package ToolJDBC.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.mysql.cj.jdbc.CallableStatement;

import ToolJDBC.constant.SqlConstant;
import ToolJDBC.entity.SinhVien;
import ToolJDBC.utils.DBConnection;

public class StoreProcedurers {

	private Connection con;

	private Statement sta;
	
	private CallableStatement csa;
	
	public void topSV(int id) throws SQLException {
		ResultSet result = null;
		con=DBConnection.getInstance().getConnection();
		sta=null;
		ResultSet rs =null;
		PreparedStatement sta1 =con.prepareStatement(SqlConstant.SELECT_TOP_SINH_VIEN);
		sta1.setInt(1,id );
		result=sta1.executeQuery();
		while(result.next()) {
			String ten =result.getString("Ten");
			int diem= result.getInt("Diem");
			System.out.println("Ten :"+ten+"diem : "+diem);
			
		}
		
	}
	public int avgScore(int id) throws SQLException {
		int result = 0;
		con=DBConnection.getInstance().getConnection();
		sta=null;
		ResultSet rs =null;
		 csa =(CallableStatement) con.prepareCall(SqlConstant.AVG_SCORE);
		csa.setInt(1,id );
		csa.registerOutParameter(2, Types.INTEGER);
		csa.execute();
		result =csa.getInt(2);
		return result ;
	
		
	}
	public int tuitionFee(int id) throws SQLException {
		int result = 0;
		con=DBConnection.getInstance().getConnection();
		sta=null;
		ResultSet rs =null;
		 csa =(CallableStatement) con.prepareCall(SqlConstant.TUITION_FEE);
		csa.registerOutParameter(1, Types.DOUBLE);
		 csa.setInt(2,id );
		
		csa.execute();
		result =csa.getInt(1);
		return result ;
	
		
	}
}
