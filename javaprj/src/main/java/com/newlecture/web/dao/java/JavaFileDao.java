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
		//경로 정하기 C:\tools
		java.io.File directory = new java.io.File(path);
	
		if(!directory.exists())
			directory.mkdir(); 
		//파일이 없을 경우 or 서버가 다시 시작되었을 경우 null이 뜨니깐
		//경로를 만들어주는데 mkdir은 upload까지만 만들어주는 것
		//mkdirs는 하위 경로까지 전부 만들어주는 것
		//디렉토리에 있는 파일 목록들
		java.io.File[] files = directory.listFiles();
		
		//각각의 jason들을 담을 큰 그릇 
		
		
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

