package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

import com.sist.vo.OffClassVO;



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
	   public List<OffClassVO> classListData(int page)
	   {
		   List<OffClassVO> list=new ArrayList<OffClassVO>();
		   try
		   {
			   // 연결
			   getConnection();
			   // SQL문장
			   String sql="SELECT c_no,c_poster,c_title,c_artist,c_price,c_category,c_address "
					   +"FROM thisclass "
					   +"WHERE c_onoff=1 AND num BETWEEN ? AND ? "
					   +"ORDER BY c_no ASC";
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
				   	vo.setCaddress(rs.getString(7));
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
			   String sql="SELECT COUNT(*) FROM thisclass "
					   +"WHERE c_onoff=1";
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
	   public List<OffClassVO> OffDetailData(int cno)
	   {
		   List<OffClassVO> list=new ArrayList<OffClassVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT c_no,c_title,c_content,c_poster,c_artist,c_price,c_address,c_time,"
					   	+"c_category, c_intro,c_subtitles,c_contents "
					   	+"FROM thisclass "
					   	+"WHERE c_onoff=1 AND c_no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, cno);
			   // 결과값 받기
			   ResultSet rs=ps.executeQuery(); 
			   rs.next();
			   OffClassVO vo=new OffClassVO();
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
}





























