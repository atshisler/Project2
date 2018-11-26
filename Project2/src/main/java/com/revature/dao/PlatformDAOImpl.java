package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.model.Genre;
import com.revature.model.Platform;
import com.revature.util.HibernateUtil;

public class PlatformDAOImpl implements PlatformDAO {

	@Override
	public Platform getPlatform(String name) {
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM Platform WHERE NAME = ?";
		Query<Platform> q = s.createNativeQuery(sql, Platform.class);
		q.setParameter(1, name);
		Platform platform = q.getSingleResult();
		return platform;
	}

	@Override
	public int addPlatform(Platform platform) {
		if (!platformExists(platform)) {
			Session s = HibernateUtil.getSession();
			Transaction tx = s.beginTransaction();
			int platformPk = (Integer) s.save(platform);
			tx.commit();
			s.close();
			return platformPk;
		}
		else
			return getPlatform(platform.getName()).getId();
		
	}

	private boolean platformExists(Platform platform) {
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM Platform WHERE NAME = ?";
		Query<Platform> q = s.createNativeQuery(sql, Platform.class);
		q.setParameter(1, platform.getName());
		return (q.uniqueResult() != null);
	}

}
