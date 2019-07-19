package com.newlecture.web.entity;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class File {
	
	private boolean isFile;
	private String name;
	private String type;
	private long size;
	private Date createdDate;
	

	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	
	public boolean getIsFile() {
		return isFile;
	}
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	
	public File(java.io.File file) {
		name = file.getName();
		size= file.length();
		
		
		if(file.isDirectory()) //지정 디렉토리 일 때
			type="dir";
		else if(name.lastIndexOf(".") == -1) //확장자가 없을 때
			type="noext";
		else
			type = name.substring(name.lastIndexOf(".")+1);
	
		
		try {
			BasicFileAttributes fatter 
			= Files.readAttributes(file.toPath(),BasicFileAttributes.class);
		
			createdDate = new Date(fatter.creationTime().toMillis());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void fromFile(java.io.File file) {
		name = file.getName();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "File [name=" + name + ", type=" + type + ", size=" + size + ", createdDate=" + createdDate + "]";
	}

	public String toJSON() throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		return JSONParser.toJSON(this);
	}

}
