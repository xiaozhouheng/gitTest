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
<title><spring:message code="myBill" /></title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
</head>
<style type="text/css">
.xoms-secnavbar a {
	text-decoration: none;
}

.xoms-secnavbar {
	margin-top: -20px;
}

.kuang {
	padding-left: 0px;
	padding-right: 0px;
	margin-top: 10px;
}
</style>

<script type="text/javascript">
    //鼠标滑过显示
    $(function () {
      /*   $(".dropdown").mouseover(function () {
            $(this).addClass("open");
        });

        $(".dropdown").mouseleave(function(){
            $(this).removeClass("open");
        }) */

    })
</script>

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
				<li class="createto_create createbatch_upload active"><a
					href="<%=path%>/mybill/custom.html"><spring:message
							code="myBill" /></a></li>
				<%-- <li class="order_problemindex"><a href="<%=path%>/queryOrder/recharge.html"><spring:message code="recharge"/></a></li> --%>
				<li class="order_problemindex"><a
					href="<%=path%>/freeCount/findqt.html"><spring:message
							code="freeCount" /></a></li>
				<li class="searchindex"><a href="<%=path%>/freeMx/findMx.html"><spring:message
							code="freeMx" /></a></li>
				<li class="order_problemindex"><a href="<%=path%>/insurance/insurance.html"><spring:message
							code="insurance" /></a></li>
			</ul>
		</div>
	</div>



	<div class="col-lg-1"></div>
	<div class="col-lg-10 col-xs-12 ztck-body">
		<div class="container col-md-12 col-xs-12">
			<ul class="nav nav-tabs active">
				<li role="presentation" class="active"><a href="#everydayCost"
					data-toggle="tab"><spring:message code="mybill.Dailyexpenses" /></a></li>
				<%--  <li role="presentation" ><a href="#accountChange" data-toggle="tab"><spring:message code="mybill.AmountChange"/></a></li> --%>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="everydayCost">
					<br>
					<div>
						<div class="demoTable" align="center">
							<spring:message code="mybill.mailNo" />
							<div class="layui-inline">
								<input class="layui-input" name="add.mailno" id="demoReload"
									autocomplete="off">
							</div>
							<spring:message code="mybill.startTime" />
							<div class="layui-inline">
								<input class="layui-input" name="startTime" id="statetime">
							</div>
							<spring:message code="mybill.endTime" />
							<div class="layui-inline">
								<input class="layui-input" name="endTime" id="endtime">
							</div>
							<button class="layui-btn layui-bg-blue" data-type="reload">
								<spring:message code="mybill.Query" />
							</button>
						</div>
						<div align="center">
							<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>
						</div>
					</div>

					<table class="layui-hide" id="LAY_table_user"></table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
layui.use(['table','laytpl','laydate','util'], function(){
    var table = layui.table,
    	laydate = layui.laydate,
    	util=layui.util,
        laytpl = layui.laytpl;
    
    /* function toDate(v,r,i) {
        var date = new Date();
        date.setTime(v.time);
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        m = m<10?'0'+m:m;
        var d = date.getDate();
        d = d<10?("0"+d):d;
        var h = date.getHours();
        h = h<10?("0"+h):h;
        var M = date.getMinutes();
        M = M<10?("0"+M):M;
        var str = y+"-"+m+"-"+d+" "+h+":"+M;
        return str;

   } */
    table.render({
		elem: '#LAY_table_user',
		url:"<%=path%>/mybill/findBill.do",
		limit:50,
		height:700,
		limits:[50,200,500,1000]
		,cols: [[
			{field:'type', title: '<spring:message code="mybill.Number"/>', align :'center',
				templet:function(row){
            		if(row.type==1){
            			return "<font>充值</font>";
            		}else if(row.type==2){
            			return "<font>预付</font>";
            		}else if(row.type==3){
            			return "<font>返回</font>";
            		}else if(row.type==4){
            			return "<font>二次扣款</font>";
            		}else if(row.type==5){
            			return "<font>扣款</font>";
            		}else if(row.type==6){
            			return "<font>退款</font>";
            		}else if(row.type==7){
            			return "<font>预付保价</font>";
            		}else if(row.type==8){
            			return "<font>二次保价</font>";
            		}else if(row.type==11){
            			return "<font>保价退款</font>";
            		}
            	}
			}
			,{field:'mailno', title: '<spring:message code="mybill.OddOrders"/>',align :'center'}
		/* 	,{field:'sex', title: '<spring:message code="mybill.AmountRecharge"/>', sort: true,align :'center'} */
			,{field:'playmoney',title: '<spring:message code="mybill.AmountExpenditure"/>',align :'center'}
			,{field:'sign', title: '<spring:message code="mybill.Coupons"/>',align :'center'}
			,{field:'smomey', title: '<spring:message code="mybill.AccountBalance"/>', align :'center'}
 			,{field: 'createTime', title: '<spring:message code="mybill.BillingDate"/>',templet: '#createTime'}		
]]    
		,id: 'testReload'
		,page: true 
    });
  
	var $ = layui.$, active = {
		reload: function(){
			var demoReload = $('#demoReload');
			var statetime = $('#statetime');
			var endtime = $('#endtime');
			table.reload('testReload', {
				page: {
				  curr: 1 //重新从第 1 页开始
				}
				,where: {
			        mailno: demoReload.val(),
			      	startTime: statetime.val(),
			   	 	endTime: endtime.val(),
		      }
		    });
		}
	};
    
	$('.demoTable .layui-btn').on('click', function(){
	   var type = $(this).data('type');
	   active[type] ? active[type].call(this) : '';
	});
	
	 laydate.render({
		  theme: '#3EB8E9',
	    elem: '#endTime', //指定元素
	  });
	 laydate.render({
		  theme: '#3EB8E9',
	    elem: '#statetime', //指定元素
	  });
});


</script>

	<script id="createTime" type="text/html">
    {{createTime(d.createTime)}} 
    </script>

	<script type="text/javascript">
function createTime(v){
	var date = new Date();
    date.setTime(v.time);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var str = y+"-"+m+"-"+d+" "+h+":"+M;
    return str;
}
</script>

</body>
</html>
