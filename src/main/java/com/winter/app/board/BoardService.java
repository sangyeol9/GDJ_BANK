package com.winter.app.board;

import java.util.List;

import com.winter.app.util.Paser;

public interface BoardService {

	
	//목록
	public List<BoardDTO> getList(Paser pager) throws Exception;
	
	public Object getDetail(BoardDTO dto) throws Exception;
	
	public int setAdd(BoardDTO dto) throws Exception;
	
	public int setUpdate(BoardDTO dto) throws Exception;
	
	public int setDelete(BoardDTO dto) throws Exception;
	
}
