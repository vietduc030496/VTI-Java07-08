package Ex3andEx4.backend.utils;

import Ex3andEx4.backend.model.Employee;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

import static Ex3andEx4.backend.utils.FileManager.isFileExists;

public class IOManager {
    public static String readFile(String pathFile) {
        String fileRead = "";
        try {
            if (isFileExists(pathFile)) {
                FileInputStream fileInputStream = new FileInputStream(pathFile);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                while (line != null) {
                    fileRead += line + "\n";
                    line = bufferedReader.readLine();

                }
                bufferedReader.close();
                fileInputStream.close();
            } else {
                throw new Exception("Error! File not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileRead;
    }

    public static void writeFile(String pathFile, boolean isContinuing, String content) throws Exception {
        try {
            if (isFileExists(pathFile)) {
                FileOutputStream fileOutputStream = new FileOutputStream(pathFile, isContinuing);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                bufferedWriter.write(content);
                bufferedWriter.close();
                fileOutputStream.close();
            } else {
                throw new Exception("Error! File not Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writerObject(Employee employee, String path, String fileName) {
        try {
            if (employee == null) {
                throw new Exception("Error! Object is Null!");
            }
            File folder = new File(path);
            if (!folder.isDirectory()) {
                folder.mkdir();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/" + fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(fileOutputStream); // dung de ghi theo Object vao file f
            oStream.writeObject(employee);   // ghi student theo kieu Object vao file
            oStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Employee reafObject(String filePath) {
        Employee employee = null;
        try {
            if (!isFileExists(filePath)) {
                throw new Exception("Error! File Not Exist.");
            }
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            employee = (Employee) inputStream.readObject();
            fileInputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
}
