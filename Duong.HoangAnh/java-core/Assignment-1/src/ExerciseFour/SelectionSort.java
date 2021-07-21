package ExerciseFour;

public class SelectionSort extends NumberList implements Sort {
	private int[] arr = this.getList();
	public SelectionSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	private void selectionSort(int arr[]) {
        int indexMin, i, j;
        for (i = 0; i < arr.length - 1; i++) {
            indexMin = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                int temp = arr[indexMin];
                arr[indexMin] = arr[i];
                arr[i] = temp;
            }
        }
    }
	@Override
	public void sort() {
		this.selectionSort(arr);
	}
}
