package exercise1;

import java.util.Scanner;

public class Book {
	private String name;
	private int isbn;
	private String author;
	private String publisher;
	public Book() {
		super();
	}
	public Book(String name, int isbn, String author, String publisher) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
	public String getBookInfo() {
		return "\nname book:"+getName()+"\nisbn:"+getIsbn()+"\nauthor:"+getAuthor()+"\npublisher:"+getPublisher();
	}
	public void inputdata() {
		Scanner sc=new Scanner(System.in);
		System.out.println("nhap vao name book:");
		this.name=sc.nextLine();
		System.out.println("nhap vao isbn:");
		this.isbn=Integer.parseInt(sc.nextLine());
		System.out.println("nhap vao author:");
		this.author=sc.nextLine();
		System.out.println("nhap vao publisher:");
		this.publisher=sc.nextLine();
	}
}
