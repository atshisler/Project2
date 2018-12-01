package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.model.Game;
import com.revature.model.Genre;
import com.revature.model.Platform;
import com.revature.util.HibernateUtil;

public class GenreDAOImpl implements GenreDAO {

	@Override
	public int addGenre(Genre genre) {
		// TODO Auto-generated method stub

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int genrePk = (Integer) s.save(genre);
		tx.commit();
		s.close();
		return genrePk;
	}
	@Override
	public void updateGenre(Genre genre) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		genre = getGenre(genre.getName());
		s.merge(genre);
		tx.commit();
		s.close();
	}

	@Override
	public Genre getGenre(String name) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GENRE WHERE NAME = ?";
		Query<Genre> q = s.createNativeQuery(sql, Genre.class);
		q.setParameter(1, name);
		Genre genre = q.uniqueResult();
		return genre;
	}

	@Override
	public boolean genreExists(Genre genre) {
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GENRE WHERE NAME = ?";
		Query<Genre> q = s.createNativeQuery(sql, Genre.class);
		q.setParameter(1, genre.getName());
		return (q.uniqueResult() != null);
	}
	
	public ArrayList<Game> getGameByGenre(String name){
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM GENRE WHERE NAME = ?";
		Query<Genre> q = s.createNativeQuery(sql, Genre.class);
		q.setParameter(1, name);
		Genre genre= q.uniqueResult();
		System.out.println(genre);
		sql = "SELECT GAME_GENRE.GAME_ID from GAME_GENRE WHERE GENRE_ID = ?";
		Query<Integer> qInt = s.createNativeQuery(sql, Integer.class);
		qInt.setParameter(1, genre.getId());
		List<Integer> gIdList = qInt.list();
		System.out.println(gIdList);
		ArrayList<Game> games = new ArrayList<Game>();
		for(int i = 0; i < gIdList.size(); i++)
		{
			sql = "SELECT *from GAME WHERE GAME_ID = ?";
			Query<Game> game = s.createNativeQuery(sql, Game.class);
			game.setParameter(1, gIdList.get(i));
			System.out.println(game.uniqueResult());
			games.add(game.uniqueResult());
		}
		
		return games;
	}
}
