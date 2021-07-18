package frontend;

import java.io.IOException;
import entity.*;
import backend.Exercise4;

public class Program4 {
	public static void main(String[] args) throws IOException {
		Employee emp = new Employee();
		
		//Q1
		Exercise4.readFile(null);
		//Q2
//		Exercise4.writeFile(null, false, null);
//		//Q3
		Exercise4.writeObject(emp, null, null);
//		//Q4
//		Exercise4.readObject(null);
	}
}
