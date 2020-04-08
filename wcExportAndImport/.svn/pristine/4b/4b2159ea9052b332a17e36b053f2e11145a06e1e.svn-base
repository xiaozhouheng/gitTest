<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
<title>登录</title>
<link rel="stylesheet" type="text/css" href="../statics/login/css/jquery.alerts.css" />
<link rel="stylesheet" type="text/css" href="../statics/login/css/headerfooterindex.css" />
<link rel="stylesheet" type="text/css" href="../statics/login/css/login.css" />
<link rel="stylesheet" type="text/css" href="../statics/login/css/login1.css" />
<script type="text/javascript" src="../statics/login/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="../statics/login/js/jquery.cookie.js"></script>
<script type="text/javascript" src="../statics/login/js/jquery.alerts.js"></script>
<script type="text/javascript" src="../statics/login/js/png.js"></script>
<script type="text/javascript" src="../statics/login/js/cas.login.js"></script>
<script type="text/javascript" src="../statics/login/js/capsLock.js"></script>
</head>
<body class="body">
	<div class="login-main">
	<div class="login-main-left">
		<!-- <img src="../statics/img/login/loginleft.png" /> -->
	</div>
	<div class="login-main-right">
     <!-- <div class="index-login">
			<div class="login-tab clearfix">
				<div class="float-left"><span>用户登录</span></div>
			</div>
			<div class="login-con">
				<div class="login-item" style="display: block;">
					<span id="err_con_tip" class="error-tip"></span>
					<form class="m-sign-in" id="loginForm" autocomplete="off" >action = "/user/login.do" 
						<ul>
							<li>
								<div class="input-box"><input name="username" id="username" type="text" placeholder="用户名"></div>
							</li>
							<li>
								<div class="input-box"><input name=password id="pwd" type="password" placeholder="密码 "></div>
							</li>
							<li>
								<a href="javascript:;" id="btn" class="btn-login" onclick="login()">登录</a>
							</li>
						</ul>
					</form>
				</div>
			</div>
		</div> -->
		<form class="m-sign-in" id="loginForm" action="/wcExportAndImport/login" autocomplete="off" method="POST">
		<div class="login-content">
					<h1>用户登录</h1>
					<div class="textbox">
						<i class="text-icon"></i>
						<input class="username" id ="username" type="text" name="username" placeholder="请输入用户名">
						<span id="userErr" title="请输入用户名" style="color:red;"></span>
						<i class="text-del"></i>
					</div>
					<div class="textbox ">
						<i class="text-icon password-icon"></i>
						<input id="password" type="password" name="password" placeholder="请输入密码">
						<span id="PwdErr" style="color:red;"></span>
						<i class="text-del"></i>
					</div>
        			<button class="sublit" type= "submit">登录</button>
        			<p class="forget">
        				<!-- <a href="/client/register/a=forgetPassword" target="_blanck" class="passwprds">忘记登录密码？</a> -->
        				<a href="JavaScript:;" class="passwprds"></a>
        				<a href="http://localhost:8080/wcExportAndImport/page/register" class="registers">免费注册</a>
        			</p>
        			
				</div>
				</form>
	</div>
	</div>
</body>
<script type="text/javascript">
//实时监听输入框
/* $('#username').live('input propertychange', function(){
		userErr.innerHTML="";
})
$('#password').live('input propertychange', function(){
		PwdErr.innerHTML="";
})
 function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	var userErr = document.getElementById("userErr");
	var PwdErr = document.getElementById("PwdErr");
	
	if(!$("#loginForm input[name='username']").val()) {
		userErr.innerHTML="用户名不能为空";
		return;
	}else if(!$("#loginForm input[name='password']").val()){
		userErr.innerHTML="";
		PwdErr.innerHTML="密码不能为空";
		return;
	}else{
		userErr.innerHTML="";
		PwdErr.innerHTML="";
		ExecuteAjax()
	}
	
	}
 function ExecuteAjax(){
	 var data = $('#loginForm').serialize();
	 $.ajax({
		type:"POST",
		async:false,
		dataType: "json",
		url:"/wcExportAndImport/user/login",
		data:data,
		success:function(data){
					if(data.status == 200){
						jAlert('登录成功！',"提示", function(){
							 if(data.msg==0){   
								location.href = "http://localhost:8080/wcExportAndImport/";         
							} else {          
								location.href = "http://localhost:8080/wcExportAndImport/";            
							}
						});
					}else{
						jAlert("登录失败，原因是：" + data.msg,"失败");
					}
				},
		error:function(){
			alert("崩溃了")
		}
		});
 } */
</script>
</html>