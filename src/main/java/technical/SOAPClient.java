package technical;


import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import domainModel.MediaItem;

public class SOAPClient 
{
	private static SOAPClient instance = null;
	private static String SOAP = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>"
			+ "<s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\""
			+ "	xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\">" + "	<s:Body>"
			+ "		<u:Browse xmlns:u=\"urn:schemas-upnp-org:service:ContentDirectory:1\">"
			+ "			<ObjectID>{OBJECT_ID}</ObjectID>" + "			<BrowseFlag>BrowseDirectChildren</BrowseFlag>"
			+ "			<Filter></Filter>" + "			<StartingIndex>0</StartingIndex>"
			+ "			<RequestedCount>999</RequestedCount>" + "			<SortCriteria></SortCriteria>"
			+ "		</u:Browse>" + "	</s:Body>" + "</s:Envelope>";

	public static SOAPClient getInstance(URL server) 
	{
		if (instance != null) 
		{
			if (!server.toString().equalsIgnoreCase(instance.serverURL.toString())) 
			{
				instance.serverURL = server;
			}
			return instance;
		} else 
		{
			return new SOAPClient(server);
		}
	}

	private URL serverURL;
	private ArrayList<MediaItem> items;

	private SOAPClient(URL server) 
	{
		serverURL = server;
		items = new ArrayList<MediaItem>();
	}

	public void serverURLDidChange(URL url) 
	{
		serverURL = url;
	}

	private static Document loadXMLFromString(String xml) throws Exception 
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return builder.parse(is);
	}

	/*Send an obj ID to SOAP and it returns the ArrayList of Media Items under that ID*/
	public ArrayList<MediaItem> request(int ID) throws IOException 
	{
		String id = Integer.toString(ID);
		System.err.println("Sending request for container ID: " + id);
		String soapMsg = SOAP.replace("{OBJECT_ID}", id);
		okhttp3.MediaType XML = okhttp3.MediaType.parse("text/xml; charset=utf-8");
		RequestBody body = RequestBody.create(XML, soapMsg);
		Request request = new Request.Builder().url(serverURL.toString())
				.header("Soapaction", "\"urn:schemas-upnp-org:service:ContentDirectory:1#Browse\"").post(body).build();
		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		
		if (response.code() == 200) 
		{
			String resultStr = response.body().string();
			processResults(resultStr);
		} else 
		{
			System.err.println("Response code: " + response.code());
			System.err.println("Response: " + response.message());
		}
		
		return items;
	}

	public void processResults(String soapResponse) 
	{
		soapResponse = soapResponse.replace("&lt;", "<").replace("&gt;", ">");
		items.clear();
		
		final String START_TAG = "<Result>";
		final String END_TAG = "</Result>";
		int startIndex = soapResponse.indexOf(START_TAG) + START_TAG.length();
		int endIndex = soapResponse.indexOf(END_TAG);

		String resultStr = soapResponse.substring(startIndex, endIndex);
		resultStr = resultStr.replace("&lt;", "<").replace("&gt;", ">");

		try {
			Document doc = loadXMLFromString(resultStr);
			NodeList nodes = doc.getDocumentElement().getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				org.w3c.dom.Node node = nodes.item(i);
				if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String ID = node.getAttributes().getNamedItem("id").getNodeValue();
					System.out.println(ID);
					int id = -1;
					try {
						id = Integer.parseInt(ID);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					String title = element.getElementsByTagName("dc:title").item(0).getChildNodes().item(0)
							.getNodeValue();
					System.out.println(title);
					URL link = null;
					if (node.getNodeName().equalsIgnoreCase("item")) {
						String urlString = element.getElementsByTagName("res").item(0).getChildNodes().item(0)
								.getNodeValue();
						System.out.println(urlString);
						try {
							link = new URL(urlString);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						}
					}
					
					MediaItem item = new MediaItem(id, title, link);
					items.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
