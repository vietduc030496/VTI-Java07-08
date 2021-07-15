package Exercise4;

public class SelectionSort extends NumberList implements Sort {
	public SelectionSort() {
		super();
	}

	public SelectionSort(int n) {
		super(n);
		
	}
	public void sort() {
		int[] arr=this.getArr();
		int min;
		for(int i=0;i<this.getN()-1;i++) {
			min=i;
			for(int j=i+1;j<this.getN();j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			if(min!=i) {
				int temp=arr[min];
				arr[min]=arr[i];
				arr[i]=temp;
			}
		}
		this.setArr(arr);
	}

}
