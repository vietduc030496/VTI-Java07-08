/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class BookTest {
    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();
        for(int i = 1;i<=30;i++){
            Book book = new Book();
            book.setName("book"+i);
            book.setIsbn(100+i);
            book.setAuthor("ngoquocan" + i);
            book.setPublisher("kimdong" +i);
            list.add(book);
        }
        for (Book book : list) {
            System.out.println(book.getBookInfo());
        }  
    }
}
