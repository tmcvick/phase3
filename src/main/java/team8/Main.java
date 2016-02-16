package team8;

public class Main {

	public static void main(String[] args) {
		LoginFrame l = new LoginFrame();
		l.setVisible(true);
		while(l.login());
		//l.setVisible(false);
		MyFrame w = new MyFrame();
		w.setVisible(true);
	}

}
