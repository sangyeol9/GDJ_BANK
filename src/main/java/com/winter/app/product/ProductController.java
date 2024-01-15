package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Paser;

@Controller
@RequestMapping(value="/product/*")
public class ProductController {
	
		@Autowired
		private ProductService service;
	
	@RequestMapping(value="list",method = RequestMethod.GET)
	public String getList(Paser pager,Model model ) throws Exception {
		List<ProductDTO> ar =service.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("page", pager);
		return "product/list";
	}
	
	@RequestMapping(value="add",method = RequestMethod.GET)
	public String add() throws Exception{
		
		return "product/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(ProductDTO dto,MultipartFile [] attach,Model model) throws Exception{
		int result = service.setAdd(dto,attach);
		
		String msg = "실패";
		String path = "../product/list";
		
		if(result>0) 
				msg = "성공";
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
			
		return "commons/result";
	}
	
	@RequestMapping(value="detail",method = RequestMethod.GET)
	public String detail(ProductDTO dto,Model model)  throws Exception {
		
		dto = service.getDetail(dto);
		
		model.addAttribute("detail", dto);
		
		return "product/detail";
	}
	
	@RequestMapping(value="update",method = RequestMethod.GET)
	public String update() throws Exception {
		
		return "product/update";
	}
	
	@RequestMapping(value="update",method = RequestMethod.POST)
	public String update(ProductDTO dto,Model model) throws Exception {
		int result = service.setUpdate(dto);
		String msg = "실패";
		String path="../product/list";
		if(result>0) 
			msg = "성공";
	
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		
	return "commons/result";
	}
	
	@RequestMapping(value="delete",method = RequestMethod.GET)
	public String delete(ProductDTO dto,Model model) throws Exception{
		int result = service.setDelete(dto);
		String msg = "실패";
		String path="../product/list";
		if(result>0) 
			msg = "성공";
	
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		
		
		return "commons/result";
	}
	
}
