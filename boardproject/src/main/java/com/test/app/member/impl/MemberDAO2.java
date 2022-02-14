package com.test.app.member.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.app.member.MemberVO;


public class MemberDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String member_selectOne = "select * from smember where mid=? and password=?";
	private String member_insert = "insert into smember values(?,?,?,?)";
	private String member_update="update smember set password=?,name=? where mid=?";
	
	public MemberVO selectOne(MemberVO vo) throws Exception{
		System.out.println("member selectOne수행중");
		Object[] obj = {vo.getMid(), vo.getPassword()};
		return jdbcTemplate.queryForObject(member_selectOne, obj, new MemberRowMapper());	
	}
	
	public void updateMember(MemberVO vo) {
		System.out.println("member: update수행중");
		jdbcTemplate.update(member_update,vo.getPassword(),vo.getName(),vo.getMid());
	}
	
	public void insertMember(MemberVO vo){
		System.out.println("member insert수행중");
		jdbcTemplate.update(member_insert, vo.getMid(), vo.getPassword(), vo.getName(), vo.getRole());
	}
}


class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		
		data.setMid(rs.getString("mid"));
		data.setName(rs.getString("name"));
		data.setPassword(rs.getString("password"));
		data.setRole(rs.getString("role"));
		return data;
	}
	
}