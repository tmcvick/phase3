import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RetrieveButton extends JButton implements ActionListener
{
    private Window w;

    public RetrieveButton(String label, Window wd)
    {
	super(label);
	this.w = wd;
	this.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
	w.submit_change();
    }
}
