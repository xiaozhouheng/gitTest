
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
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<!--  禁止在移动设备上缩放   -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!--保险管理-->
<title><spring:message code="insurance" /></title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/iconfont.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/index.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script defer src="<%=path%>/statics/js/require.min.js"></script>
<script defer src="<%=path%>/statics/js/require.config.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<script type="text/javascript">
layui.use(['laydate', 'laypage', 'layer', 'table', 'element'], function(){
    var laydate = layui.laydate, //日期
    laypage = layui.laypage, //分页
    layer = layui.layer, //弹层
    table = layui.table, //表格
    element = layui.element; //元素操作
    table.render({
        elem: '#test',
        url:'<%=path%>/insurance/OrderInsurance.do',
        height:700,
        page: true,
        limit:200,
        limits:[200,500,1000],
        id:"orderins",
        cols: [[
					{field:'orderNo',  title: '<spring:message code='queryOrder.CustomerOrderNo'/>',align :'center'},
					{field:'premiumPrice',  title: '<spring:message code='insurance.premiumPrice'/>',align :'center'},
					{field:'compensable',  title: '<spring:message code='insurance.compensable'/>',align :'center',
						 templet :function (row){
								if(row.compensable==0){
									 return "待核对";
								}else{
									 return row.compensable;
								}
			                }
					},
					{field:'miumToPrice', title: '<spring:message code='insurance.miumToPrice'/>',align :'center'},
					{field:'isPreM',  title: '<spring:message code='insurance.isPreM'/>',align :'center',
						 templet :function (row){
							if(row.isPreM==1){
								 return "<span class='layui-badge layui-bg-green'>已投保</span>";
							}else{
								 return "<span class='layui-badge'>未投保</span>";
							}
		                }  	
					}
					]]	
   		 });
    
    var $ = layui.$, active = {
      	    reload: function(){
      	      var key = $('#keyword');
      	      //执行重载
      	      table.reload('orderins', {
      	        page: {
      	          curr: 1 //重新从第 1 页开始
      	        }
      	        ,where: {
      	        	key: key.val()
      	        }
      	      });
      	    }
      	  }; 
    $('#insurance-sou').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    
    /**回车事件*/
	   $("#keyword").keydown(function(event){
		   if(event.keyCode ==13){
			   var key = $('#keyword');
	      	      //执行重载
	      	      table.reload('orderins', {
	      	        page: {
	      	          curr: 1 //重新从第 1 页开始
	      	        }
	      	        ,where: {
	      	        	key: key.val()
	      	        }
	      	      });
		   }
		});
});
    </script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="basebar/financebar.txt" %>
	<!--
	时间：2018-02-06
	描述：网站主体开始
-->
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="createto_create createbatch_upload "><a
					href="<%=path%>/mybill/custom.html"><spring:message
							code="myBill" /></a></li>
				<%--   <li class="order_problemindex"><a href="<%=path%>/queryOrder/recharge.html"><spring:message code="recharge"/></a></li> --%>
				<li class="order_problemindex"><a
					href="<%=path%>/freeCount/findqt.html"><spring:message
							code="freeCount" /></a></li>
				<li class="searchindex "><a
					href="<%=path%>/freeMx/findMx.html"><spring:message
							code="freeMx" /></a></li>
				<li class="order_problemindex active"><a href="<%=path%>/insurance/insurance.html"><spring:message
							code="insurance" /></a></li>
			</ul>
		</div>
	</div>
	<div class="col-lg-10 col-xs-12 ztck-body col-md-offset-1">
		<br />
		<div class="col-lg-12">
			<div class="col-lg-3 container col-md-offset-9">
				<div class="form-group">
					<div class="input-group  col-lg-9 col-xs-11">
						<input type="text" name="key" id="keyword"
							class="form-control"
							placeholder="<spring:message code="insurance.queryOrder"/>">
						<span class="input-group-btn"> <a
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							id="insurance-sou" data-type="reload"><i class="layui-icon">&#xe615;</i></a>
						</span>
					</div>
				</div>
			</div>
		</div>
		
		<table class="layui-hide" id="test" lay-filter="queryOrders"></table>

	</div>
	<div class="xoms-footer">
		<div class="container xoms-footer-content">
			<!-- Copyright 2004-2015©4PX All rights reserved  粤ICP备10020553号-2 -->
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
	<!-- /.modal -->
	<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?9fda412926e52b163fabf7d39d135ad4";
        document.getElementsByTagName('body')[0].appendChild(hm);
    })();
</script>
</body>
</html>
