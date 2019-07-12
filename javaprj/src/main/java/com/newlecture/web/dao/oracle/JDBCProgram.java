package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		DriverManager driverManager;
//		Connection connection;
//		Statement statement;
//		ResultSet resultset;
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하세용 ^^: ");
		String a = sc.nextLine();
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER where id like '%"+a+"%'";
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement st = con.createStatement();
		
		
		ResultSet rs = st.executeQuery(sql);
	
		while(rs.next()) {
		
		String name = rs.getString("NAME");
		String id = rs.getString("id");
		String pw = rs.getString("pwd");
//		if(id.contains("J"))
			System.out.printf("id:%s,pw:%s,NAME:%s\n",id,pw, name);
		}
		
		rs.close();
		st.close();
		con.close();
		
	}
}
