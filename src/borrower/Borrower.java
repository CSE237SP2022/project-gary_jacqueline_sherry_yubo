package borrower;
import java.util.Set;
import java.util.HashSet;

public class Borrower {
	int borrowerId; // a unique borrower id
	String name;    // name of a borrower
	Set<Integer> bookBorrowed;
	
	/*
	 * Constructor
	 */
	public Borrower(int id, String name) {
		this.borrowerId = id;
		this.name = name;
		this.bookBorrowed = new HashSet<>();
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
	
	/*
	 * borrowBook: record the book that the user borrowed
	 */
	public void borrowBook(int bookId) {
		bookBorrowed.add(bookId);
	}
	
	public void returnBook(int bookId) {
		if(bookBorrowed.contains(bookId))
			bookBorrowed.remove(bookId);
	}
	
	/*
	 * getBookBorrowed get the books that the user borrowed
	 */
	public Set<Integer> getBookBorrowed() {
		return bookBorrowed;
	}
	
	public void printInfo() {
    	System.out.println("Name: "+name);
    	System.out.println("id: "+borrowerId);
    	System.out.println("number of books borrowed: "+bookBorrowed.size());
    	if(bookBorrowed.size()>0)
    		for(int i : bookBorrowed)
    			System.out.println("book borrowed: "+i);
	}
}
