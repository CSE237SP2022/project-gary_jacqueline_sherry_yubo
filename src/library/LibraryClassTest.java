package library;
import library.Library;
import Books.Books;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class LibraryClassTest {

	@Test
	void testAddBook() {
		String name = "";
		String author = "";
		String language = "";
		int id = 0;
		int borrowCount = 0;
		boolean isBorrowed = false;
		
		Books book1 = new Books(name, id, language, borrowCount, isBorrowed, author);
		Library lib = new Library();
		lib.addBook(book1);
		HashMap<Integer, Books> bookList = lib.getBooksList();
		assert(bookList.containsKey(id));
		assert(book1 == bookList.get(id));
	}

	@Test
	void testRemoveBook() {
		String name = "";
		String author = "";
		String language = "";
		int id = 0;
		int borrowCount = 0;
		boolean isBorrowed = false;
		
		Books book1 = new Books(name, id, language, borrowCount, isBorrowed, author);
		Library lib = new Library();
		lib.addBook(book1);
		HashMap<Integer, Books> bookList = lib.getBooksList();
		assert(bookList.containsKey(id));
		assert(book1 == bookList.get(id));
		lib.removeBook(book1);
		assert(!bookList.containsKey(id));
	}
	
}
