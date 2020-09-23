package com.example.demo.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIHelloWorld {
    
    @RequestMapping("/")
    public String world() {
        return "Hello beautiful World";
    }
}
