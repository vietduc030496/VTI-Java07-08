package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.IOManager;
import com.vti.entity.Person;

public class Ex4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IOManager run = new IOManager();

		boolean exit = false;

		// change path to apply
		String path = "";

		while (exit == false) {
			System.out.print("Choose option: ");
			int x = sc.nextInt();
			switch (x) {
			case 1: {
				System.out.println(run.readFile(path));
				break;
			}
			case 2: {
				System.out.print("Nhap noi dung");
				String content = sc.next();
				System.out.print("isContinuing: ");
				boolean isContinuing = sc.nextBoolean();
				run.writeFile(path, content, isContinuing);
			}
			case 3: {
				Person person = new Person("test", "male");
				run.writeObject(person, path);
			}
			case 4: {
				Person person = (Person) run.readObject(path);
				System.out.println(person.toString());
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + x);
			}
		}
		sc.close();
	}
}
