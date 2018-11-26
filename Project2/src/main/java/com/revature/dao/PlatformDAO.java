package com.revature.dao;

import com.revature.model.Platform;

public interface PlatformDAO {
	public Platform getPlatform(String name);
	public int addPlatform(Platform platform);
}
