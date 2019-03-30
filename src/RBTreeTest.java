import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RBTreeTest extends RBTree{

	/**
	 * 	Things to add still
	 * 
	 * 	1.Update height of RBTree
	 *  2.Test intervals
	 *  3.General Testing
	 *  4.Fix null pointer when endpoint is null
	 */
	

	@Test
	void testRBInsert() {
		RBTree rb = new RBTree();
		int id = 1;
		Node nodes[] = new Node[12];
		nodes[0] = new Node(1,1, new Endpoint(1,1),id++);
		nodes[1] = new Node(2,1,new Endpoint(2,1),id++);
		nodes[2] = new Node(3,1,new Endpoint(3,1),id++);
		nodes[3] = new Node(4,1,new Endpoint(4,1),id++);
		nodes[4] = new Node(5,-1,new Endpoint(5,-1),id++);
		nodes[5] = new Node(6,-1,new Endpoint(6,-1),id++);
		nodes[6] = new Node(7,-1,new Endpoint(7,-1),id++);
		nodes[7] = new Node(8,1,new Endpoint(8,1),id++);
		nodes[8] = new Node(9,-1,new Endpoint(9,-1),id++);
		nodes[9] = new Node(10,-1,new Endpoint(10,-1),id++);
		nodes[10] = new Node(11,1,new Endpoint(11,1),id++);
		nodes[11] = new Node(12,-1,new Endpoint(12,-1),id++);
		for( int i = 1; i <= 12; i++ ) {
			rb.insertNode(nodes[i - 1]);
		}
		
		//Testing height
		assertEquals( 5, rb.getHeight() );
		
		//Testing Position of nodes
		Node nodePos2 = rb.root.left, nodePos6 = rb.root.right.left, 
			 nodePos7 = rb.root.right.left.right, nodePos1 = rb.root.left.left,
			 nodePos12 = rb.root.right.right.right.right;
		//testing tree structure
		assertEquals(nodePos2.key, 2);
		assertEquals(nodePos6.key, 6);
		assertEquals(nodePos7.key, 7);
		assertEquals(nodePos1.key, 1);
		assertEquals(nodePos12.key, 12);
		
		//testing emax and maxval
		int treeEmax = rb.root.getEmax().value;
		assertEquals( treeEmax == 4 , true);
		assertEquals( rb.root.getMaxVal(), 4);
		
		//test height
		assertEquals(rb.getSize(), 12);
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
		
		//rb.printTree(rb.root);
		
		assertEquals(rb.root.right.key, 41);
		assertEquals(rb.root.key, 38);
		assertEquals(rb.root.left.key, 19);
		
		//Case 1 right child
		RBTree rb2 = new RBTree();
		id = 1;
		rb2.insertNode(new Node(5, 1, null, id++));
		rb2.insertNode(new Node(6, 1, null, id++));
		rb2.insertNode(new Node(3, 1, null, id++));
		rb2.insertNode(new Node(4, 1, null, id++));
		
		assertEquals(rb2.root.left.color, 1);
		
		//Case 1 left child
		RBTree rb3 = new RBTree();
		id = 1;
		rb3.insertNode(new Node(5, 1, null, id++));
		rb3.insertNode(new Node(6, 1, null, id++));
		rb3.insertNode(new Node(3, 1, null, id++));
		rb3.insertNode(new Node(2, 1, null, id++));
				
		assertEquals(rb3.root.left.color, 1);
		
		//Case 2 & 3 left subtree
		RBTree rb4 = new RBTree();
		id = 1;
		rb4.insertNode(new Node(5, 1, null, id++));
		rb4.insertNode(new Node(3, 1, null, id++));
		rb4.insertNode(new Node(4, 1, null, id++));
					
		assertEquals(rb4.root.left.color, 0);
		assertEquals(rb4.root.right.color, 0);
		assertEquals(rb4.root.key, 4);
		
		//Case 2 & 3 right subtree
		RBTree rb5 = new RBTree();
		id = 1;
		rb5.insertNode(new Node(3, 1, null, id++));
		rb5.insertNode(new Node(5, 1, null, id++));
		rb5.insertNode(new Node(4, 1, null, id++));
							
		assertEquals(rb5.root.left.color, 0);
		assertEquals(rb5.root.right.color, 0);
		assertEquals(rb5.root.key, 4);
		
		//Testing the height
		RBTree rb6 = new RBTree();
		id = 1;
		rb6.insertNode(new Node(10, 1, new Endpoint(1,1), id++));
		assertEquals(rb6.height, 1);
		rb6.insertNode(new Node(6, 1, new Endpoint(2,1), id++));
		assertEquals(rb6.height, 2);
		rb6.insertNode(new Node(15, 1, new Endpoint(3,1), id++));
		rb6.insertNode(new Node(12, 1, new Endpoint(4,1), id++));
		rb6.insertNode(new Node(18, 1, new Endpoint(5,1), id++));
		assertEquals(rb6.height, 3);
		rb6.insertNode(new Node(20, 1, new Endpoint(6,1), id++));
		assertEquals(rb6.height, 4);
		rb6.insertNode(new Node(3, 1, new Endpoint(6,1), id++));
		rb6.insertNode(new Node(4, 1, new Endpoint(6,1), id++));
		rb6.insertNode(new Node(1, 1, new Endpoint(6,1), id++));
		assertEquals(rb6.height, 4);
		rb6.insertNode(new Node(21, 1, new Endpoint(6,1), id++));
		assertEquals(rb6.height, 4);
		
		rb.printTree(rb6.root);
		
	}

	
	@Test
	void testUpdateSingleNode() {
		int id = 0;
		Node n = new Node(6, 1, new Endpoint(6,1), id++);
		Node left = new Node ( 4, 1, new Endpoint(4,1), id++);
		Node right = new Node ( 7, 1, new Endpoint(7,1), id++);
		Node nilNode = new Node();
		Node np = new Node(8, -1, new Endpoint(8,-1), id++);
		n.left = left;
		n.right = right;
		left.right = left.left = right.right = right.left = nilNode;
		np.left = n;
		np.right = nilNode;
		updateSingleNode(left);
		updateSingleNode(right);
		updateSingleNode(n);
		updateSingleNode(np);
		
		//testing self max
		assertEquals(4,left.emax.getValue());
		assertEquals(1,left.getMaxVal());
		//testing right max
		assertEquals(7,n.emax.getValue());
		assertEquals(3,n.getMaxVal());
		//testing left max
		assertEquals(7, np.emax.getValue());
		assertEquals(3, np.getMaxVal());
	}
}
