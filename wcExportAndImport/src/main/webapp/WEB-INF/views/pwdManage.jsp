<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username = request.getSession().getAttribute("userName").toString();
%>
<html>
<head>
<!--密码修改页面-->
<title><spring:message code="pwd" /></title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<!--  禁止在移动设备上缩放   -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/iconfont.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet"
	href="<%=path%>/statics/css/jquery-ui/bootstrap/jquery-ui-1.10.3.custom.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script defer src="<%=path%>/statics/js/require.min.js"></script>
<script defer src="<%=path%>/statics/js/require.config.js"></script>
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
        $().ready(function() {
        	
        $("#oldPassword").blur(function(){
        	var password = $("#oldPassword").val();
        	$.post('<%=path%>/register/upwd.do',{password:password},
        	   function(result){
        		if(result==0){
        			document.getElementById("errorLogPwd").innerHTML="输入的密码不正确";
        		}else{
        			document.getElementById("errorLogPwd").innerHTML="";
        		}
        	   }		
        	)
        })
        
         $("#newPassword").blur(function(){
		 var password = $('#newPassword').val();
		 var length1=password.length;
		 if(6>length1 || length1>20){
				document.getElementById("errorLognewpwd").innerHTML="密码必须大于6位数或者小于20位数";
				return false;
			}else{
				document.getElementById("errorLognewpwd").innerHTML="";
			}
	 })
	 
	 $("#cfNewPassword").blur(function(){
		 var password = $('#newPassword').val();
		 var cfPassword = $('#cfNewPassword').val();
		 if(cfPassword!=password){
				document.getElementById("errorLogcfpwd").innerHTML="两次输入的密码不一致";
				return false;
			}else{
				document.getElementById("errorLogcfpwd").innerHTML="";
			}
	 })
	 
        })
        
        function updatepwd(){
          var errorLogPwd = $("#errorLogPwd").text();
          var errorLognewpwd = $("#errorLognewpwd").text();
          var errorLogcfpwd = $("#errorLogcfpwd").text();
          if(errorLogPwd=="输入的密码不正确"){
        	  return false;
          }
          if(errorLognewpwd=="密码必须大于6位数或者小于20位数"){
        	  return false;
          }
          if(errorLogcfpwd=="两次输入的密码不一致"){
        	  return false;
          }
          var password = $('#newPassword').val();
          $.post('<%=path%>/register/updateUsers.do',{password:password},
        	  function(result){
        	       if(result==1){
        	    	   alert("密码修改成功，请重新登录！");
        	    	   window.location="<%=path%>/login1/loginOut.do";
        	       }
              }	  
          )
        }
    </script>
</head>
<body>
	<!-- 导航栏 -->
<%@ include file="basebar/settingsbar.txt" %>
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="createto_create createbatch_upload"><a
					href="<%=path%>/declare/toquery.html"><spring:message
							code="declare" /></a></li>
				<li
					class="managementinfo_received managementshipment_received managementon_delivery
				managementdraft managementshipped managementpicked_up managementdelivered">
					<a href="<%=path%>/sender/sender.html"><spring:message
							code="sender" /></a>
				</li>
				<!-- 			<li class="ordinary_mailindex">< a href="/order/my_order/ordinary_mail/index">平邮订单</ a></li>  -->
				<li class="searchindex active"><a
					href="<%=path%>/register/toupdate.html"><spring:message
							code="pwd" /></a></li>
			</ul>
		</div>
	</div>

	<div class="xoms-container" role="main">
		<div class="container has-secnavbar-container xoms-main">
			<form id="change-password-form" class="form-horizontal" method="post"
				style="width: 750px; margin: 0 auto; padding-top: 100px;">
				<div class="form-group form-title">
					<label class="col-sm-2 control-label"
						style="color: deepskyblue; font-size: 18px"> <spring:message
							code="pwd" />
					</label>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label require-star-before"
						for="oldPassword"> <spring:message
							code="pwdManage.Currentpassword" />
					</label>
					<div class="col-sm-5">
						<input
							placeholder=" <spring:message code="pwdManage.Thecurrentpasswordmustbecorrect"/>"
							id="oldPassword" name="oldPassword" type="password"
							maxlength="20" class="form-control" style="width: 400px;"
							onpaste="return false;" /> <span id="errorLogPwd"
							style="color: red"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label require-star-before"
						for="newPassword"> <spring:message
							code="pwdManage.Newpassword" />
					</label>
					<div class="col-sm-5">
						<input
							placeholder=" <spring:message code="pwdManage.6to20characters"/>"
							id="newPassword" name="newPassword" type="password"
							maxlength="20" class="form-control" style="width: 400px;"
							onpaste="return false;" /> <span id="errorLognewpwd"
							style="color: red"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label require-star-before"
						for="cfmNewPassword"> <spring:message
							code="pwdManage.Confirmnewpassword" />
					</label>
					<div class="col-sm-5">
						<input
							placeholder="<spring:message code="pwdManage.6to20characters"/>"
							id="cfNewPassword" name="cfNewPassword" type="password"
							maxlength="20" class="form-control" style="width: 400px;"
							onpaste="return false;" /> <span id="errorLogcfpwd"
							style="color: red"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-5">
						<button class="btn layui-btn layui-btn-normal release"
							type="button" onclick="updatepwd()">
							<span class="glyphicon glyphicon-ok release"></span>
							<spring:message code="pwdManage.Changepassword" />
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>



	<div class="xoms-footer">
		<div class="container xoms-footer-content">
			<!--  Copyright 2004-2015©4PX All rights reserved  粤ICP备10020553号-2 -->
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
						class="btn btn-sm btn-primary submit-feedback">提交</button>
					<button type="button" class="btn btn-sm btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
</body>
</html>
