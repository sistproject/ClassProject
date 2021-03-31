package com.sist.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.sist.jdbc.*;

public class productDAO {
	private DAOManager dm = new DAOManager();
	private Connection conn;
	private PreparedStatement ps;
	public void productInsert(productVO vo) {
		 try {
			 conn=dm.getConnection();
//			 System.out.println("conn:"+conn);
			 String sql="INSERT INTO work(w_no,w_title,w_content,w_poster,w_price,w_artist,w_point,w_delivery,w_score,w_tag,w_like,w_purchase)"
			 		+ " VALUES((SELECT NVL(MAX(w_no)+1,1) FROM work),?,?,?,?,?,?,?,?,?,?,?)";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, vo.getWtitle());
			 ps.setString(2, vo.getWcontent());
			 ps.setString(3, vo.getWposter());
			 ps.setString(4, vo.getWprice());
			 ps.setString(5, vo.getWartist());
			 ps.setInt(6, vo.getWpoint());
			 ps.setString(7, vo.getWdelivery());
			 ps.setDouble(8, vo.getWscore());
			 ps.setString(9, vo.getWtag());
			 ps.setInt(10, vo.getWlike());
			 ps.setInt(11, vo.getWpurchase());
			 // 실행
			 ps.executeUpdate(); // COMMIT
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 } finally {
			 dm.disConnection(conn, ps);
		 }
	 }
	public static void main(String[] args) {
		Double d = Double.parseDouble("1");
		System.out.println(d);
	}
}
