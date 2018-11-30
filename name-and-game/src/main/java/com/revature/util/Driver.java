package com.revature.util;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.revature.dao.GameDAO;
import com.revature.dao.GameDAOImpl;
import com.revature.dao.GenreDAO;
import com.revature.dao.GenreDAOImpl;
import com.revature.dao.PlatformDAO;
import com.revature.dao.PlatformDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.igdb.IgdbRequest;
import com.revature.model.Game;
import com.revature.model.Genre;
import com.revature.model.Platform;

public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		UserDAO ud = new UserDAOImpl();
		GameDAO gd = new GameDAOImpl();
		IgdbRequest igd = new IgdbRequest();
		PlatformDAO pDAO = new PlatformDAOImpl();
		GenreDAO gnDAO = new GenreDAOImpl();
		// ud.createUser(new GameUser("GMan", "halflife4@gmail.com", "Freeman",
		// "user"));
		System.out.println("Test: " + ud.getUser("GMan"));

		
		/*
		 * Game testGame = new Game("TestZelda64", "Review", "Nintendo", null);
		 * 
		 * Platform platform = new Platform("Nintendo64");//
		 * pDAO.getPlatform("Gamecube"); Platform platform2 = new Platform("Switch");//
		 * pDAO.getPlatform("PS2"); Set<Platform> platformList = new
		 * HashSet<Platform>();
		 * 
		 * if (pDAO.platformExists(platform)) { platform =
		 * pDAO.getPlatform(platform.getName()); pDAO.updatePlatform(platform); } else {
		 * pDAO.addPlatform(platform); } platformList.add(platform); if
		 * (pDAO.platformExists(platform2)) { platform2 =
		 * pDAO.getPlatform(platform2.getName()); pDAO.updatePlatform(platform2); } else
		 * pDAO.addPlatform(platform2); platformList.add(platform2);
		 * 
		 * 
		 * Genre genre = new Genre("Adventure");// gnDAO.getGenre("Platformer");
		 * 
		 * Set<Genre> genreList = new HashSet<Genre>(); if (gnDAO.genreExists(genre)) {
		 * genre = gnDAO.getGenre(genre.getName()); gnDAO.updateGenre(genre); } else
		 * gnDAO.addGenre(genre); genreList.add(genre);
		 * 
		 * testGame.setGenres(genreList); testGame.setPlatforms(platformList);
		 * gd.addGame(testGame); System.out.println(gd.getGameByName("TestZelda64"));
		 */
		//igd.getGameByTitle("Zelda");
		//System.out.println(gd.getGameByName("Zelda no Densetsu: The Hyrule Fantasy"));
		//igd.getGameByTitle("Halo");
		System.out.println(gd.searchGameByName("Halo"));
		//System.out.println(gd.getGameByGenre("Shooter"));
		//System.out.println(gd.searchGameByName("zelda"));
		// igd.getGameByTitle("Dark Souls");

	}

}