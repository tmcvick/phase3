package gui;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class that is a popup requesting delete confirmation
 */
public class DeletePopup extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private MyFrame parent;

	/**
	 * creates a new popup
	 * @param p the EditProfilePanel that will request confirmation
	 */
	public DeletePopup(EditProfilePanel p) {
		parent = p.getParent();
		
		
		getContentPane().setLayout(new MigLayout("", "[][][][][][][][][]", "[][][]"));
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to delete User 1?");
		lblAreYouSure.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblAreYouSure, "cell 4 0");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_switch(-1);
			}
		});
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnDelete, "cell 2 2 2 1");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_switch(0);
			}
		});
		
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnCancel, "cell 6 2");
		pack();
	}
	
	/**
	 * Will set the popup invisible, and then return to the appropriate screen
	 * @param i represents the panel to switch back to: -1 = delete, 0 = cancel
	 */
	protected void panel_switch(int i) {
		setVisible(false);
		dispose();
		if(i == -1)
			parent.getCardlayout().show(parent.getCards(), "profile");
		if(i == 0)
			parent.getCardlayout().show(parent.getCards(), "editprofile");
	}

}
