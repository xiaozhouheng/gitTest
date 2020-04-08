<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();

	String name = "ssss";
	String username = "zzzz";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人中心</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="shortcut icon" href="./statics/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="./statics/layui/css/layui.css" />
<link rel="stylesheet" href="./statics/css/navigation.css" />
<link rel="stylesheet" href="./statics/css/xoms.layout.css" />
<link type="text/css"  href="./statics/layui/layui.css" rel="stylesheet">
<script type="text/javascript" src="./statics/login/js/jquery-1.5.1.min.js"></script>
<script src="./statics/layui/layui.js"></script>
<script type="text/javascript" src="./statics/js/jquery.min.js"></script>
<script type="text/javascript" src="./statics/layui/layui.js"></script>
<script type="text/javascript" src="./statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>


<link rel="shortcut icon" href="../statics/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="../statics/layui/css/layui.css" />
<link rel="stylesheet" href="../statics/css/navigation.css" />
<link rel="stylesheet" href="../statics/css/xoms.layout.css" />
<link type="text/css"  href="./statics/layui/layui.css" rel="stylesheet">
<script type="text/javascript" src="./statics/login/js/jquery-1.5.1.min.js"></script>
<script src="./statics/layui/layui.js"></script>
<script type="text/javascript" src="../statics/js/jquery.min.js"></script>
<script type="text/javascript" src="../statics/layui/layui.js"></script>
<script type="text/javascript" src="../statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>


</head>
<body>
	<!-- 对话框css样式 -->
	<style type="text/css">
html, body, div, img, span {
	padding: 0;
	margin: 0;
}

.clearfix {
	display: block;
	zoom: 1;
	overflow: auto;
}

.message {
	margin-bottom: 10px;
}

.content-time {
	text-align: center;
	margin: 10px auto;
}

.content-time-span {
	display: inline-block;
	padding: 1px 10px;
	background: #dcdcdc;
	color: #fff;
	border-radius: 2px;
}

.pic {
	float: right;
	width: 40px;
	height: 40px;
}

.pic-left {
	float: left;
	width: 40px;
	height: 40px;
}

.text-style {
	text-align: right;
}

.text-style-left {
	text-align: left;
}

.pos, .pos-left {
	margin: 0 10px;
	display: inline-block;
	position: relative;
}

.pos:after {
	content: "";
	position: absolute;
	top: 14px;
	left: 100%;
	border-top: 5px solid transparent;
	border-left: 6px solid #b2e281;
	border-bottom: 5px solid transparent;
}

.pos-left:before {
	content: "";
	position: absolute;
	top: 14px;
	right: 100%;
	border-top: 5px solid transparent;
	border-right: 6px solid #b2e281;
	border-bottom: 5px solid transparent;
}

.bubble {
	text-align: left;
	max-width: 400px;
	min-height: 40px;
	display: inline-block;
	vertical-align: top;
	background: #b2e281;
	border-radius: 3px;
}

.plain {
	padding: 9px 13px;
	font-size: 14px;
}
</style>
<!-- 导航栏 -->
<%-- <%@ include file="basebar/indexbar.txt" %> --%>
<!-- 导航栏开始 -->
<nav class="navbar navbar-default container-fluid">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=path%>/page/pageJump.do?path=views/index">安布雷</a>
			</div>

			<div class="collapse navbar-collapse "
				id="bs-example-navbar-collapse-1">

				<ul class="nav navbar-nav ">
					<li class="active"><a href="<%=path%>/page/pageJump.do?path=views/index">个人中心</a></li>
					<li class="dropdown "><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">进口货物<span class="caret"></span></a>
						<ul class="dropdown-menu active">
							<!--<li><a href="<%=path%>/my_orders/to_create.html">到货计划表</a></li>-->
							<li><a href="<%=path%>/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlan">到货计划表</a></li>
							<%-- <li><a href="<%=path%>/orderManage/draft.html">审核</a></li>
							<li><a href="<%=path%>/my_order/order_problem.html">订单状态二</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态三</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态四</a></li> --%>
						</ul></li>
					<li class="dropdown "><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">出口货物<span
							class="caret"></span></a>
						<ul class="dropdown-menu active">
							<!--<li><a href="<%=path%>/my_orders/to_create.html">出货计划表</a></li>-->
							<li><a href="<%=path%>/page/pageJump.do?path=views/sShippingPlan/SShippingPlan">出货计划表</a></li>
							<%-- <li><a href="<%=path%>/orderManage/draft.html">订单状态一</a></li>
							<li><a href="<%=path%>/my_order/order_problem.html">订单状态二</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态三</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态四</a></li> --%>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">企业数据库<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=path%>/page/pageJump.do?path=views/product/productVO">产品备案</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">企业信息<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<!--<li><a href="./company/companyUI">企业基本信息</a></li> -->
							<li><a href="<%=path%>/company/editCompany">企业基本信息</a></li>
							<li><a href="<%=path%>/customs/customsUI">海关登记信息</a></li>
							<li><a href="<%=path%>/customer/customerUI">往来客户信息管理</a></li>
						</ul></li>

				</ul>
			<ul class="nav navbar-nav navbar-right">
					<%-- <li class="dropdown"><a href="?lang=zh_CN"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">语言<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="?lang=zh_CN">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
									src="<%=path%>/statics/img/cn.gif" alt="中文" />&nbsp;&nbsp;&nbsp;中文
							</a></li>
							<li><a href="?lang=en_US">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
									src="<%=path%>/statics/img/us.gif" alt="English" />&nbsp;&nbsp;&nbsp;English
							</a></li>
						</ul>
					</li> --%>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">您好！${user.userName}</a>
							<li><a href="http://localhost:8080/wcExportAndImport/page/login">退出</a></li>
					</li>
				</ul>
			</div>
		</div>
	</nav>
