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
public class QuickSort extends NumberList implements Sort{

    @Override
    public void sort() {
        Scanner sc = new Scanner(System.in);
        NumberList nl = new NumberList();
        
        System.out.print("Nhap so ptu: ");
        int n = Integer.parseInt(sc.nextLine());
        
        int list[] = nl.NumberList(n);
        nl.input(list, n);
        nl.print(list);
        
        quickSort(list, 0, n-1);
        System.out.println("Sau khi sort");
        nl.print(list);
       
    }
    
    public int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low -1);
        for(int j = low; i<high; j++){
            if(arr[j] < pivot){
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return i+1;
    }
    
    public int partition(int arr[], int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;
 
        while (true) {
 
            while (arr[++leftPointer] < pivot) {
                // khong lam gi
            }
 
            while (rightPointer > 0 && arr[--rightPointer] > pivot) {
                // khong lam gi
            }
 
            if (leftPointer >= rightPointer) {
                break;
            } else {                
                int temp = arr[leftPointer];
                arr[leftPointer] = arr[rightPointer];
                arr[rightPointer] = temp;
            }
 
        }
         
        int temp = arr[leftPointer];
        arr[leftPointer] = arr[right];
        arr[right] = temp;
        
        return leftPointer;
    }
    
    public void quickSort(int arr[], int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            int pivot = arr[right];
            int partitionPoint = partition(arr, left, right, pivot);
            quickSort(arr, left, partitionPoint - 1);
            quickSort(arr, partitionPoint + 1, right);
        }
    }
}
