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
public class InsertSort extends NumberList implements Sort {

    public InsertSort(int[] arr, int n) {
        super(arr, n);
    }

    @Override
    public void sort() {
        int[] arr = getArr();
        int i, key, j,n=arr.length-1;
        for (i = 0; i <= n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}
