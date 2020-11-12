package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {
	private static int ID=100;
	
	@Autowired
	PlayerRepository repo;
	
	@RequestMapping("/addPlayer")
	public String addPlayer(Player player)
	{
		player.setLogin();
		player.setpID(++ID);
		repo.save(player);
		return "login";
	}
	
	@RequestMapping("/getPlayer")
	public ModelAndView getPlayer(@RequestParam String username, @RequestParam String password)
	{
		ModelAndView mv = new ModelAndView("home");
		String login = username+password;
		Player player = repo.findByLogin(login);
		mv.addObject(player);
		return mv;
	}
}