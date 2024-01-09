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
	
	public List<ProductDTO> getList(ProductPager pager) throws Exception {
		pager.makeRow();
		Integer totalCount =dao.total(pager);
		
		Integer totalPage =0;
		int mod = 0;
		if(totalCount%pager.getPager() > 0) mod =1;
		totalPage = (totalCount/pager.getPager() + mod) ;
		
		pager.setTotalPage(totalPage);
		
		Integer perblock=5;

		pager.setPerBlock(perblock);
		Integer totalBlock=0;
		totalBlock = totalPage / pager.getPerBlock();
		if(totalPage%pager.getPerBlock() !=0) totalBlock++;
		pager.setTotalBlock(totalBlock);
		
		Integer curBlock =0;
		curBlock = pager.getPage() /pager.getPerBlock() ;
		if(pager.getPage() % pager.getPerBlock() !=0) curBlock++;
		
		Integer startnum=0;
		Integer lastnum=0;
		lastnum = curBlock*pager.getPerBlock();
		startnum = lastnum - (pager.getPerBlock()-1);
		if(lastnum>pager.getTotalPage())
			lastnum = pager.getTotalPage();
		pager.setLast_page(lastnum);
		pager.setStart_page(startnum);
		
		return this.dao.list(pager);
	}
	
	
	
}


