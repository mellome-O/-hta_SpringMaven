package com.newlecture.web.dao.java;

import com.newlecture.web.entity.File;

//import java.io.File; 두 개의 클래스 파일명 구별하기 위해 하나의 파일에 풀네임 붙여주기

public class Program {

	public static void main(String[] args) {
		//경로 정하기 C:\tools
		java.io.File directory = new java.io.File("C:\\tools");
		
		//디렉토리에 있는 파일 목록들
		java.io.File[] files = directory.listFiles();
		
		File f1 = new File(files[0]);
		System.out.println(f1.toString());
		System.out.println(files.length);
		
		for(int i=0; i<files.length; i++) {
			File fs = new File(files[i]);
			System.out.println(fs.toString());
		}
	}

}
