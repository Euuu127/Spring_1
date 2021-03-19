package com.DKMK.s1.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView memberLogin(MemberDTO memberDTO, ModelAndView modelAndView) throws Exception {
		memberDTO=memberservice.memberLogin(memberDTO);

		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("member/memberPage");
		
		return modelAndView;
		
	}
	
	//, method = RequestMethod.GET
	@RequestMapping(value = "/member/memberJoin")
	public void memberJoin() {

	}

	@RequestMapping(value = "/member/memberJoin", method = RequestMethod.POST)
	public void memberJoin2(MemberDTO memberDTO)throws Exception {
		
		int result  = memberservice.memberJoin(memberDTO);
		
		System.out.println(result);


	}

}
