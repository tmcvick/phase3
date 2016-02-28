package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class that represents the panel where a user can change the server
 */
public class ChangeServerPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtFieldOldServer;
	private JTextField txtFieldNewServer;
	private MyFrame parent;
	
	/*
	 * Creates a new instance, with an argument of the Main Frame (to use the layout)
	 */
	public ChangeServerPanel(MyFrame parent2) {
		parent = parent2;
		setLayout(new MigLayout("", "[100][400,grow][100]", "[50][50][50][50][50][50][50]"));
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switch_back();
			}
		});
		add(btnBack, "cell 0 0,alignx left,aligny top");
		
		JLabel lblCurrentServer = new JLabel("Current Server:");
		add(lblCurrentServer, "cell 1 1,alignx center,aligny bottom");
		
		txtFieldOldServer = new JTextField();
		txtFieldOldServer.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldOldServer.setEditable(false);
		txtFieldOldServer.setText("www.fakeserver.com");
		add(txtFieldOldServer, "cell 1 2,alignx center,aligny center");
		txtFieldOldServer.setColumns(50);
		
		JLabel lblEnterNewServer = new JLabel("Enter new server:");
		add(lblEnterNewServer, "cell 1 3,alignx center,aligny bottom");
		
		txtFieldNewServer = new JTextField();
		txtFieldNewServer.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtFieldNewServer, "cell 1 4,growx,aligny center");
		txtFieldNewServer.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//popup will show, and then disappear after a second
				ServerPopup pop = new ServerPopup();
				pop.setVisible(true);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}
				switch_back();
			}
		});
		
		add(btnSubmit, "cell 1 5,alignx center,aligny center");
	}
	
	/*
	 * Will switch the panel showing to the settings home panel
	 */
	private void switch_back()
	{
		parent.getCardlayout().show(parent.getCards(), "home");
	}

}
