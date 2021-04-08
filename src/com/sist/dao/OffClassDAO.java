package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

import com.sist.vo.OffClassVO;
import com.sist.vo.OffclassReplyVO;
import com.sist.vo.ReserveVO;



public class OffClassDAO {
	// 연결 객체
	   private Connection conn;
	   // SQL문장 전송 
	   private PreparedStatement ps;
	   // 미리 생성된 Connection객체 읽기
	   private static OffClassDAO dao;
	   public void getConnection()
	   {
		   try
		   {
			// JNDI초기화 : 탐색기를 연다
			   Context init=new InitialContext();
			   Context c=(Context)init.lookup("java://comp/env");
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			   conn=ds.getConnection();
		   }catch(Exception ex) {}
	   }
	// 사용후에 반환 
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex){}
	   }
	// DAO  객체를 클라이언트당 1개씩만 사용 => 싱글턴 
	   public static OffClassDAO newInstance()
	   {
		   if(dao==null)
			   dao=new OffClassDAO();
		   
		   return dao;
			   
	   }
	   // Class나열
	   public List<OffClassVO> OffClassData(int page)
	   {
		   List<OffClassVO> list=new ArrayList<OffClassVO>();
		   try
		   {
			   // 연결
			   getConnection();
			   // SQL문장
			   String sql="SELECT c_no, c_poster, c_title, c_artist, c_price, c_category, infoaddr, c_score, num "
						+ "FROM (SELECT c_no, c_title, c_poster, c_artist, c_price, c_category, infoaddr, c_score, rownum as num "
						+ "FROM (SELECT c_no, c_title, c_poster, c_artist, c_price, c_category, infoaddr, c_score " 
						+ "FROM thisclass WHERE c_onoff=1 ORDER BY c_no ASC)) "
						+ "WHERE num BETWEEN ? AND ?";
			   // 전송 객체 생성
			   ps=conn.prepareStatement(sql);
			   int rowSize=12;
			   int start=(rowSize*page)-(rowSize-1); 
			   int end=rowSize*page;
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				    OffClassVO vo=new OffClassVO();
				    vo.setCno(rs.getInt(1));
				   	vo.setCposter(rs.getString(2));
				   	vo.setCtitle(rs.getString(3));
				   	vo.setCartist(rs.getString(4));
				   	vo.setCprice(rs.getString(5));
				   	vo.setCcategory(rs.getString(6));
				   	vo.setInfoaddr(rs.getString(7));
				   	vo.setCscore(rs.getDouble(8));
				   	list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	   }
	   // 오프라인 클래스 총 갯수
	   public int OffClassCount()
	   {
		   int count=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT COUNT(*) FROM thisclass";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   count=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return count;
	   }
	   
	   /*
	    * 	C_NO        NOT NULL NUMBER        
			C_TITLE              VARCHAR2(300) 
			C_CONTENT            CLOB          
			C_POSTER             VARCHAR2(500) 
			C_ARTIST             VARCHAR2(100) 
			C_PRICE              VARCHAR2(20)  
			C_ADDRESS            VARCHAR2(400) 
			C_TIME               VARCHAR2(30)  
			C_ONOFF              NUMBER        
			C_CATEGORY           VARCHAR2(50)  
			C_INTRO              VARCHAR2(100) 
			C_SUBTITLES          VARCHAR2(200) 
			C_CONTENTS           CLOB     
	    */
	   // Class 상세보기
	   public OffClassVO OffDetailData(int cno)
	   {
		   OffClassVO vo=new OffClassVO();
		   try
		   {
			   getConnection();
			   String sql = "SELECT c_no, c_title, c_content, c_poster, c_artist, c_price, c_address, c_time, "
					   	+ "c_category, c_intro, c_subtitles, c_contents, infoaddr "
					   	+ "FROM thisclass "
					   	+ "WHERE c_no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, cno);
			   // 결과값 받기
			   ResultSet rs=ps.executeQuery(); 
			   rs.next();
			   vo.setCno(rs.getInt(1));
			   vo.setCtitle(rs.getString(2));
			   vo.setCcontent(rs.getString(3));
			   vo.setCposter(rs.getString(4));
			   vo.setCartist(rs.getString(5));
			   vo.setCprice(rs.getString(6));
			   vo.setCaddress(rs.getString(7));
			   vo.setCtime(rs.getString(8));
			   vo.setCcategory(rs.getString(9));
			   vo.setCintro(rs.getString(10));
			   vo.setCsubtitles(rs.getString(11));
			   vo.setCcontents(rs.getString(12));
			   vo.setInfoaddr(rs.getString(13));
			   rs.close();
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return vo;
	   }
	   
	   
	   	
	     // 찜하기
	     public void offJjimInsert(int c_no,String id)
	     {
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="INSERT INTO jjim VALUES("
	    				   +"jjim_no_seq.nextval,?,?)";
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setInt(2, c_no);
	    		 ps.setString(1, id);
	    		 
	    		 ps.executeUpdate();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	     }
	     // 찜하기 체크
	     public int offJjimCheck(int c_no,String id)
	     {
	    	 int count=0;
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="SELECT COUNT(*) FROM jjim "
	    				   +"WHERE c_no=? AND id=?";
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setInt(1, c_no);
	    		 ps.setString(2, id);
	    		 ResultSet rs=ps.executeQuery();
	    		 rs.next();
	    		 count=rs.getInt(1);
	    		 rs.close();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	    	 return count;
	     }
	     
	     
	     // 아래부터 예약관련 코드
	     public List<OffClassVO> offclassReserveAllData()
	     {
	    	 List<OffClassVO> list=new ArrayList<OffClassVO>();
		     try
		     {
		    	 getConnection();
	    		 String sql="SELECT c_no, c_title ,c_poster, infoaddr "
	    				   +"FROM thisclass "
	    				   +"WHERE c_onoff=1 "
	    				   +"ORDER BY c_no ASC";
	    		 ps=conn.prepareStatement(sql);
	    		 ResultSet rs=ps.executeQuery();
	    		 while(rs.next())
	    		 {
	    			 OffClassVO vo=new OffClassVO();
	    			 vo.setCno(rs.getInt(1));
	    			 vo.setCtitle(rs.getString(2));
	    			 vo.setCposter(rs.getString(3));
	    			 vo.setInfoaddr(rs.getString(4));
	    			 list.add(vo);
	    		 }
	    		 rs.close();
	    	 }catch(Exception ex) 
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	    	 return list;
	     }
	     
	     public String offclassReserveDate(int c_no)
	     {
	    	 String rday="";
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="SELECT rdays FROM thisclass "
	    				   +"WHERE c_no=?";
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setInt(1, c_no);
	    		 ResultSet rs=ps.executeQuery();
	    		 rs.next();
	    		 rday=rs.getString(1);
	    		 rs.close();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	    	 return rday;
	     }
	     
	     public String offclassReserveTimeData(int day)
	     {
	    	 String time="";
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="SELECT tno FROM rday "
	    				 +"WHERE no=?"; 
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setInt(1, day);
	    		 ResultSet rs=ps.executeQuery();
	    		 rs.next();
	    		 time=rs.getString(1);
	    		 rs.close();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	    	 return time;
	     }
	     
	     public String offclassReserveGetTime(int no)
	     {
	    	 String time="";
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="SELECT time FROM rtime "
	    				 +"WHERE no=?";
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setInt(1, no);
	    		 ResultSet rs=ps.executeQuery();
	    		 rs.next();
	    		 time=rs.getString(1);
	    		 rs.close();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	    	 
	    	 return time;
	     }
	     
	     public void offclassReserveSave(ReserveVO vo)
	     {
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="INSERT INTO offclass_reserve VALUES("
	    		 		+ "(SELECT NVL(MAX(no)+1,1) FROM project_reserve),?,?,?,?,?,"
	    				 +"0,SYSDATE)";  
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setString(1, vo.getId());
	    		 ps.setString(2, vo.getTitle());
	    		 ps.setString(3, vo.getDay());
	    		 ps.setString(4, vo.getTime());
	    		 ps.setString(5, vo.getInwon());
	    		 ps.executeUpdate();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		disConnection(); 
	    	 }
	     }
	     
	     public void reserve_ok(int no)
	     {
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="UPDATE offclass_reserve SET "
	    				 +"state=1 "
	    				 +"WHERE no=?"; 
	    	 ps=conn.prepareStatement(sql);
	    	 ps.setInt(1, no);
	    	 ps.executeUpdate();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	     }
	     
	     
	     // 댓글
	     
	     // 댓글 읽기
	     public List<OffclassReplyVO> offclassReplyReadData(int cno)
	     {
	    	 List<OffclassReplyVO> list=new ArrayList<OffclassReplyVO>();
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="SELECT no,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') "
	    				 +"FROM offclass_reply "
	    				 +"WHERE c_no=?";
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setInt(1, cno);
	    		 ResultSet rs=ps.executeQuery();
	    		 while(rs.next())
	    		 {
	    			 OffclassReplyVO vo=new OffclassReplyVO();
	    			 vo.setNo(rs.getInt(1));
	    			 vo.setId(rs.getString(2));
	    			 vo.setName(rs.getString(3));
	    			 vo.setMsg(rs.getString(4));
	    			 vo.setDbday(rs.getString(5));
	    			 list.add(vo);
	    		 }
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	    	 return list;
	     }
	     
	     
	     // 댓글 올리기
	     public void offclassReplyInsert(OffclassReplyVO vo)
	     {
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="INSERT INTO offclass_reply VALUES("
	    				 +"or_no_seq.nextval,?,?,?,?,SYSDATE)";
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setInt(1, vo.getCno());
	    		 ps.setString(2, vo.getId());
	    		 ps.setString(3, vo.getName());
	    		 ps.setString(4, vo.getMsg());
	    		 
	    		 ps.executeUpdate();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	     }
	     
	     // 댓글 수정
	     public void offclassReplyUpdate(OffclassReplyVO vo)
	     {
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="UPDATE offclass_reply SET "
	    				 +"msg=?"
	    				 +"WHERE c_no=?";
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setString(1, vo.getMsg());
	    		 ps.setInt(2, vo.getCno());
	    		 ps.executeUpdate();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	     }
	     
	     // 댓글 삭제
	     public void offclassReplyDelete(int cno)
	     {
	    	 try
	    	 {
	    		 getConnection();
	    		 String sql="DELETE FROM offclass_reply "
	    				   +"WHERE c_no=?";
	    		 ps=conn.prepareStatement(sql);
	    		 ps.setInt(1, cno);
	    		 ps.executeUpdate();
	    	 }catch(Exception ex)
	    	 {
	    		 ex.printStackTrace();
	    	 }
	    	 finally
	    	 {
	    		 disConnection();
	    	 }
	     }
}






























