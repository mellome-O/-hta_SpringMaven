package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.dao.oracle.NoticeView;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.Notice;

public interface MemberDao {

	Member get(String id) throws ClassNotFoundException, SQLException;
	
	int insert(Member member) throws ClassNotFoundException, SQLException;
	int update(Member member) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	

	
} 
