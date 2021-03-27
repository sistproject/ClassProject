package com.sist.yoo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Manager {
	public void productData() {
		try {
			int k=1;
			Document doc = Jsoup.connect("https://www.idus.com/w/main/today-recommend-product").get();
//			System.out.println(doc);
			
			Elements id = doc.select("li.ui_grid__item button.ui_card__overlay");
			
			Elements link = doc.select("picture.img img");
			for(int i=0;i<id.size();i++) {
				System.out.println("number: "+k);
				System.out.println("title: "+id.get(i).attr("data-target-id"));
				
				Document target = Jsoup.connect("https://www.idus.com/w/product/"+id.get(i).attr("data-target-id")).get();
				
				Elements title = target.select("div.sticky_aside_product h2.sticky_aside__produc-title");
				Elements artist = target.select("div.sticky_aside_product span.artist_card__label");
				Elements image = target.select("ul.img-view li.ui-slide");
				Elements price = target.select("strong.sold-price");
				Elements detail = target.select("div.sticky_aside_product span.artist_card__label");
				Elements category = target.select("a.txt-strong");
				
				
				String imgstr = image.get(0).attr("style");
				
				for(int j=0;j<title.size();j++) {
					System.out.println("product: "+title.get(j).text());
					System.out.println("artist: "+artist.get(j).text());
					System.out.println("image: "+imgstr.substring(imgstr.indexOf("(")+1,imgstr.indexOf(")")));
//					System.out.println("price: "+price.get(j).text());
					System.out.println(price.size());
					System.out.println("category: "+category.get(j).text());
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
