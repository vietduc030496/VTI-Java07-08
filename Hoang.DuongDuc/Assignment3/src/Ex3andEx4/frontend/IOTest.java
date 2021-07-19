package Ex3andEx4.frontend;

import Ex3andEx4.backend.constant.Contants;
import Ex3andEx4.backend.model.Employee;
import Ex3andEx4.backend.utils.FileManager;
import Ex3andEx4.backend.utils.IOManager;

import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contants contants = new Contants();
        while (true) {
            int choose;
            System.out.println("                                   MENU                                 ");
            System.out.println("========================================================================");
            System.out.println("1. In ra noi dung file");
            System.out.println("2. Viet vao file");
            System.out.println("3. Write Object");
            System.out.println("4. Read Object");
            System.out.println("0. Thoat");
            System.out.println("========================================================================");
            System.out.print("Hay chon mot so: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.println(IOManager.readFile(contants.pathFiletoRead));
                    break;
                case 2:
                    System.out.println("Nhap content:");
                    String content = sc.nextLine();
                    System.out.println("Muon viet tiep vao sau file hay xoa du lieu cua cua file ? [1-yes/0-no]");
                    int isContinue = sc.nextInt();
                    try {
                        IOManager.writeFile(contants.pathFiletoWrite, isContinue == 1, content);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Moi nhap ten nhan vien:");
                    String nameEmployee = sc.nextLine();
                    System.out.println("Moi nhap tuoi nhan vien:");
                    int ageEmployee = sc.nextInt();
                    Employee employee = new Employee(nameEmployee, ageEmployee);
                    IOManager.writerObject(employee, contants.pathToCreateFileFromOb, "Nhanvien1.txt");
                    break;
                case 4:
                    Employee e = IOManager.reafObject(contants.pathToReadFileFromOb);
                    System.out.println("Thong tin Object:");
                    System.out.println("Ten nhan vien:" + e.getEmployeeName());
                    System.out.println("Tuoi nhan vien:" + e.getAge());
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
