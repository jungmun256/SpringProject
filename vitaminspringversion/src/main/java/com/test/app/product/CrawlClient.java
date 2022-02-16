//콘솔 뷰 확인용
package com.test.app.product;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CrawlClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CrawlService bs = (CrawlService)factory.getBean("crawlService");
		//게시글 작성하기 버튼을 누름 -> 게시글 작성 페이지 -> 게시글을 작성함 -> 글 등록버튼을 누름
		bs.insertCrawlDB();
		factory.close();
	}
}
