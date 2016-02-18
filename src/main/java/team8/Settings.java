package team8;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Settings {

	// Singleton
	private static Settings instance;
	public static Settings getInstance() {
		if (instance == null) instance = new Settings();
		return instance;
	}
	private Settings() {
		// Load class from Settings.xml
		load();
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
	
	// Methods
	public void load() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File("Settings.xml");
			Document doc = builder.parse(file);

			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			Node urlNode = root.getElementsByTagName("serverURL").item(0);
			String urlString = urlNode.getTextContent();
			serverURL = new URL(urlString);
			
			Node currentUserNode = root.getElementsByTagName("currentUser").item(0);
			Element currentUserElement = (Element) currentUserNode;
			currentUser = parseUser(currentUserElement);
			
			this.albums = new HashMap<Restriction, Set<Album>>();
			Set<Album> restrictedAlbums = new HashSet<Album>();
			Set<Album> unrestrictedAlbums = new HashSet<Album>();
			Node albumsNode = root.getElementsByTagName("albums").item(0);
			Element albumsElement = (Element) albumsNode;
			NodeList albumsList = albumsElement.getElementsByTagName("album");
			for (int temp = 0; temp < albumsList.getLength(); temp++) {
				Node albumNode = albumsList.item(temp);
				Element albumElement = (Element) albumNode;
				Album album = parseAlbum(albumElement);
				if (album.getAccess().compareTo(Restriction.Restricted) == 0) {
					restrictedAlbums.add(album);
				} else {
					unrestrictedAlbums.add(album);
				}
			}
			albums.put(Restriction.Restricted, restrictedAlbums);
			albums.put(Restriction.Unrestricted, unrestrictedAlbums);
			
			users = new HashSet<User>();
			Node usersNode = root.getElementsByTagName("users").item(0);
			Element usersElement = (Element) usersNode;
			NodeList usersList = usersElement.getElementsByTagName("user");
			for (int index = 0; index < usersList.getLength(); index++) {
				Node userNode = usersList.item(index);
				User user = parseUser((Element) userNode);
				users.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to construct Settings");
		}
	}
	
	private User parseUser(Element userElement) {
		boolean admin = userElement.getElementsByTagName("admin").item(0).getTextContent().equalsIgnoreCase("true");
		int PIN = Integer.parseInt(userElement.getElementsByTagName("PIN").item(0).getTextContent());
		String name = userElement.getElementsByTagName("username").item(0).getTextContent();
		String restriction = userElement.getElementsByTagName("access").item(0).getTextContent();
		Restriction access = Restriction.valueOf(restriction);
		String imageFileName = userElement.getElementsByTagName("imageFileName").item(0).getTextContent();
		Element favoritesElement = (Element) userElement.getElementsByTagName("favorites").item(0);
		NodeList favoritesList = favoritesElement.getElementsByTagName("album");
		Set<Album> favorites = new HashSet<Album>();
		for (int temp = 0; temp < favoritesList.getLength(); temp++) {
			Node albumNode = favoritesList.item(temp);
			Element albumElement = (Element) albumNode;
			favorites.add(parseAlbum(albumElement));
		}
		if (favorites.isEmpty()) favorites = null;
		if (imageFileName.isEmpty()) imageFileName = null;
		
		return new User(name, PIN, admin, access, imageFileName, favorites);
	}
	
	private Album parseAlbum(Element albumElement) {
		String restriction = albumElement.getAttribute("access");
		Restriction access = Restriction.valueOf(restriction);
		String title = albumElement.getElementsByTagName("title").item(0).getTextContent();
		String artist = albumElement.getElementsByTagName("artist").item(0).getTextContent();
		int ID = Integer.parseInt(albumElement.getElementsByTagName("ID").item(0).getTextContent());
		
		return new Album(access, title, artist, ID);
	}
}
