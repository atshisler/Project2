package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("/user")
public class UserController {

	private UserDAO ud = new UserDAOImpl();
	private GameDAO gd = new GameDAOImpl();

//-----------------------------Variables--------------------------------------//

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GameUser login(@RequestParam("email") String user, @RequestParam("password") String pass) {
		return ud.login(user, pass);
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
}