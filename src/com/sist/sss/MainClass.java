package com.sist.sss;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReserveDAO dao=new ReserveDAO();
		for(int i=1;i<=15548;i++)
		{
			String s=getReserveData();
			dao.rdayInsert(i,s);
		}
	}
	
	public static String getReserveData()
	{
		String result="";
		int rand=(int)(Math.random()*5)+3; // 몇개를 발생할거냐
		System.out.println("rand:"+rand);
		int[] com=new int[rand];// 10~15
		int su=0;
		boolean bCheck=false;
		for(int i=0;i<rand;i++)
		{
			bCheck=true;
			while(bCheck)
			{
				su=(int)(Math.random()*12)+1; // 12개 사이에서 발생할거다 라는 것
				bCheck=false;
				for(int j=0;j<i;j++)
				{
					if(com[j]==su)
					{
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		// 출력
		Arrays.sort(com);
		for(int i:com)
		{
			result+=i+",";
		}
		result=result.substring(0,result.lastIndexOf(","));
		System.out.println(result);
		return result;
	}

}