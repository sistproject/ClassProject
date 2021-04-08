<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Blog Single</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/blog_single.css">
<link rel="stylesheet" type="text/css" href="styles/blog_single_responsive.css">

<link rel="stylesheet" type="text/css" href="../main/styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../main/plugins/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../main/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="../main/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="../main/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="../main/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="../main/styles/responsive.css">
<% //세션에 저장되어 있는 데이터 읽기
    String id=(String)session.getAttribute("id"); // 없는 경우:null 
    System.out.println(id);
%>
<%  
	String menu = (String)request.getAttribute("menu"); 
	if(menu==null){
		menu = "work";
	}
%>
<!-- 카테고리 -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
function view(opt){
	if(opt){
		category_display.style.display="block";
		category_size.style.color= "#A593E0";
	}else{
		category_display.style.display="none";
		category_size.style.color= "#384158";
	}
}
function view2(opt2){
	if(opt2){
		category_display.style.display="block";
		category_size.style.color= "#A593E0";
	}else{
		category_display.style.display="none";
		category_size.style.color= "#384158";
	}
}
let i = 0;
$(function() {
	$('.delBtn').click(
			function() {
				let no = $(this).attr("data-no");
				let cno = $(this).attr("data-cno");
				location.href = "../online/online_reply_delete.do?no=" + no+ "&cno=" + cno;
			});

	$('.updateBtn').click(function() {
		$('.updateli').hide();
		$('.updateBtn').text("수정");
		let no = $(this).attr("data-no");
		if (i == 0) {
			$(this).text("취소");
			$('#m' + no).show("slow");
			i = 1;
		} else {
			$(this).text("수정");
			$('#m' + no).hide("slow");
			i = 0;
		}

	});
	$('.replyBtn').click((event)=>{
		event.preventDefault();
		let msg = $('#msg').val();
		console.log(msg);
		$.ajax({
		    type:'post',
		    url: '../online/online_reply_insert.do',
		   	data: {
		   	'cno':${ondVO.cno},
		    'msg':msg
		    },
		    success: function(result){
				
		    		
		    }
		});
	})
});

</script>
<style type="text/css">

.container{
	min-width:1500px;
}
.w_c_wrapper{
	display: inline-block;
}

.work_class{
	margin-right: 80px;
}
.work_class li{
	display: inline-block;
	font-size: 18px;
}
.work_class a{
	color: gray;
}
.myButton {
	background-color:#f0ecc5;
	border-radius:28px;
	border:1px solid #f0ecc5;
	display:inline-block;
	cursor:pointer;
	color:#080608;
	font-family:Times New Roman;
	font-size:17px;
	font-weight:bold;
	padding:13px 40px;
	text-decoration:none;
	text-shadow:0px 1px 0px #f0ecc5;
}
.myButton:hover {
	background-color:#f0ecc5;
}
.myButton:active {
	position:relative;
	top:1px;
}

