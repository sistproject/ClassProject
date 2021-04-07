package com.sist.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.BoardDAO;
import com.sist.dao.CartDAO;
import com.sist.vo.BoardVO;

@Controller
public class BoardModel {
	@RequestMapping("board/freeboard.do")
	public String freeboard(HttpServletRequest request,HttpServletResponse response) {
	    String strPage=request.getParameter("page");
	    if(strPage==null)
	    	strPage="1";
	    int curpage=Integer.parseInt(strPage);
	    BoardDAO dao=new BoardDAO();
	    List<BoardVO> list=dao.freeboardList();

		request.setAttribute("list", list );
		request.setAttribute("main_jsp", "../board/freeboard.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/qaboard.do")
	public String QAboard(HttpServletRequest request,HttpServletResponse response) {
		    BoardDAO dao=new BoardDAO();
		    List<BoardVO> list=dao.qaBoardList();  

		request.setAttribute("list", list );
		request.setAttribute("main_jsp", "../board/qaboard.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/freedetail.do")
	public String freeboarddetail(HttpServletRequest request,HttpServletResponse response) {
		
		String no = request.getParameter("no");
		BoardDAO dao = BoardDAO.newInstance();
		dao.hit(Integer.parseInt(no));
		List<BoardVO> list = dao.freeboardList();
		BoardVO vo = new BoardVO();
		for(BoardVO bvo:list) {
			if(bvo.getBno() == Integer.parseInt(no)) vo=bvo;
		}
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board/freedetail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/qadetail.do")
	public String qaboarddetail(HttpServletRequest request,HttpServletResponse response) {
		String no = request.getParameter("no");
		BoardDAO dao = BoardDAO.newInstance();
		dao.hit(Integer.parseInt(no));
		List<BoardVO> list = dao.qaBoardList();
		BoardVO vo = new BoardVO();
		for(BoardVO bvo:list) {
			if(bvo.getBno() == Integer.parseInt(no)) vo=bvo;
		}
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board/qadetail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/delete.do")
	public String delete(HttpServletRequest request,HttpServletResponse response) {
		String no = request.getParameter("no");
		String type = request.getParameter("type");
		BoardDAO dao = BoardDAO.newInstance();
		dao.boardDelete(Integer.parseInt(no));
		if(type.equals("0")) return "redirect:../board/qaboard.do";
		return "redirect:../board/freeboard.do";
	}
	@RequestMapping("board/insert.do")
	public String insert(HttpServletRequest request,HttpServletResponse response) {
		
		//boad/insert.do?type=0&cno=?
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String type = request.getParameter("type");
		String wno = request.getParameter("wno");
		String cno = request.getParameter("cno");
		String title = "";
		try {
			BoardDAO dao = BoardDAO.newInstance();
			title = dao.additional(Integer.parseInt(wno), "w");
		if(cno!=null) title=dao.additional(Integer.parseInt(cno), "c");
		}catch (Exception e) {}
		request.setAttribute("id", id);
		request.setAttribute("type", type);
		request.setAttribute("add", title);
		request.setAttribute("wno", wno);
		request.setAttribute("cno", cno);
		request.setAttribute("main_jsp", "../board/insert.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/insert_ok.do")
	public String insertOk(HttpServletRequest request,HttpServletResponse response) {
		BoardDAO dao = BoardDAO.newInstance();
		try{
			request.setCharacterEncoding("UTF-8");
		} catch(Exception e){}

		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String type=request.getParameter("type");
		String addc=request.getParameter("cno");
		String addw=request.getParameter("wno");
		
		BoardVO vo = new BoardVO();
		if(type.equals("0")) {
			vo.setId(id);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setIsFree(0);
			if(addc!=null) {
				vo.setCno(Integer.parseInt(addc));
				vo.setType("c");
			}
			if(addw!=null) {
				vo.setWno(Integer.parseInt(addw));
				vo.setType("w");
			}
			dao.boardInsert(vo);
			return "redirect:../board/qaboard.do";
		}
		
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setIsFree(1);
		dao.boardInsert(vo);
		
		return "redirect:../board/freeboard.do";
	}

	@RequestMapping("board/update.do")
	public String boardupdate(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String type = request.getParameter("type");
		String no = request.getParameter("no");
		
		BoardDAO dao = BoardDAO.newInstance();
		List<BoardVO> list = dao.freeboardList();
		System.out.println(type);
		System.out.println(type.equals("0"));
		if(type.equals("0")) {
			list = dao.qaBoardList();
		}
		BoardVO vo = new BoardVO();
		for(BoardVO bvo:list) {
			if(bvo.getBno() == Integer.parseInt(no)) vo=bvo;
		}
		
		request.setAttribute("vo", vo);
		request.setAttribute("id", id);
		request.setAttribute("type", type);
		
		request.setAttribute("main_jsp", "../board/update.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/update_ok.do")
	public String updateOk(HttpServletRequest request,HttpServletResponse response) {
		BoardDAO dao = BoardDAO.newInstance();
		try{
			request.setCharacterEncoding("UTF-8");
		} catch(Exception e){}

		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String type=request.getParameter("type");
		String no=request.getParameter("no");
		
		BoardVO vo = new BoardVO();
		vo.setBno(Integer.parseInt(no));
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		dao.boardUpdate(vo);
		if(type.equals("0")) return "redirect:../board/qadetail.do?no="+no;
		return "redirect:../board/freedetail.do?no="+no;
		
	}
}
