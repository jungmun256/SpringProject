package com.test.app.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	public MemberDAO2 memberDao;
	
	@Override
	public boolean insertMember(MemberVO member) {
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO loginMember(MemberVO member) {
		return memberDao.loginMember(member);
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		return memberDao.selectMember(memberVO);
	}

	@Override
	public boolean updateMember(MemberVO vo) {
		return memberDao.updateMember(vo);
	}

	@Override
	public boolean deleteMember(MemberVO vo) {
		return memberDao.deleteMember(vo);
	}

}


