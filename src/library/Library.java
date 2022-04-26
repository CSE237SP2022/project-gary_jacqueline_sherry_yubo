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
		try {
		bookList.remove(book.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("The book does not in the library right now");
		}
	}	

	// This method is to add borrower who borrowed books from library
	public void addBorrower(Borrower borrower) {
		borrowerList.put(borrower.getId(), borrower);
	}
	
	
	// This method is to remove borrower who returned books to library
	public void removeBorrower(Borrower borrower) {
		try {
		borrowerList.remove(borrower.getId());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("This borrower has already returned the book.");
		}
	}
	
	
	// This method is to record which book is borrowed.
	public void borrowBook(Integer bookId, Integer borrowerId) {
		  if(borrowerList.containsKey(borrowerId) && bookList.containsKey(bookId)) {
		   Books book = bookList.get(bookId);
		   Borrower borrower = borrowerList.get(borrowerId);
		   book.borrowBook(borrowerId);
		   borrower.borrowBook(bookId);
		   System.out.println(borrower.getName() + " borrows " + book.getName());
		  }
		  else {
			  System.out.println("Books are not on the list.");
		  }
		 }
	
	public HashMap<Integer, Books> getBooksList() {
		return bookList;
	}
	
	public HashMap<Integer, Borrower> getBorrowerList() {
		return borrowerList;
	}
	
	// This method is to record the book has been returned.
	public void returnBook(Integer bookId, Integer borrowerId) {
		  if(bookList.containsKey(bookId) && borrowerList.containsKey(borrowerId) && borrowerList.get(borrowerId).getBookBorrowed().contains(bookId)) {
		   Books book = bookList.get(bookId);
		   book.returnBook();
		   borrowerList.get(borrowerId).returnBook(bookId);
		   System.out.println(book.getName() + " is returned");
		  } 
		  else {
			  System.out.println("Books are not being returned.");
		  }
		 }
}
