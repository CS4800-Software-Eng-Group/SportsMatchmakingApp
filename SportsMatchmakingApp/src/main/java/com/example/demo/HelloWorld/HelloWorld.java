package com.example.demo.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
@RestController
public class HelloWorld {
	
	@RequestMapping(value="/helloWorld", method= RequestMethod.GET )
	public String hello() {
		return "Hello World";
	}
}

