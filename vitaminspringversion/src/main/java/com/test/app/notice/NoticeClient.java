//콘솔 뷰 확인용
package com.test.app.notice;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NoticeClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		NoticeService bs = (NoticeService)factory.getBean("noticeService");
		//게시글 작성하기 버튼을 누름 -> 게시글 작성 페이지 -> 게시글을 작성함 -> 글 등록버튼을 누름
		NoticeVO vo = new NoticeVO();
		vo.setNtitle("abc@gmail.com");
		vo.setNcont("hi");
		vo.setWriter("고객1");
		bs.insertNotice(vo);
		
		ArrayList<NoticeVO> datas = bs.selectAll(vo);
		for(NoticeVO v:datas) {
			System.out.println(v.getNcont());
		}
		factory.close();
	}
}
