package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {
	@Autowired
	PlayerRepository repo;
	
	
	@RequestMapping("/addPlayer")
	public String addPlayer(Player player)
	{
		repo.save(player);
		return "login";
	}
	
	@RequestMapping("/getPlayer")
	public ModelAndView getPlayer(@RequestParam int pID)
	{
		ModelAndView mv = new ModelAndView("home");
		Player player = repo.findById(pID).orElse(new Player());
		mv.addObject(player);
		return mv;
	}
}