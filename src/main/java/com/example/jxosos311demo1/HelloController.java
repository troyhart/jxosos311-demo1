package com.example.jxosos311demo1;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Say hello to the last person to state their name.
 */
@RestController
@RequestMapping("/")
public class HelloController {
    private String name;

    @PutMapping("/names/{name}")
    public void stateYourName(@PathVariable String name) {
        Assert.hasText(name, "null/blank name");
        this.name = name;
    }

    @GetMapping
    public String hello() {
        String greeting = "Hello " + (name == null ? "kind sir!" : name);
        return greeting;
    }
}