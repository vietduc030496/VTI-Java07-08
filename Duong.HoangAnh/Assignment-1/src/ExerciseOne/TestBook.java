package ExerciseOne;

public class TestBook {
	Book[] listBook = new Book[30];
	public void spawnerBook() {
		for(int i = 0; i < 30; i++) {
			Book book = new Book("book name " + i, "publisher " + i, "auther " + i, i);
			listBook[i] = book;
		}
	}
	public void printBook() {
		for(int i = 0; i <30; i++) {
			System.out.println(listBook[i].getBookInfo());
		}
	}
}