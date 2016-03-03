package gui;

import java.net.MalformedURLException;
/*Swing Imports*/
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*Package Imports*/
import technical.MediaPlayer;
import technical.SOAPClient;
import domainModel.MediaItem;
import domainModel.Settings;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class LibraryPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JToggleButton tglbtnPlay;
	private URL serverURL = null;
	private MediaPlayer musicPlayer;
	private SOAPClient soap;
	private DefaultListModel<MediaItem> listmodel;
	private JList<MediaItem> itemList;
	private ArrayList<MediaItem> mediaItems;
	private JTextField songUrl;
	private URL playUrl;
	private boolean test = false;
	private Settings settings;
	
	public LibraryPanel() 
	{
		settings = Settings.getInstance();
		
		try {
			serverURL = new URL("http://127.0.0.1:5001/upnp/control/content_directory");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		// SOAPClient Singleton instantiation
		soap = SOAPClient.getInstance(serverURL);

		
		/*LAYOUT*/
		setLayout(null);
		
		/*JLISTS CONTAINTER*/
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 533, 233);
		add(scrollPane);
		
		
		/*BROWSE SERVER*//////////////////////////////////////////////////////////
		JList albumList = new JList();
		scrollPane.setRowHeaderView(albumList);
		
		JList trackList = new JList();
		scrollPane.setViewportView(trackList);
		
		itemList = new JList<MediaItem>(listmodel);
		itemList.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if(test == false)
					showTrackList();
			}
		});
		
		
		
		
		
		/*MEDIA PLAYER UI*///////////////////////////////////////////////////////
		/*PLAY/PAUSE BUTTON*/
		final ImageIcon playIcon = new ImageIcon("src/main/resources/play.png");
		final ImageIcon pauseIcon = new ImageIcon("src/main/resources/pause.png");
		tglbtnPlay = new JToggleButton(playIcon);
		tglbtnPlay.setBounds(236, 283, 54, 40);
		add(tglbtnPlay);
		/*Changes Pause->Play & Vice Versa*/
		tglbtnPlay.addChangeListener(new ChangeListener()
		{
	        @Override
	        public void stateChanged(ChangeEvent event) 
	        {
	        	if (tglbtnPlay.isSelected())
	        		tglbtnPlay.setIcon(playIcon);
	        	else
	        		tglbtnPlay.setIcon(pauseIcon);
	        }
		});
		
		/*TRACK NAME LABEL*/
		JLabel label = new JLabel("<Track Name>");
		label.setBounds(208, 255, 112, 16);
		add(label);
		
		/*NEXT TRACK BUTTON*/
		Icon nextTrackIcon = new ImageIcon("src/main/resources/next 1.png");
		JButton btnNextTrack = new JButton(nextTrackIcon);
		btnNextTrack.setBounds(302, 283, 47, 40);
		add(btnNextTrack);
		
		/*PREVIOUS TRACK BUTTON*/
		Icon prevTrackIcon = new ImageIcon("src/main/resources/prev 1.png");
		JButton btnPrevTrack = new JButton(prevTrackIcon);
		btnPrevTrack.setBounds(181, 283, 47, 40);
		add(btnPrevTrack);
		
		/*Music Progress Bar*/
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(6, 267, 533, 20);
		add(progressBar);
		
	}  //END CONSTRUCTOR

	//////////////////////////////////////////////////////////////////
	/*Changes objID to selected album, submits change to SOAP client*/
	/*Populates tracklist JList with data SOAP client returns      */
	public void showTrackList() 
	{
		//returns set of tracks to display in track list
		//browserLibcontroller.getTrackList(ObjID);
		
		int index = itemList.getSelectedIndex();
		int objID = mediaItems.get(index).objectID;
		
		
	}
	
	/*Updates media player track listing with track selected in tracklist JList*/
	public void queueTrack()
	{
		int index = itemList.getSelectedIndex();
		
		//display track in media player 
		if (mediaItems.get(index).url != null) 
		{
			songUrl.setText(mediaItems.get(index).url.toString());
			playUrl = mediaItems.get(index).url;
		}
	}
	
	/*Adds selected album to settings.currentUser.favorites list and downloads album*/
	public void addToFavorites()
	{
		//download real album (from server)
		//browesLibController.downloadAlbum(objID)
		
		//create album object with album name and artist
		//Album a = new Album("name", "artist", objID);
		
		//add album to settings.(set of albums)
	//	settings.addAlbum(a);
		
		//add album to settings.currentuser.favorites
			}
}
