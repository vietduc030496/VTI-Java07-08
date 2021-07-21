/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kieuq
 */
public class BookTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> arrBook = new ArrayList<>();
        
        for(int i=1; i<=30; i++){      
            System.out.print("Nhap ten: ");
            String bookName = sc.next();
            System.out.print("Nhap ISBN: ");
            String ISBN_number = sc.next();
            System.out.print("Nhap tac gia: ");
            String authorName = sc.next();
            System.out.print("Nhap nxb: ");
            String publisherName = sc.next();
            System.out.println("-------------------");
               
            Book b = new Book(bookName, ISBN_number, authorName, publisherName);
            arrBook.add(b);
        }
        
        for (Book b : arrBook) {
            System.out.println(b.getBookInfo());
        }
    }
}
