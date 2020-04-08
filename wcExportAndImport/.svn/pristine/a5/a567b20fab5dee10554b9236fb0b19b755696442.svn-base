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
<title>查询</title>
<link rel="stylesheet" href="../statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="../statics/layui/css/layui.css" />
<link rel="stylesheet" href="../statics/css/track.css" />
<link rel="stylesheet" href="../statics/css/navigation.css" />
<link rel="stylesheet" href="../statics/css/to_create.css" />
<link rel="stylesheet" href="../statics/css/xoms.layout.css" />
<script type="text/javascript" src="../statics/js/jquery.min.js"></script>
<script type="text/javascript" src="../statics/js/StringBuilder.js"></script>
<script type="text/javascript" src="../statics/js/tools.js"></script>
<script type="text/javascript" src="../statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="../statics/layui/layui.js"></script>
<!-- <script type="text/javascript" src="../statics/js/common/common.js"></script> -->
<style>
.order-no {
	width: 300px;
}

.ztck-biaodan {
	margin-top: 20px;
}

.order-select {
	width: 80px;
}

.ztck-textarea {
	width: 225px;
}

.xoms-secnavbar a {
	text-decoration: none;
}

.xoms-secnavbar {
	margin-top: -20px;
}

.saveInput {
	padding-top: 10px;
	padding-left: 0px;
	padding-right: 0px;
}

.bighuan {
	border: 1px dashed #F0F0F0;
	border-radius: 5px 5px 5px 5px;
	width: 1140px;
	margin-left: 30px;
}

.fieldName {
	text-align: right;
	padding-top: 7px;
	padding-left: 0px;
}

.valueName {
	padding-left: 0px;
}
/* 搜索栏 */
.ui-autocomplete {
        max-height: 50%;/* 高度值 */
        overflow-y: auto; /* 超过高度出现滚动条 */
        overflow-x: hidden;/*横向超出隐藏，如果要出现横向滚动，设置为auto即可 */
    }
    /*  IE 6不支持最大高度 
     *  我们使用高度代替，但这迫使菜单总是这么高。 
     */
     /**我也不知道写这个干啥，反正我们也不用IE6*/
    * html .ui-autocomplete {
        height: 300px;
    }
       .file {  
            position: relative;  
            display: inline-block;  
            background: #D0EEFF;  
            border: 1px solid #99D3F5;  
            border-radius: 4px;  
            padding: 4px 12px;  
            overflow: hidden;  
            color: #1E88C7;  
            text-decoration: none;  
            text-indent: 0;  
            line-height: 20px;  
        }  
        .file input {  
            position: absolute;  
            font-size: 100px;  
            right: 0;  
            top: 0;  
            opacity: 0;  
        }  
        .file:hover {  
            background: #AADFFD;  
            border-color: #78C3F3;  
            color: #004974;  
            text-decoration: none;  
        } 
