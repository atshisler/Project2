package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


import com.revature.model.Game;

import com.revature.util.HibernateUtil;

public class GameoDAOImpl implements GameDAO {

	public Game getGameByName(String name) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GAMEUSER WHERE TITLE = ?";
		Query<Game> q = s.createNativeQuery(sql, Game.class);
		q.setParameter(1, name);
		Game game = q.getSingleResult();
		return game;
	}

	public List<Game> getGamesByCompany(String company) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GAME WHERE COMPANY = ?";
		Query<Game> q = s.createNativeQuery(sql, Game.class);
		q.setParameter(1, company);
		List<Game> games = q.list();
		return games;
	}

	public List<Game> getGamesByPlatform(String platform) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GAME WHERE PLATFORM = ?";
		Query<Game> q = s.createNativeQuery(sql, Game.class);
		q.setParameter(1, platform);
		List<Game> games = q.list();
		return games;
	}

	public List<Game> getGamesByYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Game> getGameByGenre(String genre) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GAME WHERE GENRE = ?";
		Query<Game> q = s.createNativeQuery(sql, Game.class);
		q.setParameter(1, genre);
		List<Game> games = q.list();
		return games;
	}


}
