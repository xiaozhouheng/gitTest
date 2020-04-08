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
<!--发件人管理页面-->
<title><spring:message code="sender" /></title>
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
<%@ include file="basebar/settingsbar.txt" %>

	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="createto_create createbatch_upload"><a
					href="<%=path%>/declare/toquery.html"><spring:message
							code="declare" /></a></li>
				<li
					class="managementinfo_received managementshipment_received managementon_delivery
				managementdraft managementshipped managementpicked_up managementdelivered active">
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
		<div class="col-lg-12">
			<div class="container-fluid col-lg-7">
				<div class="row container">
					<div class="container col-lg-10 col-xs-12 ztck-body">
						<div class="col-lg-1 col-xs-2 container">
							<button type="button" id="save"
								class="btn layui-btn layui-btn-normal layui-btn-sm">
								<span class="glyphicon glyphicon-plus"></span>
								<spring:message code="sender.add" />
							</button>
						</div>
						<div class="col-lg-1 col-xs-2 container">
							<button type="button" id="edit"
								class="btn layui-btn layui-btn-normal layui-btn-sm">
								<span class="glyphicon glyphicon-edit"></span>
								<spring:message code="sender.Edit" />
							</button>
						</div>
						<div class="col-lg-1 col-xs-2 container">
							<button type="button" id="delete"
								class="btn layui-btn layui-btn-normal layui-btn-sm">
								<span class="glyphicon glyphicon-remove"></span>
								<spring:message code="sender.Delete" />
							</button>
						</div>
					<%-- 	<div class="col-lg-1 col-xs-2 container">
							<button type="button" id="default"
								class="btn layui-btn layui-btn-normal layui-btn-sm">
								<span class="glyphicon glyphicon-user"></span>
								<spring:message code="sender.SetAsDefaultShipper" />
							</button>
						</div> --%>
					</div>
				</div>
			</div>
			<div class="col-lg-3 container col-md-offset-2">
				<div class="form-group">
					<div class="input-group  col-lg-9 col-xs-11">
						<input type="text" name="keyword" id="keyword"
							class="form-control"
							placeholder="<spring:message code="sender.SearchbyNameTel"/>">
						<span class="input-group-btn"> <a
							class="btn layui-btn layui-btn-normal layui-btn-sm"
							id="sender-sou" data-type="reload"><i class="layui-icon">&#xe615;</i></a>
						</span>
					</div>
				</div>

			</div>
		</div>
		<table class="layui-hide" id="test" lay-filter="queryOrders"></table>

	</div>

	<script type="text/javascript">
