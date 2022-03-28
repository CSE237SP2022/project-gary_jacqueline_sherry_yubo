package Books;


public class Books {
	private String name;
	private String author;
    private int id;
    private String language;
    private int borrowCount;
    private boolean isBorrowed;
    
    public Books(String name, int id, String language, int borrowCount, boolean isBorrowed, String author) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.language = language;
        this.borrowCount = borrowCount;
        this.isBorrowed = false;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getAuthor() {
    	return author;
    }
    
    public void setAuthor(String author) {
    	this.author = author;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
	
    public String getLanguage() {
    	return language;
    }
    
    public void setLanguage(String language) {
    	this.language = language;
    }
    
    public int getBorrowCount() {
    	return borrowCount;
    }
    
    public void setBorrowCount(int borrowCount) {
    	this.borrowCount = borrowCount;
    }
    
    public boolean isBorrowed() {
        return isBorrowed;
    }
    
    public void borrowBook(Books book) {
    	book.isBorrowed = true;
    	book.borrowCount ++;
    }
    
    public void returnBook(Books book) {
    	book.isBorrowed = false;
    }
    
    public void modifyName(Books book, String newName) {
    	book.name = newName;
    }
    
    public void modifyAuthor(Books book, String newAuthor) {
    	book.author = newAuthor;
    }
    
    public void modifyLanguage(Books book, String newLanguage) {
    	book.language = newLanguage;
    }
    
    public void resetBorrowCount(Books book) {
    	book.borrowCount = 0;
    }
    
    
    

}
