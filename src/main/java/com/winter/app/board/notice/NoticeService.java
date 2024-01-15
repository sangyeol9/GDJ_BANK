package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Paser;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	@Qualifier("na")
	private BoardDAO boardDAO;
	
	
	@Override
	public List<BoardDTO> getList(Paser pager) throws Exception {
		pager.makeRow();
		
		
		return boardDAO.getList(pager);
		
	}

	@Override
	public Object getDetail(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setAdd(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
