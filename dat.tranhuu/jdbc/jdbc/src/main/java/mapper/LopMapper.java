package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Lop;

public class LopMapper implements RowMapper<Lop> {

	@Override
	public Lop mapRow(ResultSet result) {
		try {
			Lop lop = new Lop();
			lop.setId(result.getLong("id"));
			lop.setName(result.getString("name"));
			lop.setYear(result.getString("year"));
			return lop;
		}catch(SQLException e) {
			return null;
		}
	}

}
