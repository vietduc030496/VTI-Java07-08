package ex_04;

import java.util.Arrays;

public class QuickSort extends NumberList implements Sort {

	@Override
	public void sort() {
		Arrays.sort(this.getArray());	
		
	}

	public QuickSort() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
