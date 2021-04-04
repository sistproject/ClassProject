package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.OffClassDAO;
import com.sist.vo.OffClassVO;

@Controller
public class OffClassModel {
	@RequestMapping("offclass/offclass.do")
	public String class_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		OffClassDAO dao= OffClassDAO.newInstance();
		List<OffClassVO> ofList=dao.classListData(curpage);
		int count=dao.OffClassCount();
		int totalPage=(int)(Math.ceil(count/12.0));
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;

		
		if(endPage>totalPage)
			endPage=totalPage; 
		
		request.setAttribute("count", count);
		request.setAttribute("ofList", ofList);
		
		request.setAttribute("block", BLOCK);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("totalPage", totalPage);
	    request.setAttribute("curpage", curpage);
	    request.setAttribute("main_jsp", "../offclass/offclass.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("offclass/offclass_detail.do")
	public String class_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String cno=request.getParameter("cno");
		// DAO
		OffClassDAO dao=OffClassDAO.newInstance();
		List<OffClassVO> ofdList=dao.classListData(Integer.parseInt(cno));
		request.setAttribute("ofdList", ofdList);
		request.setAttribute("main_jsp", "../offclass/offclass_detail.jsp");
		
		return "../main/main.jsp";
	}
}
