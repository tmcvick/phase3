package team8;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerPopup extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblServerFound;
	private JButton btnClose;
	public ServerPopup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblVerifyingServer = new JLabel("Verifying Server..........");
		lblVerifyingServer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVerifyingServer.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblVerifyingServer, BorderLayout.NORTH);
		
		lblServerFound = new JLabel("Server Found!");
		lblServerFound.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblServerFound.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblServerFound, BorderLayout.CENTER);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		getContentPane().add(btnClose, BorderLayout.SOUTH);
		btnClose.setVisible(false);
		lblServerFound.setVisible(false);
	}
	public void setVisible(boolean bool)
	{
		super.setVisible(bool);
		if(bool == true)
		{
		try {
			Thread.sleep(1000);
			lblServerFound.setVisible(true);
			btnClose.setVisible(true);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		}
			

	}
}
