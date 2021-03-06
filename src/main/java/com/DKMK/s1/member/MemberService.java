package com.DKMK.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		
		memberDTO = memberDAO.login(memberDTO);
		
		return memberDTO; 
	}
		
	
	public int memberJoin(MemberDTO memberDTO)throws Exception {
		return memberDAO.memberJoin(memberDTO);
		
		
	}
}