<!-- 导航栏结束 -->
	<!--
	时间：2018-02-05
	描述：网站主体开始
-->
	<div class="col-lg-1 col-xs-12"></div>
	<div class="ztck-body col-lg-10 col-xs-12">
		<div class="container-fluid col-md-10 col-xs-12">
			<div style="width: 100px;">
				<div style="float: left; width: 150px; height: 150px;">
					<img src="<%=path%>/statics/img/personal_photo.png"
						style="float: left; margin-left: 50px; margin-top: 20px;" />
				</div>
			</div>
			<div class="container col-md-3 col-xs-12">
				<div style="margin-top: 50px;">
					<span><%=name %></span><br /> <span>
					余额:100000000000000000
			
					</span>
				</div>
			</div>
			<div class="container col-md-3 col-xs-12">
				<div style="margin-top: 50px;">
					<span></span>
				</div>
			</div>

			<div class="container col-md-3 col-xs-12">
				<div style="margin-top: 50px;">
					<span></span>
				</div>
			</div>
		</div>

		<!--
    	作者：offline
    	时间：2018-02-05
    	描述：标签页
    -->
		<div class="container col-md-6 col-xs-12" style="height: 300px">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#stayReply"
					data-toggle="tab">问题订单</a></li>
				<li role="presentation"><a href="#alreadyReply"
					data-toggle="tab">问题</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="stayReply">
					<div style="width: 700px; height: 250px; overflow-y: auto;">
						<c:forEach var="feedbacks" items="${feedbacks}">
							<div>
								<a class="btn feeda" id="${feedbacks.feedbackid}">订单号：${feedbacks.orderNo},问题类型:${feedbacks.problemType},详细内容：${fn:substring(feedbacks.feedback,0, 15)}...</a><br>
								<span style="display: none;">${feedbacks.feedbackid}</span>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="tab-pane" id="alreadyReply">
					<p>我是已回复的内容</p>
				</div>
			</div>

		</div>
		<div class="container col-md-6 col-xs-12" style="height: 300px">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#stayRead"
					data-toggle="tab">待办理事件</a></li>
				<li role="presentation"><a href="#alreadyRead"
					data-toggle="tab">已完成事件</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="stayRead">
					<!-- <p>年审</p> -->
				</div>
				<div class="tab-pane" id="alreadyRead">
					<p>我是已经阅读了的内容</p>
				</div>
			</div>

		</div>

		<div class="container col-md-6 col-xs-12" style="height: 300px">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#Notice"
					data-toggle="tab">公告</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="Notice">
					<div style="width: 600px; height: 250px; overflow-y: auto;">公告</div>
				</div>
			</div>

		</div>




	</div>
	<div id="aa" style="display: none;">
		<div id="container" class="clearfix"
			style="width: 586px; height: 415px;">
		
		</div>
		<div style="margin-left: 3px;">
			<textarea rows="4" cols="82" style="resize: none;" id="content"></textarea>
		</div>
	</div>


	<!--
	时间：2018-02-05
	描述：主体结束
-->


	<!--
	时间：2018-02-05
	描述：网站尾部
-->
	<script type="text/javascript">

