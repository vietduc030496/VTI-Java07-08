package app;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import constant.SQLQuery;
import dao.impl.CountDAO;
import dao.impl.LopDAO;
import dao.impl.ScoreDtoDAO;
import dao.impl.StudentDAO;
import dao.impl.StudentDtoDAO;
import dao.impl.SubjectScoreDAO;
import dto.ScoreDto;
import dto.StudentDto;
import entity.Lop;
import entity.Student;
import entity.SubjectScore;
import service.LopService;
import service.StudentServiceImpl;

public class Main {
	public static void main(String[] args) throws ParseException {
		
		StudentDAO sDAO = new StudentDAO();
		StudentDtoDAO sDtoDAO = new StudentDtoDAO();
		StudentServiceImpl sService= new StudentServiceImpl(sDAO,sDtoDAO);
		
		LopDAO lopDAO = new LopDAO();
		LopService lService= new LopService(lopDAO);
		
		CountDAO cDAO = new CountDAO();
		ScoreDtoDAO scoreDAO = new ScoreDtoDAO();
		
		SubjectScoreDAO ssDAO = new SubjectScoreDAO();
		
		App app = new App();
		Scanner input = new Scanner(System.in);
		boolean isRun = true;
		app.showMenu();
		String type="";
		while (isRun) {
			type = input.nextLine();
			switch (type) {
			case "1":
				Student s = app.inputStudent(input,lopDAO.findAll());
				sService.saveOrUpdate(s);
				app.showMenu();
				break;
			case "2":
				List<StudentDto> listSDto= sService.findAllDto();
				app.showStudent(listSDto);
				app.showMenu();
				break;
			case "3":
				List<Lop> listLop= lService.findAll();
				if(listLop!=null && listLop.size()>0) {
					for(Lop l : listLop) {
						System.out.println("Trong lớp "+l.getName()+" có:");
						System.out.println(cDAO.countStudentByGender("MALE", l.getId())+ " sinh viên nam");
						System.out.println(cDAO.countStudentByGender("FEMALE", l.getId())+ " sinh viên nữ");
					}
					
				}
				app.showMenu();
				break;
			case "4":
				Long id = app.inputID(input);
				app.showScore(scoreDAO.findByStudent(id));
				app.showMenu();
				break;
				
			case "5":
				List<Lop> listLop1= lService.findAll();
				if(listLop1!=null && listLop1.size()>0) {
					for(Lop l : listLop1) {
						System.out.println("Trong lớp "+l.getName()+" có: "+ cDAO.countStudentByLop(l.getId())+" sinh viên.");
						app.showStudentEntity(sService.findByLop(l.getId()));
					}
					
				}
				app.showMenu();
				break;
				
			case "6":
				List<ScoreDto> listScore = scoreDAO.findByScoreMin();
				if(listScore!=null && listScore.size()>0) {
					for(ScoreDto l : listScore) {
						System.out.println("Môn học : "+l.getSubjectName()+" có điểm thấp nhất: "+l.getSocre()+" gồm các sinh viên :");
						app.showStudentEntity(sService.findByScoreSubject(l.getStudentId(), l.getSocre()));
					}
				}else {
					System.out.println("Không có điểm các môn học");
				}
				app.showMenu();
				break;
			case "7":
				System.out.println("Vui lòng nhập mã môn học:");
				Long subjectId= app.inputID(input);
				app.showStudentEntity(sService.findByTop5ScoreSubject(subjectId));
				app.showMenu();
				break;
			case "8":
				System.out.println("Vui lòng nhập mã sinh viên:");
				Long studentId= app.inputID(input);
				List<SubjectScore> listSS= ssDAO.getARGByIdStudent(studentId);
				if(listSS!=null && listSS.size()>0) {
					System.out.println("điểm trung binh là : " + listSS.get(0).getSocre());
				}else {
					System.out.println("Không có điểm các môn học");
				}
				app.showMenu();
				break;
			case "9":
				System.out.println("Vui lòng nhập mã sinh viên:");
				Long studentId1= app.inputID(input);
				Integer total = sService.getTotal(studentId1);
				if(total!=null) {
					System.out.println("Tiền học phí của sinh viên này là: "+ total * SQLQuery.FEE+"k");
				}else {
					System.out.println("Không tìm thấy học phí");
				}
				app.showMenu();
				break;
			case "10":
				isRun=false;
				break;
			default:
				break;
			}
		}
	}
}
