package com.sist.vo;
/*
	ADMIN             NUMBER         
	NAME     NOT NULL VARCHAR2(100)  
	ID       NOT NULL VARCHAR2(34)   
	PWD      NOT NULL VARCHAR2(15)   
	TEL               VARCHAR2(15)   
	EMAIL    NOT NULL VARCHAR2(100)  
	POST              VARCHAR2(200)  
	ADDRESS1          VARCHAR2(2000) 
	ADDRESS2          VARCHAR2(2000) 
	SEX               VARCHAR2(3)    
	BIRTH             DATE  
 */
import java.util.*;
public class MemberVO {
	private String name,id,email,tel,post,addr1,addr2,sex;
	private Date birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emial) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
}
