package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dto.ScoreDto;
import dto.StudentDto;
import entity.Lop;
import entity.Student;
import utils.ValidUtil;

public class App {

	public void showMenu() {
		System.out.println("--------------------------------------------");
		System.out.println("1. Thêm sinh viên");
		System.out.println("2. Danh sách sinh viên");
		System.out.println("3. Hiện thị số lượng học sinh nam/nữ của các lớp");
		System.out.println("4. Xem điển của sinh viên");
		System.out.println("5. Thông tin sinh viên của từng lớp");
		System.out.println("6. Thông tin sinh viên có điểm thấp nhất của mỗi môn học");
		System.out.println("7. Thông tin sinh viên có điểm thuộc top 5");
		System.out.println("8. Điểm trung bình của sinh viên ");
		System.out.println("9. Tiền học theo số tín chỉ của sinh viên  ");
		System.out.println("10. Thoát");
		
		
	}

	public Student inputStudent(Scanner input, List<Lop> list) throws ParseException {
		SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
		Student s = new Student();
		System.out.print("firstName:");
		s.setFirstName(input.nextLine());
		System.out.print("name: ");
		s.setName(input.nextLine());
		System.out.print("email: ");
		boolean validEmail = false;
		String email = "";
		while (validEmail == false) {
			email = (input.nextLine());
			validEmail = ValidUtil.validEmail(email);
			if (validEmail == false) {
				System.out.println("invalid email, input email again: ");
			}
		}
		s.setEmail(email);
		System.out.print("gender(MALE/FEMALE):");
		s.setGender(input.nextLine().toUpperCase());
		System.out.print("dob:");
		String dateS = "";
		validEmail = false;
		while (validEmail == false) {
			dateS = (input.nextLine());
			validEmail = ValidUtil.validDate(dateS);

			if (validEmail == false) {
				System.out.println("invalid dob, input dob again: ");
			}
		}
		s.setDob(spd.parse(dateS));
		System.out.print("address:");
		s.setAddress(input.nextLine());

		System.out.print("phone:");
		String phone = "";
		validEmail = false;
		while (validEmail == false) {
			phone = (input.nextLine());
			validEmail = ValidUtil.validPhone(phone);
			if (validEmail == false) {
				System.out.println("invalid email, input email again: ");
			}
		}
		s.setPhone(phone);
		System.out.println("lopId(chọn 1 trong các lớp sau):");
		this.showLop(list);
		String lopId = "";
		validEmail = false;
		while (validEmail == false) {
			lopId = (input.nextLine());

			try {
				for (Lop l : list) {
					if (Long.parseLong(lopId) == l.getId()) {
						validEmail = true;
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("nhập sai id vui lòng nhập lại");
			}
			if (validEmail == false) {
				System.out.println("nhập sai id vui lòng nhập lại");
			}
		}
		s.setLopId(Long.parseLong(lopId));

		return s;
	}

	public void showStudent(List<StudentDto> list) {
		SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
		for (StudentDto s : list) {
			System.out
					.println("mã sv: " + s.getId() + ", tên: " + s.getFirstName() + " " + s.getName() + ", ngày sinh: "
							+ spd.format(s.getDob()) + ", giới tính: " + s.getGender() + ",lớp: " + s.getNameLop());
		}
	}
	
	public void showStudentEntity(List<Student> list) {
		SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
		if(list!=null && list.size()>0) {
			for (Student s : list) {
				System.out
						.println("mã sv: " + s.getId() + ", tên: " + s.getFirstName() + " " + s.getName() + ", ngày sinh: "
								+ spd.format(s.getDob()) + ", giới tính: " + s.getGender());
			}
		}else {
			System.out.println("không có sinh viên phù hợp: ");
		}
		
	}

	public void showLop(List<Lop> list) {
		for (Lop l : list) {
			System.out.println(l.getId() + ". tên: " + l.getName() + " niên khóa: " + l.getYear());
		}
	}
	
	public Long inputID(Scanner input) {
		String lopId = "";
		Boolean validEmail = false;
		while (validEmail == false) {
			System.out.println("nhập id: ");
			lopId = (input.nextLine());

			try {
				Long.parseLong(lopId);
				validEmail=true;
			} catch (Exception e) {
				System.out.println("nhập sai id vui lòng nhập lại");
			}
			if (validEmail == false) {
				System.out.println("nhập sai id vui lòng nhập lại");
			}
		}
		return Long.parseLong(lopId);
	}

	public void showScore(List<ScoreDto> list) {
		if(list!=null && list.size()>0) {
			for(ScoreDto s : list) {
				System.out.println("mã sv: "+s.getStudentId()+", lớp: "+s.getLopName()+", môn học: "+s.getSubjectName()
				+", điểm: "+s.getSocre());
			}
		}else {
			System.out.println("Không có điểm cho sinh viên này");
		}
	}
}
