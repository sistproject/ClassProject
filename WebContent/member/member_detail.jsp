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
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="../main/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../main/css/shop-homepage.css">
<link rel="stylesheet" href="../main/styles/main_styles.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
.join_row{
	width:700px;
	margin: 0px auto;
}
 .sectiontitle{
	background-color:#E0E3DA;
	display:inline;
	padding: 10px;
	border-radius: 20px;
	font-family: 'Source Sans Pro', sans-serif;
}
small{
	color:red;
}
.btn{
	cursor:pointer;
}

</style>

<script type="text/javascript">
const emailValidation = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
const telValidation = /^[0-9]/g;
$(function(){
	$('#postbtn').click(()=>{
		new daum.Postcode({
			oncomplete:function(data) {
				$('#post').val(data.zonecode);
				$('#addr1').val(data.address);
			}
		}).open();
	})
	$('#pwd1,#pwd2').on("change keyup paste",()=>{
		let pwd = $('#pwd1').val();
		let repwd = $('#pwd2').val();
		if(pwd!==repwd){
			$('#pwderr').text("password does not match");
			$('#sumbit').addClass('disabled');
		}
		else{
			$('#pwderr').text("");
		}
	});
	$('#email').on("change keyup paste",()=>{
		let mail = $('#email').val();
		if(!emailValidation.test(mail.trim())){
			$('#emailerr').text("unvalid email");
		}else{
			$('#emailerr').text("");	
		}
	});
	$('#submit').click((event)=>{
		let pwd = $('#pwd1').val();
		if(pwd.trim()===""){
			$('#pwd1').val(${vo.pwd});
		}
		$('form').submit();
		
	});
});
function checkNumber(event) {
	  if(event.key === '.' || event.key === '-'
	     || event.key >= 0 && event.key <= 9) {
	    return true;
	  }
	  return false;
}
</script>
</head>
<body>
 <!-- Page Content -->
  <div class="container" style="margin-top:8%">
    <div class="row">
      <div class="col-lg-3">
        <h1 class="my-4">MY PAGE</h1>
        <div class="list-group">
          <a href="../member/member_detail.do" class="list-group-item" style="color:#566270">회원정보 수정</a>
          <a href="../member/member_order.do" class="list-group-item" style="color:#566270">주문 내역</a>
          <a href="../member/member_mypost.do" class="list-group-item" style="color:#566270">내가 쓴 글</a>
          <a href="../member/member_mycoupon.do" class="list-group-item" style="color:#566270">쿠폰함</a>
          <a href="../member/member_myjjim.do" class="list-group-item" style="color:#566270">찜목록</a>
        </div>
        <div class="help" onclick="location.href='../board/qaboard.do'" style="cursor:pointer;">
          <span>도움이 필요하신가요?</span>
          <div>1:1 문의하기</div>
        </div>
      </div>
      <!-- /.col-lg-3 -->

		<div class="wrapper row3 join_row">
		<div style="height:30px"></div>
		<h2 class="sectiontitle" >회원 정보 수정</h2>
		<div style="height:30px"></div>
		<form method=post action="../member/member_update.do" name="form">
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
		<input type=text name=email id=email class="input-sm" size=40 value="${vo.email }">
		<small id="emailerr"></small>
		</td>
		</tr>
		<th width=20% class="text-right">PWD</th>
		<td width=80%>
		<input type=password name=pwd id=pwd1 class="input-sm" size=15>
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">REPWD</th>
		<td width=80%>
		<input type=password id=pwd2 class="input-sm" size=15 placeholder="password check">
		<small id="pwderr"></small>
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
		<c:if test="${vo.sex eq '남자'}">
		<input type=radio name=sex class="input-sm" checked value="남자" >남자
		<input type=radio name=sex class="input-sm" value="여자" style="margin-left:30px;">여자
		</c:if>
		<c:if test="${vo.sex eq '여자'}">
		<input type=radio name=sex class="input-sm" value="남자" >남자
		<input type=radio name=sex class="input-sm" checked value="여자" style="margin-left:30px;">여자
		</c:if>
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">Birth</th>
		<td width=80%>
		<input type=date name=birth size=20 value="${vo.birth }">
		</td>
		</tr>
		</tr>
		<tr>
		<th width=20% class="text-right">Post</th>
		<td width=80%>
		<input type=text name=post id=post class="input-sm" size=10 style="float:left" value="${vo.post }" readonly>
		&nbsp;&nbsp;<input type=button value="우편번호 검색" class="btn btn-sm postbtn" id=postbtn style="float:left;background-color:#A593E0">
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">Address</th>
		<td width=80%>
		<input type=text name=addr1 id=addr1 class="input-sm" size=45 value="${vo.addr1 }">
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">Detail</th>
		<td width=80%>
		<input type=text name=addr2 id=addr2 class="input-sm" size=45 value="${vo.addr2 }">
		</td>
		</tr>
		<tr>
		<th width=20% class="text-right">TEL</th>
		<td width=80%>
		<input type=text name=tel1 id=tel1 class="input-sm" size=5 value="${vo.tel.substring(0,3) }" style="float:left" onkeypress='return checkNumber(event)'>
		<input type=text name=tel2 id=tel2 class="input-sm" size=5 value="${vo.tel.substring(3,7) }" style="float:left" onkeypress='return checkNumber(event)'>
		<input type=text name=tel3 id=tel3 class="input-sm" size=5 value="${vo.tel.substring(7) }" style="float:left" onkeypress='return checkNumber(event)'>
		</td>
		</tr>
		<tr>
		<td colspan="2" class="text-center">
		<button id="submit" class="btn btn-sm submitbtn"  style="background-color:#A593E0;margin-right:20px">저장</button>
		<input type=button value="취소" class="btn btn-sm btn-secondary" onclick="javascript:history.back()">
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
<script src="../main/vendor/jquery/jquery.min.js"></script>
<script src="../main/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="../main/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="../main/js/custom.js"></script>
</body>
</html>
