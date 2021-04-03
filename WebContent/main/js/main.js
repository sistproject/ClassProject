function isLogin(){
	const id = sessionStorage['id'];
	const logli = document.querySelector('.log');
	console.log(id,logli)
	if(id!==undefined){
		logli.innerHTML ='<a href="../main/main.do" onclick="logout()"><div>로그아웃</div></a>';
	}
}
function logout(){
	sessionStorage.clear();
}
window.onload=isLogin;