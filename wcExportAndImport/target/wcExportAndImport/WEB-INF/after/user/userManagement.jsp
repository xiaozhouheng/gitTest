<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link href="<%=path%>/statics/layui/css/layui.css" rel="stylesheet">
<link href="<%=path%>/statics/css/user/user.css" rel="stylesheet">
<script src="<%=path%>/statics/layui/layui.js"></script>
<script src="<%=path%>/statics/js/jquery.min.js"></script>
<script src="<%=path%>/statics/js/common/common.js"></script>
</head>
<body class="layui-layout-body">
<div>
<div class="col-sm-12 search-collapse">
<form class="layui-form">
  <div class="layui-form-item form-inline">
    <div class="layui-input-inline" style="width:120px;">
     <select name="serachname" id="serachname" lay-verify="required">
        <option value="userName">用户名称</option>
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
		<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.getAddData('40%','59%')"data-type="getAddData">
  			<i class="layui-icon">&#xe608;</i> 添加
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.getUpdateData('38%','58%')"data-type="getUpdateData">
  			<i class="layui-icon">&#xe642;</i> 修改
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.editDataPrivilegesUi('45%','55%')"data-type="editDataPrivilegesUi">
  			<i class="layui-icon">&#xe642;</i> 修改数据权限
    	</button>
    	<!-- <button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.editPrivilegesUi('45%','55%')"data-type="editPrivilegesUi">
  			<i class="layui-icon">&#xe642;</i> 修改模块权限
    	</button> --> 
    	<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.removeAll()" data-type="getDeleteData">
  			<i class="layui-icon">&#xe640;</i> 删除
    	</button> 
		<table class="layui-hide" id="layuiTable" lay-filter="queryOrders" style="margin-bottom: -17px;"></table>
		<!-- <div id="barDemo" class="layui-hide">
		    <a class=" layui-btn layui-btn-xs" lay-event="edit" onclick="editUser(id)"><i class="layui-icon">&#xe642;</i>编辑</a>
		    <a class=" layui-btn-danger layui-btn layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
       </div> -->
	</div>
</div>

<script>
//入口方法 
$(function(){
	var options = {
			//初始显示所有地址
			url : '<%=path%>/user/findAllUser.do',
			//进入修改页面的地址
			editUrl : '<%=path%>/user/editUser.do',
			//进入添加页面的地址
			addUrl :'<%=path%>/user/editUser.do',
			//删除地址     
			removeUrl : '<%=path%>/user/deleteByID.do',
			//数据权限地址
			DataPrivilegesUrl:'<%=path%>/page/updateJump.do?path=after/user/updateDataPrivilege',
			//模块权限地址
			PrivilegesUrl:'<%=path%>/page/updateJump.do?path=after/user/updatePrivilege',
			//生成 Layui table 的标识 id，必须提供，用于后文刷新操作
			 id: "queryOrders", 
			//显示字段
			cols: [[ //表头
                   {type:'checkbox', fixed: 'left'}
                   /* ,{field: 'id', title: '序号', sort: false, fixed: 'left', templet :function (row){
                	   $("a").attr("id",row.id);
                	   return row.id; 
                   }}*/
                   ,{field: 'userName', title: '用户名称',templet :function (row){
                      var userName =row.userName;
                      return userName;
                   }}
                   ,{field: 'passWord', title: '密码'}
                   ,{field: 'email', title: '邮箱'} 
                   ,{field: 'status', title: '状态',templet :function (d){
                	 if (d.status =='1'){
                         return '有效'
                     }else {
                    	 return '无效' 
                     }
                 }}
                   /* ,{field: 'createUserId', title: '创建人'} */
                   ,{field: 'userType', title: '用户类型' ,templet :function (d){
                	 if (d.userType =='0'){
                         return '系统管理'
                     }else if(d.userType =='1'){
                         return '操作员'
                     }else if(d.userType =='2'){
                         return '客户'
                     }
                 }}
                   /* ,{field: 'modularPrivilege', title: '模块权限'}
                   ,{field: 'dataPrivilege', title: '数据权限'} */
                   ,{field: 'createTime', title: '创建时间',templet :function (row){
                       return createTime(row.createTime);
                     }}
                   /* ,{field: 'right', title: '操作', toolbar:"#barDemo"} */
                 ]]
			}
			
	//条件查询
	   //var $ = layui.$, 
	   active = {
			    reload: function(){
			    	var getValue = $("#getValue");
				    var name = $('#serachname option:selected').attr("value")
				    if(name == "userName"){
				    	//执行重载
					      layui.table.reload('queryOrders', {
					        page: {
					          curr: 1 //重新从第 1 页开始
					      }
					      //根据条件查询
					        ,where: {
					        	userName:getValue.val(),
					        }
					      }, 'data');
				      }
			    },
		         }   
	         $('#btnSerach').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
	//进入初始化表格方法
	$.table.init(options);
})
</script>
</body>
</html>