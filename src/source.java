import Books.Books;
import borrower.Borrower;
import library.Library;

public class source {

	public static void main(String[] args) {
		Library lib = new Library();
		Borrower borrower1 = new Borrower(0, "borrower0");
		Books book1 = new Books("book0", 0, "English", 0, false, "author0");
		
		lib.addBook(book1);
		lib.addBorrower(borrower1);
		lib.borrowBook(0, 0);
		lib.returnBook(0);
	}
}
