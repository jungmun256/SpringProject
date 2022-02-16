package com.test.app.member;

public interface MemberService {

	public boolean insertMember(MemberVO member);
	
	public MemberVO loginMember(MemberVO member);
	
	public MemberVO selectMember(MemberVO memberVO);
	
	public boolean updateMember(MemberVO vo);
	
	public boolean deleteMember(MemberVO vo);
	
}
