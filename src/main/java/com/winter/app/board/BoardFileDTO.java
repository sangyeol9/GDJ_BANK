package com.winter.app.board;

import com.winter.app.files.FileDTO;

public class BoardFileDTO extends FileDTO {
	
	private Long notice_Num;
	
	public Long getBoard_Num() {
		return notice_Num;
	}

	public void setBoard_Num(Long notice_Num) {
		this.notice_Num = notice_Num;
	}
	
	
}
