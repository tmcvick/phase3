package gui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingsPanel extends JPanel {
	private ChangeServerPanel changeServerPanel;
	private DisplayRestrictionsPanel restrictionsPanel;
	private ProfileDisplayPanel profilePanel;
	private DeletePopup deletePopup;
	private EditProfilePanel editProfilePanel;
	private EditRestrictionsPanel editRestrictionsPanel;
	private ProfileInfoPanel profileInfoPanel;
	
	public ChangeServerPanel getChangeServerPanel() {
		return changeServerPanel;
	}

	public DisplayRestrictionsPanel getRestrictionsPanel() {
		return restrictionsPanel;
	}

	public ProfileDisplayPanel getProfilePanel() {
		return profilePanel;
	}
	private ServerPopup serverPopup;
	private MyFrame parent;
	private CardLayout cards;
	
	public SettingsPanel(MyFrame p) {
		parent = p;
		cards = parent.getCardlayout();
		
		changeServerPanel = new ChangeServerPanel(parent);
		restrictionsPanel = new DisplayRestrictionsPanel(parent);
		profilePanel = new ProfileDisplayPanel(parent);
		profileInfoPanel = new ProfileInfoPanel(profilePanel);
		editProfilePanel = new EditProfilePanel(profileInfoPanel);
		editRestrictionsPanel = new EditRestrictionsPanel(restrictionsPanel);
		
		
		setLayout(new MigLayout("", "[200][200][200]", "[50][50][50][50][50][50]"));
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to do?");
		lblWhatWouldYou.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblWhatWouldYou, "cell 1 1,alignx center,aligny center");
		
		JLabel lblChangeTheServer = new JLabel("Change the server");
		lblChangeTheServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				panel_switch(1);
				
			}
		});
		add(lblChangeTheServer, "cell 1 2,alignx center,aligny center");
		
		JLabel lblManageUsers = new JLabel("Manage Users");
		lblManageUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				panel_switch(2);
			}
		});
		add(lblManageUsers, "cell 1 3,alignx center,aligny center");
		
		JLabel lblManageRestrictions = new JLabel("Manage Restrictions");
		lblManageRestrictions.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				panel_switch(3);
			}
		});
		add(lblManageRestrictions, "cell 1 4,alignx center,aligny center");
	}
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void panel_switch(int i)
	{
		
		this.setVisible(false);
		if(i == 1)
		{
			cards.show(parent.getCards(), "server");
			
		}
		else if(i == 2)
			cards.show(parent.getCards(), "profile");
		else if(i == 3)
			cards.show(parent.getCards(), "restrict");
		
	}

	public DeletePopup getDeletePopup() {
		return deletePopup;
	}

	public void setDeletePopup(DeletePopup deletePopup) {
		this.deletePopup = deletePopup;
	}

	public EditProfilePanel getEditProfilePanel() {
		return editProfilePanel;
	}

	public void setEditProfilePanel(EditProfilePanel editProfilePanel) {
		this.editProfilePanel = editProfilePanel;
	}

	public EditRestrictionsPanel getEditRestrictionsPanel() {
		return editRestrictionsPanel;
	}

	public void setEditRestrictionsPanel(EditRestrictionsPanel editRestrictionsPanel) {
		this.editRestrictionsPanel = editRestrictionsPanel;
	}

	public ProfileInfoPanel getProfileInfoPanel() {
		return profileInfoPanel;
	}

	public void setProfileInfoPanel(ProfileInfoPanel profileInfoPanel) {
		this.profileInfoPanel = profileInfoPanel;
	}

	public ServerPopup getServerPopup() {
		return serverPopup;
	}

	public void setServerPopup(ServerPopup serverPopup) {
		this.serverPopup = serverPopup;
	}
}

