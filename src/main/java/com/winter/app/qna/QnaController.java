package com.winter.app.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RequestMapping(value="/qna/*")
@Controller
public class QnaController {

		@RequestMapping(value = "list",method =RequestMethod.GET)
		public String getList() throws Exception {
			
			return "qna/list";
		}
	
}
