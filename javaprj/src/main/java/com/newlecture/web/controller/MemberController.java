package com.newlecture.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.NoticeView;

@Controller("MemberController")
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("login") //
	public String login() {
		return "member.login";	
	}
	@GetMapping("join")
	public String join() {
		return "member.join";
	}
	@PostMapping("join")
	public String join(Member member) throws ClassNotFoundException, SQLException {
		String pwd = member.getPwd();
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		pwd = pwdEncoder.encode(pwd);
		
		member.setPwd(pwd);
		
		memberDao.insert(member);
		//memberRoleDao.insert(memberRole); 
		//ROLE_MEMBER ±ÇÇÑ 
		
		
		
		return "redirect:../index";
	}
}
