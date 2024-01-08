package com.winter.app;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.product.ProductDAO;
import com.winter.app.product.ProductDTO;

public class Testcom extends MyTest {
	
	@Autowired
	private ProductDAO dao;
	
	@Test
	public void testList() throws Exception {
		List<ProductDTO> ar = dao.list();
		
		assertNotEquals(0, ar.size());
		
	}
	
	@Test
	public void testDetail() throws Exception{
		ProductDTO dto = new ProductDTO();
		dto.setProductnum(1L);
		dto = dao.detail(dto);
		
		assertNotNull(dto.getProductcontents());
	}
	
	@Test
	public void testAdd() throws Exception{
		ProductDTO dto = new ProductDTO();
		dto.setProductnum(10L);
		dto.setProductjumsu(3.3);
		dto.setProductname("test");
		dto.setProductrate(3.3);
		dto.setProductcontents("test");
		int result = dao.add(dto);
		assertNotEquals(0, result);
	}
	
}
