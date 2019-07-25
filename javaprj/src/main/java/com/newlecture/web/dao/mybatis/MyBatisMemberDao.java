package com.newlecture.web.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Repository
//@Repository("mybatismemberDao")
public class MyBatisMemberDao implements MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Member get(String id) throws ClassNotFoundException, SQLException {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.get(id);
	}

	@Override
	public int insert(Member member) throws ClassNotFoundException, SQLException {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.insert(member);
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
