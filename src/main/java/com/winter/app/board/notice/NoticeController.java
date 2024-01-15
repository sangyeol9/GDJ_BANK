package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Paser;

@RequestMapping(value="/notice/*")
@Controller
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	private BoardService boardService;
	
	//@RequestMapping(value="list",method = RequestMethod.GET)
	@GetMapping("list")
	public String getList(Paser pager,Model model) throws Exception{
		List<BoardDTO> ar =  boardService.getList(pager);
		
		
		model.addAttribute("list", ar);
		return "board/list";
	}
		
	@GetMapping("detail")
	public String getDetail(BoardDTO dto,Model model) throws Exception{
		dto =  boardService.getDetail(dto);
		
		model.addAttribute("detail", dto);
		return "board/detail";
	}
	
	@GetMapping("add")
	public String setAdd() throws Exception{
		
		
		return "board/add";
	}
	
	@PostMapping("add")
	public String setAdd(BoardDTO dto ) throws Exception{
		
		int result = boardService.setAdd(dto);
		return "redirect:./list";
	}
}
