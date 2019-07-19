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
		// 1. 업로드 경로를 얻기
	      String urlPath = "/upload";
	      String path = request
	                     .getServletContext()
	                     .getRealPath(urlPath);
	      
	      System.out.println(path);
	      
	      // 2. 업로드된 파일명 얻기
	      String fileName = file.getOriginalFilename();//filePart.getSubmittedFileName();
	            
	      // 3. 경로 구분자 넣기 
	      String filePath = path + File.separator + fileName; // d:\aa + "bb.jpg" -> d:\aabb.jpg
	      
	      System.out.println(filePath);
	      
	      // 4. 경로가 없다는 오류 문제
	      File pathFile = new File(path);
	      if(!pathFile.exists()) // 존재하지 않으면
	         pathFile.mkdirs();// 생성해주세요.  
	      
	      // 5. 동일한 파일명에 경로에 이미 존재하는 문제 : 이름 정책
	      //aa.jpg -> aa.jpg1 ==> aa1.jpg
	      //aa1.jpg -> aa(1).jpg
	      /*
	       * File ? = new File(?);
	       * 
	       * if(? 존재한다면) { 꼬리(확장자)를 잘라낸 이름을 얻고 그 마지막에 소괄호()가 있는지 확인하고 있으면 번호를 알아내고 1증가된 값을
	       * 얻어서.. fileName = ?; }
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
//		System.out.println("파일업로드 완료됐다!");	
//		return "파일업로드 완료됐다!";
	}
	
//	@RequestMapping("index") //이것을호출해주는녀석:프론트컨트롤러
//	public String index(Model model) {
//		model.addAttribute("x","웅아토요일에모할까");
//		return "index";
//	}

//	@RequestMapping("index")
//	@ResponseBody
//	public String index() {
//		return "환영합니다.";
//	}
	
//2번방법	
	//@RequestMapping("index")
	//@ResponseBody //반환되는 것을 출력해라 이거지우면 view라고 인식?
//	public void index(HttpServletResponse response) throws IOException	{
//		System.out.println("index 요청이 있었습니다.");
//		PrintWriter out = response.getWriter();
//		out.println("Welcome Home!!!");		
//	}

//1번방법
//@ResponseBody //반환되는 것을 출력해라
//public String 장웅희이지연() {
//	System.out.println("index 요청이 있었습니다.");
//	return "Welcome Home!!!";
//	}


	@RequestMapping("hello")
	public void 웅쏭() {
	System.out.println("hello 요청이 있었습니다.");	
	}

}
