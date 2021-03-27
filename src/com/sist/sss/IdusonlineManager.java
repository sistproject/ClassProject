package com.sist.sss;
/*
 *  NO          NUMBER         
	POSTER      VARCHAR2(4000) 
	CATEGORY    VARCHAR2(100)  
	TITLE       VARCHAR2(1000) 
	PRICE       VARCHAR2(500)  
	LINK        VARCHAR2(1000) 
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.*;

public class IdusonlineManager {
	private IdusonlineDAO dao=new IdusonlineDAO();
	public void idusOnlineData()
	{
		try
		{
			int k=1;
			Document doc=Jsoup.connect("https://www.idus.com/oc").get();
    		//System.out.println(doc);
    		Elements poster=doc.select("div.img_box"); // CSS 선택자
    		Elements category=doc.select("div.edu-online-list div");
    		Elements title=doc.select("div.edu-online-list strong");
    		Elements price=doc.select("div.edu-online-list span");
    		Elements link=doc.select("div a.href");
    		for(int i=0;i<title.size();i++)
    		{
    			System.out.println("번호:"+k);
    			System.out.println("이미지:"+poster.get(i).attr("style"));
    			System.out.println("카테고리"+category.get(i).text());
    			System.out.println("제목:"+title.get(i).text());
    			System.out.println("가격:"+price.get(i).text());
    			System.out.println("링크:https://www.idus.com"+link.get(i).attr("href"));
    			IdusonlineVO vo=new IdusonlineVO();
    			vo.setPoster(poster.get(i).attr("url"));
    			vo.setCategory(category.get(i).text());
    			vo.setTitle(title.get(i).text());
    			vo.setPrice(price.get(i).text());
    			vo.setLink("https://www.idus.com"+link.get(i).attr("href"));
    			
    			k++;
    		}
		}catch(Exception ex) {}
	}

	public static void main(String[] args) {
		IdusonlineManager im=new IdusonlineManager();
		im.idusOnlineData();
	}
}

