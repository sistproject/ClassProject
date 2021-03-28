package com.sist.jun;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Manager {
	public void productData() {
		try {
			int k=1;
			
			// 아이디어스 온라인 클래스
//			Document doc = Jsoup.connect("https://www.idus.com/w/main/today-recommend-product").get();
//			Document doc = Jsoup.connect("https://www.idus.com/w/main/liver-order-product").get();
			Document doc = Jsoup.connect("https://www.idus.com/oc/class/8").get();
			
			// System.out.println(doc);
			
			// 각 작품의 id
			
			for(int i=0;i<1;i++) {
				System.out.println("number: "+k);
//				System.out.println("title: "+id.get(i).attr("data-target-id"));
				
				// 각 작품의 상세페이지
//				Document target = Jsoup.connect("https://www.idus.com/w/product/"+id.get(i).attr("data-target-id")).get();
				
				Elements artist = doc.select("span.artist_card__label");
				Elements subject = doc.select("small.sticky_aside__small");
				Elements title = doc.select("h2.sticky_aside__title");
				Elements image = doc.select("img.article_block__img");
				Elements context = doc.select("p.article_block__para bot_spacing");
				Elements context2 = doc.select("article_block__label");
//				Elements price = doc.select("div.sticky_aside_product");
//				Elements category = doc.select("a.txt-strong");
				
				String imgstr = image.get(0).attr("src");
				
//				String pricestr = String.valueOf(price.get(0));
//				String dataprice = "data-sold-price";
//				int idx = pricestr.indexOf(dataprice)+17;
//				String pslide = pricestr.substring(idx,idx+10);
//				String pslide2 = pslide.substring(0,pslide.lastIndexOf("\""));
				
				for(int j=0;j<1;j++) {
					try {
						System.out.println("artist: "+artist.get(j).text());
						System.out.println("product: "+title.get(j).text());
						System.out.println("image: "+imgstr.substring(imgstr.indexOf("h",imgstr.lastIndexOf("png"))));
						System.out.println("context: "+context.get(j).text());
						System.out.println("context2: "+context2.get(j).text());
						
						
						//						System.out.println("price: "+ pslide2 + "원");
//						System.out.println("category: "+category.get(j).text());
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
