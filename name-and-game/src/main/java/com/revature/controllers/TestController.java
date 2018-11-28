package com.revature.controllers;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.model.Game;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
	@GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public String test() {
		return "{ \"test\": 1000000 }";
	}
	
	@GetMapping(value = "/game", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getGame() {
		Game game = new Game(1, "Generic Game", "Generic Review", "Generic Company", new Date(new java.util.Date().getTime()));
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
