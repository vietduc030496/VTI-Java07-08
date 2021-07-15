/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberlist;

import java.util.ArrayList;

/**
 *
 * @author an.ngoquoc
 */
public class QuickSort extends NumberList implements Sort{
    
    public QuickSort(int[] arr, int n) {
        super(arr, n);
    }

    @Override
    public void sort() {
        int[] arr = getArr();
        quicksort(arr,0,arr.length-1);
    }
    public void quicksort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            quicksort(arr, low, pi-1); 
            quicksort(arr, pi+1, high); 
        } 
    }
    public int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
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
} 
