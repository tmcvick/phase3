package team8;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayRestrictionsPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SettingsPanel parent;
	
	private EditRestrictionsPanel child;

	public DisplayRestrictionsPanel(SettingsPanel p) {
		parent = p;
		child = new EditRestrictionsPanel(this);
		
		setLayout(new MigLayout("", "[75][150,grow][150,grow][75]", "[25][50][100,grow][50][100,grow]"));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_switch(0);
			}
		});
		add(btnBack, "cell 0 0,alignx left,aligny top");
		
		JLabel lblRestriction = new JLabel("Restrictions:");
		lblRestriction.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblRestriction, "cell 1 0,alignx right,aligny bottom");
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_switch(1);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(btnEdit, "cell 3 0,alignx right,aligny top");
		
		JLabel lblLevel = new JLabel("Level 1:");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblLevel, "cell 1 1,aligny bottom");
		
		JLabel lblLevel_1 = new JLabel("Level 2:");
		lblLevel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblLevel_1, "cell 2 1,alignx left,aligny bottom");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 2,grow");
		
		JList<String> list = new JList<String>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Album A", "Album B", "Album C"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 2 2,grow");
		
		JList<?> list_1 = new JList<Object>();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblLevel_2 = new JLabel("Level 3:");
		lblLevel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblLevel_2, "cell 1 3,aligny bottom");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 4,grow");
		
		JList<String> list_2 = new JList<String>();
		list_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list_2.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Album D", "Album E"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_2.setViewportView(list_2);
	}
	private void panel_switch(int i) {
		setVisible(false);
		if(i == 0)
			parent.setVisible(true);
		if(i ==1)
			child.setVisible(true);
	}

	
}
