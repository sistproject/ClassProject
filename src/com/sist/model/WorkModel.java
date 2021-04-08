package com.sist.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.OffClassDAO;
import com.sist.dao.OnlineDAO;
import com.sist.dao.WorkDAO;
import com.sist.vo.OnlineReplyVO;
import com.sist.vo.OnlineVO;
import com.sist.vo.WorkDetailVO;
import com.sist.vo.WorkReplyVO;
import com.sist.vo.WorkVO;

@Controller
public class WorkModel {
	//////------------------------- 오늘의 발견 ----------------------------//////
	@RequestMapping("work/work_list.do")
	public String work_list(HttpServletRequest request, HttpServletResponse response)
	{
		
		// 페이지 나누기
				String page = request.getParameter("page");
				System.out.println("페이지 출력");
				System.out.println(page);
				System.out.println("페이지 출력 완료");
				if (page == null) {
					page = "1";
				}
				int curpage = Integer.parseInt(page);
				
				WorkDAO dao=new WorkDAO();
				List<WorkDetailVO> rList = dao.WorkListData(curpage);
				int count = dao.WorkMainCount();
				int totalpage = (int) (Math.ceil(count / 12.0));

				final int BLOCK = 10;
				// 102 [1]-[10] [91]~[100] [101][102]
				int startpage = ((curpage - 1) / BLOCK * BLOCK) + 1;
				// 1~10 => 1 10-1/10 => 0 9/10
				int endpage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

				if (endpage > totalpage)
					endpage = totalpage;
				

		request.setAttribute("count", count);
		request.setAttribute("rList", rList);
		request.setAttribute("block", BLOCK);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("main_jsp", "../work/work_list.jsp");
		request.setAttribute(page, rList);

		return "../main/main.jsp";
	}
	/////----------------------- 인기 작품 ---------------------------------//////
	@RequestMapping("work/work_ingi.do")
	public String work_ingi(HttpServletRequest request, HttpServletResponse response)
	{
		
		// 페이지 나누기
				String page = request.getParameter("page");
				System.out.println("페이지 출력");
				System.out.println(page);
				System.out.println("페이지 출력 완료");
				if (page == null) {
					page = "1";
				}
				int curpage = Integer.parseInt(page);
				
				WorkDAO dao=new WorkDAO();
				List<WorkDetailVO> rList = dao.WorkListData(curpage);
				int count = dao.WorkMainCount();
				int totalpage = (int) (Math.ceil(count / 12.0));

				final int BLOCK = 10;
				// 102 [1]-[10] [91]~[100] [101][102]
				int startpage = ((curpage - 1) / BLOCK * BLOCK) + 1;
				// 1~10 => 1 10-1/10 => 0 9/10
				int endpage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

				if (endpage > totalpage)
					endpage = totalpage;
				

		request.setAttribute("count", count);
		request.setAttribute("rList", rList);
		request.setAttribute("block", BLOCK);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("main_jsp", "../work/work_ingi.jsp");
		request.setAttribute(page, rList);

		return "../main/main.jsp";
	}
	//////----------------------- 실기간 추천작품 -----------------------------------//////
	@RequestMapping("work/work_sil.do")
	public String work_sil(HttpServletRequest request, HttpServletResponse response)
	{
		
		// 페이지 나누기
				String page = request.getParameter("page");
				System.out.println("페이지 출력");
				System.out.println(page);
				System.out.println("페이지 출력 완료");
				if (page == null) {
					page = "1";
				}
				int curpage = Integer.parseInt(page);
				
				WorkDAO dao=new WorkDAO();
				List<WorkDetailVO> rList = dao.WorkListData(curpage);
				int count = dao.WorkMainCount();
				int totalpage = (int) (Math.ceil(count / 12.0));

				final int BLOCK = 10;
				// 102 [1]-[10] [91]~[100] [101][102]
				int startpage = ((curpage - 1) / BLOCK * BLOCK) + 1;
				// 1~10 => 1 10-1/10 => 0 9/10
				int endpage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

				if (endpage > totalpage)
					endpage = totalpage;
				

		request.setAttribute("count", count);
		request.setAttribute("rList", rList);
		request.setAttribute("block", BLOCK);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("main_jsp", "../work/work_sil.jsp");
		request.setAttribute(page, rList);

		return "../main/main.jsp";
	}
	//////----------------------------- 실시간 구매-------------------------------- ///////
	@RequestMapping("work/work_silgu.do")
	public String work_silgu(HttpServletRequest request, HttpServletResponse response)
	{
		
		// 페이지 나누기
				String page = request.getParameter("page");
				System.out.println("페이지 출력");
				System.out.println(page);
				System.out.println("페이지 출력 완료");
				if (page == null) {
					page = "1";
				}
				int curpage = Integer.parseInt(page);
				
				WorkDAO dao=new WorkDAO();
				List<WorkDetailVO> rList = dao.WorkListData(curpage);
				int count = dao.WorkMainCount();
				int totalpage = (int) (Math.ceil(count / 12.0));

				final int BLOCK = 10;
				// 102 [1]-[10] [91]~[100] [101][102]
				int startpage = ((curpage - 1) / BLOCK * BLOCK) + 1;
				// 1~10 => 1 10-1/10 => 0 9/10
				int endpage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

				if (endpage > totalpage)
					endpage = totalpage;
				

		request.setAttribute("count", count);
		request.setAttribute("rList", rList);
		request.setAttribute("block", BLOCK);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("main_jsp", "../work/work_silgu.jsp");
		request.setAttribute(page, rList);

		return "../main/main.jsp";
	}
	/////-------------------------------- 작가님 추천 --------------------------------/////
	@RequestMapping("work/work_jak.do")
	public String work_jak(HttpServletRequest request, HttpServletResponse response)
	{
		
		// 페이지 나누기
				String page = request.getParameter("page");
				System.out.println("페이지 출력");
				System.out.println(page);
				System.out.println("페이지 출력 완료");
				if (page == null) {
					page = "1";
				}
				int curpage = Integer.parseInt(page);
				
				WorkDAO dao=new WorkDAO();
				List<WorkDetailVO> rList = dao.WorkListData(curpage);
				int count = dao.WorkMainCount();
				int totalpage = (int) (Math.ceil(count / 12.0));

				final int BLOCK = 10;
				// 102 [1]-[10] [91]~[100] [101][102]
				int startpage = ((curpage - 1) / BLOCK * BLOCK) + 1;
				// 1~10 => 1 10-1/10 => 0 9/10
				int endpage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

				if (endpage > totalpage)
					endpage = totalpage;
				

		request.setAttribute("count", count);
		request.setAttribute("rList", rList);
		request.setAttribute("block", BLOCK);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("main_jsp", "../work/work_jak.jsp");
		request.setAttribute(page, rList);

		return "../main/main.jsp";
	}
	
	
	@RequestMapping("work/work_detail_before.do")
	  public String detail_before(HttpServletRequest request,HttpServletResponse response)
	  {
		
		System.out.println("===============================before");
		  String w_no=request.getParameter("w_no");
		  System.out.println("출력");
		  System.out.println(w_no);
		  System.out.println("했나?");
		  Cookie cookies=new Cookie("wc"+w_no, w_no);// 문자열만 저장이 가능 
		  cookies.setMaxAge(60*60);
		  cookies.setPath("/");
		  response.addCookie(cookies);
		  System.out.println("==============================쿠키 생성");
		  return "redirect:../work/work_detail.do?w_no="+w_no;
	  }
	@RequestMapping("work/work_detail.do")
	public String work_detail(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			request.setCharacterEncoding("UTF-8");
		}catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		try
		{
		System.out.println("============================================detail");
		String w_no=request.getParameter("w_no");
		WorkDAO dao=new WorkDAO();
		System.out.println("==============================6888==============detail");
		WorkDetailVO vo=dao.WorkDetailData(Integer.parseInt(w_no));
		List<WorkReplyVO> reList = dao.WorkReplyReadData(Integer.parseInt(w_no));
		System.out.println("==============================6666==============detail");
		request.setAttribute("vo", vo);
		System.out.println("============================777==============detail");
		request.setAttribute("main_jsp", "../work/work_detail.jsp");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "../main/main.jsp";
	}
	
