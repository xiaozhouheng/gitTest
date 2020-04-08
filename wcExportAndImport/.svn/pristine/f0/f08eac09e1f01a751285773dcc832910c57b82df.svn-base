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
<title>模块管理</title>
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
<div class="col-sm-12 search-collapse">
<form class="layui-form" action="" method="get" id="moduleSerach">
  <div class="layui-form-item form-inline">
    <div class="layui-input-inline" style="width:120px;">
      <select name="serachname" id="serachname" lay-verify="required">
        <option value="name">模块名称</option>
        <option value="code">模块编码</option>
      </select>
  </div>
  
    <div class="layui-input-inline">
      <input type="text" id="getValue" placeholder="请输入关键词" autocomplete="off" class="layui-input">
    </div>
    <button class="same btn" type="button" data-type="reload" id="btnSerach" onclick="">搜索</button>
  </div>
</form>
</div>
<div class="col-sm-12 select-table">
		<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.getAddData('40%','59%')"data-type="getAddData">
  			<i class="layui-icon">&#xe608;</i> 添加
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.getUpdateData('38%','58%')"data-type="getUpdateData">
  			<i class="layui-icon">&#xe642;</i> 修改
    	</button> 
    	<button type="button" class="layui-btn layui-btn-sm" onclick ="$.operate.removeAll()" data-type="getDeleteData">
  			<i class="layui-icon">&#xe640;</i> 删除
    	</button> 
		<table class="layui-hide" id="layuiTable" lay-data="idTest" lay-filter="layuiTable" style="margin-bottom: -17px;"></table>
	</div>
<script>
//入口方法 
$(function(){
	var options = {
			//初始显示所有地址
			url : '<%=path%>/modular/findAllModular.do',
			//进入修改页面的地址
			editUrl : '<%=path%>/modular/updateJump.do',
			//进入添加页面的地址
			addUrl :'<%=path%>/modular/updateJump.do',
			//删除地址     
			removeUrl : '<%=path%>/modular/deleteModularByID.do',
			//生成 Layui table 的标识 id，必须提供，用于后文刷新操作
			 id: "queryOrders", 
			//显示字段
			cols: [[ //表头
                    {type:'checkbox', fixed: 'left'}
                    /* ,{field: 'id', title: '序号', sort: false, fixed: 'left', templet :function (row){
                 	   return row.id;
                    }} */
                   /* ,{field: 'parentId', title: '父菜单id',align: 'center',hide: true,templet :function (row){ 
                 	   return row.parentId;
                   }} */
                   /* ,{field: 'parentName', title: '父菜单名称'} */
                   ,{field: 'name', title: '模块名称',align: 'center',}
                   ,{field: 'code', title: '模块编码',align: 'center',} 
                   /* ,{field: 'sortOrder', title: '排列序号',align: 'center',} */
                   ,{field: 'isParent', title: '是否父菜单',align: 'center',templet :function (d){
                	   if (d.isParent =='0'){
                           return '否'
                       }else{
                           return '是'
                       }
                    }}
                   ,{field: 'status', title: '状态',align: 'center',templet :function (d){
                	   if (d.status =='0'){
                           return '删除'
                       }else if (d.status =='1'){
                           return '存在'
                       }
                     }}
                   ,{field: 'createTime', title: '创建时间',align: 'center',templet :function (row){
                       return createTime(row.createTime);
                   }}
                 ]]
			}
			
	//根据条件查询表格数据重新加载
	   active = {
		    reload: function(){
		    //获取用户输入内容
		      var getValue = $("#getValue");
		      var name = $('#serachname option:selected').attr("value")
		      if(name == "name"){
		    	//执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	name:getValue.val(),
			        	code:""
			        }
			      }, 'data');
		      }else if(name == "code"){
		    	//执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	code:getValue.val(),
			        	name:""
			        }
			      }, 'data'); 
		      }else{
		    	  alert("致命错误！")
		      }
		      
		   }
		};
	  //点击搜索按钮根据用户名称查询
	  $('#btnSerach').on('click',
      function(){
          var type = $(this).data('type');
          active[type] ? active[type].call(this) : '';
      });
	//进入初始化表格方法
	$.table.init(options);
})
</script>
</body>
</html>