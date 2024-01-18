package com.winter.app.member;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	String namespace = "com.winter.app.member.MemberDAO.";
	
	public int setJoin(MemberDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setJoin",dto);
	}
	
	public int setFileJoin (MemberFileDTO attach ) throws Exception{
		return sqlSession.insert(namespace+"setFileJoin",attach);
	}
	
	public MemberDTO getDetail(MemberDTO dto) throws Exception {
		return sqlSession.selectOne(namespace+"getDetail",dto);
	}
	
}
