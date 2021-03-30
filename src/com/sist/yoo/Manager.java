package com.sist.yoo;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Manager {
	public void productData() {
		try {
			int k=1;
			
			// 오늘의 발견,실시간 구매,인기작품 tab
//			Document doc = Jsoup.connect("https://www.idus.com/w/main/today-recommend-product").get();
//			Document doc = Jsoup.connect("https://www.idus.com/w/main/liver-order-product").get();
			Document doc = Jsoup.connect("https://www.idus.com/w/main/popular-category").get();
			
			// System.out.println(doc);
			
			// 각 작품의 id
			Elements id = doc.select("li.ui_grid__item button.ui_card__overlay");
			
			for(int i=0;i<id.size();i++) {
				System.out.println("number: "+k);
				System.out.println("title: "+id.get(i).attr("data-target-id"));
				
				// 각 작품의 상세페이지
				Document target = Jsoup.connect("https://www.idus.com/w/product/"+id.get(i).attr("data-target-id")).get();
				Elements title = target.select("div.sticky_aside_product h2.sticky_aside__produc-title");
				Elements artist = target.select("div.sticky_aside_product span.artist_card__label");
				Elements image = target.select("ul.img-view li.ui-slide");
				Elements content = target.select("p.para");
				Elements category = target.select("a.txt-strong");
				Elements tags = target.select("div.listwrap ul li a");
				
				String imgstr = image.get(0).attr("style");
				
				// 적립금,배송기간,평점,해시태그,찜수,누적구매
				String strtarget = String.valueOf(target);
				int startidx = strtarget.indexOf("productPrice");
				int endidx = strtarget.lastIndexOf("isStarred");
				String info = strtarget.substring(startidx,endidx);
				
				List<String> list = new ArrayList<String>();
				String[] temp = info.replace(" ", "").replace("\n", "").split(",");
				for(String s:temp) {
					s=s.substring(s.indexOf(":")+1);
					list.add(s);
				}
				
				String price = list.get(1);
				String purchase = list.get(2);
				String point = list.get(13);
				if(point.contains(".")) point = point.substring(0,point.indexOf("."));
				String delivery = "평균 "+list.get(21).replace("'", "")+" 최대"+list.get(22).replace("'", "");
				String likes = list.get(list.size()-1).replace("\"", "");
				String tag="";
				
				for(int j=0;j<title.size();j++) {
					try {
						System.out.println("product: "+title.get(j).text());
						System.out.println("artist: "+artist.get(j).text());
						System.out.println("image: "+imgstr.substring(imgstr.indexOf("(")+1,imgstr.indexOf(")")));
						System.out.println("content: "+content.get(j).text());
						System.out.println("category: "+category.get(j).text());
					}catch(Exception e) {
						System.out.println("null");
					}
				}
				for(int j=0;j<tags.size();j++) {
					tag+=tags.get(j).text();
				}
				System.out.println("가격: "+price);
				System.out.println("누적구매: "+purchase);
				System.out.println("포인트: "+point);
				System.out.println("배송: "+delivery);
				System.out.println("찜: "+likes);
				System.out.println("태그: "+tag);
				k++;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Manager fm = new Manager();
		fm.productData();
	}
}
