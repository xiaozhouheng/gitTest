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
<!--申报品管理页面-->
<title><spring:message code="declare" /></title>
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
        url:'<%=path%>/declare/findAll.do',
        page: true,
        method:'post',
        height:750,
        limit:50,
        limits:[50,200,500,1000],
        id: 'queryOrders',
        cols: [[
            {field : 'id',checkbox : true,align : 'center',fixed:true},
            {field:'eName',  title: '<spring:message code='declare.DeclaredNameEN'/>',align :'center'},
            {field:'cName',  title: '<spring:message code='declare.DeclaredNameCN'/>',align :'center'},
            {field:'price', title: '<spring:message code='declare.UnitPrice'/>',align :'center'},
            {field:'netWeight',  title: '<spring:message code='declare.weight'/>',align :'center'},
            {field:'deliveryNote',  title: '<spring:message code='declare.PictupNote'/>',align :'center'},
            {field:'goodsNum',  title: '<spring:message code='declare.Code'/>',align :'center' },
            {field:'declareUrl',  title: '<spring:message code='declare.Declaredurl'/>',align :'center'},
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
	              var eName=$("#eName1").val();
			      //执行重载
			      table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	eName: eName
			      }
			      });
			    },
			    getDeleteData: function(){ //删除数据
				      var checkStatus = table.checkStatus('queryOrders');
				      var data = checkStatus.data;
				      var length=i_ids.length;
				     if(length==0){
				    	 layer.msg("请至少选择一条数据进行删除！",{icon:2});
			    }else{
				       layer.confirm("确定删除这<font color='red'>"+length+"</font>条数据？", function(){ 
								var ids="";
								for(var i=0;i<length;i++){
									if(i==0){
										ids += i_ids[i];
									}else{
										ids += ','+i_ids[i];
									}						
								}
							   $.post('<%=path%>/declare/delete.do',{ids:ids},
									   function(result){
								          if(result==0){
								        	  layer.msg("删除失败！",{icon:2});
								          }else{
								        	  layer.msg("删除成功！",{icon:1});
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
			    	
			    }
			   },
			   getUpdateData: function(){ //修改数据
				      var checkStatus = table.checkStatus('queryOrders');
				      var data = checkStatus.data;
				      var length=data.length;
				     if(length!=1){
				    	 layer.msg("请选择一条数据进行修改！",{icon:2});
			    }else{
			    	$("#declareId").val(data[0].id);
			    	$("#eName").val(data[0].eName);
			    	$("#cName").val(data[0].cName);
			    	$("#price").val(data[0].price);
			    	$("#goodsNum").val(data[0].goodsNum);
			    	$("#netWeight").val(data[0].netWeight);
			    	$("#deliveryNote").val(data[0].deliveryNote);
			    	$("#declareUrl").val(data[0].declareUrl);
			    	 layer.open({
			        	   type: 1,
			        	   title: '修改申报品',
			        	   area: ['600px', '450px'],
			        	   skin: 'yourclass',
			        	   content: $('#add_declare'),
			        	   btn: ['保存', '取消']
			        	   ,yes: function(index){
			        		   var eName=$("#eName").val();
			        		   var price=$("#price").val();
			        		   var obj = $("#f_declare").serializeJson();
			        		   if(eName=="" || price=="" || eName==null || price==null){
              			          return false;
			        		   }else{
							   $.post('<%=path%>/declare/update.do',obj,
									   function(result){
								          if(result==1){
								        	  layer.msg("修改成功！",{icon:1});
								        	  layer.close(index);
								        	  //刷新数据
								        	  table.reload('queryOrders', {
                                                page: {
                                                  curr: 1 //重新从第 1 页开始
                                                    }
								        	  })
								          }else{
								        	  layer.msg("修改失败！",{icon:2});
								          }
							   })
			        		   }
			             }
			    	}		
			    	)
			    }
			   },
			   getAddData:function(){//添加数据
			    	$("#declareId").val("");
			    	$("#eName").val("");
			    	$("#cName").val("");
			    	$("#price").val("");
			    	$("#goodsNum").val("");
			    	$("#netWeight").val("");
			    	$("#deliveryNote").val("");
			    	$("#declareUrl").val("");
					 layer.open({
			        	   type: 1,
			        	   title: '新增申报品',
			        	   area: ['600px', '450px'],
			        	   skin: 'yourclass',
			        	   content: $('#add_declare'),
			        	   btn: ['保存', '取消']
			        	   ,yes: function(index){
			        		   var eName=$("#eName").val();
			        		   var price=$("#price").val();
			        		   var obj = $("#f_declare").serializeJson();
			        		   if(eName=="" || price=="" || eName==null || price==null){
			        			   layer.msg("带红色星号的必填项请填写完整",{icon:2});
              			          return false;
			        		   }else{
			        			   $.post('<%=path%>/declare/add.do',obj,
			        					   function(result){
			        				       if(result==1){
			        				           layer.msg("添加成功！",{icon:1});
			        				           //刷新数据
									        	  table.reload('queryOrders', {
	                                                page: {
	                                                  curr: 1 //重新从第 1 页开始
	                                                    }
									        	  })
			        				      	  layer.close(index);
			        				        }else{
			        				        	layer.msg("添加失败",{icon:2});
			        				        }
			        			   })
			        		   }
			        		  }
			        	 });
			   }
	 }   
			  $('.btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
	 
	    $("#eName").blur(function() {
		 var eName = $('#eName').val();
		 if(eName==null || eName==""){
			 document.getElementById("LogEname").innerHTML="英文名称不能为空！";
			 return false;
		 }else{
			 document.getElementById("LogEname").innerHTML="";
		 }
    }); 
	    
	    $("#price").blur(function() {
		 var price = $('#price').val();
		 if(price==null || price==""){
			 document.getElementById("LogPrice").innerHTML="单价不能为空！";
			 return false;
		 }else{
			 document.getElementById("LogPrice").innerHTML="";
		 }
    }); 
	    
	    /**回车事件*/
	 	   $("#eName1").keydown(function(event){
	 		   if(event.keyCode ==13){
	 			  var eName=$("#eName1").val();
			      //执行重载
			      table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	eName: eName
			      }
			      });
	 		   }
	 		});
});
    //鼠标滑过显示
  /*   $(function () {
        $(".dropdown").mouseover(function () {
            $(this).addClass("open");
        });

        $(".dropdown").mouseleave(function(){
            $(this).removeClass("open");
        })

    }) */
