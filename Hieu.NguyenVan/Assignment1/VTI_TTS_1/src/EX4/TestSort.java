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
public class TestSort {

    public static void main(String[] args) {

//        SelectionSort sort=new SelectionSort(10);
//        sort.input();
        //InserSort inserSort = new InserSort(10);
        //inserSort.sort();

        // inserSort.print();
        Quicksort sort = new Quicksort(10);
        sort.sort();
        sort.print();
    }
}
