package Exercise4;

public class InsertSort  extends NumberList implements Sort {
	public InsertSort() {
		super();
	}

	public InsertSort(int n) {
		super(n);
		
	}
	public void sort() {
		int[] arr=this.getArr();
        int valueToInsert;
        int holePosition;
        for (int i = 1; i < this.getN(); i++) {
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
		this.setArr(arr);
	}
}
