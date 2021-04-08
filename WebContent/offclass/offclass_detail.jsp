  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<title>Course Details</title>
<style type="text/css">
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
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
$(function(){
	$('.delBtn').click(function(){
		let no=$(this).attr("data-no");
		let cno=$(this).attr("data-cno");
		location.href="../offclass/offclass_reply_delete.do?no="+no+"&cno="+cno;
	});
	
	$('.updateBtn').click(function(){
		$('.updateli').hide();
		$('.updateBtn').text("수정");
		let no=$(this).attr("data-no");
		if(i==0)
		{
			$(this).text("취소");
			$('#m'+no).show("slow");
			i=1;
		}
		else
		{
			$(this).text("수정");
			$('#m'+no).hide("slow");
			i=0;
		}
		
	});
});
</script>
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
<link rel="stylesheet" type="text/css" href="styles/course.css">
<link rel="stylesheet" type="text/css" href="styles/course_responsive.css">
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
								<li><a href="../offclass/offclass.do">오프라인 클래스</a></li>
								<li>${vo.ccategory }</li>
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
				<div class="col-lg-8">
					
					<div class="course_container">
						
						<div class="course_title">${vo.ctitle }</div>
						<div class="course_info d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">

							<!-- Course Info Item -->
							<div class="course_info_item">
								<div class="course_info_title">위치:</div>
								<div class="course_info_text"><a href="#">${vo.infoaddr }</a></div>
							</div>

							<!-- Course Info Item -->
							<div class="course_info_item">
								<div class="course_info_title">평점:</div>
								<div class="course_info_text">${vo.cscore }</a></div>
							</div>

							<!-- Course Info Item -->
							<div class="course_info_item">
								<div class="course_info_title">아티스트:</div>
								<div class="course_info_text">${vo.cartist }</a></div>
							</div>

						</div>

						<!-- Course Image -->
						<div class="course_image"><img src="${vo.cposter }" alt=""></div>

						<!-- Course Tabs -->
						<div class="course_tabs_container">
							<div class="tabs d-flex flex-row align-items-center justify-content-start">
								<div class="tab active">소개</div>
								<div class="tab">위치</div>
								<div class="tab">후기</div>
							</div>
							<div class="tab_panels">

								<!-- Description -->
								<div class="tab_panel active">
									<div class="tab_panel_title">${vo.ctitle }</div>
									<div class="tab_panel_content">
										<div class="tab_panel_text">
											<p>${vo.cintro} ${vo.csubtitles }</p>
										</div>
										<div class="tab_panel_section">
											<div class="tab_panel_subtitle">내용</div>
											<div class="tab_panel_text">
												<p>${vo.ccontent }</p>
											</div>
										</div>
										<div class="tab_panel_section">
											<div class="tab_panel_subtitle"></div>
											<div class="tab_panel_text">
												<p></p>
											</div>
										</div>
										
									</div>
								</div>

								<!-- Curriculum -->
								<div class="tab_panel tab_panel_2">
									<div class="tab_panel_content">
										<div class="tab_panel_title">Software Training</div>
										<div class="tab_panel_content">
											<div class="tab_panel_text">
												<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio.</p>
											</div>

											<!-- Dropdowns -->
											<ul class="dropdowns">
												<li class="has_children">
													<div class="dropdown_item">
														<div class="dropdown_item_title"><span>Lecture 1:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
														<div class="dropdown_item_text">
															<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
														</div>
													</div>
													<ul>
														<li>
															<div class="dropdown_item">
																<div class="dropdown_item_title"><span>Lecture 1.1:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
																<div class="dropdown_item_text">
																	<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
																</div>
															</div>
														</li>
														<li>
															<div class="dropdown_item">
																<div class="dropdown_item_title"><span>Lecture 1.2:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
																<div class="dropdown_item_text">
																	<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
																</div>
															</div>
														</li>
													</ul>
												</li>
												
												
											</ul>
										</div>
									</div>
								</div>

								<!-- Reviews -->
								<div class="tab_panel tab_panel_3">
									<div class="tab_panel_title">Course Review</div>
										<c:if test="${sessionScope.id!=null }">
									        <form action="../offclass/offclass_reply_insert.do" method="post">
									          <table class="table" style="text-center">
									            <tr>
									             <td>
									              <textarea rows="10" cols="100" name="msg"></textarea>
									              <input type="hidden" name=cno value="${vo.cno }">
									              <br>
									              <input type="submit" value="댓글쓰기" class="btn btn-sm btn-danger">
									             </td>
									            </tr>
									          </table>
									        </form>
								        </c:if>
									<!-- Comments -->
									<div class="comments_container">
										<ul class="comments_list">
										<c:forEach var="rvo" items="${rList }">
											<li>
											
												<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
													<div class="comment_image"><div><img src="images/rr.png" alt=""></div></div>
													<div class="comment_content">
														<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
														<div class="comment_author"><a href="#">${rvo.name }</a></div>
														<figure class="avatar">
															<c:if test="${sessionScope.id==rvo.id }">
																<span class="btn btn-xs btn-success updateBtn"
																	data-no="${rvo.no }">수정</span>
																<span class="btn btn-xs btn-danger delBtn"
																	data-no="${rvo.no }" data-cno="${vo.cno }">삭제</span>
															</c:if>
														</figure>
															
															<div class="comment_time ml-auto">${rvo.dbday }
															
															</div>
														</div>
														<div class="comment_text">
															<pre style="white-space: pre-wrap;border:none;background-color:white;">${rvo.msg }</pre>
														</div>
													
													</div>
												</div>
												</li>
												<li style="display: none" id="m${rvo.no }" class="updateli">

								 	<table class="table">
										<tr>
											<td>
												<textarea rows="7" cols="120" name="msg">${rvo.msg }</textarea>
												<input type="hidden" name=cno value="${vo.cno }">
												<input type="hidden" name=no value="${rvo.no }"> <input type="submit" value="댓글수정" class="btn btn-sm btn-danger">
											</td>
										</tr>
									</table> 

							</li>
						</c:forEach>
						
										
										</ul>

										<div class="add_comment_container">
											<div class="add_comment_title">Add a review</div>
											<div class="add_comment_text">You must be <a href="../member/login.do">logged</a> in to post a comment.</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<!-- Course Sidebar -->
				<div class="col-lg-4">
					<div class="sidebar">

						<!-- Feature -->
						<div class="sidebar_section">
							<div class="sidebar_section_title">Course Feature</div>
							<div class="sidebar_feature">
								<div class="course_price">${vo.cprice }</div>

								<!-- Features -->
								<div class="feature_list">

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-clock-o" aria-hidden="true"></i><span>소요시간:</span></div>
										<div class="feature_text ml-auto">${vo.ctime }</div>
									</div>

								
									
								
          							
										<a href="../member/jjim.do?no=${vo.cno}&type=cf" class="myButton">찜</a>&nbsp;&nbsp;&nbsp;<a href="../offclass/reserve.do?no=${vo.cno }" class="myrButton">예약하기</a>
								<button onclick="location.href='../board/insert.do?type=0&cno=${vo.cno}'">문의하기</button>

								</div>
							</div>
						</div>

						<!-- Feature -->
						

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Newsletter -->


	
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