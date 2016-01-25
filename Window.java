import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame
{
    private PlayPanel playpanel;
    private RetrieveButton retrieve;
    private JTextField url;
    private JTextField object_num;
    private CList container_list;
    private DefaultListModel listModel;
    private JScrollPane scrollPane;
    private int[] Ids;

    public Window()
    {
	playpanel = new PlayPanel();
	url = new JTextField("http://127.0.0.1:5001/upnp/control/content_directory", 60);

	object_num = new JTextField("0", 5);
	retrieve = new RetrieveButton("Retrieve", this);
	retrieve.addActionListener(retrieve);


	container_list = new CList(this);
	listModel = new DefaultListModel();
	container_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	container_list.addListSelectionListener(container_list);
	container_list.setLayoutOrientation(JList.VERTICAL);
	scrollPane = new JScrollPane(container_list);


	JPanel top = new JPanel(new FlowLayout());
	top.add(new JLabel("URL: "));
	top.add(url);
	top.add(new JLabel("Object ID: "));
	top.add(object_num);
	top.add(retrieve);

	add(top, BorderLayout.NORTH);
	add(scrollPane, BorderLayout.WEST);
	add(playpanel, BorderLayout.EAST);

	setTitle("Simple Media Player");
	setLocation(100, 100);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	pack();

    }

    /*this will submit the change to the UMS and the change the list*/
    public void submit_change()
    {
	//I want to keep an array where the index on the list is the
	//object ID Number.  but when i print the list, i can just combine
	//the object title to the object ID
	//listModel.addElement(jadsngf)
	//listModel.removeAllElements()



	//first I need to send the URL and object ID to the UMS
	//parseInt for the Object ID

	//then I will receive the List, remove all elemens,
	//and add new list into the listmodel
	//combine two strings from each (title and pbject ID)

	//I will then refresh the scrollPane
	scrollPane.revalidate();
	scrollPane.repaint();
    }

    /* this will change the Object ID to the ID of index on the list*/
    public void change_boxes(int index)
    {
	int ID = Ids[index];
	
	object_num.setText(Integer.toString(ID));
    }
}
