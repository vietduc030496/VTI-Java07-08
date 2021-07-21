package b4;

import java.util.Scanner;

public class NumberList {

	private int lengOfList;
	private int[] array;
	public int getLengOfList() {
		return lengOfList;
	}
	public void setLengOfList(int lengOfList) {
		this.lengOfList = lengOfList;
	}
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	public NumberList(int lengOfList) {
		super();
		this.lengOfList = lengOfList;
		this.array = new int[this.lengOfList];
	}
	
	public void input() {
		if(this.lengOfList>0) {
			System.out.println("nhap:");
			Scanner input= new Scanner(System.in);
			for(int i=0;i<this.lengOfList;i++) {
				this.array[i]= input.nextInt();
			}
			input.close();
		}
		
	}
	public void print() {
		if(this.lengOfList>0) {
			for(int i=0;i<this.lengOfList;i++) {
				System.out.print(this.array[i]+" ");
			}
			System.out.println();
		}
		
	}
	public NumberList() {
		super();
	}
	
	
}
