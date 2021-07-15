package ex_04;

public class SelectionSort extends NumberList implements Sort {

	@Override
	public void sort() {
		int indexMin, i, j;
		Integer[] arr = this.getArray();
		 
        // lap qua ta ca cac so
        for (i = 0; i < arr.length - 1; i++) {
            // thiet lap phan tu hien tai la min
            indexMin = i;
 
            // kiem tra phan tu hien tai co phai la nho nhat khong
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
 
            if (indexMin != i) {
                // Trao doi cac so
                int temp = arr[indexMin];
                arr[indexMin] = arr[i];
                arr[i] = temp;
            }

        }
		
	}

}