layui.use(['table','layer','form','laytpl'], function(){
	  var table = layui.table,
	  layer=layui.layer,
	  form=layui.form,
	  laytpl = layui.laytpl;
	  $(".feeda").click(function(){
		  $("#content").val("");
			var a=$(this).parent().find($("span")).text();
			//console.log(a)
			hui(a);
			 layer.open({
				  type: 1 //Page层类型
				  ,area: ['601px', '600px']
				  ,title: '正在回复...'
				  ,shade: 0 //遮罩透明度
				  ,anim: 1 //0-6的动画形式，-1不开启
				  ,content: $('#aa')
				  ,btn: ['发送', '取消']
				  ,yes:function(){
					  var content=$("#content").val();
					 	 $.ajax({
					 		url:'<%=path%>/feedback/QtReply.do',
					 		type:'POST',
					 		data:{
					 			feedbackid:a,
					 			feedback:content,
					 			},
					 		success:function(msg){
					 			if(msg.resultInfo.messageCode==888){
					 				layer.msg("回复成功");
					 				$("#content").val("");
					 			    hui(a);
					 			}else{
					 				layer.msg("回复失败");
					 			}
					 		}
					 	}); 
				  }
				  
				});  
		});
	  $(function(){
			 console.log("%cZTCK"," text-shadow: 0 1px 0 #ccc,0 2px 0 #c9c9c9,0 3px 0 #bbb,0 4px 0 #b9b9b9,0 5px 0 #aaa,0 6px 1px rgba(0,0,0,.1),0 0 5px rgba(0,0,0,.1),0 1px 3px rgba(0,0,0,.3),0 3px 5px rgba(0,0,0,.2),0 5px 10px rgba(0,0,0,.25),0 10px 10px rgba(0,0,0,.2),0 20px 20px rgba(0,0,0,.15);font-size:5em")
			 console.log("%c你打开控制台想看什么？"," text-shadow: 0 1px 0 #ccc,0 2px 0 #c9c9c9,0 3px 0 #bbb,0 4px 0 #b9b9b9,0 5px 0 #aaa,0 6px 1px rgba(0,0,0,.1),0 0 5px rgba(0,0,0,.1),0 1px 3px rgba(0,0,0,.3),0 3px 5px rgba(0,0,0,.2),0 5px 10px rgba(0,0,0,.25),0 10px 10px rgba(0,0,0,.2),0 20px 20px rgba(0,0,0,.15);font-size:5em")
			  
	  });
	  
	//显示聊天记录
	  function hui(b){
	 	  $("#container").empty();
	 		$.ajax({
	 			url:'<%=path%>/feedback/hui.do',
	 			type:'post',
	 			data:{feedbackid:b},
	 			success:function(msg){
	 				//console.log(msg);
	 				//console.log("长度==="+msg.length); 
	 				for(var i=0;i<msg.length;i++){
	 					  if(msg[i].identity==1){
	 						 $("#container").append("<div class='message clearfix'> <p class='content-time'><span class='content-time-span'>"+getDate(msg[i].messageSendingTime)+"</span></p><img class='pic-left' src='<%=path %>/images/kefutx.png'><div class='text-style-left'><div class='pos-left'><div class='bubble'><div class='plain'>"+msg[i].feedback+"</div></div></div></div></div>"); 
	 						 } else{
	 							$("#container").append("<div class='message clearfix'> <p class='content-time'><span class='content-time-span'>"+getDate(msg[i].messageSendingTime)+"</span></p><img class='pic' src='<%=path %>/images/kehutx.png'><div class='text-style'><div class='pos'><div class='bubble'><div class='plain'>"+msg[i].feedback+"</div></div></div></div></div>"); 
	 						 }
	 				/* 	console.log("i==="+i);
	 					console.log("id=="+msg[i].userid); */
	 				}
	 				var div = document.getElementById('container');
			  		div.scrollTop = div.scrollHeight;
	 			}
	 		});
	}
	
	  function getDate(tm){ 
		    var tt=new Date(tm).toLocaleString(); 
		    return tt; 
		}
	//年审时间提示
	  var annualTime = $("#stayRead")
	  $(function(){
	  	$.ajax({
	  		type:"get",
	  		async:false,
	  		dataType: "json",
	  		url:"<%=path%>/company/AnnualInspection.do",
	  		//data:userID,
	  		success:function(data){
	  			console.log(data)
	  			if(data.status == 400){
	  				//layer.alert(data.msg)
	  				var p = $(['<p>'+data.msg+'</p>'].join(''));
	  				annualTime.append(p);
	  			}else{
	  				layer.alert(data.msg);
	  			}
	  				},
	  		error:function(){
	  			alert("年审接口出错了")
	  		}
	  		});
	  		})	  
	  
});	



</script>
</body>
</html>