</script>
<body>
	<!-- 导航栏 -->
<%@ include file="basebar/settingsbar.txt" %>

	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="createto_create createbatch_upload active"><a
					href="<%=path%>/declare/toquery.html"><spring:message
							code="declare" /></a></li>
				<li
					class="managementinfo_received managementshipment_received managementon_delivery
				managementdraft managementshipped managementpicked_up managementdelivered ">
					<a href="<%=path%>/sender/sender.html"><spring:message
							code="sender" /></a>
				</li>
				<!-- 			<li class="ordinary_mailindex">< a href="/order/my_order/ordinary_mail/index">平邮订单</ a></li>  -->
				<li class="searchindex"><a
					href="<%=path%>/register/toupdate.html"><spring:message
							code="pwd" /></a></li>
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
							data-type="getAddData">
							<span class="glyphicon glyphicon-plus"></span>
							<spring:message code="declare.add" />
						</button>
					</div>
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="getUpdateData">
							<span class="glyphicon glyphicon-edit"></span>
							<spring:message code="declare.Edit" />
						</button>
					</div>
					<div class="col-lg-1 col-xs-2 container">
						<button type="button"
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							data-type="getDeleteData">
							<span class="glyphicon glyphicon-remove"></span>
							<spring:message code="declare.Delete" />
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-3 container">
			<div class="form-group">
				<div class="input-group  col-xs-9">
					<input type="text" id="eName1" class="form-control"
						placeholder="<spring:message code="declare.SearchbyName"/>">
					<span class="input-group-btn"> <a
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
	<!--添加 弹出层-->
	<div id="add_declare" style="display: none;">
		<form id="f_declare" method="post">
			<input type="hidden" name="id" id="declareId" class="form-control">
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;">*</span>
				<spring:message code='declare.DeclaredNameEN' /></label>
				<div class="col-lg-5">
					<input type="text" name="eName" id="eName" class="form-control">
					<span id="LogEname" style="color: red"></span>
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;"></span>
				<spring:message code='declare.DeclaredNameCN' /></label>
				<div class="col-lg-5">
					<input type="text" name="cName" id="cName" class="form-control">
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;">*</span>
				<spring:message code='declare.UnitPrice' />（USD）</label>
				<div class="col-lg-5">
					<input type="text" name="price" id="price" class="form-control"
						onkeyup="value=value.replace(/[^\d.]/g,'')"> <span
						id="LogPrice" style="color: red"></span>
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;"></span>
				<spring:message code='declare.Code' /></label>
				<div class="col-lg-5">
					<input type="text" name="goodsNum" id="goodsNum"
						class="form-control">
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;"></span>
				<spring:message code='declare.weight' /></label>
				<div class="col-lg-5">
					<input type="text" name="netWeight" id="netWeight"
						class="form-control">
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;"></span>
				<spring:message code='declare.PictupNote' /></label>
				<div class="col-lg-5">
					<input type="text" name="deliveryNote" id="deliveryNote"
						class="form-control">
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;"></span>
				<spring:message code='declare.Declaredurl' /></label>
				<div class="col-lg-5">
					<input type="text" name="declareUrl" id="declareUrl"
						class="form-control">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
