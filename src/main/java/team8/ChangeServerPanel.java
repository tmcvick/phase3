package team8;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeServerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtWwwfakeservercom;
	private JTextField textField;
	private MyFrame parent;
	public ChangeServerPanel(MyFrame parent2) {
		parent = parent2;
		setLayout(new MigLayout("", "[100][400,grow][100]", "[50][50][50][50][50][50][50]"));
		
		JButton btnBack = new JButton("Back");
		add(btnBack, "cell 0 0,alignx left,aligny top");
		
		JLabel lblCurrentServer = new JLabel("Current Server:");
		add(lblCurrentServer, "cell 1 1,alignx center,aligny bottom");
		
		txtWwwfakeservercom = new JTextField();
		txtWwwfakeservercom.setHorizontalAlignment(SwingConstants.CENTER);
		txtWwwfakeservercom.setEditable(false);
		txtWwwfakeservercom.setText("www.fakeserver.com");
		add(txtWwwfakeservercom, "cell 1 2,alignx center,aligny center");
		txtWwwfakeservercom.setColumns(50);
		
		JLabel lblEnterNewServer = new JLabel("Enter new server:");
		add(lblEnterNewServer, "cell 1 3,alignx center,aligny bottom");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		add(textField, "cell 1 4,growx,aligny center");
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
	
	private void switch_back()
	{
		parent.getCardlayout().show(parent.getCards(), "home");
	}

}
