package gui;

/**
 * Panel that displays all saved user profiles
 */
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProfileDisplayPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private String username = "";
	private MyFrame parent;
	
		/**
		 * creates a new panel
		 * @param parent2 the main frame 
		 */
	public ProfileDisplayPanel(MyFrame parent2) {
		parent = parent2;
		
		
		
		setLayout(new MigLayout("", "[95][95][95][95][95]", "[75][75][20][75][20][75][20][75]"));
		
		//set up the images
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/main/resources/login.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		Image resized = img.getScaledInstance(50, 49, Image.SCALE_SMOOTH);
		
		ImageIcon image = new ImageIcon(resized);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switch_panel(0);
			}
		});
		
		add(btnBack, "cell 0 0,alignx left,aligny top");
		
		JLabel lblSelectUser = new JLabel("Select User:");
		lblSelectUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblSelectUser, "cell 2 0,alignx center,aligny center");
		
		JLabel lblUser1 = new JLabel("User 1");
		lblUser1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				username = "User 1";
				switch_panel(2);
			}
		});
		lblUser1.setIcon(image);
		lblUser1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser1.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser1, "cell 1 1,alignx center,aligny center");
		
		JLabel lblUser2 = new JLabel("User 2");
		lblUser2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 2";
				switch_panel(2);
			}
		});
		lblUser2.setIcon(image);
		lblUser2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser2.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser2, "cell 3 1,alignx center,aligny center");
		
		JLabel lblUser3 = new JLabel("User 3");
		lblUser3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 3";
				switch_panel(2);
			}
		});
		lblUser3.setIcon(image);
		lblUser3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser3.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser3, "cell 1 3,alignx center,aligny center");
		
		JLabel lblUser4 = new JLabel("User 4");
		lblUser4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 4";
				switch_panel(2);
			}
		});
		lblUser4.setIcon(image);
		lblUser4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser4.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser4, "cell 3 3,alignx center,aligny center");
		
		JLabel lblUser5 = new JLabel("User 5");
		lblUser5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 5";
				switch_panel(2);
			}
		});
		lblUser5.setIcon(image);
		lblUser5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser5.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser5, "cell 1 5,alignx center,aligny center");
		
		JLabel lblUser6 = new JLabel("User 6");
		lblUser6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 6";
				switch_panel(2);
			}
		});
		lblUser6.setIcon(image);
		lblUser6.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser6.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser6, "cell 3 5,alignx center,aligny center");
		
		JButton btnNew = new JButton("New");
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditProfilePanel newChild = parent.getHome().getEditProfilePanel();;
				newChild.clearFields();
				switch_panel(1);
			}
		});
		
		add(btnNew, "cell 2 7,alignx center,aligny center");
	}
	
	/**
	 * switches to the appropriate panel
	 * @param i the panel to switch to: 0 = home, 1 = new, 2 = view profile
	 */
	private void switch_panel(int i)
	{
		
		if(i == 0)
			parent.getCardlayout().show(parent.getCards(), "home");
		if(i == 1)
			parent.getCardlayout().show(parent.getCards(), "editprofile");
		if(i == 2)
		{
			ProfileInfoPanel child = parent.getHome().getProfileInfoPanel();
			child.setUsername(username);
		
			parent.getCardlayout().show(parent.getCards(), "indvprofile");
		}
	}

	/**
	 * @return the main frame
	 */
	public MyFrame getParent() {
		return parent;
	}

	/**
	 * 
	 * @return the settings home panel
	 */
	public SettingsPanel getSettings() {
		
		return parent.getHome();
	}

}
