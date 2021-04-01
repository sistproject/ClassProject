<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
<div class="container">
      <form id="form" class="form" method=post action="login_ok.jsp">
        <h2>LOG IN</h2>
       <div class="form_control">
          <label for="id">ID</label>
          <input type="text" id="id" placeholder="ID" />
          <small>Error message</small>
        </div>
        <div class="form_control">
          <label for="password">Password</label>
          <input type="password" id="password" placeholder="PASSWORD" />
          <small>Error message</small>
        </div>
        <button class="btn_login">LOG IN</button>
        <span>if you don't have ID, join us!</span>
      	<div class="btn_signin" onclick="location.href='signin.jsp'">SIGN IN</div>
      </form>
    </div>
</body>
</html>