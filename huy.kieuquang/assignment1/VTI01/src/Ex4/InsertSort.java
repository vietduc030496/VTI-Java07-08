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
public class InsertSort extends NumberList implements Sort{

    @Override
    public void sort() {
        Scanner sc = new Scanner(System.in);
        NumberList nl = new NumberList();
        
        System.out.print("Nhap so ptu: ");
        int n = Integer.parseInt(sc.nextLine());
        
        int list[] = nl.NumberList(n);
        nl.input(list, n);
        nl.print(list);
        
        insertionSort(list);
        System.out.println("Sau khi sort");
        nl.print(list);
    }
    
     public void insertionSort(int arr[]) {
        int valueToInsert;
        int holePosition;
        int i;
 
        // lap qua tat ca cac so
        for (i = 1; i < arr.length; i++) {
            // chon mot gia tri de chen
            valueToInsert = arr[i];
 
            // lua chon vi tri de chen
            holePosition = i;
 
            // kiem tra xem so lien truoc co lon hon gia tri duoc chen khong
            while (holePosition > 0 && arr[holePosition - 1] > valueToInsert) {
                arr[holePosition] = arr[holePosition - 1];
                holePosition--;
                System.out.println("Di chuyen phan tu: " + arr[holePosition]);
            }
 
            if (holePosition != i) {

                // chen phan tu tai vi tri chen
                arr[holePosition] = valueToInsert;
            }
        }
    }
}
