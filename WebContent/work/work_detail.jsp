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
				<!-- Blog Sidebar -->
				<div class="col-lg-6">
				 <div style="margin-top:45px"></div>
					<div class="sidebar">
						<!-- Categories -->
						<div class="team_body" style="width:650px; height: 300px; text-align:left; vertical-align:text-top;">

							  <div class="sidebar_section">
							<div class="sidebar_section_title"><h2>${vo.w_title }</h2></div>
							<div class="sidebar_categories">
								<ul class="categories_list">
									<li class="clearfix">${vo.w_artist }<span>(25)</span></li>
									<li class="clearfix">${vo.w_price }<span>${vo.w_like }</span></li>
									<li class="clearfix">적립금  ${vo.w_point }P<span>${vo.w_purchase }</span></li>
									<li class="clearfix">평점  ${vo.w_score }<span></span></li>
									<li class="clearfix">배송기간 ${vo.w_delivery }<span></span></li>
								</ul>
							</div>
						    </div>

						</div>
						

						<!-- Latest News -->
						<div class="sidebar_section">
							<div class="sidebar_section_title">Latest Courses</div>
							<div class="sidebar_latest">

								<!-- Latest Course -->
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="images/latest_1.jpg" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a href="course.html">How to Design a Logo a Beginners Course</a></div>
										<div class="latest_date">november 11, 2017</div>
									</div>
								</div>

								<!-- Latest Course -->
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="images/latest_2.jpg" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a href="course.html">Photography for Beginners Masterclass</a></div>
										<div class="latest_date">november 11, 2017</div>
									</div>
								</div>

								<!-- Latest Course -->
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="images/latest_3.jpg" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a href="course.html">The Secrets of Body Language</a></div>
										<div class="latest_date">november 11, 2017</div>
									</div>
								</div>

							</div>
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