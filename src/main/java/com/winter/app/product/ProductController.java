package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/product/*")
public class ProductController {
	
		@Autowired
		private ProductService service;
	
	@RequestMapping(value="list",method = RequestMethod.GET)
	public String getList(ProductDTO dto,Model model ) throws Exception {
		List<ProductDTO> ar =service.getList();
		
		model.addAttribute("list", ar);
		return "product/list";
	}
	
	@RequestMapping(value="add",method = RequestMethod.GET)
	public String add() throws Exception{
		
		return "product/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(MultipartFile attach) throws Exception{
		
		
		return "commons/result";
	}
	
	@RequestMapping(value="detail",method = RequestMethod.GET)
	public String detail(ProductDTO dto,Model model)  throws Exception {
		
		dto = service.getDetail(dto);
		
		model.addAttribute("detail", dto);
		
		return "product/detail";
	}
	
}
