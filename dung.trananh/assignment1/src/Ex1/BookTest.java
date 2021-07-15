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
 * @author ADMIN
 */
public class BookTest {
    public static void main(String[] args) {
        ArrayList<Book> b = new ArrayList<>();
        for (int i=0;i<30;i++){
            Scanner in = new Scanner(System.in);
            System.out.print("Nhap ma so sach: ");
            int maso = Integer.parseInt(in.nextLine());
            System.out.print("Nhap ten sach: ");
            String ten = in.nextLine();
            System.out.print("Nhap ten tac gia: ");
            String tacgia = in.nextLine();
            System.out.print("Nhap nha xuat ban: ");
            String nhaxuatban= in.nextLine();
            Book a= new Book(maso, ten, tacgia, nhaxuatban);
            b.add(a);
            System.out.println("\n");
        }
        System.out.println("Danh sach cac sach do la: ");
        for (int i=0;i<b.size();i++){
            System.out.println(b.get(i).getBookInfo());
        }
    }
}
