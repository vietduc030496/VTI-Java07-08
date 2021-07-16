package b4;

public class InsertSort extends NumberList implements Sort{

	@Override
	public void sort() {
		if(this.getLengOfList()>0) {
			int[] arr= this.getArray();
			int valueToInsert;
	        int holePosition;
	        for (int i = 1; i < arr.length; i++) {
	            valueToInsert = arr[i];
	            holePosition = i;
	            while (holePosition > 0 && arr[holePosition - 1] > valueToInsert) {
	                arr[holePosition] = arr[holePosition - 1];
	                holePosition--;
	            }
	            if (holePosition != i) {
	                arr[holePosition] = valueToInsert;
	            }
	        }
	        this.setArray(arr);
		}
	}

	public InsertSort() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsertSort(int lengOfList) {
		super(lengOfList);
		// TODO Auto-generated constructor stub
	}

	
}
