package library;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import java.util.Map;

import org.junit.jupiter.api.Test;

import Books.Books;
import borrower.Borrower;

class LibraryTest {
	
	

	@Test
	void addBook() {

	
		Books book1 = new Books("Surviving Savannah", 124, "English", 10, false, "Patti Callahan");
		Books book2 = new Books("A Million Things", 123, "English", 15, false, "Emily Spurr");
		Books book3 = new Books("The Code Breaker", 125, "English", 20, false, "Walter Isaacson");
		Books book4 = new Books("The Night Watchman", 127, "English", 5, false, "Louise Erdrich");
		
	
		Map<Integer, Books> bookList = new HashMap<>();
		bookList.put(book1.getId(),book1);
		bookList.put(book2.getId(), book2);
		bookList.put(book3.getId(), book3);
		bookList.put(book4.getId(), book4);
		assertTrue(bookList.size()==4);
		
	}
	
	
	@Test
	void removeBook() {
		Books book1 = new Books("The Promise", 211, "English", 10, false, "Damon Galgut");
		Books book2 = new Books("The Last Cuentista", 238, "English", 15, false, "Donna Barba Higuera");
		Books book3 = new Books("The Book of Lost Names", 285, "English", 20, false, "Kristin Harmel");
		Books book4 = new Books("George and Lizzie", 290, "Germany", 5, false, "Nancy Pearl");
		Map<Integer, Books> bookList = new HashMap<>();
		bookList.put(book1.getId(),book1);
		bookList.put(book2.getId(), book2);
		bookList.put(book3.getId(), book3);
		bookList.put(book4.getId(), book4);
		
		bookList.remove(book1.getId());
		bookList.remove(book4.getId());
		assertTrue(bookList.size()==2);
		
		
	}
	
	@Test
	void addBorrower() {
		Borrower person1 = new Borrower(2, "Jackson");
		Borrower person2 = new Borrower(8, "Warren");
		Borrower person3 = new Borrower(9, "Julie");
		Borrower person4 = new Borrower(11, "David");
		
		Map<Integer, Borrower> borrowerList = new HashMap<>();
		
		borrowerList.put(person1.getId(),person1);
		borrowerList.put(person2.getId(),person2);
		borrowerList.put(person3.getId(),person3);
		borrowerList.put(person4.getId(),person4);
		
		assertTrue(borrowerList.size()==4);
		
	}
	
	@Test
	void removeBorrower() {
		Borrower person1 = new Borrower(21, "Jennie");
		Borrower person2 = new Borrower(23, "Kathaway");
		Borrower person3 = new Borrower(10, "Elina");
		Borrower person4 = new Borrower(15, "Ada");
		
		Map<Integer, Borrower> borrowerList = new HashMap<>();
		
		borrowerList.put(person1.getId(),person1);
		borrowerList.put(person2.getId(),person2);
		borrowerList.put(person3.getId(),person3);
		borrowerList.put(person4.getId(),person4);
		
		borrowerList.remove(person1.getId());
		borrowerList.remove(person3.getId());
		borrowerList.remove(person4.getId());
		
		assertTrue(borrowerList.size()==1);
	}
	
	@Test
	void borrowBook() {
		
	}
	
	

}
