package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession; 
	String namespace = "com.winter.app.product.ProductDAO.";
	
	public List<ProductDTO> getList() throws Exception{
			
		return sqlSession.selectList(namespace+"getList");
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail",dto);
		
	}
	
}
