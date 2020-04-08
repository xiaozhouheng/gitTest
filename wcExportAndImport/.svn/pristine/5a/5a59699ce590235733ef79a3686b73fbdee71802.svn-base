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
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<!--  禁止在移动设备上缩放   -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="shortcut icon" href="/imgs/favicon.ico" type="image/x-icon" />
<!--问题订单页面-->
<title><spring:message code="errOrder" /></title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/index.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<link rel="stylesheet"
	href="<%=path%>/statics/css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" href="<%=path%>/statics/css/ui.jqgrid.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/jqGrid.overrides.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/select2.css" />
<link rel="stylesheet"
	href="<%=path%>/statics/css/select2-bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.validate.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/order.problem.css" />
<link rel="stylesheet"
	href="<%=path%>/statics/css/xoms.orderProblemReplydialog.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script defer src="<%=path%>/statics/js/require.min.js"></script>
<script defer src="<%=path%>/statics/js/require.config.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
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
                elem: '#test1',
                url:'<%=path%>/my_order/arrears.do?notEnd=6',
                height:550,
                page: true,
                limit:200,
                limits:[200,500,1000],
                id:"arrea",
                cols: [[
							{type:'numbers'},
							{type:'checkbox'},
							{field:'orderNo', width:160, title: '<spring:message code='queryOrder.CustomerOrderNo'/>',align :'center'},
							{field:'mailNo', width:160, title: '<spring:message code='queryOrder.TackingNo'/>',align :'center'},
							{field:'transport',width:160, title: '<spring:message code='queryOrder.product2'/>',align :'center'},
							{field:'destinationCountry', width:160, title: '<spring:message code='queryOrder.Country'/>',align :'center'},
							{field:'consignee', width:160, title: '<spring:message code='queryOrder.ConsigneeName'/>',align :'center'},
							{field:'createTime', width:160, title: '<spring:message code='queryOrder.CreateDate'/>',align :'center' },
							{field:'orderStep', width:160, title: '<spring:message code='queryOrder.status2'/>',align :'center'},
							{field:'classify', width:160, title: '<spring:message code='queryOrder.Track'/>',align :'center'}
							]]
							,done: function(res, page, count){  
							//如果是异步请求数据方式，res即为你接口返回的信息。  
							//如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度  
							//分类显示中文名称  
							$("[data-field='orderStep']").children().each(function(){  
							if($(this).text()=='1'){  
							  $(this).text("已运抵")  
							}else if($(this).text()=='2'){  
							  $(this).text("二次扫描")  
							}else if($(this).text()=='3'){  
							  $(this).text("合包")  
							}else if($(this).text()=='4'){  
							  $(this).text("已取消")  
							}else if($(this).text()=='5'){
							   $(this).text("待审核")  
							}else if($(this).text()=='6'){
							   $(this).text("支付中")  
							} else if($(this).text()=='7'){
							   $(this).text("已支付")  
							} else if($(this).text()=='8'){
							   $(this).text("有信无货")  
							} else if($(this).text()=='9'){
							   $(this).text("有货无信")  
							} else if($(this).text()=='10'){
							   $(this).text("货信不符")  
							} else if($(this).text()=='0'){
							   $(this).text("待运抵")  
							} else if($(this).text()=='99'){
							   $(this).text("已发货")  
							} else if($(this).text()=='11'){
		                    	   $(this).text("待支付")  
		                       } 
						})  
					}  
            });
            var $ = layui.$, active = {
              	    reload: function(){
              	      var keyword = $('#keyword');
              	      $("#search").attr("style","");
              	      $("#search").click();
              	      //执行重载
              	      table.reload('arrea', {
              	        page: {
              	          curr: 1 //重新从第 1 页开始
              	        }
              	        ,where: {
              	        	key: keyword.val()
              	        }
              	      });
              	    }
              	  }; 
              $('#btn-sou').on('click', function(){
                  var type = $(this).data('type');
                  active[type] ? active[type].call(this) : '';
                });
              
              /**回车事件*/
       	   $("#keyword").keydown(function(event){
       		   if(event.keyCode ==13){
       			   var orderNo=$("#keyword").val();
       			      //执行重载
       			      table.reload('arrea', {
       			        page: {
       			          curr: 1 //重新从第 1 页开始
       			        }
       			        ,where: {
       			        	orderNo: orderNo
       			      }
       			      });
       		   }
       		});
              
        });
        //鼠标滑过显示
        $(function () {
           /*  $(".dropdown").mouseover(function () {
                $(this).addClass("open");
            });

            $(".dropdown").mouseleave(function(){
                $(this).removeClass("open");
            }) */

        $(".zt_tab").click(function(){
        	$("#search").attr("style","display:none;");
        })
        })
    </script>
