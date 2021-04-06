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
			   String sql="SELECT w.w_title,w.w_artist,w.w_poster,w.w_price,cr.quantity,w.w_no "
			   		+ "FROM cart cr,member m,thiswork w "
			   		+ "WHERE m.id = cr.id AND w.w_no=cr.w_no AND m.id=? AND ono=0";
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
				   vo.setNo(rs.getInt(6));
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
			   String sql="SELECT c.c_title,c.c_artist,c.c_poster,c.c_price,cr.quantity,c.c_no "
					   + "FROM cart cr,member m,thisclass c "
					   + "WHERE m.id = cr.id AND c.c_no=cr.c_no AND m.id=? AND ono=0";
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
				   vo.setNo(rs.getInt(6));
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
	   public void cartWnoRemove(int no,String id) {
		   List<CartVO> list = new ArrayList<CartVO>();
		   try {
			   getConnection();
			   String sql="DELETE FROM cart	WHERE w_no=? AND id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.setString(2, id);
			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   finally {
			   disConnection();
		   }
	   } 
	   
	   public void cartCnoRemove(int no,String id) {
		   List<CartVO> list = new ArrayList<CartVO>();
		   try {
			   getConnection();
			   String sql="DELETE FROM cart	WHERE c_no=? AND id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.setString(2, id);
			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   finally {
			   disConnection();
		   }
	   } 
	   public void cartClassCheckout(String id,List<Integer> cCheck,List<Integer> wCheck) {
		   try {
			   getConnection();
			   int ono = 0;
			   String sql="SELECT MAX(ono) FROM cart";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs = ps.executeQuery();
			   rs.next();
			   ono = rs.getInt(1)+1;
			   rs.close();
			   System.out.println("check class");
			   System.out.println(ono);
			   for(int no:cCheck) {
				   System.out.println("cno= "+no);
				   sql="UPDATE cart SET ono=?,regdate=sysdate WHERE id=? AND c_no=? AND ono=0";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, ono);
				   ps.setString(2, id);
				   ps.setInt(3, no);
				   
				   ps.executeUpdate();
			   }
			   for(int no:wCheck) {
				   System.out.println("wno= "+no);
				   sql="UPDATE cart SET ono=?,regdate=sysdate WHERE id=? AND w_no=? AND ono=0";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, ono);
				   ps.setString(2, id);
				   ps.setInt(3, no);
				   
				   ps.executeUpdate();
			   }
			   
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   finally {
			   disConnection();
		   }
	   } 
	   public List<CartVO> classOrder(String id) {
		   List<CartVO> list = new ArrayList<CartVO>();
		   try {
			   getConnection();
			   String sql="SELECT cr.ono, cr.c_no, c.c_title,c.c_poster,"
			   		+ "c.c_price,cr.quantity,cr.regdate "
			   		+ "FROM cart cr, member m, thisclass c "
			   		+ "WHERE m.id = cr.id AND c.c_no=cr.c_no "
			   		+ "AND cr.id=? and cr.ono!=0 ORDER BY cr.ono DESC";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   CartVO vo = new CartVO();
				   vo.setOno(rs.getInt(1));
				   vo.setNo(rs.getInt(2));
				   vo.setTitle(rs.getString(3));
				   vo.setPoster(rs.getString(4));
				   vo.setPrice(rs.getString(5));
				   vo.setQuantity(rs.getInt(6));
				   vo.setRegdate(rs.getString(7).substring(0,rs.getString(7).indexOf(" ")));
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
	   public List<CartVO> workOrder(String id) {
		   List<CartVO> list = new ArrayList<CartVO>();
		   try {
			   getConnection();
			   String sql="SELECT cr.ono, cr.c_no, w.w_title,w.w_poster,"
					   + "w.w_price,cr.quantity,cr.regdate "
					   + "FROM cart cr, member m, thiswork w "
					   + "WHERE m.id = cr.id AND w.w_no=cr.w_no "
					   + "AND cr.id=? and cr.ono!=0 ORDER BY cr.ono DESC";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   CartVO vo = new CartVO();
				   vo.setOno(rs.getInt(1));
				   vo.setNo(rs.getInt(2));
				   vo.setTitle(rs.getString(3));
				   vo.setPoster(rs.getString(4));
				   vo.setPrice(rs.getString(5));
				   vo.setQuantity(rs.getInt(6));
				   vo.setRegdate(rs.getString(7).substring(0,rs.getString(7).indexOf(" ")));
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