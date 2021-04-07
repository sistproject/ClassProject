package com.sist.vo;

import java.sql.Date;

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
public class WorkDetailVO {
	private int w_no,w_point,w_like,w_purchase,w_hit,catl_no;
	private String w_title,w_content,w_poster,w_price,w_artist,w_delivery,w_tag;
	private Double w_score;
	private Date w_regdate;
	public int getW_no() {
		return w_no;
	}
	public void setW_no(int w_no) {
		this.w_no = w_no;
	}
	public int getW_point() {
		return w_point;
	}
	public void setW_point(int w_point) {
		this.w_point = w_point;
	}
	public int getW_like() {
		return w_like;
	}
	public void setW_like(int w_like) {
		this.w_like = w_like;
	}
	public int getW_purchase() {
		return w_purchase;
	}
	public void setW_purchase(int w_purchase) {
		this.w_purchase = w_purchase;
	}
	public int getW_hit() {
		return w_hit;
	}
	public void setW_hit(int w_hit) {
		this.w_hit = w_hit;
	}
	public int getCatl_no() {
		return catl_no;
	}
	public void setCatl_no(int catl_no) {
		this.catl_no = catl_no;
	}
	public String getW_title() {
		return w_title;
	}
	public void setW_title(String w_title) {
		this.w_title = w_title;
	}
	public String getW_content() {
		return w_content;
	}
	public void setW_content(String w_content) {
		this.w_content = w_content;
	}
	public String getW_poster() {
		return w_poster;
	}
	public void setW_poster(String w_poster) {
		this.w_poster = w_poster;
	}
	public String getW_price() {
		return w_price;
	}
	public void setW_price(String w_price) {
		this.w_price = w_price;
	}
	public String getW_artist() {
		return w_artist;
	}
	public void setW_artist(String w_artist) {
		this.w_artist = w_artist;
	}
	public String getW_delivery() {
		return w_delivery;
	}
	public void setW_delivery(String w_delivery) {
		this.w_delivery = w_delivery;
	}
	public String getW_tag() {
		return w_tag;
	}
	public void setW_tag(String w_tag) {
		this.w_tag = w_tag;
	}
	public Double getW_score() {
		return w_score;
	}
	public void setW_score(Double w_score) {
		this.w_score = w_score;
	}
	public Date getW_regdate() {
		return w_regdate;
	}
	public void setW_regdate(Date w_regdate) {
		this.w_regdate = w_regdate;
	}
	

}