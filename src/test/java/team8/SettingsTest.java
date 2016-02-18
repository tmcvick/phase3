package team8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SettingsTest {
	protected static Settings settings;
	protected URL testURL;
	protected User testUser;
	protected Album testRestrictedAlbum;
	protected Album testUnrestrictedAlbum;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		settings = Settings.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testURL = new URL("http://127.0.0.1:5001/upnp/control/content_directory");
		testUser = new User("defaultUser", 7777, true, Restriction.Unrestricted);
		testUnrestrictedAlbum = new Album(Restriction.Unrestricted, "Test", "Dylan Pyle", 7);
		testRestrictedAlbum = new Album(Restriction.Restricted, "Restricted Test", "Dylan Pyle", 13);
	}

	@Test
	public void test() {
		assertEquals(testURL, Settings.serverURL);
		assertEquals(testUser, settings.getCurrentUser());
		assertTrue(Settings.users.contains(testUser));
		assertTrue(settings.getAlbums(Restriction.Unrestricted).contains(testUnrestrictedAlbum));
		assertTrue(settings.getAlbums(Restriction.Restricted).contains(testRestrictedAlbum));
	}

}
