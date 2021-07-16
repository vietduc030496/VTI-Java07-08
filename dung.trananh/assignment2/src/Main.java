
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dung.trananh
 */
public class Main {

    public static void main(String[] args) {

        int choiceNumber;
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.println("1. Input data from the keyboard");
            System.out.println("2. Display employees");
            System.out.println("3. Classify employees");
            System.out.println("4. Employee Search");
            System.out.println("5. Report");
            System.err.println("0. Exit");
            do {
                System.out.println("Bấm số để chọn: ");
                choiceNumber = scanner.nextInt();
            } while ((choiceNumber < 1) || (choiceNumber > 8));
            switch (choiceNumber) {
                case 1:
//                    
                    break;
                case 2:
//                    
                    break;
                case 3:
//                    
                    break;
                case 4:
//                    
                    break;
                case 5:
//
                    break;
                case 0:
                    System.exit(0);
                    break;

            }
        }
    }
}
