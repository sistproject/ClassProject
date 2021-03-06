package com.sist.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;

import com.sist.freeboard.freeBoardDAO;
import com.sist.freeboard.freeBoardVO;
import com.sist.member.memberVO;
import com.sist.vo.BoardVO;
import com.sist.vo.CartVO;
import com.sist.vo.CouponVO;
import com.sist.vo.MemberVO;
import com.sist.vo.OnlineVO;

import javax.naming.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
   public String isLogin(String id,String pwd,HttpServletRequest request) {
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
			   sql="SELECT pwd,name,admin FROM member "
				  +"WHERE id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   String name=rs.getString(2);
			   int admin=rs.getInt(3);
			   rs.close();
			   
			   if(db_pwd.equals(pwd)) {
				   result=name;
				   if(admin==1) {
					   HttpSession session = request.getSession();
					   session.setAttribute("admin", "1");
				   }
			   }
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
   public void jjim(String id, int no,String type) {
	   try {
		   getConnection();
		   String sql="SELECT COUNT(*) FROM jjim where id=? and c_no=?";
		   if(type.equals("w")) sql="SELECT COUNT(*) FROM jjim where id=? and w_no=?";
		   ps=conn.prepareStatement(sql);

		   ps.setString(1, id);
		   ps.setInt(2, no);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   int count=rs.getInt(1);
		   System.out.println(count);
		   rs.close();
		   if(count==0) {
			   sql="INSERT INTO jjim(no,id,c_no) VALUES("
					   +"jjim_no_seq.nextval,?,?)";
			   if(type.equals("w")) sql="INSERT INTO jjim(no,id,w_no) VALUES(jjim_no_seq.nextval,?,?)";
			   ps=conn.prepareStatement(sql);
			   
			   ps.setString(1, id);
			   ps.setInt(2, no);
			   ps.executeUpdate();
		   }else {
			   sql="DELETE FROM jjim WHERE id=? AND c_no=?";
			   if(type.equals("w")) sql="DELETE FROM jjim WHERE id=? AND w_no=?";
			   ps=conn.prepareStatement(sql);
			   
			   ps.setString(1, id);
			   ps.setInt(2, no);
			   ps.executeUpdate();
		   }
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   disConnection();
	   }
   }
   public List<BoardVO> mypost(String id, int page) {
	   List<BoardVO> list = new ArrayList<BoardVO>();
	   try {
		   getConnection();
//		   String sql="SELECT bno,id,btitle,bcontent,hits,regdate FROM board where id=?";
		   
		   
		   String sql = "SELECT bno,id,btitle,bcontent,hits,regdate num "
					+ "FROM (SELECT bno,id,btitle,bcontent,hits,regdate, rownum as num "
					+ "FROM (SELECT bno,id,btitle,bcontent,hits,regdate "
					+ "FROM board ORDER BY bno DESC)) "
					+ "WHERE num BETWEEN ? AND ? AND id = ?";
		   ps=conn.prepareStatement(sql);
		   int rowSize = 12;
		   int start = (rowSize * page) - (rowSize - 1);
		   int end = rowSize * page;
		   
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   ps.setString(3, id);
			
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
		   BoardVO vo = new BoardVO();
		   vo.setBno(rs.getInt(1));
		   vo.setId(rs.getString(2));
		   vo.setTitle(rs.getString(3));
		   vo.setContent(rs.getString(4));
		   vo.setHits(rs.getInt(5));
		   vo.setRegdate(rs.getString(6));
		   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   disConnection();
	   }
	   return list;
   }
   
// 온라인 클래스 메인페이지 총 갯수
		public int boardCount() {
			int count = 0;
			try {
				getConnection();
				String sql = "SELECT COUNT(*) FROM board";
				ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				rs.next();
				count = rs.getInt(1);
				rs.close();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				disConnection(); 
				
			}
			return count;
			
		}
   
   
   
   public List<CouponVO> mycoupon(String id) {
	   List<CouponVO> list = new ArrayList<CouponVO>();
	   try {
		   getConnection();
		   String sql="SELECT id,name,type,amount,createAt FROM coupon where id=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, id);
		   
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			   CouponVO vo = new CouponVO();
			   vo.setId(rs.getString(1));
			   vo.setName(rs.getString(2));
			   vo.setType(rs.getString(3));
			   vo.setAmount(rs.getInt(4));
			   vo.setCreatAt(rs.getString(5));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   disConnection();
	   }
	   return list;
   }
   public List<CartVO> myjjim(String id) {
	   List<CartVO> list = new ArrayList<CartVO>();
	   try {
		   getConnection();
		   String sql="SELECT w.w_title,w.w_artist,w.w_poster,w.w_price,w.w_no "
			   		+ "FROM jjim j,member m,thiswork w "
			   		+ "WHERE m.id = j.id AND w.w_no=j.w_no AND m.id=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, id);
		   ResultSet rs = ps.executeQuery();
		   while(rs.next()) {
			   CartVO vo = new CartVO();
			   vo.setTitle(rs.getString(1));
			   vo.setArtist(rs.getString(2));
			   vo.setPoster(rs.getString(3));
			   vo.setPrice(rs.getString(4));
			   vo.setNo(rs.getInt(5));
			   vo.setType("w");
			   list.add(vo);
		   }
		   sql="SELECT c.c_title,c.c_artist,c.c_poster,c.c_price,c.c_no,c.c_onoff "
				   + "FROM jjim j,member m,thisclass c "
				   + "WHERE m.id = j.id AND c.c_no=j.c_no AND m.id=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, id);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   CartVO vo = new CartVO();
			   vo.setTitle(rs.getString(1));
			   vo.setArtist(rs.getString(2));
			   if(rs.getString(3).contains("^")) vo.setPoster(rs.getString(3).substring(0, rs.getString(3).indexOf("^")));
			   else vo.setPoster(rs.getString(3));
			   vo.setPrice(rs.getString(4));
			   vo.setNo(rs.getInt(5));
			   vo.setOnoff(rs.getInt(6));
			   vo.setType("c");
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   disConnection();
	   }
	   return list;
   }
}








