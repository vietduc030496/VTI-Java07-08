package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.GenericDAO;
import mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3307/jdbcvti";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowmapper, Object... objects) {
		List<T> results = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			statement = con.prepareStatement(sql);
			setPara(statement, objects);
			rs = statement.executeQuery();
			while (rs.next()) {
				results.add(rowmapper.mapRow(rs));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}
	
	public List<T> queryCall(String sql, RowMapper<T> rowmapper, Object... objects) {
		List<T> results = new ArrayList<>();
		Connection con = null;
		CallableStatement statement = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			statement = con.prepareCall(sql);
			setPara1(statement, objects);
			boolean hadResults = statement.execute();
			while(hadResults) {
				rs= statement.getResultSet();
				while (rs.next()) {
					results.add(rowmapper.mapRow(rs));
				}
				hadResults = statement.getMoreResults();
			}
			
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}
	
	
	public Integer queryCallFunction(String sql, Long id) {
		Connection con = null;
		CallableStatement statement = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			statement = con.prepareCall(sql);
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			statement.setLong(2, id);
			statement.execute();
			return statement.getInt(1);
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}

	private void setPara(PreparedStatement statement, Object... objects) {
		// TODO Auto-generated method stub
		SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int index = 1;
			for (Object object : objects) {
				if (object instanceof Long) {
					statement.setLong(index, (Long) object);
				} else if (object instanceof String) {
					statement.setString(index, (String) object);
				} else if (object instanceof Integer) {
					statement.setInt(index, (Integer) object);
				}else if (object instanceof Date) {
					statement.setString(index, (String) spd.format(object) );
				}else if (object instanceof Float) {
					statement.setFloat(index, (Float) object );
				}
				
				index++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private void setPara1(CallableStatement statement, Object... objects) {
		// TODO Auto-generated method stub
		SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int index = 1;
			for (Object object : objects) {
				if (object instanceof Long) {
					statement.setLong(index, (Long) object);
				} else if (object instanceof String) {
					statement.setString(index, (String) object);
				} else if (object instanceof Integer) {
					statement.setInt(index, (Integer) object);
				}else if (object instanceof Date) {
					statement.setString(index, (String) spd.format(object) );
				}else if (object instanceof Float) {
					statement.setFloat(index, (Float) object );
				}
				
				index++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(String sql, Object... objects) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			setPara(statement, objects);
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... objects) {
		ResultSet rs = null;
		Long id = null;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setPara(statement, objects);
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getLong(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			System.out.print("khong the them du lieu tt lien ket sai");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				return null;
			}
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}

		}
	}


}
