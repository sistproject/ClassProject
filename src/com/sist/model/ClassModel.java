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

}
