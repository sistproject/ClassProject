package com.sist.jun;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.dao.CartDAO;
import com.sist.jdbc.DAOManager;
import com.sist.jun.OnlineVO;
import com.sist.vo.WorkVO;

public class OnlineDAO {
	private DAOManager dm = new DAOManager();
	private Connection conn;
	private PreparedStatement ps;
	public void onlineDataInsert(OnlineVO vo) {
		 try {
			 conn=dm.getConnection();
			 String sql = "INSERT INTO thisclass(c_no, c_title, c_artist, c_price, c_onoff, c_poster, c_content) VALUES "
				+ "((SELECT NVL(MAX(c_no)+1,1) FROM thisclass),?,?,?,0,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getCtitle());
				ps.setString(2, vo.getCartist());
				ps.setString(3, vo.getCprice());
				ps.setString(4, vo.getCposter());
				ps.setString(5, vo.getCcontent());
				
				ps.executeUpdate();
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 } finally {
			 dm.disConnection(conn, ps);
		 }
	 
	}
	/*
	 * C_NO        NOT NULL NUMBER        
		C_TITLE              VARCHAR2(300) 
		C_CONTENT            CLOB          
		C_POSTER             VARCHAR2(500) 
		C_ARTIST             VARCHAR2(100) 
		C_PRICE              VARCHAR2(20)  
		C_ADDRESS            VARCHAR2(400) 
		C_TIME               VARCHAR2(30)  
		C_ONOFF              NUMBER        
		C_CATEGORY           VARCHAR2(50)  
	 * 
	 */
//	public void onlineDataInsert(OnlineVO vo) {
//		try {
//			getConnection();
//			String sql = "INSERT INTO testclass(c_no, c_title, c_content, c_poster, c_artist, c_price,c_onoff) VALUES "
//					+ "((SELECT NVL(MAX(c_no)+1,1) FROM testclass),?,?,?,?,?,0)";
//			   ps=conn.prepareStatement(sql);
//			   ps.setString(1, vo.getCtitle());
//			   ps.setString(2, vo.getCcontent());
//			   ps.setString(3, vo.getCposter());
//			   ps.setString(4, vo.getCartist());
//			   ps.setString(5, vo.getCprice());
//			   
//			   ps.executeUpdate();
//			   
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}finally {
//			disConnection();
//		}
//		
//		
//	}
//	
}
