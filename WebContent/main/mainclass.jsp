<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="super_container">
	<!-- Home -->
	<div style="height:160px"></div>
	<div class="home">
		<div class="home_slider_container">
			
			<!-- Home Slider -->
			<div class="owl-carousel owl-theme home_slider">
				
				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(img5.jpg);"></div>
				</div>
				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(img7.jpg)"></div>
				</div>
				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(img9.jpg)"></div>
				</div>
			</div>
		</div>

		<!-- Home Slider Nav -->

		<div class="home_slider_nav home_slider_prev"><i class="fa fa-angle-left" aria-hidden="true"></i></div>
		<div class="home_slider_nav home_slider_next"><i class="fa fa-angle-right" aria-hidden="true"></i></div>
	</div>
			
<!-- ------------------------------------------------------------------------------------------------------------------------------------- -->
	<!-- /////////작품 메인/////////// -->

	<div class="team">
		<div class="team_background parallax-window" data-parallax="scroll" data-speed="0.8"></div>
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2>온라인 인기 클래스</h2>
						<div style="border:1px solid #818CF8;0 width:100%"></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				<!-- 온라인 클래스 -->
				<c:forEach var="onvo" items="${onList }">
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><a href="../online/online_detail_before.do?cno=${onvo.cno }"><img src="${fn:substring(onvo.cposter,0,fn:indexOf(onvo.cposter,'^'))}" style="width: 180px;height: 190px;" alt=""></a></div>
						<div class="team_body"  style="width: 340px;height: 275px;">
							<div class="team_title"><a href="../online/online_before.do?cno=${onvo.cno }">">${onvo.ctitle }</a></div>
							<div class="team_subtitle">${onvo.cartist }</div>
							<div class="social_list">
								<ul>
									<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			   </c:forEach>
			   
			   <div class="row" style="margin:0 auto">
				<div class="col">
					<div class="courses_button trans_200"><a href="../online/online.do">온라인 클래스 더보기</a></div>
				</div>
			</div>
		</div>
		<!-- ============================================== -->
		<div style="height:100px"></div>
		<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2>오프라인 인기클래스 </h2>
						<div style="border:1px solid #818CF8; width:100%"></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				<!-- 오프라인 인기클래스 -->
				<c:forEach var="offvo" items="${offList }">
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><a href="offclass/offclass_before.do?cno=${offvo.cno }"><img src="${offvo.cposter }" style="width: 180px;height: 190px;" alt=""></a></div>
						<div class="team_body"  style="width: 340px;height: 275px;">
							<div class="team_title"><a href="offclass/offclass_before.do?cno=${offvo.cno }">${offvo.ctitle }</a></div>
							<div class="team_subtitle">${offvo.cartist }</div>
							<div class="social_list">
								<ul>
									<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			   </c:forEach>
			   
			   <div class="row" style="margin:0 auto">
				<div class="col">
					<div class="courses_button trans_200"><a href="../class/trendclass.do">오프라인 인기클래스 더보기</a></div>
				</div>
			</div>
		</div>
		<!-- ============================================== -->
		<div style="height:100px"></div>
		<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2>오프라인 추천클래스</h2>
						<div style="border:1px solid #818CF8; width:100%"></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				
				<!-- 오프라인 추천클래스 -->
				<c:forEach var="offvo" items="${offList }" varStatus="s">
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><a href="offclass/offclass_before.do?cno=${offvo.cno }"><img src="${offvo.cposter }" style="width: 180px;height: 190px;" alt=""></a></div>
						<div class="team_body"  style="width: 340px;height: 275px;">
							<div class="team_title"><a href="offclass/offclass_before.do?cno=${offvo.cno }">${offvo.ctitle }</a></div>
							<div class="team_subtitle">${offvo.cartist }</div>
							<div class="social_list">
								<ul>
									<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			   </c:forEach>
			   
			   <div class="row" style="margin:0 auto">
				<div class="col">
					<div class="courses_button trans_200"><a href="../class/newclass.do">오프라인 추천클래스 더보기</a></div>
				</div>
			</div>
		</div>
		
		<!-- ============================================== -->
		<div style="height:100px"></div>
		<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2>오프라인 신규클래스</h2>
						<div style="border:1px solid #818CF8; width:100%"></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				
				<!-- 오프라인 신규클래스 -->
				<c:forEach var="offvo" items="${offList }">
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><a href="offclass/offclass_before.do?cno=${offvo.cno }"><img src="${offvo.cposter }" style="width: 180px;height: 190px;" alt=""></a></div>
						<div class="team_body"  style="width: 340px;height: 275px;">
							<div class="team_title"><a href="offclass/offclass_before.do?cno=${offvo.cno }">${offvo.ctitle }</a></div>
							<div class="team_subtitle">${offvo.cartist }</div>
							<div class="social_list">
								<ul>
									<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			   </c:forEach>
			   
			   <div class="row" style="margin:0 auto">
				<div class="col">
					<div class="courses_button trans_200"><a href="../class/recommendclass.do">오프라인 신규클래스 더보기</a></div>
				</div>
			</div>
		</div>
	<!-- ------------------------------------------------------------------------------------------------------------------------------------- -->
			</div>
		</div>
	</div>
</body>
</html>