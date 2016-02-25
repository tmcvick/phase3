package gui;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MyJTreeData extends JTree
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyJTreeData()
	{
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Albums");
        DefaultMutableTreeNode parent;
        
            
        DefaultTreeModel model= new DefaultTreeModel(root);
        model.setRoot(null);
        JTree tree = new JTree(root);
        
        parent = new DefaultMutableTreeNode("Led Zeppelin IV");
        root.add(parent);
        parent.add(new DefaultMutableTreeNode("Misty Mountain Hop"));
        parent.add(new DefaultMutableTreeNode("Four Sticks"));
        parent.add(new DefaultMutableTreeNode("Whole Lotta Love"));
        parent.add(new DefaultMutableTreeNode("Ramble On"));

        parent = new DefaultMutableTreeNode("Abbey Road");
        root.add(parent);
        parent.add(new DefaultMutableTreeNode("Here Comes the Sun"));
        parent.add(new DefaultMutableTreeNode("Come Together"));
        parent.add(new DefaultMutableTreeNode("Maxwell's Silver Hammer"));
        parent.add(new DefaultMutableTreeNode("Get Back"));

        parent = new DefaultMutableTreeNode("The Dark Side of the Moon");
        root.add(parent);
        parent.add(new DefaultMutableTreeNode("Great Gig in the Sky"));
        parent.add(new DefaultMutableTreeNode("Money"));
        parent.add(new DefaultMutableTreeNode("Time"));
        parent.add(new DefaultMutableTreeNode("Brain Damage"));
        
        tree.setModel(model);
	}
}
