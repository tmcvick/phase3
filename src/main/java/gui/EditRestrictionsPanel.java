package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class that represents the editing restrictions panel
 * @author tmcvick
 *
 */
public class EditRestrictionsPanel extends JPanel{
	//Allows us to reference the cardlayout	 
	private MyFrame parent;
	
	/**
	 * creates a new editrestrictionpanel
	 * @param p the panel that switches to this
	 */
	public EditRestrictionsPanel(DisplayRestrictionsPanel p) {
		
		//absolute layout
		setLayout(null);
		parent = p.getParent();
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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
		
		//the textfields which represent the albums' restriction level
		textFieldA = new JTextField();
		textFieldA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldA.setText("1");
		textFieldA.setBounds(202, 40, 58, 34);
		add(textFieldA);
		textFieldA.setColumns(10);
		
		textFieldB = new JTextField();
		textFieldB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldB.setText("1");
		textFieldB.setBounds(203, 83, 57, 34);
		add(textFieldB);
		textFieldB.setColumns(10);
		
		textFieldC = new JTextField();
		textFieldC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldC.setText("1");
		textFieldC.setBounds(203, 134, 57, 34);
		add(textFieldC);
		textFieldC.setColumns(10);
		
		textFieldD = new JTextField();
		textFieldD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldD.setText("3");
		textFieldD.setBounds(203, 182, 57, 34);
		add(textFieldD);
		textFieldD.setColumns(10);
		
		textFieldE = new JTextField();
		textFieldE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldE.setText("3");
		textFieldE.setBounds(203, 227, 57, 34);
		add(textFieldE);
		textFieldE.setColumns(10);
	}

	/**
	 * switches back to the previous panel (display restrictions)
	 * @param i unused
	 */
	private void panel_switch(int i) {
	
		if(i == 0)
			parent.getCardlayout().show(parent.getCards(), "restrict");
		
	}

	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldC;
	private JTextField textFieldD;
	private JTextField textFieldE;
}
