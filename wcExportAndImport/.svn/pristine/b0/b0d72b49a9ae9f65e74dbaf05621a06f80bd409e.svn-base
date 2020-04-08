$().ready(function() {
	$("button").on("click",function(){
		if($(this).attr("id")=="next-step-2"){
			
			if(pwd()==false){
				return false;
			}
			logOne()
		}else if($(this).attr("id")=="next-step-3"){
			logTwo()
		}
	});

	

	function pwd(){
		var loginName = $('#loginName').val();
		var password = $('#password');
		var cfPassword = $('#cfPassword');
		if(3>loginName&&loginName<15){
			document.getElementById("errorLogName").innerHTML="用户名必须大于3位数或者小于15位数";
			return false;
		}
	/*	if(6>password&&password<20){
			document.getElementById("errorLogPwd").innerHTML="密码必须大于6位数或者小于20位数";
			return false;
		}
		if(cfPassword!=password){
			document.getElementById("errorLogCFPwd").innerHTML="密码不通";
			return false;
		}*/
		
		
		
		
	}













	function logOne(){
		if(document.getElementById("logDivOne").getAttribute("hidden")==null){
			document.getElementById("logDivOne").setAttribute("hidden","hidden")
			document.getElementById("logDivTwo").removeAttribute("hidden")
			document.getElementById("divBztow").className += ' register-header-current-step';
			document.getElementById("divBzOne").className="register-header-item";
		}else{
			document.getElementById("logDivTwo").setAttribute("hidden","hidden")
			document.getElementById("logDivOne").removeAttribute("hidden")
			document.getElementById("divBzOne").className += ' register-header-current-step';
			document.getElementById("divBztow").className="register-header-item";
		}
	}
	function logTwo(){
		if(document.getElementById("logDivTwo").getAttribute("hidden")==null){
			document.getElementById("logDivTwo").setAttribute("hidden","hidden")
			document.getElementById("logDivS").removeAttribute("hidden")
			document.getElementById("divBzs").className += ' register-header-current-step';
			document.getElementById("divBztow").className="register-header-item";
		}else{
			document.getElementById("logDivS").setAttribute("hidden","hidden")
			document.getElementById("logDivTwo").removeAttribute("hidden")
			document.getElementById("divBztow").className += ' register-header-current-step';
			document.getElementById("divBzs").className="register-header-item";
		}
	}
})