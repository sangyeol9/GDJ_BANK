package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	public int delete(ProductDTO dto) throws Exception{
		return dao.delete(dto);
	}
	
	public int update(ProductDTO dto) throws Exception{
		return dao.update(dto);
	}
	
	public int addProduct(ProductDTO dto) throws Exception {
		return dao.add(dto);
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception {
		return dao.detail(dto);
		
	}
	
	public List<ProductDTO> getList() throws Exception {
	return this.dao.list();	
	
	

	}
	
	
}


