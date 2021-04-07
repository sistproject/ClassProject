<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
    String id=(String)session.getAttribute("id"); // 없는 경우:null 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="../main/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../main/css/shop-homepage.css">
<link rel="stylesheet" href="../main/styles/main_styles.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
$(function(){
	$('#delSpan').click(function(){
		if(i==0) {
			$('#del').show();
			$('#delSpan').text("취소");
			i=1;
		}
		else {
			$('#del').hide();
			$('#delSpan').text("삭제");
			i=0;
		}
	});
	
    // 삭제 버튼
    $('#delBtn').click(function(){
    	let pwd=$('input[name=pwd]').val();
    	if(pwd.trim()=="") {
    		$('input[name=pwd]').focus();
    		return;
    	}
    	// 데이터를 전송 (번호,비밀번호,페이지)
    	$('#frm').submit();
    });
});
</script>
<style>
.join_row{
	width:700px;
	margin: 0px auto;
}
 .sectiontitle{
	background-color:#E0E3DA;
	display:inline;
	padding: 10px;
	border-radius: 10px;
	font-family: 'Source Sans Pro', sans-serif;
}
.detaila:link {
	color: gray; text-decoration: none;
}
.detaila:visited {
	color: gray; text-decoration: none;
}
.detaila:hover {
	color: gray; text-decoration: none;
	font-weight: bold;
}
</style>
</head>
<body>
<div class="wrapper row3 join_row">
		<div style="height:100px"></div>
		<h2 class="sectiontitle" class="text-center" style="display:block;text-align:center">자유게시판</h2>
		<div style="height:30px"></div>
		<div style="height:600px;">
	 <table class="table">
	   <tr>
	     <th class="text-center danger" width=20%>번호</th>
	     <td class="text-center" width=30%>${vo.bno}</td>
	     <th class="text-center danger" width=20%>작성일</th>
	     <td class="text-center" width=30%>${vo.regdate}</td>
	   </tr>
	   <tr>
	     <th class="text-center danger" width=20%>이름</th>
	     <td class="text-center" width=30%>${vo.id}</td>
	     <th class="text-center danger" width=20%>조회수</th>
	     <td class="text-center" width=30%>${vo.hits}</td>
	   </tr>
	   <tr>
	     <th class="text-center danger" width=20%>제목</th>
	     <td colspan="3">${vo.title}</td>
	   </tr>
	   <tr>
	     <td class="text-left" valign="top" height=200 colspan="4"><pre style="white-space: pre-wrap;border:none;">${vo.content}</pre>
	     </td>
	   </tr>
	   <tr>
	     <td colspan="4" class="text-right">
	     <c:if test="${vo.id eq id}">
	      <a href="../board/update.do?no=${vo.bno}&type=1" class="btn btn-sm btn-success">수정</a>
	      <a href="../board/delete.do?no=${vo.bno}&type=1" class="btn btn-sm btn-success">삭제</a>
	      </c:if>
	      <a href="../board/freeboard.do" class="btn btn-sm btn-info">목록</a>
	     </td>
	   </tr>
	   
	 </table>
 </div>
</div>

 <script src="../main/js/jquery-3.2.1.min.js"></script>
<script src="../main/styles/bootstrap4/popper.js"></script>
<script src="../main/styles/bootstrap4/bootstrap.min.js"></script>
<script src="../main/plugins/greensock/TweenMax.min.js"></script>
<script src="../main/plugins/greensock/TimelineMax.min.js"></script>
<script src="../main/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="../main/plugins/greensock/animation.gsap.min.js"></script>
<script src="../main/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="../main/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="../main/plugins/easing/easing.js"></script>
<script src="../main/plugins/parallax-js-master/parallax.min.js"></script>
<script src="../main/js/custom.js"></script>
</body>
</html>