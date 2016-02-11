
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Window extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField inputUrl;
	private JTextField objectNum;
	private DefaultListModel<MediaItem> listmodel;
	private JList<MediaItem> itemList;
	private SOAPClient soap;
	private JScrollPane scrollPane;
	private URL serverURL = null;
	private MediaPlayer musicPlayer;

	public URL getURL() {
		return this.serverURL;
	}

	private ArrayList<MediaItem> mediaItems;
	private JTextField songUrl;
	private URL playUrl;
	private boolean test = false;

	
	public void setItems(ArrayList<MediaItem> items) {
		if (mediaItems != null && items != null) {
			mediaItems.clear();
			for(int i = 0; i < items.size(); i++)
				mediaItems.add(items.get(i));
		}else if(items == null)
			return;
		else {
			mediaItems = new ArrayList<MediaItem>();
			for(int i = 0; i < items.size(); i++)
				mediaItems.add(items.get(i));
			
		}
	}

	public Window() {

		try {
			serverURL = new URL("http://127.0.0.1:5001/upnp/control/content_directory");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		// SOAPClient Singleton instantiation
		soap = SOAPClient.getInstance(serverURL);

		JLabel lblServerUrl = new JLabel("Server URL:");

		inputUrl = new JTextField();
		inputUrl.setText("http://127.0.0.1:5001/upnp/control/content_directory");
		inputUrl.setColumns(10);

		JLabel lblObjectId = new JLabel("Object ID:");

		objectNum = new JTextField();
		objectNum.setText("0");
		objectNum.setColumns(10);

		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					submit_change();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		});

		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				musicPlayer = new MediaPlayer(playUrl);
				musicPlayer.start();
			}
		});

		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musicPlayer.pause();
			}
		});

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musicPlayer.stop();
			}
		});

		scrollPane = new JScrollPane();

		songUrl = new JTextField();
		songUrl.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblServerUrl, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(inputUrl, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnPlay)
									.addGap(18)
									.addComponent(btnPause)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnStop))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(100)
									.addComponent(lblObjectId)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(objectNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnRetrieve))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(songUrl, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)))
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServerUrl, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputUrl, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblObjectId, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(objectNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRetrieve))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnPlay)
								.addComponent(btnPause)
								.addComponent(btnStop))
							.addGap(18)
							.addComponent(songUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
					.addContainerGap())
		);
		listmodel = new DefaultListModel<MediaItem>();
		itemList = new JList<MediaItem>(listmodel);
		itemList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(test == false)
					change_boxes();
			}
		});

		scrollPane.setViewportView(itemList);
		getContentPane().setLayout(groupLayout);
		setTitle("Media Player Application");
		pack();
	}

	public void submit_change() throws MalformedURLException {
		if (serverURL != new URL(inputUrl.getText())) {
			serverURL = new URL(inputUrl.getText());
			soap.serverURLDidChange(serverURL);
		}

		ArrayList<MediaItem> items = new ArrayList<MediaItem>();
		try {
			items = soap.request(Integer.parseInt(objectNum.getText()));
		} catch (NumberFormatException e) {
			System.out.println("here is the error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("here is the error");

			e.printStackTrace();
		}
		
		setItems(items);
		
		test = true;
		listmodel.clear();
		test = false;
		
		for (int i = 0; i < mediaItems.size(); i++)
			listmodel.addElement(mediaItems.get(i));
		scrollPane.revalidate();
		scrollPane.repaint();
	}

	public void change_boxes() {
		int index = itemList.getSelectedIndex();
		int ID = mediaItems.get(index).objectID;
		if (mediaItems.get(index).url != null) {
			songUrl.setText(mediaItems.get(index).url.toString());
			playUrl = mediaItems.get(index).url;
		}
		objectNum.setText(Integer.toString(ID));
	}

}

