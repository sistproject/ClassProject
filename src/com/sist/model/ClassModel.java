package com.sist.model;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ClassDAO;
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
	@RequestMapping("class/write.do")
	public String writeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		
		System.out.println(request.getParameter("artist"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("type_list"));
		System.out.println(request.getParameter("category_list"));
		System.out.println(request.getParameter("poster"));
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("content"));
		System.out.println(request.getParameter("time"));
		System.out.println(request.getParameter("price"));
		request.setAttribute("main_jsp", "../main/home.jsp");
		request.setAttribute("menu", "class");
		return "../main/main.jsp";
	}

}
