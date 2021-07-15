import java.util.*;
public class Book {
    private String name;
    private String ISBN;
    private String author;
    private String publisher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
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

    public Book(String name, String ISBN, String author, String publisher) {
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
    }

    public String getBookInfo() {
        return this.getName() + " - " + this.getISBN() + " - " + this.getAuthor() + " - " + this.getPublisher();
    }
}
