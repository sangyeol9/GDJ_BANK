package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Paser;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession; 
	String namespace = "com.winter.app.product.ProductDAO.";
	
	public List<ProductFileDTO> deleteList(ProductDTO dto){
		return sqlSession.selectList(namespace+"deleteList",dto);
	}
	
	public List<ProductDTO> getList(Paser pager) throws Exception{
		return sqlSession.selectList(namespace+"getList",pager);
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail",dto);
		
	}
	
	public int setAdd(ProductDTO dto) throws Exception {
		return sqlSession.insert(namespace+"setAdd",dto);
	}
	
	public int setUpdate(ProductDTO dto) throws Exception{
		return sqlSession.update(namespace+"setUpdate",dto);
		
	}
	
	public int setDelete(ProductDTO dto) throws Exception{
		return sqlSession.delete(namespace+"setDelete",dto);
		
	}
	
	public int setAddFile(ProductFileDTO dto) throws Exception{
		
		return sqlSession.insert(namespace+"setAddFile",dto);
	}
	
	public Integer total(Paser pager) throws Exception{
		return sqlSession.selectOne(namespace+"total",pager);
		
	}
}
