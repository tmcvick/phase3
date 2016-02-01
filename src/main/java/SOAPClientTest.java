import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SOAPClientTest {
	private URL serverURL;
	private ArrayList<MediaItem> returnedItems;

	@Before
	public void setUp() throws Exception {
		serverURL = new URL("http://127.0.0.1:5001/upnp/control/content_directory");
		MediaItem item1 = new MediaItem(24, "Recently Played", null);
		MediaItem item2 = new MediaItem(25, "Music", null);
		returnedItems.add(item1);
		returnedItems.add(item2);
	}

	@Test
	public void test() {
		SOAPClient client = SOAPClient.getInstance(serverURL);
		ArrayList<MediaItem> items = new ArrayList<MediaItem>();
		try {
			items = client.request(0);
		} catch (IOException e) {
			fail("IOException");
			e.printStackTrace();
		}
		if (items.size() != returnedItems.size()) {
			fail("Returned items are not the size they should be.");
		}
		for (int i = 0; i < returnedItems.size(); i++) {
			if (items.get(i) != returnedItems.get(i)) {
				fail("Returned items are not equal to what they should be.");
			}
		}
	}
}
