/*package team8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;

import domainModel.Album;
import domainModel.Restriction;
import domainModel.Settings;
import domainModel.User;

public class SettingsTest {
	protected static Settings settings;
	protected static URL testURL;
	protected static User testUser;
	protected static Album testRestrictedAlbum;
	protected static Album testUnrestrictedAlbum;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		settings = Settings.getInstance();
		testURL = new URL("http://127.0.0.1:5001/upnp/control/content_directory");
		testUser = new User("Admin", 9999, true, Restriction.Unrestricted);
		testUnrestrictedAlbum = new Album(Restriction.Unrestricted, "Album A", "Dylan Pyle", 7);
		testRestrictedAlbum = new Album(Restriction.Restricted, "Album B", "Dylan Pyle", 13);
	}

	@Test
	public void testURL() {
		assertEquals(testURL, Settings.serverURL);
	}

	@Test
	public void testUser() {
		assertTrue(Settings.users.contains(testUser));
	}
	
	@Test
	public void testAlbums() {
		assertTrue(settings.getAlbums(Restriction.Restricted).contains(testRestrictedAlbum));
		assertTrue(settings.getAlbums(Restriction.Unrestricted).contains(testUnrestrictedAlbum));
	}
	
}
*/