</style>
</head>
<body>
<div class="super_container">
<!-- Header -->
<header class="header">
	<!-- Top Bar -->
	<div class="top_bar">
		<div class="top_bar_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="top_bar_content d-flex flex-row align-items-center justify-content-end">
							<ul class="top_bar_contact_list">
							     <% if(id!=null) { %>
							       <li>
							       <a href="../member/logout.do"><div>로그아웃</div></a>
									</li>
							     <% } else { %>
							       <li>
							       <a href="../member/login.do"><div>로그인</div></a>
							       </li> 
							     <% } %>
								<li>
									<a href="../member/signin.do"><div>회원가입</div></a>
								</li>
								<li>
									<a href="../member/member_detail.do"><div>마이페이지</div></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>				
	</div>

	<div class="category_wrapper">
	<div class="mouse_check" onmouseover="view(true)" onmouseout="view(false)"></div>
	<div class="mouse_check2" id="category_display" onmouseover="view2(true)" onmouseout="view2(false)">
	<div class="category">
		<ul class="category_content">
			<li>가다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
		</ul>
	</div>
	
	<div class="category">
		<ul class="category_content">			
			<li>가다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
			<li>가나다라마바사아</li>
		</ul>
	</div>
	</div>
	</div>
		<!-- Header Content -->
	<div class="header_container">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="header_content d-flex flex-row align-items-center justify-content-start">
						<div class="logo_container" style="width:200px">
							<a href="../main/main.do">
								<div class="logo_text">Unic<span>at</span></div>
							</a>
						</div>
						<nav class="main_nav_contaner">
							<div class="w_c_wrapper">
							<ul class="work_class">
								<li><a href="../main/main.do" 
								<%if(menu.equals("work")){%>
									style="color: #A593E0"
								<%} else{%>
									style="color: gray;"
								<%}%>
								>작품</a></li>
								<li>/</li>
								<li><a href="../main/cmain.do" 
								<%if(menu.equals("class")){%>
									style="color: #A593E0"
								<%} else{%>
									style="color: gray;"
								<%}%>
								>클래스</a></li>
							
							</ul>
							</div>
							<div class="w_c_wrapper"> <!--  -->
							<%if(menu.equals("work")) {%>
							<ul class="main_nav">
								<li>
									<a href="#" onmouseover="view(true)" onmouseout="view(false)">
									<div id="category_size">카테고리</div></a>
								</li>
								<li class="active"><a href="../main/main.do">홈</a></li>
								<li><a href="#">작품 전체</a></li>
								<li><a href="#">인기 작품</a></li>
								<li><a href="../work/work_list.do">오늘의 발견</a></li>
								<li><a href="#">실시간 구매</a></li>
								<li><a href="#">작가님 추천</a></li>
								<li><a href="#">실시간 추천</a></li>
							</ul>
							</div>
							<div class="search_button"><i class="fa fa-search" aria-hidden="true"></i></div>
							<%}else if(menu.equals("class")) {%>
							<ul class="main_nav">
								<li>
									<a href="#" onmouseover="view(true)" onmouseout="view(false)">
									<div id="category_size">카테고리</div></a>
								</li>
								<li class="active"><a href="../main/cmain.do">홈</a></li>
								<li><a href="../online/online.do">온라인</a></li>
								<li><a href="../offclass/offclass.do">오프라인</a></li>
								<li><a href="#">인기 클래스</a></li>
								<li><a href="#">추천 클래스</a></li>
								<li><a href="#">신규 클래스</a></li>
								<li><a href="../offclass/reserve.do">클래스 예약</a></li>
							</ul>
							</div>
							<div class="search_button"><i class="fa fa-search" aria-hidden="true"></i></div>
							<%} %>
							<div class="shopping_cart"><a href="../cart/cart.do"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a></div>
						</nav>
					</div>
				</div>
			</div>
		</div>
	

	<!-- Header Search Panel -->
	<div class="header_search_container">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="header_search_content d-flex flex-row align-items-center justify-content-end">
						<form action="#" class="header_search_form">
							<input type="search" class="search_input" placeholder="Search" required="required">
							<button class="header_search_button d-flex flex-column align-items-center justify-content-center">
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>			
	</div>			
</header>

	
	<!-- Home -->
     <div style="margin-top:150px"></div>

	<!-- Blog -->

	<div class="blog">
		<div class="container">
			<div class="row">

				<!-- Blog Content -->
				<div class="col-lg-6">
					<div class="blog_content">
						<div class="blog_meta">
							<ul>
							    <li>By          ${vo.w_artist }</li>
								<li>Post on     ${vo.w_regdate }</li>
							</ul>
						</div>
						<div class="blog_image"><img src="${vo.w_poster }" style="width:720px; height:600ps object-fit:fill" alt=""></div>
						<div style="margin-top:15px"></div>
						<div class="team_body" style="width:720px; height: 450px">
							<div class="team_title">${vo.w_content }</div>
							 <div class="social_list">
								<span>Tags: </span>
										<ul>
											<li>${vo.w_tag }</li>
										</ul>
									</div>
								</div>
				 </div>
				</div>
				<!-- Course Tabs -->
							<div class="course_tabs_container">

								<div
									class="tabs d-flex flex-row align-items-center justify-content-start">
									<div class="tab active">수강평</div>
									<div class="tab">curriculum</div>
									<div class="tab">reviews</div>
								</div>
								<div class="tab_panels">

<!-- //////  댓글  ////////// -->
							<div class="course_tabs_container">

								<div
									class="tabs d-flex flex-row align-items-center justify-content-start">
									<div class="tab active">구매 후기</div>
									<div class="tab">curriculum</div>
									<div class="tab">reviews</div>
								</div>
								<div class="tab_panels">



