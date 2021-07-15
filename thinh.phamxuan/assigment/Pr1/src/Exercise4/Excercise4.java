package Exercise4;

import java.util.Scanner;

public class Excercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Nhap n: \n");
		int n=scanner.nextInt();
		SelectionSort selectionSort= new SelectionSort(n);
		selectionSort.input();
		selectionSort.print();
		selectionSort.sort();
		selectionSort.print();
		System.out.println("Nhap m: \n");
		int m=scanner.nextInt();
		InsertSort insertSort= new InsertSort(m);
		insertSort.input();
		insertSort.print();
		insertSort.sort();
		insertSort.print();
	}

}
