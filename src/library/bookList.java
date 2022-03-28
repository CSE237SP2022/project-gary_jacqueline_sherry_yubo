package library;

//data:
//some structure to store book info
//some structure to store borrower info
//
//method:
//borrow
//return
//add book
//remove book
//add borrower
//remove borrower
//modify book
//modify borrower
import java.util.HashMap;

public class bookList {
	HashMap<String, String> storeBook = new HashMap<String, String>(); 
	HashMap<String, String> borrowInfo = new HashMap<String, String>(); 
	
	private boolean isBorrowed = false;
	private boolean isReturned = false;
	
	public void setBorrowed(boolean borrowed) {
		isBorrowed = borrowed;
    }
	
	public void setReturned(boolean returned) {
		
        isReturned = returned;
    }
	
	public void addBook(String id, String name) {
		storeBook.put(id, name);
	}
	
	public void removeBook(String id, String name) {
		storeBook.remove(id, name);
	}
	
	public void addBrower(String id, String name) {
		borrowInfo.put(id, name);
	}
	
	public void removeBrower(String id, String name) {
		borrowInfo.remove(id, name);
	}
	
	
	
	
	
}
