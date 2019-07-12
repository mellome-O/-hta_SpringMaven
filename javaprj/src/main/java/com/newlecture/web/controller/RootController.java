package com.newlecture.web.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RootController {

	@RequestMapping("index") //이것을호출해주는녀석:프론트컨트롤러
	public String index(Model model) {
		model.addAttribute("x","웅아토요일에모할까");
		return "index";
	}

	
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
