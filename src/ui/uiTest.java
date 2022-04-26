package ui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import java.io.*;

import org.junit.jupiter.api.*;



class uiTest {
	
	private static ByteArrayOutputStream outContent;
	private static final PrintStream originalOut = System.out;

	@BeforeEach
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	}
	
	@AfterAll
	public static void cleanUpStreams() {
	    System.setOut(new PrintStream(originalOut));
	    System.out.println("Current books:");
		UI.getBooksList();
	    System.out.println("\nCurrent borrowers:");
		UI.getBorrowersList();
	}
	
	@AfterEach
	public void cleanOutput() {
		try {
			outContent.flush();
		} catch (IOException e) {
			
		}
	}
	
	private static Scanner scan;

	@Test
	void addBookFromInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("0,0,0,0\n1,1,1,1".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.addBookFromInput(scan);
		assertTrue(outContent.toString().contains("successfully"));
		UI.addBookFromInput(scan);
		assertTrue(outContent.toString().contains("successfully"));
		assertTrue(UI.lib.getBooksList().containsKey(0));
		assertTrue(UI.lib.getBooksList().containsKey(1));
		scan.close();
	}
	
	@Test
	void addDuplicateBookFromInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("1,0,1,1".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.addBookFromInput(scan);
		assertTrue(outContent.toString().contains("duplicate"));
		assertTrue(UI.lib.getBooksList().containsKey(0));
		assertEquals("0", UI.lib.getBooksList().get(0).getName());
		scan.close();
	}
	
	@Test
	void addInvalidBookFromInput() {
		int size = UI.lib.getBooksList().size();
		ByteArrayInputStream in = new ByteArrayInputStream("1,x,1,1\n1,1,1\n1,1,1,1,1".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.addBookFromInput(scan);
		assertTrue(outContent.toString().contains("invalid"));
		UI.addBookFromInput(scan);
		assertTrue(outContent.toString().contains("invalid"));
		UI.addBookFromInput(scan);
		assertTrue(outContent.toString().contains("invalid"));
		assertEquals(size, UI.lib.getBooksList().size());
	}
	
	@Test
	void addBookFromFile() {
		// All cases with invalid book info are tested in this single function
		int size = UI.lib.getBooksList().size();
		ByteArrayInputStream in = new ByteArrayInputStream("C:\\Users\\steve\\OneDrive - Washington University in St. Louis\\courses\\CSE 237S\\project-gary_jacqueline_sherry_yubo\\addBook.csv".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.addBooksFromFile(scan);
		assertTrue(outContent.toString().contains("successfully"));
		assertTrue(outContent.toString().contains("fails"));
		assertTrue(outContent.toString().contains("invalid"));
		assertTrue(outContent.toString().contains("duplicate"));
		assertEquals(size+1, UI.lib.getBooksList().size());
	}
	
	@Test
	void addBorrowerFromInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("0,0\n1,1".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.addBorrowerFromInput(scan);
		assertTrue(outContent.toString().contains("successfully"));
		UI.addBorrowerFromInput(scan);;
		assertTrue(outContent.toString().contains("successfully"));
		assertTrue(UI.lib.getBorrowerList().containsKey(0));
		assertTrue(UI.lib.getBorrowerList().containsKey(1));
		scan.close();
	}
	
	@Test
	void addDuplicateBorrowerFromInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("1,0".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.addBorrowerFromInput(scan);
		assertTrue(outContent.toString().contains("duplicate"));
		assertTrue(UI.lib.getBooksList().containsKey(0));
		assertEquals("0", UI.lib.getBorrowerList().get(0).getName());
		scan.close();
	}
	
	@Test
	void addInvalidBorrowerFromInput() {
		int size = UI.lib.getBorrowerList().size();
		ByteArrayInputStream in = new ByteArrayInputStream("1,x\n1,1,1\n1".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.addBorrowerFromInput(scan);
		assertTrue(outContent.toString().contains("invalid"));
		UI.addBorrowerFromInput(scan);
		assertTrue(outContent.toString().contains("invalid"));
		UI.addBorrowerFromInput(scan);
		assertTrue(outContent.toString().contains("invalid"));
		assertEquals(size, UI.lib.getBorrowerList().size());
	}
	
	@Test
	void testAddBorrowerFromFile() {
		// All cases with invalid borrower info are tested in this single function
		int size = UI.lib.getBorrowerList().size();
		ByteArrayInputStream in = new ByteArrayInputStream("C:\\Users\\steve\\OneDrive - Washington University in St. Louis\\courses\\CSE 237S\\project-gary_jacqueline_sherry_yubo\\addBorrower.csv".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.addBorrowerFromFile(scan);
		assertTrue(outContent.toString().contains("successfully"));
		assertTrue(outContent.toString().contains("fails"));
		assertTrue(outContent.toString().contains("invalid"));
		assertTrue(outContent.toString().contains("duplicate"));
		assertEquals(size+1, UI.lib.getBorrowerList().size());
	}
	
	@Test
	void borrowBook() {
		ByteArrayInputStream in = new ByteArrayInputStream("0\n0".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.borrowBook(scan);
		assertTrue(outContent.toString().contains("borrows"));
	}
	
	@Test
	void borrowBookWithInvalidBorrower() {
		ByteArrayInputStream in = new ByteArrayInputStream("10\n0".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.borrowBook(scan);
		assertTrue(outContent.toString().contains("not"));
	}
	
	@Test
	void borrowInvalidBookWithBorrower() {
		ByteArrayInputStream in = new ByteArrayInputStream("0\n10".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.borrowBook(scan);
		assertTrue(outContent.toString().contains("not"));
	}
	
	@Test
	void returnInvalidBook() {
		ByteArrayInputStream in = new ByteArrayInputStream("0\n0".getBytes());
		System.setIn(in);
		scan = new Scanner(System.in);
		UI.returnBook(scan);		
		assertTrue(outContent.toString().contains("not"));
	}

}
