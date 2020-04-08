<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = "";
    String username = "";
%>
<html>
<head>

<title>往来客户信息</title>
<link rel="shortcut icon" href="../statics/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="../statics/css/navigation.css" />
<link rel="stylesheet" href="../statics/css/xoms.layout.css" />
<link rel="stylesheet" href="../statics/layui/css/layui.css" />
<script type="text/javascript" src="../statics/js/jquery.min.js"></script>
<script type="text/javascript" src="../statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="../statics/layui/layui.js"></script>
<script type="text/javascript" src="../statics/js/common/common.js"></script>
</head>
<style type="text/css">
.xoms-secnavbar a {
	text-decoration: none;
}

.xoms-secnavbar {
	margin-top: -20px;
}

.saveInput {
	padding-top: 10px;
}
</style>
<script type="text/javascript">
var tableCS
//当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量
var table_data=new Array();
//入口方法 
$(function(){
	var options = {
			//初始显示所有地址
			url : '<%=path%>/customer/getAllCustomer.do',
			//进入修改页面的地址
			editUrl : '<%=path%>/customer/jumpEndit.do',
			//进入添加页面的地址
			addUrl :'<%=path%>/customer/jumpEndit.do',
			//删除地址     
			removeUrl : '<%=path%>/customer/delete.do',
			//生成 Layui table 的标识 id，必须提供，用于后文刷新操作
			 id: "queryOrders",
			//where: {  },
			//显示字段
			cols: [[ //表头
                  {type:'checkbox', fixed: 'left',templet :function (row){ 
                	   var id = row.id;
                  }}
                 ,{field: 'customerCode', title: '客户代码',align: 'center'}
                 ,{field: 'customerChName', title: '客户名称（中文）'}
                 ,{field: 'chAddress', title: '客户地址',align: 'center',}
                 ,{field: 'customerEnName', title: '客户名称（英文）',align: 'center'} 
                 ,{field: 'enAddress', title: '英文地址',align: 'center',}
                 ,{field: 'contact', title: '联系人',align: 'center'}
                 ,{field: 'phone', title: '电话',align: 'center'}
                 ,{field: 'fax', title: '传真',align: 'center'}
                 ,{field: 'createTime', title: '创建时间',align: 'center',templet :function (row){
                     return createTime(row.createTime);
                 }}
                /*  ,{field: 'createId', title: '创建人',align: 'center'} */
               ]]
			}
			//条件查询
			active = {
				    reload: function(){
			          var customerCode = $("#customerCode").val();
				      //执行重载
				      layui.table.reload('queryOrders', {
				        page: {
				          curr: 1 //重新从第 1 页开始
				        }
				        ,where: {
				        	customerCode : customerCode,
				      }
				      });
				    },
			         }   
		         $('.btn').on('click', function(){
				    var type = $(this).data('type');
				    active[type] ? active[type].call(this) : '';
				  });
	//进入初始化表格方法
	$.table.init(options);
})
</script>
<body>
	<!-- 导航栏 -->
