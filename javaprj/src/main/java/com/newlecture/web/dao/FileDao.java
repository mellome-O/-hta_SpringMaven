package com.newlecture.web.dao;

import java.io.File;
import java.util.List;

//�츮�� ���� ����
//import com.newlecture.web.entity.File;

public interface FileDao {
	List<File> getList(String path);
	//List<File> getList(String Filename);
	
}