<!-- Description -->
<div class="tab_panel active reply">
	<c:if test="${sessionScope.id!=null }">
		<button>
			<table class="table">
				<tr>
					<td><textarea rows="10" cols="100" name="msg" id="msg"></textarea> <%--<c:set var="page" value="${param.page}"/> 
								              									<input type="hidden" name=cno value="${page}">--%>
						<input type="hidden" name=w_no value="${vo.w_no}"> 
						<input type="submit" value="댓글쓰기" class="btn btn-sm btn-danger replyBtn">
						<c:forEach var="rvo" items="${reList }">
							<li>
								<article>
									<header>
										<figure class="avatar">
											<c:if test="${sessionScope.id==rvo.id }">
												<span class="btn btn-xs btn-success updateBtn"
													data-no="${vo.no }">수정</span>
												<span class="btn btn-xs btn-danger delBtn"
													data-no="${vo.no }" data-cno="${vo.w_no }">삭제</span>
											</c:if>
										</figure>
										<address>
											By <a href="#">${vo.name }</a>
										</address>
										<time datetime="2045-04-06T08:15+00:00">${vo.dbday }</time>
									</header>
									<div class="comcont">
										<pre style="white-space: pre-wrap; border: none; background-color: white;">${vo.msg }</pre>
									</div>
								</article>
							</li>
							<li style="display: none" id="m${vo.no }" class="updateli">
								<button>
									<table class="table">
										<tr>
											<td>
												<textarea rows="7" cols="25" name="msg">${vo.msg }</textarea>
												<input type="hidden" name=cno value="${vo.w_no }">
												<input type="hidden" name=no value="${vo.no }"> <input type="submit" value="댓글수정" class="btn btn-sm btn-danger">
											</td>
										</tr>
									</table>
								</button>
							</li>
						</c:forEach>
						</td>
				</tr>
			</table>
		</button>
	</c:if>
</div>

					<!-- Course Sidebar -->
					<div class="col-lg-6">
						<div class="sidebar">

							<!-- Feature -->
							<div class="sidebar_section">
								<div class="sidebar_section_title">${vo.w_title }</div>
								
								<!-- Feature -->
										<div
											class="feature d-flex flex-row align-items-center justify-content-start">
											<div class="feature_title">
												<i class="fa fa-clock-o" aria-hidden="true"></i><span>${vo.w_artist }</span>
											</div>
											<div class="feature_text ml-auto"></div>
										</div>
								
								
								<div class="sidebar_feature">
									<div class="course_price">${vo.w_price }원</div>

									<!-- Features -->
									<div class="feature_list">

										<!-- Feature -->
										<div
											class="feature d-flex flex-row align-items-center justify-content-start">
											<div class="feature_title">
												<i class="fa fa-clock-o" aria-hidden="true"></i><span>적립금:</span>
											</div>
											<div class="feature_text ml-auto">${vo.w_point }p</div>
										</div>

										<!-- Feature -->
										<div
											class="feature d-flex flex-row align-items-center justify-content-start">
											<div class="feature_title">
												<i class="fa fa-file-text-o" aria-hidden="true"></i><span>별점:</span>
											</div>
											<div class="feature_text ml-auto">${vo.w_score }</div>
										</div>

										<!-- Feature -->
										<div
											class="feature d-flex flex-row align-items-center justify-content-start">
											<div class="feature_title">
												<i class="fa fa-question-circle-o" aria-hidden="true"></i><span>배송:</span>
											</div>
											<div class="feature_text ml-auto">${vo.w_delivery }</div>
										</div>

										<!-- Feature -->
										<div
											class="feature d-flex flex-row align-items-center justify-content-start">
											<div class="feature_title">
												<i class="fa fa-list-alt" aria-hidden="true"></i><span>Lectures:</span>
											</div>
											<div class="feature_text ml-auto">Yes</div>
										</div>

										<!-- Feature -->
										<div
											class="feature d-flex flex-row align-items-center justify-content-start">
											<div class="feature_title">
												<i class="fa fa-users" aria-hidden="true"></i><span>Lectures:</span>
											</div>
											<div class="feature_text ml-auto">35</div>
										</div>
						    <a href="../member/jjim.do?no=${vo.w_no}&type=w" class="myButton">찜</a>&nbsp;&nbsp;&nbsp;<a href="../work/reserve.do" class="myrButton">예약하기</a>
						</div>
         			</div>
				</div>
			</div>
		</div>
	</div>



<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/blog_single.js"></script>

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