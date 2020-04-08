<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username = request.getSession().getAttribute("userName").toString();
    String userId = request.getSession().getAttribute("userId").toString();
%>
<html>
<head>
<title><spring:message code="toOrder.OutedWarehouse" /></title>
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<link rel="stylesheet" href="<%=path%>/css/track.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/to_create.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
<script type="text/javascript" src="<%=path%>/js/StringBuilder.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<script type="text/javascript">
    var i_ids =new Array();
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
            url:'<%=path%>/orderManage/findAll.do?notEnd=4',
            page: true,
            method:'post',
            height:600,
            limit:50,
            limits:[50,200,500,1000],
            id: 'queryOrders',
            cols: [[
                {field : 'id',checkbox : true,align : 'center',fixed:true},
                {field:'orderNo',  title: '<spring:message code='queryOrder.CustomerOrderNo'/>',align :'center'},
                {field:'mailNo',  title: '<spring:message code='queryOrder.TackingNo'/>',align :'center'},
                {field:'overseasMailNo',  title: '<spring:message code='toOrder.overseasMailNo'/>',align :'center'},
                {field:'totalWayBill',  title: '<spring:message code='queryOrder.totalWayBill'/>',align :'center'},
                {field:'transport', title: '<spring:message code='queryOrder.product2'/>',align :'center'},
                {field:'destinationCountry',  title: '<spring:message code='queryOrder.Country'/>',align :'center'},
                {field:'consignee',  title: '<spring:message code='queryOrder.ConsigneeName'/>',align :'center'},
                {field:'createTime',  title: '<spring:message code='queryOrder.CreateDate'/>',align :'center' },
                {field:'orderStep',  title: '<spring:message code='queryOrder.status2'/>',align :'center'},
                {field:'classify',  title: '<spring:message code='queryOrder.Track'/>',align :'center' , toolbar: '#track'}
            ]]
        ,done: function(res, page, count){  
            //如果是异步请求数据方式，res即为你接口返回的信息。  
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度  
        	 table_data=res.data;
             //在缓存中找到id ,然后设置data表格中的选中状态
             //循环所有数据，找出对应关系，设置checkbox选中状态
             for(var i=0;i< res.data.length;i++){
                 for (var j = 0; j < i_ids.length; j++) {
                     //数据id和要勾选的id相同时checkbox选中
                     if(res.data[i].id == i_ids[j])
                     {
                         //这里才是真正的有效勾选
                         res.data[i]["LAY_CHECKED"]='true';
                         //找到对应数据改变勾选样式，呈现出选中效果
                         var index= res.data[i]['LAY_TABLE_INDEX'];
                         $('.layui-table-fixed-l tr[data-index=' + index + '] input[type="checkbox"]').prop('checked', true);
                         $('.layui-table-fixed-l tr[data-index=' + index + '] input[type="checkbox"]').next().addClass('layui-form-checked');
                     }
                 }
             }
             //设置全选checkbox的选中状态，只有改变LAY_CHECKED的值， table.checkStatus才能抓取到选中的状态
             var checkStatus = table.checkStatus('my-table');
             if(checkStatus.isAll){
                 $(' .layui-table-header th[data-field="0"] input[type="checkbox"]').prop('checked', true);
                 $('.layui-table-header th[data-field="0"] input[type="checkbox"]').next().addClass('layui-form-checked');
             }
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
                    } 
            })  
   }  
        });
            
      //监听工具条  点击跟踪显示tips
        table.on('tool(Singledata)', function(obj){
          var data = obj.data;
       if(obj.event === 'detail'){
    	   var sb = new StringBuilder();
           var orderNo=data.orderNo;
           $.ajax({ 
        	   type : "post",  
               url : "<%=path%>/track/orderTrack.do",  
               data : {orderNo : orderNo},
               async : false,  
               success : function(data){  
            	 if(data.length<1){
            		  sb.append("<span class='order_track'>：( 该订单暂无物流进展，请稍后再试。</span><br><br>");
            	 }else{
            		 for (var i = 0; i < data.length; i++) {
                 		  sb.append("<span class='order_track'>"+createTime(JSON.stringify(data[i].createtime))+" &nbsp;&nbsp;"+JSON.stringify(data[i].track)+"</span><br><br>");
   					 } 
            	 }
               }  
           }); 
         layer.tips("<div class='order_track'>查看轨迹</div><hr class='layui-bg-black'>"+sb+"", this,{
        		     tips:[1,'#FFFFFF'],
        	 		 time: 0,//不自动关闭
        	 		 closeBtn:1,//显示关闭按钮
        	 		 area: ['auto', 'auto'],//大小自动
        		});
          }
        });
            
        table.on('checkbox(Singledata)', function (obj) {
        	if(obj.checked==true){
                if(obj.type=='one'){
             	   var flag = 0;
             	   for(i in i_ids){
             		   if(i == obj.data.id){
             			   flag=1;
             		   }
             	   }
             	   if(flag==0){
             		   i_ids.push(obj.data.id);
             	   }
                    
               }else{
                    for(var i=0;i<table_data.length;i++){
                 	   var flag = 0;
                 	   for(var j=0;j<i_ids.length;j++){
                 		   if(i_ids[j] == table_data[i].id){
                 			   flag=1;
                 		   }
                 	   } 
                 	   if(flag==0){
                 		   i_ids.push(table_data[i].id);
                 	   }
                        
                    }
                }
            }else{
                if(obj.type=='one'){
                    for(var i=0;i<i_ids.length;i++){
                       if(i_ids[i]==obj.data.id){
                            i_ids.remove(i);
                        }
                   }
                }else{
                    for(var i=0;i<i_ids.length;i++){
                        for(var j=0;j<table_data.length;j++){
                            if(i_ids[i]==table_data[j].id){
                               i_ids.remove(i);
                           }
                        }
                    }
                }
            } 
         });   
           
   	 var $ = layui.$, active = {
			    reload: function(){
	              var orderNo= $("#orderNo").val();
			      //执行重载
			      table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	orderNo: orderNo
			      }
			      });
			    },
			    getCheckData: function(){ 
				      var checkStatus = table.checkStatus('queryOrders');
				      var data = checkStatus.data;
				      var length=i_ids.length;//获取的是上面的全局变量
				     // layer.alert(data[0].id);
				     if(length!=0){
				       layer.confirm("确定导出这<font color='red'>"+length+"</font>条数据？", function(index){ 
								var ids="";
								for(var i=0;i<length;i++){
									if(i==0){
										ids += i_ids[i];//获取的是上面的全局变量
									}else{
										ids += ','+i_ids[i];
									}						
								}
								$("#orderOutIDS").val(ids);
								$("#f_orderOut_export").submit();
								 i_ids = new Array(); 
								 layer.close(index);
					})
				      //layer.alert(JSON.stringify(data));
			    }else{
			    	$("#orderOutIDS").val(null);
			    	  var obj = $("#queryForm").serializeJson();
					  layer.confirm("确定导出？", function(r){ 
							$("#queryForm").attr('action','<%=path%>/orderManage/exportOrderOut.do?orderOutQueryVo='+obj);
							$("#queryForm").submit();
							 layer.close(r);
					})
			    }
			   }
	 }   
			  $('.btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
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
			managementdraft managementshipped managementpicked_up managementdelivered active">
					<a href="<%=path%>/orderManage/draft.html"><spring:message
							code="orderManager" /></a>
				</li>
				<li class="order_problemindex"><a
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
	<div class="xoms-thirdnavbar">
		<div class="container order-management-thirdnav">
			<ul class="nav nav-pills" style="margin-top: 30px;">
				<li class="draft active"><a
					href="<%=path%>/orderManage/draft.html"> <span><i></i></span> <span><spring:message
								code="toOrder.Draft" />（${countVo.to_draft}）</span><span
						class="nav-order-count"></span></span>
				</a></li>
				<li class="info_received "><a
					href="<%=path%>/queryOrder/to_order.html"> <span><i></i></span>
						<span><spring:message code="toOrder.Received" />（${countVo.to_order}）<span
							class="nav-order-count"></span></span>
				</a></li>
				<li class="handover"><a href="<%=path%>/orderManage/ship.html">
						<span><i></i></span> <span><spring:message
								code="toOrder.ShipmentReceived" />（${countVo.to_ship}）<span
							class="nav-order-count"></span></span>
				</a></li>
				<li class="inside_operation"><a
					href="<%=path%>/orderManage/inopera.html"> <span><i></i></span>
						<span><spring:message code="toOrder.InOperation" />（${countVo.to_inopera}）<span
							class="nav-order-count"></span></span>
				</a></li>
				<li class="outed_warehouse active"><a
					href="<%=path%>/orderManage/outed.html"> <span><i></i></span> <span><spring:message
								code="toOrder.OutedWarehouse" />（${countVo.to_outed}）<span
							class="nav-order-count"></span></span>
				</a></li>
				<div style="float: left; margin-top: -30px; width: 20%">
					<li class="handover_serve" style="width: 100%;">
						<div>
							<a href="<%=path%>/orderManage/picked.html"
								style="text-decoration: none;"> <span><i></i></span> <span><spring:message
										code="toOrder.Pickup" />（${countVo.to_picked}）<span
									class="nav-order-count"></span></span>
							</a>
						</div>
					</li>
					<div style="padding-top: 25px;">
						<li class="main_transport" style="float: left; width: 50%;">
							<a
							style="float: left; padding-right: 35px; text-decoration: none;"
							href="<%=path%>/orderManage/main.html"> <span><i></i></span>
								<span><spring:message code="toOrder.MainTransport" />（${countVo.to_main}）<span
									class="nav-order-count"></span></span>
						</a>
						</li>
						<li class="on_delivery" style="float: right; width: 50%;"><a
							style="float: left; text-decoration: none;"
							href="<%=path%>/orderManage/last.html"> <span><i></i></span>
								<span><spring:message code="toOrder.LastKm" />（${countVo.to_last}）<span
									class="nav-order-count"></span></span>
						</a></li>
					</div>
				</div>
				<li class="closed"><a href="<%=path%>/orderManage/closed.html">
						<span><i></i></span> <span><spring:message
								code="toOrder.Closed" />（${countVo.to_close}）<span
							class="nav-order-count"></span></span>
				</a></li>
				<div class="status-nav-line"></div>
			</ul>
		</div>
	</div>
	<div class="xoms-container" role="main">
		<div
			class="container has-thirdnavbar-container myorder-container xoms-main"
			style="margin-top: -50px;">
			<div class="main">
				<div class="myorder-toolbar-container">
					<div class="order-toolbar clearfix col-lg-12">
						<div class="pull-left xoms-btn-container operate-btn-container">
							<a class="btn layui-btn layui-btn-normal layui-btn-sm export"
								data-type="getCheckData"><span
								class="glyphicon glyphicon-arrow-down export"></span> <spring:message
									code="toOrder.ExportExcel" /></a>
							<%--   <button class="btn btn-info btn-sm min-screen-hidden tick"><span class="glyphicon glyphicon-ok tick"></span> 勾选未打印</button>
                 <button class="btn btn-info btn-sm min-screen-hidden disabled print"><span class="glyphicon glyphicon-print print"></span><spring:message code="toOrder.PrintLabel"/></button>
                 <div class="btn-group">
                     <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
                         <spring:message code="toOrder.More"/> <span class="caret"></span>
                     </button>
                     <ul class="dropdown-menu" role="menu">
                         <li class="disabled holdup"><a class="holdup" href="#"><span class="glyphicon glyphicon-ban-circle holdup"></span><spring:message code="toOrder.ApplyIntecept"/></a></li>
                         <li class="disabled unholdup"><a class="unholdup" href="#"><span class="glyphicon glyphicon-share-alt unholdup"></span><spring:message code="toOrder.CancelIntecept"/></a></li>
                         <li class="disabled delivery min-screen-hidden"><a class="delivery" href="#"><span class="glyphicon glyphicon-print delivery"></span><spring:message code="toOrder.PrintDeliveryList"/></a></li>
                         <li class="disabled invoice min-screen-hidden"><a class="invoice" href="#"><span class="glyphicon glyphicon-print invoice"></span><spring:message code="toOrder.PrintInvoice"/></a></li>
                         <li class="min-screen-hidden export"><a class="export" href="#"><span class="glyphicon glyphicon-arrow-down export"></span><spring:message code="toOrder.ExportExcel"/></a></li>
                     </ul>
                 </div> --%>
						</div>
						<div class="pull-right xoms-keyword-div received-search-container">
							<form id="queryForm"
								class="form-inline xoms-search-form myorder-simple-search"
								role="form" method="post">
								<%-- <div class="form-group">
                         <select class="form-control" id="fieldName" name="fieldName">
                             <option value="orderNo"><spring:message code="toOrder.orderNum"/></option>
                             <option value="countryName"><spring:message code="toOrder.Destinat"/></option>
                             <option value="productName"><spring:message code="toOrder.Product"/></option>
                             <option value="buyerId"><spring:message code="toOrder.BuyerID"/></option>
                             <option value="consigneeName"><spring:message code="toOrder.Consignee"/></option>
                             <option class="min-screen-hidden" value="advanced"><spring:message code="toOrder.AdvanceSearch"/></option>
                         </select>
                     </div>
                     <div class="form-group other-value-group">
                         <label for="keyword">
                             <button type="submit"><span class="glyphicon glyphicon-search"></span></button>
                         </label>
                         <input type="text" class="form-control" id="fieldValue" name="fieldValue">
                         <!-- <input type="text" class="form-control" id="productNameValue" name="productNameValue">
                         <input type="text" class="form-control" id="countryNameValue" name="countryNameValue"> -->
                     </div> --%>

								<!-- <div class="form-group advanced-value-group">
                         <button type="button" class="btn btn-default expand"><span class="glyphicon glyphicon-chevron-up expand"></span></button>
                     </div> -->
								<textarea rows="4" cols="20" name="orderOutCustom.orderNo"
									id="orderNo" class="form-control" placeholder="多条订单按回车区分"></textarea>
								<input type="hidden" name="orderOutCustom.notEnd"
									class="form-control" value="4"> <input type="hidden"
									name="orderOutCustom.userId" class="form-control"
									value="<%=userId%>"> <a
									class="btn layui-btn layui-btn-normal layui-btn-sm"
									id="search_submit" data-type="reload"><i class="layui-icon">&#xe615;</i></a>
							</form>
							<!-- <form class="form-horizontal myorder-advanced-search container advanced-search-hide">
                     <div class="form-group">
                         <label for="countryName" class="col-xs-2 control-label">目的国家/地区</label>
                         <div class="col-xs-4">
                             <input type="text" class="form-control" id="countryNameSearch" name="countryName" />
                         </div>
                         <label for="productName" class="col-xs-2 control-label">运输方式</label>
                         <div class="col-xs-4">
                             <input type="text" class="form-control" id="productNameSearch" name="productName" />
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="startDate" class="col-xs-2 control-label">起始日期</label>
                         <div class="col-xs-4">
                             <input type="text" class="form-control" id="startDate" name="startDate" readonly="readonly" />
                         </div>
                         <label for="endDate" class="col-xs-2 control-label">结束日期</label>
                         <div class="col-xs-4">
                             <input type="text" class="form-control" id="endDate" name="endDate" readonly="readonly" />
                         </div>
                     </div>
                     <div class="form-group">
                         <div class="col-xs-12 xoms-btn-container">
                             <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> 搜索</button>
                         </div>
                     </div>
                 </form> -->
						</div>
			<table id="ordermanage" lay-filter="Singledata"
				style="height: 150px; width: 1555px;">
			</table>
					</div>
				</div>
			</div>
		</div>
		<!-- 打印表单 -->
		<form class="print-form" action="#" target=_blank method="post">
			<input type="hidden" name="userName" /> <input type="hidden"
				name="identity" /> <input type="hidden" name="data" /> <input
				type="hidden" name="encipherment" />
		</form>
		<!-- 导出excel -->
		<form id="f_orderOut_export"
			action="<%=path%>/orderManage/exportOrderOut.html?" method="post">
			<input type="hidden" name="ids" id="orderOutIDS" />
		</form>
	</div>

	<!-- <div class="xoms-footer">
<div class="container xoms-footer-content">
 Copyright 2004-2015©4PX All rights reserved  粤ICP备10020553号-2
</div> -->
	</div>
	<script type="text/html" id="track">
  <a class="layui-btn layui-btn-xs layui-btn-normal a" lay-event="detail" >跟踪</a>
</script>
</body>
</html>
