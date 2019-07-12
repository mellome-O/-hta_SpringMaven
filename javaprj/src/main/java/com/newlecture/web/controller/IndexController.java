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
		ModelAndView mv = new ModelAndView("/index"); //내가 가고싶은 페이지
		mv.addObject("x",30);//사용데이터는 x
		mv.addObject("y",40);
		mv.addObject("name","두째형 사랑꾼 성미사랑 만만세");
				
		return mv;
	}

}

