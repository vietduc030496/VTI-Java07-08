package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Subject;

public class SubjectMapper implements RowMapper<Subject>{

	@Override
	public Subject mapRow(ResultSet result) {
		try {
			Subject lop = new Subject();
			lop.setId(result.getLong("id"));
			lop.setName(result.getString("name"));
			lop.setNumber(result.getInt("number"));
			return lop;
		}catch(SQLException e) {
			return null;
		}
	}

}
