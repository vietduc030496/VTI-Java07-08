package Exercise4;

public class QuickSort extends NumberList implements Sort{
	public QuickSort() {
		super();
	}

	public QuickSort(int n) {
		super(n);
		
	}
	public void sort() {
		int[] arr=this.getArr();
		quickSort(arr, 0, this.getN() - 1);
		this.setArr(arr);
		
	}
	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	static int partition(int[] arr, int low, int high)
	{
	     
	    int pivot = arr[high];

	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {

	        if (arr[j] < pivot)
	        {

	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	public void quickSort(int[] arr, int low, int high)
	{
	    if (low < high)
	    {
	        int pi = partition(arr, low, high);
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	}

}