</style>
<script type="text/javascript">
	//时间控件  作为时间格式化使用
	function createTime(v){
		var date = new Date(v);
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
    //当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量
    var table_data=new Array();
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function(){
        var laydate = layui.laydate, //日期
            laypage = layui.laypage, //分页
            layer = layui.layer, //弹层
            table = layui.table, //表格
            carousel = layui.carousel, //轮播
            upload = layui.upload, //上传
            element = layui.element; //元素操作
        table.render({
            elem: '#ordermanage',
            url:'<%=path%>/SShippingPlan/getAllSShippingPlan.do',
            page: true,
            method:'get',
            height:600,
            limit:50,
            limits:[50,200,500,1000],
            id: 'queryOrders',
            response: {
                statusName: 'success' //数据状态的字段名称，默认：code
                , statusCode: true //成功的状态码，默认：0
                , msgName: 'message' //状态信息的字段名称，默认：msg
                , countName: 'count' //数据总数的字段名称，默认：count
                , dataName: 'value' //数据列表的字段名称，默认：data  
            },
            cols: [[
                {type:'checkbox', fixed: 'left'},
                {field:'id',title:'id',align : 'center'},
                {field:'businessNumber',  title: '业务编号',align :'center'},
                {field:'salespersonCode',  title: '销售员代码',align :'center'},
                {field:'exportPorts',  title: '出口口岸',align :'center'},
                {field:'deliveryTime',  title: '出货时间',align :'center',templet :function (row){
                    return createTime(row.deliveryTime);
                }},
                {field:'destinationCountry',  title: '目的国',align :'center'},
                {field:'destination',  title: '目的港',align :'center'},
                {field:'modeOfTransport',  title: '运输方式',align :'center',templet :function (row,value){
                    return value ===1?"铁路":"公路"}},
                {field:'mainWaybillNumber',  title: '主运单号',align :'center'},
                {field:'distributionOrderNumber', title: '分运单号',align :'center'},
                {field:'supervisionType',  title: '监管方式',align :'center',templet :function (row,value){
                    return value ===1?"方式四":"方式三"}},
                {field:'transactionTyep',  title: '成交方式',align :'center',templet :function (row,value){
                    return value ===1?"方式二":"方式一"}},
                {field: 'param3', title: '上传文件',align: 'center',templet :uploadFile}
            ]]
        ,done: function(res, page, count){
        	//表格列隐藏
        	 $("[data-field='id']").css('display','none');
        	//给table添加双击事件
            $('.layui-table-body').find("table" ).find("tbody").children("tr").on('dblclick',function(){
            	//var ids = res.value[0].id;
            	/* var id = JSON.stringify($('.layui-table-body').find("table" ).find("tbody").find(".layui-table-hover").data('index')); */
            	var ids = JSON.stringify($('.layui-table-body').find("table").find("tbody").find(".layui-table-hover").find("td").find(".laytable-cell-1-id").text())
                //var data = res.data[id];
             	ids = ids.replace(/[^0-9]/ig,"")
                location.href = "<%=path%>/SShippingPlan/enditSShippingPlan.do?id="+ids;
            });
     
   }  
        });  
            
   	 var $ = layui.$, active = {
			    reload: function(){
	              var businessNumber = $("#businessNumber").val();
	              var mainWaybillNumber = $("#mainWaybillNumber").val();
			      //执行重载
			      table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	businessNumber : businessNumber,
			        	mainWaybillNumber : mainWaybillNumber,
			      }
			      });
			    },
	 }   
			  $('.btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });

			  
});
     
    //删除
    function removeData(){
    	var table
		layui.use(['table'], function(){
			table = layui.table;
		})
		var checkStatus = table.checkStatus('queryOrders');
    	if(checkStatus.data.length == 0){
    		layer.msg("请至少选择一条数据");
    	}else if(checkStatus.data.length == 1){
    		layer.confirm("确认要删除选中的" + checkStatus.data.length + "条数据吗?", function() {
    		//删除一条操作
    		var id = checkStatus.data[0].id;
    		removeDataSub(id);
    	})
    	}
    	else{
    		layer.confirm("确认要删除选中的" + checkStatus.data.length + "条数据吗?", function() {
    			//群体删除操作
    			var id
    			for(var i = 0 ; i < checkStatus.data.length ; i++ ){
    				if(i==0){
    					id=checkStatus.data[i].id;
    				}else{
    					id+=","+checkStatus.data[i].id;
    				}
    				
    			}
    			removeDataSub(id);
    		});
    		};
    }
    	
    	function removeDataSub(id){
    	$.ajax({
    	      url:"<%=path%>/SShippingPlan/deleteSShippingPlan.do?ids="+id,
    	      async: false,
    	      type:"POST",
    	      dataType: "text",
    	      success: function (result) {
    	    	   //把响应结果由字符串转成对象
                   var obj = JSON.parse(result)
    	            if (obj.status == 200) {
    	            	layer.msg(obj.msg, {
    	            		icon: 1,
    	            		time: 1400,
    	            	},function(index){
    	            		//layer刷新子页面
    	            		window.location.reload();
              				layer.close(index); 
                			});
    	            }else{
    	            	layer.msg(obj.msg,{
    	            		icon: 2,
    	            		time: 1400,
    	            	},function(index){
    	            		//layer刷新子页面
    	            		window.location.reload();
              				layer.close(index); 
                			});
    	            }
    	        },
    	        error : function() {
    	            alert("异常！");
    	        }
    	      })
    	   } 
    	
    	
    	//文件上传 
        function uploadFile(data){
        	var invoice = data.invoice;
        	var btn = "<a class='layui-btn-blue layui-btn-xs' lay-event='update' onclick='getUploadFile(\""+invoice+"\")' >上传附件</a>"
        	return btn;   
          }
        function getUploadFile(invoice){
        	var invoice = invoice;
            var urls = "<%=path%>/page/updateJump.do?path=views/sShippingPlan/uploadFile";
            var url = urls+"&id="+invoice; 
        	layer.open({
    	    	  title: '上传文件',
    	    	  type: 2,
    	    	  closeBtn: 2,
    	    	  content: url,
    	    	  //btn: ['保存', '取消'],
    	    	  isOutAnim : true,
    	    	  maxmin  : true,
    	    	  anim : 2 ,
    	    	  area : ['40%','50%'],
    	    	  /* yes: function(index, layero){
    	    		  	//按钮【按钮一】的回调
    	    		  var iframeWin = layero.find('iframe')[0];
          	          iframeWin.contentWindow.submitHandler();
    	    	  },
    	    	  btn2: function(index, layero){
    	    		  	//按钮【按钮二】的回调
    	    		  layer.close(index);
    	    		  //return false 开启该代码可禁止点击该按钮关闭
    	    	  } */
    	    });
        }
    
    
