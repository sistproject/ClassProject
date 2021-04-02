package com.sist.model;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.MemberDAO;


@Controller
public class MemberModel {
  @RequestMapping("member/idcheck.do")
  public String idcheck(HttpServletRequest request,HttpServletResponse response) {
	  String id=request.getParameter("id");
	  MemberDAO dao = MemberDAO.newInstance();
	  int count = dao.idCheck(id);
	  request.setAttribute("count",count);
	  return "../member/idcheck.jsp";
  }
}