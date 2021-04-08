<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="../main/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../main/css/shop-homepage.css">
<link rel="stylesheet" href="../main/styles/main_styles.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(()=>{
	$('.sendBtn').click(()=>{
		let subject = $('input[name=title]').val();
		if(subject.trim()==""){
			 $('input[name=id]').focus();
			return;
		}
		let content= $('textarea').val();
		if(content.trim()==""){
			 $('textarea').focus();
			return;
		}
		
		$('#frm').submit();
	})
})

</script>
<style>
.join_row{
	width:700px;
	margin: 0px auto;
}
 .sectiontitle{
	background-color:#E0E3DA;
	display:inline;
	padding: 10px;
	border-radius: 10px;
	font-family: 'Source Sans Pro', sans-serif;
}
.back,
.sendBtn {
	cursor:pointer;
	padding: .25rem .5rem;
    font-size: .875rem;
    line-height: 1.5;
    border-radius: .2rem;
    border:none;
    background-color: #A593E0;

}
.back{
	background-color:#E0E3DA;
	margin-left:15px;
}
.back:hover{
	background-color: #8269d3;
}
.sendBtn:hover{
	background-color: #8269d3;
}
</style>
</head>
<body>
<div class="wrapper row3 join_row">
		<div style="height:100px"></div>
		<h2 class="sectiontitle" class="text-center" style="display:block;text-align:center">답변하기</h2>
		<div style="height:30px"></div>
		<div style="height:800px;">
	 <form method=post action="../board/answer_ok.do?root=${bno}" id="frm" autocomplete="off">
    <table class="table">
    <tr>
    <th class="text-right danger" width=15%>ID</th>
    <td width=85%>
    	<input type=text name=id class="input-sm" size=55 value="${id}" readonly style="border: none;">
    </td>
    </tr>
    <tr>
    <th class="text-right danger" width=15%>제목</th>
    <td width=85%>
    	<input type=text name=title class="input-sm" size=55 value="re: ${vo.title}">
    </td>
    </tr>
    <tr>
    <th class="text-right danger" width=15% valign="top">내용</th>
    <td width=85%>
    	<textarea rows="10" cols="62" name=content></textarea>
    </td>
    </tr>
    <tr>
    <tr>
    <th class="text-right danger" width=15% valign="top">상품 정보</th>
    <td width=85%>
    	<input type=text name=add class="input-sm" size=55 readonly value="${vo.add}" style="border: none">
    	<input type=hidden name=addc value="${cno}">
    	<input type=hidden name=addw value="${wno}">
    </td>
    </tr>
    <tr>
    <td colspan="2" class="text-center">
        <button class="sendBtn">등록</button>
    	<button class="back" onclick="javascript:history.back();">취소</button>
    </td>
    </tr>
    </table>
    </form>
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