<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增修改用户页面</title>
<link href="<%=path%>/statics/layui/layui.css" rel="stylesheet">
<link href="<%=path%>/statics/css/user/user.css" rel="stylesheet">
<script src="<%=path%>/statics/layui/layui.js"></script>
<script src="<%=path%>/statics/js/jquery.min.js"></script>
<script src="<%=path%>/statics/js/common/common.js"></script>
</head>
<body>
	<div class="content">
    <form action="" method="post" id="enditform" class="layui-form enditform">
    	
        <div class="layui-form-item">
            <label class="layui-form-label">用户名称:</label>
            <div class="layui-input-block">
                <input type="text"  class="layui-input" lay-verify="required" name="userName" id="userName" value="${users.userName}">
                <span id="erroruserName" style="color: red"></span>
            </div> 
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-block">
                <input type="text"  class="layui-input" lay-verify="required" name="passWord" id="passWord"  value="${users.passWord}" >
                <span id="errorpassWord" style="color: red"></span>
            </div> 
        </div> 

        <div class="layui-form-item">
            <label class="layui-form-label">邮箱:</label>
            <div class="layui-input-block">
                <input type="text"  class="layui-input" lay-verify="email" name="email" id="email"  value="${users.email}" >
                <span id="erroremail" style="color: red"></span>
            </div> 
        </div>
        <div class="layui-form-item">
         <!-- <div class="layui-inline"> -->
				<label class="layui-form-label">用户类型</label>
				<div class="layui-input-block">
					<select name="userType" id="" lay-verify="required">
						<option value="2" <c:if test="${users.userType=='2'}">selected</c:if>>客户</option>
						<option value="0" <c:if test="${users.userType=='0'}">selected</c:if>>管理员</option>
						<option value="1" <c:if test="${users.userType=='1'}">selected</c:if>>操作员</option>					
					</select>
				</div>
				<!-- </div> -->
        		</div>
        <!-- <div class="form-group text-center submit endit-btn" style="position: absolute;right: 50px;top: 300px;">
            <button type="button" class="layui-btn layui-btn-sm" id="enditSubmit" onclick="editSubmit()">确定</button>
            <button class="layui-btn layui-btn-sm" id="btnCancel" onclick="window.parent.location.reload()">取消</button>
        </div> -->
    </form>
    </div>
</body>
<script>

layui.use('form', function(){
	//alert($(User.email))
	var form = layui.form; 
	form.render();
	});
	if("${user.id}" != ""){
		var url = "<%=path%>/user/updateModularPrivilege.do?id="+"${users.id}"
	}else{
		var url = "<%=path%>/user/updateModularPrivilege.do"
	}
	
function submitHandler() {
	/* var userName = $("#userName").val();
	var passWord = $("#passWord").val();
	var email = $("#email").val();

	if(userName==null || userName=="" ){
		  layer.confirm("请填写用户名称")
	}
	if(passWord==null || passWord=="" ){
		  layer.confirm("请填写密码")
	}
	if(email==null || email=="" ){
		  layer.confirm("请填写邮箱")
	} */
	
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        async:false,
        url: url,
        data: $('#enditform').serialize(),
        success: function (result) {
            if (result.status == 200) {
            	layer.msg(result.msg, {
            		icon: 1,
            		time: 700,
            	},function(index){
        				window.parent.location.reload();
          				layer.close(index); 
            			});
            }else{
            	layer.msg(result.msg,{
            		icon: 2,
            		time: 700,
            	},function(index){
        				window.parent.location.reload();
          				layer.close(index); 
            			});
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}
</script>
</html>