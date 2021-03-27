package com.sist.sss;
/*package mybiskit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.sist.jdbc.DAOManager;

public class MybiskitDAO {
	private DAOManager dm=new DAOManager();
	private Connection conn;
	private PreparedStatement ps;
	public void mybiskitInsert(MybiskitVO vo)
	{
		try
		{
			*/
			/*
			 * 	NO          NUMBER         
				POSTER      VARCHAR2(4000) 
				CATEGORY    VARCHAR2(100)  
				TITLE       VARCHAR2(1000) 
				PRICE       VARCHAR2(500)  
				LINK        VARCHAR2(1000) 
			 */
/*
			conn=dm.getConnection();
			String sql="INSERT INTO idus_online VALUES("
					 +"(SELECT NVL(MAX(no)+1,1) FROM mybiskit),?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			// 
			ps.setString(1, vo.getPoster());
			ps.setString(2, vo.getCategory());
			ps.setString(3, vo.getTitle());
			ps.setString(4, vo.getPrice());
			ps.setString(5, vo.getLink());
			
			// 실행
			ps.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			dm.disConnection(conn, ps);
		}
	}
}
*/