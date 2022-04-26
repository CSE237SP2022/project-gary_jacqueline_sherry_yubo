package Books;


public class Books {
	private String name;
	private String author;
    private int id;	// unique identifier of the book
    private String language; // language of this book
    private int borrowCount; // how many times the book is been borrowed
    private boolean isBorrowed; // boolean to see the status of books
    private int borrowedBy; // borrower of this book
    
    /*
     * Constructor:
     */
    public Books(String name, int id, String language, int borrowCount, 
    		boolean isBorrowed, String author) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.language = language;
        this.borrowCount = borrowCount;
        this.isBorrowed = false;
        this.borrowedBy = -1;
    }
    
    /*
     * getName(): get the name of object
     */
    public String getName() {
    	return name;
    }
    
    /*
     * setName(): set the name of object
     */
    public void setName(String name) {
    	this.name = name;
    }
    
    /*
     * getAuthor(): get author of object
     */
    public String getAuthor() {
    	return author;
    }
    
    /*
     * setAuthor(): get author of object
     */
    public void setAuthor(String author) {
    	this.author = author;
    }
    
    /*
     * getId(): get id of object
     */
    public int getId() {
    	return id;
    }
    
    /*
     * setId(): set ID of object
     */
    public void setId(int id) {
    	this.id = id;
    }
	
    /*
     * getLanguage(): get language of object
     */
    public String getLanguage() {
    	return language;
    }
    
    /*
     * setLanguage(): set language of object
     */
    public void setLanguage(String language) {
    	this.language = language;
    }
    
    /*
     * getBorrowCount(): get BorrowCount of object
     */
    public int getBorrowCount() {
    	return borrowCount;
    }
    
    /*
     * setBorrowCount(): set BorrowCount of object
     */
    public void setBorrowCount(int borrowCount) {
    	this.borrowCount = borrowCount;
    }
    
    /*
     * isBorrowed(): get isBorrowed number of object
     */
    public boolean isBorrowed() {
        return isBorrowed;
    }
    
    /*
     * borrowBook(): add up borrowCount if isBorrowed set to true
     */
    public void borrowBook(int borrower) {
    	isBorrowed = true;
    	borrowCount ++;
        borrowedBy = borrower;
    }
    
    /*
     * returnBook(): set isBorrowed to false
     */
    public void returnBook() {
    	isBorrowed = false;
        borrowedBy = -1;
    }

    /*
     * getBorrower(): get the borrower for the current book
     */
    public int getBorrower() {
        return borrowedBy;
    }
        
    public void printInfo() {
    	System.out.println("Name: "+name);
    	System.out.println("id: "+id);
    	System.out.println("language: "+language);
    	System.out.println("count of borrows: "+borrowCount);
    	System.out.println("is borrowed: "+isBorrowed);
    	if(isBorrowed)
    		System.out.println("borrowed by: "+borrowedBy);
    }
}
