package dao;

import java.util.List;

import mapper.RowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, RowMapper<T> rowmapper, Object... objects);
	
	void update(String sql, Object...objects);
	
	Long insert(String sql, Object...objects);
	
}