</script>
</head>
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
					<li class="dropdown active"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">出口货物<span
							class="caret"></span></a>
						<ul class="dropdown-menu active">
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
时间：2018-02-06
描述：网站主体开始
-->
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="searchindex"><a href="<%=path%>/page/pageJump.do?path=views/sShippingPlan/SShippingPlan">出货计划表</a></li>
				<li role="presentation" class="active"><a
				 href="<%=path%>/page/pageJump.do?path=views/sShippingPlan/SShippingPlanInopera">出货计划表查询</a>
				</li>
			</ul>
		</div>
	</div>
        <%-- <ul class="nav nav-tabs">
			<li role="presentation"><a
				href="<%=path%>/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlan">到货计划表新增</a>
			</li>
			<li role="presentation" class="active"><a
				href="<%=path%>/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlanInopera">查询</a>
			</li>
		</ul> --%>	
	    <div class="xoms-container" role="main">
		<div
			class="container has-thirdnavbar-container myorder-container xoms-main"
			style="margin-top: -50px;">
			<div class="main">
				<div class="myorder-toolbar-container">
					<div class="order-toolbar clearfix  col-lg-12">
						<div class="pull-left xoms-btn-container operate-btn-container">
						</div>
						<div class="pull-right xoms-keyword-div received-search-container">
							<form id="queryForm" class="form-inline xoms-search-form myorder-simple-search"
								role="form" method="get">
								<label>业务编号:</label><input type="text" id ="businessNumber" class="form-control" name="businessNumber" value="" >
								<label>主运单号:</label><input type="text" id ="mainWaybillNumber" class="form-control" name="mainWaybillNumber" value="">
								 <a class="btn layui-btn layui-btn-normal layui-btn-sm"
									id="search_submit" data-type="reload"><i class="layui-icon">&#xe615;</i>查询</a>
							</form>
						</div>
						
						<button type="button"
							class="layui-btn layui-btn-normal layui-btn-sm"
							onclick="removeData()"><!-- data-type="getDeleteData" -->
							<span class="glyphicon glyphicon-remove"></span>
							删除
						</button>
						<table id="ordermanage" lay-filter="Singledata"
							style="height: 135px; width: 1555px;">
					    </table>
					</div>
				</div>
			</div>
			
		</div>
		</div>
	
	<script type="text/html" id="track">
  <a class="layui-btn layui-btn-xs layui-btn-normal a" lay-event="detail" >跟踪</a>
</script>
</body>
</html>
