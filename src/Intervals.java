/**
 * The intervals class represents a collection of intervals.
 * @author Colin Ishman, Joel Holm
 *
 */
public class Intervals {
	
	RBTree T;
	int idNum;
	
	public Intervals() {
		idNum = 1;
		T = new RBTree();
	}
	
	public void intervalInsert(int a, int b) {
		//check that a <= b
		if( a > b ) {
			throw new IllegalArgumentException("a and b must follow a <= b");
		}
		//insert into RBTree
		T.insertNode(new Node(a, 1, new Endpoint(a,1), idNum));
		T.insertNode(new Node(b, -1, new Endpoint(b,-1), idNum));
		idNum++;
	}
	
	public boolean intervalDelete(int intervalID) {
		//don't do
		return true;
	}
	
	public int findPOM() {
		if( T.root == null ) {
			return 0;
		}
		return T.getRoot().getEmax().getValue();
	}
	
	public RBTree getRBTree() {
		return T;
	}
}
