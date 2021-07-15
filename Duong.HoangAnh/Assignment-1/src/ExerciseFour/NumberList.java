package ExerciseFour;
import java.util.*;

public class NumberList {
	private int[] list;
	public NumberList(int n) {
		list = new int[n];
	}
	public int[] getList() {
		return list;
	}
	public void input() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter list number: ");
		for(int i = 0; i < this.list.length; i++) {
			list[i] = input.nextInt();
		}
		input.close();
		return;
	}
	public void print() {
		for(int i = 0; i < this.list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}
}
