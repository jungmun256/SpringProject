package com.test.app.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.app.board.BoardVO;

// BoardDAO의 한계 : 중복코드많다.
// -> JDBCTemplate 사용
//		1 - JdbcDAOSupport 클래스를 상속받아서 구현 -> 문제 !! 강제성이 부족하다
//			
//		2 - JdbcTemplate 클래스 <bean> 등록하여 DI * (좀더 많이 쓴다.)
//			jdbcTemplate를 멤버변수로 사용!!


public class BoardDAO2{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String board_insert="insert into sboard(bid,title,writer,content,filepath) values((select nvl(max(bid),0)+1 from sboard),?,?,?,?)";
	private String board_update="update sboard set title=?,content=? where bid=?";
	private String board_delete="delete sboard where bid=?";
	private String board_selectOne="select * from sboard where bid=?";
	private String board_selectAll="select * from sboard order by bid desc";

	private String selectW="select * from sboard where writer like '%'||?||'%' order by bid desc";
	private String selectT="select * from sboard where title like '%'||?||'%' order by bid desc";
	
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insert수행중");
		jdbcTemplate.update(board_insert, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getFilepath());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("update수행중");
		jdbcTemplate.update(board_update, vo.getTitle(), vo.getContent(), vo.getBid());
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("delete수행중");
		jdbcTemplate.update(board_delete, vo.getBid());
	}
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("selectOne수행중");
		Object[] obj = {vo.getBid()};
		return jdbcTemplate.queryForObject(board_selectOne, obj, new BoardRowMapper());
	}
	public List<BoardVO> selectAll(BoardVO vo) {
		System.out.println("selectAll수행중 검색기능 추가됨");		
		String sql = board_selectAll;
		Object[] obj = {vo.getSearchContent()};
		if(vo.getSearchCondition().equals("title")) {
			sql = selectT;
		}
		else if(vo.getSearchCondition().equals("writer")){
			sql = selectW;
		}
		return  jdbcTemplate.query(sql,obj,new BoardRowMapper());
		
	}
	
}

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setBdate(rs.getDate("bdate"));
		data.setBid(rs.getInt("bid"));
		data.setCnt(rs.getInt("cnt"));
		data.setContent(rs.getString("content"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setFilepath(rs.getString("filepath"));
		return data;
	}
	
}