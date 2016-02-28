package gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 * The main frame of the program
 * @author tmcvick
 *
 */
public class MyFrame extends JFrame {
	
	//for use when switching settings panels
	private CardLayout cardlayout;
	private JPanel SettingsTab;
	private JPanel cardBackgroundPanel;
	
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel FavoritesTab = new FavoritesPanel();
		tabbedPane.addTab("Favorites", null, FavoritesTab, "Locally Favorited Music\n");
		
		JPanel LibraryTab = new LibraryPanel();
		tabbedPane.addTab("Library", null, LibraryTab, null);
		
		cardBackgroundPanel = new JPanel();
		cardBackgroundPanel.setLayout(new CardLayout());
		cardlayout = (CardLayout) cardBackgroundPanel.getLayout();
		
		
		//Set up the multiple settings panels
		SettingsTab = new SettingsPanel(this);
		JPanel ServerTab = ((SettingsPanel) SettingsTab).getChangeServerPanel();
		JPanel RestrictionTab = ((SettingsPanel) SettingsTab).getRestrictionsPanel();
		JPanel ProfileTab = ((SettingsPanel) SettingsTab).getProfilePanel();
		JPanel EditProfileTab = ((SettingsPanel) SettingsTab).getEditProfilePanel();
		JPanel EditRestrictionsTab = ((SettingsPanel) SettingsTab).getEditRestrictionsPanel();
		JPanel ProfileInfoTab = ((SettingsPanel) SettingsTab).getProfileInfoPanel();
		
		
		cardBackgroundPanel.add(SettingsTab, "home");
		cardBackgroundPanel.add(ServerTab, "server");
		cardBackgroundPanel.add(RestrictionTab, "restrict");
		cardBackgroundPanel.add(ProfileTab, "profile");
		cardBackgroundPanel.add(EditProfileTab, "editprofile");
		cardBackgroundPanel.add(EditRestrictionsTab, "editrestriction");
		cardBackgroundPanel.add(ProfileInfoTab, "indvprofile");
		
		tabbedPane.addTab("Settings", null, cardBackgroundPanel, null);
		
		getContentPane().add(tabbedPane, "name_265974599776111");
		
		
		pack();
		
	}
	
	/**
	 * 
	 * @return the layout of the settings tab
	 */
	public CardLayout getCardlayout() {
		return cardlayout;
	}
	
	/**
	 * 
	 * @return the home settings panel (with the options)
	 */
	public SettingsPanel getHome()
	{
	return (SettingsPanel) SettingsTab;
	}
	
	/**
	 * 
	 * @return the background panel for the settings tab
	 */
	public JPanel getCards()
	{
		return cardBackgroundPanel;
	}
	private static final long serialVersionUID = 1L;
}
