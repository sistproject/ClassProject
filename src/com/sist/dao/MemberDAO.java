package com.sist.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;

import com.sist.member.memberVO;
import com.sist.vo.MemberVO;

import javax.naming.*;
public class MemberDAO {
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
   public void insertMember(String name,String id,String pwd,String email) {
	   try {
		   System.out.println(name+" "+id+" "+ email+" "+pwd);
		   getConnection();
		   String sql="INSERT INTO member(name,id,pwd,email) VALUES(?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, name);
		   ps.setString(2, id);
		   ps.setString(3, pwd);
		   ps.setString(4, email);
		   
		   ps.executeUpdate();	
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	   finally {
		   disConnection();
	   }
   }
   public int idCheck(String id) {
	   int cnt = 0;
	   try {
		  getConnection();
		  String sql = "SELECT COUNT(*) FROM member WHERE id=?";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1, id);
		  ResultSet rs=ps.executeQuery();
		  rs.next();
		  cnt = rs.getInt(1);
		  rs.close();
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   disConnection();
	   }
	   return cnt;
   }
   public String isLogin(String id,String pwd) {
	   String result="";
	   try {
		   getConnection();
		   String sql="SELECT COUNT(*) FROM member WHERE id=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, id);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   int count=rs.getInt(1);
		   rs.close();
		   if(count==0) {// ID가 없는 상태
			   result="NOID";
		   } else {// ID가 존재하는 상태
			   sql="SELECT pwd,name FROM member "
				  +"WHERE id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   String name=rs.getString(2);
			   rs.close();
			   
			   if(db_pwd.equals(pwd)) result=name;
			   else result="NOPWD";
		   }
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	   finally {
		   disConnection();
	   }
	   return result;
   }
   /*
	ADMIN             NUMBER         
	NAME     NOT NULL VARCHAR2(100)  
	ID       NOT NULL VARCHAR2(34)   
	PWD      NOT NULL VARCHAR2(15)   
	TEL               VARCHAR2(15)   
	EMAIL    NOT NULL VARCHAR2(100)  
	POST              VARCHAR2(200)  
	ADDRESS1          VARCHAR2(2000) 
	ADDRESS2          VARCHAR2(2000) 
	SEX               VARCHAR2(3)    
	BIRTH             DATE  
*/
   public MemberVO memberDetailData(String id) {
	   MemberVO vo = new MemberVO();
	   try {
		  getConnection();
		  String sql = "SELECT name,id,email,tel,post,address1,address2,sex,birth,pwd FROM member WHERE id=?";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1, id);
		  ResultSet rs=ps.executeQuery();
		  
		  rs.next();
		  vo.setName(rs.getString(1));
		  vo.setId(rs.getString(2));
		  vo.setEmail(rs.getString(3));
		  vo.setTel(rs.getString(4));
		  vo.setPost(rs.getString(5));
		  vo.setAddr1(rs.getString(6));
		  vo.setAddr2(rs.getString(7));
		  vo.setSex(rs.getString(8));
		  vo.setBirth(rs.getString(9));
		  vo.setPwd(rs.getString(10));
		  
		  rs.close();
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   disConnection();
	   }
	   return vo;
   }

   public MemberVO memberUpdateData(MemberVO vo) {
	   try {
		  getConnection();
		  String sql = "UPDATE member SET name=?, pwd=?, email=?, tel=?, post=?, address1=?, address2=?, sex=?, birth=? WHERE id=?";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1, vo.getName());
		  ps.setString(2, vo.getPwd());
		  ps.setString(3, vo.getEmail());
		  ps.setString(4, vo.getTel());
		  ps.setString(5, vo.getPost());
		  ps.setString(6, vo.getAddr1());
		  ps.setString(7, vo.getAddr2());
		  ps.setString(8, vo.getSex());
		  ps.setString(9,vo.getBirth());
		  ps.setString(10, vo.getId());
		  
		  ps.executeUpdate();
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   disConnection();
	   }
	   return vo;
   }
}








