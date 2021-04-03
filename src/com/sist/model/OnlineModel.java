package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;


@Controller
public class OnlineModel {
	@RequestMapping("online/online.do")
	public String online(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "../online/online.jsp";
	}
}
