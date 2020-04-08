<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = "";
    String username = "";
%>
<html>
<head>
<title>修改往来客户信息</title>
<link rel="shortcut icon" href="../statics/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="../statics/css/navigation.css" />
<link rel="stylesheet" href="../statics/css/xoms.layout.css" />
<link rel="stylesheet" href="../statics/layui/css/layui.css" />
<script type="text/javascript" src="../statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="../statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="../statics/layui/layui.js"></script>
<script type="text/javascript" src="../statics/js/common/common.js"></script>
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
<div id="aaa" style="margin: 5px">
		<form id="orderInfoForm" method="post" class="layui-form">
			<table class="layui-table" name="orderDetail">
				<tbody>
					<tr style="display: none;">
						<th>id</th>
						<td><input type="" name="id" id="id" value="${customerInformation.id}"></td>
						<td></td>
					</tr>
				</tbody>
			</table>	
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">客户代码</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input"
							id="customerCode" name="customerCode"
							value="${customerInformation.customerCode}">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">客户地址</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input"
							id="chAddress" name="chAddress"
							value="${customerInformation.chAddress}">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">客户名称(中文)</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input"
							id="customerChName" name="customerChName"
							value="${customerInformation.customerChName}">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">客户名称(英文)</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input" 
							id="customerEnName" name="customerEnName" value="${customerInformation.customerEnName}">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">英文地址</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input"
							id="enAddress" name="enAddress"
							value="${customerInformation.enAddress}">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">联系人</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input"
							id="contact" name="contact" value="${customerInformation.contact}">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">电话</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input"
							id="phone" name="phone" placeholder=""
							value="${customerInformation.phone}">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">传真</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input"
							id="fax" name="fax" value="${customerInformation.fax}">
					</div>
				</div>
			</div>
		</form>
	</div>
		<script type="text/javascript">
	//layui激活form
	layui.use('form', function(){
		var form = layui.form; 
		form.render();
		});
		function submitHandler() {
			var editurl ='<%=path%>/customer/updateCustomer.do';
					$.operate.save(editurl, $('#orderInfoForm').serialize());

	    }
	</script>
</body>
</html>