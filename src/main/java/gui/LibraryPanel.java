package gui;

import java.io.IOException;
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
import javax.swing.ListSelectionModel;

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
	private DefaultListModel<MediaItem> albumListModel;
	private DefaultListModel<MediaItem> trackListModel;
	private JList trackList;
	private JList albumList;
	private ArrayList<MediaItem> mediaItems;
	private JTextField songUrl;
	private URL playUrl;
	private boolean lock = false;
	private Settings settings;
	JScrollPane albumScrollPane;
	JScrollPane trackScrollPane;
	JButton btnAddFavorite;
	
	public LibraryPanel() 
	{
		//allows you to pull info from settings obj 
		//created upon login
		settings = Settings.getInstance();
		
		//gets and assigns server URL to pull media from
		serverURL = settings.serverURL;
	
		// SOAPClient Singleton instantiation
		soap = SOAPClient.getInstance(serverURL);

		/*LAYOUT*/
		setLayout(null);
		
		/*JLISTS CONTAINERS*/
		albumScrollPane = new JScrollPane();
		albumScrollPane.setBounds(6, 6, 267, 233);
		add(albumScrollPane);
		trackScrollPane = new JScrollPane();
		trackScrollPane.setBounds(533, 20, -247, 207);
		add(trackScrollPane);
		
		//album list 
		albumList = new JList();
		albumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		albumScrollPane.add(albumList);
		albumScrollPane.setViewportView(albumList);
		
		
		//track list
		trackList = new JList();
		trackList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		trackScrollPane.add(trackList);
		trackScrollPane.setViewportView(trackList);
		
		
		//ALBUM LIST MODEL
		albumListModel = new DefaultListModel<MediaItem>();
		albumList = new JList<MediaItem>(albumListModel);
		albumList.addListSelectionListener(new ListSelectionListener() 
		{
			//shows selected album's track list in track panel
			//enables "Add Fav" button for selected album 
			public void valueChanged(ListSelectionEvent e)
			{
				//checks that album is selected
				if (albumList.getSelectedIndex() != -1)
					btnAddFavorite.setEnabled(true);
				
				if(lock == false)
					showTrackList();
			}
		});
		
		//TRACK LIST MODEL
		trackListModel= new DefaultListModel<MediaItem>();
		trackList = new JList<MediaItem>(trackListModel);
		trackList.addListSelectionListener(new ListSelectionListener() 
		{
			//shows selected track name in media player label
			public void valueChanged(ListSelectionEvent e)
			{
				//disables fav button since track is selected
				btnAddFavorite.setEnabled(false);
				
				if(lock == false)
					queueTrack();
			}
		});
		
		
		/*MEDIA PLAYER UI*/
		//////////////////////////////////////////////////////////////////
		
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
		
		/*MUSIC PROGRESS BAR*/
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(6, 267, 533, 20);
		add(progressBar);
		
		/*ADD TO FAVORITES BUTTON*/
		btnAddFavorite = new JButton("Add to Favorites");
		btnAddFavorite.setBounds(409, 375, 130, 29);
		btnAddFavorite.setEnabled(false);
		add(btnAddFavorite);
		
		//populates album list with albums
		showAlbumList();
		
		
		
		
	}  /*[END CONSTRUCTOR]*/

	
	
	
	
	/*METHODS*/
	//////////////////////////////////////////////////////////////////
	/*Changes objID to selected album, submits change to SOAP client*/
	public void showAlbumList() 
	{
		
		
		//returns set of tracks to display in track list
		//browserLibcontroller.getTrackList(ObjID);
		setItems(getMediaFromServer(0));
		
		//displays track list in track panel
		lock = true;
		albumListModel.clear();
		lock = false;
		
		for (int i = 0; i < mediaItems.size(); i++)
		{
			trackListModel.addElement(mediaItems.get(i));
			System.out.println(mediaItems.get(i));
		}
		
		trackScrollPane.revalidate();
		trackScrollPane.repaint();	
	}
	
	
	/*Changes objID to selected album, submits change to SOAP client*/
	/*Populates tracklist JList with data SOAP client returns       */
	public void showTrackList() 
	{
		int index = albumList.getSelectedIndex();
		int objID = mediaItems.get(index).objectID;
	
		
		//returns set of tracks to display in track list
		//browserLibcontroller.getTrackList(ObjID);
		setItems(getMediaFromServer(objID));
		
		//displays track list in track panel
		//lock = true;
		//trackListModel.clear();
		//lock = false;
		
		for (int i = 0; i < mediaItems.size(); i++)
			trackListModel.addElement(mediaItems.get(i));
		trackScrollPane.revalidate();
		trackScrollPane.repaint();	
	}
	
	/*-------to be moved to libcontroller*/
	/*Sets items pulled from server into Jlist*/
	public void setItems(ArrayList<MediaItem> items) 
	{
		if (mediaItems != null && items != null) 
		{
			mediaItems.clear();
			for(int i = 0; i < items.size(); i++)
				mediaItems.add(items.get(i));
		}else if(items == null)
			return;
		else 
		{
			mediaItems = new ArrayList<MediaItem>();
			for(int i = 0; i < items.size(); i++)
				mediaItems.add(items.get(i));
		}
	}
	
	
	/*-------to be moved to libcontroller*/
	/*Returns list of media items in directory of ObjID*/
	public ArrayList<MediaItem> getMediaFromServer(int objID)
	{
		ArrayList<MediaItem> media= new ArrayList<MediaItem>();
		
		try {
			media= soap.request(objID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return media;
	}
	
	/*Updates media player track listing with track selected in tracklist JList*/
	public void queueTrack()
	{
		int index = trackList.getSelectedIndex();
		
		//display track name in media player 
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