</head>
<body>
	<!-- 导航栏 -->
<%@ include file="basebar/myorderbar.txt" %>
	<!--
	时间：2018-02-06
	描述：网站主体开始
-->
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="createto_create createbatch_upload "><a
					href="<%=path%>/my_orders/to_create.html"><spring:message
							code="createOrder" /></a></li>
				<li
					class="managementinfo_received managementshipment_received managementon_delivery
				managementdraft managementshipped managementpicked_up managementdelivered">
					<a href="<%=path%>/orderManage/draft.html"><spring:message
							code="orderManager" /></a>
				</li>
				<li class="order_problemindex active"><a
					href="<%=path%>/my_order/order_problem.html"><spring:message
							code="errOrder" /></a></li>

				<!-- 			<li class="ordinary_mailindex">< a href="/order/my_order/ordinary_mail/index">平邮订单</ a></li>  -->
				<li class="searchindex"><a
					href="<%=path%>/queryOrder/toquery.html"><spring:message
							code="queryOrder" /></a></li>
				<li class="searchindex"><a href="<%=path%>/print/printMD.html"><spring:message
							code='print.printMD' /></a></li>
				<%-- <li class="searchindex"><a
					href="<%=path%>/orderZf/orderZf.html"><spring:message
							code='PaymentOfFreight' /></a></li> --%>
			</ul>
		</div>
	</div>

	<input id="view-type-input" type="hidden" value="" />

	<div
		class="container order-problem-container xoms-main has-secnavbar-container col-lg-10 col-md-offset-1">
		<ul class="nav nav-tabs" role="tablist" id="main-tab">
			<%-- <li role="presentation" class="active"><a href="#arrearage-list"
				class="zt_tab" aria-controls="arrearage-list" role="tab"
				data-toggle="tab"><spring:message code="errOrder.ArrearageOrder" /></a>
			</li>
			<li role="presentation"><a href="#problem-list" class="zt_tab"
				aria-controls="problem-list" role="tab" data-toggle="tab"><spring:message
						code="errOrder.HoldOrder" /></a></li>
			<li role="presentation"><a href="#notice-list" class="zt_tab"
				aria-controls="notice-list" role="tab" data-toggle="tab"><spring:message
						code="errOrder.NoticeOrder" /></a></li> --%>
						<li role="presentation" class="active"><a href="#arrearage-list"
				class="zt_tab" aria-controls="arrearage-list" role="tab"
				data-toggle="tab"><spring:message code="errOrder.HoldOrder" /></a>
			</li>
			<li role="presentation" id="search-form-section">
				<div class="search-form-section-content pull-right">
					<div class="demoTable form-group form-inline">
						<!--	<input class="form-control xoms-keyword-input" name="keyword" placeholder="请输入单号" />
                            <label for="keyword">
                                <button type="submit"><span class="glyphicon glyphicon-search form-control-feedback"></span></button>
                            </label>-->
						<input type="text" id="keyword" name="keyword"
							class="form-control"
							placeholder="<spring:message code="errOrder.please"/>"> <a
							class="btn layui-btn layui-btn-normal layui-btn-sm" id="btn-sou"
							data-type="reload"><i class="layui-icon">&#xe615;</i></a>
					</div>
				</div>
			</li>
		</ul>
		<div class="tab-content">
			 <!-- 欠费件 -->
			<div role="tabpanel" class="tab-pane active " id="arrearage-list">
				<div class="arrearage-list-main xoms-grid-container-main">
					<div class="xoms-grid-panel" style="margin-top: 10px;">
						<table id="test1"></table>
					</div>
				</div>
			</div>
			<!-- 问题件 -->
			<%--<div role="tabpanel" class="tab-pane " id="problem-list">
				<div class="problem-list-toolbar clearfix">
					 <div class="pull-left xoms-btn-container">
                    <button class="btn btn-info btn-sm reply" disabled><span class="glyphicon glyphicon-plus"></span><spring:message code="errOrder.reply"/></button>
                    <button class="btn btn-info btn-sm release" disabled><span class="glyphicon glyphicon-plus"></span><spring:message code="errOrder.release"/></button>
                    <button class="btn btn-info btn-sm export" title="最多导出2万条数据"><spring:message code="errOrder.export"/></button>
                </div>
                <div class="pull-right">
                    <div class="form-inline problem-form">
                        <div class="form-group" id="issueKind-subsection">
                            <label class="control-label" for="issueKind"><spring:message code="errOrder.Type"/></label>
                            <select id="issueKind" name="issueKind" class="form-control"></select>
                        </div>
                        <div class="form-group problem-status">
                            <select id="status" name="status" class="status form-control">
                                <option value="0"><spring:message code="errOrder.all"/></option>
                                <option value="1"><spring:message code="errOrder.Unresolved"/></option>
                                <option value="2"><spring:message code="errOrder.resolved"/></option>
                            </select>
                        </div>
                    </div>
                </div>
				</div>
				<div class="problem-list-main xoms-grid-container-main">
					<div class="xoms-grid-panel">
						<table id="test1"></table>
					</div>
				</div>
			</div>
			<!-- 通知 -->
			<div role="tabpanel" class="tab-pane " id="notice-list">
				<div class="notice-list-toolbar clearfix">
					  <div class="pull-left xoms-btn-container">
                    <button class="btn btn-info btn-sm sign-readed" disabled><span class="glyphicon glyphicon-ok"></span><spring:message code="errOrder.read"/></button>
                </div>
                <div class="pull-right">
                    <div class="form-inline notice-form">
                        <div class="form-group notice-status">
                            <select id="status" name="status" class="status form-control">
                                <option value="0"><spring:message code="errOrder.all"/></option>
                                <option value="1"><spring:message code="errOrder.unreaded"/></option>
                                <option value="2"><spring:message code="errOrder.readed"/></option>
                            </select>
                        </div>
                    </div>
                </div>
				</div>
				<div class="notice-list-main xoms-grid-container-main">
					<div class="xoms-grid-panel">
						<table id="test2"></table>
					</div>
				</div>
			</div> --%>
			<!-- 搜索 -->
			<!-- <div role="tabpanel" class="tab-pane" id="search-list">
				<div id="search-grid-pager" style="margin-top: 10px;">
					<table id="test1"></table>
				</div>
			</div> -->
		</div>
	</div>

	<div id="batch-reply-dialog" style="display: none;">
		<div class="content">
			<form>
				<textarea name="content" placeholder=""></textarea>
			</form>
		</div>
	</div>

	<!-- dialog todo done -->
	<div id="todo-done-dialog" style="display: none">
		<div class="content"></div>
	</div>
	<!-- dialog toRead readed -->
	<div id="toRead-readed-dialog" style="display: none">
		<div class="content"></div>
	</div>


	<!-- 问题件内容展示模板, 也就是回复详情的第一条, 和回复展示模板很像 -->
	<script type="text/html" id="todo-done-details-template">
    <div class="reply-item clearfix" data-id="{{id}}" {{if !content }}style="display: none;"{{/if}}>
    <div class="personal-info-col">
        <div class="photo iconfont {{iconfontCSS}}"></div>
        <div class="name ellipsis" title="{{stNameCreate}}">{{stNameCreate}}</div>
    </div>
    <div class="pointer-col"></div>
    <div class="reply-content-col">
        <div class="inner-content">
            <span class="time">{{createDate}}</span>
            <div class="reply-content">{{content}}</div>
            <!--<div class="mail-info">
                <span class="business-no">{{businessLabel}}：{{businessId}}</span>
            </div>-->
        </div>
    </div>
    </div>
