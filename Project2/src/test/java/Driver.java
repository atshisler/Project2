import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.igdb.IgdbRequest;

public class Driver {

	public static void main(String[] args) {
		UserDAO ud = new UserDAOImpl();
		IgdbRequest igd = new IgdbRequest();
		//ud.createUser(new GameUser("G-Man", "halflife3@gmail.com", "Freeman", "user"));
		System.out.println("Test: " + ud.getUser("G-Man"));
		igd.getGameByTitle("Zelda");
	}
	

}
