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

public class LoginFrame extends JFrame{
	
		
		private MyFrame screen;
		private JLabel username;
		private JPasswordField passwordField;
		private JButton btnSubmit;
		private JLabel lblEnterPin;
		private JLabel lblUser;
		private JLabel lblUser_1;
		private JLabel lblUser_2;
		private JLabel lblUser_3;
		private JLabel lblUser_4;
		
		public LoginFrame() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/main/resources/login.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		Image resized = img.getScaledInstance(50, 49, Image.SCALE_SMOOTH);
		
		ImageIcon image = new ImageIcon(resized);
		JLabel lblWelcomePleaseSelect = new JLabel("Welcome! Please select a user:");
		lblWelcomePleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomePleaseSelect.setFont(new Font("Times New Roman", Font.BOLD, 18));
		getContentPane().setLayout(new MigLayout("", "[75px][75][75px][75][75,grow][75][75px][75px][75px]", "[75px][75px][75][75][75][75px]"));
		getContentPane().add(lblWelcomePleaseSelect, "cell 0 0 9 1,grow");
		
		
		username = new JLabel("");
		username.setFont(new Font("Tahoma", Font.BOLD, 16));
		getContentPane().add(username, "cell 4 3,alignx center,aligny center");
		
		lblEnterPin = new JLabel("Enter Pin:");
		lblEnterPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblEnterPin, "cell 3 4,alignx trailing,aligny center");
		
	    
		passwordField = new JPasswordField();
		passwordField.setColumns(6);
		passwordField.setEchoChar('*');
		getContentPane().add(passwordField, "cell 4 4,alignx center,aligny center");
		
		
		btnSubmit = new JButton("Submit");
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
		
		lblUser = new JLabel("User1");
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				username.setText(lblUser.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser.setIcon(image);
		lblUser.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser.setVerticalTextPosition(SwingConstants.BOTTOM);
		getContentPane().add(lblUser, "cell 1 1,alignx center,aligny center");
		
		lblUser_1 = new JLabel("User2");
		lblUser_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				username.setText(lblUser_1.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_1.setIcon(image);
		getContentPane().add(lblUser_1, "cell 4 1,alignx center,aligny center");
		
		lblUser_2 = new JLabel("User 3");
		lblUser_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username.setText(lblUser_2.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_2.setIcon(image);
		getContentPane().add(lblUser_2, "cell 7 1,alignx center,aligny center");
		
		lblUser_3 = new JLabel("User 4");
		lblUser_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username.setText(lblUser_3.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_3.setIcon(image);
		getContentPane().add(lblUser_3, "cell 2 2,alignx center,aligny center");
		
		lblUser_4 = new JLabel("User 5");
		lblUser_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				username.setText(lblUser_4.getText());
				btnSubmit.setVisible(true);
				passwordField.setVisible(true);
				lblEnterPin.setVisible(true);
			}
		});
		lblUser_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_4.setIcon(image);
		getContentPane().add(lblUser_4, "cell 6 2,alignx center,aligny center");
		
		
		
		pack();
	}

	private static final long serialVersionUID = 1L;
	

	public void login() {
	 this.setVisible(false);
	screen.setVisible(true);
		
	}
	public void getLogin(MyFrame input)
	{
		
	screen = input;	
	}
	
}
