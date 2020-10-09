package com.teamObject.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayerController {
	@RequestMapping("/playerHome")
	public String home()
	{
		return "playerHome.html";
	}
}
