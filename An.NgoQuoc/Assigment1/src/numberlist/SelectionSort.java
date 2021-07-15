/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberlist;

/**
 *
 * @author an.ngoquoc
 */
public class SelectionSort extends NumberList implements Sort{
    
    public SelectionSort(int[] arr, int n) {
        super(arr, n);
    }

    @Override
    public void sort() {
        int[] arr = getArr();
        for(int i = 0;i<=arr.length-1;i++){
            int min = arr[i],index = i;
            for(int j=i;j<=arr.length-1;j++){
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
    
}
