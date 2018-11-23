import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.igdb.IgdbRequest;
import com.revature.model.Game;

public class Driver {

	public static void main(String[] args) {
		UserDAO ud = new UserDAOImpl();
		IgdbRequest igd = new IgdbRequest();
		List<Game> gameList;
		//ud.createUser(new GameUser("G-Man", "halflife3@gmail.com", "Freeman", "user"));
		//System.out.println("Test: " + ud.getUser("G-Man"));
		
		//System.out.println(igd.getGameByTitle("Zelda"));
		
		//for(int i = 0; i < gameList.size(); i++)
		//	System.out.println("Games: " + gameList.get(i));
		
	}
	

}
