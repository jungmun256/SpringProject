//콘솔 뷰 확인용
package com.test.app.contact;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ContactClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		ContactService bs = (ContactService)factory.getBean("contactService");
		//게시글 작성하기 버튼을 누름 -> 게시글 작성 페이지 -> 게시글을 작성함 -> 글 등록버튼을 누름
		ContactVO vo = new ContactVO();
		vo.setMsgemail("abc@gmail.com");
		vo.setMsgname("고객1");
		vo.setMsgtext("hi");
		bs.insertContact(vo); // c가 insert 비즈니스 메서드를 수행
		// -> 실질적으로 dao가 해당 로직을 수행함
		
		ArrayList<ContactVO> datas = bs.selectAll(vo);
		for(ContactVO v:datas) {
			System.out.println(v);
		}
		
		factory.close();
	}
}
