package b4;

import java.util.Arrays;

public class QuickSort extends NumberList implements Sort{

	@Override
	public void sort() {
		if(this.getLengOfList()>0) {
			Arrays.sort(this.getArray());
			
		}
	}

	public QuickSort() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuickSort(int lengOfList) {
		super(lengOfList);
	}
	
	

}
