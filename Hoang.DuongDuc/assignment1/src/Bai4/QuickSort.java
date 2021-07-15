package Bai4;

public class QuickSort extends NumberList implements Sort {
    public QuickSort(int n) {
        super(n);
    }

    @Override
    public void sort() {
        quickSort(0, this.length - 1);

    }

    private void quickSort(int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        int mid = (left + right) / 2;
        while (i <= j) {
            while (this.elements[i] < this.elements[mid]) i++;
            while (this.elements[j] > this.elements[mid]) j--;
            if (i <= j) {
                int tmp = this.elements[i];
                this.elements[i] = this.elements[j];
                this.elements[j] = tmp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(left, j);
        }
        if (right > i) {
            quickSort(i, right);
        }
    }
}
