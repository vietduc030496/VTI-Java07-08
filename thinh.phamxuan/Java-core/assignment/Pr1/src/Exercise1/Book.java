package Exercise1;

public class Book {
	private String bookName;
	private int ISBN;
	private String authorName;
	private String publisher;
	public Book() {
		super();
	}
	public Book(String bookName, int iSBN, String authorName, String publisher) {
		super();
		this.bookName = bookName;
		ISBN = iSBN;
		this.authorName = authorName;
		this.publisher = publisher;
	}
	public String getBookInfo() {
		return "BookName: "+this.bookName+" ISBN "+this.ISBN+" AuthorName "+this.authorName+" publisher "+this.publisher;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
}
