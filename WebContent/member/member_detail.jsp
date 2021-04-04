<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<html lang="ko">
<head>
<title>Unicat</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="../memberdetail/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../main/css/shop-homepage.css">
<link rel="stylesheet" href="../main/styles/main_styles.css">
<link rel="stylesheet" href="../shadow/css/shadowbox.css">
<script type="text/javascript" src="../shadow/js/shadowbox.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style>
.join_row{
	width:700px;
	margin: 0px auto;
}
 .sectiontitle{
	background-color:#E0E3DA;
	display:inline;
	padding: 5px;
	border-radius: 20px;
}
</style>

<script type="text/javascript">
Shadowbox.init({
	players:["iframe"]
});
$(function(){
	$('#postbtn').click(()=>{
		Shadowbox.open({
			content:'../member/postfind.jsp',
			player:'iframe',
			title:'우편번호 검색',
			width:540,
			height:450
		})
	})
});
</script>
</head>
<body>
 <!-- Page Content -->
  <div class="container" style="margin-top:8%">
    <div class="row">
      <div class="col-lg-3">
        <h1 class="my-4">MY PAGE</h1>
        <div class="list-group">
          <a href="#" class="list-group-item" style="color:#566270">회원정보 수정</a>
          <a href="#" class="list-group-item" style="color:#566270">주문 내역</a>
          <a href="#" class="list-group-item" style="color:#566270">내가 쓴 글</a>
          <a href="#" class="list-group-item" style="color:#566270">쿠폰함</a>
          <a href="#" class="list-group-item" style="color:#566270">찜목록</a>
        </div>
      </div>
      <!-- /.col-lg-3 -->

		<div class="wrapper row3 join_row">
		<h2 class="sectiontitle">회원 정보 수정</h2>
		<div style="height:10px"></div>
		<form method=post action="../member/join_ok.do" name="join_frm">
		<table class="table">
		<tr>
		<th>
		<h4 class="sectiontitle">필수정보</h4>
		</th>
		</tr>
		<tr>
		<th width=20% class="text-right">Name</th>
		<td width=80%>
		<input type=text name=name id=name class="input-sm" size=15 style="float:left" value="${vo.name }"> 
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">ID</th>
		<td width=80%>
		<input type=text name=id id=id class="input-sm" size=15 style="float:left" readonly value="${vo.id }">
		</td>
		</tr>
		<tr>
		<tr>
		<th width=20% class="text-right">Email</th>
		<td width=80%>
		<input type=text name=email id=emial class="input-sm" size=40 value="${vo.email }">
		<small>Error message</small>
		</td>
		</tr>
		<th width=20% class="text-right">PWD</th>
		<td width=80%>
		<input type=password name=pwd id=pwd1 class="input-sm" size=15 >
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">REPWD</th>
		<td width=80%>
		<input type=password name=pwd id=pwd2 class="input-sm" size=15 placeholder="재입력">
		<small>Error message</small>
		</td>
		</tr>
		<tr>
		<td>
		<h4 class="sectiontitle">추가정보</h4>
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">sex</th>
		<td width=80%>
		<ul class="inline">
		<li><input type=radio name=sex class="input-sm" checked value="남자">남자</li>
		<li><input type=radio name=sex class="input-sm" value="여자" >여자</li>
		</ul>
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">Birth</th>
		<td width=80%>
		<input type=date name=birth size=20>
		</td>
		</tr>

		</tr>
		<tr>
		<th width=20% class="text-right">Post</th>
		<td width=80%>
		<input type=text name=post id=post class="input-sm" size=10 style="float:left">
		<input type=button value="우편번호 검색" class="btn btn-sm btn-danger" id=postbtn style="float:left">
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">주소</th>
		<td width=80%>
		<input type=text name=addr1 id=addr1 class="input-sm" size=45>
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">상세주소</th>
		<td width=80%>
		<input type=text name=addr2 id=addr2 class="input-sm" size=45>
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">TEL</th>
		<td width=80%>
		<input type=text name=tel1 id=tel1 class="input-sm" size=5 readonly value="010" style="float:left">
		<input type=text name=tel2 id=tel2 class="input-sm" size=10 style="float:left">
		</td>
		</tr>
		<tr>
		<td colspan="2" class="text-center">
		<input type=submit value="저장" class="btn btn-sm btn-success" >
		<input type=button value="취소" class="btn btn-sm btn-warning" onclick="javascript:history.back()">
		</td>
		</tr>
		</table>
		</form>
		</div>
    </div>
    <!-- /.row -->
  </div>
<!-- /.container -->

<!-- Bootstrap core JavaScript -->
<script src="../memberdetail/vendor/jquery/jquery.min.js"></script>
<script src="../memberdetail/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="../main/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="../main/js/custom.js"></script>
</body>
</html>
