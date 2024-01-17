package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.FileManager;
import com.winter.app.util.Paser;

@Service
public class NoticeService implements  BoardService{

	@Autowired
	@Qualifier("na")
	private BoardDAO boardDAO;
	@Autowired
	private FileManager fileManager;
	@Override
	public List<BoardDTO> getList(Paser pager) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.getDetail(dto);
	}

	@Override
	public int setAdd(BoardDTO dto, MultipartFile[] attach) throws Exception {
		// TODO Auto-generated method stub
		int result = boardDAO.setAdd(dto);
		String path = "/resources/upload/notice";
		for(MultipartFile ar:attach) {
			fileManager.fileSave(path, ar);
			
		}
		
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO dto, MultipartFile[] attach) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
