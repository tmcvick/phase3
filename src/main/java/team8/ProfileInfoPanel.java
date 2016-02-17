package team8;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtFilepng;
	private JTextField textField_1;
	private JTextField txtAdmin;
	private ProfileDisplayPanel parent;
	private EditProfilePanel child;
	private JLabel lblUser;
	
	public ProfileInfoPanel(ProfileDisplayPanel p) {
		parent = p;
		child = p.getSettings().getEditProfilePanel();
		setLayout(new MigLayout("", "[125][125,grow][][125,grow][125,grow]", "[75][75,grow][75][75][150,grow]"));
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/login.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		Image resized = img.getScaledInstance(50, 49, Image.SCALE_SMOOTH);
		
		ImageIcon image = new ImageIcon(resized);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_switch(0);
			}
		});
		add(btnBack, "cell 0 0,alignx left,aligny top");
		
		lblUser = new JLabel("User 1");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setIcon(image);
		lblUser.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(lblUser, "cell 2 0,alignx center,aligny bottom");
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				child.setUsername(lblUser.getText(), txtAdmin.getText());
				panel_switch(1);
			}
		});
		add(btnEdit, "cell 4 0,alignx right,aligny top");
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblPin, "cell 0 1,alignx trailing,aligny bottom");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setText("1234");
		add(textField, "cell 1 1,growx,aligny bottom");
		textField.setColumns(10);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblUserType, "cell 3 1,alignx trailing,aligny bottom");
		
		txtAdmin = new JTextField();
		txtAdmin.setEditable(false);
		txtAdmin.setText("Admin");
		txtAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtAdmin, "cell 4 1,growx,aligny bottom");
		txtAdmin.setColumns(10);
		
		JLabel lblImageFilename = new JLabel("Image Filename:");
		lblImageFilename.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblImageFilename, "cell 0 2,alignx trailing,aligny bottom");
		
		txtFilepng = new JTextField();
		txtFilepng.setEditable(false);
		txtFilepng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFilepng.setText("file.png");
		add(txtFilepng, "cell 1 2,growx,aligny bottom");
		txtFilepng.setColumns(10);
		
		JLabel lblRestriction = new JLabel("Restriction Level:");
		lblRestriction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblRestriction, "cell 0 3,alignx trailing,aligny bottom");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setText("1");
		add(textField_1, "cell 1 3,alignx left,aligny bottom");
		textField_1.setColumns(4);
		
		JLabel lblFavorites = new JLabel("Favorites:");
		lblFavorites.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblFavorites, "cell 3 3,alignx center,aligny bottom");
		
		JList<String> list = new JList<String>();
		list.setBackground(SystemColor.menu);
		list.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Album 1", "Album 2", "Album 3"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(list, "cell 3 4,alignx center,growy");
	}

	private void panel_switch(int i) {
		setVisible(false);
		if(i == 0)
			parent.setVisible(true);
		if(i == 1)
			child.setVisible(true);
		
	}

	public void setUsername(String username) {
		lblUser.setText(username);
		if(!username.equals("User 1"))
			txtAdmin.setText("Child");
		
		
	}

	public ProfileDisplayPanel getFather() {
		
		return parent;
	}

}
