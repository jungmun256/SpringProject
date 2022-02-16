//jdbcTemplate을 이용한 DAO
package com.test.app.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.app.member.MemberVO;

public class MemberDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sql_insertM = "INSERT INTO member(mno, mid, mpw, mname, mgender, "
			+ "mbirth, maddr_zipcode, maddr_street, maddr_detail, maddr_etc, mtel, memail) "
			+ "VALUES"
			+ "('MEM' || LPAD(member_seq.NEXTVAL, 3, 0),?,?,?,?,?,?,?,?,?,?,?)"; 
	private String sql_selectM = "SELECT * FROM member WHERE mid=?"; 
	private String sql_updateM = "UPDATE member SET mname=nvl(?, mname), mgender=nvl(?, mgender), mbirth = nvl(?, mbirth), maddr_zipcode=nvl(?, maddr_zipcode), maddr_street=nvl(?, maddr_street) , maddr_detail=nvl(?, maddr_detail), maddr_etc=nvl(?, maddr_etc), mtel=nvl(?, mtel) ,memail=nvl(?, memail) WHERE mid = ?"; 
	private String sql_deleteM = "DELETE FROM member WHERE mid=? AND mpw=?"; 
	
	//회원가입
	public boolean insertMember(MemberVO vo) { 
		//System.out.println("insert수행중");
		int cnt = jdbcTemplate.update(sql_insertM, vo.getMid(), vo.getMpw(), vo.getMname(), vo.getMgender(),vo.getMbirth(),vo.getMaddr_zipcode(), vo.getMaddr_street(), vo.getMaddr_detail(), vo.getMaddr_etc(), vo.getMtel(), vo.getMemail());
		if(cnt == 1) {
			return true;
		}
		return false;
	}

	//회원조회
	public MemberVO selectMember(MemberVO vo) {
		//System.out.println("member selectOne수행중");
		Object[] obj = {vo.getMid()};
		return jdbcTemplate.queryForObject(sql_selectM,obj, new MemberRowMapper());
	}
	
	//회원정보수정
	public boolean updateMember(MemberVO vo) {
		System.out.println("updateMember수행중");
		int cnt = jdbcTemplate.update(sql_updateM,vo.getMname(), vo.getMgender(),vo.getMbirth(),vo.getMaddr_zipcode(), vo.getMaddr_street(), vo.getMaddr_detail(), vo.getMaddr_etc(), vo.getMtel(), vo.getMemail(),vo.getMid());
		if(cnt == 1) {
			return true;
		}
		return false;
    }
	
	//회원삭제(회원탈퇴)
	public boolean deleteMember(MemberVO vo) {
		System.out.println("deleteMember수행중");
		int cnt = jdbcTemplate.update(sql_deleteM, vo.getMid(), vo.getMpw());
		if(cnt == 1) {
			return true;
		}
		return false;
	}

}


class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setMid(rs.getString("mid"));
		data.setMpw(rs.getString("mpw"));
		data.setMname(rs.getString("mname"));
		data.setMgender(rs.getString("mgender"));
		data.setMbirth(rs.getString("mbirth"));
		data.setMemail(rs.getString("memail"));
		data.setMrole(rs.getString("mrole"));
		data.setMtel(rs.getString("mtel"));
		data.setMaddr_zipcode(rs.getString("maddr_zipcode"));
		data.setMaddr_street(rs.getString("maddr_street"));
		data.setMaddr_detail(rs.getString("maddr_detail"));
		data.setMaddr_etc(rs.getString("maddr_etc"));
		
		return data;
	}
	
}
