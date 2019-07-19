package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice/")
public class NoticeController{

	@Autowired
	//@Qualifier("mybatisNoticeDao")
	private NoticeDao noticeDao;
	
	@GetMapping("detail")
	public String detail(Integer id, Model model) throws ClassNotFoundException, SQLException {
		
		Notice notice = noticeDao.get(id);
		model.addAttribute("notice", notice);
		return "admin/notice/detail";
	}
	
	
	@RequestMapping("list1")
	public String list(Model model) throws ClassNotFoundException, SQLException {
		
		//1.���� ������ �����ؼ�
		//SqlSession sqlSession = ?;
		//���� ��ü�� ���ؼ� ���۸� ��
		//���ϴ� �޼ҵ带 ȣ���Ѵ�.
		
		//2.���ǵ����� ��� �۾��� �������� ���ø����� �����ϰ�
		//���⼭�� �׳� �� ���� ������ �� ȣ���ϴ� ���
		
		//1�� ���ǰ�ü �� ȣ���ϴ� ��� �� �� �ϳ�
		//List<NoticeView> list = sqlSession.getMapper(NoticeDao.class).getList();		
		//2�� 
		//NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		List<NoticeView> list = noticeDao.getList();
		model.addAttribute("list", list);

		return "admin/notice/list1";
	}
	
//	@RequestMapping("list")
//	public String list(Model model
//			, @RequestParam(name="p", defaultValue="1") Integer page
//			) throws ClassNotFoundException, SQLException{
//		List<NoticeView> list = noticeDao.getList(page);
//		model.addAttribute("noticelist", list);
//		
//		System.out.println("list ��Ʈ�ѷ��Դϴ�.");
//		return "admin/notice/list";
//	}
	
	//4.0�� ���� ���� ��� - ������̼����� ����
	//GET��û
	@GetMapping("reg")
	//@RequestMapping("reg")
	public String reg() {
		return "admin/notice/reg";
	}
	
	//setter�ִ� �ֵ鸸, ��ġ�ϴ� �ֵ鸸 ������ �� ����
	//POST��û
	@PostMapping("reg")
	//@RequestMapping("reg")
	public String reg(Notice notice
			, String category
			, MultipartFile file
			, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		System.out.println("category:" + category);
		System.out.println("file:" + file);
		System.out.println(notice.getTitle());
		System.out.println(notice.getContent());
		
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
	           
	           int n = fileName.lastIndexOf(".");  // fileName=hello.jpg      n =?,    name=    , suffix,    
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
		
		noticeDao.insert(notice); //�̷����ϸ� �츮�� ���ߴ� title�� content�� ����������
		notice.setWriterId("newlec");
		
		
		

		
//		public String reg(Notice notice, String category, String file
//				,@RequestParam("content-type") String contentType) {
//			notice.setContentType(contentType)
		//���Ͼ��ε�
		//1.���Ͼ��ε� ���� ����
		
		//���𷺼�:list��������
		return "redirect:list1";
		//����ν� ������:
		//return "admin/notice/reg";
		
	}
	

	
	//���� ��������
	//POST��û
	//@PostMapping("reg")
	//@RequestMapping("reg")
//	public String reg(String category, String title, String file, String content) {
//		System.out.println(category);
//		System.out.println(title);
//		System.out.println(file);
//		System.out.println(content);
//		//���𷺼�:list��������
//		return "redirect:list";
//		//����ν� ������:
//		//return "admin/notice/reg";
//		
//	}


	
	
	
	
	/* 3.0��
	//GET��û
	@RequestMapping(value="reg", method=RequestMethod.GET)
	public String reg() {
		System.out.println("reg ��Ʈ�ѷ��Դϴ�.");
		return "admin/notice/reg";
	}
	//POST��û
	@RequestMapping(value="reg", method=RequestMethod.POST)
	public String reg(String title) {
		System.out.println("reg ��Ʈ�ѷ��Դϴ�.");
		//���𷺼�:list��������
		return "redirect:list";
		//����ν� ������:
		//return "admin/notice/reg";
	}
	*/
}

