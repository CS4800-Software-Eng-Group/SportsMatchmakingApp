package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("player")
@Controller
public class PlayerController {
	private static int ID=100;
	
	@Autowired
	PlayerRepository repo;
	
	@RequestMapping("/addPlayer")
	public String addPlayer(@RequestParam String fName, @RequestParam String username, String password)
	{
		Player player = new Player();
		player.setUsername(username);
		player.setfName(fName);
		player.setPassword(password);
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
		mv.addObject("player", player);
		int count=(int)repo.count();
		mv.addObject("count", count);		
		return mv;
	}
	
	@GetMapping("/getSport")
	public ModelAndView getSport(@ModelAttribute("player") Player player)
	{
		ModelAndView mv = new ModelAndView("home");
		repo.save(player);
		return mv;
	}
	
	@GetMapping("/getZip")
	public ModelAndView getZip(@ModelAttribute("player") Player player, SessionStatus status)
	{
		ModelAndView mv = new ModelAndView("home");
		repo.save(player);
		//List<Player> playersNearby=repo.findBySport(player.getSport());
		int count=(int)repo.count();
		mv.addObject("count", count);
		/*
		long basketballcount=repo.countByZipCodeAndSport(player.getZipCode(),"basketball");
		long soccercount=repo.countByZipCodeAndSport(player.getZipCode(),"soccer");
		long baseballcount=repo.countByZipCodeAndSport(player.getZipCode(),"baseball");
		long footballcount=repo.countByZipCodeAndSport(player.getZipCode(),"football");
		long tenniscount=repo.countByZipCodeAndSport(player.getZipCode(),"tennis");
		*/
		mv.addObject("basketballcount", repo.countByZipCodeAndSport(player.getZipCode(),"basketball"));
		mv.addObject("soccercount", repo.countByZipCodeAndSport(player.getZipCode(), "soccer"));
		mv.addObject("baseballcount", repo.countByZipCodeAndSport(player.getZipCode(), "baseball"));
		mv.addObject("footballcount", repo.countByZipCodeAndSport(player.getZipCode(), "football"));
		mv.addObject("tenniscount", repo.countByZipCodeAndSport(player.getZipCode(), "tennis"));
		
		status.setComplete();
		return mv;
	}
	
	
}