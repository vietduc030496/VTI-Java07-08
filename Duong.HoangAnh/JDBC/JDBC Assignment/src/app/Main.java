package app;

import java.sql.SQLException;
import java.util.*;
import service.*;
import constant.NotificationConstant;

public class Main {
	public static void main(String[] args) throws SQLException {
		StudentService studentService = new StudentService();
		ClassService classService = new ClassService();
		SubjectService subjectService = new SubjectService();
		Scanner input = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("------------- Menu -------------");
				System.out.println("1 - Add student");
				System.out.println("2 - Show all student");
				System.out.println("3 - Show amount gender in a class");
				System.out.println("4 - Show mark board of a student");
				System.out.println("5 - Show list student follow each class");
				System.out.println("6 - Show student min mark each subject");
				System.out.println("7 - Show student in three top mark each subject");
				System.out.println("8 - Show average mark of student");
				System.out.println("9 - Show amount monney of credits of student");

				System.out.print("Enter option: ");

				int type = input.nextInt();
				input.nextLine();
				switch (type) {
				case 1:
					studentService.inputStudent(input);
					break;
				case 2:
					studentService.showAllStudent();
					break;
				case 3:
					classService.showAmountMaleAndFemaleInClass();
					break;
				case 4:
					studentService.showMarkBoardStudent(input);
					break;
				case 5:
					classService.displayStudentAllClass();
					break;
				case 6:
					subjectService.displayStudentMinMarkInSubject();
					break;
				case 7:
					subjectService.showStudentInThreeTop(input);
					break;
				case 8:
					studentService.find_average_mark_student(input);
					break;
				case 9:
					studentService.show_monney_credits_student(input, 500);
					break;
				default:
					System.out.println(NotificationConstant.NO_HAVE_OPTION);
					break;
				}
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println(NotificationConstant.NO_HAVE_OPTION);
		}

	}
}
