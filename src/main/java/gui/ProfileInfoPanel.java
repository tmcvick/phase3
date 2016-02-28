package gui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Displays a single user profile
 * @author tmcvick
 *
 */
public class ProfileInfoPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldPIN;
	private JTextField txtFieldFilename;
	private JTextField textFieldRestriction;
	private JTextField txtFieldType;
	private MyFrame parent;
	
	private JLabel lblUsername;
	
	/**
	 * creates a new panel
	 * @param p the previous panel
	 */
	public ProfileInfoPanel(ProfileDisplayPanel p) {
		parent = p.getParent();
		
		setLayout(new MigLayout("", "[125][125,grow][][125,grow][125,grow]", "[75][75,grow][75][75][150,grow]"));
		
		//to display image
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
				panel_switch(0);
			}
		});
		
		add(btnBack, "cell 0 0,alignx left,aligny top");
		
		lblUsername = new JLabel("User 1");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setIcon(image);
		lblUsername.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUsername.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUsername, "cell 2 0,alignx center,aligny bottom");
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditProfilePanel child = parent.getHome().getEditProfilePanel();
				child.setUsername(lblUsername.getText(), txtFieldType.getText());
				panel_switch(1);
			}
		});
		
		add(btnEdit, "cell 4 0,alignx right,aligny top");
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblPin, "cell 0 1,alignx trailing,aligny bottom");
		
		textFieldPIN = new JTextField();
		textFieldPIN.setEditable(false);
		textFieldPIN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPIN.setText("1234");
		add(textFieldPIN, "cell 1 1,growx,aligny bottom");
		textFieldPIN.setColumns(10);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblUserType, "cell 3 1,alignx trailing,aligny bottom");
		
		txtFieldType = new JTextField();
		txtFieldType.setEditable(false);
		txtFieldType.setText("Admin");
		txtFieldType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtFieldType, "cell 4 1,growx,aligny bottom");
		txtFieldType.setColumns(10);
		
		JLabel lblImageFilename = new JLabel("Image Filename:");
		lblImageFilename.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblImageFilename, "cell 0 2,alignx trailing,aligny bottom");
		
		txtFieldFilename = new JTextField();
		txtFieldFilename.setEditable(false);
		txtFieldFilename.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFieldFilename.setText("file.png");
		add(txtFieldFilename, "cell 1 2,growx,aligny bottom");
		txtFieldFilename.setColumns(10);
		
		JLabel lblRestriction = new JLabel("Restriction Level:");
		lblRestriction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblRestriction, "cell 0 3,alignx trailing,aligny bottom");
		
		textFieldRestriction = new JTextField();
		textFieldRestriction.setEditable(false);
		textFieldRestriction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldRestriction.setText("1");
		add(textFieldRestriction, "cell 1 3,alignx left,aligny bottom");
		textFieldRestriction.setColumns(4);
		
		JLabel lblFavorites = new JLabel("Favorites:");
		lblFavorites.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblFavorites, "cell 3 3,alignx center,aligny bottom");
		
		JList<String> listFavorites = new JList<String>();
		listFavorites.setBackground(SystemColor.menu);
		listFavorites.setModel(new AbstractListModel<String>() {
			
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Album 1", "Album 2", "Album 3"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		listFavorites.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(listFavorites, "cell 3 4,alignx center,growy");
	}

	/**
	 * switches to the appropriate panel
	 * @param i the panel to switch to; 0 = back, 1 = edit
	 */
	private void panel_switch(int i) {
		
		if(i == 0)
			parent.getCardlayout().show(parent.getCards(), "profile");
		if(i == 1)
			parent.getCardlayout().show(parent.getCards(), "editprofile");
		
	}

	/**
	 * sets the username and type
	 * @param username the username
	 */
	public void setUsername(String username) {
		lblUsername.setText(username);
		if(!username.equals("User 1"))
			txtFieldType.setText("Child");
		
		
	}

	/**
	 * @return the main frame
	 */
	public MyFrame getParent() {
		return parent;
	}

}
