//콘솔 뷰 확인용
package com.test.app.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService bs = (MemberService)factory.getBean("memberService");
		//게시글 작성하기 버튼을 누름 -> 게시글 작성 페이지 -> 게시글을 작성함 -> 글 등록버튼을 누름
		MemberVO vo = new MemberVO();
		vo.setMid("adi");
		vo.setMpw("1234");
		vo.setMname("이름");
		vo.setMgender("여자");
		vo.setMbirth("210215");
		vo.setMaddr_zipcode("12345");
		vo.setMaddr_street("잠실대로");
		
		vo.setMaddr_detail("101동");
		vo.setMaddr_etc("잠실동");
		vo.setMtel("01098765432");
		vo.setMemail("abc@gmail.com");

		MemberVO data = bs.selectMember(vo);
		System.out.println(data);
		
		factory.close();
	}
}
