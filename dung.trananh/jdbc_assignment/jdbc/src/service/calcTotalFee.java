package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import utils.DBconnection;

public class calcTotalFee {
	static Scanner in = new Scanner(System.in);
	private static Connection con;
	
	public static void calcTotalFeeByIDSV() throws SQLException{
		System.out.println("Nhap id cua sinh vien: ");
		int id = Integer.parseInt(in.nextLine());
		
		con = DBconnection.getInstance().getConnection();
		CallableStatement cs = null;

		try {
			cs = con.prepareCall("{? = call calcTotalFee(?)}");
			cs.registerOutParameter(1, Types.FLOAT);
			cs.setInt(2, id);
			cs.execute();

			System.out.println("idsv: " + id + ", tonghocphi: "+ cs.getFloat(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBconnection.closeCallableStatement(cs);
			DBconnection.closeConnection(con);
		}
	}
}
