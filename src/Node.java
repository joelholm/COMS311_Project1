
public class Node {
	
	int key, p, val, maxval;
	Node parent, left, right;
	Endpoint emax, endPoint;
	int color; //0 = red, 1 = black
	int id;
	boolean isNil;
	boolean marked;
	
	//constructor
	public Node(int key, int p, Endpoint endPoint, int id) {
		this.key = key;
		this.p = p;
		this.endPoint = endPoint;
		this.color = 1;
		this.id = id;
		isNil = false;
		marked = false;
	}
	
	//nil constructor
	public Node() {
		isNil = true;
		color = 0;
		val = 0;
		maxval = 0;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public int getKey() {
		return key;
	}
	
	public int getP() {
		return p;
	}
	
	public int getVal() {
		return val;
	}
	
	public int getMaxVal() {
		//TODO:
		//If maximum is in left subtree
		//return left.maxval;
		//If maximum is at current node
		//return left.val + p;
		//If maximum is in right subtree
		return left.maxval + p + right.maxval;
	}
	
	public Endpoint getEndpoint() {
		return endPoint;
	}
	
	public Endpoint getEmax() {
		//TODO:
		
		
		return null;
	}
	
	public int getColor() {
		return color;
	}
}
