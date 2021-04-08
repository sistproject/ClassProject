package com.sist.han;

import com.sist.jdbc.*;
import com.sist.class_.*;
import java.sql.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.jdbc.DAOManager;

public class ssdDataGet {
	private DAOManager dm = new DAOManager();
	private Connection conn;
	private PreparedStatement ps;
	
	public void hitScoreData() {
		try {
			conn = dm.getConnection();
			String sql = "";
			for(int i=490; i<=15803; i++) {
				sql = "SELECT COUNT(*) FROM thisclass WHERE c_no=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, i);
				ResultSet rs = ps.executeQuery();
				rs.next();
				int num = rs.getInt(1);
				ps.close();
				if(num==1) {
					
					sql = "UPDATE thisclass SET c_score=? "
							+ "WHERE c_no=?";
					
					//sql = "UPDATE thisclass SET c_hit=? "
					//		+ "WHERE c_no=?";
					ps = conn.prepareStatement(sql);
					double c_score = Math.random()*1.5+3.5;
					ps.setDouble(1, (Math.floor(c_score*10))/10);
					//ps.setInt(1, (int)(Math.random()*100)+1);
					ps.setInt(2, i);
					ps.executeUpdate();
					System.out.println(i);
					Thread.sleep(100);
				}
				ps.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dm.disConnection(conn, ps);
		}
	}
	
	public void insertCategory() {
		try {
			conn = dm.getConnection();
			for(int i=491; i<20000; i++) {
				String sql = "UPDATE thisclass "
						+ "SET temp_category = ? "
						+ "WHERE c_title LIKE '%'||?||'%'";
				String category = getCategory(i);
				String title = getTitle(i);
				if(title=="NO") {
					continue;
				}
				ps = conn.prepareStatement(sql);
				ps.setString(1, category);
				ps.setString(2, title);
				ps.executeUpdate();
				ps.close();
				Thread.sleep(100);
				System.out.println(i);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dm.disConnection(conn, ps);
		}
	}
	
	public String getCategory(int i) {
		String category = "";
		try {
			Document doc = Jsoup.connect("https://www.sssd.co.kr/main/class/detail/"+i).get();
			Elements cat = doc.select("div.title-type");
			category = cat.text();
		}catch (Exception e) {}
		return category;
	}
	public String getTitle(int i) {
		String title = "NO";
		try {
			Document doc = Jsoup.connect("https://www.sssd.co.kr/main/class/detail/"+i).get();
			Elements el_metaTags = doc.select("meta[property]");
			for (Element meta : el_metaTags) {
				// title
				if (meta.attr("property").equals("og:title")) {
					String title1 = meta.attr("content");
					if (title1.length()<11) {
						return title;
					}
					int idx = title1.indexOf("-");
					//System.out.println(title.substring(idx + 2));
					title = title1.substring(idx+2);
				}
			}
		}catch (Exception e) {}
		return title;
	}
	
	public void ssdInsertData(ssdVO vo) {
		try {
			conn = dm.getConnection();
			String sql = "INSERT INTO class(c_no, c_title, c_content, c_poster, c_address, "
					+ "c_artist, c_time, c_price, c_onoff) "
					+ "VALUES(CLASS_C_NO_SEQ.nextval(),?,?,?,?,?,?,?,1)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getC_title());
			ps.setString(2, vo.getC_content());
			ps.setString(3, vo.getC_poster());
			ps.setString(4, vo.getC_address());
			ps.setString(5, vo.getC_artist());
			ps.setString(6, vo.getC_time());
			ps.setInt(7, vo.getC_price());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dm.disConnection(conn, ps);
		}
	}
	
	
	
	public void getData() {
		try {
			int each = 0;
			boolean bCheck = false;
			for (int i = 10316; i < 10317; i++) {
				ssdVO vo = new ssdVO();
				String num = i + "";
				Document doc = Jsoup.connect("https://www.sssd.co.kr/main/class/detail/"+num).get();
				Elements el_metaTags = doc.select("meta[property]");
				Elements el_img = doc.select("div.detail-left");
				Elements el_address = doc.select("script");
				Elements el_content = doc.select("p#class_introduction");

				// 제목, 내용, 이미지
				for (Element meta : el_metaTags) {
					// title
					if (meta.attr("property").equals("og:title")) {
						String title = meta.attr("content");
						if (title.length()<11) {
							bCheck = true;
							break;

						}
						int idx = title.indexOf("-");
						//System.out.println(title.substring(idx + 2));
						title = title.substring(idx+2);
						vo.setC_title(title);
					}
					// content
					if (meta.attr("property").equals("og:description")) {
						//System.out.println(meta.attr("content"));
						String content = meta.attr("content");
						vo.setC_content(content);
					}
					// 주소체크용
					if (meta.attr("property").equals("og:url")) {
						//System.out.println(meta.attr("content"));
					}
					// poster
					if (meta.attr("property").equals("og:image")) {
						//System.out.println(meta.attr("content")); 
						String poster = meta.attr("content");
						vo.setC_poster(poster);
					}
				}
				if (bCheck == true) {
					bCheck = false;
					continue;
				}
				// 주소
				String addressAllCode = el_address.get(11).toString();
				String[] loc = addressAllCode.split("'");
				for (int j = 0; j < loc.length; j++) {
					int idx = loc[j].indexOf("var fullAddress");
					if (idx != -1) {
						String result = loc[j+1].replaceAll("&#039;", "");
						//System.out.println(result);
						vo.setC_address(result);
						break;
					}
				}

				// artist
				String name = doc.select("div.teacher_txt01").text();
				//System.out.println(name);
				vo.setC_artist(name);

				// 강의시간
				String timeAllCode = el_address.get(11).toString();
				String[] splitCode = timeAllCode.split(";");
				for (int k = 0; k < splitCode.length; k++) {
					int idx = splitCode[k].indexOf("lessonTime : '");
					if (idx != -1) {
						int firstIndex = splitCode[k].lastIndexOf(":");
						int lastIndex = splitCode[k].lastIndexOf("'");
						int time = Integer.parseInt(splitCode[k].substring(firstIndex + 3, lastIndex));
						String realTime = (time / 60) + "시간";
						if (time % 60 != 0) {
							realTime = realTime + " " + (time % 60) + "분"; // insert 할 값
						}
						//System.out.println(realTime);
						vo.setC_time(realTime);
						break;
					}
				}

				// 가격
				int price = Integer.parseInt(doc.select("input#classRealPrice").attr("value"));
				//System.out.println(price + "원");
				vo.setC_price(price);
				
				// 줄바꿈
				//System.out.println("===================================");
				each = each+1;
				
				ssdInsertData(vo);
			}
			System.out.println(each);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ssdDataGet dg = new ssdDataGet();
		dg.insertCategory();
	}
}
