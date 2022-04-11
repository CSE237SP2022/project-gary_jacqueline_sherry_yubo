package library;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import java.util.Map;

import org.junit.jupiter.api.Test;

import Books.Books;
import borrower.Borrower;
import library.Library;
import java.util.HashMap;
class LibraryTest {


	@Test
	void testAddBook() {

		
		Books book1 = new Books("Surviving Savannah", 124, "English", 10, false, "Patti Callahan");
		Books book2 = new Books("A Million Things", 123, "English", 15, false, "Emily Spurr");
		Books book3 = new Books("The Code Breaker", 125, "English", 20, false, "Walter Isaacson");
		Books book4 = new Books("The Night Watchman", 127, "English", 5, false, "Louise Erdrich");
		Library Mylibrary = new Library();
		Mylibrary.addBook(book4);
		Mylibrary.addBook(book3);
		Mylibrary.addBook(book2);
		Mylibrary.addBook(book1);
//		

		assertTrue(Mylibrary.bookList.containsValue(book4));
		assertTrue(Mylibrary.bookList.containsValue(book3));
		assertTrue(Mylibrary.bookList.containsValue(book2));
		assertTrue(Mylibrary.bookList.containsValue(book1));
		assertTrue(Mylibrary.bookList.size()==4);
		
	}
	
	
	@Test
	void testRemoveBook() {
//		Books book1 = new Books("The Promise", 211, "English", 10, false, "Damon Galgut");
//		Books book2 = new Books("The Last Cuentista", 238, "English", 15, false, "Donna Barba Higuera");
//		Books book3 = new Books("The Book of Lost Names", 285, "English", 20, false, "Kristin Harmel");
		Books book4 = new Books("George and Lizzie", 290, "Germany", 5, false, "Nancy Pearl");
		Library Mylibrary = new Library();
		
		Mylibrary.addBook(book4);
		Mylibrary.removeBook(book4);

		assertTrue(Mylibrary.bookList.size()==0);
//		assertTrue(Mylibrary.bookList == null);
		
		
	}
	
	@Test
	void testAddBorrower() {
		Borrower person1 = new Borrower(2, "Jackson");
		Borrower person2 = new Borrower(8, "Warren");
		Borrower person3 = new Borrower(9, "Julie");
		Borrower person4 = new Borrower(11, "David");
		Library Mylibrary = new Library();
		
		Mylibrary.addBorrower(person1);
		Mylibrary.addBorrower(person2);
		Mylibrary.addBorrower(person3);
		Mylibrary.addBorrower(person4);
		assertTrue(Mylibrary.borrowerList.containsValue(person1));
		assertTrue(Mylibrary.borrowerList.containsValue(person2));
		assertTrue(Mylibrary.borrowerList.containsValue(person3));
		assertTrue(Mylibrary.borrowerList.containsValue(person4));
		assertTrue(Mylibrary.borrowerList.containsKey(2));
		assertTrue(Mylibrary.borrowerList.containsKey(8));
		assertTrue(Mylibrary.borrowerList.containsKey(9));
		assertTrue(Mylibrary.borrowerList.containsKey(11));
		assertTrue(Mylibrary.borrowerList.size()==4);
		
	}
	
	@Test
	void testRemoveBorrower() {
		Borrower person1 = new Borrower(21, "Jennie");
		Borrower person2 = new Borrower(23, "Kathaway");
		Borrower person3 = new Borrower(10, "Elina");
		Borrower person4 = new Borrower(15, "Ada");
		Library Mylibrary = new Library();
		Mylibrary.addBorrower(person1);
		Mylibrary.addBorrower(person2);
		Mylibrary.addBorrower(person3);
		Mylibrary.addBorrower(person4);
		Mylibrary.removeBorrower(person4);
		Mylibrary.removeBorrower(person3);
		Mylibrary.removeBorrower(person2);
		Mylibrary.removeBorrower(person1);
		
		assertTrue(Mylibrary.borrowerList.size()==0);

	}
	
	@Test
	void testBorrowBook() {
		Borrower person1 = new Borrower(2, "Jackson");
		Books book1 = new Books("The Promise", 211, "English", 10, false, "Damon Galgut");
		Library Mylibrary = new Library();
		Mylibrary.addBook(book1);
		Mylibrary.addBorrower(person1);
		Mylibrary.borrowBook(book1.getId(), person1.getId());
		assertTrue(book1.isBorrowed() == true);
		
		
		
	}
	
	@Test
	void testReturnBook() {
		Borrower person1 = new Borrower(2, "Jackson");
		Books book1 = new Books("The Promise", 211, "English", 10, false, "Damon Galgut");
		Library Mylibrary = new Library();
		Mylibrary.addBook(book1);
		Mylibrary.addBorrower(person1);
		Mylibrary.borrowBook(book1.getId(), person1.getId());
		Mylibrary.returnBook(book1.getId());
		assertTrue(book1.isBorrowed() == false);
	}
	
	

}
