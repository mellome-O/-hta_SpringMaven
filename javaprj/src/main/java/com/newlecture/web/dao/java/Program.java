package com.newlecture.web.dao.java;

import com.newlecture.web.entity.File;

//import java.io.File; �� ���� Ŭ���� ���ϸ� �����ϱ� ���� �ϳ��� ���Ͽ� Ǯ���� �ٿ��ֱ�

public class Program {

	public static void main(String[] args) {
		//��� ���ϱ� C:\tools
		java.io.File directory = new java.io.File("C:\\tools");
		
		//���丮�� �ִ� ���� ��ϵ�
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
