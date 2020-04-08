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
<script src="http://localhost:18000/CLodopfuncs.js?priority=0"></script>
<script src="http://localhost:8000/CLodopfuncs.js?priority=1"></script>
<!--面单打印页面-->
<title><spring:message code='print.printMD' /></title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/printer.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
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
<body>
	<script type="text/javascript">
layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element','form'], function(){
    var laydate = layui.laydate, //日期
        laypage = layui.laypage, //分页
        layer = layui.layer, //弹层
        table = layui.table, //表格
        carousel = layui.carousel, //轮播
        upload = layui.upload, //上传
        element = layui.element; //元素操作
        form = layui.form;//form表单
    table.render({
        elem: '#test',
        url:'<%=path%>/orderManage/findAll.do?notEnd=7',
        page: true,
        method:'post',
        height:750,
        limit:50,
        limits:[50,200,500,1000],
        id: 'queryOrders',
        cols: [[
                {field : 'id',checkbox : true,align : 'center'},
                {field:'orderNo',  title: '<spring:message code='queryOrder.CustomerOrderNo'/>',align :'center'},
                {field:'mailNo',  title: '<spring:message code='queryOrder.TackingNo'/>',align :'center'},
                {field:'totalWayBill',  title: '<spring:message code='queryOrder.totalWayBill'/>',align :'center'},
                {field:'overseasMailNo',  title: '<spring:message code='print.oveaMailNo'/>',align :'center'},
                {field:'mailNOStatus',  title: '<spring:message code='print.oveaMailStatus'/>',align :'center'},
                {field:'transport', title: '<spring:message code='queryOrder.product2'/>',align :'center'},
                {field:'destinationCountry',  title: '<spring:message code='queryOrder.Country'/>',align :'center'},
                {field:'consignee',  title: '<spring:message code='queryOrder.ConsigneeName'/>',align :'center'},
                {field:'createTime',  title: '<spring:message code='queryOrder.CreateDate'/>',align :'center' },
                {field:'orderStep',  title: '<spring:message code='queryOrder.status2'/>',align :'center'},
               // {field:'printUrl',  title: '<spring:message code='print.url'/>',align :'center'}
            ]]
        ,done: function(res,row,page, count,index){  
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
                 	   $(this).text("待确认")  
                    }  
            });
            
            /*  $("[data-field='printUrl']").children().each(function(){  
                	  var a=$(this).text();
                	  $(this).text("");
                	  $(this).append('<a href="'+a+'" target="_blank">'+a+'</a>');
            });  */
        }
    });
        
	 var $ = layui.$, active = {
			    reload: function(){
	              var orderNo=$("#eName1").val();
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
			    getDeleteData: function(){ //获取打印面单
				      var checkStatus = table.checkStatus('queryOrders');
				      var data = checkStatus.data;
				      var length=data.length;
				      var printType=$("#printType").val();
				     if(length==0){
				    	 layer.msg("请至少选择一条数据进行面单获取！",{icon:2});
			    }else{
								var ids="";
								for(var i=0;i<length;i++){
									if(data[i].overseasMailNo==null || data[i].overseasMailNo==""){
										 layer.msg("有转单号的单子才能获取面单打印！",{icon:2});
										 return;
									}
									if(i==0){
										ids += data[i].id;
									}else{
										ids += ','+data[i].id;
									}						
								}
								var index=layer.load();
							   $.post('<%=path%>/print/getPrintMD.do',{ids:ids,printType:printType},
									   function(msg){
								       if(msg.result==1){
								    	   layer.msg("获取成功",{icon:1});
								    	   table.reload('queryOrders', {
										        page: {
										          curr: 1 //重新从第 1 页开始
										        }
										      });
								       }else{
								    	   layer.msg("获取失败",{icon:2});
								       }
								       layer.close(index); 
							   })
							   
							
			              }
			         },getMailNo: function(){ //获取转单号
				      var checkStatus = table.checkStatus('queryOrders');
				      var data = checkStatus.data;
				      var length=data.length;
				     if(length==0){
				    	 layer.msg("请至少选择一个进行匹配单号！",{icon:2});
			    }else{
								var ids="";
								for(var i=0;i<length;i++){
									if(data[i].overseasMailNo==null || data[i].overseasMailNo==""){
									if(i==0){
										ids += data[i].id;
									}else{
										ids += ','+data[i].id;
								     	}						
									}else{
										 layer.msg("已匹配的订单不能重复匹配！",{icon:2});
										 return;
									}
								}
								var index=layer.load();
							   $.post('<%=path%>/print/postProduct.do',{ids:ids},
									   function(ret){
								       if(ret=="1"){
								    	   layer.msg("获取成功",{icon:1});
								    	   table.reload('queryOrders', {
										        page: {
										        }
										      });
								       }else if(ret=="2"){
								    	   layer.msg("获取失败,境外物流编码错误！",{icon:2});
								       }else{
								    	   layer.msg("获取失败",{icon:2});
								       }
								       layer.close(index); 
							   })
			              }
			         },printZDA: function(){
			        	 var checkStatus = table.checkStatus('queryOrders');
					      var data = checkStatus.data;
					      var length=data.length;
					      if(length==0){
					    	  layer.msg("请至少选择一条进行打印",{icon:2});
					      }else{
					    	    var ids="";
								for(var i=0;i<length;i++){
									if(i==0){
										ids += data[i].id;
									}else{
										ids += ','+data[i].id;
									}					
								}
								var index=layer.load();
							$.ajax({
								type:"post",
								url:"<%=path%>/print/printZDA.do",
								data:{ids:ids},
								dataType: "json",
								success:function(msg){
									var order=msg.orders;
									if(order!=null){
										 LODOP.PRINT_INITA(0,0,378,378,"");
										for (var i = 0; i < order.length; i++) {
											   LODOP.NewPageA();
									<%-- 		   LODOP.ADD_PRINT_TEXT(16,63,292,40,"中达供应链有限公司");
										LODOP.PRINT_INITA(0,0,378,265,"");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",20);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_RECT(2,2,370,259,0,3);
											   LODOP.ADD_PRINT_RECT(77,3,368,96,0,1);
											   LODOP.ADD_PRINT_RECT(172,3,368,30,0,1);
											   LODOP.ADD_PRINT_RECT(201,3,368,31,0,1);
											   LODOP.ADD_PRINT_TEXT(48,90,243,30,"ZHONG DA SUPPLY CHAIN LIMITED COMPANY");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_BARCODE(84,62,286,60,"128Auto",order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
											   LODOP.ADD_PRINT_TEXT(147,97,196,30,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,15,69,26,"客户代码：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,78,107,29,order[i].merchantNum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,226,45,26,"重量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,270,69,26,order[i].grossWeight);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(210,15,69,26,"运单编号：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(209,82,106,29,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,15,69,26,"中文品类：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,78,110,26,order[i].category);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,226,69,26,"数量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,293,45,26,order[i].sum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_IMAGE(16,31,58,47,"<img border='0' src='<%=basePath%>/images/sackno.png'>");
											   LODOP.SET_PRINT_STYLEA(0,"Stretch",2);
											   if(order[i].isPreM==1){
												   LODOP.ADD_PRINT_TEXT(209,226,78,29,"已投保 保额:");
												   LODOP.SET_PRINT_STYLEA(0,"FontSize",8);
												   LODOP.ADD_PRINT_TEXT(208,305,70,29,"￥"+order[i].premiumPrice);
												   LODOP.SET_PRINT_STYLEA(0,"FontSize",8);
											   } --%>
										  
											   
											   LODOP.ADD_PRINT_RECT(328,0,198,50,0,1);
											   LODOP.ADD_PRINT_BARCODE(336,10,180,35,"128Auto",order[i].totalWayBill);
											   LODOP.ADD_PRINT_TEXT(115,75,224,25,"寄件人信息（Sender information）");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.ADD_PRINT_TEXT(142,200,75,20,"Weight(KG):");
											   LODOP.ADD_PRINT_TEXT(142,15,40,20,"Name:");
											   LODOP.ADD_PRINT_TEXT(142,52,140,20,order[i].shipperName);
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",8);
											   LODOP.ADD_PRINT_TEXT(142,270,106,20,order[i].grossWeight);
											   LODOP.ADD_PRINT_TEXT(164,15,38,20,"Tel:");
											   LODOP.ADD_PRINT_TEXT(164,52,140,20,order[i].shipperTel);
											   LODOP.ADD_PRINT_TEXT(219,75,224,25,"收件人信息（Recipient information）");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.ADD_PRINT_TEXT(245,223,70,20,"PostCode:");
											   LODOP.ADD_PRINT_TEXT(245,283,125,20,order[i].postCode);
											   LODOP.ADD_PRINT_TEXT(245,15,43,20,"Name:");
											   LODOP.ADD_PRINT_TEXT(270,54,100,20,order[i].consigneeTel);
											   LODOP.ADD_PRINT_TEXT(184,15,57,20,"Address:");
											   LODOP.ADD_PRINT_TEXT(187,71,286,20,order[i].shipperContinent+order[i].shipperCity+order[i].shipperAddress);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
											   LODOP.ADD_PRINT_TEXT(270,15,43,20,"Tel:");
											   LODOP.ADD_PRINT_TEXT(245,53,160,20,order[i].consignee);
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",8);
											   LODOP.ADD_PRINT_TEXT(164,200,52,20,"Cotain:");
											   LODOP.ADD_PRINT_TEXT(164,250,106,20,order[i].category);
											   LODOP.ADD_PRINT_IMAGE(11,196,45,45,"<img height='45' width='45' border='0' src='<%=basePath%>/statics/img/zdah_meitu_3.png'>");
											   LODOP.SET_PRINT_STYLEA(0,"Stretch",1);
											   LODOP.ADD_PRINT_IMAGE(15,0,185,40,"<img height='31' width='185' border='0' src='<%=basePath%>/statics/img/kuaidi_meitu_2.png'>");
											  <%--  LODOP.ADD_PRINT_IMAGE(67,5,120,35,"<img height='27' width='120' border='0' src='<%=basePath%>/statics/img/cdek_meitu_1.png'>"); --%>
											   LODOP.ADD_PRINT_RECT(60,0,130,50,0,1);
											   LODOP.ADD_PRINT_IMAGE(336,226,115,40,"<img height='40' width='115' border='0' src='<%=basePath%>/statics/img/yunda_meitu_1.png'>");
											   LODOP.ADD_PRINT_RECT(110,0,378,104,0,1);
											   LODOP.ADD_PRINT_TEXT(310,15,150,20,"Insured. Amount:");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   if(order[i].isPreM==1){
											       LODOP.ADD_PRINT_TEXT(310,130,209,20,"RMB"+order[i].premiumPrice);
											       LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   }
											   LODOP.ADD_PRINT_TEXT(284,15,58,20,"Address:");
											   LODOP.ADD_PRINT_TEXT(288,65,293,20,order[i].consigneeCountry+order[i].consigneeContinent+order[i].consigneeCity+order[i].consigneeAddress);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
											   LODOP.ADD_PRINT_RECT(60,130,248,50,0,1);
											   LODOP.ADD_PRINT_RECT(214,0,378,114,0,1);
											  /*  LODOP.ADD_PRINT_BARCODE(70,165,200,30,"128Auto",order[i].overseasMailNo); */
											   LODOP.ADD_PRINT_BARCODE(15,249,120,35,"128Auto",order[i].mailNo);
											   LODOP.ADD_PRINT_RECT(0,189,189,60,0,1);
											   LODOP.ADD_PRINT_RECT(0,0,378,60,0,1);
											   LODOP.ADD_PRINT_RECT(60,0,378,50,0,1);
											   LODOP.ADD_PRINT_RECT(328,0,378,50,0,1);
											   LODOP.ADD_PRINT_RECT(109,0,378,219,0,1);
									}
										 var printResult = LODOP.PREVIEW(); 
								        layer.close(index);
									}else{
								        layer.close(index);
										layer.msg("只能打印中达面单",{icon:2});
									}
								},error:function(msg){
								    layer.close(index);
									layer.msg("打印未成功",{icon:2});
								}
							});
					      }
			         },printHB: function(){  //华北eub
			        	 var checkStatus = table.checkStatus('queryOrders');
					      var data = checkStatus.data;
					      var length=data.length;
					      if(length==0){
					    	  layer.msg("请至少选择一条进行打印",{icon:2});
					      }else{
					    	    var ids="";
								for(var i=0;i<length;i++){
									if(data[i].overseasMailNo == null || data[i].overseasMailNo==''){
										layer.msg("请先获取邮政单号",{icon:2});
										return;
									 }
									if(i==0){
										ids += data[i].id;
									}else{
										ids += ','+data[i].id;
									}					
								}
								var index=layer.load();
							$.ajax({
								type:"post",
								url:"<%=path%>/print/printyzmd.do",
								data:{ids:ids},
								dataType: "json",
								success:function(msg){
									var order=msg.orders;
									if(order!=null){
										LODOP.PRINT_INITA(0,0,378,265,"");
										for (var i = 0; i < order.length; i++) {
											   LODOP.NewPageA();
											   LODOP.ADD_PRINT_TEXT(16,63,292,40,"华北E邮宝");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",20);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_RECT(2,2,370,259,0,3);
											   LODOP.ADD_PRINT_RECT(77,3,368,96,0,1);
											   LODOP.ADD_PRINT_RECT(172,3,368,30,0,1);
											   LODOP.ADD_PRINT_RECT(201,3,368,31,0,1);
											   LODOP.ADD_PRINT_TEXT(48,90,243,30,"ZHONG DA SUPPLY CHAIN LIMITED COMPANY");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_BARCODE(84,62,286,60,"128Auto",order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
											   LODOP.ADD_PRINT_TEXT(147,97,196,30,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,28,69,26,"客户代码：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,93,107,29,order[i].merchantNum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,241,45,26,"重量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,285,69,26,order[i].grossWeight);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(210,28,69,26,"运单编号：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(210,93,259,29,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,28,69,26,"中文品类：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,93,110,26,order[i].category);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,241,69,26,"中文数量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,308,45,26,order[i].sum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_IMAGE(16,31,58,47,"<img border='0' src='<%=basePath%>/images/sackno.png'>");
											   LODOP.SET_PRINT_STYLEA(0,"Stretch",2);
									}
										 var printResult = LODOP.PREVIEW(); 
								        layer.close(index);
									}else{
								        layer.close(index);
										layer.msg("获取面单失败",{icon:2});
									}
								},error:function(msg){
								    layer.close(index);
									layer.msg("打印未成功",{icon:2});
								}
							});
					      }
			         },printHD: function(){   //华东eub
			        	 var checkStatus = table.checkStatus('queryOrders');
					      var data = checkStatus.data;
					      var length=data.length;
					      if(length==0){
					    	  layer.msg("请至少选择一条进行打印",{icon:2});
					      }else{
					    	    var ids="";
								for(var i=0;i<length;i++){
									if(data[i].overseasMailNo == null || data[i].overseasMailNo==''){
										layer.msg("请先获取邮政单号",{icon:2});
										return;
									 }
									if(i==0){
										ids += data[i].id;
									}else{
										ids += ','+data[i].id;
									}					
								}
								var index=layer.load();
							$.ajax({
								type:"post",
								url:"<%=path%>/print/printyzmd.do",
								data:{ids:ids},
								dataType: "json",
								success:function(msg){
									var order=msg.orders;
									if(order!=null){
										LODOP.PRINT_INITA(0,0,378,265,"");
										for (var i = 0; i < order.length; i++) {
											   LODOP.NewPageA();
											   LODOP.ADD_PRINT_TEXT(16,63,292,40,"华东E邮宝");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",20);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_RECT(2,2,370,259,0,3);
											   LODOP.ADD_PRINT_RECT(77,3,368,96,0,1);
											   LODOP.ADD_PRINT_RECT(172,3,368,30,0,1);
											   LODOP.ADD_PRINT_RECT(201,3,368,31,0,1);
											   LODOP.ADD_PRINT_TEXT(48,90,243,30,"ZHONG DA SUPPLY CHAIN LIMITED COMPANY");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_BARCODE(84,62,286,60,"128Auto",order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
											   LODOP.ADD_PRINT_TEXT(147,97,196,30,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,28,69,26,"客户代码：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,93,107,29,order[i].merchantNum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,241,45,26,"重量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,285,69,26,order[i].grossWeight);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(210,28,69,26,"运单编号：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(210,93,259,29,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,28,69,26,"中文品类：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,93,110,26,order[i].category);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,241,69,26,"中文数量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,308,45,26,order[i].sum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_IMAGE(16,31,58,47,"<img border='0' src='<%=basePath%>/images/sackno.png'>");
											   LODOP.SET_PRINT_STYLEA(0,"Stretch",2);
									}
										 var printResult = LODOP.PREVIEW(); 
								        layer.close(index);
									}else{
								        layer.close(index);
										layer.msg("获取面单失败",{icon:2});
									}
								},error:function(msg){
								    layer.close(index);
									layer.msg("打印未成功",{icon:2});
								}
							});
					      }
			         },printDB: function(){ //邮政大包
			        	 var checkStatus = table.checkStatus('queryOrders');
					      var data = checkStatus.data;
					      var length=data.length;
					      if(length==0){
					    	  layer.msg("请至少选择一条进行打印",{icon:2});
					      }else{
					    	    var ids="";
								for(var i=0;i<length;i++){
								 if(data[i].overseasMailNo == null || data[i].overseasMailNo==''){
									layer.msg("请先获取邮政单号",{icon:2});
									return;
								 }
									if(i==0){
										ids += data[i].id;
									}else{
										ids += ','+data[i].id;
									}					
								}
								var index=layer.load();
							$.ajax({
								type:"post",
								url:"<%=path%>/print/printyzmd.do",
								data:{ids:ids},
								dataType: "json",
								success:function(msg){
									var order=msg.orders;
									if(order!=null){
										LODOP.PRINT_INITA(0,0,378,265,"");
										for (var i = 0; i < order.length; i++) {
											   LODOP.NewPageA();
											   LODOP.ADD_PRINT_TEXT(16,63,292,40,"邮政大包");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",20);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_RECT(2,2,370,259,0,3);
											   LODOP.ADD_PRINT_RECT(77,3,368,96,0,1);
											   LODOP.ADD_PRINT_RECT(172,3,368,30,0,1);
											   LODOP.ADD_PRINT_RECT(201,3,368,31,0,1);
											   LODOP.ADD_PRINT_TEXT(48,90,243,30,"ZHONG DA SUPPLY CHAIN LIMITED COMPANY");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_BARCODE(84,62,286,60,"128Auto",order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
											   LODOP.ADD_PRINT_TEXT(147,97,196,30,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,28,69,26,"客户代码：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,93,107,29,order[i].merchantNum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,241,45,26,"重量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,285,69,26,order[i].grossWeight);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(210,28,69,26,"运单编号：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(210,93,259,29,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,28,69,26,"中文品类：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,93,110,26,order[i].category);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,241,69,26,"中文数量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,308,45,26,order[i].sum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_IMAGE(16,31,58,47,"<img border='0' src='<%=basePath%>/images/sackno.png'>");
											   LODOP.SET_PRINT_STYLEA(0,"Stretch",2);
									}
										 var printResult = LODOP.PREVIEW(); 
								        layer.close(index);
									}else{
								        layer.close(index);
										layer.msg("获取面单失败",{icon:2});
									}
								},error:function(msg){
								    layer.close(index);
									layer.msg("打印未成功",{icon:2});
								}
							});
					      }
			         },printXB: function(){//邮政小包
			        	 var checkStatus = table.checkStatus('queryOrders');
					      var data = checkStatus.data;
					      var length=data.length;
					      if(length==0){
					    	  layer.msg("请至少选择一条进行打印",{icon:2});
					      }else{
					    	    var ids="";
								for(var i=0;i<length;i++){
									if(data[i].overseasMailNo == null || data[i].overseasMailNo==''){
										layer.msg("请先获取邮政单号",{icon:2});
										return;
									 }
									if(i==0){
										ids += data[i].id;
									}else{
										ids += ','+data[i].id;
									}					
								}
								var index=layer.load();
							$.ajax({
								type:"post",
								url:"<%=path%>/print/printyzmd.do",
								data:{ids:ids},
								dataType: "json",
								success:function(msg){
									var order=msg.orders;
									if(order!=null){
										LODOP.PRINT_INITA(0,0,378,265,"");
										for (var i = 0; i < order.length; i++) {
											   LODOP.NewPageA();
											   LODOP.ADD_PRINT_TEXT(16,63,292,40,"邮政小包");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",20);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_RECT(2,2,370,259,0,3);
											   LODOP.ADD_PRINT_RECT(77,3,368,96,0,1);
											   LODOP.ADD_PRINT_RECT(172,3,368,30,0,1);
											   LODOP.ADD_PRINT_RECT(201,3,368,31,0,1);
											   LODOP.ADD_PRINT_TEXT(48,90,243,30,"ZHONG DA SUPPLY CHAIN LIMITED COMPANY");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",7);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_BARCODE(84,62,286,60,"128Auto",order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
											   LODOP.ADD_PRINT_TEXT(147,97,196,30,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,28,69,26,"客户代码：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,93,107,29,order[i].merchantNum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,241,45,26,"重量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(179,285,69,26,order[i].grossWeight);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(210,28,69,26,"运单编号：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(210,93,259,29,order[i].mailNo);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,28,69,26,"中文品类：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,93,110,26,order[i].category);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,241,69,26,"中文数量：");
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_TEXT(239,308,45,26,order[i].sum);
											   LODOP.SET_PRINT_STYLEA(0,"FontName","微软雅黑");
											   LODOP.SET_PRINT_STYLEA(0,"Bold",1);
											   LODOP.ADD_PRINT_IMAGE(16,31,58,47,"<img border='0' src='<%=basePath%>/images/sackno.png'>");
											   LODOP.SET_PRINT_STYLEA(0,"Stretch",2);
									}
										 var printResult = LODOP.PREVIEW(); 
								        layer.close(index);
									}else{
								        layer.close(index);
										layer.msg("获取面单失败",{icon:2});
									}
								},error:function(msg){
								    layer.close(index);
									layer.msg("打印未成功",{icon:2});
								}
							});
					      }
			         }
			   }
			  $('.btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
	 /**回车事件*/
	   $("#eName1").keydown(function(event){
		   if(event.keyCode ==13){
			   var orderNo=$("#eName1").val();
			      //执行重载
			      table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	orderNo: orderNo
			      }
			      });
		   }
		});
	   /**打印格式*/
	     $("#expressCompany").on('change',function(){
	     	var overseasNum=$("#expressCompany").val();
	     	if(overseasNum=="HBEUB"){
	     		$("#div_1").css("display","block");
	     		$("#div_2").css("display","block");
	     		$("#div_3").css("display","none");
	     		$("#div_4").css("display","none");
	     		$("#div_5").css("display","none");
	     		$("#div_6").css("display","none");
	     	}else if(overseasNum=="HDEUB"){
	     		$("#div_1").css("display","block");
	     		$("#div_2").css("display","none");
	     		$("#div_3").css("display","block");
	     		$("#div_4").css("display","none");
	     		$("#div_5").css("display","none");
	     		$("#div_6").css("display","none");
	     	}else if(overseasNum=="YZDB"){
	     		$("#div_1").css("display","block");
	     		$("#div_2").css("display","none");
	     		$("#div_3").css("display","none");
	     		$("#div_4").css("display","block");
	     		$("#div_5").css("display","none");
	     		$("#div_6").css("display","none");
	     	}else if(overseasNum=="YZXB"){
	     		$("#div_1").css("display","block");
	     		$("#div_2").css("display","none");
	     		$("#div_3").css("display","none");
	     		$("#div_4").css("display","none");
	     		$("#div_5").css("display","block");
	     		$("#div_6").css("display","none");
	     	}else if(overseasNum=="CDEK"){
	     		$("#div_1").css("display","none");
	     		$("#div_2").css("display","none");
	     		$("#div_3").css("display","none");
	     		$("#div_4").css("display","none");
	     		$("#div_5").css("display","none");
	     		$("#div_6").css("display","block");
	     	}else if(overseasNum==""){
	     		$("#div_1").css("display","none");
	     		$("#div_2").css("display","none");
	     		$("#div_3").css("display","none");
	     		$("#div_4").css("display","none");
	     		$("#div_5").css("display","none");
	     		$("#div_6").css("display","none");
	     	} 
	     	  //执行重载
		      table.reload('queryOrders', {
		        page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		        	overseasNum: overseasNum
		      }
		      });
	     })
});
    //鼠标滑过显示
    $(function () {
       /*  $(".dropdown").mouseover(function () {
            $(this).addClass("open");
        });

        $(".dropdown").mouseleave(function(){
            $(this).removeClass("open");
        }) */
        $("#expressCompany1").attr("selected","selected");//因为f5不能刷新下拉框的值，所以这里这样给下拉框默认值
    })
