package com.sist.model;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.WorkDAO;
import com.sist.vo.WorkDetailVO;
import com.sist.vo.WorkVO;

@Controller
public class WorkModel {
	@RequestMapping("work/work_list.do")
	public String work_list(HttpServletRequest request, HttpServletResponse response)
	{
		
		try{
			String page=request.getParameter("page");
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		WorkDAO dao=new WorkDAO();
		List<WorkDetailVO> rList=dao.WorkListData(curpage);
		int count=dao.WorkMainCount();
		int totalpage=(int)(Math.ceil(count/12.0));
		System.out.println(rList.get(0)+"============================il========================");
		final int BLOCK=10;
		int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endpage>totalpage)
			endpage=totalpage;
		System.out.println("================================list");
		
		request.setAttribute("count", count);
		request.setAttribute("rList", rList);
		request.setAttribute("block", BLOCK);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("main_jsp", "../work/work_list.jsp");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "../work/work_list.jsp";
	}
	@RequestMapping("work/work_detail_before.do")
	  public String detail_before(HttpServletRequest request,HttpServletResponse response)
	  {
		
		  String w_no=request.getParameter("w_no");
		 
		  
		  Cookie cookie=new Cookie("m"+w_no, w_no);// 문자열만 저장이 가능 
		  cookie.setMaxAge(60*60);
		  cookie.setPath("/");
		  response.addCookie(cookie);
		
		  return "redirect:../work/work_detail.do?w_no="+w_no;
	  }
	@RequestMapping("work/work_detail.do")
	public String work_detail(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
		System.out.println("============================================detail");
		String w_no=request.getParameter("w_no");
		WorkDAO dao=new WorkDAO();
		System.out.println("==============================6888==============detail");
		WorkDetailVO vo=dao.WorkDetailData(Integer.parseInt(w_no));
		System.out.println("==============================6666==============detail");
		request.setAttribute("vo", vo);
		System.out.println("============================777==============detail");
		request.setAttribute("main_jsp", "../work/work_detail.jsp");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "../main/main.jsp";
	}

}
