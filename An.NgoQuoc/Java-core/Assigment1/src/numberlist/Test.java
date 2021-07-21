/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberlist;

import java.util.Scanner;

/**
 *
 * @author an.ngoquoc
 */
public class Test {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n:");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("QuickSort:");
        QuickSort qs = new QuickSort(arr,n);
        qs.input();
        qs.sort();
        qs.printf();
        System.out.print("SelectionSort:");
        SelectionSort ss = new SelectionSort(arr,n);
        ss.input();
        ss.sort();
        ss.printf();
        System.out.print("InsertSort:");
        InsertSort is = new InsertSort(arr,n);
        is.input();
        is.sort();
        is.printf();
    }
}
