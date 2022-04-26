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

		//test add books 
		Books book1 = new Books("Surviving Savannah", 124, "English", 10, false, "Patti Callahan");
		Books book2 = new Books("A Million Things", 123, "English", 15, false, "Emily Spurr");
		Books book3 = new Books("The Code Breaker", 125, "English", 20, false, "Walter Isaacson");
		Books book4 = new Books("The Night Watchman", 127, "English", 5, false, "Louise Erdrich");
		Library Mylibrary = new Library();
		Mylibrary.addBook(book4);
		Mylibrary.addBook(book3);
		Mylibrary.addBook(book2);
		Mylibrary.addBook(book1);
		
		assertTrue(Mylibrary.bookList.containsValue(book4));
		assertTrue(Mylibrary.bookList.containsValue(book3));
		assertTrue(Mylibrary.bookList.containsValue(book2));
		assertTrue(Mylibrary.bookList.containsValue(book1));
		assertTrue(Mylibrary.bookList.size()==4);
		
		
		Books book5 = new Books("The Library Book", 4124, "English", 30, false, "Susan Orlean");
		Books book6 = new Books("The Midnight Library", 4123, "English", 35, false, "Matt Haig");
		Books book7 = new Books("Summer Hours at the Robbers Library", 125, "English", 40, false, "Sue Halpern");
		Books book8 = new Books("A Christmas Carol", 4127, "English", 45, false, "Charles Dickens");
		Books book9 = new Books("Little Women", 4223, "English", 50, false, "Louisa May Alcott");
		Books book10 = new Books("Animal Farm", 4224, "English", 55, false, "George Orwell");
		Books book11 = new Books("The Call of the Wild", 4225, "English", 60, false, "Jack London");
		Books book12 = new Books("20,000 Leagues Under the Sea", 4226, "English",65, false, "Jules Verneh");
		Library Mylibrary2 = new Library();
		Mylibrary2.addBook(book5);
		Mylibrary2.addBook(book6);
		Mylibrary2.addBook(book7);
		Mylibrary2.addBook(book8);
		Mylibrary2.addBook(book9);
		Mylibrary2.addBook(book10);
		Mylibrary2.addBook(book11);
		Mylibrary2.addBook(book12);
		
		assertTrue(Mylibrary2.bookList.containsValue(book5));
		assertTrue(Mylibrary2.bookList.containsValue(book6));
		assertTrue(Mylibrary2.bookList.containsValue(book7));
		assertTrue(Mylibrary2.bookList.containsValue(book8));
		assertTrue(Mylibrary2.bookList.containsValue(book9));
		assertTrue(Mylibrary2.bookList.containsValue(book10));
		assertTrue(Mylibrary2.bookList.containsValue(book11));
		assertTrue(Mylibrary2.bookList.containsValue(book12));
		assertTrue(Mylibrary2.bookList.size()==8);
		
		Library Mylibrary3 = new Library();
		assertTrue(Mylibrary3.bookList.size()==0);
	}
	
	
	@Test
	//test remove book, add one book first
	void testRemoveBook() {
		
		Books book13 = new Books("George and Lizzie", 290, "Germany", 5, false, "Nancy Pearl");
		Library Mylibrary = new Library();
		
		Mylibrary.addBook(book13);
		Mylibrary.removeBook(book13);

		assertTrue(Mylibrary.bookList.size()==0);
		
		Books book14 = new Books("The Wind in the Willows", 4315, "English", 2, false, "Kenneth Grahame");
		Books book15 = new Books("The Last of the Mohicans", 3451, "English", 5, false, "James Fenimore Cooper");
		Books book16 = new Books("Heidi", 54673, "English", 7, false, "Johanna Spyri");
		Books book17 = new Books("The Count of Monte Cristo", 76534, "English", 9, false, "Alexandre Dumas");
		Books book18 = new Books("The Old Man and the Sea", 2353, "English", 100, false, "Ernest Hemingway");
		Library Mylibrary2 = new Library();
		Mylibrary2.addBook(book14);
		Mylibrary2.addBook(book15);
		Mylibrary2.addBook(book16);
		Mylibrary2.addBook(book17);
		Mylibrary2.addBook(book18);
		Mylibrary2.removeBook(book14);
		Mylibrary2.removeBook(book15);
		
		assertTrue(Mylibrary2.bookList.size()==3);
		
		Mylibrary2.removeBook(book17);
		Mylibrary2.removeBook(book18);
		assertTrue(Mylibrary2.bookList.size()==1);
		
		
	}
	
	@Test
	//test if the system can add a borrower.
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
		
		
		Borrower person5 = new Borrower(33, "Gary");
		Borrower person6 = new Borrower(81, "Jacky");
		Borrower person7 = new Borrower(95, "Jacqueline");
		Borrower person8 = new Borrower(10, "Alex");
		Borrower person9 = new Borrower(24, "Jay");
		Borrower person10 = new Borrower(82, "Susie");
		Borrower person11 = new Borrower(92, "Anna");
		Borrower person12 = new Borrower(67, "Ada");
		Library Mylibrary2 = new Library();
		
		Mylibrary2.addBorrower(person5);
		Mylibrary2.addBorrower(person6);
		Mylibrary2.addBorrower(person7);
		Mylibrary2.addBorrower(person8);
		Mylibrary2.addBorrower(person9);
		Mylibrary2.addBorrower(person10);
		Mylibrary2.addBorrower(person11);
		Mylibrary2.addBorrower(person12);
		assertTrue(Mylibrary2.borrowerList.containsValue(person5));
		assertTrue(Mylibrary2.borrowerList.containsValue(person6));
		assertTrue(Mylibrary2.borrowerList.containsValue(person7));
		assertTrue(Mylibrary2.borrowerList.containsValue(person8));
		assertTrue(Mylibrary2.borrowerList.containsValue(person9));
		assertTrue(Mylibrary2.borrowerList.containsValue(person10));
		assertTrue(Mylibrary2.borrowerList.containsValue(person11));
		assertTrue(Mylibrary2.borrowerList.containsValue(person12));
		assertTrue(Mylibrary2.borrowerList.containsKey(33));
		assertTrue(Mylibrary2.borrowerList.containsKey(81));
		assertTrue(Mylibrary2.borrowerList.containsKey(95));
		assertTrue(Mylibrary2.borrowerList.containsKey(10));
		assertTrue(Mylibrary2.borrowerList.containsKey(24));
		assertTrue(Mylibrary2.borrowerList.containsKey(82));
		assertTrue(Mylibrary2.borrowerList.containsKey(92));
		assertTrue(Mylibrary2.borrowerList.containsKey(67));
		assertTrue(Mylibrary2.borrowerList.size()==8);
		
	}
	
	@Test
	//test if the system can remove the borrower
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
		
		Borrower person_a = new Borrower(102, "Gary");
		Borrower person_b = new Borrower(103, "Jay");
		Library Mylibrary1 = new Library();
		Mylibrary1.addBorrower(person_a);
		Mylibrary1.addBorrower(person_b);
		Mylibrary1.removeBorrower(person_a);
		assertTrue(Mylibrary1.borrowerList.size()==1);

	}
	
	@Test
	//test if a borrower can borrow a book
	void testBorrowBook() {
		Borrower person1 = new Borrower(2, "Jackson");
		Books book1 = new Books("The Promise", 211, "English", 10, false, "Damon Galgut");
		Library Mylibrary = new Library();
		Mylibrary.addBook(book1);
		Mylibrary.addBorrower(person1);
		Mylibrary.borrowBook(book1.getId(), person1.getId());
		assertTrue(book1.isBorrowed() == true);
		assertTrue(book1.getBorrowCount() == 11);
		
		Borrower person2 = new Borrower(3, "George");
		Borrower person3 = new Borrower(3, "George");
		Books book2 = new Books("The Wind in the Willows", 4315, "English", 2, false, "Kenneth Grahame");
		Books book3 = new Books("The Last of the Mohicans", 3451, "English", 5, false, "James Fenimore Cooper");
		Books book4 = new Books("The Code Breaker", 125, "English", 20, false, "Walter Isaacson");
		Books book5 = new Books("20,000 Leagues Under the Sea", 4226, "English",65, false, "Jules Verneh");
		Library library = new Library();
		library.addBook(book2);
		library.addBook(book4);
		library.addBook(book5);
		library.addBorrower(person2);
		library.addBorrower(person3);
		library.borrowBook(book2.getId(), person2.getId());
		library.borrowBook(book4.getId(), person2.getId());
		library.borrowBook(book5.getId(), person3.getId());
		assertTrue(book2.isBorrowed() == true);
		assertTrue(book4.isBorrowed() == true);
		assertTrue(book3.isBorrowed() == false);
		assertTrue(book5.isBorrowed() == true);
	

		
		
		
	}
	
	@Test
	//test if the system can return the book successfully
	void testReturnBook() {
		Borrower person1 = new Borrower(2, "Jackson");
		Books book1 = new Books("The Promise", 211, "English", 10, false, "Damon Galgut");
		Library Mylibrary = new Library();
		Mylibrary.addBook(book1);
		Mylibrary.addBorrower(person1);
		Mylibrary.borrowBook(book1.getId(), person1.getId());
		Mylibrary.returnBook(book1.getId(), person1.getId());
		assertTrue(book1.isBorrowed() == false);
		assertTrue(book1.getBorrowCount() == 11);
		
		Borrower person2 = new Borrower(102, "Gary");
		Borrower person4 = new Borrower(22, "Josh");
		Books book2 = new Books("The Last of the Mohicans", 3451, "English", 5, false, "James Fenimore Cooper");
		Books book3 = new Books("The Code Breaker", 125, "English", 20, false, "Walter Isaacson");
		Books book4 = new Books("20,000 Leagues Under the Sea", 4226, "English",65, false, "Jules Verneh");
		Library library = new Library();
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBorrower(person2);
		library.addBorrower(person4);
		library.borrowBook(book4.getId(), person4.getId());
		library.returnBook(book4.getId(), person4.getId());
		library.borrowBook(book2.getId(), person2.getId());
		library.returnBook(book2.getId(), person2.getId());
		library.borrowBook(book3.getId(), person2.getId());
		assertTrue(book2.isBorrowed() == false);
		assertTrue(book3.isBorrowed() == true);
		assertTrue(book4.isBorrowed() ==false);
		
	}
	
	

}
