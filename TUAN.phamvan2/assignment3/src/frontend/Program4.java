package frontend;

import backend.Exercise4;
import entity.Person;

public class Program4 {
	public static void main(String[] args) throws Exception {
		String folder1 = "src/entity/New folder 1";
		String folder2 = "src/entity/New folder 2";
		
		Exercise4 ex4 = new Exercise4();
		
		// Question 1
//		System.out.println(ex4.readFile(folder1 + "/" + "file2.txt"));
		
		// Question 2
//		String content = "day la content moi";
//		ex4.writeFile(folder1 + "/" + "file2.txt", true, content);
		
		// Question 3
//		Person p = new Person("Tuan", 22);
//		ex4.writeObject(p, folder2, "info.txt");
		
		// Question 4
		Person p = (Person) ex4.readObject(folder2 + "/" + "info.txt");
		System.out.println("Ten: " + p.getName() + ", Tuoi: " + p.getAge());
	}
}
