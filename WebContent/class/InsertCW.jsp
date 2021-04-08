<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function uploadImageByImgur(file, callback) {
		form = new FormData();
		form.append('image', file);
		$.ajax(
				{
					xhr : function() {
						var xhr = new window.XMLHttpRequest();
						xhr.upload.addEventListener("progress", function(evt) {// 업로드상태이벤트리스너등록
							if (evt.lengthComputable) {
								console.log("업로드진행률:"+ parseInt((evt.loaded / evt.total * 100),10) + "%");
							}
						}, false);
						return xhr;
					},
					url : 'https://api.imgur.com/3/image',// 업로드요청주소             
					headers : {
						Authorization : 'Client-ID 0ce4a2599304661'
					},
					type : 'POST',
					data : form,
					cache : false,
					contentType : false,
					processData : false
				}).always(callback);
	}

	/*

	 파일 변경 이벤트가 감지되면 자동으로 이미지 업로드

	 */
	$(document).ready(function() { // document가 모두 로드되면 실행됨
		$("input[name=img]").change(function() {// 사용자가 파일을 변경했을때 발생됨
			var file = this.files[0];
			uploadImageByImgur(file, function(result) {
				console.log(result);
				console.log('업로드결과:' + result.status);
				if (result.status != 200) {
					result = $.parseJSON(result.responseText);
				}
				if (result.data.error) {
					console.log('지원하지않는 파일형식..');
				} else {
					console.log('업로드된 파일경로:' + result.data.link);
					$('#preview').attr('src',result.data.link)
					$('input[name="poster"]').val(result.data.link);
				}
			});
		});
	});
	
	
	$(document).ready(function(){
		  var fileTarget = $('.filebox .upload-hidden');

		    fileTarget.on('change', function(){
		        if(window.FileReader){
		            var filename = $(this)[0].files[0].name;
		        } else {
		            var filename = $(this).val().split('/').pop().split('\\').pop();
		        }

		        $(this).siblings('.upload-name').val(filename);
		    });
		}); 
</script>


<style type="text/css">
.write_wrapper{
	width:800px;
	margin:0px auto;
	padding:10px;
}
#preview{
	max-width:200px;
	max-height:200px;
}

#type_list {
    width: 200px; /* 원하는 너비설정 */
    padding: .8em .5em; /* 여백으로 높이 설정 */
    font-family: inherit;  /* 폰트 상속 */
    background: url('이미지 경로') no-repeat 95% 50%; /* 네이티브 화살표를 커스텀 화살표로 대체 */
    border: 1px solid #999;
    border-radius: 0px; /* iOS 둥근모서리 제거 */
    -webkit-appearance: none; /* 네이티브 외형 감추기 */
    -moz-appearance: none;
    appearance: none;
}

#category_list {
    width: 500px; /* 원하는 너비설정 */
    padding: .8em .5em; /* 여백으로 높이 설정 */
    font-family: inherit;  /* 폰트 상속 */
    background: url('이미지 경로') no-repeat 95% 50%; /* 네이티브 화살표를 커스텀 화살표로 대체 */
    border: 1px solid #999;
    border-radius: 0px; /* iOS 둥근모서리 제거 */
    -webkit-appearance: none; /* 네이티브 외형 감추기 */
    -moz-appearance: none;
    appearance: none;
}




</style>
</head>
<body>
<div class="write_wrapper">
	<form action="../class/write.do" method="post">
		<input type="hidden" name="artist" value="artist">
		<input type="hidden" name="address" value="address">
		<input type="hidden" name="poster" value="">
		
		<select id="type_list" name="type_list">
			<option value="작품">작품</option>
			<option value="온라인">온라인 클래스</option>
			<option value="오프라인">오프라인 클래스</option>
		</select>
		<select id="category_list" name="category_list">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
		</select>
		<br>
		<input name="img" type="file" id="img"/><br>
		<img src="" id="preview">
		<input type="text" name="title" class="form-control"
			placeholder="제목을 입력해주세요." required>
		<textarea class="form-control" rows="10" name="content"
			placeholder="내용을 입력해주세요" required></textarea>
		<div class="inline_box">
			<input type="text" id="time" name="time" class="form-control col-lg-4"
			placeholder="시간(분)" required>
			<input type="text" id="price" name="price" class="form-control col-lg-4"
			placeholder="가격(원)" required>
		</div>
		<button type="submit" class="btn btn-secondary mb-3">글쓰기</button>
	</form>
</div>
</body>
</html>