package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class JDBC {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","44498948");
			String q = "select * from employees";
			PreparedStatement pre = con.prepareStatement(q);
			ResultSet res = pre.executeQuery();
			
			while (res.next()) {
				String s = res.getString("LAST_NAME");
				System.out.println(s);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			
			
		}
		

		
	}
}
