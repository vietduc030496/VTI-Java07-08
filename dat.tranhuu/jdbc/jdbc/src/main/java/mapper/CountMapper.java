package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountMapper implements RowMapper<Integer>{

	@Override
	public Integer mapRow(ResultSet result) {
		try {
			return result.getInt("count");
		} catch (SQLException e) {
			return null;
		}
	}

}
