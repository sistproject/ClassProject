package com.sist.model;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ClassDAO;
@Controller
public class MainModel {
	@RequestMapping("main/main.do")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		String name = "";
		
		ClassDAO dao = ClassDAO.newInstance();
		List<String> catList = dao.getCategory();
		int catCount = dao.getCategoryCount();
		request.setAttribute("catList", catList);
		request.setAttribute("catCount", catCount);
		request.setAttribute("name", name);
		request.setAttribute("main_jsp", "../main/home.jsp");
		request.setAttribute("menu", "work");
		return "../main/main.jsp";
	}
	
	@RequestMapping("main/cmain.do")
	public String classPage(HttpServletRequest request,HttpServletResponse response) {
		String name = "";
		
		ClassDAO dao = ClassDAO.newInstance();
		List<String> catList = dao.getCategory();
		int catCount = dao.getCategoryCount();
		request.setAttribute("catList", catList);
		request.setAttribute("catCount", catCount);
		request.setAttribute("name", name);
		request.setAttribute("main_jsp", "../main/home.jsp");
		request.setAttribute("menu", "class");
		return "../main/main.jsp";
	}


}