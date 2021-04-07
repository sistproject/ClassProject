package com.sist.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/*
 * 	NO      NOT NULL NUMBER       
	C_NO             NUMBER       
	ID               VARCHAR2(20) 
	NAME    NOT NULL VARCHAR2(34) 
	MSG     NOT NULL CLOB         
	REGDATE          DATE        
 */
@Getter
@Setter
public class OffclassReplyVO {
	private int no;
	private int cno;
	private String id;
	private String name;
	private String msg;
	private Date regdate;
	private String dbday;
}
