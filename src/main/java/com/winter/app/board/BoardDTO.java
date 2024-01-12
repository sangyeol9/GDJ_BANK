package com.winter.app.board;

import java.sql.Date;

public class BoardDTO {
	private Long noticeName;
	private String noticeTitle;
	private String noticeWritter;
	private String noticeContents;
	private Date noticeDate;
	private Long noticeView;
	public Long getNoticeName() {
		return noticeName;
	}
	public void setNoticeName(Long noticeName) {
		this.noticeName = noticeName;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeWritter() {
		return noticeWritter;
	}
	public void setNoticeWritter(String noticeWritter) {
		this.noticeWritter = noticeWritter;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public Long getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(Long noticeView) {
		this.noticeView = noticeView;
	}
	
	
}
