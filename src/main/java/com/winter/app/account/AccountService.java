package com.winter.app.account;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.util.Paser;

@Service
public class AccountService {
	@Autowired
	private AccountDAO dao;
	
	public int setAdd(AccountDTO dto,HttpSession session) throws Exception {
		Calendar calendar = Calendar.getInstance();
		dto.setAccount_num(calendar.getTimeInMillis());
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		dto.setUserName(memberDTO.getUserName());
		
		return dao.setAdd(dto);
	}
	
	public List<ProductDTO> getList(AccountDTO dto) throws Exception{
		dto.getPager().makeRow();
		Integer totalCount = dao.getTotalCount(dto);
		
		Integer totalPage = 0;
		totalPage = totalCount/dto.getPager().getPager();
		if(totalCount%dto.getPager().getPager() >0 ) totalPage++;
		dto.getPager().setTotalPage(totalPage);
		
		dto.getPager().setPerBlock(5);
		Integer totalBlock = totalPage / dto.getPager().getPerBlock();
		if(totalPage%dto.getPager().getPerBlock() >0) totalBlock++;
		dto.getPager().setTotalBlock(totalBlock);
		
		Integer curBlock = dto.getPager().getPage() / dto.getPager().getPerBlock();
		if(dto.getPager().getPage()%dto.getPager().getPerBlock() != 0 )curBlock++;
		System.out.println(curBlock);
	
		
		Integer lastNum = curBlock * dto.getPager().getPerBlock();
		Integer startNum = lastNum-dto.getPager().getPerBlock() +1;
		if(lastNum > dto.getPager().getTotalPage()) lastNum = dto.getPager().getTotalPage();
		System.out.println(startNum);
		System.out.println(lastNum);
		dto.getPager().setStart_page(startNum);
		dto.getPager().setLast_page(lastNum);
		
		return dao.getList(dto);
		
	}
	
}
