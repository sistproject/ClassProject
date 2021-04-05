package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
			String sql = "SELECT c_no, c_title, c_poster, c_artist, c_price, c_content num "
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
	public List<OnlineVO> onlineDetailData(int cno) {
		List<OnlineVO> list = new ArrayList<OnlineVO>();
		try {
			getConnection();
			String sql = "SELECT c_no, c_title, c_poster, c_artist, c_price "
						+ "FROM class "
						+ "WHERE c_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
			ResultSet rs = ps.executeQuery();
			rs.next();
			OnlineVO vo = new OnlineVO();
			vo.setCno(rs.getInt(1));
			vo.setCtitle(rs.getString(2));
			vo.setCposter(rs.getString(3));
			vo.setCartist(rs.getString(4));
			vo.setCprice(rs.getString(5));
			list.add(vo);
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		
		return list;
		
	}
	
	

}
