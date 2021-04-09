package com.sist.model;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.OffClassDAO;
import com.sist.vo.OffClassVO;
import com.sist.vo.OffclassReplyVO;
import com.sist.vo.OnlineVO;
import com.sist.vo.ReserveVO;

@Controller
public class OffClassModel {
	@RequestMapping("offclass/offclass.do")
	public String class_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		
		OffClassDAO dao= OffClassDAO.newInstance();
		List<OffClassVO> ofList=dao.OffClassData(curpage);
		int count=dao.OffClassCount();
		int totalPage=(int)(Math.ceil(count/12.0));
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;

		
		if(endPage>totalPage)
			endPage=totalPage; 
		
		List<OffClassVO> kList=new ArrayList<OffClassVO>();
		  Cookie[] cookies=request.getCookies();	
		  System.out.println(cookies.length);
		  if(cookies != null)
		  {
			  System.out.println("not null");
			  for(int i=cookies.length-1;i>=0;i--)
			  {
				  System.out.println("length");
				  if(cookies[i].getName().startsWith("m"))
				  { 	
					  if(!cookies[i].getName().replace("m","").equals("null")) {
					  cookies[i].setPath("/");
					   // key
					  String cno=cookies[i].getValue(); // value
					  System.out.println("value"+cookies[i].getValue());
					  OffClassVO vo=dao.offclassCookiePrintData(Integer.parseInt(cno));
					  System.out.println(vo.getCno());
					  kList.add(vo);
					  
					  }
					  System.out.println("success");
				  }
			  }
		  }
		System.out.println(kList.size());
		
		request.setAttribute("kList", kList); // 쿠키 데이터
		request.setAttribute("count", count);
		request.setAttribute("ofList", ofList);
		
		request.setAttribute("block", BLOCK);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("totalPage", totalPage);
	    request.setAttribute("curpage", curpage);
	    request.setAttribute("main_jsp", "../offclass/offclass.jsp");
	    request.setAttribute("menu", "class");
		
