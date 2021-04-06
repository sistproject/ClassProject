package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.WorkDAO;
import com.sist.vo.WorkVO;
@Controller
public class MainModel {
//	@RequestMapping("main/main.do")
//	public String login(HttpServletRequest request,HttpServletResponse response) {
//		String name = "";
//		request.setAttribute("name", name);
//		request.setAttribute("main_jsp", "../main/home.jsp");
//		request.setAttribute("menu", "work");
//		return "../main/main.jsp";
//	}
//	
	@RequestMapping("main/cmain.do")
	public String classPage(HttpServletRequest request,HttpServletResponse response) {
		String name = "";
		request.setAttribute("name", name);
		request.setAttribute("main_jsp", "../main/home.jsp");
		request.setAttribute("menu", "class");
		return "../main/main.jsp";
	}
	@RequestMapping("main/main.do")
	public String main_home(HttpServletRequest request,HttpServletResponse response) {

		System.out.println("==========================");
		WorkDAO dao=WorkDAO.newInstance();
		//String w_no=request.getParameter("w_no");
		List<WorkVO> wList=dao.WorkMainData();
		
		request.setAttribute("wList", wList);
		request.setAttribute("menu", "work");
		request.setAttribute("main_jsp", "../main/home.jsp");

		return "../main/main.jsp";

	}


}