</script>
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
				<li class="order_problemindex"><a
					href="<%=path%>/my_order/order_problem.html"><spring:message
							code="errOrder" /></a></li>

				<!-- 			<li class="ordinary_mailindex">< a href="/order/my_order/ordinary_mail/index">平邮订单</ a></li>  -->
				<li class="searchindex"><a
					href="<%=path%>/queryOrder/toquery.html"><spring:message
							code="queryOrder" /></a></li>
				<li class="searchindex active"><a
					href="<%=path%>/print/printMD.html"><spring:message
							code='print.printMD' /></a></li>
				<%-- <li class="searchindex"><a
					href="<%=path%>/orderZf/orderZf.html"><spring:message
							code='PaymentOfFreight' /></a></li> --%>
			</ul>
		</div>
	</div>


	<!--
	作者：offline
	时间：2018-02-07
	描述：网站主体开始
-->
	<div class="col-lg-1"></div>
	<div class="col-lg-10 col-xs-12 ztck-body">
		<br />
		<div class="container-fluid col-lg-9">
			<div class="row container">
				<div class="container col-lg-12 col-xs-12 ztck-body">
					<div class="col-lg-2 col-xs-6" >
							<select class="form-control "  id="expressCompany" >
								<option id="expressCompany1" value="" >--请选择--</option>
								<option value="CDEK" >中达产品</option>
								<option value="HBEUB">华北E邮宝</option>
								<option value="HDEUB" >华东E邮宝</option>
								<option value="YZDB" >邮政大包裹</option>
								<option value="YZXB" >邮政小包裹</option>
                            </select>
                            </div>
					<%-- 	<div class="col-lg-1 col-xs-4 ">
							<label style="margin-top: 5px; font-size: 14px;"><spring:message
									code='print.PrintFormat' /></label>
						</div>
						<div class="col-lg-2 col-xs-6">
							<select class="form-control " id="printType">
								<option value="00" selected>A4</option>
								<option value="01">4*4</option>
								<option value="03">4*6</option>
							</select>
						</div> --%>
						<div id="div_1" style="display: none;"class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="getMailNo">
							<span class="glyphicon glyphicon-download"></span>
							<spring:message code='print.mailNo' />
						</button>
					    </div>
					<div id="div_2" style="display: none;"class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="printHB">
							<span class="glyphicon glyphicon-print"></span>
							打印华北E邮宝
						</button>
						</div>
					<div id="div_3" style="display: none;"class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="printHD">
							<span class="glyphicon glyphicon-print"></span>
							打印华东E邮宝
						</button>
						</div>
					<div id="div_4" style="display: none;"class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="printDB">
							<span class="glyphicon glyphicon-print"></span>
							打印邮政大包
						</button>
						</div>
						<div id="div_5" style="display: none;" class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="printXB">
							<span class="glyphicon glyphicon-print"></span>
							打印邮政小包
						</button>
						</div>
						<div id="div_6" style="display: none;" class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="printZDA">
							<span class="glyphicon glyphicon-print"></span> 打印中达面单
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-3 container">
			<div class="form-group">
				<div class="input-group  col-xs-9">
					<input type="text" id="eName1" class="form-control"
						placeholder="<spring:message code="errOrder.please"/>"> <span
						class="input-group-btn"> <a
						class="btn layui-btn layui-btn-normal layui-btn-sm"
						id="search_submit" data-type="reload"><i class="layui-icon">&#xe615;</i></a>
					</span>
				</div>
			</div>
		</div>
       <div class="col-lg-12" >
				<label><span style="color: red">*</span><span><a href="http://116.62.218.77:8123/syck/plugin/lodop/CLodop_Setup.zip">打印插件下载</a></span><br>
							</label>
		</div>
		<br>
		<table id="test" lay-filter="queryOrders"></table>

	</div>
	<!--
	作者：offline
	时间：2018-02-07
	描述：网站主体结束
-->
 <object id="LODOP_OB"
		classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
		<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
	</object>
</body>
</html>
