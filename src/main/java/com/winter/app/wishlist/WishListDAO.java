package com.winter.app.wishlist;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.product.ProductDTO;

@Repository
public class WishListDAO {
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.winter.app.wishlist.WishListDAO.";
	
	public int setWishList(WishListDTO dto) throws Exception {
		return sqlSession.insert(namespace+"setWishList",dto);
	}

	public List<ProductDTO> getList(WishListDTO dto) throws Exception{
		return sqlSession.selectList(namespace+"getList",dto);
	}
	
	public int setDelete(WishListDTO ar) throws Exception{ 
		return sqlSession.delete(namespace+"setDelete",ar);
	}
}
