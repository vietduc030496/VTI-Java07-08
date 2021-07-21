package Bai4;

public class SelectionSort extends NumberList implements Sort {
    public SelectionSort(int n) {
        super(n);
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < length; j++)
                if (elements[j] < elements[min_idx])
                    min_idx = j;
            int temp = elements[min_idx];
            elements[min_idx] = elements[i];
            elements[i] = temp;
        }

    }
}
