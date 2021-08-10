/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SelectionSort extends NumberList implements Sort {

    @Override
    public void sort() {
        if (this.getLengOfList() > 0) {
            int[] arr = this.getArray();
            for (int i = 0; i < this.getLengOfList() - 1; i++) {
                for (int j = i + 1; j < this.getLengOfList(); j++) {
                    if (arr[j] < arr[i]) {
                        int swap = arr[i];
                        arr[i] = arr[j];
                        arr[j] = swap;
                    }

                }
            }
            this.setArray(arr);
        }

    }

    public SelectionSort() {
        super();
    }

    public SelectionSort(int lengOfList) {
        super(lengOfList);

    }
}
