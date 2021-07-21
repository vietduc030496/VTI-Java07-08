package ex_04;

import java.util.Scanner;

public class NumberList {
	Integer[] array; 
	int n;
	public void input() {
		Scanner s = new Scanner(System.in);
		do {
	        System.out.println("nhap vao so phan tu n: ");
	        n = s.nextInt();
	    } while (n < 0);
		
		NumberList(n);
		
		System.out.println("Nhap cac phan tu cua mang: ");
	    for (int i = 0; i < n; i++) {
	        System.out.print("Nhap phan tu thu " + i + ": ");
	        array[i] = s.nextInt();
	    }
	}

	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	public void NumberList(int n) {
		array = new Integer[n];
	}

	public Integer[] getArray() {
		return array;
	}

	public void setArray(Integer[] array) {
		this.array = array;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
}
