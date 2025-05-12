package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class TestController {
    @GetMapping("/hello")
    ResponseEntity<String> getHelloWorld() {
        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/echo")
    ResponseEntity<String> getRequestParams(@RequestParam String text) {
        return new ResponseEntity<>(text, HttpStatus.OK);
    }

}
