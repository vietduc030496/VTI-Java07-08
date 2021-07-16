package b4;

public class SelectionSort extends NumberList implements Sort{

	@Override
	public void sort() {
		if(this.getLengOfList()>0) {
			int[] arr= this.getArray();
			int j;
			for(int i=0;i<this.getLengOfList();i++) {
				int temp=i;
				for(j=i+1;j<this.getLengOfList();j++) {
					if(arr[j] < arr[temp]) {
						temp=j;
					}
				}
				int swap= arr[i];
				arr[i]= arr[temp];
				arr[temp]= swap;
			}
			this.setArray(arr);
		}
		
	}

	public SelectionSort() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectionSort(int lengOfList) {
		super(lengOfList);
		// TODO Auto-generated constructor stub
	}

	

	
}
