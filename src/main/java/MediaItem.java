
import java.net.URL;

public class MediaItem {
	public URL url = null;
	public String title = "";
	public int objectID = 0;

	public MediaItem(int ID, String t, URL link) {
		url = link;
		title = t;
		objectID = ID;
	}

	@Override
	public String toString() {
		return objectID + ": " + title;
	}
}
