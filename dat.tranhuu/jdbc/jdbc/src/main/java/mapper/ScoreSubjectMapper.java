package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.SubjectScore;

public class ScoreSubjectMapper implements RowMapper<SubjectScore>{

	@Override
	public SubjectScore mapRow(ResultSet result) {
		try {
			SubjectScore s = new SubjectScore();
			s.setSocre(result.getFloat("score"));
			s.setStudentId(result.getLong("student_id"));
			s.setSubjectId(result.getLong("subject_id"));
			return s;
		}catch(SQLException e) {
			return null;
		}
	}

}
