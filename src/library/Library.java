package library;
import Books.Books;
import borrower.Borrower;

import java.util.HashMap;

public class Library {
	HashMap<Integer, Books> bookList; 
	HashMap<Integer, Borrower> borrowerList;
	
	public Library() {
		bookList = new HashMap<Integer, Books>();
		borrowerList = new HashMap<Integer, Borrower>();
	}
		
	public void addBook(Books book) {
		bookList.put(book.getId(), book);
	}
	
	public void removeBook(Books book) {
		bookList.remove(book.getId());
	}	

	public void addBorrower(Books borrower) {
		bookList.put(borrower.getId(), borrower);
	}
	
	public void removeBorrower(Borrower borrower) {
		bookList.remove(borrower.getId());
	}
	
	public void borrowBook(Integer bookId, Integer borrowerId) {
		if(borrowerList.containsKey(borrowerId) && bookList.containsKey(bookId)) {
			Books book = bookList.get(bookId);
			book.borrowBook();
		}
		else {
			
		}
	}
	
	public void returnBook(Integer bookId) {
		if(bookList.containsKey(bookId)) {
			Books book = bookList.get(bookId);
			book.returnBook();
		}
	}
}
