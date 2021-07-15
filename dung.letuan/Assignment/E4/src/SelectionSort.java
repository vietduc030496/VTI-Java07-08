
public class SelectionSort extends NumberList implements Sort{
	
	public SelectionSort() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SelectionSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	public void sort() {
		int l = this.arr.length;
		for(int i = 0; i < l - 1; ++i) {
			for(int j = i + 1; j < l; ++j) {
				if(this.arr[i] > this.arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
