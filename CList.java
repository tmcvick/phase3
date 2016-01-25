import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class CList extends JList implements ListSelectionListener
{
    private Window w;

    public CList(Window wd)
    {
	this.w = wd;
    }

    public void valueChanged(ListSelectionEvent e)
    {
	w.change_boxes(this.getSelectedIndex());
    }

}
