package app;

import entity.*;
import service.ClassroomService;
import service.StudentService;
import service.SubjectService;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentService studentService = new StudentService();
    static ClassroomService classroomService = new ClassroomService();
    static SubjectService subjectService = new SubjectService();

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        while (true) {
            int choose;
            System.out.println("                                   MENU                                 ");
            System.out.println("========================================================================");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Hien thi so luong Nam/Nu cua lop hoc");
            System.out.println("4. Xem bang diem cua sinh vien");
            System.out.println("5. Dem so sinh vien cua cac lop hoc");
            System.out.println("6. Tim sinh vien co diem thap nhat cua mon hoc");
            System.out.println("7. Lay thong tin sinh vien co diem top 5 cao nhat theo ID mon hoc");
            System.out.println("8. Tinh diem trung binh sinh vien");
            System.out.println("9. Tinh tien hoc phi sinh vien");
            System.out.println("0. Thoat");
            System.out.println("========================================================================");
            System.out.print("Hay chon mot so: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    Student st = studentService.inputStudent();
                    if (studentService.insertStudent(st) == 1) System.out.println("Insert thanh cong!");
                    try {
                        studentService.sendMailText(st.getEmail());
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    List<StudentWithClassName> students = studentService.getAllStudents();
                    for (StudentWithClassName student : students) {
                        System.out.println(student);
                    }
                    break;
                case 3:
                    List<NumberOfGenderClass> numberOfGenderClassList = classroomService.getAmountGender();
                    for (NumberOfGenderClass genderClass : numberOfGenderClassList) {
                        System.out.println(genderClass);
                    }
                    break;
                case 4:
                    System.out.println("Nhap ID sinh vien ban muon xem diem:");
                    int idSt1 = sc.nextInt();
                    List<MarkOfStudent> marks = studentService.getMarkOfStudent(idSt1);
                    if (marks.isEmpty()) System.out.println("ID sinh vien khong ton tai!");
                    else {
                        for (MarkOfStudent mark : marks) {
                            System.out.println(mark);
                        }
                    }
                    break;
                case 5:
                    List<Classroom> classrooms = classroomService.getAmountStudent();
                    for (Classroom classroom : classrooms) {
                        System.out.println(classroom);
                    }
                    break;
                case 6:
                    List<SubjectWithMark> minMarkOfStudents = subjectService.getMarkOfSubjectMin();
                    for (SubjectWithMark minMarkOfStudent : minMarkOfStudents) {
                        System.out.println(minMarkOfStudent.toStringMinMark());
                    }
                    break;
                case 7:
                    System.out.println("Nhap ID mon hoc ban muon xem :");
                    int idSj = sc.nextInt();
                    List<SubjectWithMark> topMarks = subjectService.getMarkTop5OfSubject(idSj);
                    if (topMarks.isEmpty()) System.out.println("ID mon hoc khong ton tai!");
                    else {
                        for (SubjectWithMark topMark : topMarks) {
                            System.out.println(topMark.toStringMark());
                        }
                    }
                    break;
                case 8:
                    System.out.println("Nhap ID sinh vien ban muon xem diem TB:");
                    int idSt2 = sc.nextInt();
                    StudentWithAVGMark avgMark = studentService.getMarkAVGOfStudent(idSt2);
                    if (avgMark.getStudentId() == 0) System.out.println("ID sinh vien khong ton tai!");
                    else System.out.println(avgMark);
                    break;
                case 9:
                    System.out.println("Nhap ID sinh vien ban muon xem tong hoc phi:");
                    int idSt3 = sc.nextInt();
                    TuitionOfStudent tuition = studentService.getTuition(idSt3);
                    if (tuition.getStudentId() == 0) System.out.println("ID sinh vien khong ton tai!");
                    else System.out.println(tuition);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
