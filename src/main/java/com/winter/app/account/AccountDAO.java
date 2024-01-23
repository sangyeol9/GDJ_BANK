package com.winter.app.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.product.ProductDTO;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.winter.app.account.AccountDAO.";
	
	public int setAdd(AccountDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setAdd",dto);
	}
	
	public int getTotalCount (AccountDTO dto) throws Exception{
		return sqlSession.selectOne(namespace+"getTotalCount",dto);
		
	}
	
	public List<ProductDTO> getList(AccountDTO dto) throws Exception{
		return sqlSession.selectList(namespace+"getList",dto);
		
	}
}
