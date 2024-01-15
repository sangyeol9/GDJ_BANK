package com.winter.app.board;

import java.util.List;

import com.winter.app.util.Paser;

public interface BoardDAO {

	//totalCount
	
	public Long getTotalCount() throws Exception;
	
	//목록
	public List<BoardDTO> getList(Paser pager) throws Exception;
	
	public BoardDTO getDetail(BoardDTO dto) throws Exception;
	// public NoitceDTO 
	public int setAdd(BoardDTO dto) throws Exception;
	
	public int setUpdate(BoardDTO dto) throws Exception;
	
	public int setDelete(BoardDTO dto) throws Exception;
	
}
