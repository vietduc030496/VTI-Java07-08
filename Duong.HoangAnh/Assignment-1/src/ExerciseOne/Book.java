package ExerciseOne;

public class Book {
	private String autherName;
	private String publisherName;
	private String bookName;
	private int isbnNumber;
	public Book(String book, String publisher, String auther, int isbn) {
		setBookName(book);
		setAutherName(auther);
		setPublisherName(publisher);
		setIsbnNumber(isbn);
	}
	public void setBookName(String book) {
		bookName = book;
	}
	public String getBookName() {
		return bookName;
	}
	public void setAutherName(String auther) {
		autherName = auther;
	}
	public String getAutherName() {
		return autherName;
	}
	public void setPublisherName(String publisher) {
		publisherName = publisher;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setIsbnNumber(int isbn) {
		isbnNumber = isbn;
	}
	public int getIsbnNumber() {
		return isbnNumber;
	}
	public String getBookInfo() {
		String result = "";
		result += "This book name: " + getBookName() + ".\n";
		result += "This isbn book: " + getIsbnNumber() + ".\n";
		result += "This auther book: " + getAutherName() + ".\n";
		result += "This publisher book: " + getPublisherName() + ".\n";
		return result;
	}
}
