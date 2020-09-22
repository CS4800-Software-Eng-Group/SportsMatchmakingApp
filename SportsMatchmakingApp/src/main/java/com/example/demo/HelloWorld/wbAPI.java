package com.example.demo.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class wbAPI {
	
	@RequestMapping(value="/", method= RequestMethod.GET )
	public String hello() {
		return "This is a simple API";
	}
}
