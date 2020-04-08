<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业管理</title>
<link href="<%=path%>/statics/layui/css/layui.css" rel="stylesheet">
<script src="<%=path%>/statics/layui/layui.js"></script>
<script src="<%=path%>/statics/js/jquery.min.js"></script>
<script src="<%=path%>/statics/js/common/common.js"></script>
<style>
/* 
搜索框和按钮
*/
.same{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    border: 0;
    height: 38px;
} 
.btn{
    width: 5%;
    color:#ffffff;
    background-color: #009688;
}

.search-collapse,.select-table{
	position: relative;
    background: #fff;
    border-radius: 6px;
    margin-top: 10px;
    margin-left:20px;
    margin-right:20px;
    padding-top: 13px;
    padding-bottom: 13px;
    padding-left:10px;
    box-shadow: 1px 1px 3px rgba(0,0,0,.2);
}
</style>
</head>
<body class="layui-layout-body">
<div class="col-sm-12 search-collapse" class='demoTable'>
<form class="layui-form" action="" method="get" id="moduleSerach">
  <div class="layui-form-item form-inline">
    <div class="layui-input-inline" style="width:120px;">
      <select name="serachname" id="serachname" lay-verify="required">
        <option value="creditCode">企业统一社会信用代码证编号</option>
        <option value="companyEnName">企业英文名称</option>
        <option value="companyChName">企业中文名称</option>
      </select>
  </div>
  
    <div class="layui-input-inline">
      <input type="text" id="getValue" placeholder="请输入关键词" autocomplete="off" class="layui-input">
    </div>
    <button class="layui-btn" type="button" id="btnSerach" data-type="reload" onclick="">搜索</button>
  </div>
</form>
</div>
<div class="col-sm-12 select-table">
		<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.comAudit('60%','70%')"data-type="comAudit"> 
		<i class="layui-icon">&#xe605;</i>审核
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick ="$.operate.removeAll()" data-type="getDeleteData" >
  			<i class="layui-icon">&#xe640;</i> 删除
    	</button>
		<table class="layui-hide" id="layuiTable" lay-data="idTest" lay-filter="layuiTable" style="margin-bottom: -17px;"></table>
	</div>
<script>
//入口方法 
$(function(){
	var options = {
			//初始显示所有地址
			url : '<%=path%>/company/getAllCompany.do',
			//进入审核页面的地址
			AuditUrl:'<%=path%>/company/ReviewCompany.do',
			//删除地址     
			removeUrl : '<%=path%>/company/deleteCompanyByID.do',
			//生成 Layui table 的标识 id，必须提供，用于后文刷新操作
			 id: "queryOrders", 
			//显示字段
			cols: [[ //表头
                    {type:'checkbox', fixed: 'left',templet :function (row){ 
                  	   var id = row.id;
                    }}
                   ,{field: 'creditCode', title: '企业统一社会信用代码证编号',align: 'center'}
                   ,{field: 'companyChName', title: '企业中文名称',align: 'center'}
                   ,{field: 'companyEnName', title: '企业英文名称',align: 'center'}
                   ,{field: 'customsCode', title: '海关编码注册',align: 'center'} 
                   ,{field: 'commodityNumber', title: '商检注册编码',align: 'center'}
                   ,{field: 'corporateContact', title: '关务联系人',align: 'center'}
                   ,{field: 'mobilePhone', title: '关务联系电话',align: 'center'}
                   ,{field: 'status', title: '状态',align: 'center',templet :function (d){
                	   if (d.status =='0'){
                           return '未审核'
                       }else if (d.status =='1'){
                           return '已审核'
                       }else if (d.status ==null){
                           return ''
                       }
                     }}
                   ,{field: '', title: '备注',align: 'center'}
                 ]]
			}
			
	   //根据条件查询表格数据重新加载
	   active = {
		    reload: function(){
		    //获取用户输入内容
		      var getValue = $("#getValue");
		      var name = $('#serachname option:selected').attr("value")
		      if(name == "creditCode"){
		    	//执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	creditCode:getValue.val(),
			        	companyChName:"",
			        	companyEnName:""
			        }
			      }, 'data');
		      }else if(name == "companyChName"){
		    	//执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	companyChName:getValue.val(),
			        	creditCode:"",
			        	companyEnName:""
			        }
			      }, 'data'); 
		      }else if(name == "companyEnName"){
		    	//执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	companyEnName:getValue.val(),
			        	creditCode:"",
			        	companyChName:""
			        }
			      }, 'data'); 
		      }else{
		    	  alert("致命错误！")
		      }
		      
		   }
		};
	  //点击搜索按钮根据用户名称查询
	  $('#btnSerach').on('click',function(){
       var type = $(this).data('type');
       //alert(type)
       active[type] ? active[type].call(this) : '';
   });
	//进入初始化表格方法
	$.table.init(options);
})
</script>
</body>
</html>