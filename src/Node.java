
public class Node {
	
	int key, p, val, maxval;
	Node parent, left, right;
	Endpoint emax, endPoint;
	int color; //0 = black, 1 = red
	boolean isNil;
	
	//constructor
	public Node(int key, int p, Endpoint endPoint) {
		this.key = key;
		this.p = p;
		this.endPoint = endPoint;
		this.color = 1;
		isNil = false;
	}
	
	//nil constructor
	public Node() {
		isNil = true;
		color = 0;
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
		if( isNil ) {
			return 0;
		} else {
			return left.getVal() + val + right.getVal();
		}
	}
	
	public int getMaxVal() {
		//TODO:
		
		return 0;
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
