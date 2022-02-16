//jdbcTemplate을 이용한 DAO
package com.test.app.notice.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.app.notice.NoticeVO;


public class NoticeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String sql_insertN = "INSERT INTO notice VALUES(LPAD(notice_seq.NEXTVAL, 2, 0), ?, ?, ?)"; 
	private String sql_selectAll = "SELECT ROWNUM, nidx, ntitle, ncont, writer FROM (SELECT * FROM notice ORDER BY nidx DESC) ORDER BY ROWNUM";
	private String sql_selectOne = "SELECT * FROM notice WHERE nidx=?";
	private String sql_updateN = "UPDATE notice SET ntitle=?, ncont=? WHERE nidx=?";
	private String sql_deleteN = "DELETE FROM notice WHERE nidx = ?"; 
	
	private String selectT="select * from notice where ntitle like '%'||?||'%'";
	private String selectC="select * from notice where ncont like '%'||?||'%'";
	
	
	public boolean insertNotice(NoticeVO vo) {
		//System.out.println("Notice insert수행중");
		int cnt = jdbcTemplate.update(sql_insertN,vo.getNtitle(),vo.getNcont(),vo.getWriter());
		if(cnt == 1) {
			return true;
		}
		return false;
		
	}

	// 공지사항 가져오기
	public ArrayList<NoticeVO> selectAll(NoticeVO vo) {
		
		//System.out.println("Notice selectAll수행중");

		String sql = sql_selectAll;
		Object[] obj = {vo.getSearchword()};
		if(vo.getSearchCondition().equals("ntitle")) {
			sql = selectT;
		}
		else if(vo.getSearchCondition().equals("ncont")){
			sql = selectC;
		}
		return (ArrayList<NoticeVO>) jdbcTemplate.query(sql,obj,new NoticeRowMapper());
	}
	
	public NoticeVO selectOne(NoticeVO vo) {
		//System.out.println("Notice selectOne수행중");
		Object[] obj = {vo.getNidx()};
		return jdbcTemplate.queryForObject(sql_selectOne,obj, new NoticeRowMapper());
	}
	
	// 공지사항 수정
	public boolean updateNotice(NoticeVO vo) {
		//System.out.println("Notice updateNotice수행중");
		int cnt = jdbcTemplate.update(sql_updateN,vo.getNtitle(),vo.getNcont(),vo.getNidx());
		if(cnt == 1) {
			return true;
		}
		return false;
	}
	

	public boolean deleteNotice(NoticeVO vo) {
		//System.out.println("Notice deleteNotice수행중");
		int cnt = jdbcTemplate.update(sql_deleteN,vo.getNidx());
		if(cnt == 1) {
			return true;
		}
		return false;
	}
	
}


class NoticeRowMapper implements RowMapper<NoticeVO>{

	@Override
	public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoticeVO data=new NoticeVO();
		data.setNidx(rs.getInt("nidx"));
		data.setNtitle(rs.getString("ntitle"));
		data.setNcont(rs.getString("ncont"));
		data.setWriter(rs.getString("writer"));
		
		return data;
	}
	
}