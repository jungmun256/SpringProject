package com.test.app.contact;

import java.util.ArrayList;

public interface ContactService {
	public boolean insertContact(ContactVO vo) ;
	
	// 고객문의 리스트()
	public ArrayList<ContactVO> selectAll(ContactVO vo) ;
	
	// 고객문의 조회()
	public ContactVO selectOne(ContactVO vo) ;
	
	// 고객문의 삭제 메서드()
	public boolean deleteContact(ContactVO vo);
	
}
