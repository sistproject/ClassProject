package com.sist.jun;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Manager {
	public void productData() {
		try {
			int k=1;
			int page = 8;
			// 아이디어스 온라인 클래스
			Document doc = Jsoup.connect("https://www.idus.com/oc/class/"+page).get();
			
			// System.out.println(doc);
			
			
			for(int i=0;i<1;i++) {
				System.out.println("number: "+k);
				
				// 아이디어스 온라인 클래스 상세페이지
				Elements artist = doc.select("span.artist_card__label");
				Elements subject = doc.select("small.sticky_aside__small");
				Elements title = doc.select("h2.sticky_aside__title");
				Elements image = doc.select("img.article_block__img");
				Elements context1 = doc.select("h3.article_block__title");
				Elements context2 = doc.select("p.article_block__para");
				String imgstr = image.get(i).attr("src");
				
//				String pricestr = String.valueOf(price.get(0));
//				String dataprice = "data-sold-price";
//				int idx = pricestr.indexOf(dataprice)+17;
//				String pslide = pricestr.substring(idx,idx+10);
//				String pslide2 = pslide.substring(0,pslide.lastIndexOf("\""));
				
				for(int j=0;j<artist.size();j++) {
					try {
						System.out.println("artist: "+artist.get(j).text());
						System.out.println("subject:"+subject.get(j).text());
						System.out.println("product: "+title.get(j).text());
						System.out.println("context1: "+context1.get(j).text());
						System.out.println("context2: "+context2.get(j).text());
						System.out.println("image: "+imgstr);
						
						
						//						System.out.println("price: "+ pslide2 + "원");
//						System.out.println("category: "+category.get(j).text());
					}catch(Exception e) {
						System.out.println("null");
					}
				}
				
				k++;
				page++;
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
