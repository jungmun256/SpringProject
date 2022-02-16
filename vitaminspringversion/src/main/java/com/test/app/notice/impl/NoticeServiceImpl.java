package com.test.app.notice.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.notice.NoticeService;
import com.test.app.notice.NoticeVO;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO2 noticeDao;
	
	@Override
	public boolean insertNotice(NoticeVO vo) {
		return noticeDao.insertNotice(vo);
	}

	@Override
	public ArrayList<NoticeVO> selectAll(NoticeVO vo) {
		return (ArrayList<NoticeVO>) noticeDao.selectAll(vo);
	}

	@Override
	public NoticeVO selectOne(NoticeVO vo) {
		return noticeDao.selectOne(vo);
	}

	@Override
	public boolean updateNotice(NoticeVO vo) {
		return noticeDao.updateNotice(vo);
	}

	@Override
	public boolean deleteNotice(NoticeVO vo) {
		return noticeDao.deleteNotice(vo);
	}

	
}
