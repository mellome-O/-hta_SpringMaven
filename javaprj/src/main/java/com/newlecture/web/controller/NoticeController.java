package com.newlecture.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.NoticeView;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	//1.HttpServletRequest을 이용한 고전적인 방법(매개변수에다가 써서 프론트컨트롤러에게 달라고 하자)
	//2.스프링이 제공하는 기능을 이용하는 방법
	
	@RequestMapping("list")
	public String 리스트(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		int page = 1;
		String p = request.getParameter("p");
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);
		
		//선생님 임시변수 
		List<NoticeView> list = noticeDao.getList(page);
		System.out.println(list.size());
		model.addAttribute("noticelist", list);
		
		//웅
		//model.addAttribute("noticelist",noticeDao.getList());
		System.out.println("list 요청이 있었습니다.");	
		return "/notice/list";
	}
	
}
