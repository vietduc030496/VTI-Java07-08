
public class InsertionSort extends NumberList implements Sort {
	
	public InsertionSort() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InsertionSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	public void sort() {
		int l = this.arr.length;
		if(l <= 1) return;
		else {
			int i = 1;
			while(i < l) {
				int j = i;
				while(j > 0 && this.arr[j] < this.arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					j--;
				}
				i++;
			}
		}
	}
}
