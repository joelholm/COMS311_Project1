
public class RBTree {
	
	Node root, nilNode;
	int size, height;
	
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
		return height;							//Need to remember to update this
	}
	
	public void insertNode(Node newNode) {
		if( newNode == null ) {
			throw new NullPointerException("Inserted node is null");
		}
		//if tree is empty, make this node the root
		if( size == 0 ) {
			root = newNode;
			newNode.parent = nilNode;
			newNode.left = nilNode;
			newNode.right = nilNode;
		} else {
			//otherwise, start at root and climb down tree until a spot is found
			Node y = nilNode;
			Node x = root;

			while(x != nilNode) {
				y = x;
				if(newNode.val < x.val)
					x = x.left;
				else
					x = x.right;
			}
			newNode.parent = y;
			if(newNode.val < y.val)
				y.left = newNode;
			else
				y.right = newNode;
			newNode.left = nilNode;
			newNode.right = nilNode;
			newNode.color = 1;

			//fix up tree
			RBFixup(newNode);
			
			//update the values
			recUpdateNode(null);
			
		}
		size++;
	}
	
	//update this node and this node's parents until the root node
	//if a rotation occured, two nodes should be marked, one will be hit as this recursive
	//method climbs up the tree, and the other will be the sibling of the hit node
	//This sibling will be updated also because of the rotation.
	public void recUpdateNode(Node n) {
		//update this node
		updateSingleNode(n);
		
		//if this node is marked, update the parent node's other child.
		if( n.marked ) {
			//find the other child
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
	
	public void updateSingleNode(Node n) {
		//update val
		n.val = n.left.getVal() + n.p + n.right.getVal();

		//update eval and emax
		int case1 = n.left.maxval;
		int case2 = n.left.val + n.p;
		int case3 = n.left.val + n.p + n.right.maxval;
		if( case1 >= case2 && case1 >= case3 ) {
			//case 1
			n.maxval = case1;
			//if the left node is the nilNode, make emax this node
			if( n.left.isNil ) {
				n.emax = n.getEndpoint();
			} else {
				//otherwise get endpoint of left
				n.emax = n.left.getEndpoint();
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
				//otherwise get endpoint of right
				n.emax = n.right.getEndpoint();
			}
		}
	}
	
	public void printTree() {
		
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
					rightRotate(n.parent.parent);
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
					leftRotate(n.parent.parent);
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






