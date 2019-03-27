
public class Intervals {
	
	RBTree T;
	int idNum;
	
	public Intervals() {
		idNum = 1;
	}
	
	public void intervalInsert(int a, int b) {
		
		//new Node( , 1, idNum)
		//new Node( , -1, idNum) 
		
		//insert into RBTree
		
		idNum++;
	}
	
	public boolean intervalDelete(int intervalID) {
		//don't do
		return true;
	}
	
	public int findPOM() {		
		return T.root.maxval;
	}
	
	public RBTree getRBTree() {
		return T;
	}
}
