package com.sist.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.CartDAO;
import com.sist.vo.CartVO;

@Controller
public class CartModel {
	@RequestMapping("cart/cart.do")
	public String login(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session = request.getSession();
	
	String id = (String)session.getAttribute("id");
	CartDAO dao = CartDAO.newInstance();
	List<CartVO> wlist = dao.workList(id);
	List<CartVO> clist = dao.classList(id);
	
	int total = 0;
	for(CartVO vo:wlist) {
		total+=(Integer.parseInt(vo.getPrice()))*vo.getQuantity();
	}
	for(CartVO vo:clist) {
		total+=(Integer.parseInt(vo.getPrice()))*vo.getQuantity();
	}
	int cnt = wlist.size() + clist.size();
	
	request.setAttribute("wlist", wlist );
	request.setAttribute("clist", clist );
	request.setAttribute("total", total );
	request.setAttribute("cnt", cnt);
	request.setAttribute("main_jsp", "../cart/cart.jsp");
	return "../main/main.jsp";
	}
	@RequestMapping("cart/addcart.do")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String no = request.getParameter("no");
		String type = request.getParameter("type");
		String amount = request.getParameter("amount");
		CartDAO dao = CartDAO.newInstance();
		dao.cartInsert(Integer.parseInt(no), id, type, Integer.parseInt(amount));
		
		return "../cart/cart.do";
	}
	@RequestMapping("cart/cart_remove.do")
	public String cartRemove(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		CartDAO dao = CartDAO.newInstance();
		String cno = request.getParameter("cno");
		String wno = request.getParameter("wno");
		if(cno==null) {
			dao.cartWnoRemove(Integer.parseInt(wno), id);
		}else {
			dao.cartCnoRemove(Integer.parseInt(cno), id);
		}
		
		return "redirect:../cart/cart.do";
	}
	@RequestMapping("cart/cart_checkout.do")
	public String cartChecked(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		CartDAO dao = CartDAO.newInstance();
		List<CartVO> wlist = dao.workList(id);
		List<CartVO> clist = dao.classList(id);
		
		List<Integer> wCheck = new ArrayList<Integer>();
		List<Integer> cCheck = new ArrayList<Integer>();
		for(CartVO vo:wlist) {
			System.out.println("wno: "+vo.getNo());
			wCheck.add(vo.getNo());
		}
		for(CartVO vo:clist) {
			System.out.println("cno: "+vo.getNo());
			cCheck.add(vo.getNo());
		}
		dao.cartClassCheckout(id, cCheck, wCheck);
		// crno 	id 		cno 	wno 	ono
		//    1    admin	23		null	1
		//    2    admin	23		null	1
		//    3    jun	    null	30		null
		//    4    admin	23		null	null
		//    5    jun      null	48 		null

		return "redirect:../cart/cart.do";
	}


}