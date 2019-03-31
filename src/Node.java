/**
 * The Node class represents the nodes of the red-black tree.
 * @author Colin Ishman, Joel Holm
 *
 */

public class Node {
	
	int key, p, val, maxval;
	Node parent, left, right;
	Endpoint emax, endPoint;
	int color; //0 = red, 1 = black
	int id;
	boolean isNil;
	boolean marked;
	
	//standard node constructor
	public Node(int key, int p, Endpoint endPoint, int id) {
		if( endPoint == null ) {
			endPoint = new Endpoint(0,0);
		}
		this.key = key;
		this.p = p;
		this.endPoint = endPoint;
		this.color = 0;
		this.id = id;
		isNil = false;
		marked = false;
	}
	
	//nil node constructor
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
	
	public int getVal() {
		return val;
	}
	
	public int getMaxVal() {
		return maxval;	
	}
	
	public Endpoint getEndpoint() {
		return endPoint;
	}
	
	public Endpoint getEmax() {
		return emax;
	}
	
	public int getColor() {
		return color;
	}
}
