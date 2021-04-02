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
		let form = $("#id").closest("div");
		let idsmall = $("#id + small");
		if(($('small').text()).indexOf('check')>0){
			let id=$('#id').val();
			$.ajax({
				type:'post',
				url:'../member/idcheck.do',
				data:{'id':id},
				success:function(result) {
					let count=result.trim();
					if(count==0){
						form.removeClass('error');	
						form.addClass('success');	
						idsmall.text("success");
					}else{
						form.removeClass('success');	
						form.addClass('error');		
						idsmall.text("ID already exist");
					}
					allFilled();
				}
			})
		}
	})
});
function allFilled(){
	const success = document.querySelectorAll(".success"),
		  btn = document.querySelector(".btn_submit");
	if(success.length === 5){
		btn.disabled = false;	
		btn.style.color = '#fff';	
	}else{
		btn.disabled = true;
		btn.style.color = 'gray';
		btn.style.cursor = "pointer";
	}
}
</script>
</head>
<body>
  <div class="container">
    <form id="form" class="form" method=post action="signin_ok.do">
      <h2>SIGN IN</h2>
      <div class="form_control">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="NAME" />
        <small>Error message</small>
      </div>
     <div class="form_control">
        <label for="id">ID</label>
        <input type="text" id="id" name="id" placeholder="ID" />
        <small style="float:left">Error message</small>
      </div>
        <div class="form_control">
          <label for="email">Email</label>
          <input type="text" id="email" name="email" placeholder="EMAIL" />
          <small>Error message</small>
        </div>
        <div class="form_control">
          <label for="password">Password</label>
          <input type="password" id="password" name="pwd" placeholder="PASSWORD" />
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