package com.test.app.contact;

public class ContactVO {
	private int msgno;
	private String msgname;
	private String msgemail;
	private String msgtext;
	
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
	public int getMsgno() {
		return msgno;
	}
	public void setMsgno(int msgno) {
		this.msgno = msgno;
	}
	public String getMsgname() {
		return msgname;
	}
	public void setMsgname(String msgname) {
		this.msgname = msgname;
	}
	public String getMsgemail() {
		return msgemail;
	}
	public void setMsgemail(String msgemail) {
		this.msgemail = msgemail;
	}
	public String getMsgtext() {
		return msgtext;
	}
	public void setMsgtext(String msgtext) {
		this.msgtext = msgtext;
	}
	
	@Override
	public String toString() {
		return "ContactVO [msgno=" + msgno + ", msgname=" + msgname + ", msgemail=" + msgemail + ", msgtext=" + msgtext
				+ "]";
	}
}
