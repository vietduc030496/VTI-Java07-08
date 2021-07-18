package Exercise1;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book[] arr ;
		arr=new Book[30];	
		for(int i=0;i<30;i++) {
			arr[i]=new Book("Sach"+i,i,"TacGia"+i,"KimDong");
			String rs=arr[i].getBookInfo();
			System.out.println(rs);
		}
	}

}
