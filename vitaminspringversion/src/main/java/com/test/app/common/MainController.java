package com.test.app.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.product.CrawlService;
import com.test.app.product.ProductService;


@Controller
public class MainController {

	@Autowired
	ProductService ps;
	
	@Autowired
	CrawlService cs;
	
	//크롤링 상태 판단하기 위한 flag
	public static boolean flag= false; 
	
	@RequestMapping("/main.do")
	public String main(Model model){
		
		//System.out.println("main @Controller수행중");
		if(flag != true) {
			cs.insertCrawlDB();
			flag = true;
		}
		//System.out.println("크롤링완료");
		
		//메인페이지에 보여주는 각 필터별 top6
		model.addAttribute("pdatas", ps.selectAllTOP6());
		model.addAttribute("pdatas_high", ps.selectAllHigh6());
		model.addAttribute("pdatas_low", ps.selectAllLow6());
		model.addAttribute("pdatas_soldout", ps.selectAlmostSoldOut6());

		return "main.jsp";
	}

	

}