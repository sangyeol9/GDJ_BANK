package com.winter.app.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.notice.NoticeDAO;
import com.winter.app.board.qna.QnaDAO;
import com.winter.app.member.MemberDTO;

@Component
public class WritterCheck extends HandlerInterceptorAdapter {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getRequestURI();
		path.substring(0, path.lastIndexOf("/"));
		long n=Long.valueOf(request.getParameter("notice_Num"));
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNotice_Num(n);
		if(path.equals("/qna")) {
			boardDTO=qnaDAO.getDetail(boardDTO);
		}else {
			boardDTO=noticeDAO.getDetail(boardDTO);
		}
		MemberDTO memberDTO =(MemberDTO)request.getSession().getAttribute("member");
		if(boardDTO.getNotice_Writter().equals(memberDTO.getUserName()))
		return true;
		else {
			request.setAttribute("path", "./list");
			request.setAttribute("msg", "작성자만 가능하다");
			RequestDispatcher v = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			v.forward(request, response);
			return false;
		}
		
	}
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {	
//		String method = request.getMethod();
//		Map<String, Object> map =  modelAndView.getModel();
////		Iterator<String> it = map.keySet().iterator();
////		while(it.hasNext()) {
////			String k = it.next();
////			System.out.println(k);
////			System.out.println(map.get(k));
////		}
//		if(method.toUpperCase().equals("POST")) {
//			return ;
//		}
//		//작성자
//		BoardDTO boardDTO =(BoardDTO) map.get("dto");
//		
//		//로그인
//		HttpSession session =  request.getSession();
//		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
//		
//		if(!boardDTO.getNotice_Writter().equals(memberDTO.getUserName())) {
//			modelAndView.addObject("msg", "작성자 본인만 가능합니다");
//			modelAndView.addObject("path", "./list");
//			modelAndView.setViewName("commons/result");
//		}
//			
//		System.out.println( modelAndView.getViewName() );
//	}
	
}
