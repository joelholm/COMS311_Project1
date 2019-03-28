
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

			//update the values
			RBFixup(newNode);
			//updateNode(null);
		}
		size++;
	}
	
	//update this node and this node's parents
	void updateNode(Node n) {
		

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






