<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Course Details</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/course.css">
<link rel="stylesheet" type="text/css"
	href="styles/course_responsive.css">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200&display=swap" rel="stylesheet">

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
<script type="text/javascript">
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
		
	});
	
	
	 $(document).ready(function () { 
		 var top = $('#adside').offset().top - parseFloat($('#adside').css('marginTop').replace(/auto/, 0));
		  $(window).scroll(function (event) {
		 var y = $(this).scrollTop();

		 if (y >= top) {
		 $('#adside').addClass('fixed');
		  } else {
		 $('#adside').removeClass('fixed');
		 }
		 });
		 });
	
	
</script>
<style type="text/css">
body{
	font-family: 'Source Sans Pro', sans-serif !important;
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

.myrButton {
	background-color:#a593e0;
	border-radius:28px;
	border:1px solid #a593e0;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	font-weight:bold;
	padding:13px 110px;
	text-decoration:none;
	text-shadow:0px 1px 0px #ffffff;
}
.myrButton:hover {
	background-color:#a593e0;
}
.myrButton:active {
	position:relative;
	top:1px;
}

#adsideWrapper {
 position: absolute;
}
#adside {
position: absolute;
top: 0;
}
#adside.fixed {
 position: fixed;
top: 80px;
margin-top:30px;
}

