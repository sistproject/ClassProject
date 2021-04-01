<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.sist.dao.MemberDAO"></jsp:useBean>
<% 
    String name=request.getParameter("username");
    String id=request.getParameter("id");
	String email=request.getParameter("email");
    String pwd=request.getParameter("pwd");
    
    dao.insertMember(name, id, email, pwd);
    //String result=dao.isLogin(id, pwd);
    response.sendRedirect("login.jsp");
%>