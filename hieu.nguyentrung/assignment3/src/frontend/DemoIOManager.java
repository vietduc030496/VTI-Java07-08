package frontend;

import java.util.Scanner;

import utils.IOManager;

public class DemoIOManager {
	public static void main(String[] args) throws Exception {
		IOManager IOM = new IOManager();
		String pathFile = "C:\\Users\\LENOVO\\Desktop\\Test456.txt";
		int choice;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("*****************");
			System.out.println("1.Read File!");
			System.out.println("2.Write File !");
			System.out.println("3.Write Object !");
			System.out.println("4.Read Object !");
			System.out.println("0.Exit!");
			System.out.println("*****************");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				IOM.readFile(pathFile);
				System.out.println();
				break;
			case 2:
				IOM.writeFile(pathFile, false, "asdascascadasdasfasas");;
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 0:
				System.exit(0);
				System.out.println("Bye!!");
			}
		}
	}
}
