<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Courses</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/courses.css">
<link rel="stylesheet" type="text/css" href="styles/courses_responsive.css">
<link rel="stylesheet" type="text/css" href="../online/styles/courses.css">
<link rel="stylesheet" type="text/css" href="../online/styles/courses_responsive.css">

<!-- fade -->
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<style type="text/css">
.container{
	min-width: 1550px;
}
</style>
</head>
<body>

<div class="super_container">
	<div class="courses" style="margin-top: 60px">
		<div class="container">
			<div class="row">

				<!-- Courses Main Content -->
				<div class="col-lg-9">
					<div class="courses_search_container">
						<form action="#" id="courses_search_form" class="courses_search_form d-flex flex-row align-items-center justify-content-start">
							<input type="search" class="courses_search_input" placeholder="Search Courses" required="required">
							<select id="courses_search_select" class="courses_search_select courses_search_input">
								<option>All Categories</option>
								<option>Category</option>
								<option>Category</option>
								<option>Category</option>
							</select>
							<button action="submit" class="courses_search_button ml-auto">search now</button>
						</form>
					</div>
					<div class="courses_container">
						<div class="row courses_row">
							
				<!-- Course -->
				
				<c:forEach var="al" items="${allList}"> 
					<div class="col-lg-3 course_col" data-aos="zoom-in-down">
						<div class="course">
							<div class="course_image"><img src="${al.cposter }" alt=""/></div>
							<div class="course_body">
								<div class="course_text">
								<p>${al.ccategory }</p>
								</div>
								<h4 class="course_title"><a href="../online/online_before.do?cno=${al.cno }">${al.ctitle }</a></h4>
								<div class="course_teacher">${al.cartist}</div>
							</div>
							<div class="course_footer">
								<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
									<div class="course_info">
										<i class="fa fa-eye" aria-hidden="true"></i>
										<span>${al.chit}</span>
									</div>
									<div class="course_info">
										<i class="fa fa-star" aria-hidden="true"></i>
										<span>${al.cscore }</span> 
									</div>
									<div class="course_price ml-auto">${al.cprice}</div>
								</div>
							</div>
						</div>
					</div>
					
				</c:forEach>

						</div>
						<div class="row pagination_row">
							<div class="col">
								<div class="list_number" style="text-align: center">
									<ul class="pagination_list">
							          <c:if test="${startPage>1 }">
							           <li style="display:inline-block;"><a href="../class/trendclass.do?page=${startPage-1 }">??????</a></li>
							          </c:if>
							          <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
							            <c:if test="${i==curpage }">
							             <c:set var="type" value="class=current"/>
							            </c:if>
							            <c:if test="${i!=curpage }">
							             <c:set var="type" value=""/>
							            </c:if>
							            <li ${type }  style="display:inline-block;"><a href="../class/trendclass.do?page=${i }">${i }</a></li>
							          </c:forEach>
							          <c:if test="${endPage<totalPage }">
							            <li  style="display:inline-block;"><a href="../class/trendclass.do?page=${endPage+1 }"> ??????</a></li>
							          </c:if>
							        </ul>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Courses Sidebar -->
				<div class="col-lg-3">
					<div class="sidebar">

						<!-- Latest Course -->
						<div class="sidebar_section">
							<div class="sidebar_section_title">?????? ??? ?????????</div>
							<div class="sidebar_latest cookieImg">
						      <c:forEach var="kvo" items="${kList }" varStatus="s">
						        <c:if test="${s.index<9 }">
						         <a href="../online/online_detail.do?cno=${kvo.cno }">
						         <div class="cookie_border">
						         	<img class="radius-10 " data-aos="zoom-in-down" src="${kvo.cposter }" title="${kvo.ctitle }" style="width:332px;height:180px; margin-bottom: 20px; border-radius: 10px;"></a>
						         </div>	
						        </c:if>
						      </c:forEach>
							</div>
						</div>
					</div>
				<div style="height:30px;"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/courses.js"></script>
<!-- fade -->
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
  AOS.init();
</script>
</body>
</html>