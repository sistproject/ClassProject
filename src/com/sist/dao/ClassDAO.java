package com.sist.dao;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

import com.sist.vo.OffClassVO;


public class ClassDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static ClassDAO dao;
	
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

	public static ClassDAO newInstance() {
		if (dao == null)
			dao = new ClassDAO();
		return dao;
	}
	
	public List<OffClassVO> trendListData(int page){
		List<OffClassVO> list = new ArrayList<OffClassVO>();
		try {
			getConnection();
			String sql = "SELECT c_no, c_title, c_poster, c_category, c_artist, c_price, infoaddr, c_score, c_hit, num "
					+ "FROM (SELECT c_no, c_title, c_poster, c_category, c_artist, c_price, infoaddr, c_score, c_hit, rownum as num "
					+ "FROM (SELECT c_no, c_title, c_poster, c_category, c_artist, c_price, infoaddr, c_score, c_hit "
					+ "FROM thisclass ORDER BY c_hit DESC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			int rowSize = 12;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OffClassVO vo = new OffClassVO();
				vo.setCno(rs.getInt(1));
				vo.setCtitle(rs.getString(2));
				vo.setCposter(rs.getString(3));
				vo.setCartist(rs.getString(4));
				vo.setCprice(rs.getString(5));
				vo.setInfoaddr(rs.getString(6));
				vo.setCscore(rs.getDouble(7));
				vo.setChit(rs.getInt(8));
				list.add(vo);
			}
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
	public int allCount() {
		int count = 0;
		try {
			getConnection();
			String sql = "SELECT COUNT(*) FROM thisclass";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return count;
	}
}
