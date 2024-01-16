package com.winter.app.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.FileManager;
import com.winter.app.util.Paser;

@Service
public class QnaService implements BoardService {

		@Autowired
		@Qualifier("ba")
		private BoardDAO boardDAO;
		@Autowired
		private QnaDAO qnaDAO;
		@Autowired
		private FileManager fileManager;
		@Autowired
		private ServletContext context;
		
		
	@Override
	public List<BoardDTO> getList(Paser pager) throws Exception {
		pager.makeRow();
		return	boardDAO.getList(pager);
		
	}
	
	
	
	
	@Override
	public BoardDTO getDetail(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.getDetail(dto);
	}

	@Override
	public int setAdd(BoardDTO dto,MultipartFile [] attach) throws Exception {
		// TODO Auto-generated method stub
		int result = boardDAO.setAdd(dto); 
		String path = context.getRealPath("/resources/upload/qna");
		for(MultipartFile ar:attach) {
			if(ar.isEmpty()) continue;
			
			String fileName = fileManager.fileSave(path, ar);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setBoard_Num(dto.getNotice_Num());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(ar.getOriginalFilename());
			result =qnaDAO.setFileAdd(boardFileDTO);
		}
		
		return  result;
	}

	@Override
	public int setUpdate(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO dto) throws Exception {
		//1. file 삭제
		List<BoardFileDTO> files = qnaDAO.getFileList(dto);
		String path = context.getRealPath("/resources/upload/qna");
		for(BoardFileDTO b:files) {
		fileManager.fileDelete(path, b.getFileName());
		}
		//2. file table의 정보 삭제
		int result = qnaDAO.setFileDelete(dto);
		
		//3. qna 정보 수정
		result= boardDAO.setDelete(dto);
		return result;
	}
	
	public int setReply (QnaDTO dto,MultipartFile [] attach) throws Exception{
		//1.부모의 정보를 조회 (ref depth step)
		QnaDTO parent =(QnaDTO)boardDAO.getDetail(dto);
		int result;
		String path = context.getRealPath("resources/upload/qna");
		//2. 답글 정보 저장 (ref depth step)
		dto.setNotice_Ref(parent.getNotice_Ref());
		dto.setNotice_Step(parent.getNotice_Step()+1);
		dto.setNotice_Depth(parent.getNotice_Depth()+1);
		//3. step을 업데이트
		 result = qnaDAO.setReplyUpdate(parent);
		
		//4.DB에 답글 저장 
		result =  qnaDAO.setReplyAdd(dto);
		for(MultipartFile ar:attach) {
			if(ar.isEmpty()) continue;
			String fileName=fileManager.fileSave(path, ar);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setBoard_Num(dto.getNotice_Num());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(ar.getOriginalFilename());
			result = qnaDAO.setFileAdd(boardFileDTO);
		}
		
		return result ;
	}
	
}
