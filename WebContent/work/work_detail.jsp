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
<script type="text/javascript">
let i = 0;
$(function() {
	$('.delBtn').click(
			function() {
				let no = $(this).attr("data-no");
				let w_no = $(this).attr("data-w_no");
				location.href = "../work/work_reply_delete.do?no=" + no+ "&w_no=" + w_no;
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


</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
<script>
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

<div style="margin-top:150px"></div>
<div class="super_container">
  <!-- Course -->
	<div class="course">
		<div class="container">
			<div class="row">
			<!-- Course -->
				<!-- Blog Content -->
				<div class="col-lg-6" style="height:1600px;">
					<div class="blog_content">
						<div class="blog_meta" style="color:black; padding-bottom:15px; font-size:15px;">
							<ul>
							    <li>By          ${vo.w_artist }</li>
								<li>Post on     ${vo.w_regdate }</li>
							</ul>
						</div>
						<div class="blog_image"><img src="${vo.w_poster }" style="width:720px; height:1000px object-fit:fill" alt=""></div>
						<div style="margin-top:15px"></div>
						<div class="body" style="width:720px; height: 500px; padding-top:30px;">
							<div class="team_title" style="font-size:20px; color:black;">${vo.w_content }</div>
							 <div class="social_list"  style="padding-top:30px; color:black;font-size:16px">
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
	<div class="sidebar"  id="adsideWrapper">
	<!-- Categories -->
	<div class="team_body" id="adside"style="width:650px; height: 515px;padding-top:30px">
	 <div class="sidebar_section" >
		<div class="clearfix" style="padding-bottom:15px;font-size: 17px; text-align:left; color: black;">By &nbsp;${vo.w_artist }</div>
			<div class="sidebar_section_title" style="padding-bottom:50px;  text-align:left; color: black;"><h2>${vo.w_title }</h2></div>
			 <div class="sidebar_categories">
			  <ul class="categories_list" style="font-size: 22px; text-align:left; color: black;">
				<li class="clearfix" style="padding-bottom:20px;">가격&emsp;&emsp;&emsp;&emsp;${vo.w_price }원&emsp;
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;좋아요&emsp;${vo.w_like }</li>
				<li class="clearfix" style="padding-bottom:20px;">적립금&emsp;&emsp;${vo.w_point }포인트&emsp;&emsp;&emsp;&emsp;
				&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${vo.w_purchase }명&nbsp;구매</li>
				<li class="clearfix" style="padding-bottom:20px;">평점&emsp;&emsp;&emsp;&emsp;${vo.w_score }</li>
				<li class="clearfix" style="padding-bottom:50px;">배송기간&emsp;&emsp;${vo.w_delivery }</li>
			  </ul>
			</div>
		  </div>
		  <div  style="text-align:right">
		     <a href="../member/jjim.do?no=${vo.w_no}&type=w" class="myButton">찜</a>&nbsp;&nbsp;&nbsp;<a href="../cart/addcart.do?no=${vo.w_no }&type=w&amount=1" class="myrButton">결제하기</a>
		 <button onclick="location.href='../board/insert.do?type=0&wno=${vo.w_no}'">문의하기</button>
		  </div>
	    </div>
		</div>
      </div>
								<!-- Description -->
									<div class="tab_panel active reply">
									
									<c:choose>
									
										<c:when test="${sessionScope.id eq null }">
											<strong>로그인시 댓글 이용 가능합니다.</strong>
										</c:when>
										<c:otherwise>
											<form action="../work/work_reply_insert.do" method="post">
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
																			<div style="color:blue;">
																				By ${rvo.name }
																			</div>
																			<time datetime="2045-04-06T08:15+00:00">${rvo.dbday }</time>
																		</header>
																		<div class="comcont">
																			<pre style="white-space: pre-wrap; border: none; background-color: white;">${rvo.msg }</pre>
																		</div>
																	</article>
																</li>
																<li style="display: none" id="m${rvo.no }" class="updateli">
																	<form action="../work/work_reply_update.do" method="post">
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