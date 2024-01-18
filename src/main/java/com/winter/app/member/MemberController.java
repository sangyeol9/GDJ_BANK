package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping
	public String setJoin() throws Exception {
		
		return "member/join";
	}
	@PostMapping
	public String setJoin(MemberDTO dto,Model model,MultipartFile attach) throws Exception{
		int result = service.setJoin(dto,attach);
		String path = "/";
		String msg = "실패";
		
		if(result >0) msg = "성공";
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		return "/commons/result";
	}
	
}
