<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Form Validator</title>
<link rel="stylesheet" href="style.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(()=>{
	$('#id').on("change keyup paste",()=>{
		let form = $("#id").parents("div")
		if(($('small').text()).indexOf('check')>0){
			let id=$('#id').val();
			console.log(id)
			$.ajax({
				type:'post',
				url:'../member/idcheck.do',
				data:{'id':id},
				success:function(result) {
					let count=result.trim();
					console.log(count);
					if(count==0){
						form.removeClass('error');	
						form.addClass('success');	
						$('small').text("success");
					}else{
						form.addClass('error');		
						$('small').text("ID already exist");
					}
				}
			})
		}
	})
});
</script>
</head>
<body>
  <div class="container">
    <form id="form" class="form" method=post action="signin_ok.jsp">
      <h2>SIGN IN</h2>
      <div class="form_control">
        <label for="username">Username</label>
        <input type="text" id="username" placeholder="NAME" />
        <small>Error message</small>
      </div>
     <div class="form_control">
        <label for="id">ID</label>
        <input type="text" id="id" placeholder="ID" />
        <small style="float:left">Error message</small>
        <!--  <button class="check btn_ck" >check</button>-->
      </div>
      <!-- 중복체크!!!! 클릭하면 돌아가는 모션 -> 가능하면 success-->
    <!-- 존재하는 아이디는 err: 존재하는 아이디-->
        <div class="form_control">
          <label for="email">Email</label>
          <input type="text" id="email" placeholder="EMAIL" />
          <small>Error message</small>
        </div>
        <div class="form_control">
          <label for="password">Password</label>
          <input type="password" id="password" placeholder="PASSWORD" />
          <small>Error message</small>
        </div>
        <div class="form_control">
          <label for="repassword">Confirm Password</label>
          <input type="password" id="repassword" placeholder="REPASSWORD" />
          <small>Error message</small>
        </div>
        <button class="btn_submit" disabled>Submit</button>
      </form>
    </div>
    <p class="notice">
      Welcome!
    </p>
    <script src="script.js" charset="UTF-8"></script>
  </body>
</html>