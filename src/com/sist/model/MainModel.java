package com.sist.model;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ClassDAO;
import com.sist.dao.OffClassDAO;
import com.sist.dao.OnlineDAO;
import com.sist.dao.WorkDAO;
import com.sist.vo.OffClassVO;
import com.sist.vo.OnlineVO;
import com.sist.vo.WorkDetailVO;
import com.sist.vo.WorkVO;
@Controller
public class MainModel {
	@RequestMapping("main/main.do")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("rooooooooooooooooooooooooooooooooooooooo");
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
						  if(cookies[i].getName().startsWith("oc")) // oc: online cookie
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
				  try
					{
			        // 쿠키
					List<WorkDetailVO> fList=new ArrayList<WorkDetailVO>();
					System.out.println("=================rr=========");
					WorkDAO wdao=new WorkDAO();
					Cookie[] wcookies=request.getCookies();			
					  if(wcookies != null)
					  {
						  for(int i=wcookies.length-1;i>=0;i--)
						  {
							  System.out.println("쿠키 포문");
							  if(wcookies[i].getName().startsWith("wc"))
							  { 	
								  System.out.println("쿠키 조건문");
								  wcookies[i].setPath("/");
								  System.out.println(wcookies[i].getName()); // key
								  String w_no=wcookies[i].getValue(); // value
								  System.out.println(wcookies[i].getValue());
								  WorkDetailVO vo=wdao.WorkCookiePrintData(Integer.parseInt(w_no));
								  System.out.println(vo.getW_no());
								  fList.add(vo);
								  
				
							  }
						  }
					  }
					
					request.setAttribute("fList", fList);
					System.out.println("============tt=====rr=========");
					//String w_no=request.getParameter("w_no");
					List<WorkVO> wList=wdao.WorkMainData();
					request.setAttribute("wList", wList);
					//request.setAttribute("menu", "work");
					request.setAttribute("main_jsp", "../main/home.jsp");
					}catch(Exception ex)
					{
						 
					}
		
		request.setAttribute("catList", catList);
		request.setAttribute("catCount", catCount);
		request.setAttribute("name", name);
		request.setAttribute("main_jsp", "../main/home.jsp");
		request.setAttribute("menu", "work");
		return "../main/main.jsp";
	}
	
	@RequestMapping("main/cmain.do")
	public String classmainPage(HttpServletRequest request,HttpServletResponse response) {
		OffClassDAO dao = OffClassDAO.newInstance();
		List<OffClassVO> offList = dao.OffClassData(1);
		System.out.println(offList);
		
		OnlineDAO cdao= OnlineDAO.newInstance();
		List<OnlineVO> onList = cdao.onlineData(1);
		System.out.println(onList);
		
		request.setAttribute("offList", offList);
		request.setAttribute("onList", onList);
		System.out.println("!!!!!!! dhffk !!!!");
		request.setAttribute("main_jsp", "../main/mainclass.jsp");
		request.setAttribute("menu", "class");
		return "../main/main.jsp";
	}
	@RequestMapping("main/search.do")
	public String wsearch(HttpServletRequest request,HttpServletResponse response) {
		String word = request.getParameter("search");
		ClassDAO dao = ClassDAO.newInstance();
		List<String> catList = dao.getCategory();
		int catCount = dao.getCategoryCount();
		WorkDAO wdao=new WorkDAO();
		// 쿠키
		OnlineDAO Cdao = OnlineDAO.newInstance();
		  List<OnlineVO> kList=new ArrayList<OnlineVO>();
		
				  Cookie[] cookies=request.getCookies();			
				  if(cookies != null)
				  {
					  for(int i=cookies.length-1;i>=0;i--)
					  {
						  if(cookies[i].getName().startsWith("oc")) // oc: online cookie
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
				  try
					{
			        // 쿠키
					List<WorkDetailVO> fList=new ArrayList<WorkDetailVO>();
					System.out.println("=================rr=========");
					
					Cookie[] wcookies=request.getCookies();			
					  if(wcookies != null)
					  {
						  for(int i=wcookies.length-1;i>=0;i--)
						  {
							  System.out.println("쿠키 포문");
							  if(wcookies[i].getName().startsWith("wc"))
							  { 	
								  System.out.println("쿠키 조건문");
								  wcookies[i].setPath("/");
								  System.out.println(wcookies[i].getName()); // key
								  String w_no=wcookies[i].getValue(); // value
								  System.out.println(wcookies[i].getValue());
								  WorkDetailVO vo=wdao.WorkCookiePrintData(Integer.parseInt(w_no));
								  System.out.println(vo.getW_no());
								  fList.add(vo);
								  
				
							  }
						  }
					  }
					
					request.setAttribute("fList", fList);
					}catch(Exception ex){}
				  
		List<WorkVO> wList=wdao.workSearchData(word);
		
		  
	    OffClassDAO ofdao = OffClassDAO.newInstance();
		List<OffClassVO> offList = ofdao.OffMainSearchData(word);
		
		OnlineDAO cdao= OnlineDAO.newInstance();
		List<OnlineVO> onList = cdao.onlineMainSearchData(word);
		
		
		request.setAttribute("offList", offList);
		request.setAttribute("onList", onList);
		request.setAttribute("wList", wList);
		request.setAttribute("catList", catList);
		request.setAttribute("catCount", catCount);
		request.setAttribute("main_jsp", "../main/wsearch.jsp");
		request.setAttribute("menu", "work");
		return "../main/main.jsp";
	}





}