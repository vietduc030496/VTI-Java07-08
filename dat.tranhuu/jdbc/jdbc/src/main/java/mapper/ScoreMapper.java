package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ScoreDto;

public class ScoreMapper implements RowMapper<ScoreDto>{

	@Override
	public ScoreDto mapRow(ResultSet result) {
		try {
			ScoreDto s = new ScoreDto();
			s.setFirstName(result.getString("first_name"));
			s.setName(result.getString("name"));
			s.setSocre(result.getFloat("score"));
			s.setStudentId(result.getLong("student_id"));
			s.setSubjectName(result.getString("subject_name"));
			s.setLopName(result.getString("lop_name"));
			s.setSubjectId(result.getLong("subject_id"));
			return s;
		}catch(SQLException e) {
			return null;
		}
	}

}
