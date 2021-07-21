/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

/**
 *
 * @author van hieu
 */
public class Book {
     public String  bookName;
     private int ISBN;
     private String author;
     private String publisher;

    public Book() {
    }
     
     
    public Book(String bookName, int ISBN, String author, String publisher) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
    }

    public String getBookName() {
        return bookName;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public String getBookInfo() {
        return "Book{" + "bookName=" + bookName + ", ISBN=" + ISBN + ", author=" + author + ", publisher=" + publisher + '}';
    }
    
     
}
