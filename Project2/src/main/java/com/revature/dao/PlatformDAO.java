package com.revature.dao;

import com.revature.model.Platform;

public interface PlatformDAO {
	public Platform getPlatform(String name);
	public int addPlatform(Platform platform);
	public boolean platformExists(Platform platform);
	public void updatePlatform(Platform platform);
}
