package team8;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class LibraryPanel extends JPanel 
{
	private JToggleButton tglbtnPlay;
	
	public LibraryPanel() 
	{
		setLayout(null);
		
		JScrollBar favScrollBar = new JScrollBar();
		favScrollBar.setBounds(472, 6, 15, 233);
		add(favScrollBar);
				
		MyJTreeData libAlbumTree = new MyJTreeData();
		libAlbumTree.setBounds(6, 6, 481, 233);
		add(libAlbumTree);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(6, 267, 481, 20);
		add(progressBar);
		
		/*PLAY/PAUSE BUTTON*/
		final ImageIcon playIcon = new ImageIcon("src/play.png");
		final ImageIcon pauseIcon = new ImageIcon("src/pause.png");
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
		Icon nextTrackIcon = new ImageIcon("src/next 1.png");
		JButton btnNextTrack = new JButton(nextTrackIcon);
		btnNextTrack.setBounds(278, 283, 47, 40);
		add(btnNextTrack);
		
		/*PREVIOUS TRACK BUTTON*/
		Icon prevTrackIcon = new ImageIcon("src/prev 1.png");
		JButton btnPrevTrack = new JButton(prevTrackIcon);
		btnPrevTrack.setBounds(153, 283, 47, 40);
		add(btnPrevTrack);
	}
	
}
