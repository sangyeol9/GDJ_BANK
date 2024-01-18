package com.winter.app.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.member.MemberDTO;
import com.winter.app.util.Paser;

import oracle.jdbc.proxy.annotation.Post;

@RequestMapping(value="/notice/*")
@Controller
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	private BoardService boardService;
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 0;
	}
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("update")
	public String setUpdate(BoardDTO dto,Model model) throws Exception{
		dto = boardService.getDetail(dto);
		model.addAttribute("dto", dto);
		
		return "board/update";
	}
	
	@PostMapping("update")
	public String setUpdate(BoardDTO dto,Model model,MultipartFile [] attach,HttpSession session) throws Exception{
		
		int result = boardService.setUpdate(dto, attach);
		return "redirect:./list";
	}
	
	@PostMapping
	public String setDelete(BoardDTO dto) throws Exception{
		int result =  boardService.setDelete(dto);
		
		return "redirect:./list";
	}
	
	//@RequestMapping(value="list",method = RequestMethod.GET)
	@GetMapping("list")
	public String getList(Paser pager,Model model) throws Exception{
		List<BoardDTO> ar =  boardService.getList(pager);
		
		for(BoardDTO a : ar) {
			noticeService.setTag(a);
		}
		
		model.addAttribute("list", ar);
		model.addAttribute("page", pager);
		return "board/list";
	}
		
	@GetMapping("detail")
	public String getDetail(BoardDTO dto,Model model) throws Exception{
		dto =  boardService.getDetail(dto);
		
		noticeService.setTag(dto);
		
		model.addAttribute("detail", dto);
		return "board/detail";
	}
	
	@GetMapping("add")
	public String setAdd() throws Exception{
		
		
		return "board/add";
	}
	
	@PostMapping("add")
	public String setAdd(BoardDTO dto, MultipartFile [] attach,HttpSession session ) throws Exception{
		dto.setNotice_Writter( ( (MemberDTO)session.getAttribute("member") ).getUserName() );
		int result = boardService.setAdd(dto,attach);
		return "redirect:./list";
	}
}
