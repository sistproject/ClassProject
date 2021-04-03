package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class CartModel {
@RequestMapping("cart/cart.do")

	public String login(HttpServletRequest request, HttpServletResponse response) {
	
	String id = request.getParameter("id");
	
//	request.setAttribute("id", );
	return "../cart/cart.jsp";
	}

}
