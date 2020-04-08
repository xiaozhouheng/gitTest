<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<!--注册页面-->
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<!--  禁止在移动设备上缩放   -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />

<title><spring:message code="register.zh" /></title>
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/iconfont.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/register.css" />
<script type="text/javascript"
	src="<%=path%>/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<script type="text/javascript">
	//鼠标滑过显示
	$(function () {
   /*  $(".dropdown").mouseover(function () {
        $(this).addClass("open");
    });

    $(".dropdown").mouseleave(function(){
        $(this).removeClass("open");
    }) */

})
var pwdcode = false;
$().ready(function() {
	$("button").on("click",function(){
		if($(this).attr("id")=="next-step-2"){
			if(pwd()==false){
				return false;
			}
			logOne()
		} else if($(this).attr("id")=="next-step-3"){
			if(pwd2()==false){
				return false;
			}
		} 
	});
//检验用户名是否存在
	 $("#userName").blur(function() {
		 var userName = $('#userName').val();
		 var length = userName.length;
		 if(length<3 || length>15){
			 document.getElementById("errorLogName").innerHTML="用户名必须大于3位数或者小于15位数";
			 return false;
		 }else{
			$.post('<%=path%>/register/uname.do',{userName:userName},
			         function(result){
				     if(result ==0){
				    	 document.getElementById("errorLogName").innerHTML="";
				     }else{
				    	 document.getElementById("errorLogName").innerHTML="该用户名已存在";
				    	 return false;
				     }
			   }		
			)
		 }
    }); 
	 
	 $("#password").blur(function(){
		 var password = $('#password').val();
		 var length1=password.length;
		 if(6>length1 || length1>20){
				document.getElementById("errorLogPwd").innerHTML="密码必须大于6位数或者小于20位数";
				return false;
			}else{
				document.getElementById("errorLogPwd").innerHTML="";
			}
	 })
	 
	 $("#cfPassword").blur(function(){
		 var password = $('#password').val();
		 var cfPassword = $('#cfPassword').val();
		 if(cfPassword!=password){
				document.getElementById("errorLogCFPwd").innerHTML="两次输入的密码不一致";
				return false;
			}else{
				document.getElementById("errorLogCFPwd").innerHTML="";
			}
	 })
	 
	 $("#name").blur(function(){
		 var name=$("#name").val();
		 if(name==null || name==""){
			 document.getElementById("errorLogName1").innerHTML="客户名称不能为空";
				return false;
			}else{
				document.getElementById("errorLogName1").innerHTML="";
			}
	 })
	 
	 $("#merchantNum").blur(function(){
		 var merchantNum=$("#merchantNum").val();
		 if(merchantNum==null || merchantNum==""){
			 document.getElementById("errorLogMerchantNum").innerHTML="客户编码不能为空";
				return false;
			}else{
				$.post('<%=path%>/register/findmerchantNum.do',{merchantNum:merchantNum},
				         function(result){
					     if(result =='0'){
					    	 document.getElementById("errorLogMerchantNum").innerHTML="";
					    	 $("#merchantNum").val(merchantNum.toUpperCase());
					     }else{
					    	 document.getElementById("errorLogMerchantNum").innerHTML="该客户编码已存在";
					    	 return false;
					     }
				   }		
				)
				document.getElementById("errorLogMerchantNum").innerHTML="";
			}
	 })
	 
	 $("#phone").blur(function(){
		 var email=$("#phone").val();
		   if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(email))){ 
		    	document.getElementById("errorLogemail").innerHTML="电话号码不正确";
		    	return false;
		    }else{
		    	document.getElementById("errorLogemail").innerHTML="";
		    }
	 })
	 
 	 $("#htl").blur(function(){
	 var email=$("#htl").val();
	 var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
	   if(!reg.test(email)){ 
	    	document.getElementById("errorLogemailx").innerHTML="邮箱格式不正确";
	    	return false;
	    }else{
	    	document.getElementById("errorLogemailx").innerHTML="";
	    }
	 })
	 
	function pwd(){
		 var userName = $('#userName').val();
	     var errorLogName=$("#errorLogName").text();
	     var errorLogPwd=$("#errorLogPwd").text();
	     var errorLogCFPwd=$("#errorLogCFPwd").text();
	     if(userName==null || userName=="" || errorLogName=="该用户名已存在" || errorLogName=="用户名必须大于3位数或者小于15位数" ){
	    	 return false;
	     }
	     if(errorLogPwd=="密码必须大于6位数或者小于20位数"){
	    	 return false;
	     }
	     if(errorLogCFPwd=="两次输入的密码不一致"){
	    	 return false;
	     }
	}

 	function pwd2(){
		var username=$("#username").val();
		var password=$("#password").val();
		var name=$("#name").val();
		var code=$("#code").val();
		var phone=$("#phone").val();
		var thl=$("#thl").val();
		var logmun=$("#logmun").val();
		var arr=$("#arr").val();
		 if(username==""||password==""||name==""||code==""||phone==""||thl==""||logmun==""||arr==""){
			layer.open({
				  title: '错误'
				  ,content: '请填写以上内容'
				});
			 return false;
		}
		 var bbb = false;
		 var errorRegion=$(".errorRegion")
		 errorRegion.each(function(){
    			if($(this).html()!=''){
    				layer.open({
  					  title: '错误'
  					  ,content:'存在错误信息，请填写正确信息！！'
  					});
    				bbb = true;
    				return false;
    			}
  		});
	 	if(bbb){
	 		 return false;
	 	}else{
		var obj= $("#logfromone").serializeJson();
	    $.post('<%=path%>/register/addUsers.do',obj,
	        function(result){
	    	var date=eval('('+result+')');
			if(date.result!="1"){
				layer.open({
					  title: '错误'
					  ,content:date.result
					});     
			}else{
				logTwo()
			}
    	}		
	    )
	 	}
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

layui.use('upload', function(){
	  var $ = layui.jquery;
	  upload = layui.upload;
	 
	  var uploadInst = upload.render({
	  elem: '#imgAdd1',
	  data: {code: "1"},
	  url: '<%=path%>/register/addImg.do',
	  done: function(res){
	      if(res.code > 0){
	        return layer.msg('上传失败');
	      }else{
	    	  return layer.msg('上传成功');
	      }
	    }
	  });  
	  var uploadInst = upload.render({
		  elem: '#imgAdd2',
		  data: {code: "2"},
		  url: '<%=path%>/register/addImg.do',
		  done: function(res){
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }else{
		    	  return layer.msg('上传成功');
		      }
		    }
		  });  
	  var uploadInst = upload.render({
		  elem: '#imgAdd3',
		  data: {code: "3"},
		  url: '<%=path%>/register/addImg.do',
		  done: function(res){
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }else{
		    	  return layer.msg('上传成功');
		      }
		    }
		  });  
	  var uploadInst = upload.render({
		  elem: '#imgAdd4',
		  data: {code: "4"},
		  url: '<%=path%>/register/addImg.do',
		  done: function(res){
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }else{
		    	  return layer.msg('上传成功');
		      }
		    }
		  });  
})

