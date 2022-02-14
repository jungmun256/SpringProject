package com.test.app.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms = (MemberService)factory.getBean("memberService");
		
		//로그인화면에서 ID, PW 를 입력하고 로그인 버튼을 누름.
		MemberVO vo = new MemberVO();
		vo.setMid("kim");
		vo.setPassword("1234");
	
		
		MemberVO data = ms.selectOne(vo);
		if(data == null) {
			System.out.println("로그인 실패");
		}
		else {
			System.out.println("["+data.getRole()+"]"+data.getName()+"님,반갑습니다.");
		}
		

		vo.setMid("k2");
		vo.setPassword("142");
		vo.setName("j2");
		vo.setRole("admin");
		try {
			ms.insertMember(vo);
		} catch (Exception e) {
			System.out.println("에러페이지");
		}
		
		
		factory.close();
	}
}
