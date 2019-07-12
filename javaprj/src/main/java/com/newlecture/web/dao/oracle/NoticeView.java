package com.newlecture.web.dao.oracle;

import java.util.Date;

import com.newlecture.web.entity.Notice;

public class NoticeView extends Notice{
	private int commentCount;


	public NoticeView(int id, String title, String content, String writerId, Date regDate, int hit,int commentCount) {
		super(id, title, content, writerId, regDate, hit);
		this.commentCount = commentCount;
	}





	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
	

}
