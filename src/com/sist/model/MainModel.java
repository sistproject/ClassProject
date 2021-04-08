package com.sist.model;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ClassDAO;
import com.sist.dao.OnlineDAO;
import com.sist.vo.OnlineVO;
@Controller
public class MainModel {
	@RequestMapping("main/main.do")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		String name = "";
		
		ClassDAO dao = ClassDAO.newInstance();
		List<String> catList = dao.getCategory();
		int catCount = dao.getCategoryCount();
		
		// 쿠키
		OnlineDAO Cdao = OnlineDAO.newInstance();
		  List<OnlineVO> kList=new ArrayList<OnlineVO>();
				  
				  Cookie[] cookies=request.getCookies();			
				  if(cookies != null)
				  {
					  for(int i=cookies.length-1;i>=0;i--)
					  {
						  if(cookies[i].getName().startsWith("oc") ||cookies[i].getName().startsWith("wc") ) // oc: online cookie, wc: work cookie
						  { 	
							  cookies[i].setPath("/");
							  System.out.println(cookies[i].getName()); // key
							  String cno=cookies[i].getValue(); // value
							  System.out.println(cookies[i].getValue());
							  OnlineVO vo=Cdao.onlineCookiePrintData(Integer.parseInt(cno));
							  System.out.println(vo.getCno());
							  kList.add(vo);
							  
			
						  }
					  }
				  }
		 
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