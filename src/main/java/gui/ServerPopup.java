package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class ServerPopup extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblServerFound;
	private JButton btnClose;
	public ServerPopup() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[100px][150][100]", "[17px][22px][23px]"));
		
		JLabel lblVerifyingServer = new JLabel("Verifying Server..........");
		lblVerifyingServer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVerifyingServer.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblVerifyingServer, "cell 1 0,alignx left,aligny top");
		
		lblServerFound = new JLabel("Server Found!");
		lblServerFound.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblServerFound.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblServerFound, "cell 1 1,growx,aligny top");
		lblServerFound.setVisible(false);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		getContentPane().add(btnClose, "cell 1 2,growx,aligny top");
		btnClose.setVisible(false);
		pack();
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
