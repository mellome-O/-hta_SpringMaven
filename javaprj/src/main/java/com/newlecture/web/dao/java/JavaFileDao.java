package com.newlecture.web.dao.java;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlecture.web.dao.FileDao;
import com.newlecture.web.entity.File;

@Repository
public class JavaFileDao implements FileDao{

	@Override
	public String getJSONList(String path) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		//��� ���ϱ� C:\tools
		java.io.File directory = new java.io.File(path);
	
		if(!directory.exists())
			directory.mkdir(); 
		//������ ���� ��� or ������ �ٽ� ���۵Ǿ��� ��� null�� �ߴϱ�
		//��θ� ������ִµ� mkdir�� upload������ ������ִ� ��
		//mkdirs�� ���� ��α��� ���� ������ִ� ��
		//���丮�� �ִ� ���� ��ϵ�
		java.io.File[] files = directory.listFiles();
		
		//������ jason���� ���� ū �׸� 
		
		
		StringBuilder json = new StringBuilder();
		json.append("{");
		//File f1 = new File(files[0]);
		for(int i=0; i<files.length; i++) {
			File fs = new File(files[i]);
			json.append(fs.toJSON());
			if(i!=(files.length-1))
			json.append(",");
		}
		json.append("}");	
		
		return json.toString();
	}

	@Override
	public List<File> getList(String path) {
		java.io.File directory = new java.io.File(path);
		
		if(!directory.exists())
			directory.mkdir(); 
		java.io.File[] files = directory.listFiles();
		
		List<File> list = new ArrayList<>();
		
		for(int i=0; i<files.length; i++) {
			list.add(new File(files[i]));
		}
		
		return list;
	}
}