</script>
	<!-- 问题件回复展示模板 -->
	<script type="text/html" id="reply-template">
    {{each list}}
    <div class="reply-item clearfix {{$value.customerCSS}} {{$value.selfCSS}}">
        <div class="personal-info-col">
            <div class="photo iconfont {{$value.iconfontCSS}}"></div>
            <div class="name ellipsis" title="{{$value.replayName}}">{{$value.replayName}}</div>
        </div>
        <div class="pointer-col"></div>
        <div class="reply-content-col">
            <div class="inner-content">
                <span class="time">{{$value.createDate}}</span>
                <div class="reply-content"  style="word-wrap:break-word;word-break:break-all;">{{$value.content}}</div>
            </div>
        </div>
    </div>
    {{/each}}
</script>

	<!-- 待阅已阅内容展示模板 -->
	<script type="text/html" id="toRead-readed-details-template">
    <div class="main-content">{{content}}</div>
    <div class="footer">
        <div class="description">
            <span class="author">{{fromPersonName}}</span>
            <span class="time">{{createDate}}</span>
        </div>
    </div>
</script>


	<!-- 导出excel -->
	<iframe id="export-iframe" height="0" width="0" src=""> </iframe>

	<script defer src="<%=path%>/statics/js/order.problem.js"></script>



	<div class="xoms-footer">
		<div class="container xoms-footer-content">
			<!-- Copyright 2004-2015©4PX All rights reserved  粤ICP备10020553号-2 -->
		</div>
	</div>
</body>
</html>
