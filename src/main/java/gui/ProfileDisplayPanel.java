package gui;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProfileDisplayPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username = "";
	private MyFrame parent;
	
		
	public ProfileDisplayPanel(MyFrame parent2) {
		parent = parent2;
		
		
		
		setLayout(new MigLayout("", "[95][95][95][95][95]", "[75][75][20][75][20][75][20][75]"));
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
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch_panel(0);
			}
		});
		add(btnBack, "cell 0 0,alignx left,aligny top");
		
		JLabel lblSelectUser = new JLabel("Select User:");
		lblSelectUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblSelectUser, "cell 2 0,alignx center,aligny center");
		
		JLabel lblUser = new JLabel("User 1");
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				username = "User 1";
				switch_panel(2);
			}
		});
		lblUser.setIcon(image);
		lblUser.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser, "cell 1 1,alignx center,aligny center");
		
		JLabel lblUser_1 = new JLabel("User 2");
		lblUser_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 2";
				switch_panel(2);
			}
		});
		lblUser_1.setIcon(image);
		lblUser_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser_1, "cell 3 1,alignx center,aligny center");
		
		JLabel lblUser_2 = new JLabel("User 3");
		lblUser_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 3";
				switch_panel(2);
			}
		});
		lblUser_2.setIcon(image);
		lblUser_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser_2, "cell 1 3,alignx center,aligny center");
		
		JLabel lblUser_3 = new JLabel("User 4");
		lblUser_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 4";
				switch_panel(2);
			}
		});
		lblUser_3.setIcon(image);
		lblUser_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser_3, "cell 3 3,alignx center,aligny center");
		
		JLabel lblUser_4 = new JLabel("User 5");
		lblUser_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 5";
				switch_panel(2);
			}
		});
		lblUser_4.setIcon(image);
		lblUser_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser_4, "cell 1 5,alignx center,aligny center");
		
		JLabel lblUser_5 = new JLabel("User 6");
		lblUser_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username = "User 6";
				switch_panel(2);
			}
		});
		lblUser_5.setIcon(image);
		lblUser_5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_5.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser_5, "cell 3 5,alignx center,aligny center");
		
		JButton btnNew = new JButton("New");
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditProfilePanel newChild = parent.getHome().getEditProfilePanel();;
				newChild.clearFields();
				switch_panel(1);
			}
		});
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProfilePanel newChild = parent.getHome().getEditProfilePanel();;
				newChild.clearFields();
				switch_panel(1);
			}
		});
		add(btnNew, "cell 2 7,alignx center,aligny center");
	}
	
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

	public MyFrame getParent() {
		return parent;
	}

	public SettingsPanel getSettings() {
		
		return parent.getHome();
	}

}