</script>

</head>
<body>
	<input type="hidden" name="xoms-contextPath" value="" />
	<input type="hidden" name="xoms-locale" value="zh_CN" />
	<div class="xoms-body">
		<div class="xoms-navbar-container navbar-fixed-top">
			<nav class="navbar navbar-default container-fluid">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="<%=path%>/login1/custom.html">ZDA</a>
					</div>

					<div class="collapse navbar-collapse "
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav ">
							<li><a href="<%=path%>/login1/custom.html"><spring:message
										code="home" /></a></li>

						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="?lang=zh_CN"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><spring:message
										code="language" /><span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="?lang=zh_CN">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
											src="<%=path%>/statics/img/cn.gif" alt="中文" />&nbsp;&nbsp;&nbsp;中文
									</a></li>
									<li><a href="?lang=en_US">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
											src="<%=path%>/statics/img/us.gif" alt="English" />&nbsp;&nbsp;&nbsp;English
									</a></li>
								</ul></li>
							<li><a href="<%=path%>/login1/custom.html"><spring:message
										code="login" /></a></li>
							<li class="xoms-navbar-separator"><span>|</span></li>
							<li><a href="<%=path%>/login1/register.html" target="_blank"><spring:message
										code="register" /></a></li>
						</ul>
					</div>
				</div>
			</nav>




			<!-- <div class="secnavbar-scroll-div scroll-div">
					<a class="scroll-a left" href="#"><span class="glyphicon glyphicon-chevron-left"></span></a>
					<a class="scroll-a right" href="#"><span class="glyphicon glyphicon-chevron-right"></span></a>
				</div> -->
			<!-- <div class="thirdnavbar-scroll-div scroll-div">
					<a class="scroll-a left" href="#"><span class="glyphicon glyphicon-chevron-left"></span></a>
					<a class="scroll-a right" href="#"><span class="glyphicon glyphicon-chevron-right"></span></a>
				</div> -->
		</div>
		<div class="xoms-container" role="main">




			<input type="hidden" id="publicKey"
				value="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCe4zJO65XMPAGBtvMIze1L1ssRHhinH5GqHkBv
