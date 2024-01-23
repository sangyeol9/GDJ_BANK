package com.winter.app.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.util.Paser;

@Controller
@RequestMapping("/account/*")
public class AccountController {

	@Autowired
	AccountService service;
	
	@GetMapping("add")
	public String setAdd(AccountDTO dto,Model model) throws Exception {
		model.addAttribute("detail", dto);
		return "account/add";
	}
	@PostMapping("add")
	public String setAdd(AccountDTO dto,Model model,HttpSession session) throws Exception {
		String msg = "실패";
		String path="/product/list";
		if(dto.getAccount_pw().length() !=4) {
			msg = "비밀번호는 4글자만 입력가능합니다";
			model.addAttribute("path", path);
			model.addAttribute("msg", msg);
			
			return "commons/result";
		}
		try {
			int check = Integer.valueOf( dto.getAccount_pw() );
			
		} catch (Exception e) {
			msg = "비밀번호는 숫자만 입력가능합니다";
			model.addAttribute("path", path);
			model.addAttribute("msg", msg);
			
			return "commons/result";
		}
		int result = service.setAdd(dto,session); 
		if(result > 0 )msg = "성공";
		
		model.addAttribute("path", path);
		model.addAttribute("msg", msg);
		
		return "commons/result";	
	}
	
	@GetMapping("list")
	public String getList(Paser pager ,AccountDTO dto,Model model,HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		//pager.setSearch(memberDTO.getUserName());
		dto.setPager(pager);
		System.out.println(dto);
		dto.setUserName(memberDTO.getUserName());
		
		List<ProductDTO> ar = service.getList(dto);
		
		model.addAttribute("list", ar);
		model.addAttribute("page", dto.getPager());
		return "account/list";
	}
	
}
