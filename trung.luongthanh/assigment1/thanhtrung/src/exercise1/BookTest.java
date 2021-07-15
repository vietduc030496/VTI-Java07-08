package exercise1;

import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book a[] = new Book[30];
		System.out.println("nhap so book(nho hon 30):");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Book b = new Book();
			b.inputdata();
			a[i] = b;
		}
		for (Book book : a) {
			if (book != null) {
				System.out.println(book.getBookInfo());
			}
		}
	}
}