c9jEvaBRZOrdsYeT/de4wqxyfteNMpASkOSZNI4kjPs3mdv0mEvyz+uTM8/msA03p4r51SI025zs
Kezoh4ex7tpXzg8S+AbUwLSDtjnaB1BUTNHVl06clSpenHPXdw/grdtcsQIDAQAB
" />
			<div class="container xoms-main register-main">
				<div class="register-header">
					<div class="register-header-main clearfix">
						<div id="divBzOne"
							class="register-header-item  register-header-current-step">
							<span class="register-header-index">1</span> <span><spring:message
									code="register.set" /></span>
						</div>
						<div id="divBztow" class="register-header-item ">
							<span class="register-header-index">2</span> <span><spring:message
									code="register.over" /></span>
						</div>
						<div id="divBzs" class="register-header-item ">
							<span class="register-header-index"><span
								class="glyphicon glyphicon-ok"></span></span> <span><spring:message
									code="register.success" /></span>
						</div>
					</div>
				</div>
				<form class="form-horizontal register-form" id="logfromone"
					role="form">
					<div id="logDivOne">
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								for="userName"><spring:message code="register.username" /></label>
							<div class="col-sm-8">
								<input class="form-control" id="userName" name="username"
									type="text"
									placeholder="<spring:message code="register.username.nei" />" /><span
									class="errorRegion" id="errorLogName" style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								for="password"><spring:message code="register.password" /></label>
							<div class="col-sm-8">
								<input class="form-control" id="password" name="password"
									type="password"
									placeholder="<spring:message code="register.password.nei" />" /><span
									class="errorRegion" id="errorLogPwd" style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								for="cfPassword"><spring:message
									code="register.password2" /></label>
							<div class="col-sm-8">
								<input class="form-control" id="cfPassword" name="cfPassword"
									type="password"
									placeholder="<spring:message code="register.password2.nei" />" /><span
									class="errorRegion" id="errorLogCFPwd" style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3">邀请码</label>
							<div class="col-sm-8">
								<input class="form-control" id="dlid" name="dlid" type="text" placeholder="请输入邀请码" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8 xoms-btn-container">
								<button class="layui-btn layui-btn-normal layui-btn-sm"
									type="button" id="next-step-2">
									<span class="glyphicon glyphicon-arrow-right next-step-2"></span>
									<spring:message code="register.next" />
								</button>
							</div>
						</div>
					</div>
					<div id="logDivTwo" hidden="">
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								for="merchantNum"><spring:message
									code="register.merchantNum" /></label>
							<div class="col-sm-8">
								<input class="form-control" id="merchantNum" name="code"
									type="text"  onpaste="return false" ondragenter="return false" oncontextmenu="return false;" style="ime-mode:disabled"
									placeholder="<spring:message code="register.merchantNum.nei" />" /><span
									class="errorRegion" id="errorLogMerchantNum" style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								for="customerName"><spring:message code="register.name" /></label>
							<div class="col-sm-8">
								<input class="form-control" id="name" name="name" type="text"
									placeholder="<spring:message code="register.name.nei" />" /><span
									class="errorRegion" id="errorLogName1" style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								for="phone"><spring:message code="register.phone" /></label>
							<div class="col-sm-8">
								<input class="form-control" id="phone" name="phone" type="text"
									placeholder="<spring:message code="register.phone.nei" />" /><span
									class="errorRegion" id="errorLogemail" style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								for="htl">邮箱</label>
							<div class="col-sm-8">
								<input class="form-control" id="htl" name="thl" type="text"
									placeholder="<spring:message code="register.htl.nei" />" /><span
									class="errorRegion" id="errorLogemailx" style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								for="registerNum">注册号</label>
							<div class="col-sm-8">
								<input class="form-control" id="registerNum" name="logmun"
									type="text"
									placeholder="<spring:message code="register.registerNum.nei" />" /><span
									class="errorRegion" id="errorLogemail" style="color: red"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								for="area"><spring:message code="register.city" /></label>
							<div class="col-sm-8">
								<input class="form-control" class="area" name="arr" id="area"
									placeholder="<spring:message code="register.city.nei" />">
								<input type="hidden" name="addressState" id="addressState">
								<input type="hidden" name="addressCity" id="addressCity">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3 require-star-before"
								 for="address"><spring:message code="register.address"  /></label>
							 	<div class="col-sm-8"  >
							 	<button type="button" class="layui-btn layui-btn-normal  layui-btn-xs " id="imgAdd1">身份证正面</button>
							 	<button type="button" class="layui-btn layui-btn-normal  layui-btn-xs " id="imgAdd2">身份证反面</button>
							 	<button type="button" class="layui-btn layui-btn-normal  layui-btn-xs " id="imgAdd3">营业执照</button>
							 	<button type="button" class="layui-btn layui-btn-normal  layui-btn-xs " id="imgAdd4">开户许可证</button>
						</div>
						</div>
						<!-- <div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<div class="checkbox">
						<label><input type="checkbox" name="agree" id="agree" value="agree"> 我已认真阅读并同意递四方的<a href="/documents/register-agrement.jsp" target="_blank">《服务条款》</a></label>
					</div>
				</div>
			</div> -->
						<!-- <div class="form-group">
				<label class="control-label col-sm-3">邀请码</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" placeholder="联邮通活动邀请码" />
				</div>
			</div> -->
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8 xoms-btn-container">
								<button class="layui-btn layui-btn-normal layui-btn-sm"
									id="next-step-2" type="button">
									<span class="glyphicon glyphicon-arrow-left back-step-1"></span>
									<spring:message code="register.before" />
								</button>
								<button class="layui-btn layui-btn-normal layui-btn-sm"
									id="next-step-3" type="button">
									<span class="glyphicon glyphicon-arrow-right next-step-3"></span>
									<spring:message code="register.next" />
								</button>
							</div>
						</div>
					</div>
					<div class="register-step-success register-step-3" hidden=""
						id="logDivS">
						<div>
							<span class="glyphicon glyphicon-ok"></span> <span
								class="register-usrename"></span>
							<spring:message code="register.success.nei" />
						</div>
						<div class="register-tip-header">温馨提示:</div>
						<div class="register-tip-msg">
							请联系业务人员或客服进行审核维护。中达供应链电话：+86 0417-3371688 
							</div>
					</div>
				</form>
				
			</div>

		</div>
	</div>



	<div class="xoms-footer">
		<div class="container xoms-footer-content">
			<!-- 	Copyright 2004-2015©4PX All rights reserved  粤ICP备10020553号-2 -->
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="feedback-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">我要反馈</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<input type="text" class="form-control form-control-title"
							maxlength="50" placeholder='标题' />
					</div>
					<div class="form-group">
						<textarea
							placeholder='亲爱的用户：请在这里填写您遇到的问题或者意见建议，您的意见对我们非常重要，是我们前进的动力'
							class="form-control form-control-content" rows="8"
							maxlength="500"></textarea>
					</div>
				</div>
				<div class="modal-footer xoms-btn-container">
					<button type="button"
						class="layui-btn layui-btn-normal layui-btn-sm submit-feedback">提交</button>
					<button type="button"
						class="layui-btn layui-btn-normal layui-btn-sm"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>