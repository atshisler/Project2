package com.revature.controllers;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.GameDAO;
import com.revature.dao.GameDAOImpl;
import com.revature.model.Game;

@Controller
@RequestMapping("/game")
public class GameController {
	private GameDAO gd = new GameDAOImpl();
	
	@GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getGameByName(@PathVariable("name") String name) {
		
		Game game = gd.getGameByName(name);
		System.out.println(game);
		try {
			return new ObjectMapper().writeValueAsString(game);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error Parsing Data");
		}
	}
	
	@GetMapping(value = "search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getGamesByName(@PathVariable("name") String name) {
			
		List<Game> games = gd.searchGameByName(name);
		System.out.println(games);
		try {
			return new ObjectMapper().writeValueAsString(games);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error Parsing Data");
		}
	}
	
}
