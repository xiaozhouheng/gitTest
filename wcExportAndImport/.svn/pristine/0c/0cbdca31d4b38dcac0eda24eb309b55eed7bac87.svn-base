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

<title>产品备案</title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript"src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>/statics/js/common/common.js"></script>

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
			url : '<%=path%>/commodityFiling/getAllcommodityFiling.do',
			//生成 Layui table 的标识 id，必须提供，用于后文刷新操作
			id: "queryOrders",
			/* //查询条件
			queryParams : queryParams, */ 
			//显示字段
			cols: [[ //表头
                    {type:'checkbox', fixed: 'left',templet :function (row){ 
                  	   var id = row.id;
                    }}
                   ,{field: 'itemNumber', title: '货号',align: 'center'}
                   ,{field: 'barCode', title: '条形码'}
                   ,{field: 'itemChName', title: '商品中文名称',align: 'center',}
                   ,{field: 'itemEnName', title: '产品英文名称',align: 'center',} 
                   ,{field: 'hsCode', title: 'HS编码',align: 'center',}
                   ,{field: 'hsCodeStatus', title: '税号状态',align: 'center',templet :function (d){
                 	   if (d.hsCodeStatus =='0'){
                            return '异常'
                        }else if(d.hsCodeStatus =='1'){
                            return '正常'
                        }
                    }}
                   ,{field: 'reviewStatus', title: '审核状态',align: 'center',templet :function (d){
                 	   if (d.reviewStatus =='1'){
                            return '审核通过'
                        }else if(d.reviewStatus =='-1'){
                            return '审核失败'
                        }else{
                            return '未审核'
                        }
                    }}
                   ,{field: 'netWeight', title: '单个体重',align: 'center'}
                   ,{field: 'mobilePhone', title: '关务联系电话',align: 'center'}
                   ,{field: '', title: '备注',align: 'center'}
                 ]]
			}
			
	//条件查询
	   //var $ = layui.$, 
	   var condition = {}
	   active = {
			    reload: function(){
		          var itemChName = $("#itemChName").val();
		          var hsCode = $("#hsCode").val();
		          
		          if(itemChName != "" && hsCode != ""){
		        	  condition.itemChName = itemChName
		        	  condition.hsCode = hsCode
		          }else if(itemChName == "" && hsCode != ""){
		        	  condition.itemChName = " "
		        	  condition.hsCode = hsCode
		          }else if(itemChName != "" && hsCode == ""){
		        	  condition.hsCode = " "
		        	  condition.itemChName = itemChName
		          }else{
		        	  condition.hsCode = " "
		              condition.itemChName = " "
		          }
		          
		          
		       
			      //执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where:condition
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
    //鼠标滑过显示
  /*   $(function () {
        $(".dropdown").mouseover(function () {
            $(this).addClass("open");
        });

        $(".dropdown").mouseleave(function(){
            $(this).removeClass("open");
        })

    }) */
    
  //导入
	function importCommodityFiling() {
		var openUrl = "<%=path%>/import/commodityFiling.jsp";//弹出窗口的url
		var title = '产品备案导入EXCEL';//弹出窗口的title
		var iWidth = 800; //弹出窗口的宽度;
		var iHeight = 400; //弹出窗口的高度;
		var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
	    var winopen = window.open(openUrl, title, 'height=' + iHeight + ',width='
				+ iWidth + ',left=' + iLeft + ',top=' + iTop
				+ ',toolbar=no,menubar=yes,scrollbars=no');
	    //监听 window.open 关闭事件
   	    var loop = setInterval(function() {   
   		    if(winopen.closed) {  
   		        clearInterval(loop);   
   		        window.location.reload();
   		    }  
   		}, 100);
	    
	 }
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
					<li class="dropdown active"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">企业数据库<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=path%>/page/pageJump.do?path=views/product/productVO">产品备案</a></li>
							<%-- <li><a href="<%=path%>/freeCount/findqt.html">单证管理</a></li> --%>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false active">企业信息<span
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
				<li class="createto_create createbatch_upload active"><a
					href="<%=path%>/page/pageJump.do?path=views/product/productVO">产品备案</a></li>
				<%-- <li
					class="managementinfo_received managementshipment_received managementon_delivery
				managementdraft managementshipped managementpicked_up managementdelivered ">
					<a href="<%=path%>/customs/customsUI">单证管理</a>
				</li> --%>
				<!-- 			<li class="ordinary_mailindex">< a href="/order/my_order/ordinary_mail/index">平邮订单</ a></li>  -->
			</ul>
		</div>
	</div>


	<div class="col-lg-1"></div>
	<div class="col-lg-10 col-xs-12 ztck-body">
		<br />
					<div class="col-lg-1 col-xs-2 container">
						<button type="button" onclick ='importCommodityFiling()'
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="getAddData">
							<span class="glyphicon glyphicon-plus"></span>
							导入
						</button>
					</div>
					<a class="btn layui-btn layui-btn-normal layui-btn-sm" href="<%=path%>/import/item.xlsx">
					<i class="layui-icon">&#xe601;</i>下载模板</a>
					<!-- <div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="getUpdateData">
							<span class="glyphicon glyphicon-edit"></span>
							修改
						</button>
					</div>
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="getDeleteData">
							<span class="glyphicon glyphicon-remove"></span>
							删除
						</button>
					</div> -->
					<div class="pull-right xoms-keyword-div received-search-container">
					<form id="queryForm" class="form-inline xoms-search-form myorder-simple-search"	role="form" method="get">
						<label>商品中文名称:</label><input type="text" id ="itemChName" class="form-control" name="itemChName" value="" >
						<label>HS编码:</label><input type="text" id ="hsCode" class="form-control" name="hsCode" value="">
						 <a class="btn layui-btn layui-btn-normal layui-btn-sm"
							id="search_submit" data-type="reload"><i class="layui-icon">&#xe615;</i>查询</a>
					</form>
					</div>
				<table id="layuiTable" lay-filter="queryOrders"></table>
			
	</div>
</body>
</html>
