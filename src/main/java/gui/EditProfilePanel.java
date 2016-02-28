package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class that allows a user to edit a profile
 * @author tmcvick
 *
 */
public class EditProfilePanel extends JPanel{
	private MyFrame parent;
	@SuppressWarnings("unused")
	private JPanel step;
	private DeletePopup child;
	private boolean isNew = false;
	
	/**
	 * creates a new panel for editing a profile
	 * @param p the panel that called this panel
	 */
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
		
		add(btnCancel, "cell 0 0,alignx left,aligny top");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				child.setVisible(true);
			}
		});
		
		add(btnDelete, "cell 3 0,alignx right,aligny top");
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblName, "cell 1 1,alignx right,aligny center");
		
		txtFieldUser = new JTextField();
		txtFieldUser.setText("User 1");
		txtFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtFieldUser, "cell 2 1,growx,aligny center");
		txtFieldUser.setColumns(10);
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblPin, "cell 1 2,alignx trailing,aligny center");
		
		passwordFieldOld = new JPasswordField();
		passwordFieldOld.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldOld.setEchoChar('*');
		add(passwordFieldOld, "cell 2 2,growx");
		
		JLabel lblReenterPin = new JLabel("Re-enter PIN:");
		lblReenterPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblReenterPin, "cell 1 3,alignx trailing,aligny center");
		
		passwordFieldNew = new JPasswordField();
		passwordFieldNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordFieldNew.setEchoChar('*');
		add(passwordFieldNew, "cell 2 3,growx");
		
		JLabel lblImageFilename = new JLabel("Image Filename:");
		lblImageFilename.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblImageFilename, "cell 1 4,alignx trailing,aligny center");
		
		txtImageFile = new JTextField();
		txtImageFile.setText("file.png");
		txtImageFile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtImageFile, "cell 2 4,growx,aligny center");
		txtImageFile.setColumns(10);
		
		JLabel lblRestrictionLevel = new JLabel("Restriction Level:");
		lblRestrictionLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblRestrictionLevel, "cell 1 5,alignx trailing,aligny center");
		
		txtFieldRestrictionLevel = new JTextField();
		txtFieldRestrictionLevel.setText("1");
		txtFieldRestrictionLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtFieldRestrictionLevel, "cell 2 5,growx");
		txtFieldRestrictionLevel.setColumns(10);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblUserType, "cell 1 6,alignx trailing");
		
		txtFieldUserType = new JTextField();
		txtFieldUserType.setText("Admin");
		txtFieldUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtFieldUserType, "cell 2 6,growx");
		txtFieldUserType.setColumns(10);
		
		JLabel lblFavorites = new JLabel("Favorites:");
		lblFavorites.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblFavorites, "cell 1 7,alignx right,aligny top");
		
		txtAreaAlbumList = new JTextArea();
		txtAreaAlbumList.setText("Album 1\r\nAlbum 2\r\nAlbum 3\r\n");
		txtAreaAlbumList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtAreaAlbumList, "cell 2 7,grow");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_switch(0);
			}
		});
		
		add(btnSubmit, "cell 3 7,aligny top");
	}

	/**
	 * returns the main frame
	 */
	public MyFrame getParent() {
		return parent;
	}

	/**
	 * switches to the appropriate panel
	 * @param i the panel to switch to: ifNew, show profile, if edited, show list
	 */
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
	private JTextField txtFieldUser;
	private JPasswordField passwordFieldOld;
	private JPasswordField passwordFieldNew;
	private JTextField txtImageFile;
	private JTextField txtFieldRestrictionLevel;
	private JTextField txtFieldUserType;
	private JTextArea txtAreaAlbumList;
	
	/**
	 * sets the username and user type to the parameters
	 * @param text the username
	 * @param string the user type
	 */
	public void setUsername(String text, String string) {
		txtFieldUser.setText(text);
		txtFieldUserType.setText(string);
		
	}

	/**
	 * Will clear all instance variables, effectively creating a blank user
	 */
	public void clearFields() {
		txtFieldUser.setText("");
		passwordFieldOld.setText("");
		passwordFieldNew.setText("");
		txtImageFile.setText("");
		txtFieldRestrictionLevel.setText("");
		txtFieldUserType.setText("");
		txtAreaAlbumList.setText("");
		isNew = true;
	}

}
