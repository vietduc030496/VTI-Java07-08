/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX4;

/**
 *
 * @author hieu.nguyenvan1
 */
public class Quicksort extends NumberList implements Sort{
    

    public Quicksort(int[] array) {
        super(array);
    }

    public Quicksort(int n) {
        super(n);
    }

    @Override
    public void sort() {
        implementQuickSort(this.getArray(),0,this.getArray().length-1);
        
    }

    private void implementQuickSort(int[] array, int low, int high) {
        if(low<high){
            int piov=partition(array ,low ,high);
            implementQuickSort(array, low, piov-1);
            implementQuickSort(array, piov+1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
       int pivot=array[high];
       int i=low-1;
       for(int j=low ;j<high;j++){
           if(array[j]<pivot){
               i++;
               int term =array[i];
               array[i]=array[j];
               array[j]=term;
           }
       }
       int temp=array[i+1];
       array[i+1]=array[high];
       array[high]=temp;
       return i+1;
    }
    
}
