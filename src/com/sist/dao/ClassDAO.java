package com.sist.dao;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

import com.sist.vo.MemberVO;
import com.sist.vo.OffClassVO;
import com.sist.vo.OnlineVO;
import com.sist.vo.WorkDetailVO;
import com.sist.vo.WorkVO;


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
				vo.setCcategory(rs.getString(4));
				vo.setCartist(rs.getString(5));
				vo.setCprice(rs.getString(6));
				vo.setInfoaddr(rs.getString(7));
				vo.setCscore(rs.getDouble(8));
				vo.setChit(rs.getInt(9));
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
	
	public int getCategoryCount() {
		int num = 0;
		try {
			getConnection();
			String sql = "SELECT COUNT(DISTINCT c_category) "
					+ "FROM thisclass "
					+ "WHERE c_category IS NOT NULL";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			num = rs.getInt(1);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return num;
	}
	public List<String> getCategory(){
		List<String> cList = new ArrayList<String>();
		try {
			getConnection();
			String sql = "SELECT DISTINCT c_category FROM thisclass WHERE c_category IS NOT NULL";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String cat = rs.getString(1);
				cList.add(cat);
			}
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return cList;
	}
	
	public MemberVO getWriterInfo(String id){
		MemberVO vo = new MemberVO();
		try {
			getConnection();
			String sql = "SELECT name, address1, address2 "
					+ "FROM member "
					+ "WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setName(rs.getString(1));
			vo.setAddr1(rs.getString(2));
			vo.setAddr2(rs.getString(3));
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}
	
	public int getClassMaxNum() {
		int num=0;
		try {
			getConnection();
			String sql = "SELECT MAX(c_no)+1 FROM thisclass";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			num = rs.getInt(1);
			System.out.println("num:"+num);
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return num;
	}
	public int getWorkMaxNum() {
		int num=0;
		try {
			getConnection();
			String sql = "SELECT MAX(w_no)+1 FROM thiswork";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			num = rs.getInt(1);
			System.out.println("num:"+num);
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return num;
	}
	public int InsertWork(WorkDetailVO vo) {
		int no=0;
		try {
			no = getWorkMaxNum();
			getConnection();
			String sql = "INSERT INTO thiswork(w_no, w_title, w_content, w_poster, w_price, w_artist, w_regdate) "
					+ "VALUES(? , ?, ?, ?, ?, ?, SYSDATE)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, vo.getW_title());
			ps.setString(3, vo.getW_content());
			ps.setString(4, vo.getW_poster());
			ps.setString(5, vo.getW_price());
			ps.setString(6, vo.getW_artist());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return no;
	}
	public int InsertOnline(OnlineVO vo) {
		int no=0;
		try {
			System.out.println("insert 시작");
			no = getClassMaxNum();
			getConnection();

			String sql = "INSERT INTO thisclass(c_no, c_title, c_content, c_poster, c_price, "
					+ "c_artist, c_onoff, c_category) "
					+ "VALUES(?, ?, ?, ?, ?, ?, 0, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, vo.getCtitle());
			ps.setString(3, vo.getCcontent());
			ps.setString(4, vo.getCposter());
			ps.setString(5, vo.getCprice());
			ps.setString(6, vo.getCartist());
			ps.setString(7, vo.getCcategory());
			ps.executeUpdate();
			System.out.println("insert 완료");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return no;
	}
	public int InsertOffline(OffClassVO vo) {
		int no=0;
		try {
			no = getClassMaxNum();
			getConnection();

			String sql = "INSERT INTO thisclass(c_no, c_title, c_content, c_poster, c_price, "
					+ "c_artist, c_address, c_onoff, c_time, c_category) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, 0, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, vo.getCtitle());
			ps.setString(3, vo.getCcontent());
			ps.setString(4, vo.getCposter());
			ps.setString(5, vo.getCprice());
			ps.setString(6, vo.getCartist());
			ps.setString(7, vo.getCaddress());
			ps.setString(8, vo.getCtime());
			ps.setString(9, vo.getCcategory());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return no;
	}
}
