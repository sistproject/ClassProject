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
	private static CartDAO dao;

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

	public static CartDAO newInstance() {
		if (dao == null)
			dao = new CartDAO();
		return dao;
	}
	
	public List<OnlineVO> onlineData(int index) {
		List<OnlineVO> list=new ArrayList<OnlineVO>();
		 try
		 {
			 getConnection();
			 int start=0;
			 int end=0;
			 if(index==1)
			 {
				 start=1;
				 end=12;
			 }
			 else if(index==2)
			 {
				 start=13;
				 end=18;
			 }
			 else
			 {
				 start=19;
				 end=30;
				 
			 }
			 String sql="SELECT * FROM class "
					   +"WHERE no BETWEEN ? AND ?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, start);
			 ps.setInt(2, end);
			 
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 OnlineVO vo=new OnlineVO();
				 vo.setCno(rs.getInt(1));
				 vo.setCposter(rs.getString(2));
				 vo.setCtitle(rs.getString(3));
				 vo.setCartist(rs.getString(4));
				 vo.setCprice(rs.getString(5));
				 
				 
				 
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
	
	
	
}
