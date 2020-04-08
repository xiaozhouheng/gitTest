<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String path = request.getContextPath();%>
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
    	<%-- <input type="hidden" name="id" id="id" value="${tHscode.id}"> --%>
        <div class="layui-form-item">
            <label class="layui-form-label">HSCODE</label>
            <div class="layui-input-block">
                <input type="text"  class="layui-input" lay-verify="required" name="hcode" id="hscode" value="${tHscode.hcode}">
                <span id="errorHscode" style="color: red"></span>
            </div> 
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-block">
                <input type="text"  class="layui-input" lay-verify="required" name="itemname" id="itemname"  value="${tHscode.itemname}" >
                <span id="errorItemname" style="color: red"></span>
            </div> 
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
				<label class="layui-form-label">第一单位</label>
				<div class="layui-input-inline">
					<select name="unit1" id="unit1">
						<!-- <option value="">请选择单位</option> -->
				 		<c:forEach items="${tEstimate}" var="estimate" varStatus="statu">
				 		<option value="${estimate.name}">${estimate.name}</option>
				 </c:forEach>
					</select>
				</div>
				</div>
			<div class="layui-inline">
				<label class="layui-form-label">第二单位</label>
				<div class="layui-input-inline">
					<select name="unit2" id="unit2">
						<!-- <option value="">请选择单位</option> -->
				 		<c:forEach items="${tEstimate}" var="estimate" varStatus="statu">
				 		<option value="${estimate.name}">${estimate.name}</option>
				 </c:forEach>
					</select>
				</div>
				</div>
        </div>
        <div class="layui-form-item">
			    <label class="layui-form-label">监管要求</label>
			    <div class="layui-input-block">
			      <input type="text" id="bz" name="bz" style="width:515px;" lay-verify="required" class="layui-input" value="${tHscode.bz }" maxlength="50">
			    </div>
  			</div>
       <!--  <div class="form-group text-center submit endit-btn" style="position: absolute;right: 50px;top: 300px;">
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
	if("${tHscode.id}" != ""){
		var url = "<%=path%>/hsCode/endit.do?id="+"${tHscode.id}"
	}else{
		var url = "<%=path%>/hsCode/endit.do"
	}
//提交	
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