/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class QuickSort extends NumberList implements Sort {

    @Override
    public void sort() {
        if (this.getLengOfList() > 0) {
            Arrays.sort(this.getArray());

        }
    }

    public QuickSort() {
        super();
    }

    public QuickSort(int lengOfList) {
        super(lengOfList);
    }
}
