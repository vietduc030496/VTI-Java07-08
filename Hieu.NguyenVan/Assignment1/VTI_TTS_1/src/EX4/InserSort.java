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
public class InserSort extends NumberList implements Sort {

    public InserSort(int[] array) {
        super(array);
    }

    public InserSort(int n) {
        super(n);
    }

    @Override
    public void sort() {
        int[] array = this.array;
        int[] arr = this.getArray();
        for (int i = 0; i < this.getArray().length ; i++) {
            int key = this.getArray()[i];
            int j = i - 1;
            while (j >= 0 && this.getArray()[j] > key) {
                this.getArray()[1+j] = this.getArray()[j];
                j--;
            }
            this.getArray()[j+1]=key;
        }
    }

}
