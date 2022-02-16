//mybatis를 이용한 DAO
package com.test.app.notice.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.notice.NoticeVO;

@Repository("noticeDAO")
public class NoticeDAO2 {

	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public boolean insertNotice(NoticeVO vo) {
		//System.out.println("Notice insert수행중");
		int cnt = mybatis.insert("NoticeDAO.insertNotice",vo);
		if(cnt == 1) {
			return true;
		}
		return false;
		
	}

	// 공지사항 가져오기
	public List<NoticeVO> selectAll(NoticeVO vo) {
		//System.out.println("Notice selectAll수행중");
		return mybatis.selectList("NoticeDAO.selectAll",vo);
	}
	
	public NoticeVO selectOne(NoticeVO vo) {
		//System.out.println("Notice selectOne수행중");
		return (NoticeVO) mybatis.selectOne("NoticeDAO.selectOne",vo);
	}
	
	// 공지사항 수정
	public boolean updateNotice(NoticeVO vo) {
		//System.out.println("Notice updateNotice수행중");
		int cnt = mybatis.insert("NoticeDAO.updateNotice",vo);
		if(cnt == 1) {
			return true;
		}
		return false;
	}
	

	public boolean deleteNotice(NoticeVO vo) {
		//System.out.println("Notice deleteNotice수행중");
		int cnt = mybatis.delete("NoticeDAO.deleteNotice", vo);
		if(cnt == 1) {
			return true;
		}
		return false;
	}
}
