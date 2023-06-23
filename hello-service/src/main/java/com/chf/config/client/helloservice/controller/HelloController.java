package com.chf.config.client.helloservice.controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/hello")
public class HelloController {

    @Value("${greeting.message}")
    public String greetingMessage;
    @GetMapping
    public String sayHello() {
        return greetingMessage;
    }
}
