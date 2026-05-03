package com.example.demo.controller;

import com.example.demo.engine.Composer;
import com.example.demo.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class VeraController {

    @Autowired
    Composer composer;

    @GetMapping("/healthz")
    public String health() {
        return "ok";
    }

    @PostMapping("/tick")
    public Response tick(@RequestBody Input input) {
        return composer.compose(input);
    }
}