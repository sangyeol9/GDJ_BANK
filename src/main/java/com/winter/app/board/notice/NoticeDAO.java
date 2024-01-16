package com.winter.app.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.util.Paser;


@Repository("na")
public class NoticeDAO implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.winter.app.board.notice.NoticeDAO.";
	
	@Override
	public Long getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> getList(Paser pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getList",pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getDetail",dto);
	}

	@Override
	public int setAdd(BoardDTO dto) throws Exception {
	
		return sqlSession.insert(namespace+"setAdd",dto);
	}

	@Override
	public int setUpdate(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"setDelete",dto);
	}

	public int setFileAdd(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(namespace+"setFileAdd",boardFileDTO);
	}
	
}
