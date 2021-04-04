package com.sist.model;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.CartDAO;
import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;


@Controller
public class MemberModel {
	
	@RequestMapping("member/login.do")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		return "../member/login.jsp";
	}
	@RequestMapping("member/logout.do")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		return "../member/logout_ok.jsp";
	}
	@RequestMapping("member/signin.do")
	public String signin(HttpServletRequest request,HttpServletResponse response) {
		return "../member/signin.jsp";
	}
	@RequestMapping("member/member_detail.do")
	public String memberDetail(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		MemberDAO dao = MemberDAO.newInstance();
		MemberVO vo = dao.memberDetailData(id);
		request.setAttribute("vo",vo);
		request.setAttribute("main_jsp", "../member/member_detail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("member/idcheck.do")
	public String idcheck(HttpServletRequest request,HttpServletResponse response) {
		String id=request.getParameter("id");
		MemberDAO dao = MemberDAO.newInstance();
		int count = dao.idCheck(id);
		request.setAttribute("count",count);
		return "../member/idcheck.jsp";
	}
	@RequestMapping("member/signin_ok.do")
	public String joinOk(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		
		String name=request.getParameter("username");
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		System.out.println(id);
		System.out.println(email);
		MemberDAO dao = MemberDAO.newInstance();
		dao.insertMember(name, id, pwd, email);
		
		return "redirect:../member/login.jsp";
	}
	@RequestMapping("member/login_ok.do")
	public String loginOk(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.newInstance();
		String result = dao.isLogin(id, pwd);
		
		request.setAttribute("result",result);
		return "../member/login_ok.jsp";
	}
}
