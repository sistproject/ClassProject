package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.WorkVO;

public class WorkDAO {
	 private Connection conn;
	 private PreparedStatement ps;
	// 미리 만들어진 객체주소를 얻어온다 (Connection)
	   public void getConnection()
	   {
		   try
		   {
			   Context init=new InitialContext();
			   Context c=(Context)init.lookup("java://comp/env");
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			   conn=ds.getConnection();
		   }catch(Exception ex){}
	   }
	   // 반환 (풀(POOL)로 반환) => 재사용
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	 public List<WorkVO> foodCategoryData(int index)
	 {
		 List<WorkVO> list=new ArrayList<WorkVO>();
		 try
		 {
			 getConnection();
			 int start=0;
			 int end=0;
			 if(index==1)
			 {
				 start=1;
				 end=12;
			 }
			 else if(index==2)
			 {
				 start=13;
				 end=18;
			 }
			 else
			 {
				 start=19;
				 end=30;
				 
			 }
			 String sql="SELECT * FROM work "
					   +"WHERE no BETWEEN ? AND ?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, start);
			 ps.setInt(2, end);
			 
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 /*
				  * private int no;
					private String poster;
					private String artist;
					private String title;
				  */
				 WorkVO vo=new WorkVO();
				 vo.setNo(rs.getInt(1));
				 vo.setPoster(rs.getString(2));
				 vo.setArtist(rs.getString(3));
				 vo.setTitle(rs.getString(4));
				 
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

}
