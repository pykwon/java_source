function zipCheck(){
	let url = "zipcheck.jsp?check=y";
	window.open(url, "post", 
	  "toolbar=no,width=500,height=400,top=200,left=100,status=yes,scrollbars=yes,menubar=no");
}

function idCheck(){
	if(regForm.id.value === ""){
		alert("id를 입력하시오");
		regForm.id.focus();
	}else{
		url = "idcheck.jsp?id=" + regForm.id.value;
		window.open(url, "id", "width=300,height=150,top=200,left=100");
	}
}


function inputCheck(){
	// 입력자료 검사
	if(regForm.id.value === ""){
		alert("id를 입력하시오");
		regForm.id.focus();
		return;
	}
	// 이하 생략...
	
	regForm.submit();
}

function funcLogin(){
	if(loginForm.id.value === ""){
		alert("회원 아이디 입력!");
		loginForm.id.focus();
	}else if(loginForm.passwd.value === ""){
		alert("회원 비밀번호 입력!");
		loginForm.passwd.focus();
	}else{
		loginForm.action="loginproc.jsp";
		loginForm.method="post";
		loginForm.submit();
	}
}

function funcNewMember(){
	location.href="register.jsp";
}




