package com.winter.app.board;

import java.util.List;

public interface BoardService {

	
	//목록
	public List<Object> getList() throws Exception;
	
	public Object getDetail(BoardDTO dto) throws Exception;
	
	public int setAdd(BoardDTO dto) throws Exception;
	
	public int setUpdate(BoardDTO dto) throws Exception;
	
	public int setDelete(BoardDTO dto) throws Exception;
	
}
