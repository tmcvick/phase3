package team8;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.JTree;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FavoritesPanel extends JPanel 
{
	private JToggleButton tglbtnPlay;
	private Icon playIcon;
	
	public FavoritesPanel() 
	{
		setLayout(null);
		
		JScrollBar favScrollBar = new JScrollBar();
		favScrollBar.setBounds(472, 6, 15, 233);
		add(favScrollBar);
		
		MyJTreeData favAlbumTree = new MyJTreeData();
		
		
		favAlbumTree.setBounds(6, 6, 481, 233);
		add(favAlbumTree);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(6, 267, 481, 20);
		add(progressBar);
		
		/*PLAY/PAUSE BUTTON*/
		Icon playIcon = new ImageIcon("/Users/claymoeller/workspace/team8/Vector UI Icons/PNG/play.png");
		JToggleButton tglbtnPlay = new JToggleButton(playIcon);
		tglbtnPlay.setBounds(212, 283, 54, 40);
		add(tglbtnPlay);
		tglbtnPlay.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				SwitchButton();
			}
		});
		
		
		/*TRACK NAME LABEL*/
		JLabel label = new JLabel("<Track Name>");
		label.setBounds(186, 251, 112, 16);
		add(label);
		
		/*NEXT TRACK BUTTON*/
		Icon nextTrackIcon = new ImageIcon("/Users/claymoeller/workspace/team8/Vector UI Icons/PNG/next 1.png");
		JButton btnNextTrack = new JButton(nextTrackIcon);
		btnNextTrack.setBounds(278, 283, 47, 40);
		add(btnNextTrack);
		
		/*PREVIOUS TRACK BUTTON*/
		Icon prevTrackIcon = new ImageIcon("/Users/claymoeller/workspace/team8/Vector UI Icons/PNG/prev 1.png");
		JButton btnPrevTrack = new JButton(prevTrackIcon);
		btnPrevTrack.setBounds(153, 283, 47, 40);
		add(btnPrevTrack);
	}
	
	/*Switches Play button to Pause when Pressed*/
	public void SwitchButton()
	{
		if (tglbtnPlay.isSelected())
		{
			playIcon = new ImageIcon("/Users/claymoeller/workspace/team8/Vector UI Icons/PNG/pause.png");
		}
		
		else 
			playIcon = new ImageIcon("/Users/claymoeller/workspace/team8/Vector UI Icons/PNG/play.png");
	}
	
}
