package Bai1;
import java.util.ArrayList;
public class BookTest {
    public static void main(String[] args) {
        ArrayList<Book> listb = new ArrayList<>(30);
        init(listb);
        System.out.println("Danh sach thong tin cac sach:\n\n");
        for(int i= 0; i< listb.size(); i++){
            Book book;
            book= listb.get(i);
            System.out.println("STT " + (i+1) + ".\n" + book.getBookInfo(book));
            System.out.println("\n\n");
        }
    }
    private static void init(ArrayList<Book> listb){
        Book b1= new Book();
        b1.setISBN(1);
        b1.setNameBook("Ten sach 1");
        b1.setAuthor("Tac gia 1");
        b1.setPublisher("NXB1");
        listb.add(b1);

        Book b2= new Book();
        b2.setISBN(2);
        b2.setNameBook("Ten sach 2");
        b2.setAuthor("Tac gia 2");
        b2.setPublisher("NXB2");
        listb.add(b2);

        Book b3= new Book();
        b3.setISBN(3);
        b3.setNameBook("Ten sach 3");
        b3.setAuthor("Tac gia 3");
        b3.setPublisher("NXB3");
        listb.add(b3);

        Book b4= new Book();
        b4.setISBN(4);
        b4.setNameBook("Ten sach 4");
        b4.setAuthor("Tac gia 4");
        b4.setPublisher("NXB4");
        listb.add(b4);

        Book b5= new Book();
        b5.setISBN(5);
        b5.setNameBook("Ten sach 5");
        b5.setAuthor("Tac gia 5");
        b5.setPublisher("NXB5");
        listb.add(b5);

        Book b6= new Book();
        b6.setISBN(6);
        b6.setNameBook("Ten sach 6");
        b6.setAuthor("Tac gia 6");
        b6.setPublisher("NXB6");
        listb.add(b6);

        Book b7= new Book();
        b7.setISBN(7);
        b7.setNameBook("Ten sach 7");
        b7.setAuthor("Tac gia 7");
        b7.setPublisher("NXB7");
        listb.add(b7);

        Book b8= new Book();
        b8.setISBN(8);
        b8.setNameBook("Ten sach 8");
        b8.setAuthor("Tac gia 8");
        b8.setPublisher("NXB8");
        listb.add(b8);

        Book b9= new Book();
        b9.setISBN(9);
        b9.setNameBook("Ten sach 9");
        b9.setAuthor("Tac gia 9");
        b9.setPublisher("NXB9");
        listb.add(b9);

        Book b10= new Book();
        b10.setISBN(10);
        b10.setNameBook("Ten sach 10");
        b10.setAuthor("Tac gia 10");
        b10.setPublisher("NXB10");
        listb.add(b10);

        Book b11= new Book();
        b11.setISBN(11);
        b11.setNameBook("Ten sach 11");
        b11.setAuthor("Tac gia 11");
        b11.setPublisher("NXB11");
        listb.add(b11);

        Book b12= new Book();
        b12.setISBN(12);
        b12.setNameBook("Ten sach 12");
        b12.setAuthor("Tac gia 12");
        b12.setPublisher("NXB12");
        listb.add(b12);

        Book b13= new Book();
        b13.setISBN(13);
        b13.setNameBook("Ten sach 13");
        b13.setAuthor("Tac gia 13");
        b13.setPublisher("NXB13");
        listb.add(b13);

        Book b14= new Book();
        b14.setISBN(14);
        b14.setNameBook("Ten sach 14");
        b14.setAuthor("Tac gia 14");
        b14.setPublisher("NXB14");
        listb.add(b14);

        Book b15= new Book();
        b15.setISBN(15);
        b15.setNameBook("Ten sach 15");
        b15.setAuthor("Tac gia 15");
        b15.setPublisher("NXB15");
        listb.add(b15);

        Book b16= new Book();
        b16.setISBN(16);
        b16.setNameBook("Ten sach 16");
        b16.setAuthor("Tac gia 16");
        b16.setPublisher("NXB16");
        listb.add(b16);

        Book b17= new Book();
        b17.setISBN(17);
        b17.setNameBook("Ten sach 17");
        b17.setAuthor("Tac gia 17");
        b17.setPublisher("NXB17");
        listb.add(b17);

        Book b18= new Book();
        b18.setISBN(18);
        b18.setNameBook("Ten sach 18");
        b18.setAuthor("Tac gia 18");
        b18.setPublisher("NXB18");
        listb.add(b18);

        Book b19= new Book();
        b19.setISBN(19);
        b19.setNameBook("Ten sach 19");
        b19.setAuthor("Tac gia 19");
        b19.setPublisher("NXB19");
        listb.add(b19);

        Book b20= new Book();
        b20.setISBN(20);
        b20.setNameBook("Ten sach 20");
        b20.setAuthor("Tac gia 20");
        b20.setPublisher("NXB20");
        listb.add(b20);

        Book b21= new Book();
        b21.setISBN(21);
        b21.setNameBook("Ten sach 21");
        b21.setAuthor("Tac gia 21");
        b21.setPublisher("NXB21");
        listb.add(b21);

        Book b22= new Book();
        b22.setISBN(22);
        b22.setNameBook("Ten sach 22");
        b22.setAuthor("Tac gia 22");
        b22.setPublisher("NXB22");
        listb.add(b22);

        Book b23= new Book();
        b23.setISBN(23);
        b23.setNameBook("Ten sach 23");
        b23.setAuthor("Tac gia 23");
        b23.setPublisher("NXB23");
        listb.add(b23);

        Book b24= new Book();
        b24.setISBN(24);
        b24.setNameBook("Ten sach 24");
        b24.setAuthor("Tac gia 24");
        b24.setPublisher("NXB24");
        listb.add(b24);

        Book b25= new Book();
        b25.setISBN(25);
        b25.setNameBook("Ten sach 25");
        b25.setAuthor("Tac gia 25");
        b25.setPublisher("NXB25");
        listb.add(b25);

        Book b26= new Book();
        b26.setISBN(26);
        b26.setNameBook("Ten sach 26");
        b26.setAuthor("Tac gia 26");
        b26.setPublisher("NXB26");
        listb.add(b26);

        Book b27= new Book();
        b27.setISBN(27);
        b27.setNameBook("Ten sach 27");
        b27.setAuthor("Tac gia 27");
        b27.setPublisher("NXB27");
        listb.add(b27);

        Book b28= new Book();
        b28.setISBN(28);
        b28.setNameBook("Ten sach 28");
        b28.setAuthor("Tac gia 28");
        b28.setPublisher("NXB28");
        listb.add(b28);

        Book b29= new Book();
        b29.setISBN(29);
        b29.setNameBook("Ten sach 29");
        b29.setAuthor("Tac gia 29");
        b29.setPublisher("NXB29");
        listb.add(b29);

        Book b30= new Book();
        b30.setISBN(30);
        b30.setNameBook("Ten sach 30");
        b30.setAuthor("Tac gia 30");
        b30.setPublisher("NXB30");
        listb.add(b30);

    }
}
