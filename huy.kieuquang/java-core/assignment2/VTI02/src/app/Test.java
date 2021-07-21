package app;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(2);
		a.add(4);
		
		a.remove(2);
		
		for(int i=0; i<a.size(); i++) {
			System.out.print(a.get(i)+" ");
		}
		System.out.println();
		System.out.println(a.size());
	}
}
