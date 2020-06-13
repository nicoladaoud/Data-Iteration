package testing;



import static org.junit.jupiter.api.Assertions.*;

import javax.swing.tree.DefaultMutableTreeNode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TreeInit;

class TreeInitTest {

	TreeInit tree = new TreeInit();
	DefaultMutableTreeNode myTree = tree.getTree();
	
	@Test
	/**
	 * Check if the tree is corrupted.
	 */
	void test_empty_tree() {
		TreeInit testTree = new TreeInit();
		
		assertEquals(null, testTree.root);
	}
	
	@Test
	/**
	 * Check if the tree has correct default folders.
	 */
	void test_default_folders() {
		
		assertEquals(3, myTree.getChildCount());
	}
	
	@Test
	/**
	 * Check if the tree has correct children numbers.
	 */
	void test_default_children() {
		
		assertEquals(5,myTree.getLeafCount());
	}

}
