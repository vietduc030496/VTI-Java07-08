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
public class SelectionSort extends NumberList implements Sort{

    public SelectionSort(int n) {
        super(n);
    }

    @Override
    public void sort() {
       // int [] array=this.getArray();
        for(int i=0;i< this.array.length-1;i++){
            int min=i;
            for(int j=i+1;j< this.array.length;j++){
                if(array[min]>array[j]) min=j;
            }
//            array[i]=array[i]+array[min];
//            array[min]=array[i]-array[min];
//            array[i]=array[i]-array[min];
            int term=array[min];
            array[min]=array[i];
            array[i]=term;
            System.out.println(array[i]);
        }
        System.out.println("EX4.SelectionSort.sort()");
    }
    
    
}
