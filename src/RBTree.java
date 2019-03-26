
public class RBTree {
	
	Node root, nilNode;
	int size, height;
	
	public RBTree() {
		size = 0;
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
		if( newNode == null ) {
			throw new NullPointerException("Inserted node is null");
		}
		size++;
		//if tree is empty make root
		if( size == 0 ) {
			root = newNode;
			newNode.parent = nilNode;
			newNode.left = nilNode;
			newNode.right = nilNode;
		}
		//otherwise, start at root and climb down tree until a spot is found
		
		//then check validity of tree
		
			//if not valid, go through case 1, 2, or 3
		
		//update the values
		updateNode(null);
		
	}
	
	//update this node and this node's parents
	void updateNode(Node n) {
		
	}
}
