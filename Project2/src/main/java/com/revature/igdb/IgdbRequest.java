package com.revature.igdb;

import java.util.List;

import org.json.JSONArray;

import com.revature.model.Game;

import callback.OnSuccessCallback;
import wrapper.Endpoints;
import wrapper.IGDBWrapper;
import wrapper.Parameters;
import wrapper.Version;

public class IgdbRequest {
	private String key = "c7b9a8a0deb857507ca18673690dd26b";
	private IGDBWrapper wrapper = new IGDBWrapper(key, Version.STANDARD, true);
	private JSONArray gameInfo;
	
	public Game getGameByTitle(String title) {
		gameInfo = null;
		Parameters params = new Parameters().addSearch(title).addFields("name").addExpand("genres,developers,platforms").addLimit("5");
		
		wrapper.games(params, new OnSuccessCallback() {
			public void onSuccess(JSONArray result) {
				// JSONArray containing 2 titles
				System.out.println("Success!");
				System.out.println(result.toString());
				gameInfo = result;
			}
			public void onError(Exception error) {
				System.out.println("Error");// Do something on error
			}
		});
		
		return null;
	}

	public List<Game> getGamesByName() {
		return null;
	}

	public List<Game> getGamesByCompany(String company) {
		return null;
	}

	public List<Game> getGamesByPlatform(String platform) {
		return null;

	}

	public List<Game> getGamesByYear(int year) {
		return null;

	}

	public List<Game> getGameByGenre(String genre) {
		return null;

	}

//-----------------------Helper Methods-------------------------//
	private void createGame(JSONArray result) {
		
	}

	// ---------------Helper Methods End---------------------//

}
