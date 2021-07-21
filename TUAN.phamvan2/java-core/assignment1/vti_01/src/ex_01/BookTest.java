package ex_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookTest {
	public List<Book> generateBook() {
		Scanner s = new Scanner(System.in);
		List<Book> books = new ArrayList<>();
		for(int i = 0; i < 30; i++) {
			Book book = new Book();
			System.out.println("Enter book with 4 pieces of informations: book name, ISBN number, author name and publisher:");
			book.setBookName(s.nextLine());
			book.setISBNnumber(s.nextLong());
			s.nextLine();
			book.setAuthorName(s.nextLine());
			book.setPublisher(s.nextLine());
			String description = book.getBookInfo();
			books.add(book);
			System.out.println(book.getBookInfo());
			
		}
		return books;
	}
	public static void main(String[] args) {
		BookTest bookTest = new BookTest();
		bookTest.generateBook();
	}
}
