package com.test.app.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("ndata")
public class NoticeController {

	@Autowired
	NoticeService ns;
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("제목", "ntitle");
		conditionMap.put("내용", "ncont");
		return conditionMap;
	}
	
	@RequestMapping("/notice.not")
	public String notice(NoticeVO vo, Model model) {
		//System.out.println("notice @Controller 실행");
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("ntitle");
		}
		if(vo.getSearchword() == null) {
			vo.setSearchword("");
		}
		model.addAttribute("ndatas", ns.selectAll(vo));
		return "notice.jsp";
	}

	@RequestMapping("/notice_detail.not")
	public String selectNotice(NoticeVO vo, Model model) {
		//System.out.println("selectone notice @Controller 실행");
		model.addAttribute("ndata", ns.selectOne(vo));
		return "notice_detail.jsp";
	}

	@RequestMapping("/notice_insert.not")
	public String insertNotice(NoticeVO vo) {
		//System.out.println("insertNotice @Controller 실행");
		ns.insertNotice(vo);
		return "notice.not";
	}

	@RequestMapping("/notice_update.not")
	public String updateNotice(@ModelAttribute("ndata")NoticeVO vo) {
		//System.out.println("updateNotice @Controller 실행");
		ns.updateNotice(vo);
		return "notice.not";
	}

	@RequestMapping("/notice_delete.not")
	public String deleteNotice(NoticeVO vo) {
		ns.deleteNotice(vo);
		return "notice.not";
	}


}
