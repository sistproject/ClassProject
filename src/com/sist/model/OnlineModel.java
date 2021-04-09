package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.CartDAO;
import com.sist.dao.OnlineDAO;
import com.sist.vo.OnlineReplyVO;
import com.sist.vo.OnlineVO;

@Controller
public class OnlineModel {
	@RequestMapping("online/online.do")
	public String online(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("-===============================================================online");
		// 페이지 나누기
		String page = request.getParameter("page");
		System.out.println(page);
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		
		OnlineDAO dao = OnlineDAO.newInstance();
		List<OnlineVO> omList = dao.onlineData(curpage);
		
		int count = dao.onlineMainCount();
		int totalPage = (int) (Math.ceil(count / 12.0));
		System.out.println("페이치 총 갯수:"+totalPage+"===========================");
		final int BLOCK = 10;
		// 102 [1]-[10] [91]~[100] [101][102]
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		// 1~10 => 1 10-1/10 => 0 9/10
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

		if (endPage > totalPage)
			endPage = totalPage;
		
		// 쿠키 
//		// 전체 쿠키 삭제하기
//	    Cookie[] cookies = request.getCookies() ;
//	     
//	    if(cookies != null){
//	        for(int i=0; i < cookies.length; i++){
//	             
//	            // 쿠키의 유효시간을 0으로 설정하여 만료시킨다
//	            cookies[i].setMaxAge(0) ;
//	             
//	            // 응답 헤더에 추가한다
//	            response.addCookie(cookies[i]) ;
//	        }
//	    }

		  List<OnlineVO> kList=new ArrayList<OnlineVO>();
		  
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
					  OnlineVO vo=dao.onlineCookiePrintData(Integer.parseInt(cno));
					  
					  System.out.println(vo.getCno());
					  kList.add(vo);
				  }
			  }
		  }
		
		
		
		request.setAttribute("kList", kList); // 쿠키 데이터
		request.setAttribute("count", count);
		request.setAttribute("omList", omList); // online main List

		request.setAttribute("block", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalpage", totalPage);
		request.setAttribute("curpage", curpage);
//	    request.setAttribute("main_jsp", "../online/online.jsp");
		request.setAttribute(page, omList);
		request.setAttribute("main_jsp", "../online/online.jsp");

		return "../main/main.jsp";
	}
	
	
	
	  @RequestMapping("online/online_before.do")
	  public String detail_before(HttpServletRequest request,HttpServletResponse response)
	  {	
		  System.out.println("===============================before");
		  String cno=request.getParameter("cno");
		  System.out.println("출력");
		  System.out.println(cno);
		  System.out.println("했나?");
		  Cookie cookies=new Cookie("oc"+cno, cno);// 문자열만 저장이 가능 
		  cookies.setMaxAge(60*60);
		  cookies.setPath("/");
		  response.addCookie(cookies);
		  System.out.println("==============================쿠키 생성");
		  return "redirect:../online/online_detail.do?cno="+cno;
	  }
	  
	  

	@RequestMapping("online/online_detail.do")
	public String online_detail(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String cno = request.getParameter("cno"); // 글 번호
		OnlineDAO dao = OnlineDAO.newInstance();
		OnlineVO vo = dao.onlineDetailData(Integer.parseInt(cno)); // cno로 참조
		List<OnlineReplyVO> rList = dao.onlineReplyReadData(Integer.parseInt(cno)); // 해당 글 번호의 댓글 데이터 리스트

		List<String> pList = new ArrayList<String>(); // poster List
		String poster = vo.getCposter();
		StringTokenizer pst = new StringTokenizer(poster, "^");
		int count = 0;
		while (pst.hasMoreTokens()) {
			if (count < 5) {
				pList.add(pst.nextToken());
				count++;
			} else {
				count = 0;
				break;
			}

		}

		List<String> cList = new ArrayList<String>(); // content List
		String content = vo.getCcontent();
		StringTokenizer cst = new StringTokenizer(content, "^");

		while (cst.hasMoreTokens()) {
			if (count < 5) {
				cList.add(cst.nextToken());
				count++;
			} else {
				count = 0;
				break;
			}
		}

		request.setAttribute("ondVO", vo); // online detail VO
		request.setAttribute("rList", rList);
		request.setAttribute("pList", pList);
		request.setAttribute("cList", cList);
		request.setAttribute("main_jsp", "../online/online_detail.jsp");

		return "../main/main.jsp";

	}
	

	@RequestMapping("online/online_reply_insert.do")
	public String online_reply_insert(HttpServletRequest request, HttpServletResponse response) {
		// 댓글 데이터 받기
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}
		String cno = request.getParameter("cno");
		String msg = request.getParameter("msg");
		System.out.println(cno+" "+msg);
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		
//		  System.out.println(id + "<<>>" + name + msg); //데이터 받는지 확인
		OnlineReplyVO vo = new OnlineReplyVO();
		vo.setName(name);
		vo.setMsg(msg);
		vo.setId(id);
		vo.setCno(Integer.parseInt(cno));
		// DAO연결
		OnlineDAO dao = OnlineDAO.newInstance();
		dao.OnlineReplyInsert(vo);
		
	 	List<OnlineReplyVO> list = dao.onlineReplyReadData(Integer.parseInt(cno));
		request.setAttribute("rlist", list);
		return "redirect:../online/online_detail.do?cno="+cno; // ?cno= 클래스의 번호
	}

	// 댓글 삭제
	@RequestMapping("online/online_reply_delete.do")
	public String online_reply_delete(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		String cno = request.getParameter("cno");
		OnlineDAO dao = OnlineDAO.newInstance();
//		  DB연동 
		dao.onlineReplyDelete(Integer.parseInt(no));
		return "redirect:../online/online_detail.do?cno=" + cno;
	}

	// http://localhost/JSPLastProject/food/food_detail.do?no=2
	// 댓글 수정
	@RequestMapping("online/online_reply_update.do")
	public String online_reply_update(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}
		String msg = request.getParameter("msg");
		String no = request.getParameter("no");
		System.out.println("받아온 no값"+ no + "출력");
		String cno = request.getParameter("cno");
		OnlineReplyVO vo = new OnlineReplyVO();
		vo.setNo(Integer.parseInt(no));
		vo.setMsg(msg);
		OnlineDAO dao = OnlineDAO.newInstance();
		dao.onlineReplyUpdate(vo);
		return "redirect:../online/online_detail.do?cno=" + cno;
	}
	
//	// ajax이용해서 댓글 처리
//	@RequestMapping("online/onlineReply.do")
//	public String online_reply_ajax(HttpServletRequest request, HttpServletResponse response) {
//		String msg = request.getParameter("msg");
//		
//		
//		return "redirect:../online/online_detail.do?msg="+msg;
//	}	
	
	
	@RequestMapping("online/jjim.do")
	  public String online_jjim(HttpServletRequest request,HttpServletResponse response)
	  {
		  String cno=request.getParameter("cno");
		  String wno = request.getParameter("wno");
		  HttpSession session=request.getSession();
		  String id=(String)session.getAttribute("id");
		  
		  OnlineDAO dao=OnlineDAO.newInstance();
		  // 저장 
		  dao.onlineJjimInsert(Integer.parseInt(cno),Integer.parseInt(wno), id);
		  return "redirect:../online/online_detail.do?cno="+cno;
	  }
	

}
