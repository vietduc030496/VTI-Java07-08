package app;

import java.sql.SQLException;
import java.util.List;

import entity.Department;
import service.DepartmentService;

public class Main {

	public static void main(String[] args) throws SQLException {
		DepartmentService service = new DepartmentService();

		List<Department> departments = service.getDepartments();
		for (Department department : departments) {
			System.out.println(department);
		}

		System.out.println("----------------------");

		Department detpById = service.getDetpById(3);
		System.out.println(detpById);
	}

}
