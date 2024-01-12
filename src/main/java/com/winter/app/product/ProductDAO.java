package com.winter.app.product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.files.FileDTO;



@Repository
public class ProductDAO {

	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.winter.app.product.ProductDAO.";
	
	public List<ProductFileDTO> deleteList(ProductDTO dto){
		return sqlSession.selectList(namespace+"deleteList",dto);
	}
	
	public Integer total(ProductPager pager) throws Exception {
		return sqlSession.selectOne(namespace+"total",pager);
	}
	
	public List<ProductDTO> list(ProductPager pager) throws Exception {
		return sqlSession.selectList(namespace+"list",pager);
	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(namespace+"detail",productDTO);
	}
	
	public int addFile(ProductFileDTO dto) throws Exception{
		return sqlSession.insert(namespace+"addFile",dto);
		
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		return sqlSession.insert(namespace+"add",productDTO);
	}
	
	public int update(ProductDTO productDTO) {
		return sqlSession.update(namespace+"update",productDTO);
	}
	
	public int delete(ProductDTO productDTO) {
		return sqlSession.delete(namespace+"delete",productDTO);
	}
	
}
