package com.example.jxosos311demo1;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    private String name;

    @PutMapping("/name/{name}")
    public void stateYourName(@PathVariable String name) {
        Assert.hasText(name, "null/blank name");
        this.name = name;
    }

    @GetMapping
    public String hello() {
        return "Well, howdy " + name == null ? "kind sir!" : name;
    }
}