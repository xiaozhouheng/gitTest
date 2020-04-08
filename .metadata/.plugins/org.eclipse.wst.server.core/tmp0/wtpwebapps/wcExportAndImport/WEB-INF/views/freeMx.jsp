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
<title><spring:message code="freeMx" /></title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/index.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<link rel="stylesheet"
	href="<%=path%>/statics/css/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/ui.jqgrid.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/jqGrid.overrides.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.select.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/charge.query.css" />
<link rel="stylesheet"
	href="<%=path%>/statics/css/jquery.jqpagination.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.loading.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/freightlist.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<script defer src="<%=path%>/statics/js/require.min.js"></script>
<script defer src="<%=path%>/statics/js/require.config.js"></script>
    <script id="createTime" type="text/html">  
        {{createTime(d.createTime)}}   
        </script>  
<script>
layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function(){
    var laydate = layui.laydate, //日期
    laypage = layui.laypage, //分页
    layer = layui.layer, //弹层
    table = layui.table, //表格
    carousel = layui.carousel, //轮播
    upload = layui.upload, //上传
    element = layui.element; //元素操作
   table.render({
        elem: '#findMXOrder',
        url:'<%=path%>/queryOrder/findOrderDetailed.do',
        page: true,
        height:550,
        limit:50,
        limits:[200,500,1000],
        id: 'detailedReload',
        cols: [[
                {field:'orderno',  title: '订单号'},
                {field:'offername',  title: '运输方式'},
                {field:'ctiy', title: '计费分区'},
                {field:'payweight', title: '计费重 '},
                {field:'totalprice', title: '运费 '},
                {field:'gz',  title: '燃油费 率'},
                {field:'totalprice', title: '总费'},
                {field:'createTime',  title: '收货日期' , templet: '#createTime'}   
           ]]
   
    })
    var $ = layui.$, active = {
      reload: function(){
        var orderno = $('#orderNo');
        var endTime = $('#endTime');
        var startTime = $('#startTime');
        
    	  var index=layer.load();
        //执行重载
        table.reload('detailedReload', {
          page: {
            curr: 1 //重新从第 1 页开始
          }
          ,where: {
            	orderno: orderno.val(),
            	endTime: endTime.val(),
            	startTime: startTime.val()
          }
        });
        layer.close(index); 
      }
    };
    
    $('.form-horizontal .layui-btn').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
    laydate.render({
        elem: '#startTime' //指定元素
    });

    laydate.render({
        elem: '#endTime' //指定元素
    });
});
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
				<li class="searchindex active"><a
					href="<%=path%>/freeMx/findMx.html"><spring:message
							code="freeMx" /></a></li>
				<li class="order_problemindex"><a href="<%=path%>/insurance/insurance.html"><spring:message
							code="insurance" /></a></li>
			</ul>
		</div>
	</div>
	<!--
	作者：hu
	时间：2018-02-07
	描述：主体
-->
	<div class="xoms-container col-md-10 col-md-offset-1"
		style="background-color: white;" role="main">

		<div  class="form-horizontal" style="padding-top: 50px;">
			<div class="form-group">
				<label for="waybillCode" class="col-xs-2 control-label"> <spring:message
						code="freeMx.OrderNumber" />:
				</label>
				<div class="col-xs-2">
					<input name="orderno" id = "orderNo"
						placeholder='<spring:message code="freeMx.CustomerorProviderWaybill"/>'
						type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="countryName" class="col-xs-2 control-label"></label>
				<div class="col-xs-10">
					<input id="startTime" type="text" name="startTime" class="form-control" style="width: 150px; cursor: pointer;"
						 readonly="readonly" />  
						<span style="padding: 0 15px;">-</span> 
						<input id="endTime" type="text" name="endTime" class="form-control" style="width: 150px; cursor: pointer;" 
						readonly="readonly" />
				</div>
			</div>
			<div class="form-group">
				<label for="countryName" class="col-xs-2 control-label"></label>
				<div class="col-xs-10">
					<button class="layui-btn" data-type="reload">
						<span class="glyphicon glyphicon-search"></span>
						<spring:message code="freeMx.Search" />
					</button>
				</div>
			</div>
		</div>
		<div>
			<div class="xoms-pgtoolbar clearfix">
				<%-- <button id="export"
					class="btn layui-btn layui-btn-normal layui-btn-sm">
					<span class="glyphicon glyphicon-arrow-down"></span>
					<spring:message code="freeMx.ExportExcel" />
				</button> --%>
				<iframe id="exportIframe" style="display: none;"></iframe>
			</div>
			<div id="xoms-freightlist-grids" class="xoms-freightlist-grids">
				<div class="table-responsive xoms-freightlist-grid">
					<table id="findMXOrder" >
					</table>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>

