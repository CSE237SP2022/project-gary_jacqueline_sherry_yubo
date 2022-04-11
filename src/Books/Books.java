package Books;


public class Books {
	private String name;
	private String author;
    private int id;	// unique identifier of the book
    private String language;
    private int borrowCount;
    private boolean isBorrowed;//boolean to see the status of books
    
    /*
     * Constructor:
     * parameter: String name, int id, String language, int borrowCount, boolean isBorrowed, String author
     * return: none
     */
    public Books(String name, int id, String language, int borrowCount, boolean isBorrowed, String author) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.language = language;
        this.borrowCount = borrowCount;
        this.isBorrowed = false;
    }
    
    /*
     * getName(): get the name of object
     * parameter: none
     * return: name
     */
    public String getName() {
    	return name;
    }
    
    /*
     * setName(): set the name of object
     * parameter: name
     * return: none
     */
    public void setName(String name) {
    	this.name = name;
    }
    
    /*
     * getAuthor(): get author of object
     * parameter: none
     * return: author
     */
    public String getAuthor() {
    	return author;
    }
    
    /*
     * setAuthor(): get author of object
     * parameter: author
     * return: none
     */
    public void setAuthor(String author) {
    	this.author = author;
    }
    
    /*
     * getId(): get id of object
     * parameter: none
     * return: id
     */
    public int getId() {
    	return id;
    }
    
    /*
     * setId(): set ID of object
     * parameter: id
     * return: none
     */
    public void setId(int id) {
    	this.id = id;
    }
	
    /*
     * getLanguage(): get language of object
     * parameter: none
     * return: language 
     */
    public String getLanguage() {
    	return language;
    }
    
    /*
     * setLanguage(): set language of object
     * parameter: language
     * return: none
     */
    public void setLanguage(String language) {
    	this.language = language;
    }
    
    /*
     * getBorrowCount(): get BorrowCount of object
     * parameter: none
     * return: borrowCount
     */
    public int getBorrowCount() {
    	return borrowCount;
    }
    
    public void setBorrowCount(int borrowCount) {
    	this.borrowCount = borrowCount;
    }
    
    public boolean isBorrowed() {
        return isBorrowed;
    }
    
    public void borrowBook() {
    	isBorrowed = true;
    	borrowCount ++;
    }
    
    public void returnBook() {
    	isBorrowed = false;
    }
}
