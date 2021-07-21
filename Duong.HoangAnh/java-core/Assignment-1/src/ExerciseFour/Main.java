package ExerciseFour;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter length of list number: ");
		int lengthList = scanner.nextInt();
		System.out.println("click 1 - quick sort, 2 - select sort, 3 - insert sort");
		int type = scanner.nextInt();
		if(type == 1) {
			QuickSort quick = new QuickSort(lengthList);
			quick.input();
			quick.sort();
			quick.print();
		}else if(type == 2) {
			SelectionSort select = new SelectionSort(lengthList);
			select.input();
			select.sort();
			select.print();
		}else if(type == 3) {
			InsertSort insert = new InsertSort(lengthList);
			insert.input();
			insert.sort();
			insert.print();
		}else {
		}
		scanner.close();
	}
}
