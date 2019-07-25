package com.newlecture.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.NoticeView;

@Controller("ErrorController")
@RequestMapping("/error/")
public class ErrorController {
	
	
	//특정번호 따로 하고 싶을때
	@GetMapping("403")
	public String error403() {
		return "error/403";	
	}
	
	//한 곳에 몰아서 관리할 때
//	@GetMapping("{num}")	//defaulthandler 만들어 둔 것
//	public String error() {
//		return "error/default";
//	}	
		
}
