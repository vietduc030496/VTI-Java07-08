package Ex3andEx4.backend.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    public static boolean isFileExists(String pathFile) {
        File fileName = new File(pathFile);
        if (fileName.exists()) {
            return true;
        }
        return false;
    }

    public static void createNewFile(String pathFile) throws Exception {
        if (!isFileExists(pathFile)) {
            File file = new File(pathFile);
            if (file.createNewFile()) {
                System.out.println("File is created");
            } else {
                System.out.println("Create file is failed");
            }
        } else {
            throw new Exception("Error! File Exist");
        }
    }

    public static void createNewFile(String path, String fileName) throws Exception {
        StringBuilder sb = new StringBuilder(path);
        sb.append("\\" + fileName);
        String pathFile = sb.toString();
        if (!isFileExists(pathFile)) {
            File file = new File(pathFile);
            if (file.createNewFile()) {
                System.out.println("File is created");
            } else {
                System.out.println("Create file is failed");
            }
        } else {
            throw new Exception("Error! File Exist");
        }
    }

    public static void deleteFile(String pathFile) {
        if (!isFileExists(pathFile)) {
            File file = new File(pathFile);
            if (file.delete()) {
                System.out.println(" Delete succesfully!");
            } else {
                System.out.println("Delete is failed!");
            }
        }
    }

    public static boolean isFolder(String path) {
        try {
            if (!isFileExists(path)) {
                File file = new File(path);
                if (file.isDirectory()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> getAllFileName(String path) {
        try {
            File file = new File(path);
            //check w folder is true?
            if (file.isDirectory()) {
                //get all file of folder
                List<String> listFiles = Arrays.asList(file.list());
                return listFiles;
            } else {
                throw new Exception("Error! Path is not folder");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void copyFile(String sourceFile, String distinationPath, String newName) throws Exception {
        File fileSource = new File(sourceFile);
        if (fileSource.exists()) {
            StringBuilder sb = new StringBuilder(distinationPath);
            sb.append("\\" + newName);
            String newFile = sb.toString();
            File fileDes = new File(newFile);
            if (fileDes.exists()) {
                throw new Exception("Error! newPath has File same name");
            } else {
                Files.copy(fileSource.toPath(), fileDes.toPath());
            }
        } else {
            try {
                throw new Exception("Error! Source File Not Exist");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyFile(String sourceFile, String newPath) throws Exception {
        File fileSource = new File(sourceFile);
        if (fileSource.exists()) {
            File fileDes = new File(newPath);
            if (fileDes.exists()) {
                throw new Exception("Error! newPath has File same name");
            } else {
                Files.copy(fileSource.toPath(), fileDes.toPath());
            }
        } else {
            try {
                throw new Exception("Error! Source File Not Exist");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void moveFile(String sourceFile, String destinationPath) throws Exception {
        File fileSource = new File(sourceFile);
        if (fileSource.exists()) {
            Path fileToMovePath = Paths.get(sourceFile);
            Path targetPath = Paths.get(destinationPath);
            Files.move(fileToMovePath, targetPath);
        } else {
            throw new Exception("Error! File Not Exist");
        }
    }

    public static void renameFile(String pathFile, String newName) throws Exception {
        File file = new File(pathFile);
        if (file.exists()) {
            File newFile = new File(newName);
            if (newFile.exists()) {
                throw new Exception("Error! Name is Exist");
            } else {
                file.renameTo(newFile);
                System.out.println("Rename Success");
            }
        } else {
            throw new Exception("Error! File not exist");
        }
    }

    public static void createNewFolder(String newPathFolder) throws Exception {
        File fileDir = new File(newPathFolder);
        if (fileDir.isDirectory()) {
            throw new Exception("Error! Folder Exist");
        } else {
            Files.createDirectories(fileDir.toPath());
        }
    }
}
