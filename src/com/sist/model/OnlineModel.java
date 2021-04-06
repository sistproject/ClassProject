package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.CartDAO;
//import com.sist.dao.FoodDAO;
import com.sist.dao.OnlineDAO;
import com.sist.vo.OnlineReplyVO;
//import com.sist.vo.FoodReplyVO;
import com.sist.vo.OnlineVO;

@Controller
public class OnlineModel {
	@RequestMapping("online/online.do")
	public String online(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("-===============================================================online");
		// 페이지 나누기
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);

		OnlineDAO dao = OnlineDAO.newInstance();
		List<OnlineVO> omList = dao.onlineData(curpage);
		int count = dao.onlineMainCount();
		int totalPage = (int) (Math.ceil(count / 12.0));

		final int BLOCK = 10;
		// 102 [1]-[10] [91]~[100] [101][102]
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		// 1~10 => 1 10-1/10 => 0 9/10
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

		if (endPage > totalPage)
			endPage = totalPage;

		request.setAttribute("count", count);
		request.setAttribute("omList", omList); // online main List

		request.setAttribute("block", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalpage", totalPage);
		request.setAttribute("curpage", curpage);
//	    request.setAttribute("main_jsp", "../online/online.jsp");
		request.setAttribute(page, omList);

		return "../online/online.jsp";
	}

	@RequestMapping("online/online_detail.do")
	public String online_detail(HttpServletRequest request, HttpServletResponse response) {
		try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex){
			  ex.printStackTrace();
		  }
		String cno = request.getParameter("cno"); // 글 번호
		OnlineDAO dao = OnlineDAO.newInstance();
		OnlineVO vo = dao.onlineDetailData(Integer.parseInt(cno)); // cno로 참조
		List<OnlineReplyVO> rList = dao.onlineReplyReadData(Integer.parseInt(cno)); // 해당 글 번호의 댓글 데이터 리스트
		
		
		List<String> pList = new ArrayList<String>(); // poster List
		String poster = vo.getCposter();
		StringTokenizer pst = new StringTokenizer(poster, "^");
		while(pst.hasMoreTokens()) {
			pList.add(pst.nextToken());
		}
		
		List<String> cList = new ArrayList<String>(); // content List
		String content = vo.getCcontent();
		StringTokenizer cst = new StringTokenizer(content, "^");
		while(cst.hasMoreTokens()) {
			pList.add(cst.nextToken());
		}
		
		
		request.setAttribute("ondVO", vo); // online detail VO
		request.setAttribute("rList", rList);
		request.setAttribute("pList", pList);
		request.setAttribute("cList", cList);

		return "../online/online_detail.jsp";

	}
	
	@RequestMapping("online/online_reply_insert.do")
	  public String online_reply_insert(HttpServletRequest request,HttpServletResponse response)
	  {
		  // 댓글 데이터 받기 
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  String cno=request.getParameter("cno");
		  String msg=request.getParameter("msg");
		  String page = request.getParameter("page");
//		  System.out.println("page:"+page); // 상세페이지에서 page값을 못 받아온다.
		  HttpSession session=request.getSession();
		  String id=(String)session.getAttribute("id");
		  String name=(String)session.getAttribute("name");
//		  System.out.println(id + "<<>>" + name + msg); //데이터 받는지 확인
		  OnlineReplyVO vo=new OnlineReplyVO();
		  vo.setName(name);
		  vo.setMsg(msg);
		  vo.setId(id);
		  vo.setCno(Integer.parseInt(cno));
		  //DAO연결 
		  OnlineDAO dao=OnlineDAO.newInstance();
		  dao.OnlineReplyInsert(vo);
//		  return "redirect:../food/food_detail.do?no="+cno;
		  return "redirect:../online/online_detail.do?&cno="+cno; // ?cno= 클래스의 번호
	  }
	  // 댓글 삭제
	  @RequestMapping("online/online_reply_delete.do")
	  public String food_reply_delete(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");
		  String cno=request.getParameter("cno");
		  OnlineDAO dao=OnlineDAO.newInstance();
//		  DB연동 
		  dao.foodReplyDelete(Integer.parseInt(no));
		  return "redirect:../online/online_detail.do?cno="+cno;
	  }
	  // http://localhost/JSPLastProject/food/food_detail.do?no=2
	  // 댓글 수정 
	  @RequestMapping("online/online_reply_update.do")
	  public String food_reply_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  String msg=request.getParameter("msg");
		  String no=request.getParameter("no");
		  String cno=request.getParameter("cno");
		  OnlineReplyVO vo=new OnlineReplyVO();
		  vo.setNo(Integer.parseInt(no));
		  vo.setMsg(msg);
		  OnlineDAO dao=OnlineDAO.newInstance();
		  dao.onlineReplyUpdate(vo);
		  return "redirect:../online/online_detail.do?cno="+cno;
	  }

}
