package com.winter.app.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value ="list",method = RequestMethod.GET)
	public String list(ProductPager pager,Model model) throws Exception {
		List<ProductDTO> list = productService.getList(pager);
		model.addAttribute("list",list);
		model.addAttribute("page", pager);
		return "products/list";
	}	
	
	@RequestMapping(value="detail",method =RequestMethod.GET)
	public String detail(ProductDTO productDTO,Model model) throws Exception {
		productDTO = productService.getDetail(productDTO);
		model.addAttribute("detail", productDTO);
		
		return "products/detail";
	}

	@RequestMapping(value ="add",method = RequestMethod.GET)
	public String add() {
		
		return "products/add";
	}
	@RequestMapping(value="add",method = RequestMethod.POST)
	public String add(ProductDTO productDTO, Model model) throws Exception {
	
		
		int result = productService.addProduct(productDTO);
		model.addAttribute("result", result);
		
		return "result/result";
	}
	
}
