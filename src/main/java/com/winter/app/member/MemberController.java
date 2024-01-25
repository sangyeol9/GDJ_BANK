package com.winter.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@GetMapping("idcheck")
	public String getIdCheck(MemberDTO dto,Model model) throws Exception{
		dto = service.getDetail(dto);
		int result = 0;
		if(dto==null) result =1;
		
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
	
	@GetMapping("logout")
	public String getLogOut(HttpSession session) throws Exception{
		//session.setAttribute("member", null);
		//session.removeAttribute("member");
		//session.removeValue("member")
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("join")
	public String setJoin() throws Exception {
		
		return "member/join";
	}
	
	@GetMapping("agreement")
	public void setAgreement() throws Exception{
		
	}
	
	@PostMapping("join")
	public String setJoin(MemberDTO dto,Model model,MultipartFile attach) throws Exception{
		int result = service.setJoin(dto,attach);
		String path = "/";
		String msg = "실패";
		
		if(result >0) msg = "성공";
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		return "/commons/result";
	}
	
	@GetMapping("login")
	public String getLogin() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String getLogin(MemberDTO dto,HttpSession session,Model model) throws Exception{
		dto = service.getLogin(dto);
		if(dto==null) {
			model.addAttribute("msg", "아이디 또는 패스워드를 확인하세요");
		return "member/login";
		}
		session.setAttribute("member", dto);
		
		
		
		return "redirect:/";
	}
	
	@GetMapping("mypage")
	public String getMyPage(HttpSession session,Model model) throws Exception{
		
	MemberDTO dto =(MemberDTO)session.getAttribute("member");
	
	model.addAttribute("mypage", dto);
	
		
		return "member/mypage";
	}
	
	@GetMapping("update")
	public void setUpdate(HttpSession session) throws Exception{
		
	}
	
	@PostMapping("update")
	public String setUpdate(MemberDTO dto,HttpSession session,Model model) throws Exception{
		MemberDTO temp = new MemberDTO();
		 temp = ( (MemberDTO)session.getAttribute("member"));
		dto.setUserName(temp.getUserName());
		dto = service.setUpdate(dto); 
		String msg = "성공";
		String path = "/member/mypage";
		
		
		
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		
		session.setAttribute("member", dto);
		model.addAttribute("mypage", dto);
		
		return "/commons/result";
	}
	
}
