package com.sist.vo;

/*
 *  W_NO       NOT NULL NUMBER         
	W_TITLE             VARCHAR2(200)  
	W_CONTENT           VARCHAR2(4000) 
	W_POSTER            VARCHAR2(2000) 
	W_PRICE             VARCHAR2(200)  
	W_ARTIST            VARCHAR2(200)  
	W_POINT             NUMBER         
	W_DELIVERY          VARCHAR2(300)  
	W_SCORE             NUMBER(2,1)    
	W_TAG               VARCHAR2(3000) 
	W_LIKE              NUMBER         
	W_PURCHASE          NUMBER         
	W_HIT               NUMBER         
	W_REGDATE           DATE           
	CATL_NO             NUMBER         

 */
public class WorkVO
{
	private int w_no;
	private String w_title;
	private String w_poster;
	private String w_artist;
	

 
	public int getW_no() {
		return w_no;
	}
	public void setW_no(int w_no) {
		this.w_no = w_no;
	}
	public String getW_title() {
		return w_title;
	}
	public void setW_title(String w_title) {
		this.w_title = w_title;
	}

	public String getW_poster() {
		return w_poster;
	}
	public void setW_poster(String w_poster) {
		this.w_poster = w_poster;
	}

	public String getW_artist() {
		return w_artist;
	}
	public void setW_artist(String w_artist) {
		this.w_artist = w_artist;
	}
}

