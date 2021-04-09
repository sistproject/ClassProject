package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.OnlineReplyVO;
import com.sist.vo.OnlineVO;

import java.util.*;

public class OnlineDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static OnlineDAO dao;

	// 미리 만들어진 객체주소를 얻어온다 (Connection)
	public void getConnection() {
		try {
			Context init = new InitialContext();
			Context c = (Context) init.lookup("java://comp/env");
			DataSource ds = (DataSource) c.lookup("jdbc/oracle");
			conn = ds.getConnection();
		} catch (Exception ex) {

		}
	}

	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
		}
	}

	public static OnlineDAO newInstance() {
		if (dao == null)
			dao = new OnlineDAO();
		return dao;
	}
	// 온라인 클래스 메인페이지 데이터 리스튼
	public List<OnlineVO> onlineData(int page) {
		List<OnlineVO> list = new ArrayList<OnlineVO>();
		try {// c_no, c_title, c_artist, c_price, c_poster, c_content
			getConnection();
			String sql = "SELECT c_no, c_title, c_poster, c_artist, c_price, c_content, num "
						+ "FROM (SELECT c_no, c_title, c_poster, c_artist, c_price, c_content, rownum as num "
						+ "FROM (SELECT c_no, c_title, c_poster, c_artist, c_price, c_content "
						+ "FROM thisclass ORDER BY c_no asc)) "
						+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			int rowSize = 12;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;
			ps.setInt(1, start+13365);
			ps.setInt(2, end+13365);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OnlineVO vo = new OnlineVO();
				vo.setCno(rs.getInt(1));
				vo.setCtitle(rs.getString(2));
				vo.setCposter(rs.getString(3));
				vo.setCartist(rs.getString(4));
				vo.setCprice(rs.getString(5));
				vo.setCcontent(rs.getString(6));
//				vo.setCscore(rs.getDouble(7));
				list.add(vo);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
	
	// 온라인 클래스 메인페이지 총 갯수
	public int onlineMainCount() {
		int count = 0;
		try {
			getConnection();
			String sql = "SELECT COUNT(*) FROM class";
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
	
	// 온라인 클래스 디테일 페이지 데이터
	public OnlineVO onlineDetailData(int cno) {
		OnlineVO vo = new OnlineVO();
		try {
			getConnection();
			String sql = "SELECT c_no, c_title, c_poster, c_artist, c_price, c_content, c_score,c_hit "
						+ "FROM thisclass "
						+ "WHERE c_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setCno(rs.getInt(1));
			vo.setCtitle(rs.getString(2));
			vo.setCposter(rs.getString(3));
			vo.setCartist(rs.getString(4));
			vo.setCprice(rs.getString(5));
			vo.setCcontent(rs.getString(6));
			vo.setCscore(rs.getDouble(7));
			vo.setChit(rs.getInt(8));
			
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		
		return vo;
		
	}
	
    // 댓글 읽기
    public List<OnlineReplyVO> onlineReplyReadData(int cno)
    {
   	 List<OnlineReplyVO> list=new ArrayList<OnlineReplyVO>();
   	 try
   	 {
   		 // 연결
   		 getConnection();
   		 String sql="SELECT no,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') "
   				   +"FROM online_reply "
   				   +"WHERE cno=? "
   				   + "ORDER BY no DESC";
   		 ps=conn.prepareStatement(sql);
   		 ps.setInt(1, cno);
   		 ResultSet rs=ps.executeQuery();
   		 while(rs.next())
   		 {
   			OnlineReplyVO vo=new OnlineReplyVO();
   			 vo.setNo(rs.getInt(1));
   			 vo.setId(rs.getString(2));
   			 vo.setName(rs.getString(3));
   			 vo.setMsg(rs.getString(4));
   			 vo.setDbday(rs.getString(5));
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
	
	
	
	
	// 댓글 올리기
    public void OnlineReplyInsert(OnlineReplyVO vo)
    {
   	 try
   	 {System.out.println("=======================시도");
   		 getConnection();
   		 String sql="INSERT INTO online_reply(no,cno,id,name,msg,regdate) VALUES(on_no_seq.nextval,?,?,?,?,SYSDATE)";
   		 ps=conn.prepareStatement(sql);
   		 System.out.println("===============================sql준비");
   		 ps.setInt(1, vo.getCno());
   		 System.out.println("================"+vo.getCno());
   		 ps.setString(2, vo.getId());
   		 System.out.println("================="+vo.getId());
   		 ps.setString(3, vo.getName());
   		 System.out.println("==============="+vo.getName());
   		 ps.setString(4, vo.getMsg());
   		 System.out.println("================="+vo.getMsg());
   		 
   		 // 실행
   		 ps.executeUpdate();
   		 System.out.println("===========================업데이트 성공");
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
    public void onlineReplyUpdate(OnlineReplyVO vo)
    {
   	 try
   	 {
   		 getConnection();
   		 String sql="UPDATE online_reply SET "
   				   +"msg=? "
   				   +"WHERE no=?";
   		 ps=conn.prepareStatement(sql);
   		 ps.setString(1, vo.getMsg());
   		 ps.setInt(2, vo.getNo());
   		 
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
    public void onlineReplyDelete(int no)
    {
   	 try
   	 {
   		 getConnection();
   		 String sql="DELETE FROM online_reply "
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
    
    // 찜하기
    public void onlineJjimInsert(int cno,int wno, String id)
    {
   	 try
   	 {
   		 getConnection();
   		 String sql="INSERT INTO offclass_jjim VALUES("
   				   +"oj_no_seq.nextval,?,?,?)";
   		 ps=conn.prepareStatement(sql);
   		 ps.setInt(3, wno);
   		 ps.setInt(2, cno);
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
    
    
 // cookie에 출력할 데이터 
    public OnlineVO onlineCookiePrintData(int cno)
    {
    	OnlineVO vo=new OnlineVO();
 	   try
 	   {
 		   getConnection();
 		   String sql="SELECT c_no,c_poster,c_title "
 				     +"FROM thisclass "
 				     +"WHERE c_no=?";
 		   ps=conn.prepareStatement(sql);
 		   ps.setInt(1, cno);
 		   // 실행
 		   ResultSet rs=ps.executeQuery();
 		   rs.next();
 		   vo.setCno(rs.getInt(1));
 		   String s=rs.getString(2);
 		   vo.setCposter(s.substring(0,s.indexOf("^")));
 		   vo.setCtitle(rs.getString(3));
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
    public List<OnlineVO> onlineSearchData(String word) {
		List<OnlineVO> list = new ArrayList<OnlineVO>();
		try {// c_no, c_title, c_artist, c_price, c_poster, c_content
			getConnection();
			String sql = "SELECT c_no, c_title, c_poster, c_artist, c_price, c_content "
						+ "FROM thisclass "
						+ "WHERE c_no>13365 AND REGEXP_LIKE(c_title,?)  ORDER BY c_no asc";

			ps = conn.prepareStatement(sql);
 			ps.setString(1, word);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OnlineVO vo = new OnlineVO();
				vo.setCno(rs.getInt(1));
				vo.setCtitle(rs.getString(2));
				vo.setCposter(rs.getString(3));
				vo.setCartist(rs.getString(4));
				vo.setCprice(rs.getString(5));
				vo.setCcontent(rs.getString(6));
//				vo.setCscore(rs.getDouble(7));
				list.add(vo);
			}
			rs.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
	
	

}
