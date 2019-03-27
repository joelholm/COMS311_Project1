
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

			while(x != null) {
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
			updateNode(null);
		}
		size++;
		System.out.println("Added " + newNode.key);
	}
	
	//update this node and this node's parents
	void updateNode(Node n) {
		

	}
}
