/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

import java.util.ArrayList;

/**
 *
 * @author van hieu
 */

public class BookTest {
     public static void createBook(ArrayList listBook){
        
        for(int i=0;i<30;i++){
            Book book=new Book("Lao hac", i, "Nam cao","NXB tre");
            listBook.add(book);
        }
        
        
    }
    public static void out(ArrayList listBook){
        for(int i=0;i<listBook.size();i++){
            Book book =(Book) listBook.get(i);
            String bookInfo=book.getBookInfo();
            System.out.println(bookInfo);
            
        }
        
    }
    public static void main (String[] args){
        
        ArrayList<Book> listBook=new ArrayList();
        
        createBook(listBook);
        out(listBook);
    }
    
}
