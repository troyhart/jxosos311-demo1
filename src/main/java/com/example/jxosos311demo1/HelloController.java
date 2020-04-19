package com.example.jxosos311demo1;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Say hello to the last person who has stated their name.
 */
@RestController
@RequestMapping("/")
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    private String name;
    private LinkedList<String> history = new LinkedList<>();

    @PutMapping("/names/{name}")
    public void stateYourName(@PathVariable String name) {
        Assert.hasText(name, "null/blank name");
        name = name.trim();
        LOGGER.info("Setting name to " + name);
        if (this.name != null) {
            history.addFirst(this.name);
        }
        this.name = name;
    }

    @GetMapping
    public String hello() {
        String greeting = "Hello " + (name == null ? "kind sir!" : name);
        LOGGER.info("Sending greeting: " + greeting);
        return greeting.toUpperCase();
    }

    /**
     * 
     * @return the last stated name
     */
    @GetMapping("/name")
    public String name() {
        return name;
    }

    /**
     * @param count optional count for the maximum number of names to return.
     * @return the history of stated names. All names by default, but when provided, count will limit the results the the last n,
     *  where n is equal to the given count.
     */
    @GetMapping("/names")
    public List<String> history(@RequestParam(required = false, defaultValue = "0") int count) {
        if (count > 0 && count < history.size()) {
            return history.stream().limit(count).collect(Collectors.toList());
        }

        return history;
    }
}