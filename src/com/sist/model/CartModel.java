package com.sist.model;

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
	
	request.setAttribute("wlist", wlist );
	request.setAttribute("clist", clist );;
	request.setAttribute("menu", "work");
	request.setAttribute("main_jsp", "../cart/cart.jsp");
	return "../main/main.jsp";
	}

}