package borrower;

public class Borrower {
	int borrowerId;
	String name;
	
	public Borrower(int id, String name) {
		this.borrowerId = id;
		this.name = name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
}