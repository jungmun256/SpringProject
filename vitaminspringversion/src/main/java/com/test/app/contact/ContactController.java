package com.test.app.contact;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

	@Autowired
	ContactService cs;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("이름", "msgname");
		conditionMap.put("내용", "msgtext");
		return conditionMap;
	}

	@RequestMapping("/contact.con")
	public String contact(ContactVO vo, Model model) {
		//System.out.println("contact @Controller 수행");
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("msgname");
		}
		if(vo.getSearchword() == null) {
			vo.setSearchword("");
		}
		model.addAttribute("cdatas", cs.selectAll(vo));
		return "contact.jsp";
	}

	//고객문의 글 추가
	@RequestMapping("/contact_insert.con")
	public String contactinsert(ContactVO vo) {
		//System.out.println("contactinsert @Controller 수행");
		cs.insertContact(vo);
		return "contact.con";
	}

	//고객문의 글 상세 페이지
	@RequestMapping("/contact_detail.con")
	public String contactDetail(ContactVO vo, Model model) {
		//System.out.println("@controller contactDetail()수행중");
		model.addAttribute("cdata", cs.selectOne(vo));
		return "contact_detail.jsp";
	}

	//고객문의 글 삭제
	@RequestMapping("/contact_delete.con")
	public String contactDelete(ContactVO vo) {

		//System.out.println("@controller contactDelete()수행중");
		if (cs.deleteContact(vo)) {
			return "contact.con";
		} else {
			//System.out.println("고객문의 삭제 실패");
			return "contact_detail.con";
		}
	}
}