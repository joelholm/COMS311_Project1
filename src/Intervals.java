
public class Intervals {
	
	RBTree T;
	int idNum;
	
	public Intervals() {
		idNum = 1;
	}
	
	public void intervalInsert(int a, int b) {
		//insert into RBTree
		T.insertNode(new Node(a, 1, new Endpoint(a), idNum));
		T.insertNode(new Node(b, -1, new Endpoint(b), idNum));
		idNum++;
	}
	
	public boolean intervalDelete(int intervalID) {
		//don't do
		return true;
	}
	
	public int findPOM() {		
		return T.root.emax.value;
	}
	
	public RBTree getRBTree() {
		return T;
	}
}
