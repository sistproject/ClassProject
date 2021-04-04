package com.sist.jun;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.dao.CartDAO;
import com.sist.jun.OnlineVO;


public class OnlineDAO {
	private Connection conn;
	   private PreparedStatement ps;
	   private static OnlineDAO dao;
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
	public void onlineDataInsert(OnlineVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO testclass(c_no, c_title, c_content, c_poster, c_artist, c_price,c_onoff) VALUES "
					+ "((SELECT NVL(MAX(c_no)+1,1) FROM testclass),?,?,?,?,?,0)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getCtitle());
			   ps.setString(2, vo.getCcontent());
			   ps.setString(3, vo.getCposter());
			   ps.setString(4, vo.getCartist());
			   ps.setString(5, vo.getCprice());
			   
			   ps.executeUpdate();
			   
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		
		
	}
	
}
