package team8;

import java.net.URL;
import java.util.Map;
import java.util.Set;

public class Settings {

	// Singleton
	private static Settings instance;
	public static Settings getInstance() {
		if (instance == null) instance = new Settings();
		return instance;
	}
	public Settings() {
		//should attempt to load from file. Set default values if no file
	}

	// Private Fields
	private Map<Restriction, Set<Album>> albums;
	public Set<Album> getAlbums(Restriction access) { return albums.get(access); }
	public void addAlbum(Album newAlbum) { 
		Set<Album> currentAlbums = albums.get(newAlbum.getAccess());
		if (!currentAlbums.contains(newAlbum)) {
			currentAlbums.add(newAlbum); 
		}
	}
	private User currentUser;
	public User getCurrentUser() { return currentUser; }
	public void setCurrentUser(String username, int PIN) {
		for (User user: users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPIN() == PIN) { 
				currentUser = user; 
			}
		}
	}
	
	// Public Fields
	public static URL serverURL;
	public static Set<User> users;
	
}
