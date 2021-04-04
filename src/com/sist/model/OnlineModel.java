package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.CartDAO;
import com.sist.dao.OnlineDAO;
import com.sist.vo.OnlineVO;

@Controller
public class OnlineModel {
	@RequestMapping("online/online.do")
	public String online(HttpServletRequest request, HttpServletResponse response) {

		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);

		OnlineDAO dao = OnlineDAO.newInstance();
		List<OnlineVO> omList = dao.onlineData(curpage);
		int count = dao.onlineMainCount();
		int totalPage = (int) (Math.ceil(count / 12.0));

		final int BLOCK = 10;
		// 102 [1]-[10] [91]~[100] [101][102]
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		// 1~10 => 1 10-1/10 => 0 9/10
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

		if (endPage > totalPage)
			endPage = totalPage;

		request.setAttribute("count", count);
		request.setAttribute("omList", omList);

		request.setAttribute("block", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalpage", totalPage);
		request.setAttribute("curpage", curpage);
//	    request.setAttribute("main_jsp", "../online/online.jsp");

		return "../online/online.jsp";
	}

	@RequestMapping("online/online_detail.do")
	public String online_detail(HttpServletRequest request, HttpServletResponse response) {
		String cno = request.getParameter("cno");
		
		
		
		
		
		
		return "../online/online_detail.jsp";

	}
}
