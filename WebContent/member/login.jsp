<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
function loginOk(){
	event.preventDefault();
	let id = $('#id').val();
	let pwd = $('#password').val();
	$.ajax({
		type:'post',
		url:'../member/login_ok.do',
		data:{'id':id,'pwd':pwd},
		success:function(result) {
			let res=result.trim();
			if(res==="NOID"){
				 alert("ID가 존재하지 않습니다!!");
				 $('#id').focus();
				 history.back();
			}else if(res==="NOPWD") {
	        	alert("비밀번호가 틀립니다!!");
	        	$('#password').text("");
	        	$('#password').focus();
	        	history.back();
			}else{
				sessionStorage.id = id;
				sessionStorage.name = result;
				$(location).attr("href", "../main/main.jsp");
			}
		}
	})
}
</script>
</head>
<body>
<div class="container">
      <form id="form" class="form" method=post action="login_ok.do">
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
        <button class="btn_login" onclick="loginOk()">LOG IN</button>
        <span>if you don't have ID, join us!</span>
      	<div class="btn_signin" onclick="location.href='signin.jsp'">SIGN IN</div>
      </form>
    </div>
</body>
</html>