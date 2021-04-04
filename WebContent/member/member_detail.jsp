<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<html lang="ko">
<head>
<title>Unicat</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
<% //세션에 저장되어 있는 데이터 읽기
    String id=(String)session.getAttribute("id"); // 없는 경우:null 
    System.out.println(id);
%>
<!-- 카테고리 -->
<script type="text/javascript">
function view(opt){
	if(opt){
		category_display.style.display="block";
		category_size.style.color= "#14bdee";
	}else{
		category_display.style.display="none";
		category_size.style.color= "#384158";
	}
}
function view2(opt2){
	if(opt2){
		category_display.style.display="block";
		category_size.style.color= "#14bdee";
	}else{
		category_display.style.display="none";
		category_size.style.color= "#384158";
	}
}
</script>
</head>
<body>
<div class="super_container">
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
								<a href="#">
									<div class="logo_text">Unic<span>at</span></div>
								</a>
							</div>
							<nav class="main_nav_contaner ml-auto">
								<ul class="main_nav">
									<li>
										<a href="#" onmouseover="view(true)" onmouseout="view(false)">
										<div id="category_size">카테고리</div></a>
									</li>
									<li class="active"><a href="#">Home</a></li>
									<li><a href="about.html">About</a></li>
									<li><a href="courses.html">Courses</a></li>
									<li><a href="blog.html">Blog</a></li>
									<li><a href="#">Page</a></li>
									<li><a href="contact.html">Contact</a></li>
								</ul>
								<div class="search_button"><i class="fa fa-search" aria-hidden="true"></i></div>

								<!-- Hamburger -->

								<div class="shopping_cart"><a href="../cart/cart.do"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a></div>
								<div class="hamburger menu_mm">
									<i class="fa fa-bars menu_mm" aria-hidden="true"></i>
								</div>
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
</div>
</body>
</html>
