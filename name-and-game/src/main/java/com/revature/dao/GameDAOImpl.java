package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.revature.model.Game;

import com.revature.util.HibernateUtil;

public class GameDAOImpl implements GameDAO {

	public Game getGameByName(String name) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GAME WHERE GAME_ID = ?";
		Query<Game> q = s.createNativeQuery(sql, Game.class);
		q.setParameter(1, name);
		Game game = q.getSingleResult();
		return game;
	}
	
	public Game getGameById(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GAME WHERE TITLE = ?";
		Query<Game> q = s.createNativeQuery(sql, Game.class);
		q.setParameter(1, id);
		Game game = q.getSingleResult();
		return game;
	}
	public List<Game> searchGameByName(String name){
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GAME WHERE UPPER(TITLE) LIKE UPPER(?)";
		Query<Game> q = s.createNativeQuery(sql, Game.class);
		q.setParameter(1, "%" + name + "%");
		return q.list();
		
	}

	public List<Game> getGamesByCompany(String company) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GAME WHERE UPPER(COMPANY) LIKE UPPER(?)";
		Query<Game> q = s.createNativeQuery(sql, Game.class);
		q.setParameter(1, "%" + company + "%");
		return q.list();
	}

	public List<Game> getGamesByPlatform(String platform) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GAME WHERE PLATFORM = ?";
		Query<Game> q = s.createNativeQuery(sql, Game.class);
		q.setParameter(1, platform);
		return q.list();
		
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

	@Override
	public int addGame(Game game) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int gamePk = (Integer) s.save(game); 
		tx.commit();
		s.close();
		return gamePk;
	}


}
