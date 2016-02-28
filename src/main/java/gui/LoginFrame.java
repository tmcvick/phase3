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

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * JFrame which displays the authentication screen
 * @author tmcvick
 *
 */
public class LoginFrame extends JFrame{
	
		/**
		 * Main Frame of the program
		 */
		private MyFrame screen;
		
		
		private JLabel lblUsername;
		private JPasswordField passwordField;
		private JButton btnSubmit;
		private JLabel lblEnterPin;
		private JLabel lblUser1;
		private JLabel lblUser2;
		private JLabel lblUser3;
		private JLabel lblUser4;
		private JLabel lblUser5;
		
		/**
		 * Creates a new instance of LoginFrame
		 */
		public LoginFrame() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//allow the image to be used in labels
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/main/resources/login.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		Image resized = img.getScaledInstance(50, 49, Image.SCALE_SMOOTH);
		
		ImageIcon image = new ImageIcon(resized);
		
		
		//set layout and present welcome message
		JLabel lblWelcomePleaseSelect = new JLabel("Welcome! Please select a user:");
		lblWelcomePleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomePleaseSelect.setFont(new Font("Times New Roman", Font.BOLD, 18));
		getContentPane().setLayout(new MigLayout("", "[75px][75][75px][75][75,grow][75][75px][75px][75px]", "[75px][75px][75][75][75][75px]"));
		getContentPane().add(lblWelcomePleaseSelect, "cell 0 0 9 1,grow");
		
		//Username label- blank until a user is clicked
		lblUsername = new JLabel("");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().add(lblUsername, "cell 4 3,alignx center,aligny center");
		
		//enter pin prompt- blank until a user is clicked
		lblEnterPin = new JLabel("Enter Pin:");
		lblEnterPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblEnterPin, "cell 3 4,alignx trailing,aligny center");
		
	    //field to represent pin-blank until a user is clicked
		passwordField = new JPasswordField();
		passwordField.setColumns(6);
		passwordField.setEchoChar('*');
		getContentPane().add(passwordField, "cell 4 4,alignx center,aligny center");
		
		//submit button-blank until a user is clicked
		btnSubmit = new JButton("Submit");
		
		//actionListener for loggin in
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(passwordField.getPassword().length == 4)
					login();
			}
		});
		getContentPane().add(btnSubmit, "cell 5 4,alignx center,aligny center");
		btnSubmit.setVisible(false);
		passwordField.setVisible(false);
		lblEnterPin.setVisible(false);
		
		
		//print all user labels within window
		//each label has a mouse listener
		lblUser1 = new JLabel("User1");
		lblUser1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				lblUsername.setText(lblUser1.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser1.setIcon(image);
		lblUser1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser1.setVerticalTextPosition(SwingConstants.BOTTOM);
		getContentPane().add(lblUser1, "cell 1 1,alignx center,aligny center");
		
		lblUser2 = new JLabel("User2");
		lblUser2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				lblUsername.setText(lblUser2.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser2.setIcon(image);
		getContentPane().add(lblUser2, "cell 4 1,alignx center,aligny center");
		
		lblUser3 = new JLabel("User 3");
		lblUser3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblUsername.setText(lblUser3.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser3.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser3.setIcon(image);
		getContentPane().add(lblUser3, "cell 7 1,alignx center,aligny center");
		
		lblUser4 = new JLabel("User 4");
		lblUser4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblUsername.setText(lblUser4.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser4.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser4.setIcon(image);
		getContentPane().add(lblUser4, "cell 2 2,alignx center,aligny center");
		
		lblUser5 = new JLabel("User 5");
		lblUser5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblUsername.setText(lblUser5.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser5.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser5.setIcon(image);
		getContentPane().add(lblUser5, "cell 6 2,alignx center,aligny center");
		
		
		
		pack();
	}

	private static final long serialVersionUID = 1L;
	
/**
 * Will set the main Frame visible upon authentication
 */
	public void login() {
	 this.setVisible(false);
	screen.setVisible(true);
		
	}
	
	/**
	 * sets the instance variable screen to the main frame, allowing
	 * the login frame to set it visible upon authentication
	 * 
	 * @param input the main frame for the program
	 */
	public void getLogin(MyFrame input)
	{
		screen = input;	
	}
	
}
