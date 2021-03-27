package com.sist.yoo;

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
//				System.out.println("title: "+id.get(i).attr("data-target-id"));
				
				// 각 작품의 상세페이지
				Document target = Jsoup.connect("https://www.idus.com/w/product/"+id.get(i).attr("data-target-id")).get();
				
				Elements title = target.select("div.sticky_aside_product h2.sticky_aside__produc-title");
				Elements artist = target.select("div.sticky_aside_product span.artist_card__label");
				Elements image = target.select("ul.img-view li.ui-slide");
				Elements price = target.select("div.sticky_aside_product");
				Elements content = target.select("p.para");
				Elements category = target.select("a.txt-strong");
				
				String imgstr = image.get(0).attr("style");
				
				String pricestr = String.valueOf(price.get(0));
				String dataprice = "data-sold-price";
				int idx = pricestr.indexOf(dataprice)+17;
				String pslide = pricestr.substring(idx,idx+10);
				String pslide2 = pslide.substring(0,pslide.lastIndexOf("\""));
				
				for(int j=0;j<title.size();j++) {
					try {
						System.out.println("product: "+title.get(j).text());
						System.out.println("artist: "+artist.get(j).text());
						System.out.println("image: "+imgstr.substring(imgstr.indexOf("(")+1,imgstr.indexOf(")")));
						System.out.println("artist: "+content.get(j).text());
						System.out.println("price: "+ pslide2 + "원");
						System.out.println("category: "+category.get(j).text());
					}catch(Exception e) {
						System.out.println("null");
					}
				}
				
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
