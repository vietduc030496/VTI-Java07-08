import java.time.chrono.IsoChronology;
import java.util.*;
public class BookTest {
    public static void main(String[] args) {
        Book[] b = new Book[30];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 30; ++i) {
            String name = sc.nextLine();
            String ISBN = sc.nextLine();
            String author = sc.nextLine();
            String publisher = sc.nextLine();
            b[i] = new Book(name, ISBN, author, publisher);
        }
        System.out.println("List of books: ");
        for (int i = 0; i < 30; i++) {
            System.out.println(b[i].getBookInfo());
        }
    }
}
