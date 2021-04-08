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
	width:1000px;
	margin: 0px auto;
}
 .sectiontitle{
	background-color:#E0E3DA;
	display:inline;
	padding: 10px;
	border-radius: 10px;
	font-family: 'Source Sans Pro', sans-serif;
}
.warning{
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
body > div > div > div > div.pagination_row > div > div > ul > li > a { color: black;}
</style>
</head>
<body>
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
<div class="wrapper row3 join_row">
	<div style="height:30px"></div>
		<h2 class="sectiontitle" >내가 쓴 글</h2>
		<div style="height:30px"></div>
		<div style="height:600px;">
		<table class="table">
		<tr>
	        <th class="text-center" width=10%>번호</th>
	        <th class="text-center" width=45%>제목</th>
	        <th class="text-center" width=15%>이름</th>
	        <th class="text-center" width=20%>작성일</th>
	        <th class="text-center" width=10%>조회수</th>
	     </tr>
	     <c:if test="${list.size()==0 }">
	     <tr>
	     <td colspan="4" class="text-center warning" style="margin-top:20px;"><h4>작성한 글이 없습니다</h4></td>
	     </tr>
	     </c:if>
	     <c:if test="${list.size()!=0 }">
		<c:forEach var="vo" items="${list}" varStatus="i">
	              <tr>
<%-- 			        <td class="text-center" width=10%>${list.size()-i.index}</td> --%>
			        <td class="text-center" width=10%>${vo.bno}</td>
			        <td width=45%>
			        <a href="../board/freedetail.do?no=${vo.bno}" class="detaila">${vo.title}</a>
			        </td>
			        <td class="text-center" width=15%>${vo.id}</td>
			        <td class="text-center" width=20%>${vo.regdate.substring(0,vo.regdate.indexOf(" "))}</td>
			        <td class="text-center" width=10%>${vo.hits}</td>
			      </tr>
	      </c:forEach>
	      </c:if>
		</table>
		</div>
</div>

<div class="pagination_row">
	<div class="col">
		<div class="page"  style="text-align: center" >
			<ul class="pagination_list">
		         <c:if test="${startPage>1 }">
		          <li><a href="../member/member_mypost.do?page=${startPage-1 }">이전</a></li>
		         </c:if>
		         <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
		           <c:if test="${i==curpage }">
		            <c:set var="type" value="class=current"/>
		           </c:if>
		           <c:if test="${i!=curpage }">
		            <c:set var="type" value=""/>
		           </c:if>
		           <li ${type }><a href="../member/member_mypost.do?page=${i }">${i }</a></li>
		         </c:forEach>
		         <c:if test="${endPage<totalpage }">
		           <li><a href="../member/member_mypost.do?page=${endPage+1 }"> 다음</a></li>
		         </c:if>
	        </ul>
		</div>
	</div>
</div>


<script src="../main/vendor/jquery/jquery.min.js"></script>
<script src="../main/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="../main/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="../main/js/custom.js"></script>
</body>
</html>