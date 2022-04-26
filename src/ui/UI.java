package ui;
import Books.Books;
import borrower.Borrower;
import library.Library;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class UI {
	// This program use only one Library object
	public static Library lib = new Library();
	
	/*
	 * addBook: a helper function that takes a string array of book information
	 * and create a new book object and add this object to the library object
	 */
	private static Boolean addBook(String bookInfo[]) {
		// parse book info array
		if(bookInfo.length != 4) {
			System.out.println("invalid book info: "+Arrays.toString(bookInfo));
			return false;	
		}
		
		String name = bookInfo[0];
		int id = -1;
		String language = bookInfo[2];
		String author = bookInfo[3];
		
		// convert book id from string to int
		try {
			id = Integer.parseInt(bookInfo[1]);
		} catch (NumberFormatException e) {
			System.out.println("invalid book id: "+bookInfo[1]);
			return false;
		}
		
		// create new book
		Books book = new Books(name, id, language, 0, false, author);
		
		// check if the book exist in the library
		if(lib.getBooksList().containsKey(book.getId())) {
			System.out.println("duplicate book id: "+bookInfo[1]);
			return false;
		}
		
		// add book
		lib.addBook(book);
		System.out.println(name+" added successfully");
		return true;
	}
	
	/*
	 * addBookFromInput: take a scanner object and create a book object based on the user
	 * input and add the book object to the library by calling addBook
	 */
	public static void addBookFromInput(Scanner scan) {
		String info = null;
        System.out.println("Input the info for the book in the form of: name,id,language,author");
        if (scan.hasNextLine()) {
        	info = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }
        addBook(info.split(","));
	}

	/*
	 * addBooksFromFile: take a scanner object and read from the file given by the user
	 * input and create several books object based on the content in the file and add to
	 * the library
	 */
	public static Boolean addBooksFromFile(Scanner scan) {
		// read file path from the console
		String path = null;
        System.out.println("Input the path for the book list");
        if (scan.hasNextLine()) {
            path = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
        	return false;
        }
        
    	// read csv file
        int successCount = 0;
        int failCount = 0;
		String line = null;
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			while((line = reader.readLine()) != null) {
				String item[] = line.split(",");
				if(addBook(item))
					successCount++;
				else
					failCount++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("input file not exist");
			return false;
		} catch (IOException e) {
			System.out.println("IO exception");
			return false;
		}
		
		// print summary
		System.out.println("Add "+successCount+" books successfully");
		System.out.println("Add "+failCount+" books fails");
		return true;
	}
	
	/*
	 * addBorrower: a helper function that takes a string array of borrower information
	 * and create a new borrower object and add this object to the library object
	 */
	private static Boolean addBorrower(String borrowerInfo[]) {
		// parse borrower info array
		if(borrowerInfo.length != 2) {
			System.out.println("invalid borrower info: "+Arrays.toString(borrowerInfo));
			return false;	
		}
		
		String name = borrowerInfo[0];
		int id = -1;
		
		// convert borrowerInfo id from string to int
		try {
			id = Integer.parseInt(borrowerInfo[1]);
		} catch (NumberFormatException e) {
			System.out.println("invalid borrower id: "+borrowerInfo[1]);
			return false;
		}
		
		// create new borrower
		Borrower borrower = new Borrower(id, name);
		
		// check if the borrower exist in the library
		if(lib.getBorrowerList().containsKey(borrower.getId())) {
			System.out.println("duplicate borrower id: "+borrowerInfo[1]);
			return false;
		}
		
		// add borrower
		lib.addBorrower(borrower);
		System.out.println(name+" added successfully");
		return true;
	}
	
	/*
	 * addBorrowerFromInput: take a scanner object and create a borrower object based on the
	 * user input and add the borrower object to the library by calling addBorrower
	 */
	public static void addBorrowerFromInput(Scanner scan) {
		String info = null;
        System.out.println("Input the info for the borrower in the form of: name,id");
        if (scan.hasNextLine()) {
        	info = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }
        addBorrower(info.split(","));
	}
	
	/*
	 * addBorrowerFromFile: take a scanner object and read from the file given by the user
	 * input and create several borrowers object based on the content in the file and add to
	 * the library
	 */
	public static Boolean addBorrowerFromFile(Scanner scan) {
		// read file path from the console
		String path = null;
        System.out.println("Input the path for the borrower list");
        if (scan.hasNextLine()) {
            path = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
        	return false;
        }
        
    	// read csv file
        int successCount = 0;
        int failCount = 0;
		String line = null;
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			while((line = reader.readLine()) != null) {
				String item[] = line.split(",");
				if(addBorrower(item))
					successCount++;
				else
					failCount++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("input file not exist");
			return false;
		} catch (IOException e) {
			System.out.println("IO exception");
			return false;
		}
		
		// print summary
		System.out.println("Add "+successCount+" borrowers successfully");
		System.out.println("Add "+failCount+" borrowers fails");
		return true;
	}

	/*
	 * borrowBook: get the book id and borrower id from the user input and borrow book from
	 * the library
	 */
	public static void borrowBook(Scanner scan) {
		String borrower = null;
		String book = null;
		int borrowerId = -1;
		int bookId = -1;
        System.out.println("Input the borrower id");
        if (scan.hasNextLine()) {
        	borrower = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }
    	// convert borrower id from string to int
        try {
        	borrowerId = Integer.parseInt(borrower);
		} catch (NumberFormatException e) {
			System.out.println("invalid book id: "+borrower);
			return;
		}
        
        System.out.println("Input the book id");
        if (scan.hasNextLine()) {
        	book = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }
    	// convert book id from string to int
		try {
			bookId = Integer.parseInt(book);
		} catch (NumberFormatException e) {
			System.out.println("invalid book id: "+book);
			return;
		}
        
        lib.borrowBook(bookId, borrowerId);
	}
	
	/*
	 * returnBook: get the book id and borrower id from the user input and return book from
	 * the library
	 */
	public static void returnBook(Scanner scan) {
		String borrower = null;
		String book = null;
		int borrowerId = -1;
		int bookId = -1;
        System.out.println("Input the borrower id");
        if (scan.hasNextLine()) {
        	borrower = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }
        
        System.out.println("Input the book id");
        if (scan.hasNextLine()) {
        	book = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }
        
		// convert book id from string to int
		try {
			bookId = Integer.parseInt(book);
		} catch (NumberFormatException e) {
			System.out.println("invalid book id: "+book);
			return;
		}
		// convert borrower id from string to int
        try {
        	borrowerId = Integer.parseInt(borrower);
		} catch (NumberFormatException e) {
			System.out.println("invalid book id: "+borrower);
			return;
		}

        lib.returnBook(bookId, borrowerId);
	}
	
	/*
	 * printBookInfo: get the book id from the user input and print book info for that book
	 */
	public static void printBookInfo(Scanner scan) {
		Books book = getBooks(scan);
		if(book == null)
			return;
		book.printInfo();
	}
	
	/*
	 * printBorrowerInfo: get the borrower id from the user input and print borrower info for
	 * that borrower
	 */
	public static void printBorrowerInfo(Scanner scan) {
		Borrower borrower = getBorrower(scan);
		if(borrower == null)
			return;
		borrower.printInfo();
	}

	/*
	 * getBorrower: a helper function that returns a borrower object based on the borrower id
	 * given by the user input.
	 */
	private static Borrower getBorrower(Scanner scan) {
		String borrower = null;
		int borrowerId = -1;
		System.out.println("Input the borrower id");
        if (scan.hasNextLine()) {
        	borrower = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return null;
        }
		try {
			borrowerId = Integer.parseInt(borrower);
		} catch (NumberFormatException e) {
			System.out.println("invalid borrower id: "+borrower);
			return null;
		}
		if(lib.getBorrowerList().containsKey(borrowerId))
			return lib.getBorrowerList().get(borrowerId);
		else
			System.out.println("invalid borrower id");
		return null;
	}
	
	/*
	 * getBooks: a helper function that returns a book object based on the book id
	 * given by the user input.
	 */
	private static Books getBooks(Scanner scan) {
		String book = null;
		int bookId = -1;
		System.out.println("Input the book id");
        if (scan.hasNextLine()) {
        	book = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return null;
        }
		try {
			bookId = Integer.parseInt(book);
		} catch (NumberFormatException e) {
			System.out.println("invalid book id: "+book);
			return null;
		}
		if(lib.getBooksList().containsKey(bookId))
			return lib.getBooksList().get(bookId);
		else
			System.out.println("invalid book id");
		return null;
	}

	/*
	 * setBookInfo: ask user to update the book info by promoting user input for each section
	 * of the book info except the book id.
	 */
	public static void setBookInfo(Scanner scan) {
		Books book = getBooks(scan);
		String author = null;
		String language = null;
		String name = null;
		String countStr = null;
		int borrowCount = -1;

		System.out.println("Input the new name");
        if (scan.hasNextLine()) {
        	name = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }

		System.out.println("Input the new author");
        if (scan.hasNextLine()) {
        	author = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }

		System.out.println("Input the new language");
        if (scan.hasNextLine()) {
        	language = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }

		System.out.println("Input the new borrow count");
        if (scan.hasNextLine()) {
        	countStr = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }

		try {
			borrowCount = Integer.parseInt(countStr);
		} catch (NumberFormatException e) {
			System.out.println("invalid borrow count: "+countStr);
			return;
		}

		book.setAuthor(author);
		book.setLanguage(language);
		book.setName(name);
		book.setBorrowCount(borrowCount);
	}
	
	/*
	 * setBorrowerInfo: ask user to update the borrower info by promoting user input for each
	 * section of the borrower info except the borrower id.
	 */
	public static void setBorrowerInfo(Scanner scan) {
		Borrower borrower = getBorrower(scan);
		String name = null;
		String clearBorrowed = null;
		boolean clear = false;

		System.out.println("Input the new name");
        if (scan.hasNextLine()) {
        	name = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }

		System.out.println("Clear book borrowed? (Y/N)");
        if (scan.hasNextLine()) {
        	clearBorrowed = scan.nextLine();
        }
        else {
			System.out.println("invalid input");
	        return;
        }

		if(clearBorrowed.equals("Y"))
			clear = true;
		else if(clearBorrowed.equals("N"))
			clear = false;
		else
			System.out.println("invalid input");

		borrower.setName(name);
		if(clear)
			borrower.resetBorrowedBooks();
	}

	/*
	 * getBooksList: print a list for book id and name for each book
	 */
	public static void getBooksList() {
		for(int b : lib.getBooksList().keySet())
			System.out.println("id: "+b+" name: "+lib.getBooksList().get(b).getName());
	}

	/*
	 * getBorrowerList: print a list for borrower id and name for each borrower
	 */
	public static void getBorrowersList() {
		for(int b : lib.getBorrowerList().keySet())
			System.out.println("id: "+b+" name: "+lib.getBorrowerList().get(b).getName());
	}
	
	/*
	 * removeBook: remove a book from the library based on the book id that the user input
	 */
	public static void removeBook(Scanner scan) {
        lib.removeBook(UI.getBooks(scan));
	}
	
	/*
	 * removeBorrower: remove a book from the library based on the borrower id that the user input
	 */
	public static void removeBorrower(Scanner scan) {
        lib.removeBorrower(UI.getBorrower(scan));
	}
	
	public static void selectAction(int choice, Scanner scan) {
		switch(choice) {
		case 1:
			addBooksFromFile(scan);
			break;
		case 2:
			addBookFromInput(scan);
			break;
		case 3:
			addBorrowerFromFile(scan);
			break;
		case 4:
			addBorrowerFromInput(scan);
			break;
		case 5:
			borrowBook(scan);
			break;
		case 6:
			returnBook(scan);
			break;
		case 7:
			printBookInfo(scan);
			break;
		case 8:
			printBorrowerInfo(scan);
			break;
		case 9:
			setBookInfo(scan);
			break;
		case 10:
			setBorrowerInfo(scan);
			break;
		case 11:
			getBooksList();
			break;
		case 12:
			getBorrowersList();
			break;
		case 13:
			removeBook(scan);
			break;
		case 14:
			removeBorrower(scan);
			break;
		default:
			break;
		}
		System.out.println();
	}

}
