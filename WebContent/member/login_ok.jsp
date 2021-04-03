<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.MemberDAO"></jsp:useBean>
<% 
    String id=request.getParameter("id");
    String pwd=request.getParameter("password");

    String result=dao.isLogin(id, pwd);
    if(result.equals("NOID")) { %>
         <script>
         alert("ID가 존재하지 않습니다!!");
         history.back();
         </script>
<% } else if(result.equals("NOPWD")) {
%>
        <script>
        alert("비밀번호가 틀립니다!!");
        history.back();
        </script>
<% } else {
    	// 로그인 상태 => session에 ID,Name저장
        session.setAttribute("id", id);
        session.setAttribute("name", result);
        response.sendRedirect("../main/main.do");
    }
%>









