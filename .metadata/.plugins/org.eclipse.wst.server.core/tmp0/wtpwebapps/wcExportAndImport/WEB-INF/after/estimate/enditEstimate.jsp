<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增修改用户页面</title>
<link href="<%=path%>/statics/layui/layui.css" rel="stylesheet">
<link href="<%=path%>/statics/css/user/user.css" rel="stylesheet">
<script src="<%=path%>/statics/layui/layui.js"></script>
<script src="<%=path%>/statics/js/jquery.min.js"></script>
</head>
<body>
	<div class="content">
    <form action="" method="post" id="enditform" class="layui-form enditform">
    	
        <div class="layui-form-item">
            <label class="layui-form-label">计量代码</label>
            <div class="layui-input-block">
                <input type="text"  class="layui-input" lay-verify="required" name="code" id="code" value="${estimate.code}">
                <span id="errorCode" style="color: red"></span>
            </div> 
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">简称</label>
            <div class="layui-input-block">
                <input type="text"  class="layui-input" lay-verify="required" name="shortname" id="shortname"  value="${estimate.shortname}" >
                <span id="errorShort" style="color: red"></span>
            </div> 
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">全称</label>
            <div class="layui-input-block">
                <input type="text"  class="layui-input" lay-verify="required" name="name" id="fullName"  value="${estimate.name}" >
                <span id="errorFull" style="color: red"></span>
            </div> 
        </div>
        <div class="form-group text-center submit endit-btn" style="position: absolute;right: 50px;top: 300px;">
            <button type="button" class="layui-btn layui-btn-sm" id="enditSubmit" onclick="editSubmit()">确定</button>
            <button class="layui-btn layui-btn-sm" id="btnCancel" onclick="window.parent.location.reload()">取消</button>
        </div>
    </form>
    </div>
</body>
<script>

layui.use('form', function(){
	//alert($(User.email))
	var form = layui.form; 
	form.render();
	});
	if("${estimate.id}" != ""){
		var url = "<%=path%>/estimate/updateEstimate.do?id="+"${estimate.id}"
	}else{
		var url = "<%=path%>/estimate/updateEstimate.do"
	}
	
function editSubmit() {
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