/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

/**
 *
 * @author kieuq
 */
public class Main {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        QuickSort qs = new QuickSort();
//        qs.sort();
        
        SelectionSort ss = new SelectionSort();
//        ss.sort();
        
        InsertSort is = new InsertSort();
        is.sort();
    }
}
