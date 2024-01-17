package com.winter.app.board.notice;

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
public class NoticeService implements BoardService {
	
	@Autowired
	@Qualifier("na")
	private BoardDAO boardDAO;
	@Autowired
	private NoticeDAO dao;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ServletContext context;
	
	@Override
	public List<BoardDTO> getList(Paser pager) throws Exception {
		pager.makeRow();
		Integer totalCount = boardDAO.getTotalCount();
		System.out.println(totalCount);
		if(totalCount<1) totalCount=1;
		Integer totalPage= totalCount/pager.getPager();
		if(totalCount%pager.getPager() != 0) totalPage++;
		pager.setTotalPage(totalPage);
		System.out.println(pager.getTotalPage() + "totalpage");
		
		pager.setPerBlock(5);
		Integer totalBlock  = pager.getTotalPage() / pager.getPerBlock();
		if(pager.getTotalPage() % pager.getPerBlock() != 0 ) totalBlock++;
		pager.setTotalBlock(totalBlock);
		System.out.println(pager.getTotalBlock());
		
		Integer curBlock = pager.getPage() / pager.getPerBlock();
		if(pager.getPage()%pager.getPerBlock() != 0 )curBlock++;
		System.out.println(curBlock);
	
		
		Integer lastNum = curBlock * pager.getPerBlock();
		Integer startNum = lastNum-pager.getPerBlock() +1;
		if(lastNum > pager.getTotalPage()) lastNum = pager.getTotalPage();
		System.out.println(startNum);
		System.out.println(lastNum);
		pager.setStart_page(startNum);
		pager.setLast_page(lastNum);
		
		
		
		return boardDAO.getList(pager);
		
	}

	public BoardDTO setTag(BoardDTO dto) throws Exception {
		dto.setNotice_Title(dto.getNotice_Title().replaceAll("<", "&lt").replaceAll(">", "&gt"));
		if(dto.getNotice_Contents() != null)
		dto.setNotice_Contents(dto.getNotice_Contents().replaceAll("<", "&lt").replaceAll(">", "&gt"));
		if(dto.getNotice_Writter() != null)
		dto.setNotice_Writter(dto.getNotice_Writter().replaceAll("<", "&lt").replaceAll(">", "&gt"));;
		return dto;
	}
	
	@Override
	public BoardDTO getDetail(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.getDetail(dto);
	}

	@Override
	public int setAdd(BoardDTO dto,MultipartFile [] attach) throws Exception {
		//1. 글 번호를 알기 위해 
		int result = boardDAO.setAdd(dto);
		//2. 파일을 HDD 저장
		//2-1 저장할 폴더의 실제 경로 구하기
		String path = context.getRealPath("/resources/upload/notice");
		//2*2 hdd에 저장하고 파일명 받아오기
		for(MultipartFile ar : attach) {
			if(ar.isEmpty()) continue;
			String fileName=fileManager.fileSave(path, ar);
		//2-3 DB에 정보를 저장하기
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(ar.getOriginalFilename());
			boardFileDTO.setBoard_Num(dto.getNotice_Num());
			result = dao.setFileAdd(boardFileDTO);
			
			
			
		}
		return result;
	}

	@Override
	public int setUpdate(BoardDTO dto,MultipartFile [] attach) throws Exception {
		//hdd 파일 저장
		
		return boardDAO.setUpdate(dto);
	}

	@Override
	public int setDelete(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.setDelete(dto);
	}
	
}