var i_ids =new Array();
//当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量
var table_data=new Array();
    layui.use(['laydate', 'laypage', 'layer', 'table', 'element'], function(){
        var laydate = layui.laydate //日期
            ,laypage = layui.laypage //分页
        layer = layui.layer //弹层
            ,table = layui.table //表格
            ,element = layui.element; //元素操作
            
        table.render({
            elem: '#test'
            ,id:'senderTable'
            ,url:'<%=path%>/sender/SenderAll.do?backstage=0'
            ,limit:50
            ,limits:[50,200,500,1000]
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                ,curr: 1 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
            }
            ,page: true
            ,height:750
            ,method:'post'
            ,cols: [[
                {field:'id',checkbox:true,align : 'center',fixed:true}
                ,{field:'shipperName', title: '<spring:message code="sender.ShipperName"/>',align : 'center'}
                ,{field:'shipperCompany', title: '<spring:message code="sender.Company"/>',align : 'center'}
                ,{field:'shipperTel', title: '<spring:message code="sender.Tel"/>',align : 'center'}
                ,{field:'shipperContinent', title: '<spring:message code="sender.Province/State"/>',align : 'center'}
                ,{field:'shipperCity', title: '<spring:message code="sender.City"/>',align : 'center'}
                ,{field:'shipperAddress', title: '<spring:message code="sender.Street"/>',align : 'center'}
                ,{field:'shipperCode', title: '<spring:message code="sender.Postcode"/>',align : 'center'}
               // ,{field:'state', width:160, title: '<spring:message code="sender.Default"/>',align : 'center'}
            ]]
            ,done:function(res,page,count){
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
                
            	/* $("[data-field='state']").children().each(function(){  
            		 if($(this).text()=='0'){  
                         $(this).text("否")  
                      }else if($(this).text()=='1'){  
                    	 $(this).text("")  
                         $(this).append('<span class="glyphicon glyphicon-ok-circle" style="color: #1E9FFF;"></span>')  
                      }
            	}) */
            }

        });
            
        table.on('checkbox(queryOrders)', function (obj) {
        	if(obj.checked==true){
                if(obj.type=='one'){
             	   var flag = 0;
             	   for(i in i_ids){
             		   if(i == obj.data.id){
             			   flag=1;
             			  // alert(i);
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
          	      var keyword = $('#keyword');
          	      //执行重载
          	      table.reload('senderTable', {
          	        page: {
          	          curr: 1 //重新从第 1 页开始
          	        }
          	        ,where: {
          	        	key: keyword.val()
          	        }
          	      });
          	    }
          	  }; 
        
        /**回车事件*/
	 	   $("#keyword").keydown(function(event){
	 		   if(event.keyCode ==13){
	 			  var keyword = $('#keyword');
          	      //执行重载
          	      table.reload('senderTable', {
          	        page: {
          	          curr: 1 //重新从第 1 页开始
          	        }
          	        ,where: {
          	        	key: keyword.val()
          	        }
          	      });
	 		   }
	 		});
        
          $('#sender-sou').on('click', function(){
              var type = $(this).data('type');
              active[type] ? active[type].call(this) : '';
            });     
            
            //添加发件人
         $("#save").click(function(){
        	 clear();
        	 layer.open({
        	   type: 1,
        	   title: '新增发件人',
        	   area: ['600px', '500px'],
        	   skin: 'yourclass',
        	   content: $('#saveDiv'),
        	   btn: ['保存', '取消']
        	   ,yes: function(index){
        		   var shipperName=$("#shipperName").val();
        		   var shipperTel=$("#shipperTel").val();
        		   var shipperContinent=$("#shipperContinent").val();
        		   var shipperCity=$("#shipperCity").val();
        		   var shipperAddress=$("#shipperAddress").val();
							if (shipperName == ""
											|| shipperName == null
											|| shipperTel == ""
											|| shipperTel == null
											|| shipperContinent == ""
											|| shipperContinent == null
											|| shipperCity==""
											|| shipperCity==null
											|| shipperAddress==""
											|| shipperAddress==null
										){
									layer.msg("带红色星号的必填项请填写完整",{icon:2});
									return false;
									}else if(/[\u4E00-\u9FA5]/.test(shipperName)){
										 $("#PromptName").text("发件人姓名不能为汉字");
										 return false;
									}else{
					   var obj = $("#saveSender").serializeJson();
					   //console.log(obj);
					   $.ajax({
					   url : '<%=path%>/sender/saveSender.do',
        			   type:'post',
        			   data:obj,
        			   success:function(msg){
        				   if(msg==1){
        					   layer.msg("添加成功",{icon: 1});
        					   layer.close(index); 
        					   table.reload('senderTable',{
        						  page: {
        							  curr:1
        						  }
        					   });
        				   }
        			   },
        			   error:function(msg){
        				   layer.msg("添加失败",{icon: 2});
        			   }
        		   });
					}  
        		  }
        	 });
        	 
         }); 
         //修改发件人
         $("#edit").click(function(){
        	 var checkStatus = table.checkStatus('senderTable'); //获取表格选中数据的值  数组
        	 var data=checkStatus.data;
        	 if(checkStatus.data.length!=1){
        		 layer.msg("请选择一条数据进行修改",{icon:2});
        		 return false;
        	 }else{
        		 $("#id").val(data[0].id);
        		 $("#userid").val(data[0].userid);
        		 $("#state").val(data[0].state);
        		 $("#shipperName").val(data[0].shipperName);
        		 $("#shipperCompany").val(data[0].shipperCompany);
      		     $("#shipperTel").val(data[0].shipperTel);
      		     $("#shipperContinent").val(data[0].shipperContinent);
      		     $("#shipperCity").val(data[0].shipperCity);
      		     $("#shipperAddress").val(data[0].shipperAddress);
      		     $("#shipperCode").val(data[0].shipperCode);
      		   	 $("#backstage").val(data[0].backstage);
      		   	 console.log(data[0].backstage);
        		 layer.open({
                	   type: 1,
                	   title: '新增发件人',
                	   area: ['600px', '500px'],
                	   skin: 'yourclass',
                	   content: $('#saveDiv'),
                	   btn: ['保存', '取消'],
                	   yes:function(index){
                		   var shipperName=$("#shipperName").val();
                		   var shipperTel=$("#shipperTel").val();
                		   var shipperContinent=$("#shipperContinent").val();
                		   var shipperCity=$("#shipperCity").val();
                		   var shipperAddress=$("#shipperAddress").val();
        							if (shipperName == ""
        											|| shipperName == null
        											|| shipperTel == ""
        											|| shipperTel == null
        											|| shipperContinent == ""
        											|| shipperContinent == null
        											|| shipperCity==""
        											|| shipperCity==null
        											|| shipperAddress==""
        											|| shipperAddress==null
        										){
        									return false;
        									}else if(/[\u4E00-\u9FA5]/.test(shipperName)){
       										 $("#PromptName").text("发件人姓名不能为汉字");
    										 return false;
    									}else{
                		   var editObj = $("#saveSender").serializeJson();
                		$.ajax({
                			url:'<%=path%>/sender/editSender.do',
                			type:'post',
                			data:editObj,
                			success:function(msg){
                				 if(msg==1){
                					 layer.msg("修改成功",{icon: 1})
                					 layer.close(index);
                					 table.reload('senderTable',{
                						page:{
                							curr:1
                						} 
                					 });
                				 }
                			},
                			error:function(){
                				layer.msg("修改失败",{icon: 2})
                			}
                		});
    					} 
                	   }
              	 }); 
        	 }
         });
         //删除发件人
         $("#delete").click(function(){
        	 var checkStatus = table.checkStatus('senderTable'); //获取表格选中数据的值  数组
        	 var data=checkStatus.data;
        	 var length=i_ids.length;
        	 if(length==0){
        		 layer.msg("请至少选择一条数据进行删除",{icon:2});
        		 return false;
        	 }else{
        		 layer.confirm("你确定要删除<font color='red'>"+length+"</font>条数据吗？", {icon: 3, title:'提示'}, function(index){
        			  var ids="";
        			  for (var i = 0; i < length; i++) {
						if(i==0){
							ids+=i_ids[i];
						}else{
							ids+=','+i_ids[i];
						}
					}
        			$.ajax({
        				url: "<%=path%>/sender/deleteSender.do",
        				type: 'post',
        				data: {ids:ids},
        				success:function(msg){
        					if(msg==1){
           					 layer.msg("删除成功",{icon: 1})
           					 layer.close(index);
           					 table.reload('senderTable',{
           						page:{
           							curr:1
           						} 
           					 });
           					 i_ids = new Array(); 
           				 }
        				},
        				error: function(){
        					layer.msg("删除失败",{icon:2});
        				}
        			});	  
        			});
        	 }
         });
         
        //设置默认发件人
        $("#default").click(function(){
        	 var checkStatus = table.checkStatus('senderTable'); //获取表格选中数据的值  数组
        	 var data=checkStatus.data;
        	 var length=data.length;
        	 if(length!=1){
        		 layer.msg("请选择一条进行设置",{icon:2});
        		 return false;
        	 }else{
        		 layer.confirm("您确定要将他设置成默认发件人吗？", {icon: 3, title:'提示'}, function(index){
        		 $.ajax({
        			url:'<%=path%>/sender/defaultSender.do?backstage=0', 
        			type : 'post',
        			data : {id:data[0].id},
					success:function(msg){
						if(msg==1){
          					 layer.msg("设置成功",{icon: 1})
          					 layer.close(index);
          					 table.reload('senderTable',{
          						page:{
          							curr:1
          						} 
          					 });
          					 i_ids = new Array(); 
          				 }
					},
					error:function(){
						layer.msg("设置失败！",{icon:2});
					}
        		 	});
        		 
        		 });
        	 }
        });
         
            
        
         //判断收件人姓名
         $("#shipperName").blur(function(){
        	 var shipperName=$("#shipperName").val();
        	 if(shipperName==""||shipperName==null){
        		 $("#PromptName").text("发件人姓名不能为空");
        	 }else  if(/[\u4E00-\u9FA5]/.test(shipperName)){
        		 $("#PromptName").text("发件人姓名不能为汉字");
        	 } else{
        		 $("#PromptName").text("");
        	 }
         });
        //判断收件人电话
         $("#shipperTel").blur(function(){
        	 var shipperTel=$("#shipperTel").val();
        	 if(shipperTel==""||shipperTel==null){
        		 $("#PromptTel").css("display","block");
        	 }else{
        		 $("#PromptTel").css("display","none");
        	 }
         });
        //判断省份
         $("#shipperContinent").blur(function(){
        	 var shipperContinent=$("#shipperContinent").val();
        	 if(shipperContinent==""||shipperContinent==null){
        		 $("#PromptContinent").css("display","block");
        	 }else{
        		 $("#PromptContinent").css("display","none");
        	 }
         }); 
        
       //判断城市
         $("#shipperCity").blur(function(){
        	 var shipperCity=$("#shipperCity").val();
        	 if(shipperCity==""||shipperCity==null){
        		 $("#PromptCity").css("display","block");
        	 }else{
        		 $("#PromptCity").css("display","none");
        	 }
         });
       //判断详细地址
         $("#shipperAddress").blur(function(){
        	 var shipperAddress=$("#shipperAddress").val();
        	 if(shipperAddress==""||shipperAddress==null){
        		 $("#PromptAddress").css("display","block");
        	 }else{
        		 $("#PromptAddress").css("display","none");
        	 }
         });
       //清理输入框数据
       function clear(){
    	   //每次点击添加的时候将input清空
      	 $("input[type='text']").val("");
    	 $("#state").val("0");
    	 $("#backstage").val("0");
       }
          
    })
</script>

	<!--
	作者：offline
	时间：2018-02-07
	描述：网站主体结束
-->
	<div id="saveDiv" style="display: none;">
		<form action="" method="post" id="saveSender">

			<input type="hidden" name="id" id="id"> <input type="hidden"
				name="userid" id="userid"> <input type="hidden" name="state"
				id="state"> <input type="hidden" name="backstage"
				id="backstage">
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;">*</span>发件人姓名</label>
				<div class="col-lg-5">
					<input type="text" id="shipperName" class="form-control"
						name="shipperName"> <span id="PromptName"
						style="color: red;"></span>
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;">公司</label>
				<div class="col-lg-5">
					<input type="text" id="shipperCompany" class="form-control"
						name="shipperCompany">
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;">*</span>电话</label>
				<div class="col-lg-5">
					<input type="text" id="shipperTel" class="form-control"
						name="shipperTel"> <span id="PromptTel"
						style="color: red; display: none;">电话不能为空</span>
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;">*</span>省/州</label>
				<div class="col-lg-5">
					<input type="text" id="shipperContinent" class="form-control"
						name="shipperContinent"> <span id="PromptContinent"
						style="color: red; display: none;">不能为空</span>
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;">*</span>城市</label>
				<div class="col-lg-5">
					<input type="text" id="shipperCity" class="form-control"
						name="shipperCity"> <span id="PromptCity"
						style="color: red; display: none;">不能为空</span>
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;"><span
					style="color: red; text-align: right;">*</span>详细地址</label>
				<div class="col-lg-5">
					<input type="text" id="shipperAddress" class="form-control"
						name="shipperAddress"> <span id="PromptAddress"
						style="color: red; display: none;">详细地址不能为空</span>
				</div>
			</div>
			<div class="col-lg-12 saveInput">
				<label class="col-lg-4" style="padding-top: 6px; text-align: right;">邮编</label>
				<div class="col-lg-5">
					<input type="text" id="shipperCode" class="form-control"
						name="shipperCode">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
