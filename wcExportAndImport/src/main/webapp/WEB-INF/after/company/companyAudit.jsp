<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核页面</title>
<link href="<%=path%>/statics/layui/css/layui.css" rel="stylesheet">
<link href="<%=path%>/statics/css/user/user.css" rel="stylesheet">
<script src="<%=path%>/statics/layui/layui.js"></script>
<script src="<%=path%>/statics/js/jquery.min.js"></script>
<script src="<%=path%>/statics/js/common/common.js"></script>
</head>
<body>
<form action="" method="post" id="enditform" class="layui-form enditform">
	<div class="content">
    	<input type="hidden" name="id" id="id" value="${company.id}">
       <div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">中文名称</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="ChName" name="companyChName" value="${company.companyChName}">
						<span id="errorChName" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">英文名称</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="EnName" name="companyEnName" value="${company.companyEnName}">
						<span id="errorEnName" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">中文地址</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" class="layui-input" 
							id="enAddress" name="enAddress" value="">
						<span id="errorAddress" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div> -->
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">中文地址</label>
					<div class="layui-input-inline" style="width:70px;">
						<select id="pid" name="province">
  							<option>${company.province}</option>
  						</select>
  					</div>
  					<div class="layui-input-inline" style="width:70px;">
  						<select id="cid" name="city">
  							<option>${company.city}</option>
  						</select>
  					</div>
  					<div class="layui-input-inline" style="width:70px;">	
  						<select id="aid" name="area">
  							<option>${company.area}</option>
  						</select>
					</div>
				</div>
			</div>
		</div>
		
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">英文地址</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="enAddress" name="enAddress" value="${company.enAddress}">
						<span id="errorAddress" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">企业代码</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="creditCode" name="creditCode" value="${company.creditCode}">
						<span id="errorCredit" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">纳税人性质</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="taxpayer" name="taxpayerType" value="${company.taxpayerType}">
						<span id="errorType" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">海关编码</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="customs" name="customsCode" value="${company.customsCode}">
						<span id="errorCustoms" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">商检编码</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="commodity" name="commodityNumber" value="${company.commodityNumber}">
						<span id="errorCommodity" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">注册资本</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="registered" name="registeredCapital" value="${company.registeredCapital}">
						<span id="errorRegistered" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">企业法人</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="corporate" name="corporate" value="${company.corporate}">
						<span id="errorCorporate" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">企业联系人</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="Contact" name="corporateContact" value="${company.corporateContact}">
						<span id="errorContact" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">固定电话</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="fixed" name="fixedTelephone" value="${company.fixedTelephone}">
						<span id="errorFixed" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">移动电话</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly"
							id="mobile" name="mobilePhone" value="${company.mobilePhone}">
						<span id="errorMobile" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">企业邮箱</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input" readonly="readonly" 
							id="Email" name="businessMailbox" value="${company.businessMailbox}">
						<span id="errorEmail" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md12">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">经营范围</label>
					<div class="layui-input-inline" style="width:735px;">
						<textarea id="Scope" class="layui-textarea"  name="businessScope" readonly="readonly">${company.businessScope}</textarea>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
            <label class="layui-form-label">实体类型</label>
            <div class="radio-css">
                <input class="layui-btn-disabled" disabled id="isManufacturer" type="checkbox" name="isManufacturer" value="1" title="生产企业" <c:if test="${company.isManufacturer eq '1'}"> checked="checked"</c:if>/>
                <input class="layui-btn-disabled" disabled id="isImportAndExport" type="checkbox" name="isImportAndExport" value="1" title="进出口贸易企业"  <c:if test="${company.isImportAndExport eq '1'}"> checked="checked"</c:if>/>
                <input class="layui-btn-disabled" disabled id="isFreightForwarding" type="checkbox" name="isFreightForwarding" value="1" title="货代"  <c:if test="${company.isFreightForwarding eq '1'}"> checked="checked"</c:if>/>
                <input class="layui-btn-disabled" disabled id="isInstitution" type="checkbox" name="isInstitution" value="1" title="事业单位"  <c:if test="${company.isInstitution eq '1'}"> checked="checked"</c:if>/>
                <input class="layui-btn-disabled" disabled id="entityType" type="checkbox" name="entityType" value="1" title="其他" <c:if test="${company.entityType eq '1'}"> checked="checked"</c:if>/>
            </div>
        </div>
        </form>
        <form action="<%=path%>/company/downloadFile.do" method="get" id="btnform" class="layui-form enditform" >
        <input name="fileAdress" type="hidden" id ="fileAdress">
        
        </form>
        <div class="layui-form-item">
            <label class="layui-form-label">下载附件</label>
			<div class="form-group text-center submit endit-btn" >
            <button type="button" class="layui-btn layui-btn-sm" id="" name="businessLicense" onclick="downLoad('${company.businessLicense}')">营业执照</button>
            <button type="button" class="layui-btn layui-btn-sm" id="" name="foreignTrade" onclick="downLoad('${company.foreignTrade}')">对外贸易经营者备案登记表</button>
            <button type="button" class="layui-btn layui-btn-sm" id="" name="customsRegistration" onclick="downLoad('${company.customsRegistration}')">海关备案登记</button>
            <button type="button" class="layui-btn layui-btn-sm" id="" nmae="uscc" onclick="downLoad('${company.uscc}')">企业统一社会代码证书</button>
           </div> 
        </div>
        <!-- <div class="form-group text-center submit endit-btn" style="position: absolute;right: 50%;top: 650px;margin-bottom:10px;">
            <button type="button" class="layui-btn layui-btn-sm" id="auditSubmit" onclick="editSubmit()">确定</button>
        </div> -->
    </div>
</body>
<script>
layui.use('form', function(){
	//alert($(User.email))
	var form = layui.form; 
	form.render();
	});
	
function submitHandler() {
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
//下载附件
function downLoad(adderss){
	$("#fileAdress").val(adderss)
	<%-- $('#btnform').attr("action","<%=path%>/company/downloadFile.do"); --%>
	$('#btnform').submit();
}


</script>
</html>