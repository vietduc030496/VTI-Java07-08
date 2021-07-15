/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * @author kieuq
 */
public class Book {
    private String bookName;
    private String ISBN_number;
    private String authorName;
    private String publisherName;

    public Book() {
    }

    public Book(String bookName, String ISBN_number, String authorName, String publisherName) {
        this.bookName = bookName;
        this.ISBN_number = ISBN_number;
        this.authorName = authorName;
        this.publisherName = publisherName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN_number() {
        return ISBN_number;
    }

    public void setISBN_number(String ISBN_number) {
        this.ISBN_number = ISBN_number;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getBookInfo(){
        return "Book{" + "bookName=" + bookName + ", ISBN_number=" + ISBN_number + ", authorName=" + authorName + ", publisherName=" + publisherName + '}';
    }

  
    
    
}
