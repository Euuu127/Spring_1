package com.DKMK.s1.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
	
@Controller
public class MemberController {
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping(value = "/member/memberLogin")
	public String memberJoin() {
		System.out.println("LOGIN~~~~~~~~~~~~~~");
		
		return "member/memberLogin";
	}
	
	@RequestMapping(value = "/member/memberLogin", method = RequestMethod.POST)
	public void memberLogin2(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		
		memberDTO=memberservice.memberLogin(memberDTO);
		
		System.out.println(memberDTO);
	}

}