	//찜하기 
	  @RequestMapping("work/jjim.do")
	  public String work_jjim(HttpServletRequest request,HttpServletResponse response)
	  {
	 	  String w_no=request.getParameter("w_no");
	 	  HttpSession session=request.getSession();
	 	  String id=(String)session.getAttribute("id");
	 	  String c_no=request.getParameter("c_no");
	 	  
	 	  WorkDAO dao=new WorkDAO();
	 	  // 저장 
	 	  dao.WorkJjimInsert(Integer.parseInt(w_no),Integer.parseInt(c_no), id);
	 	  return "redirect:../work/work_detail.do?w_no="+w_no;
      }
	  
		@RequestMapping("work/work_reply_insert.do")
		public String work_reply_insert(HttpServletRequest request, HttpServletResponse response) {
			// 댓글 데이터 받기
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception ex) {
			}
			String w_no = request.getParameter("w_no");
			String msg = request.getParameter("msg");
			String page = request.getParameter("page");
            //System.out.println("page:"+page); // 상세페이지에서 page값을 못 받아온다.
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			String name = (String) session.getAttribute("name");
            //System.out.println(id + "<<>>" + name + msg); //데이터 받는지 확인
			WorkReplyVO vo = new WorkReplyVO();
			vo.setName(name);
			vo.setMsg(msg);
			vo.setId(id);
			vo.setCno(Integer.parseInt(w_no));
			// DAO연결
			WorkDAO dao = new WorkDAO();
			dao.WorkReplyInsert(vo);
            //return "redirect:../food/food_detail.do?no="+cno;
			return "redirect:../work/work_detail.do?&w_no=" + w_no; // ?cno= 클래스의 번호
		}

		// 댓글 삭제
		@RequestMapping("work/work_reply_delete.do")
		public String online_reply_delete(HttpServletRequest request, HttpServletResponse response) {
			String no = request.getParameter("no");
			String w_no = request.getParameter("w_no");
			WorkDAO dao = new WorkDAO();
         // DB연동 
			dao.WorkDetailData(Integer.parseInt(no));
			return "redirect:../work/work_detail.do?w_no=" + w_no;
		}

		// http://localhost/JSPLastProject/food/food_detail.do?no=2
		// 댓글 수정
		@RequestMapping("work/wirk_reply_update.do")
		public String work_reply_update(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception ex) {
			}
			String msg = request.getParameter("msg");
			String no = request.getParameter("no");
			System.out.println("받아온 no값"+ no + "출력");
			String w_no = request.getParameter("w_no");
			WorkReplyVO vo = new WorkReplyVO();
			vo.setNo(Integer.parseInt(no));
			vo.setMsg(msg);
			WorkDAO dao = new WorkDAO();
			dao.WorkReplyUpdate(vo);
			return "redirect:../work/work_detail.do?w_no=" + w_no;
		}
		
		// ajax이용해서 댓글 처리
		@RequestMapping("work/workreply.do")
		public String work_reply_ajax(HttpServletRequest request, HttpServletResponse response) {
			String msg = request.getParameter("msg");
			
			
			return "redirect:../work/work_detail.do?msg="+msg;
		}

}

















