package com.sist.sss;
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.net.URL;

public class MybiskitManager {
	MybiskitDAO dao=new MybiskitDAO();
	public void mybiskitData()
	{
		int k=1;
		try
		{
			for(int i=1;i<=10000;i++)
			{
				 Document doc=Jsoup.connect("https://www.mybiskit.com/lecture").get();
				 Elements poster=doc.select("img[src*=/static/]"); // CSS 선택자
		    	 Elements category=doc.select("div.csummary div.summary_tit span");
		    	 Elements title=doc.select("div.csummary div.summary_tit h2.class_tit");
		    	 Elements price=doc.select("div.compo_price span");
		    	 //Elements link=doc.select("div a.href");
	    		 
	    		 for(int j=0;j<title.size();j++)
	    		 {
	    			try
	    			{
	    				MybiskitVO vo=new MybiskitVO();
	    				 vo.setPoster(poster.get(i).attr("src"));
	        			 vo.setCategory(category.get(i).text());
	        			 vo.setTitle(title.get(i).text());
	        			 vo.setPrice(price.get(i).text());

		    			 System.out.println("번호:"+k);
		    			 System.out.println("Poster:"+vo.getPoster());
		    			 System.out.println("카테고리:"+vo.getCategory());
		    			 System.out.println("제목:"+vo.getTitle());
		    			 System.out.println("가격:"+vo.getPrice());

		    			 System.out.println("k="+k);
		    			 
		    			 dao.mybiskitInsert(vo);
		    			 k++;
		    			 Thread.sleep(100);
	    			}catch(Exception e) {e.printStackTrace();}
	    		 }
			}
		}catch(Exception ex){ex.printStackTrace();}
}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MybiskitManager mm=new MybiskitManager();
		mm.mybiskitData();
	}
}
