package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.GameDAO;
import com.revature.dao.GameDAOImpl;
import com.revature.model.Game;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
	
	private GameDAO gd = new GameDAOImpl();
	@GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public String test() {
		return "{ \"test\": 1000000 }";
	}
	
	@GetMapping(value = "/game", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getGame() {
		Game game = gd.getGameByName("Zelda: The Wand of Gamelon");;
		try {
			return new ObjectMapper().writeValueAsString(game);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error Parsing Data");
		}
	}
	@PostMapping(value = "/game", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String postGame(@RequestBody Game game) {
		try {
			return new ObjectMapper().writeValueAsString(game);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error Parsing Data");
		}
	}
}
