package com.sist.jun;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Manager {
	public void productData() {
		try {
			int k = 1;
			for (int p = 8; p <= 207; p++) {
				try {
					OnlineDAO dao = new OnlineDAO();
					OnlineVO vo = new OnlineVO();
					// 아이디어스 온라인 클래스
					Document doc = Jsoup.connect("https://www.idus.com/oc/class/" + p).get();

					// System.out.println(doc); 
					
					System.out.println("number: " + k);

					// 아이디어스 온라인 클래스 상세페이지
					Elements artist = doc.select("span.artist_card__label");
					Elements subject = doc.select("small.sticky_aside__small");
					Elements title = doc.select("h2.sticky_aside__title");
					Elements image = doc.select("img.article_block__img");
					Elements context1 = doc.select("h3.article_block__title");
					Elements context2 = doc.select("p.article_block__para");

					
					for (int j = 0; j < artist.size(); j++) {
						try {
							System.out.println("artist: " + artist.get(j).text());
//							System.out.println("subject:" + subject.get(j).text());
							System.out.println("product: " + title.get(j).text());
//							System.out.println("context1: " + context1.get(j).text());
							vo.setCtitle(title.get(j).text());
							vo.setCartist(artist.get(j).text());
							
						} catch (Exception e) {
							System.out.println("null");
						}
					}
					String contents = "";
					String img="";
							
					for (int j = 0; j < context2.size(); j++) {
						img += (image.get(j).attr("src")+"^");
						contents+= (context2.get(j).text()+"^");
					}
					System.out.println(img);
					System.out.println(contents);
					
					vo.setCcontent(contents);
					vo.setCposter(img);
					vo.setCprice("16500");
					
					dao.onlineDataInsert(vo);
					
					k++;
					
					
				}catch(Exception ex) {
//					ex.printStackTrace();
					System.out.println("no page");
				}
				
			}
			
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("no page");
		}
		
	}

	public static void main(String[] args) {
		Manager fm = new Manager();
		fm.productData();
	}
}
