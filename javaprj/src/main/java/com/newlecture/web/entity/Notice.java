package com.newlecture.web.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String content;
	private String writerId;
	private Date regDate;
	private int hit;
	
	public Notice(String[] args) {
		this.id = Integer.parseInt(args[0]);
		this.title = args[1];
		this.content = args[2];
		this.writerId = args[3];
		this.regDate = null;
		this.hit = hit;
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = dt.parse(args[3]);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		this.regDate=date;
		this.hit = Integer.parseInt(args[4]);
	}
	
	public Notice(int id, String title, String content, String writerId, Date regDate, int hit) {
		this.id = id;
		this.title = title;
		this.content =content;
		this.writerId = writerId;
		this.regDate = regDate;
		this.hit = hit;

	}

	public Notice(int i) {
		// TODO Auto-generated constructor stub
	}

	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getWriterId() {
		return writerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}

	
	
}

