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
	@RequestMapping("class/class_list.do")
	public String class_list(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("cno");
		// DAO
		OffClassDAO dao=OffClassDAO.newInstance();
		List<OffClassVO> list=dao.classListData(Integer.parseInt(no));

		return "../offclass/offclass.jsp";
	}
	
	@RequestMapping("class/class_detail.do")
	public String class_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("cno");
		// DAO
		OffClassDAO dao=OffClassDAO.newInstance();
		OffClassVO vo=dao.ClassDetailData(Integer.parseInt(no));
		
		return "../offclass/offclass.jsp";
	}
}
