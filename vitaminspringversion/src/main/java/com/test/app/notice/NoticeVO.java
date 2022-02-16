package com.test.app.notice;

public class NoticeVO {
	private int nidx;
	private String ntitle;
	private String ncont;
	private String writer;
	
	private String searchCondition;
	private String searchword;
	
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchword() {
		return searchword;
	}
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	
	
	public int getNidx() {
		return nidx;
	}
	public void setNidx(int nidx) {
		this.nidx = nidx;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcont() {
		return ncont;
	}
	public void setNcont(String ncont) {
		this.ncont = ncont;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "NoticeVO [nidx=" + nidx + ", ntitle=" + ntitle + ", ncont=" + ncont + ", writer=" + writer
				+ ", searchCondition=" + searchCondition + ", searchword=" + searchword + "]";
	}
	
	
}
