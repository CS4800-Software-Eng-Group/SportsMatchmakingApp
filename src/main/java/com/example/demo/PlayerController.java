package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("player")
@Controller
public class PlayerController {
	private static int ID=100;
	private static JsonParser jsonParser = JsonParserFactory.getJsonParser();
	
	@Autowired
	PlayerRepository repo;
		
	@RequestMapping("/addPlayer")
	public String addPlayer(@RequestParam String fName, @RequestParam String lName, @RequestParam String username, @RequestParam String password, 
			@RequestParam String address, @RequestParam String city, @RequestParam String zipcode, @RequestParam String state)
	{
		Player player = new Player(username, fName, lName, "", "", password, address, city, state, zipcode);
		System.out.println("Creating player with username " + username + " and password " + password);
		repo.save(player);
		return "login";
	}
	
	@RequestMapping("/getPlayer")
	public ModelAndView getPlayer(@RequestParam String username, @RequestParam String password)
	{
		ModelAndView mv = new ModelAndView("profile");
		Player player = repo.findByUsernameAndPassword(username, password);
		System.out.println("Searching for user with Username: " + username + " and Password: " + password);
		System.out.println("Player is null: " + (player == null));
		if(player != null)
		{
			mv.addObject("player", player);
			int count= (int) repo.count();
			mv.addObject("count", count);
		}
		return mv;
	}
	
	@RequestMapping("/map")
	public ModelAndView getMap(@RequestParam String username, @RequestParam String password)
	{
		ModelAndView mv = new ModelAndView("map");
		Player 	player = repo.findByUsernameAndPassword(username, password);
		if(player != null)
		{
			mv.addObject("player", player);
		}
		System.out.println("Returning map");
		return mv;
	}
	
	@PutMapping("/updateBio")
	public @ResponseBody ResponseEntity<String> updatePlayerBio(@RequestBody String body)
	{
		Map<String, Object> params = jsonParser.parseMap(body);
		String username = (String) params.get("username");
		String password = (String) params.get("password");
		String bio = (String) params.get("bio");
		Player player = repo.findByUsernameAndPassword(username, password);
		if(player != null)
		{
			player.setBio(bio);
			repo.save(player);
		}
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getPlayers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Player> getPlayers()
	{
		List<Player> players = new ArrayList<Player>();
		Iterable<Player> iterable = repo.findAll();
	    iterable.forEach(players::add);
	    return players;
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
		List<Player> playersNearby=repo.findBySport(player.getSport());
		status.setComplete();
		return mv;
	}
}