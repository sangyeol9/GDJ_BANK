package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Paser;

@RequestMapping("/qna/*")
@Controller
public class QnaController {

	@Autowired
	@Qualifier("qnaService")
	private BoardService boardService;
	@Autowired
	private QnaService qnaService;
	@GetMapping("reply")
	public String setReply(BoardDTO dto,Model model) throws Exception{
		
		model.addAttribute("dto", dto);
		
		return "board/reply";
	}
	
	
	
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 1;
	}
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping
	public String setUpdate(BoardDTO dto , Model model) throws Exception{
		dto = boardService.getDetail(dto);
		model.addAttribute("dto", dto);
		return "board/update";
	}
	
	@PostMapping
	public String setUpdate(BoardDTO dto , Model model , MultipartFile [] attach) throws Exception{
		boardService.setUpdate(dto, attach);
		
		return "redirect:./list";
	}
	
	@PostMapping("delete")
	public String setDelete(QnaDTO dto) throws Exception {
		dto.setFlag(Integer.valueOf(1));
		int result = qnaService.setDelete(dto);
		return "redirect:./list";
	}
	
	@PostMapping("reply")
	public String setReply(QnaDTO dto,MultipartFile [] attach) throws Exception{
		int result = qnaService.setReply(dto,attach);
		
		return "redirect:./list";
	}
	
	@GetMapping("list")
	public String getList(Paser pager,Model model) throws Exception {
		List<BoardDTO> ar = boardService.getList(pager);
		
		model.addAttribute("list", ar);
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getDetail(QnaDTO dto,Model model) throws Exception{
		dto = (QnaDTO) boardService.getDetail(dto);
		
		model.addAttribute("detail", dto);
		return "board/detail";
	}
	
	@GetMapping("add")
	public String setAdd() throws Exception{
		
		return "board/add";
	}
	@PostMapping("add")
	public String setAdd(BoardDTO dto,MultipartFile [] attach) throws Exception{
		int result = boardService.setAdd(dto,attach);
		
		return "redirect:./list";
	}
}
