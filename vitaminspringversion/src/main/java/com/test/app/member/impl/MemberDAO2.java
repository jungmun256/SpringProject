//mybatis를 이용한 DAO
package com.test.app.member.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO2 {

	@Autowired
	private SqlSessionTemplate mybatis;
		
	//회원가입
	public boolean insertMember(MemberVO vo) { 
		//System.out.println("insert수행중");
		int cnt = mybatis.insert("MemberDAO.insertMember",vo);
		if(cnt == 1) {
			return true;
		}
		return false;
	}

	//회원조회
	public MemberVO selectMember(MemberVO vo) {
		//System.out.println("member selectOne수행중");
		return mybatis.selectOne("MemberDAO.selectOne",vo);
	}
	
	//로그인
	public MemberVO loginMember(MemberVO vo) {
		//System.out.println("member login수행중");
		return mybatis.selectOne("MemberDAO.loginMember",vo);
	}
	
	
	//회원정보수정
	public boolean updateMember(MemberVO vo) {
		//System.out.println("updateMember수행중");
		int cnt = mybatis.update("MemberDAO.updateMember",vo);
		if(cnt == 1) {
			return true;
		}
		return false;
    }
	
	
	//회원삭제(회원탈퇴)
	public boolean deleteMember(MemberVO vo) {
		//System.out.println("deleteMember수행중");
		int cnt = mybatis.delete("MemberDAO.deleteMember", vo);
		if(cnt == 1) {
			return true;
		}
		return false;
	}


}
