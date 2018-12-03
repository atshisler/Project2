package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.GameDAO;
import com.revature.dao.GameDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.model.Game;
import com.revature.model.GameUser;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

	private UserDAO ud = new UserDAOImpl();
	private GameDAO gd = new GameDAOImpl();

//-----------------------------Variables--------------------------------------//

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GameUser login(@RequestParam("email") String email, @RequestParam("password") String pass) {
		GameUser user = ud.login(email, pass);
		if( user.getRole().equals("block")) {
			return null;
		}
		else {
			return user;

		}
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createUser(@RequestParam("email") String email, @RequestParam("favoritegame") String favoritegame, 
			@RequestParam("favoritegenre") String favoritegenre, @RequestParam("password") String pass, 
			@RequestParam("username") String username) {
		Game favGame = gd.getGameByName(favoritegame);
		GameUser user = new GameUser(username, email, pass, "user", favoritegenre, favGame);
		ud.createUser(user);
	}
	@PostMapping(value = "/allUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<GameUser> getAllUsers(@RequestParam("role") String role) {
		if(role.equals("admin")) {
			return ud.getAllUsers();
			
		}
		else {
			return null;
		}
	}
	@PostMapping(value = "/block", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateUser(@RequestParam("username") String username) {
		GameUser user = ud.getUser(username);
		user.setRole("block");
		ud.updateUser(user);
	}
	
	
}