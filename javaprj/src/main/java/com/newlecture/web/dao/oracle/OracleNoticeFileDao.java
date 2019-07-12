package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.NoticeFile;

public class OracleNoticeFileDao implements com.newlecture.web.dao.NoticeFileDao {

   @Override
   public List<NoticeFile> getListByNoticeId(int noticeId) throws ClassNotFoundException, SQLException {
	List<NoticeFile> list = new ArrayList<>();
		
		
		String sql ="SELECT * FROM NOTICE_FILE WHERE NOTICE_ID=?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setInt(1,noticeId);

		ResultSet rs = st.executeQuery(); //꺼내오기


		while (rs.next()) {
			NoticeFile noticeFile = new NoticeFile(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getInt("notice_id")
				);
			list.add(noticeFile);
		}
		
		
		rs.close();
		st.close();
		con.close();
		
		return list;
		
   }

   @Override
   public int insert(NoticeFile noticeFile) throws ClassNotFoundException, SQLException {
      int result = 0;
      /*
       * String sql = String.format("insert into notice values(%d,'%s','%s',%s,%d)",
       * notice.getId(), notice.getTitle(), notice.getWriterId(), null,
       * notice.getHit());
       */
      String sql = "INSERT INTO NOTICE_FILE(ID, NAME, NOTICE_ID) " 
       + "VALUES (NOTICE_FILE_SEQ.NEXTVAL, ? ,?)";
      String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
      // Statement st = con.createStatement();
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, noticeFile.getName());
      st.setInt(2, noticeFile.getNoticeId());
      // st.setInt(3, notice.getId());
      /*
       * ResultSet a = st.executeQuery(sql); //만들어진 테이블 조회해서 가져오기
       */
      result = st.executeUpdate();// 연동된 DB에 입력하기

      st.close();
      con.close();

      return result;
   }

   @Override
   public int update(NoticeFile noticeFile) throws ClassNotFoundException, SQLException {
      int result = 0;

      String sql = "UPDATE NOTICE_FILE SET NAME=?, NOTICE_ID=? WHERE ID=?";

      String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");

      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, noticeFile.getName());
      st.setInt(2, noticeFile.getNoticeId());
      st.setInt(3, noticeFile.getId());

      result = st.executeUpdate();

      st.close();
      con.close();

      return result;
   }

   @Override
   public int delete(int id) throws ClassNotFoundException, SQLException {
      int result = 0;

      String sql = "DELETE NOTICE_FILE WHERE ID=?";

      String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");

      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, id);

      result = st.executeUpdate();

      st.close();
      con.close();

      return result;
   }

}