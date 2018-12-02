package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.model.GameUser;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserDAO ud = new UserDAOImpl();

//-----------------------------Variables--------------------------------------//

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GameUser login(@RequestParam("email") String user, @RequestParam("password") String pass) {
		return ud.login(user, pass);
	}

}