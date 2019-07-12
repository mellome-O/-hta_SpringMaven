package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
@Repository
public class OracleNoticeDao implements NoticeDao {

	@Override
	public List<NoticeView> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1,"title","");
	}

	@Override
	public List<NoticeView> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(page,"title","");
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		List<NoticeView> list = new ArrayList<>();
		
		int pageSize = 10;
		int start = 1+(page-1)*pageSize;  //1,11,21,31,41...1+(page-1)*10
		int end = page * pageSize; 			//10,20,30.40,50
		
		String sql ="SELECT * FROM NOTICE_VIEW" + 
				" WHERE "+field+" LIKE ? AND NUM BETWEEN ? and ?";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,"%"+query+"%");
		st.setInt(2,start);
		st.setInt(3,end);
		
		//Standard JDK 
		
		//트렌젝션 처리 위해--> EJB 사용 -->SE 까지 쓰다가 스프링으로 넘어감 
		//EJB서버에 내가만든DAO 적재하고..과거에사용했던복잡어려운방법  -->스프링라이브러리사용
		
		
		
		con.setAutoCommit(false);
		
		ResultSet rs = st.executeQuery(); //꺼내오기
		
		con.commit();
		
		
		while (rs.next()) {
			NoticeView notice = new NoticeView(
				rs.getInt("id"),
				rs.getString("title"),
				"",
				rs.getString("writer_id"),
				rs.getDate("regdate"),
				rs.getInt("hit"),
				rs.getInt("comment_Count")		
				);
			list.add(notice);
		}
	
		rs.close();
		st.close();
		con.close();
		
		return list;
		
	}

	@Override
	public Notice get(int id) throws ClassNotFoundException, SQLException {

		Notice notice = null;

		String sql = "select * from notice where id=" + id;

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); //꺼내오기

		if (rs.next()) {
			notice = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("writer_id"),
					rs.getDate("regdate"),
					rs.getInt("hit")
					);
		}

		rs.close();
		st.close();
		con.close();

		return notice;

	}

	  @Override
	   public Notice getPrev(int id) throws ClassNotFoundException, SQLException {

	      Notice notice = null;

	      String sql = " select * from (select * from notice_view order by regdate desc) "
	            + " where regdate < (select regdate from notice where id = " + id + " ) and rownum = 1 ";
	      String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(sql);

	      if (rs.next()) {
	         notice = new Notice(
	               rs.getInt("id"),
	               rs.getString("title"), 
	               "",
	               rs.getString("writer_id"), 
	               rs.getDate("regdate"), 
	               rs.getInt("hit")
	               );
	      }

	      rs.close();
	      st.close();
	      con.close();

	      return notice;

	   }

	   @Override
	   public Notice getNext(int id) throws ClassNotFoundException, SQLException {

	      Notice notice = null;

	      String sql = " select * from (select * from notice_view order by regdate) "
	            + " where regdate > (select regdate from notice where id = " + id + " ) and rownum = 1 ";

	      String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(sql);

	      if (rs.next()) {
	         notice = new Notice(
	               rs.getInt("id"),
	               rs.getString("title"),
	               "",
	               rs.getString("writer_id"),
	               rs.getDate("regdate"), 
	               rs.getInt("hit")
	               );
	      }

	      rs.close();
	      st.close();
	      con.close();

	      return notice;

	   }

	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql = "INSERT INTO NOTICE(id, title, content, writer_id) " 
		+ "values(NOTICE_SEQ.NEXTVAL, ? ,?,'mello')";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());

		result = st.executeUpdate(); //삽입,삭제
		
		st.close();
		con.close();

		return result;
	}

	@Override
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		 int result = 0;

//	      String sql = String.format("update notice set id=%d, title='%s', writer_id = '%s' where id = 12345",
//	            notice.getId(), notice.getTitle(), notice.getWriterId());

		 String sql = "UPDATE NOTICE SET title=?, content=? WHERE ID =?";
					
	      String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
//	      Statement st = con.createStatement();
//	      /*
//	       * ResultSet a = st.executeQuery(sql); //만들어진 테이블 조회해서 가져오기
//	       */
//	       result = st.executeUpdate(sql); 연동된 DB에 입력하기
	      
	    PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setInt(3, notice.getId());

			result = st.executeUpdate(); //삽입,삭제
	      
		    st.close();
		    con.close();
	
		    return result;
	   }

	

	@Override
	public int delete(int id) throws SQLException, ClassNotFoundException {
		 int result = 0;

//	      String sql = String.format("delete from notice where id=%d", id);
	      String sql="delete notice where id=?";

	      String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	     // Statement st = con.createStatement();
	      /*
	       * ResultSet a = st.executeQuery(sql); //만들어진 테이블 조회해서 가져오기
	       */
	      PreparedStatement st = con.prepareStatement(sql);
	      st.setInt(1, id);
	      result = st.executeUpdate();// 연동된 DB에 입력하기
	      
	      st.close();
	      con.close();

	      return result;	//

	}

	@Override
	public int getLastId() throws ClassNotFoundException, SQLException {
		
		int id = -1;
		
		String sql = "SELECT ID FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) WHERE ROWNUM = 1";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); //삽입,삭제
	    
		 if (rs.next()) {
	         id=rs.getInt("id");
	      }
		
		rs.close();
	    st.close();
	    con.close();

	    return id;
	}

	@Override
	public int getCount() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}