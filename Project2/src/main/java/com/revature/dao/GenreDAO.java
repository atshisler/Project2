package com.revature.dao;

import java.util.List;

import com.revature.model.Game;
import com.revature.model.Genre;

public interface GenreDAO {
	public Genre getGenre(String name);
	public int addGenre(Genre genre);
	
}
