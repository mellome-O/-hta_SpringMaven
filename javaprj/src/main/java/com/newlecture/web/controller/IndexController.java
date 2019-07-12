package com.newlecture.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/index"); //���� ������� ������
		mv.addObject("x",30);//��뵥���ʹ� x
		mv.addObject("y",40);
		mv.addObject("name","��°�� ����� ���̻�� ������");
				
		return mv;
	}

}

