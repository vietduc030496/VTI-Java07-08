/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

/**
 *
 * @author ADMIN
 */
public class InsertSort extends NumberList implements Sort {

    @Override
    public void sort() {
        if (this.getLengOfList() > 0) {
            int[] arr = this.getArray();
            int valueToInsert;
            int holePosition;
            for (int i = 1; i < arr.length; i++) {
                valueToInsert = arr[i];
                holePosition = i;
                while (holePosition > 0 && arr[holePosition - 1] > valueToInsert) {
                    arr[holePosition] = arr[holePosition - 1];
                    holePosition--;
                }
                if (holePosition != i) {
                    arr[holePosition] = valueToInsert;
                }
            }
            this.setArray(arr);
        }
    }

    public InsertSort() {
        super();
    }

    public InsertSort(int lengOfList) {
        super(lengOfList);
    }
}
