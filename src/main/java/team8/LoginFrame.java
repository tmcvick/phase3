package team8;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame{
	
	private LoginWindow loginWindow;
	public LoginFrame() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\login.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		Image resized = img.getScaledInstance(50, 49, Image.SCALE_SMOOTH);
		
		ImageIcon image = new ImageIcon(resized);
		JLabel lblWelcomePleaseSelect = new JLabel("Welcome! Please select a user:");
		lblWelcomePleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomePleaseSelect.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblUser = new JLabel("User1");
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				loginWindow.username.setTest(lblUser.getText());
				loginWindow.setVisible(true);
			}
		});
		lblUser.setIcon(image);
		lblUser.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		JLabel lblUser_1 = new JLabel("User2");
		lblUser_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_1.setIcon(image);
		
		JLabel lblUser_2 = new JLabel("User 3");
		lblUser_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_2.setIcon(image);
		
		JLabel lblUser_3 = new JLabel("User 4");
		lblUser_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_3.setIcon(image);
		
		JLabel lblUser_4 = new JLabel("User 5");
		lblUser_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblUser_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUser_4.setIcon(image);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblWelcomePleaseSelect, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
					.addGap(6))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lblUser, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addGap(97)
					.addComponent(lblUser_1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addGap(95)
					.addComponent(lblUser_2, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
					.addGap(52))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addComponent(lblUser_3, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
					.addGap(115)
					.addComponent(lblUser_4, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblWelcomePleaseSelect, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblUser)
						.addComponent(lblUser_2)
						.addComponent(lblUser_1))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblUser_4)
						.addComponent(lblUser_3))
					.addGap(20))
		);
		getContentPane().setLayout(groupLayout);
		pack();
	}

	private static final long serialVersionUID = 1L;

	public Boolean login() {
		return true;
		
	}
}
