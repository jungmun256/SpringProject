//mybatis를 이용한 DAO
package com.test.app.contact.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.contact.ContactVO;


@Repository("contactDAO")
public class ContactDAO2 {
	
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public boolean insertContact(ContactVO vo) {
		//System.out.println("contact insert수행중");
		int cnt = mybatis.insert("ContactDAO.insertContact",vo);
		if(cnt == 1) {
			return true;
		}
		return false;
	}
	
	// 고객문의 리스트()
	public List<ContactVO> selectAll(ContactVO vo) {
		//System.out.println("contact selectAll수행중");
		return mybatis.selectList("ContactDAO.selectAll",vo);
	}
	
	// 고객문의 조회()
	public ContactVO selectOne(ContactVO vo) {
		//System.out.println("contact selectOne수행중");
		return (ContactVO) mybatis.selectOne("ContactDAO.selectOne",vo);
	}
	
	// 고객문의 삭제 메서드()
	public boolean deleteContact(ContactVO vo) {
		//System.out.println("contact deleteContact수행중");
		int cnt = mybatis.delete("ContactDAO.deleteContact", vo);
		if(cnt == 1) {
			return true;
		}
		return false;
	}

}
