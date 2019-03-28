import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RBTreeTest {

	@Test
	void test() {
		
		RBTree rb = new RBTree();
		
		int id = 1;
		
		
		/////////////Tree example/////////////
		Node nodes[] = new Node[12];
		for( int i = 1; i <= 12; i++ ) {
			nodes[i - 1] = new Node(i,-1,null,id++);
			rb.insertNode(nodes[i - 1]);
		}
		
		
		//Testing height
		assertEquals( 4, rb.getHeight() );
		
		//Testing Position of nodes
		Node nodePos2 = rb.root.left, nodePos6 = rb.root.right.left, 
			 nodePos7 = rb.root.right.left.right, nodePos1 = rb.root.left.left,
			 nodePos12 = rb.root.right.right.right.right;
		assertEquals(nodePos2.key, 2);
		assertEquals(nodePos6.key, 6);
		assertEquals(nodePos7.key, 7);
		assertEquals(nodePos1.key, 1);
		assertEquals(nodePos12.key, 12);
		//////////////////////////////////////
	}
	
	@Test
	void rotationTest() {
		RBTree rb = new RBTree();
		int id = 1;
		rb.insertNode(new Node(41, 1, null, id++));
		rb.insertNode(new Node(38, 1, null, id++));
		rb.insertNode(new Node(31, 1, null, id++));
		rb.insertNode(new Node(12, 1, null, id++));
		rb.insertNode(new Node(19, 1, null, id++));
		rb.insertNode(new Node(8, 1, null, id++));
		
		assertEquals(rb.root.right.key, 38);
		assertEquals(rb.root.key, 41);
		//assertEquals(rb.root.left.key, 19);
		
	}

}
