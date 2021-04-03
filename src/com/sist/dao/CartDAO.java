package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.sist.vo.*;
import java.util.*;

public class CartDAO {
	private Connection conn;
	   private PreparedStatement ps;
	   private static MemberDAO dao;
	   // 미리 만들어진 객체주소를 얻어온다 (Connection)
	   public void getConnection() {
		   try {
			   Context init=new InitialContext();
			   Context c=(Context)init.lookup("java://comp/env");
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			   conn=ds.getConnection();
		   }catch(Exception ex){

		   }
	   }
	   public void disConnection() {
		   try {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	   public static MemberDAO newInstance() {
		   if(dao==null)
			   dao=new MemberDAO();
		   return dao;
	   }
	   
	   public List<WorkVO> workList(String id) {
		   List<WorkVO> list = new ArrayList<WorkVO>();
		   try {
			   getConnection();
			   String sql="select w.w_title,w.w_artist,rs.wquantity, w.poster "
			   		+ "from workreserve rs,member m,thiswork w "
			   		+ "where m.id = rs.id and w.w_no=rs.w_no and m.id='test';";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   WorkVO vo = new WorkVO();
				   vo.setTitle(rs.getString(1));
				   
			   }
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   finally {
			   disConnection();
		   }
		   
		   
		   
		   return list;
	   } 
	   
}
