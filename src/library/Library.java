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
	
	// This method is to store books into library
	public void addBook(Books book) {
		bookList.put(book.getId(), book);
	}
	
	// This method is to remove books from library
	public void removeBook(Books book) {
		bookList.remove(book.getId());
	}	

	public void addBorrower(Borrower borrower) {
		borrowerList.put(borrower.getId(), borrower);
	}
	
	public void removeBorrower(Borrower borrower) {
		borrowerList.remove(borrower.getId());
	}
	
	public void borrowBook(Integer bookId, Integer borrowerId) {
		if(borrowerList.containsKey(borrowerId) && bookList.containsKey(bookId)) {
			Books book = bookList.get(bookId);
			Borrower borrower = borrowerList.get(borrowerId);
			book.borrowBook();
			System.out.println(borrower.getName() + " borrows " + book.getName());
		}
		else {
			
		}
	}
	
	public HashMap<Integer, Books> getBooksList() {
		return bookList;
	}
	
	public HashMap<Integer, Borrower> getBorrowerList() {
		return borrowerList;
	}
	
	public void returnBook(Integer bookId) {
		if(bookList.containsKey(bookId)) {
			Books book = bookList.get(bookId);
			book.returnBook();
			System.out.println(book.getName() + " is returned");
		}
	}
}
