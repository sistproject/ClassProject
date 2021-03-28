package com.sist.han;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ssdDataGet {
	public void getData() {
		try {
			boolean bCheck = false;
			for (int i = 1; i < 20000; i++) {
				String num = i + "";
				Document doc = Jsoup.connect("https://www.sssd.co.kr/main/class/detail/"+num).get();
				Elements metaTags = doc.select("meta[property]");
				Elements img = doc.select("div.detail-left");
				Elements address = doc.select("script");
				Elements content = doc.select("p#class_introduction");

				// 제목, 내용, 이미지
				for (Element meta : metaTags) {
					// title
					if (meta.attr("property").equals("og:title")) {
						String title = meta.attr("content");
						if (title.length()<11) {
							bCheck = true;
							break;

						}
						int idx = title.indexOf("-");
						System.out.println(title.substring(idx + 2)); // insert 할 값
					}
					// content
					if (meta.attr("property").equals("og:description")) {
						System.out.println(meta.attr("content")); // insert 할 값
					}
					// img
					if (meta.attr("property").equals("og:image")) {
						System.out.println(meta.attr("content")); // insert 할 값
					}
				}
				if (bCheck == true) {
					continue;
				}
				// 주소
				String addressAllCode = address.get(11).toString();
				String[] loc = addressAllCode.split(";");
				for (int j = 0; j < loc.length; j++) {
					int idx = loc[j].indexOf("var fullAddress");
					if (idx != -1) {
						int firstIndex = loc[j].indexOf("'");
						int lastIndex = loc[j].lastIndexOf("'");
						System.out.println(loc[j].substring(firstIndex + 1, lastIndex)); // insert 할 값
						break;
					}
				}

				// 작가 닉네임
				String name = doc.select("div.teacher_txt01").text();
				System.out.println(name);

				// 강의시간
				String timeAllCode = address.get(11).toString();
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
						System.out.println(realTime);
						break;
					}
				}

				// 가격
				String price = doc.select("input#classRealPrice").attr("value");
				System.out.println(price + "원");
				//
				System.out.println("===================================");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ssdDataGet dg = new ssdDataGet();
		dg.getData();
	}
}
