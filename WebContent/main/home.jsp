<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<div class="home_slider_background" style="background-image:url(img1.jpg);"></div>
				</div>
				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(img2.jpg)"></div>
				</div>
				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(img3.jpg)"></div>
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
						<h2>인기 작품</h2>
						<div style="border:1px solid #818CF8;0 width:100%"></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				<!-- 인기 작품 -->
				<c:forEach var="vo" items="${wList }" varStatus="s">
				<c:if test="${s.index<8 }">
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><a href="../work/work_detail_before.do?w_no=${vo.w_no }"><img src="${vo.w_poster }" style="width: 180px;height: 190px;" alt=""></a></div>
						<div class="team_body"  style="width: 340px;height: 275px;">
							<div class="team_title"><a href="../work/work_detail_before.do?w_no=${vo.w_no }">${vo.w_title }</a></div>
							<div class="team_subtitle">${vo.w_artist }</div>
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
			   </c:if>
			   </c:forEach>
			   
			   <div class="row" style="margin:0 auto">
				<div class="col">
					<div class="courses_button trans_200"><a href="../work/work_ingi.do">인기 작품 더보기</a></div>
				</div>
			</div>
		</div>
		<!-- ============================================== -->
		<div style="height:100px"></div>
		<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2>오늘의 발견</h2>
						<div style="border:1px solid #818CF8; width:100%"></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				<!-- 오늘의 발견 -->
				<c:forEach var="vo" items="${wList }" varStatus="s">
				<c:if test="${s.index>358 and s.index<367}">
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><a href="../work/work_detail_before.do?w_no=${vo.w_no }"><img src="${vo.w_poster }" style="width: 180px;height: 190px;" alt=""></a></div>
						<div class="team_body"  style="width: 340px;height: 275px;">
							<div class="team_title"><a href="../work/work_detail_before.do?w_no=${vo.w_no }">${vo.w_title }</a></div>
							<div class="team_subtitle">${vo.w_artist }</div>
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
			   </c:if>
			   </c:forEach>
			   
			   <div class="row" style="margin:0 auto">
				<div class="col">
					<div class="courses_button trans_200"><a href="../work/work_list.do">오늘의 발견 더보기</a></div>
				</div>
			</div>
		</div>
		<!-- ============================================== -->
		<div style="height:100px"></div>
		<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2>실시간 구매</h2>
						<div style="border:1px solid #818CF8; width:100%"></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				
				<!-- 실시간 구매 -->
				<c:forEach var="vo" items="${wList }" varStatus="s">
				<c:if test="${s.index>409 and s.index<418 }">
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><a href="../work/work_detail_before.do?w_no=${vo.w_no }"><img src="${vo.w_poster }" style="width: 180px;height: 190px;" alt=""></a></div>
						<div class="team_body"  style="width: 340px;height: 275px;">
							<div class="team_title"><a href="../work/work_detail_before.do?w_no=${vo.w_no }">${vo.w_title }</a></div>
							<div class="team_subtitle">${vo.w_artist }</div>
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
			   </c:if>
			   </c:forEach>
			   
			   <div class="row" style="margin:0 auto">
				<div class="col">
					<div class="courses_button trans_200"><a href="../work.work_silgu.do">실시간 구매 더보기</a></div>
				</div>
			</div>
		</div>
		
		<!-- ============================================== -->
		<div style="height:100px"></div>
		<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2>작가님 추천작품</h2>
						<div style="border:1px solid #818CF8; width:100%"></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				
				<!-- 작가님 추천작품 -->
				<c:forEach var="vo" items="${wList }" varStatus="s">
				<c:if test="${s.index>376 and s.index<385 }">
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><a href="../work/work_detail_before.do?w_no=${vo.w_no }"><img src="${vo.w_poster }" style="width: 180px;height: 190px;" alt=""></a></div>
						<div class="team_body"  style="width: 340px;height: 275px;">
							<div class="team_title"><a href="../work/work_detail_before.do?w_no=${vo.w_no }">${vo.w_title }</a></div>
							<div class="team_subtitle">${vo.w_artist }</div>
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
			   </c:if>
			   </c:forEach>
			   
			   <div class="row" style="margin:0 auto">
				<div class="col">
					<div class="courses_button trans_200"><a href="../work/work_jak.do">작가님 추천작품 더보기</a></div>
				</div>
			</div>
		</div>
		
		<!-- ============================================== -->
		<div style="height:100px"></div>
		<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2>실시간 추천작품</h2>
						<div style="border:1px solid #818CF8; width:100%"></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				
				<!-- 실시간 추천작품 -->
				<c:forEach var="vo" items="${wList }" varStatus="s">
				<c:if test="${s.index>425 and s.index<434 }">
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><a href="../work/work_detail_before.do?w_no=${vo.w_no }"><img src="${vo.w_poster }" style="width: 180px;height: 190px;" alt=""></a></div>
						<div class="team_body"  style="width: 340px;height: 275px;">
							<div class="team_title"><a href="../work/work_detail_before.do?w_no=${vo.w_no }">${vo.w_title }</a></div>
							<div class="team_subtitle">${vo.w_artist }</div>
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
			   </c:if>
			   </c:forEach>
			   
			   <div class="row" style="margin:0 auto">
				<div class="col">
					<div class="courses_button trans_200"><a href="../work/work_sil.do">실시간 추천작품 더보기</a></div>
				</div>
			</div>
		</div>
	  <div style="height:100px"></div>
<!-- /////// 쿠키 //////// -->
 <div class="box" >
  <div class="box_title" style="padding:20px"><h2>최근 본 작품</h2></div>
	<div class="box_latest cookieImg">
	 <c:forEach var="fvo" items="${fList }" varStatus="s">
	  <c:if test="${s.index<8 }">
		<a href="../work/work_detail.do?w_no=${fvo.w_no }">
		<div class="cookie_border" style="float:left; padding-right:20px; margin-center:0px auto">
		 <img class="radius-10 " data-aos="zoom-in-down" src="${fvo.w_poster }" title="${fvo.w_title }" 
		 style="width:150px;height:150px; margin-bottom: 20px; border-radius: 10px;">
		</div></a>
	  </c:if>
	</c:forEach>
   </div>
</div>

							
 	
	<!-- ------------------------------------------------------------------------------------------------------------------------------------- -->
			</div>
		</div>
	</div>
</body>
</html>