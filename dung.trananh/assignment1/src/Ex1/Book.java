/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * @author ADMIN
 */
public class Book {
    private int ISBN_number;
    private String book_name;
    private String author_name;
    private String publisher;

    public Book() {
    }

    public Book(int ISBN_number, String book_name, String author_name, String publisher) {
        this.ISBN_number = ISBN_number;
        this.book_name = book_name;
        this.author_name = author_name;
        this.publisher = publisher;
    }

    public int getISBN_number() {
        return ISBN_number;
    }

    public void setISBN_number(int ISBN_number) {
        this.ISBN_number = ISBN_number;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getBookInfo(){
        return "Book{" + "ISBN_number=" + ISBN_number + ", book_name=" + book_name + ", author_name=" + author_name + ", publisher=" + publisher + '}';
    }
}
