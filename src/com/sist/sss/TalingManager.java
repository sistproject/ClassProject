package com.sist.sss;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class TalingManager {
	public void TalingData()
	{
		try
		{
			int k=1;
			
			for(int a=1;a<=25;a++)
			{
			
			// 메이크업
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=28&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 악기
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=59&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 보컬
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=60&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 작곡/디제잉
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=61&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 캘리그래피
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=76&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 사진
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=79&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 이색 취미
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=81&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 커피/차/술
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=83&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 요리/베이킹
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=84&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 플라워
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=125&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 가죽/목공/도예
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=126&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 취미미술
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=222&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 디지털드로잉
			//Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=232&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 조향/캔들/비누
			Document doc = Jsoup.connect("https://taling.me/Home/Search/?page="+a+"&cateMain=&cateSub=249&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
			
			// 각 작품의 id링크
			Elements id=doc.select("div.cont2_class a");
			
			for(int i=0;i<id.size();i++)
			{
				// 작품별 상세
				Document target=Jsoup.connect("https://taling.me"+id.get(i).attr("href")).get();
					
				Elements image=target.select("div.swiper-wrapper div.swiper-slide");
				Elements title=target.select("h1.p_title");
				Elements price=target.select("div.fixed_navi span.per");
				Elements artist=target.select("div.p2p_tutor_info em.t_nickname");
				Elements address=target.select("b.c_location");
				Elements content=target.select("p.col_title");
				
				
				String imgstr=image.get(0).attr("style");
				String pricestr=price.get(0).text();
				String artiststr=artist.get(0).text();
				
				for(int j=0;j<title.size();j++)
				{
					try
					{
						System.out.println("번호:"+k);
						System.out.println("이미지:"+imgstr.substring(imgstr.indexOf("(")+1,imgstr.indexOf(")")));
						System.out.println("제목:"+title.get(j).text());
						System.out.println("가격:"+pricestr.substring(0,pricestr.length()-4));
						System.out.println("아티스트:"+artiststr.substring(0,artiststr.length()-2));
						System.out.println("위치:"+address.get(j).text());
						System.out.println("내용:"+content.get(j).text());
					}catch(Exception e) {}
					
						for(int h=0;h<=25;h++)
						{
							// 메이크업
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page="+(a+1)+"&cateMain=&cateSub=28&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 악기
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=59&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 보컬
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=60&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 작곡/드제잉
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=61&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 캘리그래피
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=76&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 사진
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=79&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 이색취미
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=81&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 커피/차/술
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=83&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 요리/베이킹
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=84&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 플라워
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=125&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 가죽/목공/도예
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=126&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 취미미술
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=222&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 디지털드로잉
							//Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=232&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							// 조향/캔들/비누
							Document target2=Jsoup.connect("https://taling.me/Home/Search/?page=\"+a+\"&cateMain=&cateSub=249&region=&orderIdx=&query=&code=&org=&day=&time=&tType=&region=&regionMain=").get();
							
							Elements category=target2.select("div.main font");
								try
								{
									System.out.println("카테고리:"+category.get(h).text());
								}catch(Exception e) {}
						}
				}
				k++;
			}
			}
		}catch(Exception ex) {}
	}
		public static void main(String[] args) {
			System.out.println("hello");
			TalingManager tm=new TalingManager();
			tm.TalingData();
		}
}