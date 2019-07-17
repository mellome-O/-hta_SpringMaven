package com.newlecture.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.NoticeView;

@Controller("NoticeController")
@RequestMapping("/notice/")
public class NoticeController {
	@Autowired
	private NoticeDao noticeDao;
	//page �� ������� ���� �ְ� ���� ���� ���� �ִ�.
	//c# int? -->null�� ������ Ÿ�� �� �߰���
	//�ڹٴ� null�� �����ϰ� �Ϸ��� wrapper class ���
	
	@RequestMapping("list")
	public String list(Model model
			, @RequestParam(name="p", defaultValue="1") Integer page
			) throws ClassNotFoundException, SQLException {
		
		List<NoticeView> list = noticeDao.getList(page);
		model.addAttribute("noticelist", list);
		
		return "/notice/list";
	
	
	
	
	
//	
//	//1.HttpServletRequest�� �̿��� �������� ���(�Ű��������ٰ� �Ἥ ����Ʈ��Ʈ�ѷ����� �޶�� ����)
//	//2.�������� �����ϴ� ����� �̿��ϴ� ���
//	
//	@RequestMapping("list")
//	public String ����Ʈ(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
//		
//		int page = 1;
//		String p = request.getParameter("p");
//		if(p != null && !p.equals(""))
//			page = Integer.parseInt(p);
//		
//		//������ �ӽú��� 
//		List<NoticeView> list = noticeDao.getList(page);
//		System.out.println(list.size());
//		model.addAttribute("noticelist", list);
//		
//		//��
//		//model.addAttribute("noticelist",noticeDao.getList());
//		System.out.println("list ��û�� �־����ϴ�.");	
//		return "/notice/list";
	}
	
}
