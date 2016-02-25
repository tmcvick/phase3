package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditProfilePanel extends JPanel{
	private MyFrame parent;
	@SuppressWarnings("unused")
	private JPanel step;
	private DeletePopup child;
	private boolean isNew = false;
	
	public EditProfilePanel(JPanel p) {
		if(p instanceof ProfileInfoPanel){
			parent = ((ProfileInfoPanel)p).getParent();
			step = p;
			child = new DeletePopup(this);	
		}
		else{
			parent = (((ProfileDisplayPanel)p).getParent());
			step = p;
			child = new DeletePopup(this);
		}
		setLayout(new MigLayout("", "[50][100][150,grow][50]", "[50][50][50][50][50][50][50][150,grow]"));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_switch(0);
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_switch(0);
			}
		});
		add(btnCancel, "cell 0 0,alignx left,aligny top");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				child.setVisible(true);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				child.setVisible(true);
			}
		});
		add(btnDelete, "cell 3 0,alignx right,aligny top");
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblName, "cell 1 1,alignx right,aligny center");
		
		txtUser = new JTextField();
		txtUser.setText("User 1");
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtUser, "cell 2 1,growx,aligny center");
		txtUser.setColumns(10);
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblPin, "cell 1 2,alignx trailing,aligny center");
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setEchoChar('*');
		add(passwordField, "cell 2 2,growx");
		
		JLabel lblReenterPin = new JLabel("Re-enter PIN:");
		lblReenterPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblReenterPin, "cell 1 3,alignx trailing,aligny center");
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_1.setEchoChar('*');
		add(passwordField_1, "cell 2 3,growx");
		
		JLabel lblImageFilename = new JLabel("Image Filename:");
		lblImageFilename.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblImageFilename, "cell 1 4,alignx trailing,aligny center");
		
		txtFilepng = new JTextField();
		txtFilepng.setText("file.png");
		txtFilepng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtFilepng, "cell 2 4,growx,aligny center");
		txtFilepng.setColumns(10);
		
		JLabel lblRestrictionLevel = new JLabel("Restriction Level:");
		lblRestrictionLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblRestrictionLevel, "cell 1 5,alignx trailing,aligny center");
		
		textField_2 = new JTextField();
		textField_2.setText("1");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(textField_2, "cell 2 5,growx");
		textField_2.setColumns(10);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblUserType, "cell 1 6,alignx trailing");
		
		txtAdmin = new JTextField();
		txtAdmin.setText("Admin");
		txtAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtAdmin, "cell 2 6,growx");
		txtAdmin.setColumns(10);
		
		JLabel lblFavorites = new JLabel("Favorites:");
		lblFavorites.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblFavorites, "cell 1 7,alignx right,aligny top");
		
		txtrAlbumAlbum = new JTextArea();
		txtrAlbumAlbum.setText("Album 1\r\nAlbum 2\r\nAlbum 3\r\n");
		txtrAlbumAlbum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtrAlbumAlbum, "cell 2 7,grow");
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_switch(0);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_switch(0);
			}
		});
		add(btnNewButton, "cell 3 7,aligny top");
	}

	public MyFrame getParent() {
		return parent;
	}

	private void panel_switch(int i) {
		if(isNew == false)
			parent.getCardlayout().show(parent.getCards(), "indvprofile");
		else
			parent.getCardlayout().show(parent.getCards(), "profile");
		isNew = false;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUser;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtFilepng;
	private JTextField textField_2;
	private JTextField txtAdmin;
	private JTextArea txtrAlbumAlbum;
	
	public void setUsername(String text, String string) {
		txtUser.setText(text);
		txtAdmin.setText(string);
		
	}

	public void clearFields() {
		txtUser.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		txtFilepng.setText("");
		textField_2.setText("");
		txtAdmin.setText("");
		txtrAlbumAlbum.setText("");
		isNew = true;
	}

}
