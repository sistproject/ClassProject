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
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/blog_single.css">
<link rel="stylesheet" type="text/css" href="styles/blog_single_responsive.css">

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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
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
	$('.replyBtn').click((event)=>{
		event.preventDefault();
		let msg = $('#msg').val();
		console.log(msg);
		$.ajax({
		    type:'post',
		    url: '../online/online_reply_insert.do',
		   	data: {
		   	'cno':${ondVO.cno},
		    'msg':msg
		    },
		    success: function(result){
				
		    		
		    }
		});
	})
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


출처: https://kaiequal.tistory.com/21 [카이이퀄]
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
	
	<!-- Home -->
     <div style="margin-top:150px"></div>

	<!-- Blog -->

	<div class="blog">
		<div class="container" style="padding-bottom:300px">
			<div class="row">

				<!-- Blog Content -->
				<div class="col-lg-6">
					<div class="blog_content">
						<div class="blog_meta" style="color:black; padding-bottom:15px; font-size:15px;">
							<ul>
							    <li>By          ${vo.w_artist }</li>
								<li>Post on     ${vo.w_regdate }</li>
							</ul>
						</div>
						<div class="blog_image"><img src="${vo.w_poster }" style="width:720px; height:600px object-fit:fill" alt=""></div>
						<div style="margin-top:15px"></div>
						<div class="team_body" style="width:720px; height: 700px">
							<div class="team_title" style="font-size:20px; color:black;">${vo.w_content }</div>
							 <div class="social_list"  style="padding-top:50px; color:black;font-size:16px">
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
		 <a href="../member/jjim.do?no=${vo.w_no}&type=w" class="myButton">찜</a><a href="#" class="myrButton">결제하기</a>
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
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/blog_single.js"></script>

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