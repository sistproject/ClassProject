package com.sist.sss;
import java.util.*;
import java.sql.*;
public class ReserveDAO {
	  private Connection conn;
	  private PreparedStatement ps;
	  private final String URL="jdbc:oracle:thin:@211.238.142.196:1521:XE";
	  public ReserveDAO()
	  {
		  try
		  {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
		  }catch(Exception ex) {}
	  }
	  public void getConnection()
	  {
		  try
		  {
			  conn=DriverManager.getConnection(URL,"hr","happy");
		  }catch(Exception ex) {}
		  
	  }
	  public void disConnection()
	  {
		  try
		  {
			  if(ps!=null) ps.close();
			  if(conn!=null) ps.close();
		  }catch(Exception ex) {}
	  }
	  
	  // 맛집 => 예약일 등록
	  public void offclassReserveDate(int c_no,String rday)
	  {
		  try
		  {
			  getConnection();
			  String sql="UPDATE thisclass SET "
					    +"rdays=? "
					    +"WHERE c_no=?"
					    +"AND c_onoff=1";
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, rday);
			  ps.setInt(2, c_no);
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
	  
	  public void rdayInsert(int no,String time)
	  {
		  try
		  {
			  getConnection();
			  String slq="INSERT INTO rday VALUES(?,?)";
			  ps=conn.prepareStatement(slq);
			  ps.setInt(1, no);
			  ps.setString(2, time);
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
	  
}



























