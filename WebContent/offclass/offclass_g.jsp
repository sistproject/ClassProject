<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Courses</title>
<style type="text/css">
ul.pagination_list{
	  display: table;
	  margin-left: auto;
	  margin-right: auto;
}

</style>
<link rel="stylesheet" type="text/css" href="styles/courses.css">
<link rel="stylesheet" type="text/css" href="styles/courses_responsive.css">
</head>
<body>

<div class="super_container">

	<!-- Home -->

	<div class="home">
		<div class="breadcrumbs_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="breadcrumbs">
							<ul>
								<li><a href="../main/main.do">Home</a></li>
								<li>Courses</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>			
	</div>

	<!-- Courses -->

	<div class="courses">
		<div class="container">
			<div class="row">

				<!-- Courses Main Content -->
				<div class="col-lg-8">
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
							<c:forEach var="ofg" items="${ofgList}"> 
							<div class="col-lg-6 course_col">
								<div class="course">
									<div class="course_image"><img src="${ofg.cposter }" alt=""></div>
									<div class="course_body">
										<div class="course_category">${ofg.ccategory }</div>
										<h3 class="course_title"><a href="../offclass/offclass_detail.do?cno=${ofg.cno }">${ofg.ctitle }</a></h3>
										<div class="course_teacher">${ofg.cartist }</div>
									</div>
									<div class="course_footer">
										<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
											<div class="course_info">
												<span>${ofg.infoaddr }</span>
											</div>
											<div class="course_info">
												<i class="fa fa-star" aria-hidden="true"></i>
												<span>${ofg.cscore }</span>
											</div>
											<div class="course_price ml-auto">${ofg.cprice }</div>
										</div>
									</div>
								</div>
							</div>
							</c:forEach>
							

						</div>
						<div class="row pagination_row">
							<div class="col">
								<div class="pagination_container d-flex flex-row align-items-center justify-content-start">
									<ul class="pagination_list">
							          <c:if test="${startPage>1 }">
							           <li><a href="../offclass/offclass_g.do?page=${startPage-1 }">이전</a></li>
							          </c:if>
							          <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
							            <c:if test="${i==curpage }">
							             <c:set var="type" value="class=current"/>
							            </c:if>
							            <c:if test="${i!=curpage }">
							             <c:set var="type" value=""/>
							            </c:if>
							            <li ${type }><a href="../offclass/offclass_g.do?page=${i }">${i }</a></li>
							          </c:forEach>
							          <c:if test="${endPage<totalPage }">
							            <li><a href="../offclass/offclass_g.do?page=${endPage+1 }"> 다음</a></li>
							          </c:if>
							        </ul>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Courses Sidebar -->
				<div class="col-lg-4">
					<div class="sidebar">

						<!-- Categories -->
						<div class="sidebar_section">
							<div class="sidebar_section_title">Categories</div>
							<div class="sidebar_categories">
								<ul>
									<li><a href="../offclass/offclass_a.do">공예</a></li>
									<li><a href="../offclass/offclass_b.do">요리</a></li>
									<li><a href="../offclass/offclass_c.do">미술</a></li>
									<li><a href="../offclass/offclass_e.do">플라워</a></li>
									<li><a href="../offclass/offclass_f.do">뷰티</a></li>
									<li><a href="../offclass/offclass_g.do">체험및기타</a></li>
								</ul>
							</div>
						</div>


						<!-- Cookie -->
						<div class="sidebar_section">
							<div class="sidebar_section_title">최근 방문한 오프라인 클래스</div>
								<c:forEach var="kvo" items="${kList }" varStatus="s">
							        <c:if test="${s.index<9 }">
							         <a href="../offclass/offclass_detail.do?cno=${kvo.cno }">
							         <img class="radius-10 " src="${kvo.cposter }" title="${kvo.ctitle }" style="width:100px;height:100px"></a>
							        </c:if>
							      </c:forEach>
						</div>


<%--
						<!-- Latest Course -->
						<div class="sidebar_section">
							<div class="sidebar_section_title">Latest Courses</div>
							<div class="sidebar_latest">

								<!-- Latest Course -->
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="images/latest_1.jpg" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a href="course.html">How to Design a Logo a Beginners Course</a></div>
										<div class="latest_price">Free</div>
									</div>
								</div>

								<!-- Latest Course -->
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="images/latest_2.jpg" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a href="course.html">Photography for Beginners Masterclass</a></div>
										<div class="latest_price">$170</div>
									</div>
								</div>

								<!-- Latest Course -->
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="images/latest_3.jpg" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a href="course.html">The Secrets of Body Language</a></div>
										<div class="latest_price">$220</div>
									</div>
								</div>

							</div>
						</div>

						<!-- Gallery -->
						<div class="sidebar_section_title">Instagram</div>
							<div class="sidebar_gallery">
								<ul class="gallery_items d-flex flex-row align-items-start justify-content-between flex-wrap">
									<li class="gallery_item">
										<div class="gallery_item_overlay d-flex flex-column align-items-center justify-content-center">+</div>
										<a class="colorbox" href="images/gallery_1_large.jpg">
											<img src="images/gallery_1.jpg" alt="">
										</a>
									</li>
									<li class="gallery_item">
										<div class="gallery_item_overlay d-flex flex-column align-items-center justify-content-center">+</div>
										<a class="colorbox" href="images/gallery_2_large.jpg">
											<img src="images/gallery_2.jpg" alt="">
										</a>
									</li>
									<li class="gallery_item">
										<div class="gallery_item_overlay d-flex flex-column align-items-center justify-content-center">+</div>
										<a class="colorbox" href="images/gallery_3_large.jpg">
											<img src="images/gallery_3.jpg" alt="">
										</a>
									</li>
									<li class="gallery_item">
										<div class="gallery_item_overlay d-flex flex-column align-items-center justify-content-center">+</div>
										<a class="colorbox" href="images/gallery_4_large.jpg">
											<img src="images/gallery_4.jpg" alt="">
										</a>
									</li>
									<li class="gallery_item">
										<div class="gallery_item_overlay d-flex flex-column align-items-center justify-content-center">+</div>
										<a class="colorbox" href="images/gallery_5_large.jpg">
											<img src="images/gallery_5.jpg" alt="">
										</a>
									</li>
									<li class="gallery_item">
										<div class="gallery_item_overlay d-flex flex-column align-items-center justify-content-center">+</div>
										<a class="colorbox" href="images/gallery_6_large.jpg">
											<img src="images/gallery_6.jpg" alt="">
										</a>
									</li>
								</ul>
							</div>
						</div>   
						
						--%>

						<!-- Tags -->
						

						<!-- Banner -->
						
					</div>
				</div>
			</div>
		</div>
	</div>



 --%>
 
 
 
	<!-- Newsletter -->

	

	<!-- Footer -->


</div>

</body>
</html>