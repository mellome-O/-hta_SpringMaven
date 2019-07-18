package com.newlecture.web.dao;

import java.io.File;
import java.util.List;

//快府啊 父电 颇老
//import com.newlecture.web.entity.File;

public interface FileDao {
	List<File> getList(String path);
	//List<File> getList(String Filename);
	
}
