import javax.swing.tree.DefaultMutableTreeNode;

public class TreeInit {
	public DefaultMutableTreeNode root;
	
	public TreeInit() {
		
	}
	
	public DefaultMutableTreeNode getTree() {
		root = new DefaultMutableTreeNode("Appliance");
		
		// ChildNode
		DefaultMutableTreeNode liv = new DefaultMutableTreeNode("Living Room");

		DefaultMutableTreeNode kit = new DefaultMutableTreeNode("Kitchen");
		DefaultMutableTreeNode bat = new DefaultMutableTreeNode("Bathroom");
		root.add(liv);
		root.add(kit);
		root.add(bat);

		DefaultMutableTreeNode item1 = new DefaultMutableTreeNode("TV");
		DefaultMutableTreeNode item2 = new DefaultMutableTreeNode("Digital Watch");
		DefaultMutableTreeNode item3 = new DefaultMutableTreeNode("Air Conditioner");

		liv.add(item1);
		liv.add(item2);
		liv.add(item3);
		
		return root;
	}

}
