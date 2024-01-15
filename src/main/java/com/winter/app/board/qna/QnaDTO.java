package com.winter.app.board.qna;

import java.util.List;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;

public class QnaDTO extends BoardDTO {
	private Long notice_Ref;
	private Long notice_Step;
	private Long notice_Depth;
	private List<BoardFileDTO> fileDTOs;

	public List<BoardFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<BoardFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	public Long getNotice_Ref() {
		return notice_Ref;
	}
	public void setNotice_Ref(Long notice_Ref) {
		this.notice_Ref = notice_Ref;
	}
	public Long getNotice_Step() {
		return notice_Step;
	}
	public void setNotice_Step(Long notice_Step) {
		this.notice_Step = notice_Step;
	}
	public Long getNotice_Depth() {
		return notice_Depth;
	}
	public void setNotice_Depth(Long notice_Depth) {
		this.notice_Depth = notice_Depth;
	}
	
	
}
