package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.model.Game;
import com.revature.model.Platform;
import com.revature.util.HibernateUtil;

public class PlatformDAOImpl implements PlatformDAO {

	@Override
	public Platform getPlatform(String name) {
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM PLATFORM WHERE NAME = ?";
		Query<Platform> q = s.createNativeQuery(sql, Platform.class);
		q.setParameter(1, name);
		Platform platform = q.uniqueResult();
		return platform;
	}

	public ArrayList<Game> getGameByPlatform(String name){
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM PLATFORM WHERE NAME = ?";
		Query<Platform> q = s.createNativeQuery(sql, Platform.class);
		q.setParameter(1, name);
		Platform platform = q.uniqueResult();
		System.out.println(platform);
		sql = "SELECT GAME_ID from GAME_PLATFORM WHERE PLATFORM_ID = ?";
		Query<Integer> qInt = s.createNativeQuery(sql, Integer.class);
		List<Integer> gIdList = qInt.list();
		System.out.println(gIdList);
		ArrayList<Game> games = new ArrayList<Game>();
		for(int i = 0; i < gIdList.size(); i++)
		{
			sql = "SELECT *from GAME WHERE GAME_ID = ?";
			Query<Game> game = s.createNativeQuery(sql, Game.class);
			System.out.println(game.uniqueResult());
			games.add(game.uniqueResult());
		}
		
		return games;
	}
	@Override
	public int addPlatform(Platform platform) {

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int platformPk = (Integer) s.save(platform);
		tx.commit();
		s.close();
		return platformPk;

	}
	
	@Override
	public void updatePlatform(Platform platform) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.merge(platform);
		tx.commit();
		s.close();
	}

	public boolean platformExists(Platform platform) {
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM PLATFORM WHERE NAME = ?";
		Query<Platform> q = s.createNativeQuery(sql, Platform.class);
		q.setParameter(1, platform.getName());
		return (q.uniqueResult() != null);
	}

}
