package b1;

import java.util.ArrayList;
import java.util.List;

public class BookTest {
	
    public static void main(String[] args) {
    	
    	List<Book> listBook= new ArrayList<>();
        for(int i=0;i<30;i++){
            Book book = new Book("book"+i,i,"author"+i,"publisher"+i);
            listBook.add(book);
        }
        for(Book book: listBook){
            System.out.println(book.getBookInfor());
        }
    }
}
