package borrower;

public class Borrower {
	int borrowerId; // a unique borrower id
	String name;    // name of a borrower
	
	/*
	 * Constructor:
	 * parameter:
	 * 	id: a unique borrower id
	 * 	name: name of the borrower
	 * return:
	 * 	None
	 */
	public Borrower(int id, String name) {
		this.borrowerId = id;
		this.name = name;
	}
	
	/*
	 * setName: reset name for the borrower
	 * parameter:
	 * 	newName: new name for the borrower
	 * return:
	 * 	None
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/*
	 * getName: get name for the borrower
	 * parameter:
	 * 	None
	 * return:
	 * 	name of the borrower
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * getId: get id for the borrower
	 * parameter:
	 * 	None
	 * return:
	 * 	id of the borrower
	 */
	public int getId() {
		return this.borrowerId;
	}
}
