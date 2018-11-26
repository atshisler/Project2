import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.revature.dao.GameDAO;
import com.revature.dao.GameoDAOImpl;
import com.revature.dao.GenreDAO;
import com.revature.dao.GenreDAOImpl;
import com.revature.dao.PlatformDAO;
import com.revature.dao.PlatformDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.igdb.IgdbRequest;
import com.revature.model.Game;
import com.revature.model.Genre;
import com.revature.model.Platform;

public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		UserDAO ud = new UserDAOImpl();
		GameDAO gd = new GameoDAOImpl();
		IgdbRequest igd = new IgdbRequest();
		PlatformDAO pDAO = new PlatformDAOImpl();
		GenreDAO gnDAO = new GenreDAOImpl();
		//ud.createUser(new GameUser("GMan", "halflife4@gmail.com", "Freeman", "user"));
		System.out.println("Test: " + ud.getUser("G-Man"));
		
		Game testGame = new Game("TestMario3", "Review", "Nintendo", null);
		Platform platform = new Platform("Gamecube");
		Platform platform2 = new Platform("PS2");
		Set<Platform> platformList = new HashSet<Platform>();
		platformList.add(platform);
		platformList.add(platform2);
		pDAO.addPlatform(platform);
		pDAO.addPlatform(platform2);
		Genre genre = new Genre("Platformer");
		Genre genre2 = new Genre("RPG");
		Set<Genre> genreList = new HashSet<Genre>();
		genreList.add(genre);
		genreList.add(genre2);
		gnDAO.addGenre(genre);
		gnDAO.addGenre(genre2);
		testGame.setGenres(genreList);
		testGame.setPlatforms(platformList);
		
		gd.addGame(testGame);
		System.out.println(gd.getGameByName("TestMario3"));
		//System.out.println(gd.getGameByName("TestMario3"));
		//igd.getGameByTitle("Zelda");
		//System.out.println(gd.getGameByName("Zelda no Densetsu: The Hyrule Fantasy"));
		//igd.getGameByTitle("Dark Souls");	
		
	}
	

}
