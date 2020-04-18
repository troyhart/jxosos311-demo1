package com.example.jxosos311demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Say hello to the last person who has stated their name.
 */
@RestController
@RequestMapping("/")
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    
    private String name;

    @PutMapping("/names/{name}")
    public void stateYourName(@PathVariable String name) {
        Assert.hasText(name, "null/blank name");
        LOGGER.info("Setting name to " + name);
        this.name = name;
    }

    @GetMapping
    public String hello() {
        String greeting = "Hello " + (name == null ? "kind sir!" : name);
        LOGGER.info("Sending greeting: " + greeting);
        return greeting.toUpperCase();
    }
}