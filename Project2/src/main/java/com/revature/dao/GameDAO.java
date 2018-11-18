package com.revature.dao;

import java.util.List;

import com.revature.model.Game;

public interface GameDAO {
Game getGameByName(String name);
List<Game> getGamesByCompany(String company);
List<Game>getGamesByPlatform(String platform);
List<Game>getGamesByYear(int year);
List<Game>getGameByGenre(String genre);

}
