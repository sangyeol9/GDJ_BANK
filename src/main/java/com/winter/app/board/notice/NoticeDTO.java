package com.winter.app.board.notice;

import java.util.List;

import com.winter.app.board.BoardDTO;

public class NoticeDTO extends BoardDTO {
	
	
	private List<BoardDTO> fileDTOs;

	public List<BoardDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<BoardDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	
	
}
