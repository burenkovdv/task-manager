package org.burenkov.task_manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/api/hello")
    public String hello(@RequestParam(defaultValue = "World!") String name) {
        return "Hello, " + name;
    }
}
