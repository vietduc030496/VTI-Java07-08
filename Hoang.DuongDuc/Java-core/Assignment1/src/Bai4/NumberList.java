package Bai4;

import java.util.Scanner;

public class NumberList {
    protected int length;
    protected int[] elements;

    public NumberList(int n) {
        this.length = n;
        this.elements = new int[length];
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap cac phan tu cho mang: ");
        for (int i = 0; i < this.length; i++) {
            System.out.print("Nhap phan tu thu " + i + ": ");
            elements[i] = sc.nextInt();
        }
    }

    public void print() {
        System.out.println("\nMang vua nhap: ");
        //System.out.println(length);
        for (int i = 0; i < this.length; i++) {
            System.out.print(this.elements[i] + "\t");
        }
        System.out.println();
    }
}
