package com.test.app.contact.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.contact.ContactService;
import com.test.app.contact.ContactVO;


@Service("contactService")
public class ContactServiceImpl implements ContactService{

	
	@Autowired
	private ContactDAO2 contactDao;
	
	@Override
	public boolean insertContact(ContactVO vo) {
		return contactDao.insertContact(vo);
	}

	@Override
	public ArrayList<ContactVO> selectAll(ContactVO vo) {
		return (ArrayList<ContactVO>) contactDao.selectAll(vo);
	}

	@Override
	public ContactVO selectOne(ContactVO vo) {
		return contactDao.selectOne(vo);
	}

	@Override
	public boolean deleteContact(ContactVO vo) {
		return contactDao.deleteContact(vo);
	}

}
