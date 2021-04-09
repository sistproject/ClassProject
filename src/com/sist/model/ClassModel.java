package com.sist.model;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ClassDAO;
import com.sist.vo.MemberVO;
import com.sist.vo.OffClassVO;
import com.sist.vo.OnlineVO;
import com.sist.vo.WorkDetailVO;
import com.sist.vo.WorkVO;


@Controller
public class ClassModel {
	@RequestMapping("class/trendclass.do")
	public String trendList(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		// DAO
		ClassDAO dao = ClassDAO.newInstance();
		List<OffClassVO> allList = dao.trendListData(curpage);
		int count = dao.allCount();
		int totalPage = (int)(Math.ceil(count / 12.0));
		
		final int BLOCK = 10;
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

		if (endPage > totalPage) {
			endPage = totalPage;
		}
			
		List<OffClassVO> kList=new ArrayList<OffClassVO>();
		  
		  Cookie[] cookies=request.getCookies();			
		  if(cookies != null)
		  {
			  for(int i=cookies.length-1;i>=0;i--)
			  {
				  if(cookies[i].getName().startsWith("oc")) // oc: online cookie
				  { 	
					  cookies[i].setPath("/");
					  System.out.println(cookies[i].getName()); // key
					  String cno=cookies[i].getValue(); // value
					  System.out.println(cookies[i].getValue());
					  OffClassVO vo=dao.onlineCookiePrintData(Integer.parseInt(cno));
					  
					  System.out.println(vo.getCno());
					  kList.add(vo);
				  }
			  }
		  }

		request.setAttribute("kList", kList); // 쿠키 데이터
		request.setAttribute("count", count);
		request.setAttribute("allList", allList); // online main List

		request.setAttribute("block", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalpage", totalPage);
		request.setAttribute("curpage", curpage);
		
		request.setAttribute("main_jsp", "../class/trendclass.jsp");
		request.setAttribute("menu", "class");
		return "../main/main.jsp";
	}
	@RequestMapping("class/writeWC_ok.do")
	public String write_ok(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (Exception e) {}
		
		System.out.println("1번");
		
		String type = request.getParameter("type_list");
		System.out.println(type);
		String artist = request.getParameter("artist");
		String address = "";
		if(type=="3") {
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			address = addr1+" "+addr2;
		}
		String category = request.getParameter("category_list");
		String poster = request.getParameter("poster");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String time = request.getParameter("time");
		String price = request.getParameter("price");
		
		ClassDAO dao = ClassDAO.newInstance();
		if(type.equals("1")) {
			WorkDetailVO wvo = new WorkDetailVO();
			wvo.setW_title(title);
			wvo.setW_content(content);
			wvo.setW_artist(artist);
			wvo.setW_poster(poster);
			wvo.setW_price(price);
			int no = dao.InsertWork(wvo);
			request.setAttribute("menu", "work");
			return "redirect:../work/work_detail_before.do?w_no="+no;
			
		}else if(type.equals("2")) {
			System.out.println("3번");
			OnlineVO onvo = new OnlineVO();
			onvo.setCtitle(title);
			onvo.setCcontent(content);
			onvo.setCposter(poster);
			onvo.setCartist(artist);
			onvo.setCprice(price);
			onvo.setCcategory(category);
			int no = dao.InsertOnline(onvo);
			request.setAttribute("menu", "class");
			System.out.println("4번");
			
			return "redirect:../online/online_before.do?cno="+no;
		}else {
			OffClassVO offvo = new OffClassVO();
			offvo.setCtitle(title);
			offvo.setCcontent(content);
			offvo.setCposter(poster);
			offvo.setCartist(artist);
			offvo.setCprice(price);
			offvo.setCaddress(address);
			offvo.setCcategory(category);
			offvo.setCtime(time);
			int no = dao.InsertOffline(offvo);
			request.setAttribute("menu", "class");
			
			return "redirect:../offclass/offclass_detail.do?cno="+no;
		}
		
		//request.setAttribute("main_jsp", "../main/home.jsp");
		//return "../main/main.jsp";
	}
	@RequestMapping("class/writeWC.do")
	public String writeForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		System.out.println(id);
		if(id==null) {
			request.setAttribute("main_jsp", "../main/home.jsp");
			return "../main/main.jsp";
		}
		ClassDAO dao = ClassDAO.newInstance();
		MemberVO mvo = dao.getWriterInfo(id);
		
		request.setAttribute("mvo", mvo);
		request.setAttribute("main_jsp", "../class/writeWC.jsp");
		request.setAttribute("menu", "class");
		return "../main/main.jsp";
	}

}
