package team8;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import gui.LoginFrame;

public class Main {

	public static void main(String[] args) {
		
		/* My Attempt at downloading a file. Doesn't work but can't figure out why, giving up.
		try {
		URLConnection conn = new URL("http://127.0.0.1:5001/get/122/Track+1.mp3").openConnection();
	    InputStream is = conn.getInputStream();
	    FileOutputStream outstream = new FileOutputStream(new File("Alegro.mp3"));
	    byte[] buffer = new byte[4096];
	    int len;
	    while ((len = is.read(buffer)) > -1) {
	    	System.out.println("LOOPING");
	        outstream.write(buffer, 0, len);
	    }
	    is.close();
	    outstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} */
		
		
		//Set look and feel
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
		//open authentication frame
		LoginFrame l = new LoginFrame();
		l.setVisible(true);
		
	}

}
