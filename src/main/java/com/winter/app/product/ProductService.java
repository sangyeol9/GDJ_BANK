package com.winter.app.product;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;


@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	@Autowired
	private ServletContext context;
	@Autowired
	private FileManager fileManager;
	
	public int delete(ProductDTO dto) throws Exception{
		List<ProductFileDTO> ar = dao.deleteList(dto);
		String path = context.getRealPath("/resources/upload/products");
		int result = dao.delete(dto);
		for(ProductFileDTO fileDTO:ar) {
			fileManager.fileDelete(path, fileDTO.getFilename());
		}
		
		return result;
	}
	
	public int update(ProductDTO dto) throws Exception{
		return dao.update(dto);
	}
	
	public int addProduct(ProductDTO dto,MultipartFile [] file) throws Exception {
		int result = dao.add(dto);
		String path = context.getRealPath("resources/upload/products"); 
		
		for(MultipartFile file2 : file) {
			if(file2.isEmpty()) continue;
			String filename	=fileManager.fileSave(path, file2);
			
			
		System.out.println(path);
		
		
		ProductFileDTO fileDTO = new ProductFileDTO();
		fileDTO.setFilename(filename);
		fileDTO.setOriname(file2.getOriginalFilename());
		fileDTO.setProductnum(dto.getProductnum());
		result = dao.addFile(fileDTO);
		}
		return result;
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception {
		return dao.detail(dto);
		
	}
	
	public List<ProductDTO> getList(ProductPager pager) throws Exception {
		pager.makeRow();
		//총 row
		Integer totalCount =dao.total(pager);
		//총 페이지
		Integer totalPage =0;
		int mod = 0;
		if(totalCount%pager.getPager() > 0) mod =1;
		totalPage = (totalCount/pager.getPager() + mod) ;
		
		pager.setTotalPage(totalPage);
		
		Integer perblock=5;
		//총 블럭
		pager.setPerBlock(perblock);
		Integer totalBlock=0;
		totalBlock = totalPage / pager.getPerBlock();
		if(totalPage%pager.getPerBlock() !=0) totalBlock++;
		pager.setTotalBlock(totalBlock);
		//현재 page번호로 현재 블럭
		Integer curBlock =0;
		curBlock = pager.getPage() /pager.getPerBlock() ;
		if(pager.getPage() % pager.getPerBlock() !=0) curBlock++;
		
		//시작번호, 끝번호
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


