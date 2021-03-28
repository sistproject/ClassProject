package com.sist.han;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ssdDataGet {
	public void getData() {
		try {
			Document doc = Jsoup.connect("https://www.sssd.co.kr/main/class/detail/16373").get();
			Elements metaTags = doc.select("meta[property]");
			Elements img = doc.select("div.detail-left");
			Elements address = doc.select("script");
			
			/*
			// 제목, 내용, 이미지
			for(Element meta:metaTags) {
				// title
				if(meta.attr("property").equals("og:title")) {
					String title = meta.attr("content");
					int idx = title.indexOf("]");
					System.out.println(title.substring(idx+2)); // insert 할 값
				}
				// content
				if(meta.attr("property").equals("og:description")) {
					System.out.println(meta.attr("content")); // insert 할 값
				}
				// img
				if(meta.attr("property").equals("og:image")) {
					System.out.println(meta.attr("content")); // insert 할 값
				}
			}
			 
			// 주소
			String addressAllCode = address.get(11).toString();
			String[] loc = allCode.split(";");
			for(int i=0; i<loc.length; i++) {
				int idx = loc[i].indexOf("var fullAddress");
				if(idx!=-1) {
					int firstIndex = loc[i].indexOf("'");
					int lastIndex = loc[i].lastIndexOf("'");
					System.out.println(loc[i].substring(firstIndex+1, lastIndex)); // insert 할 값
					break;
				}
			}
			
			// 작가 닉네임
			String name = doc.select("div.teacher_txt01").text();
			
			// 강의시간
			String timeAllCode = address.get(11).toString();
			String[] loc = timeAllCode.split(";");
			for(int i=0; i<loc.length; i++) {
				int idx = loc[i].indexOf("lessonTime : '");
				if(idx!=-1) {
					int firstIndex = loc[i].lastIndexOf(":");
					int lastIndex = loc[i].lastIndexOf("'");
					int time = Integer.parseInt(loc[i].substring(firstIndex+3, lastIndex));
					String realTime = (time/60)+"시간";
					if(time%60!=0) {
						realTime = realTime+" "+(time%60)+"분"; // insert 할 값
						System.out.println(realTime);
					}
					break;
				}
			}
			
			//가격
			String price = doc.select("input#classRealPrice").attr("value");
			System.out.println(price+"원");
			*/
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ssdDataGet dg = new ssdDataGet();
		dg.getData();
	}
}
