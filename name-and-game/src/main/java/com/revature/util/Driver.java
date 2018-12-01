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
		//System.out.println("Test: " + ud.getUser("GMan"));

		
		
		//igd.getGameByTitle("Zelda");
		//System.out.println(gd.getGameByName("Zelda no Densetsu: The Hyrule Fantasy"));
		//igd.getGameByTitle("Halo");
		//igd.getGameByTitle("Zelda");
		//System.out.println(gd.getGameByGenre());
		//System.out.println(gd.getGameByGenre("Shooter"));
		//System.out.println(gd.searchGameByName("zelda"));
		 //igd.getGameByTitle("Dark Souls");
		System.out.println(gnDAO.getGameByGenre("Adventure"));
		//System.out.println(pDAO.getGameByPlatform("Playstation 4"));
	}

}
