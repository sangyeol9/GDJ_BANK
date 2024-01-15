package com.winter.app.board;

import java.sql.Date;

public class BoardDTO {
	
	private Long notice_Num;
	private String notice_Title;
	private String notice_Writter;
	private String notice_Contents;
	private Date notice_Time;
	private Long notice_View;
	
	public Long getNotice_Num() {
		return notice_Num;
	}
	public void setNotice_Num(Long notice_Num) {
		this.notice_Num = notice_Num;
	}
	public String getNotice_Title() {
		return notice_Title;
	}
	public void setNotice_Title(String notice_Title) {
		this.notice_Title = notice_Title;
	}
	public String getNotice_Writter() {
		return notice_Writter;
	}
	public void setNotice_Writter(String notice_Writter) {
		this.notice_Writter = notice_Writter;
	}
	public String getNotice_Contents() {
		return notice_Contents;
	}
	public void setNotice_Contents(String notice_Contents) {
		this.notice_Contents = notice_Contents;
	}
	public Date getNotice_Time() {
		return notice_Time;
	}
	public void setNotice_Time(Date notice_Time) {
		this.notice_Time = notice_Time;
	}
	public Long getNotice_View() {
		return notice_View;
	}
	public void setNotice_View(Long notice_View) {
		this.notice_View = notice_View;
	}
	
	
}
