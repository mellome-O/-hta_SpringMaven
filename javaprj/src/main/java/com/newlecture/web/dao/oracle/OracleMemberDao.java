package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.Notice;

public class OracleMemberDao implements MemberDao{

	 @Override
	   public Member get(String id) throws ClassNotFoundException, SQLException {
	      
	      Member member = null;
	      
	      String sql = "SELECT * FROM MEMBER WHERE ID = ?";
	      
	      String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	      PreparedStatement st = con.prepareStatement(sql);
	      st.setString(1, id); 
	      ResultSet rs = st.executeQuery();
	      
	      if (rs.next()) {
	         member = new Member(
	               rs.getString("id"), 
	               rs.getString("pwd"),
	               rs.getString("name"),
	               rs.getInt("gender"),
	               rs.getInt("age"),
	               rs.getString("birthday"),
	               rs.getString("phone"),
	               rs.getDate("regdate"),
	               rs.getString("boss_id"),
	               rs.getString("type")
	               );
	      }

	      rs.close();
	      st.close();
	      con.close();
	      
	      return member;
	   }

	   @Override
	   public int insert(Member member) throws ClassNotFoundException, SQLException {
	      // TODO Auto-generated method stub
	      return 0;
	   }

	   @Override
	   public int update(Member member) throws ClassNotFoundException, SQLException {
	      // TODO Auto-generated method stub
	      return 0;
	   }

	   @Override
	   public int delete(int id) throws ClassNotFoundException, SQLException {
	      // TODO Auto-generated method stub
	      return 0;
	   }



}