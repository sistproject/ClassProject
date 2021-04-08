package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.sist.vo.*;

import java.util.*;

public class BoardDAO {
	   private Connection conn;
	   private PreparedStatement ps;
	   private static BoardDAO dao;
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
	   public static BoardDAO newInstance() {
		   if(dao==null)
			   dao=new BoardDAO();
		   return dao;
	   }
	   public int boardRowCount(int isfree) {
			  int count=0;
			  try {
				  getConnection();
				  String sql="SELECT COUNT(*) FROM board WHERE isfree=?";
				  ps=conn.prepareStatement(sql);
				  ps.setInt(1, isfree);
				  ResultSet rs=ps.executeQuery();
				  rs.next();
				  count=rs.getInt(1);
				  rs.close();
			  }catch(Exception ex) {
				  ex.printStackTrace();
			  } finally {
				  disConnection();
			  }
			  return count;
		  }
	   public List<BoardVO> boardPage(int page) {
		   List<BoardVO> list=new ArrayList<BoardVO>();
		   int count=0;
		   try {
			   getConnection();
			   String sql="SELECT id,btitle,bcontent,hits,regdate,bno,num "
				  		+"FROM (SELECT id,btitle,bcontent,hits,regdate,bno,rownum as num "
					    +"FROM (SELECT id,btitle,bcontent,hits,regdate,bno "
					    +"FROM board WHERE isfree=1 ORDER BY bno DESC)) "
					    +"WHERE num BETWEEN ? AND ?";
			   ps=conn.prepareStatement(sql);
			  int rowSize=10;
			  int start=(rowSize*page)-(rowSize-1); 
			  int end=rowSize*page;
			
			  ps.setInt(1, start);
			  ps.setInt(2, end);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()) {
				  BoardVO vo=new BoardVO();
				  vo.setId(rs.getString(1));
				  vo.setTitle(rs.getString(2));
				  vo.setContent(rs.getString(3));
				  vo.setHits(rs.getInt(4));
				  vo.setRegdate(rs.getString(5));
				  vo.setBno(rs.getInt(6));
				  list.add(vo);
			  }
				  rs.close();
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  } finally {
			  disConnection();
		  }
		  return list;
	   }
	   public List<BoardVO> freeboardList() {
		   List<BoardVO> list=new ArrayList<BoardVO>();
		   try {
			   
			  getConnection();
			  String sql="SELECT id,btitle,bcontent,hits,regdate,bno "
			  		+ "FROM board WHERE isfree=1 ORDER BY bno DESC";
			  ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()) {
				  BoardVO vo=new BoardVO();
				  vo.setId(rs.getString(1));
				  vo.setTitle(rs.getString(2));
				  vo.setContent(rs.getString(3));
				  vo.setHits(rs.getInt(4));
				  vo.setRegdate(rs.getString(5));
				  vo.setBno(rs.getInt(6));
				  list.add(vo);
			  }
			  rs.close();
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  } finally {
			  disConnection();
		  }
		  return list;
	   }
	   public List<BoardVO> qaBoardList() {
		   List<BoardVO> list=new ArrayList<BoardVO>();
		   try {
			   
			   getConnection();
			   String sql="SELECT id,btitle,bcontent,btype,wno,hits,regdate,bno,w.w_poster,w.w_title "
			   		+ "FROM board b,thiswork w WHERE b.wno=w.w_no AND isfree=0 ORDER BY bno DESC";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   BoardVO vo=new BoardVO();
				   vo.setId(rs.getString(1));
				   vo.setTitle(rs.getString(2));
				   vo.setContent(rs.getString(3));
				   vo.setType(rs.getString(4));
				   vo.setWno(rs.getInt(5));
				   vo.setHits(rs.getInt(6));
				   vo.setRegdate(rs.getString(7));
				   vo.setBno(rs.getInt(8));
				   vo.setPoster(rs.getString(9));
				   vo.setAdd(rs.getString(10));
				   list.add(vo);
			   }
			   sql="SELECT id,btitle,bcontent,btype,cno,hits,regdate,bno,c.c_poster,c.c_title "
				   		+ "FROM board b,thisclass c WHERE b.cno=c.c_no and b.isfree=0";
			   ps=conn.prepareStatement(sql);
			   rs=ps.executeQuery();
			   while(rs.next()) {
				   BoardVO vo=new BoardVO();
				   vo.setId(rs.getString(1));
				   vo.setTitle(rs.getString(2));
				   vo.setContent(rs.getString(3));
				   vo.setType(rs.getString(4));
				   vo.setCno(rs.getInt(5));
				   vo.setHits(rs.getInt(6));
				   vo.setRegdate(rs.getString(7));
				   vo.setBno(rs.getInt(8));
				   if(rs.getString(9).contains("^")) vo.setPoster(rs.getString(9).substring(0,rs.getString(9).indexOf("^")));
				   else vo.setPoster(rs.getString(9));
				   vo.setAdd(rs.getString(10));
				   list.add(vo);
			   }
			   sql="SELECT id,btitle,bcontent,btype,hits,regdate,bno "
					   + "FROM board WHERE isfree=0 and btype is null";
			   ps=conn.prepareStatement(sql);
			   rs=ps.executeQuery();
			   while(rs.next()) {
				   BoardVO vo=new BoardVO();
				   vo.setId(rs.getString(1));
				   vo.setTitle(rs.getString(2));
				   vo.setContent(rs.getString(3));
				   vo.setType(rs.getString(4));
				   vo.setHits(rs.getInt(5));
				   vo.setRegdate(rs.getString(6));
				   vo.setBno(rs.getInt(7));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   } finally {
			   disConnection();
		   }
		   Comparator<BoardVO> sortByBno = new Comparator<BoardVO>() {
				@Override
				public int compare(BoardVO o1, BoardVO o2) {
					return o2.getBno() - o1.getBno();
				}
		   };
		   Collections.sort(list,sortByBno);
		   return list;
	   }
	   public List<BoardVO> boardDelete(int no) {
		   List<BoardVO> list=new ArrayList<BoardVO>();
		   try {
			   
			   getConnection();
			   String sql="DELETE FROM board WHERE bno=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   } finally {
			   disConnection();
		   }
		   return list;
	   }
	   public void boardInsert(BoardVO vo) {
		   try {
			   getConnection();
			   String sql="INSERT INTO board(bno,id,btitle,bcontent,isfree,btype,regdate,hits,wno) "
			   		+ "VALUES(board_SEQ.nextval,?,?,?,?,?,sysdate,0,?)";
			   if(vo.getType()!=null){
				   if(vo.getType().equals("c")) {
				   sql="INSERT INTO board(bno,id,btitle,bcontent,isfree,btype,regdate,hits,cno) "
					   		+ "VALUES(board_SEQ.nextval,?,?,?,?,?,sysdate,0,?)";
				   }
				   else if(vo.getType().equals("a")) {
					   System.out.println("e답변");
					   sql="INSERT INTO board(bno,id,btitle,bcontent,isfree,btype,regdate,hits,root) "
						   		+ "VALUES(board_SEQ.nextval,?,?,?,?,?,sysdate,0,?)";
					   
				   }
			   }
			   
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getId());
			   ps.setString(2, vo.getTitle());
			   ps.setString(3, vo.getContent());
			   ps.setInt(4, vo.getIsFree());
			   ps.setString(5, vo.getType());
			   if(vo.getType()!=null) {
				   if(vo.getType().equals("c")) ps.setInt(6, vo.getCno());
				   else if(vo.getType().equals("w")) ps.setInt(6, vo.getWno());
				   else ps.setInt(6, vo.getRoot());
			   }
			   else ps.setInt(6, vo.getCno());
			   ps.executeUpdate();
			   System.out.println("성공");
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   } finally {
			   disConnection();
		   }
	   }
	   public void boardUpdate(BoardVO vo) {
		   try {
			   getConnection();
			   String sql="UPDATE board SET id=?,btitle=?,bcontent=? WHERE bno=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getId());
			   ps.setString(2, vo.getTitle());
			   ps.setString(3, vo.getContent());
			   ps.setInt(4, vo.getBno());

			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   } finally {
			   disConnection();
		   }
	   }
	   public void hit(int no) {
		   try {
			   getConnection();
			   String sql="UPDATE board SET hits=hits+1 WHERE bno=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1,no);
			   ps.executeUpdate();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   } finally {
			   disConnection();
			   
		   }
	   }
	   public String additional(int no,String wc) {
		   String title="";
		   try {
			   getConnection();
			   String sql="SELECT c_title FROM thisclass WHERE c_no=?";
			   if(wc.equals("w")) sql="SELECT w_title FROM thiswork WHERE w_no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1,no);
			   ResultSet rs = ps.executeQuery();
			   rs.next();
			   title=rs.getString(1);
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   } finally {
			   disConnection();
			   
		   }
		   return title;
	   }
	   public List<BoardVO> answerBoard() {
		   List<BoardVO> list = new ArrayList<BoardVO>();
		   try {
			   getConnection();
			   String sql="SELECT id,btitle,bcontent,hits,regdate,bno,root FROM board WHERE btype='a'";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   BoardVO vo = new BoardVO();
				   vo.setId(rs.getString(1));
				   vo.setTitle(rs.getString(2));
		 		   vo.setContent(rs.getString(3));
				   vo.setHits(rs.getInt(4));
				   vo.setRegdate(rs.getString(5));
				   vo.setBno(rs.getInt(6));
				   vo.setRoot(rs.getInt(7));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   } finally {
			   disConnection();
			   
		   }
		   return list;
	   }
	   
		
		
		
	   
	   
	   
	   

}
