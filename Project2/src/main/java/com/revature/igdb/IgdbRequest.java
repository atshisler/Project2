package com.revature.igdb;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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
		Parameters params = new Parameters().addSearch(title).addFields("name,first_release_date")
				.addExpand("genres,developers,platforms").addLimit("5");

		wrapper.games(params, new OnSuccessCallback() {
			public void onSuccess(JSONArray result) {
				// JSONArray containing 2 titles
				System.out.println("Success!");
				gameInfo = result;
				for (int i = 0; i < result.length(); i++)
					System.out.println(result.get(i).toString());
				createGame(gameInfo);
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
		List<Game> newGames = new ArrayList<Game>();
		for (int i = 0; i < result.length(); i++) {
			Game newGame = new Game();
			if(result.getJSONObject(i).has("name"))
				newGame.setTitle(result.getJSONObject(i).getString("name"));
			newGame.setCompany(getName(result.getJSONObject(i), "developers"));
			newGame.setPlatform(getName(result.getJSONObject(i), "platforms"));
			newGame.setGenre(getName(result.getJSONObject(i), "genres"));
			if (result.getJSONObject(i).has("first_release_date")) {
				Date date= new Date ((Long)result.getJSONObject(i).get("first_release_date"));
				newGame.setReleaseDate(date);
			}
			newGames.add(newGame);
			System.out.println(newGame.toString());

		} // result array
		for(int x = 0; x < newGames.size(); x++)
			System.out.println(newGames.get(x));
	}// createGame

	//returns name value of a given key
	private String getName(JSONObject result, String data) {
		if (result.has(data)) {
			JSONArray array = (JSONArray) result.get(data);
			for (int x = 0; x < array.length(); x++) {
				return array.getJSONObject(x).getString("name");
			} // developer array
		} // getDeveloper name if it has one
		else
			System.out.println("N/A");
		return "N/A";
	}

	// ---------------Helper Methods End---------------------//

}
