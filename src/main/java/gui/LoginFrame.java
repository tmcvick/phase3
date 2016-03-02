package gui;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.swing.SwingConstants;

import domainModel.AuthenticateUserController;
import domainModel.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * JFrame which displays the authentication screen
 * 
 * @author tmcvick
 *
 */
public class LoginFrame extends JFrame {

/*****************************FIELDS********************************************/
	
	/**
	 * Main Frame of the program
	 */
	private MyFrame screen;
	
	/**
	 * Swing components
	 */
	private JLabel lblUsername;
	private JPasswordField passwordField;
	private JButton btnSubmit;
	private JLabel lblEnterPin;
	private JLabel lblUser1;
	private static final long serialVersionUID = 1L;
	private JLabel lblWrongPin;
	
	
	/**
	 * Controller for the Authentication
	 */
	private AuthenticateUserController control;
	
	/**
	 * TreeMap of integers (User #) to User objects
	 */
	private Map<Integer, User> users;
	
	
	/**
	 * Represents the key in the map for the user logging in
	 */
	private int select;
	
	
	
/*****************************INTERFACE*****************************************/
	/**
	 * Creates a new instance of LoginFrame
	 * 
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//load users from settings
		populate_lists();
		

		// set layout and present welcome message
		JLabel lblWelcomePleaseSelect = new JLabel("Welcome! Please select a user:");
		lblWelcomePleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomePleaseSelect.setFont(new Font("Times New Roman", Font.BOLD, 18));
		getContentPane().setLayout(new MigLayout("", "[75px][75][75px][75][75,grow][75][75px][75px][75px]", "[75px][75px][75][75][75][75][75px]"));
		getContentPane().add(lblWelcomePleaseSelect, "cell 0 0 9 1,grow");

		// Username label- blank until a user is clicked
		lblUsername = new JLabel("");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().add(lblUsername, "cell 4 4,alignx center,aligny center");

		// enter pin prompt- blank until a user is clicked
		lblEnterPin = new JLabel("Enter Pin:");
		lblEnterPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblEnterPin, "cell 3 5,alignx trailing,aligny center");

		// field to represent pin-blank until a user is clicked
		passwordField = new JPasswordField();
		passwordField.setColumns(6);
		passwordField.setEchoChar('*');
		getContentPane().add(passwordField, "cell 4 5,alignx center,aligny center");

		// submit button-blank until a user is clicked
		btnSubmit = new JButton("Submit");

		// actionListener for loggin in
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (passwordField.getPassword().length == 4)
					login();
				else
					wrong_pin();
			}
			
		});
		getContentPane().add(btnSubmit, "cell 5 5,alignx center,aligny center");
		
		lblWrongPin = new JLabel("Wrong PIN!");
		lblWrongPin.setForeground(Color.RED);
		lblWrongPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblWrongPin, "cell 4 6,alignx center,aligny top");
		lblWrongPin.setVisible(false);
		btnSubmit.setVisible(false);
		passwordField.setVisible(false);
		lblEnterPin.setVisible(false);

		// print all user labels within window
		// each label has a mouse listener
		int i = 0, k = 0;
		int row=0, column=0;
		for (User user : users.values()) {
			column = (2 * k) + 2;
			i++;
			if(++k == 3)
				k = 0;
			if(i < 4)
				row = 1;
			else if(i < 7)
				row = 2;
			else
				row = 3;
			
			lblUser1 = new JLabel(user.getUsername());
			lblUser1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					lblUsername.setText(user.getUsername());
					
					//Find the key of selected user to set select to
					for(Entry<Integer, User> entry : users.entrySet())
					{
						if(Objects.equals(user.getUsername(), entry.getValue().getUsername()))
							select = entry.getKey();
					}
					
					btnSubmit.setVisible(true);
					passwordField.setVisible(true);
					lblEnterPin.setVisible(true);
				}
			});
			// allow the image to be used in labels
			BufferedImage img = null;
			try {
				img = ImageIO.read(new File(user.imageFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Image resized = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

			ImageIcon image = new ImageIcon(resized);
			lblUser1.setIcon(image);
			lblUser1.setHorizontalTextPosition(SwingConstants.CENTER);
			lblUser1.setVerticalTextPosition(SwingConstants.BOTTOM);
			getContentPane().add(lblUser1, "cell" + column + " " + row + ",alignx center,aligny center");
		}
		
		

		pack();
	}

	
/**************************************METHODS*********************************************************/	
	/**
	 * Will use the controller to load the users and images from Settings file
	 * 
	 */
	private void populate_lists() {
		control = new AuthenticateUserController();
		users = control.getUsers();
	
	}

	
	
	/**
	 * Will set the main Frame visible upon authentication
	 */
	public void login() {
		
		char[] entered = passwordField.getPassword();
		
		if(control.checkPassword(select, entered))
		{
			this.setVisible(false);
			control.setCurrUser(select);
			screen.setVisible(true);
		}
		else
			
		{
		//print error at 4, 5	
			wrong_pin();
		}
	}

	
	
	/**
	 * Will set the Wrong Pin label to visible
	 * A method that can be modified to handle scenarios in the future
	 */
	private void wrong_pin() {
		lblWrongPin.setVisible(true);
		passwordField.setText("");
		
	}

	
	
	/**
	 * sets the instance variable screen to the main frame, allowing the login
	 * frame to set it visible upon authentication
	 * 
	 * @param input the main frame for the program
	 *            
	 */
	public void getLogin(MyFrame input) {
		screen = input;
	}

}
