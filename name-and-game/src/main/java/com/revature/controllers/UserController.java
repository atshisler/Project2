package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.GameUser;
import com.revature.dao.UserDAOImpl;

//@Controller
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserDAOImpl userDAOImpl;
	
	@GetMapping
//	@ResponseBody
	public List<GameUser> getAllUsers(){
		return userDAOImpl.getAllUsers();
	}
	
	@GetMapping("/{id}")
//	@ResponseBody
	public GameUser getUserbyId(@PathVariable("id") Integer id) {
		return userDAOImpl.getUserbyId(id);
	}
	
	@PostMapping
//	@ResponseBody
	public int addUser(@Valid @RequestBody GameUser u) {
		return userDAOImpl.createUser(u);
	}
	
	@PutMapping("/{id}")
//	@ResponseBody
	public void updateUser(@Valid @PathVariable("id")Integer id, @RequestBody GameUser u) {
		u.setId(id);
		userDAOImpl.updateUser(u);
	}
	
	@DeleteMapping("/{id}")
//	@ResponseBody
	public void deleteUser(@PathVariable GameUser user) {
//		GameUser user = new GameUser();
//		user.setId(id);
		userDAOImpl.deleteUser(user);
	}

//  does not follow our uniform interface
	@PostMapping("/login")
	@ResponseBody
	public GameUser login(@RequestParam("email") String user, @RequestParam("password")String pass) {
		return userDAOImpl.login(user, pass);
	}

}

