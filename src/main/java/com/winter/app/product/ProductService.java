package com.winter.app.product;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;
import com.winter.app.util.Paser;

@Service
public class ProductService {

		@Autowired
		private ProductDAO productDAO;
		
		//@Autowired
		private ServletContext context;
		
		@Autowired
		private FileManager fileManager;
		
		public List<ProductDTO> getList(Paser pager) throws Exception{
			pager.makeRow();
			System.out.println(pager.getStart_num());
			Integer totalCount =productDAO.total(pager);
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
			System.out.println(pager.getStart_num());
			return productDAO.getList(pager);
		}
		
		public ProductDTO getDetail(ProductDTO dto) throws Exception{
			
			return productDAO.getDetail(dto);
		}
		
		public int setAdd(ProductDTO dto,MultipartFile [] file) throws Exception{
			int result = productDAO.setAdd(dto);
			String path = context.getRealPath("resources/upload/product");
			
			for(MultipartFile ar:file) {
				if(ar.isEmpty()) continue;
			String filename =fileManager.fileSave(path, ar);
			
				ProductFileDTO fileDTO = new ProductFileDTO();
				fileDTO.setFileName(filename);
				fileDTO.setOriName(ar.getOriginalFilename());
				fileDTO.setProductNum(dto.getProductNum());	
				
				result = productDAO.setAddFile(fileDTO);
			}
			return result;
		}
		
		public int setUpdate(ProductDTO dto) throws Exception{
			return productDAO.setUpdate(dto);
			
		}
		public int setDelete(ProductDTO dto) throws Exception{
			List<ProductFileDTO> ar = productDAO.deleteList(dto);
			String path = context.getRealPath("/resources/upload/product");
			System.out.println(path);
			int result = productDAO.setDelete(dto);
			for(ProductFileDTO fileDTO:ar) {
				fileManager.fileDelete(path, fileDTO.getFileName());
			}
			
			return result;
			
		}
}
