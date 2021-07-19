package Run;

import Service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DepartmentManage dm = new DepartmentManage();
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (i > 0 && i < 8) {
            System.out.println("-------------------------------");
            System.out.println("1. Input data from keyboard");
            System.out.println("2. Display employees");
            System.out.println("3. Classify employees");
            System.out.println("4. Search employees by department's name");
            System.out.println("5. Search employees by employee's name");
            System.out.println("6. Show report");
            System.out.println("7. Delete employee");
            System.out.println("0. Exit");
            i = sc.nextInt();
            switch (i) {
                case 1:
                    dm.inputData();
                    break;
                case 2:
                    dm.displayEmployee();
                    break;
                case 3:
                    dm.classifyEmployee();
                    break;
                case 4:
                    dm.searchEmployeeByDepartment();
                    break;
                case 5:
                    dm.searchEmployeeByName();
                    break;
                case 6:
                    dm.report();
                    break;
                case 7:
                    dm.deleteEmployee();
                    break;
                default:
                    System.out.println("Bye bye!");
            }
        }
    }
}
