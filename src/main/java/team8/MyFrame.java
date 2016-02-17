package team8;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	public MyFrame() {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel FavoritesTab = new FavoritesPanel();
		tabbedPane.addTab("Favorites", null, FavoritesTab, "Locally Favorited Music\n");
		
		JPanel LibraryTab = new LibraryPanel();
		tabbedPane.addTab("Library", null, LibraryTab, null);
		
		JPanel SettingsTab = new JPanel();
		tabbedPane.addTab("Settings", null, SettingsTab, null);
		getContentPane().setLayout(groupLayout);
	}
	private static final long serialVersionUID = 1L;
}