<%-- <%@ include file="../basebar/settingsbar.txt" %> --%>
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
				<a class="navbar-brand" href="">安布雷</a>
			</div>

			<div class="collapse navbar-collapse "
				id="bs-example-navbar-collapse-1">

				<ul class="nav navbar-nav ">
					<li class=""><a href="<%=path%>/page/pageJump.do?path=views/index">个人中心</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">进口货物<span class="caret"></span></a>
						<ul class="dropdown-menu active">
							<!--<li><a href="<%=path%>/my_orders/to_create.html">到货计划表</a></li>-->
							<li><a href="<%=path%>/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlan">到货计划表</a></li>
							<%-- <li><a href="<%=path%>/orderManage/draft.html">审核</a></li>
							<li><a href="<%=path%>/my_order/order_problem.html">订单状态二</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态三</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态四</a></li> --%>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">出口货物<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<!--<li><a href="<%=path%>/my_orders/to_create.html">到货计划表</a></li>-->
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
							<%-- <li><a href="<%=path%>/freeCount/findqt.html">单证管理</a></li> --%>
						</ul></li>
					<li class="dropdown active"><a href="#" class="dropdown-toggle"
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
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="createto_create createbatch_upload"><a
					href="<%=path%>/company/editCompany">企业基本信息</a></li>
				<li class="managementinfo_received managementshipment_received managementon_delivery
				managementdraft managementshipped managementpicked_up managementdelivered ">
					<a href="<%=path%>/customs/customsUI">海关登记信息</a>
				</li>
				<li class="searchindex active"><a href="<%=path%>/customer/customerUI">往来客户信息</a></li>
			</ul>
		</div>
	</div>
	<div class="col-lg-1"></div>
	<!-- <div class="col-lg-10 col-xs-12 ztck-body">
		<br />
		<div class="container-fluid col-lg-9">
			<div class="row container">
				<div class="container col-lg-10 col-xs-12 ztck-body">
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="layui-btn layui-btn-normal layui-btn-sm"
							 onclick="$.operate.getAddData('38%','50%')">data-type="getAddData" 
							<span class="glyphicon glyphicon-plus"></span>
							新增
						</button>
					</div>
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="layui-btn layui-btn-normal layui-btn-sm"
							onclick="$.operate.getUpdateData('38%','50%')">data-type="getUpdateData"
							<span class="glyphicon glyphicon-edit"></span>
							修改
						</button>
					</div>
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="layui-btn layui-btn-normal layui-btn-sm"
							onclick="$.operate.removeAll()">data-type="getDeleteData"
							<span class="glyphicon glyphicon-remove"></span>
							删除
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-3 container">
			<div class="form-group">
				<div class="input-group  col-xs-9">
					<input type="text" id="eName1" class="form-control" placeholder="请输入客户代码">
					<span class="input-group-btn">
					<a class="btn layui-btn layui-btn-normal layui-btn-sm"
					   id="search_submit" data-type="reload"><i class="layui-icon">&#xe615;</i></a>
					</span>
				</div>
			</div>
		</div>

		<table id="test" lay-filter="queryOrders"></table>
	</div> -->
	<div class="col-lg-10 col-xs-12 ztck-body">
	</br>
		<div class="container" style="width:1800px;">
			<div class="row container">
				<div class="container col-lg-10 col-xs-12 ztck-body"style="width:1500px;">
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="layui-btn layui-btn-normal layui-btn-sm"
							 onclick="$.operate.getAddData('38%','50%')"><!-- data-type="getAddData" --> 
							<span class="glyphicon glyphicon-plus"></span>
							新增
						</button>
					</div>
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="layui-btn layui-btn-normal layui-btn-sm"
							onclick="$.operate.getUpdateData('38%','50%')"><!-- data-type="getUpdateData" -->
							<span class="glyphicon glyphicon-edit"></span>
							修改
						</button>
					</div>
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="layui-btn layui-btn-normal layui-btn-sm"
							onclick="$.operate.removeAll()"><!-- data-type="getDeleteData" -->
							<span class="glyphicon glyphicon-remove"></span>
							删除
						</button>
					</div>
					
					<div class="pull-right xoms-keyword-div received-search-container">
						<form id="queryForm" class="form-inline xoms-search-form myorder-simple-search"
							role="form" method="get">
							<label>客户代码:</label><input type="text" id ="customerCode" class="form-control" name="customerCode" value="">
							 <a class="btn layui-btn layui-btn-normal layui-btn-sm"
								id="search_submit" data-type="reload"><i class="layui-icon">&#xe615;</i>查询</a>
						</form>
					</div>
				</div>
			</div>
		
		</div>
		<table id="layuiTable" lay-filter="queryOrders"></table>
	</div>
</body>
</html>
