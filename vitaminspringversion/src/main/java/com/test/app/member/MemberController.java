package com.test.app.member;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("mdata")
public class MemberController {

	@Autowired
	MemberService ms;
	
	//로그인
	@RequestMapping("/member_login.mem")
	public String memberLogin(MemberVO vo, HttpSession session) {
		
		if(vo.getMid()== null || vo.getMid().equals("")) {
			throw new IllegalArgumentException("아이디를 입력하지 않았습니다.");
		}
		
		MemberVO data = ms.loginMember(vo);
		//System.out.println("여기안들어오는가?"+data);
		session.setAttribute("mid", data.getMid());
		session.setAttribute("mname", data.getMname());
		session.setAttribute("mrole", data.getMrole());
		return "main.do";
	}

	//로그아웃
	@RequestMapping("/member_logout.mem")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "main.do";
	}

	//회원가입폼에서 id 중복확인
	@RequestMapping("/isExistId.mem")
	public String memberExistid(MemberVO vo, HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		int result;
		MemberVO data = ms.selectMember(vo);
		if (data != null) {
			result = 0;
			System.out.println("이미 존재하는 아이디입니다.");
		} else {
			result = 1;
			System.out.println("사용 가능한 아이디입니다.");
		}
		out.write(result + "");
		return null;
	}

	//회원가입
	@RequestMapping("/member_insert.mem")
	public String memberInsert(MemberVO vo) {
		ms.insertMember(vo);
		return "login.jsp";
	}
	
	//마이페이지
	@RequestMapping("/member_mypage.mem")
	public String memberSelect(MemberVO vo, Model model) {
		model.addAttribute("mdata", ms.selectMember(vo));
		return "mypage.jsp";
	}

	//회원정보수정
	@RequestMapping("/member_update.mem")
	public String memberUpdate(@ModelAttribute("mdata")MemberVO vo, HttpSession session){
		// 세션에 저장되어 있는 id 값 가져온 뒤 sql문에서 id로 판별해야 하므로 id값 설정
		vo.setMid((String) session.getAttribute("mid"));
		ms.updateMember(vo);
		session.setAttribute("mname", vo.getMname());
		return "main.do";
	}

	//회원정보삭제(회원탈퇴)
	@RequestMapping("/member_delete.mem")
	public String memberDelete(MemberVO vo,HttpSession session) {
		ms.deleteMember(vo);
		session.invalidate();
		return "main.do";

	}

}