package domainModel;

import java.util.HashMap;
import java.util.Map;

public class AuthenticateUserController {
	private Settings settings;
	private Map<Integer, User> list;
	public AuthenticateUserController()
	{
		settings = Settings.getInstance();
	}
	
	public Map<Integer, User> getUsers() {
		
		list = new HashMap<Integer, User>();
		int i = 0;
		for(User user : Settings.users)
		{
			list.put(i, user);
		}
		
		return list;
	}

	public boolean checkPassword(int i, char[] entered) {
		
				
		int pw = Integer.parseInt(new String(entered));
		
		return (list.get(i).getPIN() == pw);
			
	}

	public void setCurrUser(int select) {
		settings.setCurrentUser(list.get(select));
		
	}

	

}
