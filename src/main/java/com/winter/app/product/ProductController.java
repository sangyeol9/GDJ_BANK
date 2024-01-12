package com.winter.app.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/product/*")
public class ProductController {
	
	@RequestMapping(value="list",method = RequestMethod.GET)
	public String getList() throws Exception {
			
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
	
}
