package com.newlecture.web.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.FileDao;

@Controller
@RequestMapping("/")
public class RootController {
	
	@Autowired
	private FileDao fileDao;
	
	@GetMapping("file-list")
	@ResponseBody
	public String fileList() {
		String urlPath = "/upload";
		String realPath = "";
		
		
		
		
		List<File> list = fileDao.getList(realPath);
		
		return "";
	}
	
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
		// 1. ���ε� ��θ� ���
	      String urlPath = "/upload";
	      String path = request
	                     .getServletContext()
	                     .getRealPath(urlPath);
	      
	      System.out.println(path);
	      
	      // 2. ���ε�� ���ϸ� ���
	      String fileName = file.getOriginalFilename();//filePart.getSubmittedFileName();
	            
	      // 3. ��� ������ �ֱ� 
	      String filePath = path + File.separator + fileName; // d:\aa + "bb.jpg" -> d:\aabb.jpg
	      
	      System.out.println(filePath);
	      
	      // 4. ��ΰ� ���ٴ� ���� ����
	      File pathFile = new File(path);
	      if(!pathFile.exists()) // �������� ������
	         pathFile.mkdirs();// �������ּ���.  
	      
	      // 5. ������ ���ϸ� ��ο� �̹� �����ϴ� ���� : �̸� ��å
	      //aa.jpg -> aa.jpg1 ==> aa1.jpg
	      //aa1.jpg -> aa(1).jpg
	      /*
	       * File ? = new File(?);
	       * 
	       * if(? �����Ѵٸ�) { ����(Ȯ����)�� �߶� �̸��� ��� �� �������� �Ұ�ȣ()�� �ִ��� Ȯ���ϰ� ������ ��ȣ�� �˾Ƴ��� 1������ ����
	       * ��.. fileName = ?; }
	       */
	       
	       File sameFile = new File(filePath);
	        System.out.println(sameFile);
	        if(sameFile.exists()) {
	           
	           int n = fileName.lastIndexOf(".");           // fileName=hello.jpg      n =?,    name=    , suffix,    
	           String name = fileName.substring(0, n);  // 
	           String suffix = fileName.substring(n);         
	           
	           //name.endsWith(")");  
	           //int parenS = name.lastIndexOf("(");
	           //int parenE = name.lastIndexOf(")");
	            
	           //String indexC = name.substring(parenS+1, parenE);
	           
	           //int indexN = Integer.parseInt(indexC);
	            
	           //if (parenS == -1)
	               fileName = name +"("+ 1 +")"+ suffix;
	           //else {
	           //   indexN++;
	           //    fileName = fileName.substring(0, parenS+1)+ indexN +")"+ suffix;
	           //}           
	       }
	      
	      InputStream fis = file.getInputStream();
	      OutputStream fos = new FileOutputStream(filePath);
	      
	      byte[] buf = new byte[1024];
	      int size = 0;
	      while((size = fis.read(buf)) != -1)
	         fos.write(buf, 0, size);
	      
	      fis.close();
	      fos.close();	
		
	      return "ok";
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("���Ͼ��ε� �Ϸ�ƴ�!");	
//		return "���Ͼ��ε� �Ϸ�ƴ�!";
	}
	
//	@RequestMapping("index") //�̰���ȣ�����ִ³༮:����Ʈ��Ʈ�ѷ�
//	public String index(Model model) {
//		model.addAttribute("x","��������Ͽ����ұ�");
//		return "index";
//	}

//	@RequestMapping("index")
//	@ResponseBody
//	public String index() {
//		return "ȯ���մϴ�.";
//	}
	
//2�����	
	//@RequestMapping("index")
	//@ResponseBody //��ȯ�Ǵ� ���� ����ض� �̰������ view��� �ν�?
//	public void index(HttpServletResponse response) throws IOException	{
//		System.out.println("index ��û�� �־����ϴ�.");
//		PrintWriter out = response.getWriter();
//		out.println("Welcome Home!!!");		
//	}

//1�����
//@ResponseBody //��ȯ�Ǵ� ���� ����ض�
//public String �����������() {
//	System.out.println("index ��û�� �־����ϴ�.");
//	return "Welcome Home!!!";
//	}


	@RequestMapping("hello")
	public void ����() {
	System.out.println("hello ��û�� �־����ϴ�.");	
	}

}
