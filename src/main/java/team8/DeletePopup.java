package team8;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeletePopup extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private MyFrame parent;

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
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_switch(0);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(btnCancel, "cell 6 2");
		pack();
	}
	protected void panel_switch(int i) {
		setVisible(false);
		dispose();
		if(i == -1)
			parent.getCardlayout().show(parent.getCards(), "profile");
		if(i == 0)
			parent.getCardlayout().show(parent.getCards(), "editprofile");
	}

}
