/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

import java.util.Scanner;

/**
 *
 * @author kieuq
 */
public class SelectionSort extends NumberList implements Sort{

    @Override
    public void sort() {
        Scanner sc = new Scanner(System.in);
        NumberList nl = new NumberList();
        
        System.out.print("Nhap so ptu: ");
        int n = Integer.parseInt(sc.nextLine());
        
        int list[] = nl.NumberList(n);
        nl.input(list, n);
        nl.print(list);
        
        selectionSort(list);
        System.out.println("Sau khi sort");
        nl.print(list);
    }
    
    public void selectionSort(int arr[]) {
        int indexMin, i, j;
 
        // lap qua ta ca cac so
        for (i = 0; i < arr.length - 1; i++) {
            // thiet lap phan tu hien tai la min
            indexMin = i;
 
            // kiem tra phan tu hien tai co phai la nho nhat khong
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
 
            if (indexMin != i) {

                // Trao doi cac so
                int temp = arr[indexMin];
                arr[indexMin] = arr[i];
                arr[i] = temp;
            }
            
        }
    }
}
