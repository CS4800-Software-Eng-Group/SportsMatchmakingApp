package com.example.demo.HelloWorld;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

@RestController
public class GuavaMethodAlexNeoh {
	
	@RequestMapping(value = "/email",method = RequestMethod.GET)
	public String email() {
		List<String> list = Lists.newArrayList("neoh", "alex@gmail", "com");
		String newString = Joiner.on(".").join(list);
		return newString;
	}
	
}
