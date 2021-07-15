package Bai4;

public class InsertSort extends NumberList implements Sort {
    public InsertSort(int n) {
        super(n);
    }

    @Override
    public void sort() {
        for (int i = 1; i < length; ++i) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j = j - 1;
            }
            elements[j + 1] = key;
        }

    }

}
