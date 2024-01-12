package com.winter.app.board.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/notice/*")
@Controller
public class NoticeController {

	@RequestMapping(value="list",method = RequestMethod.GET)
	public String gerList() throws Exception{
		
		return "notice/list";
	}
		
}
