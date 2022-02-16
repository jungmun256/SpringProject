package com.test.app.notice;

import java.util.ArrayList;

public interface NoticeService {
	public boolean insertNotice(NoticeVO vo);
	public ArrayList<NoticeVO> selectAll(NoticeVO vo);
	public NoticeVO selectOne(NoticeVO vo) ;
	public boolean updateNotice(NoticeVO vo);
	public boolean deleteNotice(NoticeVO vo) ;
}
