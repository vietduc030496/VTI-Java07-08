package Bai1;

public class Book {
    private String nameBook;
    private int ISBN;
    private String author;
    private String publisher;

    public Book(){

    }
    public Book(String nameBook, int ISBN, String author, String publisher) {
        this.nameBook = nameBook;
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getBookInfo(Book book){
        String desc= "";
        desc += "Thong tin sach:\nMa sach:"+ book.getISBN() + "\nTen sach:"
                + book.getNameBook() + "\nTen tac gia:" + book.getAuthor()
                + "\nTen nha cung cap:" + book.getPublisher();
        return desc;
    }
}
