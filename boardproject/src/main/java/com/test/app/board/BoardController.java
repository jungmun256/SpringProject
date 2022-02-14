package com.test.app.board;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;


@Controller
@SessionAttributes("data")
public class BoardController{

	@Autowired
	BoardService bs;
	
	//파일 경로 저장
	final String path = "/Users/jm/Web_3/springworkspace/day45/src/main/webapp/image/";
	
	//@RequestMapping 보다 먼저 호출되는 @ModelAttribute
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("제목", "title");
		conditionMap.put("작성자", "writer");
		return conditionMap;
	}
	
	
	@RequestMapping("/board.do")
	public String board(BoardVO vo, Model model) {
		model.addAttribute("data", bs.selectOne(vo));
		System.out.println(bs.selectOne(vo));
		System.out.println("로그 : board() @컨트롤러"+bs.selectOne(vo).getFilepath());
		return "board.jsp";
	}
	
	@RequestMapping("/main.do")
	public String main(BoardVO vo, Model model) {
		//@을 활용하여 인자로 검색을 다뤘었
		//@RequestParam(value="searchCondition",defaultValue="title",required=false)String searchCondition, @RequestParam(value="searchContent",defaultValue="",required=false)String searchContent,
		System.out.println("조건:"+vo.getSearchCondition());
		System.out.println("내용:"+vo.getSearchContent());
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("title");
		}
		//@MA 설정이 추가되면서, model객체에 Map, AL 두개의 컬렉션이 저장되어있음
		if(vo.getSearchContent() == null) {
			vo.setSearchContent("");
		}
		model.addAttribute("datas",bs.selectAll(vo));
		return "main.jsp";
		
	}
	
	//Servlet에 대한 강제가 들어가게 되어, POJO라고 생각하지 않음 -> 경량이 아님. 무거운 파일
	//핸들러 매핑, 요청하나당 메서드 매핑    , command객체 : BoardVO vo, BoardDAO dao
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println("로그 : insertBoard() @컨트롤러");
		MultipartFile file = vo.getFile();
		if(!file.isEmpty()) {
			//업로드를 했다면,
			String fileName = file.getOriginalFilename();
			System.out.println("업로드 파일 이름 : "+fileName);
			
			file.transferTo(new File(path+fileName));
			vo.setFilepath("image/"+fileName);
		}
		else {
			vo.setFilepath("image/d.jpg"); //디폴트로 출력할 이미지
		}
		bs.insertBoard(vo);
		return "main.do";
	}

	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO vo) {
		System.out.println("로그 : updateBoards() @컨트롤러"+vo);
		System.out.println("작성자정보 "+vo.getWriter());
		//59라인에서 , data라는 이름의 @MA 설정을 추가했기 때문에, 
		//@SA->null방지 처리진행함
		bs.updateBoard(vo);
		return "main.do";
	}

	
	@RequestMapping(value="/deleteBoard.do")
	public String deletetBoard(BoardVO vo) {
		System.out.println("로그 : deletetBoard() @컨트롤러");
		bs.deleteBoard(vo);
		return "main.do";
	}
}
