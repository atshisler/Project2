import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.igdb.IgdbRequest;
import com.revature.model.Game;

public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		UserDAO ud = new UserDAOImpl();
		IgdbRequest igd = new IgdbRequest();
		Future<List<Game>> futureList;
		//ud.createUser(new GameUser("G-Man", "halflife3@gmail.com", "Freeman", "user"));
		//System.out.println("Test: " + ud.getUser("G-Man"));
		
		futureList = igd.getGameByTitle("Zelda");
		
		
		while(!futureList.isDone()) {
			System.out.println("Future");
			
		}
		if(futureList.isDone())
			System.out.println("done");
		System.out.println(futureList.get());
		List<Game> gameList = futureList.get();
		
		for(int i = 0; i < gameList.size(); i++)
			System.out.println("Games: " + gameList.get(i));
		
		
		futureList = igd.getGameByTitle("Dark Souls");	
		gameList = futureList.get();
		
		System.out.println(gameList);
				
		for(int i = 0; i < gameList.size(); i++)
			System.out.println("Games: " + gameList.get(i));
		
	}
	

}
