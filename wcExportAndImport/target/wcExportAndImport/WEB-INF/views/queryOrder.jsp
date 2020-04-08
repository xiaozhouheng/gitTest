<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username = request.getSession().getAttribute("userName").toString();
    String userId = request.getSession().getAttribute("userId").toString();
%>
<!DOCTYPE HTML>
<html>
<head>
<title><spring:message code="queryOrder" /></title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/css/track.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=path%>/js/StringBuilder.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
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
</style>

<script>

var i_ids =new Array();
//当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量
var table_data=new Array();
	layui.use([ 'laydate', 'laypage', 'layer', 'table', 'carousel', 'upload',
			'element' ], function() {
		var laydate = layui.laydate, //日期
		laypage = layui.laypage, //分页
		layer = layui.layer, //弹层
		table = layui.table, //表格
		carousel = layui.carousel, //轮播
		upload = layui.upload, //上传
		element = layui.element; //元素操作
		table.render({
			elem : '#test',
			url : '<%=path%>/queryOrder/findAll.do',
                page: true,
                method:'post',
                height:600,
                limit:50,
                limits:[20,50,100,300],
                id: 'queryOrders',
                cols: [[
                    {field : 'id',checkbox : true,align : 'center',fixed:true},
                    {field:'orderNo',  title: '<spring:message code='queryOrder.CustomerOrderNo'/>',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'mailNo',  title: '<spring:message code='queryOrder.TackingNo'/>',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'totalWayBill',  title: '<spring:message code='queryOrder.totalWayBill'/>',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'overseasMailNo',  title: '<spring:message code='print.oveaMailNo'/>',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'transport', title: '<spring:message code='queryOrder.product2'/>',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'destinationCountry',  title: '<spring:message code='queryOrder.Country'/>',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'consignee',  title: '<spring:message code='queryOrder.ConsigneeName'/>',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'createTime',  title: '<spring:message code='queryOrder.CreateDate'/>',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'priorPrice',  title: '预付价格',event: 'setSign',style:'cursor: pointer;',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'orderStep',  title: '<spring:message code='queryOrder.status2'/>',event: 'setSign',style:'cursor: pointer;',align :'center'},
                    {field:'classify',  title: '<spring:message code='queryOrder.Track'/>',event: 'setSign',style:'cursor: pointer;',align :'center', toolbar: '#track'}
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
                 
               //给table添加双击事件
                 $('.layui-table-body').find("table" ).find("tbody").children("tr").on('dblclick',function(){
                 	var id = JSON.stringify($('.layui-table-body').find("table" ).find("tbody").find(".layui-table-hover").data('index'));
                    var data = res.data[id];
                	//主表赋值
    		    	$("#orderNo1").val(data.orderNo);
    		    	$("#ztOrderNo1").val(data.ztOrderNo);
    		    	$("#mailNo1").val(data.mailNo);
    		    	$("#overseasNum").val(data.overseasNum);
    		    	$("#overseasMailNo").val(data.overseasMailNo);
    		    	$("#mailNOStatus").val(data.mailNOStatus);
    		    	$("#destinationCountry1").val(data.destinationCountry);
    		    	$("#grossWeight").val(data.grossWeight);
    		    	$("#totalPrice").val(data.totalPrice);
    		    	$("#merchantNum").val(data.merchantNum);
    		    	$("#productName").val(data.productName);
    		    	$("#transport1").val(data.transport);
    		    	if(data.battery==0){
    		    	   $("#battery").val("否");
    		    	}else{
    		    	   $("#battery").val("是");
    		    	}
    		    	$("#goodsTpye").val(data.goodsTpye);
    		    	$("#taxNumber").val(data.taxNumber);
    		    	$("#payweight").val(data.payweight);
    		    	$("#olength").val(data.olength);
    		    	$("#owidth").val(data.owidth);
    		    	$("#oheight").val(data.oheight);
    		    	$("#eori").val(data.eori);
    		    	$("#consignee1").val(data.consignee);
    		    	$("#consigneeCountry").val(data.consigneeCountry);
    		    	$("#consigneeContinent").val(data.consigneeContinent);
    		    	$("#consigneeCity").val(data.consigneeCity);
    		    	$("#consigneeAddress").val(data.consigneeAddress);
    		    	$("#consigneeCompany").val(data.consigneeCompany);
    		    	$("#consigneeTel").val(data.consigneeTel);
    		    	$("#consigneeEmail").val(data.consigneeEmail);
    		    	$("#postCode").val(data.postCode);
    		    	$("#shipperName").val(data.shipperName);
    		    	$("#shipperCompany").val(data.shipperCompany);
    		    	$("#shipperContinent").val(data.shipperContinent);
    		    	$("#shipperCity").val(data.shipperCity);
    		    	$("#shipperCode").val(data.shipperCode);
    		    	$("#shipperTel").val(data.shipperTel);
    		    	$("#shipperAddress").val(data.shipperAddress);
    		    	//子表赋值
    		    	table.render({
    					elem : '#orderSku',
    					url : '<%=path%>/queryOrder/findSku.do?orderNo='+data.orderNo,
    		                page: false,
    		                method:'post',
    		                id: 'queryOrdersku',
    		                cols: [[
    		                    {field:'itemName',  title: '商品名称',align :'center'},
    		                    {field:'eName',  title: '英文名称',align :'center'},
    		                    {field:'unitPrice',  title: '单价',align :'center'},
    		                    {field:'goodsAmount',  title: '数量',align :'center'},
    		                    {field:'customsnumber',  title: '海关编号',align :'center'},
    		                    {field:'netWeight',  title: '重量',align :'center'},
    		                    {field:'remarks',  title: '备注',align :'center'},
    		                    {field:'url',  title: 'URL',align :'center'}
    		                ]]
    		    	});
    				 layer.open({
			        	   type: 1,
			        	   title: '订单详情',
			        	   area: ['1200px', '600px'],
			        	   skin: 'yourclass',
			        	   content: $('#orderMX')
			        	 });
                    
                    
                    
                 });
               
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
                     } else if($(this).text()=='20'){
                  	   $(this).text("干线运输中")  
                     }else if($(this).text()=='0'){
                  	   $(this).text("待运抵")  
                     } else if($(this).text()=='99'){
                  	   $(this).text("已发货")  
                     } else if($(this).text()=='11'){
                  	   $(this).text("待确认")  
                     } else if($(this).text()=='12'){
                     	 $(this).text("已确认")  
                     }else if($(this).text()=='44'){
                     	 $(this).text("物品类型或邮编错误")  
                     }
                })  
           }
            
            });
		
		
		 //监听工具条  点击跟踪显示tips
        table.on('tool(demoEvent)', function(obj){
          var data = obj.data;
       if(obj.event === 'detail'){
    	   var sb = new StringBuilder();
           var orderNo=data.orderNo;
           $.ajax({ 
        	   type : "post",  
               url : "<%=path%>/track/orderTrack.do",  
               data : {orderNo : orderNo},
               async : false,  //改为同步
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
                
            laydate.render({
                elem: '#searchDateRangePicker',
                theme: '#3EB8E9',
                range: true
            });
            
            
            table.on('checkbox(demoEvent)', function (obj) {
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
        	              var obj= $("#queryForm").serializeJson();
        			      //执行重载
        			      table.reload('queryOrders', {
        			        page: {
        			          curr: 1 //重新从第 1 页开始
        			        }
        			        ,where: {
        			        	orderOutQueryVo: obj
        			      }
        			      });
        			    },
        			    getCheckData: function(){ //获取选中数据
  					      var checkStatus = table.checkStatus('queryOrders');
  					      var data = checkStatus.data;
  					      var length=i_ids.length;
  					     // layer.alert(data[0].id);
  					     if(length!=0){
  					       layer.confirm("确定导出这<font color='red'>"+length+"</font>条数据？", function(index){ 
  									var ids="";
  									for(var i=0;i<length;i++){
  										if(i==0){
  											ids += i_ids[i];
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
        							$("#queryForm").attr('action','<%=path%>/queryOrder/exportOrderOut.do?orderOutQueryVo='+obj);
        							$("#queryForm").submit();
        							 layer.close(r);
        					})
        			    }
        			   }
        	 }
        	 
        			  $('#searchBtn').on('click', function(){
        			    var type = $(this).data('type');
        			    active[type] ? active[type].call(this) : '';
        			  });
        	 		$('#exportBtn').on('click', function(){
 			  		  var type = $(this).data('type');
 			   		  active[type] ? active[type].call(this) : '';
 			 		 });
        	 		//反馈
        	 		 $('#feedback').on('click', function(){
        	 			   var checkStatus = table.checkStatus('queryOrders');
     				      var data = checkStatus.data;
     				      var length=i_ids.length;
     				     if(length!=1){
     				    	 layer.msg("请选择一条数据进行反馈",{icon:2});
     		        		 return false;
     				     }else{
     				     	 //console.log(data);
     				    	 $("#ztOrderNo").val(data[0].ztOrderNo);
     				    	 $("#mailNo").val(data[0].mailNo);
     				    	 $("#orderNo").val(data[0].orderNo); 
     				    	 $("#feedbackText").val("");
     				    	 $("#problemType").val("");
     				    	layer.open({
     	                	   type: 1,
     	                	   title: '反馈信息',
     	                	   area: ['500px', '400px'],
     	                	   skin: 'yourclass',
     	                	   content: $('#FeedbackDiv'),
     	                	   btn: ['确定', '取消'],
     	                	   yes:function(index){
     	                		  var obj = $("#saveFeedback").serializeJson();
     	                		  $.ajax({
     	                			 url:'<%=path%>/feedback/saveFeedback.do',
     	                			 type:"post",
     	                			 data:obj,
     	                			 success:function(msg){
     	                				if(msg.resultInfo.messageCode==888){
     	                					layer.msg("反馈成功",{icon: 1})   
         	                				layer.close(index); 
     	                					 i_ids = new Array(); 
     	                				}else{
     	                					layer.msg("反馈失败",{icon: 2})
     	                				}
     	                			 },error:function(msg){
     	                				layer.msg("反馈失败",{icon: 2})
     	                			 }
     	                		  });
     	                			},
     	                		});
     	                	   }
     	              	 }); 
        });
        
        //鼠标滑过显示
/*         $(function () {
            $(".dropdown").mouseover(function () {
                $(this).addClass("open");
            });

            $(".dropdown").mouseleave(function(){
                $(this).removeClass("open");
            })

        }) */
        function queryOrder(){
        	alert("ssss")
        	var obj= $("#queryForm").serializeJson();
       /*  	table.reload('test', {
        		  url: '/api/table/search'
        		  ,where: {} //设定异步数据接口的额外参数
        		  //,height: 300 */
        }
    </script>
</head>
<body style="background-color: #F6F6F6;">
	<!-- 导航栏 -->
<%@ include file="basebar/myorderbar.txt" %>
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
				<li class="order_problemindex "><a
					href="<%=path%>/my_order/order_problem.html"><spring:message
							code="errOrder" /></a></li>

				<!-- 			<li class="ordinary_mailindex">< a href="/order/my_order/ordinary_mail/index">平邮订单</ a></li>  -->
				<li class="searchindex active"><a
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
	<!--
    作者：hu
    时间：2018-02-07
    描述：主体部分
-->
	<div class="ztck-body col-md-10 col-md-offset-1">
		<div class="ztck-biaodan col-lg-12" >
			<form class="form-horizontal xoms-order-search-form" role="form"
				id="queryForm" method="post">
				<input type="hidden" name="orderOutCustom.userId"
					class="form-control" value="<%=userId%>">
				<div class="form-group col-lg-4 col-sm-3" >
					<label class="col-lg-2 col-sm-2 control-label"></label>
					<div class="col-lg-10 col-sm-5" >
					    <label><spring:message code="queryOrder.orderNo" /></label>
						<textarea class="form-control ztck-textarea"
							name="orderOutCustom.orderNo" placeholder="多条订单按回车区分"></textarea>
					</div>
				</div>
				<div class="form-group col-lg-8 col-sm-9" >
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label"><spring:message
								code="queryOrder.product" /></label>
						<div class="col-lg-2 col-sm-2">
							<input class="form-control" type="text"
								name="orderOutCustom.transport" id="transport">
						</div>

						<label class="col-lg-2 col-sm-2 control-label"><spring:message
								code="queryOrder.Destinat" /></label>
						<div class="col-lg-2 col-sm-2">
							<input class="form-control" type="text"
								name="orderOutCustom.destinationCountry" id="destinationCountry">
						</div>

						<label class="col-lg-1 col-sm-2 control-label"><spring:message
								code="queryOrder.status" /></label>
						<div class="col-lg-2 col-sm-2">
							<div class="">
								<select class="form-control shipperChannelId"
									name="orderOutCustom.orderStep" id="status">
									<option value=""><spring:message code="errOrder.all" /></option>
									<option value="11">待确认</option>
									<option value="12">已确认</option>
									<option value="0">待运抵</option>
									<option value="1">已运抵</option>
									<option value="2">二次扫描</option>
									<option value="3">合包</option>
									<%--     <option value="6"><spring:message code="toOrder.Pickup" /></option>
                                <option value="7"><spring:message code="toOrder.MainTransport" /></option>
                                <option value="8"><spring:message code="toOrder.LastKm" /></option> --%>
									<option value="99">已出库</option>
								</select>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label"><spring:message
								code="create.consignee" /></label>
						<div class="col-lg-2 col-sm-2">
							<input type="text" class="form-control" id="consignee"
								name="orderOutCustom.consignee" />
						</div>
						<div class="col-lg-2 col-sm-2">
							<label style="float: right;"> <spring:message
									code="queryOrder.CreateTime" />
							</label>
						</div>
						<div class="col-lg-5 col-sm-5" style="position: relative;">
							<input id="searchDateRangePicker"
								name="orderOutCustom.sectionTime" type="text" placeholder=" - "
								class="form-control" />
						</div>

					</div>

					<div class="col-lg-12 col-sm-12" style="margin-left: -15px; margin-right: -15px;">
						<label
							class="col-lg-offset-2 col-sm-offset-2 xoms-btn-container">
							<a id="searchBtn"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="reload"><span
								class="glyphicon glyphicon-search search"></span>
							<spring:message code="queryOrder.Search" /></a> <a id="exportBtn"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="getCheckData"><span
								class="glyphicon glyphicon-arrow-down export"></span>
							<spring:message code="queryOrder.Export" /></a> <a id="feedback"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="getCheckData"><span
								class="glyphicon glyphicon-comment"></span>反馈</a>
						</label>
					</div>
				</div>
			</form>
			<div class="col-lg-6 ztck-biaodan" >
				<label><span style="color: red">*</span><span>双击下表数据可显示订单详情</span><br>
				<span style="color: red">*</span><span>转邮政派送订单，境外单号在CDEK单号列和韵达国际列中显示</span>
							</label>
					</div>
		</div>
		<table id="test" style="height: 0px; width: 1555px;"
			lay-filter="demoEvent">
		</table>
	</div>
	<form id="f_orderOut_export"
		action="<%=path%>/queryOrder/exportOrderOut.html?" method="post">
		<input type="hidden" name="ids" id="orderOutIDS" />
	</form>

	<div id="FeedbackDiv" style="display: none;">
		<form action="" method="post" id="saveFeedback">
			<input type="hidden" name="ztOrderNo" id="ztOrderNo"> <input
				type="hidden" name="orderNo" id="orderNo"> <input
				type="hidden" name="mailNo" id="mailNo">
			<div class="col-lg-12 ">
				<div class="col-lg-12 ">
					<div class="layui-form-item">
						<input name="problemType" id="problemType" placeholder="请填写问题类型"
							class="form-control" type="text">
					</div>
				</div>
				<div class="col-lg-12">
					<textarea rows="10" cols="10" name="feedback" id="feedbackText"
						class="form-control" placeholder="请填写详细信息"></textarea>
					<span id="FeedbackName" style="color: red; display: none;">反馈信息不能为空</span>
				</div>
			</div>

		</form>
	</div>

	<div id="orderMX" style="display: none; background-color: #F0F0F0;">
		<div class="col-lg-12 titles">
			<span style="font-size: 20px">订单信息:</span>
		</div>
		<div class="col-lg-12 bighuan">
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>订单号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="orderNo1" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>内部单号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="ztOrderNo1" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>运单号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="mailNo1" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>境外物流编码:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="overseasNum" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>境外单号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="overseasMailNo" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>境外单号返回值:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="mailNOStatus" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>运抵国:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="destinationCountry1" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>总价:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="totalPrice" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>重量:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="grossWeight" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName "><h9>商家编码:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="merchantNum" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>产品名称:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="productName" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>运输方式:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="transport1" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>

			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>计费重量:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="payweight" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName "><h9>长:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="olength" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>宽:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="owidth" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>高:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="oheight" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>



			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>税号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="taxNumber" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName "><h9>EORI:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="eori" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>是否带电池:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="battery" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>货物类型:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="goodsTpye" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-12 titles">
			<span style="font-size: 20px">收件人信息:</span>
		</div>
		<div class="col-lg-12 bighuan">
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>收货人:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="consignee1" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>收货人国家:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="consigneeCountry" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>收货人省:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="consigneeContinent" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>收货人市:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="consigneeCity" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>收货人详细地址:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="consigneeAddress" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>收货人公司:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="consigneeCompany" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>收货人电话:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="consigneeTel" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>收货人邮编:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="postCode" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>收货人email:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="consigneeEmail" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-12 titles">
			<span style="font-size: 20px">寄件人信息:</span>
		</div>
		<div class="col-lg-12 bighuan">
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>寄件人:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="shipperName" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>寄件人公司:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="shipperCompany" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>寄件人省:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="shipperContinent" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>寄件人市:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="shipperCity" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>寄件人详细地址:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="shipperAddress" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>寄件人电话:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="shipperTel" readonly="readonly"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>寄件人邮编:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="shipperCode" readonly="readonly"
							class="form-control">
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-12 titles">
			<span style="font-size: 20px">海关申报品:</span>
		</div>
		<div class="col-lg-12 bighuan">
			<table id="orderSku" class="layui-hide"></table>
		</div>
	</div>
	<script type="text/html" id="track">
  <a class="layui-btn layui-btn-xs layui-btn-normal a" lay-event="detail" >跟踪</a>
</script>
</body>
</html>

