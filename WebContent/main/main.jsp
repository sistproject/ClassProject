<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  -->
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Unicat</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
						<div class="logo_container">
							<a href="../main/main.do">
								<div class="logo_text">Unic<span>at</span></div>
							</a>
						</div>
						<nav class="main_nav_contaner ml-auto">
							<div class="w_c_wrapper">
							<ul class="work_class">
								<li><a href="../main/main.do" 
								<%if(menu.equals("work")){%>
									style="color: red"
								<%} else{%>
									style="color: gray;"
								<%}%>
								>작품</a></li>
								<li>/</li>
								<li><a href="../main/cmain.do" 
								<%if(menu.equals("class")){%>
									style="color: red"
								<%} else{%>
									style="color: gray;"
								<%}%>
								>클래스</a></li>
							
							</ul>
							</div>
							<div class="w_c_wrapper">
							<%if(menu.equals("work")) {%>
							<ul class="main_nav">
								<li>
									<a href="#" onmouseover="view(true)" onmouseout="view(false)">
									<div id="category_size">카테고리</div></a>
								</li>
								<li class="active"><a href="../main/main.do">Home</a></li>
								<li><a href="about.html">About</a></li>
								<li><a href="../online/online.do">Courses</a></li>
								<li><a href="#">abc</a></li>
								<li><a href="#">Page</a></li>
								<li><a href="contact.html">Contact</a></li>
							</ul>
							</div>
							<div class="search_button"><i class="fa fa-search" aria-hidden="true"></i></div>
							<%}else if(menu.equals("class")) {%>
							<ul class="main_nav">
								<li>
									<a href="#" onmouseover="view(true)" onmouseout="view(false)">
									<div id="category_size">카테고리</div></a>
								</li>
								<li class="active"><a href="../main/cmain.do">Home</a></li>
								<li><a href="about.html">About</a></li>
								<li><a href="#">Courses</a></li>
								<li><a href="../offclass/offclass.do">오프라인</a></li>
								<li><a href="#">Page</a></li>
								<li><a href="contact.html">Contact</a></li>
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


<!-- home -->

<jsp:include page="${main_jsp}"></jsp:include>
<!-- Footer -->

<footer class="footer">
	<div class="footer_background" style="background-color: #566270"></div>
	<div class="container">
		<div class="row footer_row">
			<div class="col">
				<div class="footer_content">
					<div class="row">

						<div class="col-lg-3 footer_col">
				
							<!-- Footer About -->
							<div class="footer_section footer_about">
								<div class="footer_logo_container">
									<a href="#">
										<div class="footer_logo_text">Unic<span>at</span></div>
									</a>
								</div>
								<div class="footer_about_text">
									<p>Lorem ipsum dolor sit ametium, consectetur adipiscing elit.</p>
								</div>
								<div class="footer_social">
									<ul>
										<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									</ul>
								</div>
							</div>
							
						</div>

						<div class="col-lg-3 footer_col">
				
							<!-- Footer Contact -->
							<div class="footer_section footer_contact">
								<div class="footer_title">Contact Us</div>
								<div class="footer_contact_info">
									<ul>
										<li>Email: Info.deercreative@gmail.com</li>
										<li>Phone:  +(88) 111 555 666</li>
										<li>40 Baria Sreet 133/2 New York City, United States</li>
									</ul>
								</div>
							</div>
							
						</div>

						<div class="col-lg-3 footer_col">
				
							<!-- Footer links -->
							<div class="footer_section footer_links">
								<div class="footer_title">Contact Us</div>
								<div class="footer_links_container">
									<ul>
										<li><a href="index.html">Home</a></li>
										<li><a href="about.html">About</a></li>
										<li><a href="contact.html">Contact</a></li>
										<li><a href="#">Features</a></li>
										<li><a href="courses.html">Courses</a></li>
										<li><a href="#">Events</a></li>
										<li><a href="#">Gallery</a></li>
										<li><a href="#">FAQs</a></li>
									</ul>
								</div>
							</div>
							
						</div>

						<div class="col-lg-3 footer_col clearfix">
				
							<!-- Footer links -->
							<div class="footer_section footer_mobile">
								<div class="footer_title">Mobile</div>
								<div class="footer_mobile_content">
									<div class="footer_image"><a href="#"><img src="images/mobile_1.png" alt=""></a></div>
									<div class="footer_image"><a href="#"><img src="images/mobile_2.png" alt=""></a></div>
								</div>
							</div>
							
						</div>

					</div>
				</div>
			</div>
		</div>

		<div class="row copyright_row">
			<div class="col">
				<div class="copyright d-flex flex-lg-row flex-column align-items-center justify-content-start">
					<div class="cr_text"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></div>
					<div class="ml-lg-auto cr_links">
						<ul class="cr_list">
							<li><a href="#">Copyright notification</a></li>
							<li><a href="#">Terms of Use</a></li>
							<li><a href="#">Privacy Policy</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
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