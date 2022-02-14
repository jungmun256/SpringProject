package com.test.app.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardService;
import com.test.app.board.BoardVO;

//@Component("boardService")해도 되지만 서칭 속도를 향상하기위해
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	//멤버변수
	@Autowired
	private BoardDAO3 boardDAO;

	@Override
	public void insertBoard(BoardVO vo) {
		if(vo.getWriter().equals("작성자2")) {
			//컴파일러는 무시하지만 실행시 발생하는 예외 만들기
			throw new IllegalArgumentException("일부러 발생시킨 예외");
		}
		boardDAO.insertBoard(vo);
		//boardDAO.insertBoard(vo);  // -> rollback();
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		return boardDAO.selectOne(vo);
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		System.out.println("검색기능 추가함");
		return boardDAO.selectAll(vo);
	}

}
