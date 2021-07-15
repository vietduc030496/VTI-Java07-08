/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

/**
 *
 * @author ADMIN
 */
public class TestSort {

    public static void main(String[] args) {
//      QuickSort q = new QuickSort(5);

        SelectionSort s = new SelectionSort(5);
        s.input();
        System.out.print("Mang ban dau la: ");
        s.print();
        s.sort();
        System.out.print("Mang sau khi sap xep la: ");
        s.print();

//	InsertSort i = new InsertSort(5);

    }
}
