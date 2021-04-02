package com.sist.dao;
import java.sql.*;
import javax.sql.*;
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
			   
			   if(db_pwd.equals(pwd)) {
				   result=name;
			   }
			   else {
				   result="NOPWD";
			   }
		   }
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	   finally {
		   disConnection();
	   }
	   System.out.println(result);
	   return result;
   }
}








