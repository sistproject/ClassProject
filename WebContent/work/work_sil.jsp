<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.container{
	min-width:1550px;
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
.list_number ul li a{
   color:black;
}
</style>
</head>
<body>
<div class="super_container">
<!-- home -->

<div style="height: 120px"></div>
		<!-- /////////작품 메인/////////// -->

		<div class="team">
			<div class="team_background parallax-window" data-parallax="scroll"
				data-speed="0.8"></div>
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="section_title_container text-center">
							<h2>실시간 구매</h2>
							<div style="border: 1.5px solid #818CF8"></div>
						</div>
					</div>
				</div>
				<div class="row team_row">
					<!-- 실시간 구매 -->
					<c:forEach var="vo" items="${rList }" varStatus="s">
						<div class="col-lg-3 col-md-6 team_col">
							<div class="team_item" style="width: 250px; height: 295px">
								<div class="team_image">
									<a href="../work/work_detail_before.do?w_no=${vo.w_no }"><img
										src="${vo.w_poster }" alt=""></a>
								</div>
								<div class="team_body" style="width: 250px; height: 295px">
									<div class="team_title">
										<a href="../work/work_detail_before.do?w_no=${vo.w_no }">${vo.w_title }</a>
									</div>
									<div class="team_subtitle">${vo.w_artist }</div>
									<div class="social_list">
										<ul>
											<li><a href="#"><i class="fa fa-facebook"
													aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-twitter"
													aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-google-plus"
													aria-hidden="true"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
							<div style="height:100px"></div>
						</div>
					</c:forEach>

				</div>
				
				<div class="list_num" style="text-align: center; font-size: 39px;">
							<div class="col">
								<div class="list_number">
									<ul>
							          <c:if test="${startpage>1 }">
							           <li style="display:inline-block;"><a href="../work/work_sil.do?page=${startpage-1 }">이전</a></li>
							          </c:if>
							          <c:forEach var="i" begin="${startpage }" end="${endpage }" step="1">
							            <c:if test="${i==curpage }">
							             <c:set var="type" value="class=current"/>
							            </c:if>
							            <c:if test="${i!=curpage }">
							             <c:set var="type" value=""/>
							            </c:if>
							            <li ${type }  style="display:inline-block;"><a href="../work/work_sil.do?page=${i }">${i }</a></li>
							          </c:forEach>
							          <c:if test="${endpage<totalpage }">
							            <li  style="display:inline-block;"><a href="../work/work_sil.do?page=${endpage+1 }"> 다음</a></li>
							          </c:if>
							        </ul>
								</div>
							</div>
						</div>
			</div>
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