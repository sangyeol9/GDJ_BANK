package com.winter.app.wishlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.product.ProductDTO;

@Service
public class WishListService {

	@Autowired
	private WishListDAO dao;
	
	public int setWishList(WishListDTO dto) throws Exception {
		return dao.setWishList(dto);
	}
	public List<ProductDTO> getList(WishListDTO dto) throws Exception {
		return dao.getList(dto);
	}
	public int setDelete(WishListDTO [] ar) throws Exception{
		int result =0;
		for(WishListDTO a:ar) {
		result =dao.setDelete(a);
		}
		return result;
	}
}
