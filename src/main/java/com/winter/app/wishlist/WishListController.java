package com.winter.app.wishlist;

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

@Controller
@RequestMapping("/wishlist/*")
public class WishListController {

	@Autowired
	private WishListService service;
	
	@GetMapping("add")
	public void setWishList(WishListDTO dto,HttpSession session) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = (MemberDTO)session.getAttribute("member");
		dto.setUserName(memberDTO.getUserName());
		int result = service.setWishList(dto);
	}
	
	@GetMapping("list")
	public void getList(Model model,HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member"); 
		WishListDTO dto = new WishListDTO();
		dto.setUserName(memberDTO.getUserName());
		List<ProductDTO> ar = service.getList(dto);
		
		model.addAttribute("list", ar);
	}
	
	@PostMapping("delete")
	public String setDelete(HttpSession session,Long [] productNum,Model model) throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = (MemberDTO)session.getAttribute("member");
		for(Long l:productNum) {
			System.out.println(l);
		}
		WishListDTO [] ar = new WishListDTO[productNum.length];
		for(int i=0; i<ar.length;i++) {
			ar[i] = new WishListDTO();
			ar[i].setUserName(memberDTO.getUserName());
			ar[i].setProductNum(productNum[i]);
		}
		int result = service.setDelete(ar);
		
		model.addAttribute("result", result);
		return "commons/ajaxResult";
		
	}
	
	
}
