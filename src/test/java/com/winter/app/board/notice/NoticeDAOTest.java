package com.winter.app.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.board.BoardDTO;
import com.winter.app.util.Paser;

public class NoticeDAOTest extends MyTest {

	@Autowired
	private NoticeDAO dao;
	
	@Test
	public void getListTest() throws Exception {
		Paser pager = new Paser();
		pager.makeRow();
		List<BoardDTO> ar= dao.getList(pager);
		assertNotEquals(0, ar.size());
	}

}
