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
	
//	String id = (String)session.getAttribute("id");
//	System.out.println(id);
//	String id="admin";
//	CartDAO dao = CartDAO.newInstance();
//	List<CartVO> wlist = dao.workList(id);
//	List<CartVO> clist = dao.classList(id);
//	
//	request.setAttribute("wlist", wlist );
//	request.setAttribute("clist", clist );;
	
	return "../cart/cart.jsp";
	}

}