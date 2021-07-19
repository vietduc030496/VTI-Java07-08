import java.util.*;

public class NumberList {	
	public int[] arr;
	public void input() {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] tokens = line.split(" ");
		this.arr = new int[tokens.length];
		for (int i = 0; i < tokens.length;i++)
		    this.arr[i] = Integer.parseInt(tokens[i]);
	}
	
	public void print() {
		int l = this.arr.length;
		for(int i = 0; i < l; ++i) {
			System.out.print(this.arr[i] + " ");
		}
	}
	
	public NumberList() {
		
	}
	
	public NumberList(int n) {
		arr = new int[n];
	}
}
