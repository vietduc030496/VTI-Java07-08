package Exercise4;
import java.util.Scanner;
public class NumberList {
	private int n;
	private int[] arr;
	public NumberList() {
		super();
	}
	public NumberList(int n) {
		super();
		this.n = n;
		this.arr = new int[n];
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public void input() {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<n;i++) {
			this.arr[i]=sc.nextInt();
		}
	}
	public void print() {
		for(int i=0;i<n;i++) {
			System.out.print(this.arr[i]+" ");
		}
		System.out.print("\n");
	}

}
	

