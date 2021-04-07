package com.sist.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.CartDAO;
import com.sist.dao.MemberDAO;
import com.sist.vo.CartVO;
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
	@RequestMapping("member/member_order.do")
	public String memberOrder(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		// 주문내용 전체 최신순
		//select cno,wno from cart where id=id and ono!=0 order by ono desc
		CartDAO dao = CartDAO.newInstance();
		List<CartVO> list = new ArrayList<CartVO>();
		List<CartVO> wlist = dao.workOrder(id);
		List<CartVO> clist = dao.classOrder(id);
		try {
			for(CartVO vo:wlist) {
			list.add(vo);
			}
			for(CartVO vo:clist) {
				list.add(vo);
			}
			int wmax = wlist.get(0).getOno();
			int cmax = clist.get(0).getOno();
			int newest = cmax;
			if (wmax>cmax) newest=wmax;
			System.out.println(newest);
			for(CartVO vo:list) {
				System.out.println(vo.getTitle());
				System.out.println(vo.getPoster());
			}
			request.setAttribute("newest", newest);
		}catch (Exception e) {}
		
		
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../member/order.jsp");
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
		MemberDAO dao = MemberDAO.newInstance();
		dao.insertMember(name, id, pwd, email);
		
		return "redirect:../member/login.jsp";
	}
	@RequestMapping("member/login_ok.do")
	public String loginOk(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		return "../member/login_ok.jsp";
	}
	@RequestMapping("member/member_update.do")
	public String member_update(HttpServletRequest request,HttpServletResponse response) throws ParseException {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		
		MemberDAO dao = MemberDAO.newInstance();
		MemberVO vo = new MemberVO();
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		
		String post=request.getParameter("post");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		
		String tel1=request.getParameter("tel1");
		String tel2=request.getParameter("tel2");
		String tel3=request.getParameter("tel3");
		
		//private String name,id,email,tel,post,addr,sex,pwd;
		//private Date birth;
		
		vo.setName(name);
		vo.setId(id);
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setSex(sex);
		vo.setBirth(birth);
		vo.setPost(post);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setTel(tel1+tel2+tel3);
		

		dao.memberUpdateData(vo);
		
		return "redirect: ../member/member_detail.do";
	}
	@RequestMapping("member/jjim.do")
	public String jjim(HttpServletRequest request,HttpServletResponse response) {

		String no=request.getParameter("no");
		String type=request.getParameter("type");  //w(work), cn(classonline), cf(classoffline)
	 	HttpSession session=request.getSession();
	 	String id=(String)session.getAttribute("id");
	 	System.out.println(no);
	 	System.out.println(type);
		MemberDAO dao = MemberDAO.newInstance();
		dao.jjim(id, Integer.parseInt(no), type);
		if(type.equals("w")) return "redirect:../work/work_detail.do?w_no="+no;
		else if(type.equals("cn")) return "redirect:../online/online_detail.do?cno="+no;
		return "redirect:../offclass/offclass_detail.do?cno="+no;
	}
	
}
