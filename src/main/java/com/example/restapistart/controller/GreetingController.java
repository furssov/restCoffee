package com.example.restapistart.controller;

import com.example.restapistart.property.SomeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private SomeInfo someInfo;
    @Value("${greeting-name:Diamond}")
    private String name;

    @Value("${greeting-coffee}")
    private String coffeeGreeting;

    @GetMapping
    public String getGreeting()
    {
        return name;
    }

    @GetMapping("/coffee")
    public String getCoffeeGreeting()
    {
        return coffeeGreeting + "\n" + someInfo.getInfo();
    }
}
