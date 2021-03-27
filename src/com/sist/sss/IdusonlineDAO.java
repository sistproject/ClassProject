package com.sist.sss;
/*package idus;
import java.util.*;
import com.sist.jdbc.DAOManager;

import java.sql.*;
public class IdusonlineDAO {
	private DAOManager dm=new DAOManager();
	private Connection conn;
	private PreparedStatement ps;
	public void idusonlineInsert(IdusonlineVO vo)
	{
		try
		{
			//
			conn=dm.getConnection();
			String sql="INSERT INTO idus_online VALUES("
					 +"(SELECT NVL(MAX(no)+1,1) FROM idus_online),?,?,?,?,?)";
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