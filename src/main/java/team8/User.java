package team8;

import java.util.Set;

public class User {
	
	// Private Fields
	private String username;
	public String getUsername() { return username; }
	private int PIN;
	public int getPIN() { return PIN; } 
	private boolean admin;
	public boolean isAdmin() { return admin; }
	private Restriction access;
	public Restriction getAccess() { return access; }
	public void setAccess(Restriction newAccessLevel) {
		if (Settings.getInstance().getCurrentUser().isAdmin()) { access = newAccessLevel; }
	}
	
	// Public Fields
	public String imageFileName;
	public Set<Album> favorites;
	
	// Constructors
	public User(String username, int PIN, boolean admin, Restriction access, String imageFileName,
			Set<Album> favorites) {
		super();
		this.username = username;
		this.PIN = PIN;
		this.admin = admin;
		this.access = access;
		this.imageFileName = imageFileName;
		this.favorites = favorites;
	}
	
	public User(String username, int PIN, boolean admin, Restriction access) {
		super();
		this.username = username;
		this.PIN = PIN;
		this.admin = admin;
		this.access = access;
	}
	
	public User(String username, int PIN) {
		super();
		this.username = username;
		this.PIN = PIN;
		this.admin = true;
		this.access = Restriction.Unrestricted;
	}
	
	// Auto Generated Methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + PIN;
		result = prime * result + ((access == null) ? 0 : access.hashCode());
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((favorites == null) ? 0 : favorites.hashCode());
		result = prime * result + ((imageFileName == null) ? 0 : imageFileName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (PIN != other.PIN)
			return false;
		if (access != other.access)
			return false;
		if (admin != other.admin)
			return false;
		if (favorites == null) {
			if (other.favorites != null)
				return false;
		} else if (!favorites.equals(other.favorites))
			return false;
		if (imageFileName == null) {
			if (other.imageFileName != null)
				return false;
		} else if (!imageFileName.equals(other.imageFileName))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
