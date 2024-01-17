package com.winter.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Paser;

public interface BoardService {

	
	//목록
	public List<BoardDTO> getList(Paser pager) throws Exception;
	
	public BoardDTO getDetail(BoardDTO dto) throws Exception;
	
	public int setAdd(BoardDTO dto,MultipartFile [] attach) throws Exception;
	
	public int setUpdate(BoardDTO dto,MultipartFile [] attach) throws Exception;
	
	public int setDelete(BoardDTO dto) throws Exception;
	
}
