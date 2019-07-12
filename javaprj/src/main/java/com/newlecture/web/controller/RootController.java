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

	@RequestMapping("index") //�̰���ȣ�����ִ³༮:����Ʈ��Ʈ�ѷ�
	public String index(Model model) {
		model.addAttribute("x","��������Ͽ����ұ�");
		return "index";
	}

	
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
