package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.CartDAO;
import com.sist.dao.OnlineDAO;
import com.sist.vo.OnlineVO;


@Controller
public class OnlineModel {
	@RequestMapping("online/online.do")
	public String online(HttpServletRequest request, HttpServletResponse response) {
		
//		String index = request.getParameter("index");
		OnlineDAO dao = OnlineDAO.newInstance();
		String index = "1";
		List<OnlineVO> omList = dao.onlineData(Integer.parseInt(index));
		request.setAttribute("omList", omList);
		return "../online/online.jsp";
	}
}
