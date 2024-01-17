package com.winter.app.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.util.Paser;

@Repository("ba")
public class QnaDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.winter.app.board.qna.QnaDAO.";
	
	@Override
	public List<BoardDTO> getList(Paser pager) throws Exception {
		return sqlSession.selectList(namespace+"getList",pager);
	}
	@Override
	public BoardDTO getDetail(BoardDTO dto) throws Exception {
		return sqlSession.selectOne(namespace+"getDetail",dto);
	}
	@Override
	public int setAdd(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"setAdd",dto);
	}
	@Override
	public int setUpdate(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"setUpdate",dto);
	}
	
	@Override
	public Integer getTotalCount( ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int setDelete(BoardDTO dto) throws Exception {
		
		return sqlSession.update(namespace+"setDelete",dto);
	}
	
	public int setFileDelete(BoardDTO dto) throws Exception {
		return sqlSession.delete(namespace+"setFileDelete",dto);
	}
	
	public List<BoardFileDTO> getFileList(BoardDTO dto) throws Exception{
		return sqlSession.selectList(namespace+"getFileList",dto);
	}
	
	public int setReplyUpdate(QnaDTO dto) throws Exception{
		return sqlSession.update(namespace+"setReplyUpdate",dto);
		
	}
	
	public int setReplyAdd(QnaDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setReplyAdd",dto);
	}
	
	public int setReplyFileAdd(BoardFileDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setReplyFileAdd",dto);
	}
	
	public int setFileAdd(BoardFileDTO dto) throws Exception{
		return sqlSession.insert(namespace+"setFileAdd",dto);
	}
	
}
