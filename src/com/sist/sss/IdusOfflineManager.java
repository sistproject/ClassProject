package com.sist.sss;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
 *  NO          NUMBER         
	IMAGE       VARCHAR2(4000) 
	CATEGORY    VARCHAR2(100)  
	TITLE       VARCHAR2(1000) 
	PRICE       VARCHAR2(500)  
	ARTIST      VARCHAR2(200)  
	CONTENT     VARCHAR2(3000) 
 */
public class IdusOfflineManager {
	public void idusOffData()
	{
		try
		{
			int k=1;
			
			//카테고리 (5가지 총 72개)
			//for(int a=2;a<=7;a++)
			//{
			//Document doc = Jsoup.connect("https://www.idus.com/c/category/"+a).get();
			
			// 오프라인 인기클래스
			Document doc = Jsoup.connect("https://www.idus.com/c/popular").get();
			
			// 오프라인 신규 클래스
			//Document doc = Jsoup.connect("https://www.idus.com/c/latest").get();
			
			// 오프라인 지역별(12곳 총 101개)
			/*
			for(int b=101;b<=116;b++)
			{
			Document doc = Jsoup.connect("https://www.idus.com/c/region/"+b).get();
			System.out.println("지역번호"+b);
			*/
			
			
			// 각 작품의 id
			Elements id=doc.select("li.ui_grid__item button.ui_card__overlay");
			
			for(int i=0;i<id.size();i++)
			{
				// 작품별 상세페이지
				Document target=Jsoup.connect("https://www.idus.com/c/class/"+id.get(i).attr("data-target-id")).get();
				
				
				Elements image=target.select("ul.img-view li.ui-slide");
				Elements category=target.select("aside.sticky_aside small.sticky_aside__small");
				Elements title=target.select("aside.sticky_aside h2.sticky_aside__title");
				Elements price=target.select("div.price_tag strong.sold-price");
				Elements artist=target.select("aside.sticky_aside span.artist_card__label");
				Elements address=target.select("div.map__labelbox strong");
				Elements content=target.select("div.article_block__header h3.article_block__title"); 
				
				String imgstr=image.get(0).attr("style");
				
		    		for(int j=0;j<title.size();j++)
		    		{
		    			try {
			    			System.out.println("번호:"+k);
			    			System.out.println("이미지:"+imgstr.substring(imgstr.indexOf("(")+1,imgstr.indexOf(")")));
			    			System.out.println("카테고리:"+category.get(j).text());
			    			System.out.println("제목:"+title.get(j).text());
			    			System.out.println("가격:"+price.get(j).text()+"원");
			    			System.out.println("아티스트:"+artist.get(j).text());
			    			System.out.println("위치:"+address.get(j).text());
			    			System.out.println("내용:"+content.get(j).text());
		    			}catch(Exception e) {}
		    		}
		    		k++;
			}
		//} // 카테고리 5가지 for문 & 오프라인 지역별
		}catch(Exception ex) {}
	}
	public static void main(String[] args) {
		IdusOfflineManager ifm=new IdusOfflineManager();
		ifm.idusOffData();
	}
}
