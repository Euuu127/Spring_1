package com.DKMK.s1.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberservice;

	@RequestMapping(value = "/member/memberLogin")
	public String memberLogin() {
		//String name = request.getParameter("name");
		//int age = Integer.parseInt(request.getParameter("age"));
		//System.out.println(name);
		//System.out.println(age);
		System.out.println("LOGIN~~~~~~~~~~~~~~");

		return "member/memberLogin";
	}

	@RequestMapping(value = "/member/memberLogin", method = RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, Model model) throws Exception {
		memberDTO=memberservice.memberLogin(memberDTO);

		model.addAttribute("dto", memberDTO);
		return "member/memberPage";
		
	}

	@RequestMapping(value = "/member/memberJoin", method = RequestMethod.GET)
	public String memberJoin(String id, String pw, String name, String phone, String email) {
		return "member/memberJoin";



	}

	@RequestMapping(value = "/member/memberJoin", method = RequestMethod.POST)
	public void memberJoin2(MemberDTO memberDTO)throws Exception {
		
		int result  = memberservice.memberJoin(memberDTO);
		
		System.out.println(result);


	}

}
