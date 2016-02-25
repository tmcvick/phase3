package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditRestrictionsPanel extends JPanel{
	//Allows use to reference the cardlayout	 
	private MyFrame parent;
	
	public EditRestrictionsPanel(DisplayRestrictionsPanel p) {
		setLayout(null);
		parent = p.getParent();
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_switch(0);
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_switch(0);
			}
		});
		btnSubmit.setBounds(351, 11, 89, 23);
		add(btnSubmit);
		
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
		btnCancel.setBounds(10, 11, 89, 23);
		add(btnCancel);
		
		JLabel lblEditRestrictions = new JLabel("Edit Restrictions");
		lblEditRestrictions.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditRestrictions.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditRestrictions.setBounds(109, 15, 232, 14);
		add(lblEditRestrictions);
		
		JLabel lblAlbumA = new JLabel("Album A");
		lblAlbumA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlbumA.setBounds(133, 50, 73, 14);
		add(lblAlbumA);
		
		JLabel lblAlbumB = new JLabel("Album B");
		lblAlbumB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlbumB.setBounds(133, 93, 73, 14);
		add(lblAlbumB);
		
		JLabel lblAlbumC = new JLabel("Album C");
		lblAlbumC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlbumC.setBounds(133, 144, 73, 14);
		add(lblAlbumC);
		
		JLabel lblAlbumD = new JLabel("Album D");
		lblAlbumD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlbumD.setBounds(133, 192, 73, 14);
		add(lblAlbumD);
		
		JLabel lblAlbumE = new JLabel("Album E");
		lblAlbumE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlbumE.setBounds(133, 237, 73, 14);
		add(lblAlbumE);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setText("1");
		textField.setBounds(202, 40, 58, 34);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setText("1");
		textField_1.setBounds(203, 83, 57, 34);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setText("1");
		textField_2.setBounds(203, 134, 57, 34);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setText("3");
		textField_3.setBounds(203, 182, 57, 34);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setText("3");
		textField_4.setBounds(203, 227, 57, 34);
		add(textField_4);
		textField_4.setColumns(10);
	}

	private void panel_switch(int i) {
	
		if(i == 0)
			parent.getCardlayout().show(parent.getCards(), "restrict");
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
}
