package domainModel;

public class Album {
	
	// Private Fields
	private Restriction access;
	public Restriction getAccess() { return access; }
	public void setAccess(Restriction newAccessLevel) {
		if (Settings.getInstance().getCurrentUser().isAdmin()) { access = newAccessLevel; }
	}
	
	// Public Fields
	public String title;
	public String artist;
	public int ID;
	
	// Constructors
	public Album(Restriction access, String title, String artist, int ID) {
		super();
		this.access = access;
		this.title = title;
		this.artist = artist;
		this.ID = ID;
	}
	
	public Album(String title, String artist, int ID) {
		super();
		this.access = Restriction.Unrestricted;
		this.title = title;
		this.artist = artist;
		this.ID = ID;
	}

	// Auto Generated Methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((access == null) ? 0 : access.hashCode());
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Album other = (Album) obj;
		if (ID != other.ID)
			return false;
		if (access != other.access)
			return false;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
