package ExerciseFour;

public class InsertSort extends NumberList implements Sort {
	private int[] arr = this.getList();
	public InsertSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	private void insertionSort(int arr[], int n)
	{
	    int i, key, j;
	    for (i = 1; i < n; i++)
	    {
	        key = arr[i];
	        j = i - 1;
	        while (j >= 0 && arr[j] > key)
	        {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	}
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		this.insertionSort(arr, arr.length);
	}

}
