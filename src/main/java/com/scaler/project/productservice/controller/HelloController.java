package com.scaler.project.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    String getHelloMessage(){
        //return new ResponseEntity<>("Hello World!", HttpStatus.OK);
        return "Hello There!";
    }
}
