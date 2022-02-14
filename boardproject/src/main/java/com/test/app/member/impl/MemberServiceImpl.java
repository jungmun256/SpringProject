package com.test.app.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService	{
	@Autowired
	private MemberDAO3 memberDAO;

	/*
	 * public MemberDAO getMemberDAO() { return memberDAO; } public void
	 * setMemberDAO(MemberDAO memberDAO) { this.memberDAO = memberDAO; }
	 */

	@Override
	public MemberVO selectOne(MemberVO vo) {
		try {
			return memberDAO.selectOne(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertMember(MemberVO vo){
		memberDAO.insertMember(vo);

	}
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}
	
	
}