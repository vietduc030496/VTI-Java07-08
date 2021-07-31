package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import dto.StudentDto;

public class StudentDtoMapper implements RowMapper<StudentDto>{

	@Override
	public StudentDto mapRow(ResultSet result) {
		try {
			StudentDto sdto= new StudentDto();
			sdto.setId(result.getLong("id"));
			sdto.setAddress(result.getString("address"));
			sdto.setEmail(result.getString("email"));
			sdto.setLopId(result.getLong("lop_id"));
			sdto.setName(result.getString("name"));
			sdto.setFirstName(result.getString("first_name"));
			sdto.setGender(result.getString("gender"));
			sdto.setPhone(result.getString("phone"));
			sdto.setDob(result.getDate("dob"));
			sdto.setNameLop(result.getString("lop_name"));
			sdto.setYear(result.getString("lop_year"));
			
			return sdto;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
