<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增修改用户页面</title>
<link href="../statics/layui/css/layui.css" rel="stylesheet">
<link href="../statics/css/user/user.css" rel="stylesheet">
<script src="../statics/layui/layui.js"></script>
<script src="../statics/js/jquery.min.js"></script>
</head>
<body>
	<div class="content">
    <form action="" method="post" id="enditform" class="layui-form enditform">
    	<input type="hidden" name="id" id="id" value="${company.id}">
       <div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">货号</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="itemNumber" name="itemNumber" value="${company.companyChName}">
						<span id="errorChName" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">条形码</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="barCode" name="barCode" value="${company.companyEnName}">
						<span id="errorEnName" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">产品中文名称</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input" 
							id="itemChName" name="itemChName" value="">
						<span id="errorAddress" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">产品英文名称</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="itemEnName" name="itemEnName" value="${company.enAddress}">
						<span id="errorAddress" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">税号</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="hsCode" name="hsCode" value="${company.creditCode}">
						<span id="errorCredit" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">单个净重</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="netWeight" name="netWeight" value="${company.taxpayerType}">
						<span id="errorType" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">品牌</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="brand" name="brand" value="${company.customsCode}">
						<span id="errorCustoms" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">品牌类型</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="brandType" name="brandType" value="${company.commodityNumber}">
						<span id="errorCommodity" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">用途</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="uses" name="uses" value="${company.registeredCapital}">
						<span id="errorRegistered" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">功能</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="features" name="features" value="${company.corporate}">
						<span id="errorCorporate" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">材质</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="material" name="material" value="${company.corporateContact}">
						<span id="errorContact" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">型号</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="model" name="model" value="${company.fixedTelephone}">
						<span id="errorFixed" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">包装</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="packageType" name="packageType" value="${company.mobilePhone}">
						<span id="errorMobile" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">规格尺寸</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly" 
							id="standardSizes" name="standardSizes" value="${company.businessMailbox}">
						<span id="errorEmail" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">规格尺寸</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly" 
							id="other" name="other" value="${company.businessMailbox}">
						<span id="errorEmail" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">企业编码</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly" 
							id="companyCode" name="companyCode" value="${company.businessMailbox}">
						<span id="errorEmail" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
        <div class="layui-form-item">
            <label class="layui-form-label">下载附件</label>
			<div class="form-group text-center submit endit-btn" >
            <a class="layui-btn layui-btn-sm" name="businessLicense" href="${company.businessLicense}">营业执照</a>
            <a class="layui-btn layui-btn-sm" name="foreignTrade" href="${company.foreignTrade}">对外贸易经营者备案登记表</a>
            <a class="layui-btn layui-btn-sm" name="customsRegistration" href="${company.customsRegistration}">海关备案登记</a>
            <a class="layui-btn layui-btn-sm" name="uscc" href="${company.uscc}">企业统一社会代码证书</a>
           </div> 
        </div>

        <div class="form-group text-center submit endit-btn" style="position: absolute;right: 50%;top: 650px;margin-bottom:10px;">
            <button type="button" class="layui-btn layui-btn-sm" id="auditSubmit" onclick="editSubmit()">确定</button>
            <!-- <button class="layui-btn layui-btn-sm">取消</button> -->
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
	
function editSubmit() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST", //方法类型
        dataType: "json",//预期服务器返回的数据类型
        async:false,
        url: "<%=path%>/company/updateCompanyStatus.do?id="+"${company.id}",
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