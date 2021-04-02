package com.sist.product;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
/*
W_NO       NOT NULL NUMBER         
W_TITLE             VARCHAR2(200)  
W_CONTENT           VARCHAR2(3000) 
W_POSTER            VARCHAR2(200)  
W_PRICE             VARCHAR2(20)   
W_ARTIST            VARCHAR2(20) 
W_DELIVERY          VARCHAR2(30) 
W_TAG               VARCHAR2(30)     
W_POINT             NUMBER         
W_SCORE             NUMBER(1,1)   
W_LIKE              NUMBER         
W_PURCHASE          NUMBER         
W_HIT               NUMBER         
W_REGDATE           DATE           
CATL_NO             NUMBER         
 */
@Getter
@Setter
public class productVO {
	public int getWno() {
		return wno;
	}
	public void setWno(int wno) {
		this.wno = wno;
	}
	public int getWpoint() {
		return wpoint;
	}
	public void setWpoint(int wpoint) {
		this.wpoint = wpoint;
	}
	public int getWpurchase() {
		return wpurchase;
	}
	public void setWpurchase(int wpurchase) {
		this.wpurchase = wpurchase;
	}
	public int getWlike() {
		return wlike;
	}
	public void setWlike(int wlike) {
		this.wlike = wlike;
	}
	public int getWhit() {
		return whit;
	}
	public void setWhit(int whit) {
		this.whit = whit;
	}
	public int getWcatl_no() {
		return wcatl_no;
	}
	public void setWcatl_no(int wcatl_no) {
		this.wcatl_no = wcatl_no;
	}
	public Double getWscore() {
		return wscore;
	}
	public void setWscore(Double wscore) {
		this.wscore = wscore;
	}
	public String getWtitle() {
		return wtitle;
	}
	public void setWtitle(String wtitle) {
		this.wtitle = wtitle;
	}
	public String getWcontent() {
		return wcontent;
	}
	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}
	public String getWposter() {
		return wposter;
	}
	public void setWposter(String wposter) {
		this.wposter = wposter;
	}
	public String getWprice() {
		return wprice;
	}
	public void setWprice(String wprice) {
		this.wprice = wprice;
	}
	public String getWartist() {
		return wartist;
	}
	public void setWartist(String wartist) {
		this.wartist = wartist;
	}
	public String getWdelivery() {
		return wdelivery;
	}
	public void setWdelivery(String wdelivery) {
		this.wdelivery = wdelivery;
	}
	public String getWtag() {
		return wtag;
	}
	public void setWtag(String wtag) {
		this.wtag = wtag;
	}
	public Date getWregdate() {
		return wregdate;
	}
	public void setWregdate(Date wregdate) {
		this.wregdate = wregdate;
	}
	private int wno, wpoint, wpurchase, wlike, whit, wcatl_no;
	private Double wscore;
	private String wtitle, wcontent, wposter, wprice, wartist, wdelivery, wtag;
	private Date wregdate;
}
