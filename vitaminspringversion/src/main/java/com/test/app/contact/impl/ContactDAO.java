//jdbcTemplate을 이용한 DAO
package com.test.app.contact.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.app.contact.ContactVO;


public class ContactDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sql_insertC = "INSERT INTO contact VALUES(LPAD(contact_seq.NEXTVAL,2,0), ?, ?, ?)";
	private String sql_selectAll = "SELECT * FROM contact";
	private String sql_selectOne = "SELECT * FROM contact WHERE msgno=?";
	private String sql_deleteC = "DELETE FROM contact WHERE msgno = ?";
	
	private String selectN="select * from contact where msgname like '%'||?||'%'";
	private String selectT="select * from contact where msgtext like '%'||?||'%'";
	
	
	// 고객문의 작성()
	public boolean insertContact(ContactVO vo) {
		//System.out.println("contact insert수행중");
		int cnt = jdbcTemplate.update(sql_insertC,vo.getMsgname(),vo.getMsgemail(),vo.getMsgtext());
		if(cnt == 1) {
			return true;
		}
		return false;
	}
	
	// 고객문의 리스트()
	public ArrayList<ContactVO> selectAll(ContactVO vo) {
		//System.out.println("contact selectAll수행중");
		String sql = sql_selectAll;
		Object[] obj = {vo.getSearchword()};
		if(vo.getSearchCondition().equals("msgname")) {
			sql = selectN;
		}
		else if(vo.getSearchCondition().equals("msgtext")){
			sql = selectT;
		}

		return (ArrayList<ContactVO>) jdbcTemplate.query(sql,obj,new ContactRowMapper());
	}
	
	// 고객문의 조회()
	public ContactVO selectOne(ContactVO vo) {
		//System.out.println("contact selectOne수행중");
		Object[] obj = {vo.getMsgno()};
		return jdbcTemplate.queryForObject(sql_selectOne,obj, new ContactRowMapper());
	}
	
	// 고객문의 삭제 메서드()
	public boolean deleteContact(ContactVO vo) {
		//System.out.println("contact deleteContact수행중");
		int cnt = jdbcTemplate.update(sql_deleteC,vo.getMsgno());
		if(cnt == 1) {
			return true;
		}
		return false;
	}
	
}

class ContactRowMapper implements RowMapper<ContactVO>{

	@Override
	public ContactVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ContactVO data=new ContactVO();
		data.setMsgno(rs.getInt("msgno"));
		data.setMsgname(rs.getString("msgname"));
		data.setMsgemail(rs.getString("msgemail"));
		data.setMsgtext(rs.getString("msgtext"));
		
		return data;
	}
	
}