package ex_04;

public class InsertSort extends NumberList implements Sort {

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		int valueToInsert;
        int holePosition;
        int i;
		Integer[] arr = this.getArray();

 
        // lap qua tat ca cac so
        for (i = 1; i < arr.length; i++) {
 
            // chon mot gia tri de chen
            valueToInsert = arr[i];
 
            // lua chon vi tri de chen
            holePosition = i;
 
            // kiem tra xem so lien truoc co lon hon gia tri duoc chen khong
            while (holePosition > 0 && arr[holePosition - 1] > valueToInsert) {
                arr[holePosition] = arr[holePosition - 1];
                holePosition--;
            }
 
            if (holePosition != i) {
                // chen phan tu tai vi tri chen
                arr[holePosition] = valueToInsert;
            }
        }
	}

}
