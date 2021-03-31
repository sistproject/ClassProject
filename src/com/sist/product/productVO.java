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
	private int wno, wpoint, wpurchase, wlike, whit, wcatl_no;
	private Double wscore;
	private String wtitle, wcontent, wposter, wprice, wartist, wdelivery, wtag;
	private Date wregdate;
}
