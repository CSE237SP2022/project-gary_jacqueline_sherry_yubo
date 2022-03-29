package Books;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BooksClassTest {

	@Test
	void ConstructorAndAccessTest() {
		String name = "";
		String author = "";
		String language = "";
		int id = 0;
		int borrowCount = 0;
		boolean isBorrowed = false;
		Books book1 = new Books(name, id, language, borrowCount, isBorrowed, author);
		assertEquals(name, book1.getName());
		assertEquals(author, book1.getAuthor());
		assertEquals(language, book1.getLanguage());
		assertEquals(borrowCount, book1.getBorrowCount());
		assertEquals(isBorrowed, book1.isBorrowed());
		assertEquals(id, book1.getId());
	}
	
	@Test
	void AccessAndModifyTest() {
		String newName = "A";
		String newAuthor = "B";
		int newId = 1;
		String newLanguage = "C";
		Books book1 = new Books("", 0, "", 1, false, "");
		book1.setName(newName);
		book1.setAuthor(newAuthor);
		book1.setLanguage(newLanguage);
		book1.setId(newId);
		assertEquals(newAuthor, book1.getAuthor());
		assertEquals(newId, book1.getId());
		assertEquals(newName, book1.getName());
		assertEquals(newLanguage, book1.getLanguage());
	}

}
