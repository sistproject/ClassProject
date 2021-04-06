package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.sist.vo.WorkDetailVO;
import com.sist.vo.WorkVO;

import java.util.*;

public class WorkDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static WorkDAO dao;

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

	public static WorkDAO newInstance() {
		if (dao == null)
			dao = new WorkDAO();
		return dao;
	}
	// 작품 메인페이지 데이터 리스트
	public List<WorkVO> WorkMainData() {
		List<WorkVO> list = new ArrayList<WorkVO>();
		try {
			getConnection();
			String sql = "SELECT w_no,w_poster,w_artist,w_title "
					+ "FROM thiswork "
					+ "ORDER BY w_no ASC";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WorkVO vo=new WorkVO();
				vo.setW_no(rs.getInt(1));
				vo.setW_poster(rs.getString(2));
				vo.setW_artist(rs.getString(3));
				vo.setW_title(rs.getString(4));

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
	
	// work => cookie에 출력할 데이터 
	   public WorkDetailVO foodCookiePrintData(int w_no)
	   {
		   WorkDetailVO vo=new WorkDetailVO();
		   try
		   {
			   getConnection();
			   String sql="SELECT w_no,w_poster,w_title "
					     +"FROM thiswork "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, w_no);
			   // 실행
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setW_no(rs.getInt(1));
			   vo.setW_poster(rs.getString(2));
			   vo.setW_title(rs.getString(3));
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
	
	// 작품 상세 페이지 
	public WorkDetailVO WorkDetailData(int w_no)
	{
		WorkDetailVO vo=new WorkDetailVO();
		try
		{
				
				/*
				 *  W_NO       NOT NULL NUMBER         
					W_TITLE             VARCHAR2(200)  
					W_CONTENT           VARCHAR2(4000) 
					W_POSTER            VARCHAR2(2000) 
					W_PRICE             VARCHAR2(200)  
					W_ARTIST            VARCHAR2(200)  
					W_POINT             NUMBER         
					W_DELIVERY          VARCHAR2(300)  
					W_SCORE             NUMBER(2,1)    
					W_TAG               VARCHAR2(3000) 
					W_LIKE              NUMBER         
					W_PURCHASE          NUMBER         
					W_HIT               NUMBER         
					W_REGDATE           DATE           
					CATL_NO             NUMBER         
				
				 */
			getConnection();
			String sql="SELECT w_no,w_title,w_content,w_poster,w_price,w_artist,w_point,"
					+ "w_delivery,w_score,w_tag,w_like,w_purchase,w_hit,w_regdate,cal_no "
					+ "FROM thiswork "
					+ "WHERE w_no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, w_no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setW_no(rs.getInt(1));
			vo.setW_title(rs.getString(2));
			vo.setW_content(rs.getString(3));
			vo.setW_poster(rs.getString(4));
			vo.setW_price(rs.getString(5));
			vo.setW_artist(rs.getString(6));
			vo.setW_point(rs.getInt(7));
			vo.setW_delivery(rs.getString(8));
			vo.setW_score(rs.getDouble(9));
			vo.setW_tag(rs.getString(10));
			vo.setW_like(rs.getInt(11));
			vo.setW_purchase(rs.getInt(12));
			vo.setW_hit(rs.getInt(13));
			vo.setW_regdate(rs.getDate(14));
			vo.setCatl_no(rs.getInt(15));
			
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
	
	// 작품 리스트
		public List<WorkDetailVO> WorkListData(int page) {
			List<WorkDetailVO> list = new ArrayList<WorkDetailVO>();
			try {
				getConnection();
				String sql="SELECT w_no,w_title,w_poster,w_artist,num "
						+ "FROM (SELECT w_no,w_title,w_poster,w_artist,rownum as num "
						+ "FROM (SELECT w_no,w_title,w_poster,w_artist "
						+ "FROM thiswork ORDER BY dbms_random.random())) "
						+ "WHERE num BETWEEN ? AND ?";
				ps = conn.prepareStatement(sql);
				int rowSize = 12;
				int start = (rowSize * page) - (rowSize - 1);
				int end = rowSize * page;
				ps.setInt(1, start);
				ps.setInt(2, end);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					WorkDetailVO vo = new WorkDetailVO();
					vo.setW_no(rs.getInt(1));
					vo.setW_title(rs.getString(2));
					vo.setW_poster(rs.getString(3));
					vo.setW_artist(rs.getString(4));
					
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
		
		// 작품 메인페이지 총 갯수
		public int WorkMainCount() {
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
		
		// 쿠키
		public WorkVO WorkCookiePrintData(int no)
		   {
			   WorkVO vo=new WorkVO();
			   try
			   {
				   getConnection();
				   String sql="SELECT no,poster,title "
						     +"FROM food_house "
						     +"WHERE no=?";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, no);
				   // 실행
				   ResultSet rs=ps.executeQuery();
				   rs.next();
				   vo.setW_no(rs.getInt(1));
				   String s=rs.getString(2);
				   vo.setW_poster(s.substring(0,s.indexOf("^")));
				   vo.setW_title(rs.getString(3));
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
}















