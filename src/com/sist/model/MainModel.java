package com.sist.model;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ClassDAO;
import com.sist.dao.WorkDAO;
import com.sist.vo.WorkDetailVO;
import com.sist.vo.WorkVO;
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
	@RequestMapping("main/main.do")
	public String main_home(HttpServletRequest request,HttpServletResponse response) {
		
        // 쿠키
		List<WorkDetailVO> fList=new ArrayList<WorkDetailVO>();
		System.out.println("=================rr=========");
		WorkDAO dao=new WorkDAO();
		Cookie[] cookies=request.getCookies();			
		  if(cookies != null)
		  {
			  for(int i=cookies.length-1;i>=0;i--)
			  {
				  System.out.println("쿠키 포문");
				  if(cookies[i].getName().startsWith("m"))
				  { 	
					  System.out.println("쿠키 조건문");
					  cookies[i].setPath("/");
					  System.out.println(cookies[i].getName()); // key
					  String w_no=cookies[i].getValue(); // value
					  System.out.println(cookies[i].getValue());
					  WorkDetailVO vo=dao.WorkCookiePrintData(Integer.parseInt(w_no));
					  System.out.println(vo.getW_no());
					  fList.add(vo);
					  
	
				  }
			  }
		  }
		request.setAttribute("fList", fList);
		System.out.println("============tt=====rr=========");
		//String w_no=request.getParameter("w_no");
		List<WorkVO> wList=dao.WorkMainData();
		request.setAttribute("wList", wList);
		//request.setAttribute("menu", "work");
		request.setAttribute("main_jsp", "../main/home.jsp");

		return "../main/main.jsp";

	}





}