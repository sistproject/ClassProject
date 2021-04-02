<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.MemberDAO"></jsp:useBean>
<% // id,pwd 받는다
    String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
    // DAO연결
    String result=dao.isLogin(id, pwd);
    // 결과출력 
    if(result.equals("NOID")) { %>
         <script>
         alert("ID가 존재하지 않습니다!!");
         history.back();
         </script>
<% } else if(result.equals("NOPWD")) { %>
        <script>
        alert("비밀번호가 틀립니다!!");
        history.back();
        </script>
<% } else {
    	// 로그인 상태 => session에 ID,Name저장

        session.setAttribute("id", id);
        session.setAttribute("name", result);
        // 홍길동님 안녕하세요
        // 이동 => main.jsp
        response.sendRedirect("../main/main.jsp");
    } %>











