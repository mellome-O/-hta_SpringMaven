package com.newlecture.web.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Repository
//@Repository("mybatisNoticeDao")
public class MyBatisNoticeDao implements NoticeDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
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

	@Override
	public List<NoticeView> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1,"title","");
		//return null;
	}

	@Override
	public List<NoticeView> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(page,"title","");
		//return null;
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		//1번방법-Dao를 직접 가져다 쓰기
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getList();
		//진보된 방식
		//sql문을 매퍼에 구현해서 
		//인터페이스로 다오에서 가져다쓰기
		
		//sqlsession.select("SELECT*","")
		//이런식으로 라이브러리처럼 직접 SQL문 쓸 수 있다
		//우리는 DAO만들었으니까 1번방법으로! 
		
	}

	@Override
	public Notice get(int id) throws ClassNotFoundException, SQLException {
		
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.get(id);
	}

	@Override
	public Notice getPrev(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getNext(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		
		//1번방법
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.insert(notice);
		//2번방법
		//return sqlSession.getMapper(NoticeDao.class).insert(notice);
	}

	@Override
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLastId() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
