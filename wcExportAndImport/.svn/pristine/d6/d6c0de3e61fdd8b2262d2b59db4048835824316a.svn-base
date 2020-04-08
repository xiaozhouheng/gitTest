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
<!--支付页面-->
<title><spring:message code='PaymentOfFreight' /></title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
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
        elem: '#test',
        url:'<%=path%>/orderZf/findorderZf.do',
        page: true,
        method:'post',
        height:750,
        limit:50,
        limits:[200,500,1000],
        id: 'queryOrders',
        cols: [[
                {field : 'id',checkbox : true,align : 'center',fixed:true},
                {field:'orderNo',  title: '<spring:message code='queryOrder.CustomerOrderNo'/>',align :'center'},
                {field:'mailNo',  title: '<spring:message code='queryOrder.TackingNo'/>',align :'center'},
                {field:'transport',  title: '<spring:message code='queryOrder.product2'/>',align :'center'},
                {field:'destinationCountry',  title: '<spring:message code='queryOrder.Country'/>',align :'center'},
                {field:'consignee',  title: '<spring:message code='queryOrder.ConsigneeName'/>',align :'center' },
                {field:'createTime',  title: '<spring:message code='queryOrder.CreateDate'/>',align :'center' },
                {field:'totalPrice',  title: '<spring:message code='toOrder.totalPrice'/>',align :'center'},
                {field:'paydetail',  title: '<spring:message code='toOrder.paydetail'/>',align :'center'},
                {field:'payweight',  title: '计算重量',align :'center'},
                {field:'reallyWeight',  title: '实际重量',align :'center'}
                //{field:'isPlay',  title: '是否支付',align :'center'},
               /*  {field:'zhekou',  title: '折扣',align :'center'} */
            ]]
        ,done: function(res, page, count){  
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
            $("[data-field='isPlay']").children().each(function(){  
                    if($(this).text()=='0'){  
                       $(this).text("未支付")  
                    }else if($(this).text()=='1'){  
                       $(this).text("已支付")  
                   }
            })  
        }
    });
        
    table.on('checkbox(queryOrders)', function (obj) {
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
			    getDeleteData: function(){ 
			    	 var checkStatus = table.checkStatus('queryOrders');
				      var data = checkStatus.data;
				      var length=i_ids.length;
				      if(length!=0){
					       layer.confirm("确定支付这<font color='red'>"+length+"</font>条订单？", function(index){ 
									var ids="";
									for(var i=0;i<length;i++){
										if(i==0){
											ids += i_ids[i];
										}else{
											ids += ','+i_ids[i];
										}						
									}
									$.post('<%=path%>/orderManage/pay.do',{ids:ids},
											function(rr){
										var result=eval('('+rr+')');
										if(result.result!=0){
											layer.msg(result.result,{icon:2});
										}else{
											layer.msg('支付成功',{icon:1});
											  //刷新数据
								        	  table.reload('queryOrders', {
                                             page: {
                                               curr: 1 //重新从第 1 页开始
                                                 }
								        	  })
								        	  i_ids = new Array(); 
										}
									})
						})
				    }else{
				    	layer.msg('请至少选择一条数据',{icon:2});
				    }
			    },
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
<body>
	<!-- 导航栏 -->
<%@ include file="base.txt" %>
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
				<li class="searchindex"><a href="<%=path%>/print/printMD.html"><spring:message
							code='print.printMD' /></a></li>
				<li class="active"><a href="<%=path%>/orderZf/orderZf.html"><spring:message
							code='PaymentOfFreight' /></a></li>
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
				<div class="container col-lg-10 col-xs-12 ztck-body">
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="getDeleteData">
							<span class="glyphicon glyphicon-print"></span>
							<spring:message code="pay.pay" />
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

		<table id="test" lay-filter="queryOrders"></table>

	</div>

	<!--
	作者：offline
	时间：2018-02-07
	描述：网站主体结束
-->

</body>
</html>
