
public class QuickSort extends NumberList implements Sort{
	
	public QuickSort() {
		super();
	}
	
	public QuickSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	public void sort() {
		sort(this.arr, 0, this.arr.length - 1);
	}
	
	public void sort(int[] arr, int low, int high) {
	    if (low < high)
	    {
	         

	        int pi = partition(arr, low, high);

	        sort(arr, low, pi - 1);
	        sort(arr, pi + 1, high);
	    }
	}	
	
	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];

	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {

	        if (arr[j] < pivot)
	        {
	            i++;
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp; 
 	        }
	    }
	    int temp = arr[i+1];
	    arr[i+1] = arr[high];
	    arr[high] = temp;
	    return (i + 1);
	}
}
