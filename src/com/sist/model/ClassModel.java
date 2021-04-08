package com.sist.model;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ClassDAO;
import com.sist.vo.MemberVO;
import com.sist.vo.OffClassVO;


@Controller
public class ClassModel {
	@RequestMapping("class/trendclass.do")
	public String trendList(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		// DAO
		ClassDAO dao = ClassDAO.newInstance();
		List<OffClassVO> allList = dao.trendListData(curpage);
		int count = dao.allCount();
		int totalPage = (int)(Math.ceil(count / 12.0));
		
		final int BLOCK = 10;
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

		if (endPage > totalPage) {
			endPage = totalPage;
		}
			
		request.setAttribute("count", count);
		request.setAttribute("allList", allList); // online main List

		request.setAttribute("block", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalpage", totalPage);
		request.setAttribute("curpage", curpage);
		
		//request.setAttribute("main_jsp", "../class/trendclass.jsp");
		request.setAttribute("menu", "class");
		return "../class/trendclass.jsp";
	}
	@RequestMapping("class/writeWC_ok.do")
	public String write_ok(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		String type = request.getParameter("type_list");
		String artist = request.getParameter("artist");
		String address = "";
		if(type=="3") {
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			address = addr1+" "+addr2;
		}
		String category = request.getParameter("category_list");
		String poster = request.getParameter("poster");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String time = request.getParameter("time");
		String price = request.getParameter("price");
		
		request.setAttribute("main_jsp", "../main/home.jsp");
		request.setAttribute("menu", "class");
		return "../main/main.jsp";
	}
	@RequestMapping("class/writeWC.do")
	public String writeForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		System.out.println(id);
		if(id==null) {
			request.setAttribute("main_jsp", "../main/home.jsp");
			return "../main/main.jsp";
		}
		ClassDAO dao = ClassDAO.newInstance();
		MemberVO mvo = dao.getWriterInfo(id);
		
		request.setAttribute("mvo", mvo);
		request.setAttribute("main_jsp", "../class/writeWC.jsp");
		request.setAttribute("menu", "class");
		return "../main/main.jsp";
	}

}
