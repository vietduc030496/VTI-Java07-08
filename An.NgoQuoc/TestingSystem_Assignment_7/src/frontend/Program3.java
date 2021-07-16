package frontend;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import backend.Exercise3;

public class Program3 {
	public static void main(String[] arg) {
		Exercise3 ex3 = new Exercise3();
		try {
			List<String> a = ex3.getAllFileName("C:\\Users\\an.ngoquoc\\Desktop\\JAVA");
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
