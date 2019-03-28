
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
		this.color = 0;
		this.id = id;
		isNil = false;
		marked = false;
	}
	
	//nil constructor
	public Node() {
		isNil = true;
		color = 1;
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
	
	public Node min(Node x) {
		while(!x.left.isNil)
			x = x.left;
		return x;
	}
	
	public Node max(Node x) {
		while(!x.right.isNil)
			x = x.right;
		return x;
	}
	
	public Node successor(Node x) {
		if(!x.right.isNil)
			return min(x.right);
		Node y = x.parent;
		while(!y.isNil && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	public Node predecessor(Node x) {
		if(!x.left.isNil)
			return max(x.left);
		Node y = x.parent;
		while(!y.isNil && x == y.left) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	public int getVal() {
		return val;
	}
	
	public int getMaxVal() {
		//TODO:
		//OR DO YOU LOOK AT THE EMAX NOT MAXVAL
		//If maximum is in left subtree
		if(left.maxval >= maxval)
			return left.maxval;
		//If maximum is in right subtree
		if(right.maxval > maxval)
			return left.maxval + p + right.maxval;
		//If maximum is at current node
		else
			return left.val + p;		
	}
	
	public Endpoint getEndpoint() {
		return endPoint;
	}
	
	public Endpoint getEmax() {
		//TODO:
		//If node has no children or is the max
		if(right.isNil && left.isNil)
			return endPoint;
		//if max is on the left subtree
			//return left.emax
		//if max is on the right subtree
			//return right.emax
		
		return null;
	}
	
	public int getColor() {
		return color;
	}
}
