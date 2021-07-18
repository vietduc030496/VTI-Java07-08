package Ex3andEx4.frontend;

import Ex3andEx4.backend.constant.Contants;
import Ex3andEx4.backend.utils.FileManager;

import java.util.Scanner;
public class FileTest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Contants contants = new Contants();
        while (true) {
            int choose;
            System.out.println("                                   MENU                                 ");
            System.out.println("========================================================================");
            System.out.println("1. Kiem tra su ton tai cua path");
            System.out.println("2. Tao file moi");
            System.out.println("3. Xoa file");
            System.out.println("4. Kiem tra path la file hay folder");
            System.out.println("5. Lay danh sach cac file cua folder");
            System.out.println("6. Copy file");
            System.out.println("7. Moving file");
            System.out.println("8. Rename file");
            System.out.println("9. Tao folder moi");
            System.out.println("0. Thoat");
            System.out.println("========================================================================");
            System.out.print("Hay chon mot so: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1: {
                    String pathTrue = contants.pathTrue;
                    if (FileManager.isFileExists(pathTrue)) {
                        System.out.println("Ton tai duong dan:" + pathTrue);
                    } else {
                        System.out.println("Khong ton tai duong dan:" + pathTrue);
                    }
                    break;
                }
                case 2: {
                    String pathFolderTrue = contants.pathFolderTrue;
                    String nameF = "NewFile";
                    FileManager.createNewFile(pathFolderTrue, nameF);
                    break;
                }
                case 3: {
                    String pathToDelete = contants.pathtoDelete;
                    FileManager.deleteFile(pathToDelete);
                    break;
                }
                case 4:{
                    String pathFiOrFo= contants.pathFolderTrue;
                    if(FileManager.isFolder(pathFiOrFo)){
                        System.out.println("Day la duong dan cua Folder");
                    }
                    else {
                        System.out.println("Day la duong dan cua File");
                    }
                    break;
                }

                case 5:{
                    String pathFolderTrue = contants.pathFolderTrue;
                    FileManager.getAllFileName(pathFolderTrue);
                    break;
                }
                case 6: {
                    String pathTrue = contants.pathTrue;
                    String pathDes = contants.pathDes;
                    System.out.println("Nhap ten file moi:");
                    String newName = sc.nextLine();
                    FileManager.copyFile(pathTrue, pathDes, newName);
                    break;
                }
                case 7: {
                    String pathSource = contants.pathTrue;
                    String pathDes = contants.pathDes;
                    FileManager.moveFile(pathSource, pathDes);
                    break;
                }
                case 8: {
                    String pathTrue = contants.pathTrue;
                    String newFile = contants.newFile;
                    FileManager.renameFile(pathTrue, newFile);
                    break;
                }
                case 9:{
                    String pathFolder= contants.newFolderFalse;
                    FileManager.createNewFolder(pathFolder);
                    break;
                }
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
