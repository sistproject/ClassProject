const form = document.getElementById("form"),
	  username = document.getElementById("username"),
	  id = document.getElementById("id"),
	  email = document.getElementById("email"),
	  password = document.getElementById("password"),
	  repassword = document.getElementById("repassword"),
	  btn = document.querySelector(".btn_submit");

//const nameValidation =  /^[가-힣]{2,4}$/;
const nameValidation =  /^[a-z0-9_-]{2,20}$/;
const emailValidation = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
const idValidation = /^[a-z0-9_-]{2,20}$/;   // 2-20글자 숫자&영문
//const pwValidation = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[~,!,@,#,$,*,(,),=,+,_,.,|]).*$/;
const notice = document.querySelector(".notice");


function showError(input, message) {
  const formControl = input.parentElement;
  formControl.className = "form_control error";
  const small = formControl.querySelector("small");
  small.innerText = message;
}

function showSuccess(input) {
  const formControl = input.parentElement;
  formControl.className = "form_control success";
  const small = formControl.querySelector("small");
  small.innerText = "success";
}

function allRequired() {
  notice.classList.add("show");
  setTimeout(() => {
    notice.classList.remove("show");
  }, 2000);
}

function isValidName() {
  const name = username.value;
  if (nameValidation.test(name.trim())) {
    showSuccess(username);
	allFilled();
  } else {
    showError(username, "Name is not valid");
  }
}
function isValidID() {
  const idv = id.value;
  if (idValidation.test(idv.trim())) {
    showSuccess(id);
	allFilled();
  } else {
    showError(id, "ID is more than 2 characters");
  }
}

function isValidPw() {
  const pwd = password.value;
  if (pwd.trim()) {
	 showSuccess(password);
	 checkPasswordsMatch();
	 allFilled();
	}
}

function isValidEmail() {
  const mail = email.value;	
  if (emailValidation.test(mail.trim())) {
    showSuccess(email);
	allFilled();
  } else {
    showError(email, "Email is not Valid");
  }
}

function checkPasswordsMatch() {
  const pwd = password.value;
  const repwd = repassword.value;	
  if (pwd !== repwd) {
    showError(repassword, "Passwords do not match");
  } else{
	showSuccess(repassword);
	allFilled();
  }
}

function allFilled(){
	const success = document.querySelectorAll(".success");
	console.log(success)
	if(success.length === 5){
		btn.disabled = false;	
		btn.style.color = '#fff';	
	}else{
		btn.disabled = true;
		btn.style.color = 'gray';
	}
}

function init(){
	username.addEventListener('input',isValidName);
	id.addEventListener('input',isValidID);
	email.addEventListener('input',isValidEmail);
	password.addEventListener('input',isValidPw);
	repassword.addEventListener('input',checkPasswordsMatch);
	form.addEventListener("change",allFilled);
	form.addEventListener("submit",allRequired);
}
init();