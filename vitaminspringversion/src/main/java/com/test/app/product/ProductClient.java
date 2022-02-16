//콘솔 뷰 확인용
package com.test.app.product;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProductClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		ProductService bs = (ProductService)factory.getBean("productService");
		//게시글 작성하기 버튼을 누름 -> 게시글 작성 페이지 -> 게시글을 작성함 -> 글 등록버튼을 누름
		
		List<ProductVO> datas = bs.selectAll();
		for(ProductVO v:datas) {
			System.out.println(v.getPname());
		}
		
		factory.close();
	}
}
