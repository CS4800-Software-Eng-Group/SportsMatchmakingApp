package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {
	@Autowired
	PlayerRepo repo;	
	
	@RequestMapping("/")
	public String home(Player player)
	{
		return "playerHome.jsp";
	}
	
	@RequestMapping("/addPlayer")
	public String addPlayer(Player player)
	{
		repo.save(player);
		return "playerHome.jsp";
	}
	
	@RequestMapping("/getPlayer")
	public ModelAndView getPlayer(@RequestParam int pID)
	{
		ModelAndView mv = new ModelAndView("showPlayer.jsp");
		Player player = repo.findById(pID).orElse(new Player());
		mv.addObject(player);
		return mv;
	}
}