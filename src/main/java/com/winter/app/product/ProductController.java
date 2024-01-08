package com.winter.app.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/product/*")
public class ProductController {
	
	private ProductDTO dto ;
	private ProductDAO dao ;

	public ProductController() {
		this.dto = new ProductDTO();
		this.dao = new ProductDAO();
	}
	
	@RequestMapping(value ="list",method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		List<ProductDTO> list = dao.list();
		request.setAttribute("list", list);
	
		return "product/list";
	}	
	
	@RequestMapping(value="detail",method =RequestMethod.GET)
	public String detail(ProductDTO productDTO,Model model) throws Exception {
		productDTO = dao.detail(productDTO);
		model.addAttribute("detail", productDTO);
		
		return "product/detail";
	}

	@RequestMapping(value ="add",method = RequestMethod.GET)
	public String add() {
		
		return "product/add";
	}
	@RequestMapping(value="add",method = RequestMethod.POST)
	public String add(ProductDTO productDTO, Model model) throws Exception {
	
		
		int result = dao.add(productDTO);
		model.addAttribute("result", result);
		
		return "result/result";
	}
	
}
