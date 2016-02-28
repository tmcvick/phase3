package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class which displays the different album restriction level
 * @author tmcvick
 *
 */
public class DisplayRestrictionsPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private MyFrame parent;

	/**
	 * 
	 *creates a new panel
	 * @param parent2 the Main Frame of the program (to switch panels)
	 */
	public DisplayRestrictionsPanel(MyFrame parent2) {
		parent = parent2;
		
		
		setLayout(new MigLayout("", "[75][150,grow][150,grow][75]", "[25][50][100,grow][50][100,grow]"));
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panel_switch(0);
			}
		});
		
		add(btnBack, "cell 0 0,alignx left,aligny top");
		
		JLabel lblRestriction = new JLabel("Restrictions:");
		lblRestriction.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblRestriction, "cell 1 0,alignx right,aligny bottom");
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel_switch(1);
			}
		});
		
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(btnEdit, "cell 3 0,alignx right,aligny top");
		
		JLabel lblLevel1 = new JLabel("Level 1:");
		lblLevel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblLevel1, "cell 1 1,aligny bottom");
		
		JLabel lblLevel2 = new JLabel("Level 2:");
		lblLevel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblLevel2, "cell 2 1,alignx left,aligny bottom");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 2,grow");
		
		JList<String> listAlbums1 = new JList<String>();
		listAlbums1.setEnabled(false);
		listAlbums1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listAlbums1.setModel(new AbstractListModel<String>() {
			
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Album A", "Album B", "Album C"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listAlbums1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 2 2,grow");
		
		JList<?> listAlbums2 = new JList<Object>();
		listAlbums2.setEnabled(false);
		listAlbums2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setViewportView(listAlbums2);
		
		JLabel lblLevel3 = new JLabel("Level 3:");
		lblLevel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblLevel3, "cell 1 3,aligny bottom");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 4,grow");
		
		JList<String> listAlbums3 = new JList<String>();
		listAlbums3.setEnabled(false);
		listAlbums3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listAlbums3.setModel(new AbstractListModel<String>() {
			
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Album D", "Album E"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_2.setViewportView(listAlbums3);
	}
	
	
	
	/**
	 * switches to the appropriate panel
	 * @param i the panel to switch to; 0 = settings home, 1 = edit restrictions
	 */
	private void panel_switch(int i) {
		
		if(i == 0)
		{
			parent.getCardlayout().show(parent.getCards(), "home");
	
		}
		if(i ==1)
			parent.getCardlayout().show(parent.getCards(),  "editrestriction");
	}
	
	/**
	 * returns the main frame of the program
	 */
	public MyFrame getParent(){
		return parent;
	}
	
}
