<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.newpost,
.mypost {
	cursor:pointer;
	padding: .25rem .5rem;
    font-size: .875rem;
    line-height: 1.5;
    border-radius: .2rem;
    border:none;
    background-color: #A593E0;

}
.newpost:hover,.mypost:hover{
	background-color: #8269d3;
}

</style>
</head>
<body>
<div class="wrapper row3 join_row">
		<div style="height:100px"></div>
		<h2 class="sectiontitle" class="text-center" style="display:block;text-align:center">문의게시판</h2>
		<div style="height:10px"></div>
		<div class="text-right">
		<button class="newpost" onclick="location.href='../board/insert.do?type=0'">새글</button>
		<button class="mypost" onclick="location.href='../member/mypost.do'">내가 쓴 글</button>
		</div>
		<div style="height:10px"></div>
		<div style="height:600px;">
		<table class="table">
		<tr>
	        <th class="text-center" width=10%>번호</th>
	        <th class="text-center" width=45%>제목</th>
	        <th class="text-center" width=15%>이름</th>
	        <th class="text-center" width=20%>작성일</th>
	        <th class="text-center" width=10%>조회수</th>
	     </tr>
		<c:forEach var="vo" items="${list}" varStatus="i">
	              <tr>
			        <td class="text-center" width=10%>${list.size()-i.index}</td>
			        <td width=45%>
			        <img src="${vo.poster}" alt="" onerror="this.src='qa.jpg'" style="width:30px; height:30px" class="img-fluid rounded shadow-sm">
			          &nbsp; &nbsp;<a href="../board/qadetail.do?no=${vo.bno}" class="detaila">${vo.title}</a>
			        </td>
			        <td class="text-center" width=15%>${vo.id}</td>
			        <td class="text-center" width=20%>${vo.regdate.substring(0,vo.regdate.indexOf(" "))}</td>
			        <td class="text-center" width=10%>${vo.hits}</td>
			      </tr>
	      </c:forEach>
		</table>
</div>

<div class="wrapper row3 join_row">
  <table class="table">
    <tr>
     <td class="text-right">
      <a href="list.jsp?page=" class="btn btn-sm btn-success">이전</a>
      1 page / 1 pages
      <a href="list.jsp?page=" class="btn btn-sm btn-info">다음</a>
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