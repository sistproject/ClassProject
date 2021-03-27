package com.sist.product;
/*
 * W_NO       NOT NULL NUMBER         
W_TITLE             VARCHAR2(200)  
W_CONTENT           VARCHAR2(3000) 
W_POSTER            VARCHAR2(200)  
W_SUBJECT           VARCHAR2(40)   
W_ARTIST            VARCHAR2(20)   
W_POINT             VARCHAR2(50)   
W_POST              VARCHAR2(20)   
W_START             VARCHAR2(30)   
W_DELIVERY          VARCHAR2(20)   
W_AMOUNT            VARCHAR2(100)  
W_LIKE              NUMBER         
W_HIT               NUMBER         
W_PRICE             VARCHAR2(20)   
W_REGDATE           DATE           
W_TERM              VARCHAR2(20)   
W_TARGET            VARCHAR2(200)  
W_SCORE             VARCHAR2(50)   
W_ADDRESS           VARCHAR2(100)  
W_TAG               VARCHAR2(30)   
W_CANCEL            VARCHAR2(1000) 
W_NAME              VARCHAR2(15)   
W_EMAIL             VARCHAR2(30)   
W_TEL               VARCHAR2(30)   
CATL_NO             NUMBER        
 * 
 */
public class productVO {
	private int wno, wlike, whit, wcatl_no;
	private String wtitle, wcontent, wposter, wsubject, wartist, wpoint, wpost, wstart, wdelivery, wamount, wprice,
					wregdate, wterm, wtarget, wscore, waddress, wtag, wcancel, wname, wemail, wtel;
}
