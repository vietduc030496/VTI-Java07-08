package ex_01;

public class Book {
	private String bookName;
	private long ISBNnumber;
	private String authorName, publisher;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String bookName, long iSBNnumber, String authorName, String publisher) {
		super();
		this.bookName = bookName;
		ISBNnumber = iSBNnumber;
		this.authorName = authorName;
		this.publisher = publisher;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public long getISBNnumber() {
		return ISBNnumber;
	}

	public void setISBNnumber(long iSBNnumber) {
		ISBNnumber = iSBNnumber;
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
	
	public String getBookInfo() {
		return "Book [bookName=" + this.bookName + ", ISBNnumber=" + this.ISBNnumber + ", authorName=" + this.authorName
				+ ", publisher=" + this.publisher + "]";
	}
}
