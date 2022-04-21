package borrower;
import java.util.LinkedList;
import java.util.List;

public class Borrower {
	int borrowerId; // a unique borrower id
	String name;    // name of a borrower
	
	/*
	 * Constructor
	 */
	public Borrower(int id, String name) {
		this.borrowerId = id;
		this.name = name;
	}
	
	/*
	 * setName: reset name for the borrower
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/*
	 * getName: get name for the borrower
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * getId: get id for the borrower
	 */
	public int getId() {
		return this.borrowerId;
	}
}
