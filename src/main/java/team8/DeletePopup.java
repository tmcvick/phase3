package team8;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletePopup extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private EditProfilePanel parent;
private ProfileDisplayPanel grand;
	public DeletePopup(EditProfilePanel p, ProfileDisplayPanel g) {
		parent = p;
		grand = g;
		
		getContentPane().setLayout(new MigLayout("", "[][][][][][][][][]", "[][][]"));
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to delete User 1?");
		lblAreYouSure.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblAreYouSure, "cell 4 0");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_switch(-1);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnDelete, "cell 2 2 2 1");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_switch(0);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnCancel, "cell 6 2");
	}
	protected void panel_switch(int i) {
		this.setVisible(false);
		if(i == -1)
			grand.setVisible(true);
		if(i == 0)
			parent.setVisible(true);
	}

}
