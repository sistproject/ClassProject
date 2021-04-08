<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.house').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	});
	
	$('.house').click(function(){
		let poster=$(this).attr("data-poster");
		let title=$(this).attr("data-title");
		let no=$(this).attr("data-no");
		$('#reserve_poster').attr("src",poster);
		$('#reserve_title').text(title);
		
		$.ajax({
			type:'post',
			url:'../offclass/date.do',
			data:{"no":no},
			success:function(result)
			{
				$('#offclass_date').html(result);
			}
		});
	});
})
</script>
</head>
<body>
  <table class="table">
      <tr class="house" data-poster="${vo.cposter }" data-title="${vo.ctitle }" data-no="${vo.cno }">
       <td class="text-center"><img src="${vo.cposter }" style="height: 30px;width:30px"></td>
       <td>${vo.ctitle }</td>
       <td>${vo.infoaddr }</td>
      </tr>
  </table>
</body>
</html>