</style>
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
									<li><a href="courses.html">Courses</a></li>
									<li>Course Details</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Course -->

		<div class="course">
			<div class="container">
				<div class="row">

					<!-- Course -->
					<div class="col-lg-6">

						<div class="course_container">
							<div class="course_title">${ondVO.ctitle }</div>
							<div
								class="course_info d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">

								<!-- Course Info Item -->
								<div class="course_info_item">
									<div class="course_info_title">Teacher:</div>
									<div class="course_info_text">
										<a href="#">${ondVO.cartist }</a>
									</div>
								</div>

								<!-- Course Info Item -->
								<div class="course_info_item">
									<div class="course_info_title">Reviews:</div>
									<div class="rating_r rating_r_4">
										<i></i><i></i><i></i><i></i><i></i>
									</div>
								</div>

								<!-- Course Info Item -->
								<div class="course_info_item">
									<div class="course_info_title">Categories:</div>
									<div class="course_info_text">
										<a href="#">Languages</a>
									</div>
								</div>

							</div>

							<!-- Course Image -->





							<c:forEach var="poster" items="${pList}" varStatus="status">
								<div class="course_image">
									<img src="${poster}" alt="">
								</div>
								<p>${cList[status.index]}</p>
							</c:forEach>



							<!-- Course Tabs -->
							<div class="course_tabs_container">

								<div
									class="tabs d-flex flex-row align-items-center justify-content-start">
									<div class="tab active">수강평</div>
									<div class="tab">curriculum</div>
									<div class="tab">reviews</div>
								</div>
								<div class="tab_panels">



									<!-- Description -->
									<div class="tab_panel active reply">
									
									<c:choose>
									
										<c:when test="${sessionScope.id eq null }">
											<strong>로그인시 댓글 이용 가능합니다.</strong>
										</c:when>
										<c:otherwise>
											<form action="../online/online_reply_insert.do" method="post">
												<table class="table">
													<tr>
														<td><textarea rows="10" cols="100" name="msg"></textarea> 
															<input type="hidden" name=cno value="${ondVO.cno}"> 
															<input type="submit" value="댓글쓰기" class="btn btn-sm btn-danger">
															<c:forEach var="rvo" items="${rList }">
																<li>
																	<article>
																		<header>
																			<figure class="avatar">
																				<c:if test="${sessionScope.id==rvo.id }">
																					<span class="btn btn-xs btn-success updateBtn"
																						data-no="${rvo.no }">수정</span>
																					<span class="btn btn-xs btn-danger delBtn"
																						data-no="${rvo.no }" data-cno="${ondVO.cno }">삭제</span>
																				</c:if>
																			</figure>
																			<address>
																				By <a href="#">${rvo.name }</a>
																			</address>
																			<time datetime="2045-04-06T08:15+00:00">${rvo.dbday }</time>
																		</header>
																		<div class="comcont">
																			<pre style="white-space: pre-wrap; border: none; background-color: white;">${rvo.msg }</pre>
																		</div>
																	</article>
																</li>
																<li style="display: none" id="m${rvo.no }" class="updateli">
																	<form action="../online/online_reply_update.do" method="post">
																		<table class="table">
																			<tr>
																				<td>
																					<textarea rows="7" cols="25" name="msg">${rvo.msg }</textarea>
																					<input type="hidden" name=cno value="${ondVO.cno }">
																					<input type="hidden" name=no value="${rvo.no }"> <input type="submit" value="댓글수정" class="btn btn-sm btn-danger">
																				</td>
																			</tr>
																		</table>
																	</form>
																</li>
															</c:forEach>
															</td>
													</tr>
												</table>
											</form>
										</c:otherwise>
										</c:choose>
									</div>

									<!-- Curriculum -->
									<div class="tab_panel tab_panel_2">
										<div class="tab_panel_content">
											<div class="tab_panel_title">Software Training</div>
											<div class="tab_panel_content">
												<div class="tab_panel_text">
													<p>Lorem Ipsn gravida nibh vel velit auctor aliquet.
														Aenean sollicitudin, lorem quis bibendum auci elit
														consequat ipsutis sem nibh id elit. Duis sed odio sit amet
														nibh vulputate cursus a sit amet mauris. Morbi accumsan
														ipsum velit. Nam nec tellus a odio tincidunt auctor a
														ornare odio.</p>
												</div>

												<!-- Dropdowns -->
												<ul class="dropdowns">
													<li class="has_children">
														<div class="dropdown_item">
															<div class="dropdown_item_title">
																<span>Lecture 1:</span> Lorem Ipsn gravida nibh vel
																velit auctor aliquet.
															</div>
															<div class="dropdown_item_text">
																<p>Lorem Ipsn gravida nibh vel velit auctor aliquet.
																	Aenean sollicitudin, lorem quis bibendum auci elit
																	consequat ipsutis sem nibh id elit. Duis sed odio sit
																	amet nibh vulputate cursus.</p>
															</div>
														</div>
														<ul>
															<li>
																<div class="dropdown_item">
																	<div class="dropdown_item_title">
																		<span>Lecture 1.1:</span> Lorem Ipsn gravida nibh vel
																		velit auctor aliquet.
																	</div>
																	<div class="dropdown_item_text">
																		<p>Lorem Ipsn gravida nibh vel velit auctor
																			aliquet. Aenean sollicitudin, lorem quis bibendum
																			auci elit consequat ipsutis sem nibh id elit. Duis
																			sed odio sit amet nibh vulputate cursus.</p>
																	</div>
																</div>
															</li>
															<li>
																<div class="dropdown_item">
																	<div class="dropdown_item_title">
																		<span>Lecture 1.2:</span> Lorem Ipsn gravida nibh vel
																		velit auctor aliquet.
																	</div>
																	<div class="dropdown_item_text">
																		<p>Lorem Ipsn gravida nibh vel velit auctor
																			aliquet. Aenean sollicitudin, lorem quis bibendum
																			auci elit consequat ipsutis sem nibh id elit. Duis
																			sed odio sit amet nibh vulputate cursus.</p>
																	</div>
																</div>
															</li>
														</ul>
													</li>
													<li class="has_children">
														<div class="dropdown_item">
															<div class="dropdown_item_title">
																<span>Lecture 2:</span> Lorem Ipsn gravida nibh vel
																velit auctor aliquet.
															</div>
															<div class="dropdown_item_text">
																<p>Lorem Ipsn gravida nibh vel velit auctor aliquet.
																	Aenean sollicitudin, lorem quis bibendum auci elit
																	consequat ipsutis sem nibh id elit. Duis sed odio sit
																	amet nibh vulputate cursus.</p>
															</div>
														</div>
														<ul>
															<li>
																<div class="dropdown_item">
																	<div class="dropdown_item_title">
																		<span>Lecture 2.1:</span> Lorem Ipsn gravida nibh vel
																		velit auctor aliquet.
																	</div>
																	<div class="dropdown_item_text">
																		<p>Lorem Ipsn gravida nibh vel velit auctor
																			aliquet. Aenean sollicitudin, lorem quis bibendum
																			auci elit consequat ipsutis sem nibh id elit. Duis
																			sed odio sit amet nibh vulputate cursus.</p>
																	</div>
																</div>
															</li>
															<li>
																<div class="dropdown_item">
																	<div class="dropdown_item_title">
																		<span>Lecture 2.2:</span> Lorem Ipsn gravida nibh vel
																		velit auctor aliquet.
																	</div>
																	<div class="dropdown_item_text">
																		<p>Lorem Ipsn gravida nibh vel velit auctor
																			aliquet. Aenean sollicitudin, lorem quis bibendum
																			auci elit consequat ipsutis sem nibh id elit. Duis
																			sed odio sit amet nibh vulputate cursus.</p>
																	</div>
																</div>
															</li>
														</ul>
													</li>
													<li>
														<div class="dropdown_item">
															<div class="dropdown_item_title">
																<span>Lecture 3:</span> Lorem Ipsn gravida nibh vel
																velit auctor aliquet.
															</div>
															<div class="dropdown_item_text">
																<p>Lorem Ipsn gravida nibh vel velit auctor aliquet.
																	Aenean sollicitudin, lorem quis bibendum auci elit
																	consequat ipsutis sem nibh id elit. Duis sed odio sit
																	amet nibh vulputate cursus.</p>
															</div>
														</div>
													</li>
													<li>
														<div class="dropdown_item">
															<div class="dropdown_item_title">
																<span>Lecture 4:</span> Lorem Ipsn gravida nibh vel
																velit auctor aliquet.
															</div>
															<div class="dropdown_item_text">
																<p>Lorem Ipsn gravida nibh vel velit auctor aliquet.
																	Aenean sollicitudin, lorem quis bibendum auci elit
																	consequat ipsutis sem nibh id elit. Duis sed odio sit
																	amet nibh vulputate cursus.</p>
															</div>
														</div>
													</li>
													<li>
														<div class="dropdown_item">
															<div class="dropdown_item_title">
																<span>Lecture 5:</span> Lorem Ipsn gravida nibh vel
																velit auctor aliquet.
															</div>
															<div class="dropdown_item_text">
																<p>Lorem Ipsn gravida nibh vel velit auctor aliquet.
																	Aenean sollicitudin, lorem quis bibendum auci elit
																	consequat ipsutis sem nibh id elit. Duis sed odio sit
																	amet nibh vulputate cursus.</p>
															</div>
														</div>
													</li>
												</ul>
											</div>
										</div>
									</div>

									<!-- Reviews -->
									<div class="tab_panel tab_panel_3">
										<div class="tab_panel_title">Course Review</div>

										<!-- Rating -->
										<div class="review_rating_container">
											<div class="review_rating">
												<div class="review_rating_num">4.5</div>
												<div class="review_rating_stars">
													<div class="rating_r rating_r_4">
														<i></i><i></i><i></i><i></i><i></i>
													</div>
												</div>
												<div class="review_rating_text">(28 Ratings)</div>
											</div>
											<div class="review_rating_bars">
												<ul>
													<li><span>5 Star</span>
														<div class="review_rating_bar">
															<div style="width: 90%;"></div>
														</div></li>
													<li><span>4 Star</span>
														<div class="review_rating_bar">
															<div style="width: 75%;"></div>
														</div></li>
													<li><span>3 Star</span>
														<div class="review_rating_bar">
															<div style="width: 32%;"></div>
														</div></li>
													<li><span>2 Star</span>
														<div class="review_rating_bar">
															<div style="width: 10%;"></div>
														</div></li>
													<li><span>1 Star</span>
														<div class="review_rating_bar">
															<div style="width: 3%;"></div>
														</div></li>
												</ul>
											</div>
										</div>

										<!-- Comments -->
										<div class="comments_container">
											<ul class="comments_list">
												<li>
													<div
														class="comment_item d-flex flex-row align-items-start jutify-content-start">
														<div class="comment_image">
															<div>
																<img src="images/comment_1.jpg" alt="">
															</div>
														</div>
														<div class="comment_content">
															<div
																class="comment_title_container d-flex flex-row align-items-center justify-content-start">
																<div class="comment_author">
																	<a href="#">Milley Cyrus</a>
																</div>
																<div class="comment_rating">
																	<div class="rating_r rating_r_4">
																		<i></i><i></i><i></i><i></i><i></i>
																	</div>
																</div>
																<div class="comment_time ml-auto">1 day ago</div>
															</div>
															<div class="comment_text">
																<p>There are many variations of passages of Lorem
																	Ipsum available, but the majority have alteration in
																	some form, by injected humour.</p>
															</div>
															<div
																class="comment_extras d-flex flex-row align-items-center justify-content-start">
																<div class="comment_extra comment_likes">
																	<a href="#"><i class="fa fa-heart"
																		aria-hidden="true"></i><span>15</span></a>
																</div>
																<div class="comment_extra comment_reply">
																	<a href="#"><i class="fa fa-reply"
																		aria-hidden="true"></i><span>Reply</span></a>
																</div>
															</div>
														</div>
													</div>
													<ul>
														<li>
															<div
																class="comment_item d-flex flex-row align-items-start jutify-content-start">
																<div class="comment_image">
																	<div>
																		<img src="images/comment_2.jpg" alt="">
																	</div>
																</div>
																<div class="comment_content">
																	<div
																		class="comment_title_container d-flex flex-row align-items-center justify-content-start">
																		<div class="comment_author">
																			<a href="#">John Tyler</a>
																		</div>
																		<div class="comment_rating">
																			<div class="rating_r rating_r_4">
																				<i></i><i></i><i></i><i></i><i></i>
																			</div>
																		</div>
																		<div class="comment_time ml-auto">1 day ago</div>
																	</div>
																	<div class="comment_text">
																		<p>There are many variations of passages of Lorem
																			Ipsum available, but the majority have alteration in
																			some form, by injected humour.</p>
																	</div>
																	<div
																		class="comment_extras d-flex flex-row align-items-center justify-content-start">
																		<div class="comment_extra comment_likes">
																			<a href="#"><i class="fa fa-heart"
																				aria-hidden="true"></i><span>15</span></a>
																		</div>
																		<div class="comment_extra comment_reply">
																			<a href="#"><i class="fa fa-reply"
																				aria-hidden="true"></i><span>Reply</span></a>
																		</div>
																	</div>
																</div>
															</div>
														</li>
													</ul>
												</li>
												<li>
													<div
														class="comment_item d-flex flex-row align-items-start jutify-content-start">
														<div class="comment_image">
															<div>
																<img src="images/comment_3.jpg" alt="">
															</div>
														</div>
														<div class="comment_content">
															<div
																class="comment_title_container d-flex flex-row align-items-center justify-content-start">
																<div class="comment_author">
																	<a href="#">Milley Cyrus</a>
																</div>
																<div class="comment_rating">
																	<div class="rating_r rating_r_4">
																		<i></i><i></i><i></i><i></i><i></i>
																	</div>
																</div>
																<div class="comment_time ml-auto">1 day ago</div>
															</div>
															<div class="comment_text">
																<p>There are many variations of passages of Lorem
																	Ipsum available, but the majority have alteration in
																	some form, by injected humour.</p>
															</div>
															<div
																class="comment_extras d-flex flex-row align-items-center justify-content-start">
																<div class="comment_extra comment_likes">
																	<a href="#"><i class="fa fa-heart"
																		aria-hidden="true"></i><span>15</span></a>
																</div>
																<div class="comment_extra comment_reply">
																	<a href="#"><i class="fa fa-reply"
																		aria-hidden="true"></i><span>Reply</span></a>
																</div>
															</div>
														</div>
													</div>
												</li>
											</ul>
											<div class="add_comment_container">
												<div class="add_comment_title">Add a review</div>
												<div class="add_comment_text">
													You must be <a href="#">logged</a> in to post a comment.
												</div>
											</div>
										</div>
									</div>

								</div>
							</div>

						</div>
					</div>

					<!-- Course Sidebar -->
					<div class="col-lg-6">
					  <div style="margin-top:45px"></div>
						<div class="sidebar"  id="adsideWrapper">
						<!-- Categories -->
						<div class="team_body" id="adside"style="width:650px; height: 515px;padding-top:30px">
						 <div class="sidebar_section" >
							<div class="clearfix" style="padding-bottom:15px;font-size: 17px; text-align:left; color: black;">By &nbsp;${ondVO.cartist }</div>
								<button>문의하기</button>
								<div class="sidebar_section_title" style="padding-bottom:50px;  text-align:left; color: black;"><h2>${ondVO.ctitle }</h2></div>
								 <div class="sidebar_categories">
								  <ul class="categories_list" style="font-size: 22px; text-align:left; color: black;">
									<li class="clearfix" style="padding-bottom:20px;">가격&emsp;&emsp;&emsp;&emsp;${ondVO.cprice }원&emsp;</li>
									<li>좋아요&emsp;&emsp;&emsp;${ondVO.chit }</li>
									
									<li class="clearfix" style="padding-bottom:20px;">평점&emsp;&emsp;&emsp;&emsp;${ondVO.cscore }</li>
								  </ul>
								</div>
							</div>
							<div style="text-align:center;">
							 <a href="../member/jjim.do?no=${ondVO.cno}&type=cn" class="myButton">찜</a>
											
							<a href="../cart/addcart.do?no=${ondVO.cno }&type=c&amount=1" class="myrButton">수강신청</a>
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
	<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
	<script src="plugins/easing/easing.js"></script>
	<script src="plugins/parallax-js-master/parallax.min.js"></script>
	<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
	<script src="js/course.js"></script>
</body>
</html>