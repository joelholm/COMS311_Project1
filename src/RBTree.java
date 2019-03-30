
public class RBTree {
	
	Node root, nilNode;
	int size, height, hFlag;
	
	public RBTree() {
		size = 0;
		height = 0;
		nilNode = new Node();
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node getNILNode() {
		return nilNode;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void insertNode(Node newNode) {
		hFlag = 0;
		if( newNode == null ) {
			throw new NullPointerException("Inserted node is null");
		}
		//if tree is empty, make this node the root
		if( size == 0 ) {
			root = newNode;
			newNode.parent = nilNode;
			newNode.left = nilNode;
			newNode.right = nilNode;
			newNode.color = 1;
			height = 1;
		} else {
			//otherwise, start at root and climb down tree until a spot is found
			Node y = nilNode;
			Node x = root;
			int count = 1;

			while(x != nilNode) {
				y = x;
				if(newNode.key < x.key)
					x = x.left;
				else
					x = x.right;
				count++;
			}
			if(height < count) {
				height = count;
				hFlag = 1;
			}
				
			newNode.parent = y;
			if(newNode.key < y.key)
				y.left = newNode;
			else
				y.right = newNode;
			newNode.left = nilNode;
			newNode.right = nilNode;
			newNode.color = 0;

			//fix up tree
			RBFixup(newNode);
			
			//update the values
			recUpdateNode(newNode);
			
		}
		size++;
	}
	

	/**
	 * This is a recursive function which starts at a leaf node and steps up the tree until the root.
	 * Every node this function passes will have it's val, maxval, and emax values updated by 
	 * the helper function updateSingleNode(Node n).  There is the possibility of a rotation
	 * when adding a node to the tree.  If this happens there will be one node pushed out of 
	 * the path this algorithm takes.  That is why the if( n.marked ) line is included.
	 * This will update that node which would have been missed before.
	 * 
	 * @param n	is the node which was added to the tree.  This should be a leaf
	 */
	public void recUpdateNode(Node n) {
		//update this node
		updateSingleNode(n);
		
		//if this node is marked, update the parent node's other child.
		if( n.marked ) {
			//unmark both children of this node's parent
			n.parent.right.marked = n.parent.left.marked = false;
			//find and update the other child
			if( n.parent.left == n ) {
				updateSingleNode(n.parent.right);
			} else if( n.parent.right == n ){
				updateSingleNode(n.parent.left);
			} else {
				throw new NullPointerException("checking whether left/right child went wrong");					//can delete if it works
			}
		}
		
		//if this is not the root, go to the next parent
		if( n.parent != nilNode ) {
			recUpdateNode(n.parent);
		}
	}
	
	/**
	 * This function updates the val, maxval, emax values in Node n.
	 * 
	 * @param n is the node which will be updated
	 */
	public void updateSingleNode(Node n) {
		//update val
		n.val = n.left.getVal() + n.p + n.right.getVal();

		//update eval and emax
		int case1 = n.left.getMaxVal();
		int case2 = n.left.getVal() + n.p;
		int case3 = n.left.getVal() + n.p + n.right.getMaxVal();
		if( case1 >= case2 && case1 >= case3 ) {
			//case 1
			n.maxval = case1;
			//if the left node is the nilNode, make emax this node
			if( n.left.isNil ) {
				n.emax = n.getEndpoint();
			} else {
				//otherwise get emax of left
				n.emax = n.left.getEmax();
			}
		} else if( case2 >= case1 && case2 >= case3 ) {
			//case 2
			n.maxval = case2;
			n.emax = n.getEndpoint();
		} else if( case3 >= case1 && case3 >= case2 ) {
			//case 3
			n.maxval = case3;
			//if the left node is the nilNode, make emax this node
			if( n.right.isNil ) {
				n.emax = n.getEndpoint();
			} else {
				//otherwise get emax of right
				n.emax = n.right.getEmax();
			}
		}
	}
	
	/**
	 * This function recursively prints all children nodes of the input node.  
	 * Mostly meant for debugging.
	 * 
	 * @param n is the node to start the recursive print
	 */
	public void printTree(Node n) {
		if( !n.isNil ) {
			System.out.print("Key: " + n.key + " " + n.color + "\t\tleft.key: " + n.left.key + "\t\tright.key: " + n.right.key + "\n");
			printTree(n.left);
			printTree(n.right);
		}
	}
	
	
	public void RBFixup(Node n) {
		while(n.parent.color == 0) {
			if(n.parent == n.parent.parent.left) {
				Node y = n.parent.parent.right;
				if(y.color == 0) {
					n.parent.color = 1;
					y.color = 1;
					n.parent.parent.color = 0;
					n = n.parent.parent;
				}
				else {
					if(n == n.parent.right) {
						n = n.parent;
						leftRotate(n);
					}
					n.parent.color = 1;
					n.parent.parent.color = 0;
					//mark n and n's grandparent, because in the end these two nodes will be the children
					//marking will be handled in recUpdateNode
					n.marked = true;
					n.parent.parent.marked = true;
					rightRotate(n.parent.parent);
					if(hFlag == 1)
						height--;
				}
			}
			else {
				Node y = n.parent.parent.left;
				if(y.color == 0) {
					n.parent.color = 1;
					y.color = 1;
					n.parent.parent.color = 0;
					n = n.parent.parent;
				}
				else {
					if(n == n.parent.left) {
						n = n.parent;
						rightRotate(n);
					}
					n.parent.color = 1;
					n.parent.parent.color = 0;
					//mark n and n's grandparent, because in the end these two nodes will be the children
					//marking will be handled in recUpdateNode
					n.marked = true;
					n.parent.parent.marked = true;
					leftRotate(n.parent.parent);
					if(hFlag == 1)
						height--;
				}
			}
		}
		root.color = 1;
	}
	
	public void leftRotate(Node n) {
		Node y = n.right;
		n.right = y.left;
		if(!y.left.isNil)
			y.left.parent = n;
		y.parent = n.parent;
		if(n.parent.isNil)
			root = y;
		else if(n == n.parent.left)
			n.parent.left = y;
		else
			n.parent.right = y;
		y.left = n;
		n.parent = y;
	}
	
	public void rightRotate(Node n) {
		Node y = n.left;
		n.left = y.right;
		if(!y.right.isNil)
			y.right.parent = n;
		y.parent = n.parent;
		if(n.parent.isNil)
			root = y;
		else if(n == n.parent.right)
			n.parent.right = y;
		else
			n.parent.left = y;
		y.right = n;
		n.parent = y;
	}
}




