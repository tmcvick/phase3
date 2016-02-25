package team8;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import gui.LoginFrame;
import gui.MyFrame;

public class Main {

	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		LoginFrame l = new LoginFrame();
		l.setVisible(true);
		MyFrame w = new MyFrame();
		l.getLogin(w);
				
		
	}

}
