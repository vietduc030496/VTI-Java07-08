package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Student;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet result) {
		try {
			Student student = new Student();
			student.setId(result.getLong("id"));
			student.setAddress(result.getString("address"));
			student.setEmail(result.getString("email"));
			student.setLopId(result.getLong("lop_id"));
			student.setName(result.getString("name"));
			student.setFirstName(result.getString("first_name"));
			student.setGender(result.getString("gender"));
			student.setPhone(result.getString("phone"));
			student.setDob(result.getDate("dob"));
			
			return student;
		}catch(SQLException e) {
			return null;
		}
	}

}
