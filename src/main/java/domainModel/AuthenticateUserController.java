package domainModel;

import java.util.Map;
import java.util.TreeMap;

/**
 * This class is the MVC Controller for authenticating the user.  
 * It communicates with the LoginFrame and the Settings Class
 * @author tmcvick
 *
 */
public class AuthenticateUserController {
	private Settings settings;
	private Map<Integer, User> list;
	
	/**
	 * creates a new controller, and loads the settings from the xml file
	 */
	public AuthenticateUserController()
	{
		settings = Settings.getInstance();
	}
	
	/**
	 * populates the map of users from the xml file
	 * @return a treemap with keys as integers from 0...n and values of users stored in the settings file
	 */
	public Map<Integer, User> getUsers() {
		
		list = new TreeMap<Integer, User>();
		int i = 0;
		for(User user : Settings.users)
		{
			list.put(i++, user);
		}
		
		return list;
	}

	/**
	 * checks the entered password with the password from the file
	 * @param i the key of the user from the map
	 * @param entered the entered password
	 * @return true if the authentication was successful, false if otherwise
	 */
	public boolean checkPassword(int i, char[] entered) {
		
				
		int pw = Integer.parseInt(new String(entered));
		
		return (list.get(i).getPIN() == pw);
			
	}

	/**
	 * Sets the current user of the application to the user who logged in
	 * @param select the key from the map of the user who logged in 
	 */
	public void setCurrUser(int select) {
		settings.setCurrentUser(list.get(select));
		
	}

	

}