		return "../main/main.jsp";
	}
	
  @RequestMapping("offclass/offclass_before.do")
  public String offclass(HttpServletRequest request,HttpServletResponse response)
  {
	  String c_no=request.getParameter("cno");
	  Cookie cookie=new Cookie("m"+c_no, c_no);
	  cookie.setMaxAge(60*60);		
	  cookie.setPath("/");
	  response.addCookie(cookie);
	  return "redirect:../offclass/offclass_detail.do?cno="+c_no;  
  }
	
	@RequestMapping("offclass/offclass_detail.do")
	public String class_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String cno=request.getParameter("cno");
		// DAO
		OffClassDAO dao=OffClassDAO.newInstance();
		OffClassVO vo=dao.OffDetailData(Integer.parseInt(cno));
		List<String> sList = new ArrayList<String>(); // subtitle list
		String subtitle = "";
		int count=0;
		if(vo.getCsubtitles()!=null) {
				subtitle = vo.getCsubtitles();
				StringTokenizer sst = new StringTokenizer(subtitle,"^");
				
				while (sst.hasMoreTokens()) 
				{
					if (count<5) 
					{
						sList.add(sst.nextToken());
						count++;
					} 
					else {
						count=0;
						break;
					}
				}
					
		}

		List<String> cList = new ArrayList<String>(); // content List
		String content = vo.getCcontent();
		String contents = vo.getCcontents();

		
		StringTokenizer cst= new StringTokenizer(content+contents,"^");
		
		while(cst.hasMoreTokens())
		{
			if (count<5) 
			{
				cList.add(cst.nextToken());
				count++;
			} 
			else {
				count=0;
				break;
			}
		}
		
		List<OffclassReplyVO> rList=dao.offclassReplyReadData(Integer.parseInt(cno));
		System.out.println(rList.size());
		System.out.println(sList.size());
		System.out.println(cList.size());
		
		
		request.setAttribute("rList", rList);
		request.setAttribute("sList", sList);
		request.setAttribute("cList", cList);
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../offclass/offclass_detail.jsp");
		request.setAttribute("menu", "class");
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		//int count=dao.offJjimCheck(Integer.parseInt(cno), id);
		request.setAttribute("count", count);
		
		return "../main/main.jsp";
	}

	  
	  //찜하기 
	  @RequestMapping("offclass/jjim.do")
	  public String offclass_jjim(HttpServletRequest request,HttpServletResponse response)
	  {
	 	  String c_no=request.getParameter("cno");
	 	  HttpSession session=request.getSession();
	 	  String id=(String)session.getAttribute("id");
	 	  
	 	  OffClassDAO dao=OffClassDAO.newInstance();
	 	  // 저장 
	 	  dao.offJjimInsert(Integer.parseInt(c_no), id);
	 	  return "redirect:../offclass/offclass_detail.do?cno="+c_no;
}
	  
	  

	  // 예약
	  
	  @RequestMapping("offclass/reserve.do")
	  public String offclass_reserve(HttpServletRequest request,HttpServletResponse response)
	  {
		  String cno = request.getParameter("no");
		  request.setAttribute("cno", cno);
		  request.setAttribute("main_jsp", "../offclass/reserve.jsp");
		  request.setAttribute("menu", "class");
		  return "../main/main.jsp";
	  }
	  
	  
	  @RequestMapping("offclass/date.do")
	  public String offclass_date(HttpServletRequest request,HttpServletResponse response)
	  {
		   String strYear=request.getParameter("year");
		   String strMonth=request.getParameter("month");
		   
		   String today=new SimpleDateFormat("yyyy-M-d").format(new Date());
		   StringTokenizer st=new StringTokenizer(today,"-");
		   
		   String sy=st.nextToken();
		   String sm=st.nextToken();
		   String sd=st.nextToken();
		   
		   if(strYear==null)
			   strYear=sy;
		   if(strMonth==null)
			   strMonth=sm;
		   
		   int year=Integer.parseInt(strYear);
		   int month=Integer.parseInt(strMonth);
		   int day=Integer.parseInt(sd);
		   
		   
		   String[] strWeek={"일","월","화","수","목","금","토"};
		   
		   int total=(year-1)*365
				    +(year-1)/4
				    -(year-1)/100
				    +(year-1)/400;
		   
		   int[] lastDay={31,28,31,30,31,30,
				          31,31,30,31,30,31};
		   
		   if((year%4==0 && year%100!=0)||(year%400==0))
			   lastDay[1]=29;
		   else
			   lastDay[1]=28;
			
		   for(int i=0;i<month-1;i++)
		   {
			   total+=lastDay[i];
		   }
		   
		   total++;
		   
		   int week=total%7;
		   
		   String no=request.getParameter("no");
		   OffClassDAO dao=OffClassDAO.newInstance();
		   String rday=dao.offclassReserveDate(Integer.parseInt(no));
		   /*
		    *    1,2,3,4,5,6,7,8,10
		    *    int[] arr=new int[10];
		    *    
		    *    arr[0]=11
		    *    arr[1]=21
		    *    arr[2]=31
		    *    --
		    *    arr[9]=10
		    *    
		    *    int[] arr={1,2,3,4,5,6,7}
		    *    int[] arr1={0,2,0,0,5,0,0}
		    *    
		    *    arr[i]==arr1[i] 2,5
		    */
		   
		   int[] days=new int[31];
		   if(rday!=null)
		   {
			   // 1,2,3,7,8,10...
			   StringTokenizer st1=new StringTokenizer(rday,",");
			   while(st1.hasMoreTokens())
			   {
				  int p=Integer.parseInt(st1.nextToken());// 31
				  if(p>=day)
				  {
				     days[p-1]=p;
				  }
			   }
		   }
		   request.setAttribute("days", days);
		   request.setAttribute("lastday", lastDay[month-1]);
		   request.setAttribute("week", week);
		   request.setAttribute("year", year);
		   request.setAttribute("month", month);
		   request.setAttribute("day", day);
		   request.setAttribute("strWeek", strWeek);
		   
		   return "../offclass/date.jsp";
	  }
	  
	  @RequestMapping("offclass/reserve_offclass.do")
	  public String reserve_offclass(HttpServletRequest request,HttpServletResponse response)
	  {
		  System.out.println("get");
		  String cno = request.getParameter("cno");
		  System.out.println(cno);
		  OffClassDAO dao=OffClassDAO.newInstance();
		  OffClassVO vo = dao.OffDetailData(Integer.parseInt(cno));
//		  List<OffClassVO> list=dao.offclassReserveAllData();
//		  request.setAttribute("list", list);
		  request.setAttribute("vo", vo);
		  System.out.println(vo.getCtitle());
		  return "../offclass/reserve_offclass.jsp";
	  }
	  
	  @RequestMapping("offclass/time.do")
	  public String offclass_time(HttpServletRequest request,HttpServletResponse response) 
	  {
		  String day=request.getParameter("day");
		  // 시간을 읽어 온다 => 오라클에 있음
		  OffClassDAO dao=OffClassDAO.newInstance();
		  String tno=dao.offclassReserveTimeData(Integer.parseInt(day));
		  List<String> list=new ArrayList<String>();
		  StringTokenizer st=new StringTokenizer(tno,",");
		  while(st.hasMoreTokens())
		  {
			  String t=st.nextToken();
			  int i=Integer.parseInt(t);
			  String time=dao.offclassReserveGetTime(i);
			  list.add(time);
		  }
		  
		  request.setAttribute("list", list);
		  return "../offclass/time.jsp";   
	  }
	  
	  @RequestMapping("offclass/inwon.do")
	  public String offclass_inwon(HttpServletRequest request,HttpServletResponse response) 
	  {
		  return "../offclass/inwon.jsp";
	  }
	  
	  @RequestMapping("offclass/reserve_save.do")
	  public String reserve_save(HttpServletRequest request,HttpServletResponse response) 
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  String title=request.getParameter("title");
		  String day=request.getParameter("day");
		  String time=request.getParameter("time");
		  String inwon=request.getParameter("inwon");
		  HttpSession session=request.getSession();
		  String id=(String)session.getAttribute("id");
		  
		  ReserveVO vo=new ReserveVO();
		  vo.setId(id);
		  vo.setTitle(title);
		  vo.setDay(day);
		  vo.setTime(time);
		  vo.setInwon(inwon);
		  
		  OffClassDAO dao=OffClassDAO.newInstance();
		  dao.offclassReserveSave(vo);
		  
		  return "redirect:../cart/cart.do";   // 이부분 확인할것!!!
	  }
	  
	  
	  
	  // 댓글
	  @RequestMapping("offclass/offclass_reply_insert.do")
	  public String offclass_reply_insert(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex){}
		  String c_no=request.getParameter("cno");
		  String msg=request.getParameter("msg");
		  HttpSession session=request.getSession();
		  String id=(String)session.getAttribute("id");
		  String name=(String)session.getAttribute("name");
		  OffclassReplyVO vo=new OffclassReplyVO();
		  vo.setName(name);
		  vo.setMsg(msg);
		  vo.setId(id);
		  vo.setCno(Integer.parseInt(c_no));
		  
		  // DAO
		  OffClassDAO dao=OffClassDAO.newInstance();
		  dao.offclassReplyInsert(vo);

		  return "redirect:../offclass/offclass_detail.do?cno="+c_no;
	  }
	  
	  // 댓글 삭제
	  @RequestMapping("offclass/offclass_reply_delete.do")
	  public String offclass_reply_delete(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");
		  String c_no=request.getParameter("cno");
		  OffClassDAO dao=OffClassDAO.newInstance();
		  //DB연동 
		  dao.offclassReplyDelete(Integer.parseInt(no));
		  return "redirect:../offclass/offclass_detail.do?cno="+c_no;
	  }
	  
	  // 댓글 수정 
	  @RequestMapping("offclass/offclass_reply_update.do")
	  public String offclass_reply_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  String msg=request.getParameter("msg");
		  String no=request.getParameter("no");
		  String c_no=request.getParameter("cno");
		  OffclassReplyVO vo=new OffclassReplyVO();
		  vo.setNo(Integer.parseInt(no));
		  vo.setMsg(msg);
		  OffClassDAO dao=OffClassDAO.newInstance();
		  dao.offclassReplyUpdate(vo);
		  return "redirect:../offclass/offclass_detail.do?cno="+c_no;
		  
		  
	  }
	  
	  
	  // 쿠키
	  
	  
	
		
	  
	  
	  @RequestMapping("offclass/offclass_a.do")
		public String 공예_list(HttpServletRequest request,HttpServletResponse response)
		{
			String page=request.getParameter("page");
			if(page==null) {
				page="1";
			}
			int curpage=Integer.parseInt(page);
			
			OffClassDAO dao= OffClassDAO.newInstance();
			List<OffClassVO> ofaList=dao.Off공예Data(curpage);
			int count=dao.OffClassCount();
			int totalPage=(int)(Math.ceil(count/12.0));
			
			final int BLOCK=10;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;

			
			if(endPage>totalPage)
				endPage=totalPage; 
			
			
			request.setAttribute("count", count);
			request.setAttribute("ofaList", ofaList);
			
			request.setAttribute("block", BLOCK);
		    request.setAttribute("startPage", startPage);
		    request.setAttribute("endPage", endPage);
		    request.setAttribute("totalPage", totalPage);
		    request.setAttribute("curpage", curpage);
		    request.setAttribute("main_jsp", "../offclass/offclass_a.jsp");
		    request.setAttribute("menu", "class");
			
			return "../main/main.jsp";
		}
	  
	  
	  	@RequestMapping("offclass/offclass_b.do")
		public String 요리_list(HttpServletRequest request,HttpServletResponse response)
		{
			String page=request.getParameter("page");
			if(page==null) {
				page="1";
			}
			int curpage=Integer.parseInt(page);
			
			OffClassDAO dao= OffClassDAO.newInstance();
			List<OffClassVO> ofbList=dao.Off요리Data(curpage);
			int count=dao.OffClassCount();
			int totalPage=(int)(Math.ceil(count/12.0));
			
			final int BLOCK=10;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;

			
			if(endPage>totalPage)
				endPage=totalPage; 
			
			
			request.setAttribute("count", count);
			request.setAttribute("ofbList", ofbList);
			
			request.setAttribute("block", BLOCK);
		    request.setAttribute("startPage", startPage);
		    request.setAttribute("endPage", endPage);
		    request.setAttribute("totalPage", totalPage);
		    request.setAttribute("curpage", curpage);
		    request.setAttribute("main_jsp", "../offclass/offclass_b.jsp");
		    request.setAttribute("menu", "class");
			
			return "../main/main.jsp";
		}
	  	
	  	@RequestMapping("offclass/offclass_c.do")
		public String 미술_list(HttpServletRequest request,HttpServletResponse response)
		{
			String page=request.getParameter("page");
			if(page==null) {
				page="1";
			}
			int curpage=Integer.parseInt(page);
			
			OffClassDAO dao= OffClassDAO.newInstance();
			List<OffClassVO> ofcList=dao.Off미술Data(curpage);
			int count=dao.OffClassCount();
			int totalPage=(int)(Math.ceil(count/12.0));
			
			final int BLOCK=10;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;

			
			if(endPage>totalPage)
				endPage=totalPage; 
			
			
			request.setAttribute("count", count);
			request.setAttribute("ofcList", ofcList);
			
			request.setAttribute("block", BLOCK);
		    request.setAttribute("startPage", startPage);
		    request.setAttribute("endPage", endPage);
		    request.setAttribute("totalPage", totalPage);
		    request.setAttribute("curpage", curpage);
		    request.setAttribute("main_jsp", "../offclass/offclass_c.jsp");
		    request.setAttribute("menu", "class");
			
			return "../main/main.jsp";
		}
	  	
	  	
	  	@RequestMapping("offclass/offclass_e.do")
		public String 플라워_list(HttpServletRequest request,HttpServletResponse response)
		{
			String page=request.getParameter("page");
			if(page==null) {
				page="1";
			}
			int curpage=Integer.parseInt(page);
			
			OffClassDAO dao= OffClassDAO.newInstance();
			List<OffClassVO> ofeList=dao.Off플라워Data(curpage);
			int count=dao.OffClassCount();
			int totalPage=(int)(Math.ceil(count/12.0));
			
			final int BLOCK=10;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;

			
			if(endPage>totalPage)
				endPage=totalPage; 
			
			
			request.setAttribute("count", count);
			request.setAttribute("ofeList", ofeList);
			
			request.setAttribute("block", BLOCK);
		    request.setAttribute("startPage", startPage);
		    request.setAttribute("endPage", endPage);
		    request.setAttribute("totalPage", totalPage);
		    request.setAttribute("curpage", curpage);
		    request.setAttribute("main_jsp", "../offclass/offclass_e.jsp");
		    request.setAttribute("menu", "class");
			
			return "../main/main.jsp";
		}
	  	
	  	@RequestMapping("offclass/offclass_f.do")
		public String 뷰티_list(HttpServletRequest request,HttpServletResponse response)
		{
			String page=request.getParameter("page");
			if(page==null) {
				page="1";
			}
			int curpage=Integer.parseInt(page);
			
			OffClassDAO dao= OffClassDAO.newInstance();
			List<OffClassVO> offList=dao.Off뷰티Data(curpage);
			int count=dao.OffClassCount();
			int totalPage=(int)(Math.ceil(count/12.0));
			
			final int BLOCK=10;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;

			
			if(endPage>totalPage)
				endPage=totalPage; 
			
			
			request.setAttribute("count", count);
			request.setAttribute("offList", offList);
			
			request.setAttribute("block", BLOCK);
		    request.setAttribute("startPage", startPage);
		    request.setAttribute("endPage", endPage);
		    request.setAttribute("totalPage", totalPage);
		    request.setAttribute("curpage", curpage);
		    request.setAttribute("main_jsp", "../offclass/offclass_f.jsp");
		    request.setAttribute("menu", "class");
			
			return "../main/main.jsp";
		}
	  	
	  	@RequestMapping("offclass/offclass_g.do")
		public String 체험_list(HttpServletRequest request,HttpServletResponse response)
		{
			String page=request.getParameter("page");
			if(page==null) {
				page="1";
			}
			int curpage=Integer.parseInt(page);
			
			OffClassDAO dao= OffClassDAO.newInstance();
			List<OffClassVO> ofgList=dao.Off체험Data(curpage);
			int count=dao.OffClassCount();
			int totalPage=(int)(Math.ceil(count/12.0));
			
			final int BLOCK=10;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;

			
			if(endPage>totalPage)
				endPage=totalPage; 
			
			
			request.setAttribute("count", count);
			request.setAttribute("ofgList", ofgList);
			
			request.setAttribute("block", BLOCK);
		    request.setAttribute("startPage", startPage);
		    request.setAttribute("endPage", endPage);
		    request.setAttribute("totalPage", totalPage);
		    request.setAttribute("curpage", curpage);
		    request.setAttribute("main_jsp", "../offclass/offclass_g.jsp");
		    request.setAttribute("menu", "class");
			
			return "../main/main.jsp";
		}
}


















