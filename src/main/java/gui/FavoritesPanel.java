package gui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FavoritesPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private JToggleButton tglbtnPlay;
	
	public FavoritesPanel() 
	{
		setLayout(null);
		
<<<<<<< HEAD
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
		albumScrollPane.setViewportView(albumList);
		add(albumScrollPane);
		
		trackListModel= new DefaultListModel<MediaItem>();
		trackList = new JList<MediaItem>(trackListModel);
		trackList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		trackScrollPane = new JScrollPane(trackList);
		trackScrollPane.setBounds(300, 20, 247, 207);
		//trackScrollPane.setViewportView(trackList);
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
<<<<<<< HEAD
=======
=======
		/*
>>>>>>> parent of c00de86... Uniformed Interface
		JScrollBar favScrollBar = new JScrollBar();
		favScrollBar.setBounds(472, 6, 15, 233);
		add(favScrollBar);
				
		MyJTreeData favAlbumTree = new MyJTreeData();
		favAlbumTree.setBounds(6, 6, 481, 233);
<<<<<<< HEAD
		add(favAlbumTree);
>>>>>>> parent of ec51bb5... Big Commit
=======
		add(favAlbumTree); */
>>>>>>> parent of c00de86... Uniformed Interface
		
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
		
		/*TRACK NAME LABEL*/
		JLabel label = new JLabel("<Track Name>");
		label.setBounds(186, 251, 112, 16);
		add(label);
		
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
	
	
	}
	
<<<<<<< HEAD
	public void queueTrack()
	{
		int index = trackList.getSelectedIndex();
		System.out.println(index);
		//display track name in media player 
		if (selectedAlbum.tracks != null && index >= 0) 
		{
			System.out.println(selectedAlbum.tracks.size());
			MediaItem item = selectedAlbum.tracks.get(index);
			songTitle = new JLabel(item.title);
			if (item.url != null) {
				playUrl = item.url;
			}
		}
		trackList.clearSelection();
	}
=======
>>>>>>> parent of ec51bb5... Big Commit
}
