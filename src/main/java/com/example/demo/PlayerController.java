package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
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
	PlayerRepository playerRepo;
		
	@Autowired
	FriendshipRepository friendshipRepo;
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {

	}
	
	@RequestMapping("/addPlayer")
	public String addPlayer(@RequestParam String fName, @RequestParam String lName,
			@RequestParam String username,
			@RequestParam String password, 
			@RequestParam String address, @RequestParam String city, @RequestParam String zipcode, @RequestParam String state)
	{
		if(!playerRepo.existsById(username))
		{
			Player player = new Player(username, fName, lName, "", "", password, address, city, state, zipcode);
			System.out.println("Creating player with username " + username + " and password " + password);
			playerRepo.save(player);
		}
		else
		{
			// TODO: Throw error if username already exists
		}
		
		return "login";
	}
	
	@RequestMapping("/getPlayer")
	public ModelAndView getPlayer(@CookieValue(value = "username", defaultValue = "") String username,
			@CookieValue(value = "password", defaultValue = "") String password)
	{
		ModelAndView mv = new ModelAndView("profile");
		Player player = playerRepo.findByUsernameAndPassword(username, password);
		System.out.println("Searching for user with Username: " + username + " and Password: " + password);
		System.out.println("Player is null: " + (player == null));
		if(player != null)
		{
			mv.addObject("player", player);
			int count= (int) playerRepo.count();
			mv.addObject("count", count);
		}
		return mv;
	}
	
	@RequestMapping("/map")
	public ModelAndView getMap(@CookieValue(value = "username", defaultValue = "") String username,
			@CookieValue(value = "password", defaultValue = "") String password)
	{
		ModelAndView mv = new ModelAndView("map");
		Player 	player = playerRepo.findByUsernameAndPassword(username, password);
		if(player != null)
		{
			mv.addObject("player", player);
		}
		System.out.println("Returning map");
		return mv;
	}
	
	@RequestMapping(value = "/checkFriendshipByUsernames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Boolean checkFriendshipByUsernames(@RequestParam String firstUser, @RequestParam String secondUser)
	{
		Player user1 = playerRepo.findByUsername(firstUser);
		Player user2 = playerRepo.findByUsername(secondUser);
		
		if(user1 != null && user2 != null)
		{
			return friendshipRepo.findFriendshipWithIdPair(user1.getUsername(), user2.getUsername()) != null;
		}
		
		return false;
	}
	
	@RequestMapping(value = "/getUserFriends", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Friendship> getUserFriends(@RequestParam String username)
	{
		Player user = playerRepo.findByUsername(username);
		
		if(user != null)
		{
			return friendshipRepo.findFriendshipById(user.getUsername());
		}
		
		return new ArrayList<Friendship>();
	}
	
	@PutMapping("/updateBio")
	public @ResponseBody ResponseEntity<String> updatePlayerBio(@RequestBody String body, @CookieValue(value = "username", defaultValue = "") String username,
			@CookieValue(value = "password", defaultValue = "") String password)
	{
		Map<String, Object> params = jsonParser.parseMap(body);
		// String username = (String) params.get("username");
		// String password = (String) params.get("password");
		String bio = (String) params.get("bio");
		Player player = playerRepo.findByUsernameAndPassword(username, password);
		if(player != null)
		{
			player.setBio(bio);
			playerRepo.save(player);
		}
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@PutMapping("/addFriend")
	public @ResponseBody ResponseEntity<String> addFriend(@RequestBody String body, @CookieValue(value = "username", defaultValue = "") String username,
			@CookieValue(value = "password", defaultValue = "") String password)
	{
		Map<String, Object> params = jsonParser.parseMap(body);
		Player player = playerRepo.findByUsernameAndPassword(username, password);
		Player otherUser = playerRepo.findByUsername((String) params.get("otherUser"));
		if(player != null && otherUser != null)
		{
			if(player.getUsername().equals(otherUser.getUsername()))
				return new ResponseEntity<String>("Users cannot friend themselves.", HttpStatus.BAD_REQUEST); 
			
			for(Friendship friendship : friendshipRepo.findFriendshipById(player.getUsername()))
			{
				if(friendship.getUserId1().equals(otherUser.getUsername()) || friendship.getUserId2().equals(otherUser.getUsername()))
				{
					return new ResponseEntity<String>("Users are already friends.", HttpStatus.BAD_REQUEST); 
				}
			}
			
			friendshipRepo.save(new Friendship(player.getUsername(), otherUser.getUsername()));
		}
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@PutMapping("/removeFriend")
	public @ResponseBody ResponseEntity<String> removeFriend(@RequestBody String body, @CookieValue(value = "username", defaultValue = "") String username,
			@CookieValue(value = "password", defaultValue = "") String password)
	{
		System.out.println("Remove friend body: " + body);
		Map<String, Object> params = jsonParser.parseMap(body);
		Player player = playerRepo.findByUsernameAndPassword(username, password);
		Player otherUser = playerRepo.findByUsername((String) params.get("otherUser"));
		if(player != null && otherUser != null)
		{
			if(player.getUsername().equals(otherUser.getUsername()))
				return new ResponseEntity<String>("Users cannot unfriend themselves.", HttpStatus.BAD_REQUEST); 
			
			System.out.println("Attempting to unfriend " + player.getUsername() + " and " + otherUser.getUsername());
			Friendship friendship = friendshipRepo.findFriendshipWithIdPair(player.getUsername(), otherUser.getUsername());
			if(friendship != null)
			{
				friendshipRepo.deleteById(friendship.getFriendshipId());
			}
			else
				return new ResponseEntity<String>("Users are not friends so they cannot be unfriended.", HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getPlayers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Player> getPlayers()
	{
		List<Player> players = new ArrayList<Player>();
		Iterable<Player> iterable = playerRepo.findAll();
	    iterable.forEach(players::add);
	    return players;
	}
	
	@GetMapping("/getSport")
	public ModelAndView getSport(@ModelAttribute("player") Player player)
	{
		ModelAndView mv = new ModelAndView("home");
		playerRepo.save(player);
		return mv;
	}
	
	@GetMapping("/getZip")
	public ModelAndView getZip(@ModelAttribute("player") Player player, SessionStatus status)
	{
		ModelAndView mv = new ModelAndView("home");
		playerRepo.save(player);
		List<Player> playersNearby=playerRepo.findBySport(player.getSport());
		status.setComplete();
		return mv;
	}
}