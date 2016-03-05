package gui;

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
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domainModel.Album;
import domainModel.MediaItem;
import domainModel.Settings;
import technical.MediaPlayer;

public class FavoritesPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private JToggleButton tglbtnPlay;
	private MediaPlayer musicPlayer;
	private DefaultListModel<Album> albumListModel;
	private DefaultListModel<MediaItem> trackListModel;
	private JList<MediaItem> trackList;
	private JList<Album> albumList;
	private boolean lock = false;
	private ArrayList<Album> albums;
	private Album selectedAlbum;
	private JLabel songTitle;
	private URL playUrl;
	private Settings settings;
	JScrollPane albumScrollPane;
	JScrollPane trackScrollPane;
	
	public FavoritesPanel() 
	{
		settings = Settings.getInstance();
		setLayout(null);
		
		albums = new ArrayList<Album>();
		if (settings.getCurrentUser().favorites != null)
			for (String favorite : settings.getCurrentUser().favorites) 
				albums.add(settings.getAlbum(favorite));
		
		albumListModel = new DefaultListModel<Album>();
		for (Album item : albums) albumListModel.addElement(item);
		albumList = new JList<Album>(albumListModel);
		albumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		albumScrollPane = new JScrollPane(albumList);
		albumScrollPane.setBounds(6, 6, 267, 233);
		add(albumScrollPane);
		
		trackListModel= new DefaultListModel<MediaItem>();
		trackList = new JList<MediaItem>(trackListModel);
		trackList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		trackScrollPane = new JScrollPane(trackList);
		trackScrollPane.setBounds(300, 20, 247, 207);
		add(trackScrollPane);
		
		albumList.addListSelectionListener(new ListSelectionListener() 
		{
			//shows selected album's track list in track panel
			//enables "Add Fav" button for selected album 
			public void valueChanged(ListSelectionEvent e)
			{	
				if (!lock) showTrackList();
			}
		});
		
		trackList.addListSelectionListener(new ListSelectionListener() 
		{
			//shows selected track name in media player label
			public void valueChanged(ListSelectionEvent e)
			{
				if(!lock)	queueTrack();
			}
		});
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(6, 267, 481, 20);
		add(progressBar);
		
		/*PLAY/PAUSE BUTTON*/
		final ImageIcon playIcon = new ImageIcon("src/main/resources/play.png");
		final ImageIcon pauseIcon = new ImageIcon("src/main/resources/pause.png");
		tglbtnPlay = new JToggleButton(playIcon);
		tglbtnPlay.setBounds(212, 283, 54, 40);
		add(tglbtnPlay);
		
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
		
		songTitle = new JLabel("");
		songTitle.setBounds(200, 251, 112, 16);
		add(songTitle);
		
		/*NEXT TRACK BUTTON*/
		Icon nextTrackIcon = new ImageIcon("src/main/resources/next 1.png");
		JButton btnNextTrack = new JButton(nextTrackIcon);
		btnNextTrack.setBounds(278, 283, 47, 40);
		add(btnNextTrack);
		
		/*PREVIOUS TRACK BUTTON*/
		Icon prevTrackIcon = new ImageIcon("src/main/resources/prev 1.png");
		JButton btnPrevTrack = new JButton(prevTrackIcon);
		btnPrevTrack.setBounds(153, 283, 47, 40);
		add(btnPrevTrack);
	
		//showAlbumList();
	}
	
	/*
	private void showAlbumList() 
	{
		
		
		//returns set of tracks to display in track list
		//browserLibcontroller.getTrackList(ObjID);
		//setItems(getMediaFromServer(0));
		
		//displays track list in track panel
		lock = true;
		albumListModel.clear();
		lock = false;
		
		for (int i = 0; i < albums.size(); i++)
		{
			trackListModel.addElement(mediaItems.get(i));
			System.out.println(mediaItems.get(i));
		}
		
		trackScrollPane.revalidate();
		trackScrollPane.repaint();	
	} */
	
	private void showTrackList() 
	{
		lock = true;
		trackListModel.clear();
		lock = false;
		int index = albumList.getSelectedIndex();
		selectedAlbum = albums.get(index);
		//int objID = mediaItems.get(index).objectID;
	
		
		//returns set of tracks to display in track list
		//browserLibcontroller.getTrackList(ObjID);
		//setItems(getMediaFromServer(objID));
		
		//displays track list in track panel
		//lock = true;
		//trackListModel.clear();
		//lock = false;
		
		//for (int i = 0; i < mediaItems.size(); i++)
		//	trackListModel.addElement(mediaItems.get(i));
	
		for (MediaItem item : selectedAlbum.tracks) trackListModel.addElement(item);
		trackScrollPane.revalidate();
		trackScrollPane.repaint();	
	}
	
	public void queueTrack()
	{
		int index = trackList.getSelectedIndex();
		//display track name in media player 
		if (selectedAlbum.tracks != null && index >= 0) 
		{
			MediaItem item = selectedAlbum.tracks.get(index);
			songTitle.setText(item.title);
			
			if (item.url != null) {
				playUrl = item.url;
			}
		}
		trackList.clearSelection();
	}
}
