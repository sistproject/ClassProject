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
	   private static CartDAO dao;
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
	   public static CartDAO newInstance() {
		   if(dao==null)
			   dao=new CartDAO();
		   return dao;
	   }
	   /*   ID       NOT NULL VARCHAR2(34) 
			C_NO     NOT NULL NUMBER       
			W_NO     NOT NULL NUMBER       
			CRNO     NOT NULL NUMBER       
			QUANTITY          NUMBER 
	    */
	   public List<CartVO> workList(String id) {
		   List<CartVO> list = new ArrayList<CartVO>();
		   try {
			   getConnection();
			   String sql="SELECT w.w_title,w.w_artist,w.w_poster,w.w_price,cr.quantity "
			   		+ "FROM cart cr,member m,thiswork w "
			   		+ "WHERE m.id = cr.id AND w.w_no=cr.w_no AND m.id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   CartVO vo = new CartVO();
				   vo.setTitle(rs.getString(1));
				   vo.setArtist(rs.getString(2));
				   vo.setPoster(rs.getString(3));
				   vo.setPrice(rs.getString(4));
				   vo.setQuantity(rs.getInt(5));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   finally {
			   disConnection();
		   }
		   return list;
	   } 
	   public List<CartVO> classList(String id) {
		   List<CartVO> list = new ArrayList<CartVO>();
		   try {
			   getConnection();
			   String sql="SELECT c.c_title,c.c_artist,c.c_poster,c.c_price,cr.quantity "
					   + "FROM cart cr,member m,thisclass c "
					   + "WHERE m.id = cr.id AND c.c_no=cr.c_no AND m.id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   CartVO vo = new CartVO();
				   vo.setTitle(rs.getString(1));
				   vo.setArtist(rs.getString(2));
				   vo.setPoster(rs.getString(3));
				   vo.setPrice(rs.getString(4));
				   vo.setQuantity(rs.getInt(5));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   finally {
			   disConnection();
		   }
		   return list;
	   } 
	   
	   
}
