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
			Elements loc = doc.select("li.ui_grid__item div.ui_card--white span.ui_card__overlay--label");
			Elements image = doc.select("li.ui_grid__item div.ui_card--white div.ui_card__imgcover a.ui_card__img");
			
			Elements link = doc.select("picture.img img");
			for(int i=0;i<id.size();i++) {
				System.out.println("number: "+k);
				System.out.println("title: "+id.get(i).attr("data-target-id"));
				
				Document target = Jsoup.connect("https://www.idus.com/w/product/"+id.get(i).attr("data-target-id")).get();
				
				Elements title = target.select("div.sticky_aside_product h2.sticky_aside__produc-title");
				Elements artist = target.select("div.sticky_aside_product span.artist_card__label");

				for(int j=0;j<title.size();j++) {
					System.out.println("product: "+title.get(j).text());
					System.out.println("artist: "+artist.get(j).text());
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
