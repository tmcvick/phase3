package team8;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class MyFrame extends JFrame {
	private CardLayout cardlayout;
	private JPanel SettingsTab;
	private JPanel settingsTab;
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel FavoritesTab = new FavoritesPanel();
		tabbedPane.addTab("Favorites", null, FavoritesTab, "Locally Favorited Music\n");
		
		JPanel LibraryTab = new LibraryPanel();
		tabbedPane.addTab("Library", null, LibraryTab, null);
		
		settingsTab = new JPanel();
		settingsTab.setLayout(new CardLayout());
		cardlayout = (CardLayout) settingsTab.getLayout();
		
		SettingsTab = new SettingsPanel(this);
		JPanel ServerTab = ((SettingsPanel) SettingsTab).getChangeServerPanel();
		JPanel RestrictionTab = ((SettingsPanel) SettingsTab).getRestrictionsPanel();
		JPanel ProfileTab = ((SettingsPanel) SettingsTab).getProfilePanel();
		JPanel EditProfileTab = ((SettingsPanel) SettingsTab).getEditProfilePanel();
		JPanel EditRestrictionsTab = ((SettingsPanel) SettingsTab).getEditRestrictionsPanel();
		JPanel ProfileInfoTab = ((SettingsPanel) SettingsTab).getProfileInfoPanel();
		
		
		settingsTab.add(SettingsTab, "home");
		settingsTab.add(ServerTab, "server");
		settingsTab.add(RestrictionTab, "restrict");
		settingsTab.add(ProfileTab, "profile");
		settingsTab.add(EditProfileTab, "editprofile");
		settingsTab.add(EditRestrictionsTab, "editrestriction");
		settingsTab.add(ProfileInfoTab, "indvprofile");
		
		tabbedPane.addTab("Settings", null, settingsTab, null);
		getContentPane().add(tabbedPane, "name_265974599776111");
		
		
		pack();
		
	}
	public CardLayout getCardlayout() {
		return cardlayout;
	}
	
	public SettingsPanel getHome()
	{
	return (SettingsPanel) SettingsTab;
	}
	
	public JPanel getCards()
	{
		return settingsTab;
	}
	private static final long serialVersionUID = 1L;
}
