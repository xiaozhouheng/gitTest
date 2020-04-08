<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = "";
    String username = "";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>海关登记信息</title>
<link rel="shortcut icon" href="../statics/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="../statics/css/navigation.css" />
<link rel="stylesheet" href="../statics/css/xoms.layout.css" />
<link rel="stylesheet" href="../statics/layui/css/layui.css" />
<script type="text/javascript" src="../statics/js/jquery.min.js"></script>
<script type="text/javascript" src="../statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
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
.left-margin-100{
	margin-left: 100px;
}
</style>
<body>
<form action="" method="post" id="enditform" class="layui-form" style="margin-top:20px;">
    	<input type="hidden" name="id" id="id" value="${customsInformation.id}">
		<div class="layui-col-md5 left-margin-100">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">海关登记编号</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="customsRegistrationNumber" name="customsRegistrationNumber" value="${customsInformation.customsRegistrationNumber}">
						<span id="errorCustomsNumber" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">企业名称</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="companyName" name="companyName" value="${customsInformation.companyName}">
						<span id="errorCompanyName" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5 left-margin-100">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">关务联系人</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="customsContact" name="customsContact" value="${customsInformation.customsContact}">
						<span id="errorcustomsContact" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">联系电话</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="contactNumber" name="contactNumber" value="${customsInformation.contactNumber}">
						<span id="errorContactNumber" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5 left-margin-100">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">年审日期</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="annualReviewDate" name="annualReviewDate" placeholder=""
							value="<fmt:formatDate value="${customsInformation.annualReviewDate}" pattern="yyyy-MM-dd"/>">
						<span id="errorReviewDate" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">有效期</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="expirationDate" name="expirationDate" 
							value="<fmt:formatDate value="${customsInformation.expirationDate}" pattern="yyyy-MM-dd"/>">
						<span id="errorExpirationDate" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5 left-margin-100">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">法人卡号</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="corporateCardNumber" name="corporateCardNumber" value="${customsInformation.corporateCardNumber}">
						<span id="errorCardNumber" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="name" name="name" value="${customsInformation.name}">
						<span id="errorName" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5 left-margin-100">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">身份证编号</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="idCard" name="idCard" value="${customsInformation.idCard}">
						<span id="errorIdCard" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">法人联系电话</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="corporatePhone" name="corporatePhone" value="${customsInformation.corporatePhone}">
						<span id="errorPhone" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md5 left-margin-100">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-inline" style="width:230px;">
						<input type="text" lay-verify="required" class="layui-input"
							id="note" name="note" value="${customsInformation.note}">
						<span id="errorNote" style="color: red"></span>	
					</div>
				</div>
			</div>
		</div>
			<div class="layui-form-item left-margin-100">
					<label class="layui-form-label">企业类型</label>
           				<div class="radio-css">
               			<input id="enableAgency" type="radio" name="companyType" value="0" title="自理报关"  <c:if test="${customsInformation.companyType eq '0'}"> checked="checked"</c:if> />
               			<input id="agency" type="radio" name="companyType" value="1" title="代理报关" <c:if test="${customsInformation.companyType eq '1'}"> checked="checked"</c:if> />
           				</div>
			</div>
        </form>
<script type="text/javascript">
	//layui激活form
	layui.use('form', function(){
		var form = layui.form; 
		form.render();
		});
	
	layui.use(['element','laydate'],function () {
	    var laydate = layui.laydate;
	    //执行一个laydate实例
	    laydate.render({
	        elem: '#annualReviewDate', //指定元素
	        trigger:'click'
	        ,done: function(value, date, endDate){
	            $('#annualReviewDate').change();  // 一定要加上这句！！！不然没有回调！！！
	             //得到日期生成的值，如：2017-08-18
	            //getData(new Date(value));
	        }
	    });
	    laydate.render({
	        elem: '#expirationDate', //指定元素
	        trigger:'click'
	    });
	})
//时间格式
function createTime(v){
	if(v==null){
		 return "/";
	}
	var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var str = y+"/"+m+"/"+d;
    return str;
}    
	    
		function submitHandler() {
			var id = $("#id").val();
			var customsRegistrationNumber=$("#customsRegistrationNumber").val();//海关登记编号
		    var companyName=$("#companyName").val();//企业名称
		    var customsContact=$("#customsContact").val();//关务联系人
		    var contactNumber=$("#contactNumber").val();//联系电话
		    var annualReviewDate=createTime($("#annualReviewDate").val());//年审日期
		    var expirationDate=createTime($("#expirationDate").val());//有效期
		    var corporateCardNumber=$("#corporateCardNumber").val();//卡人法号
		    var name=$("#name").val();//姓名
		    var idCard=$("#idCard").val();//身份证编号
		    var corporatePhone=$("#corporatePhone").val();//法人联系电话
		    var note=$("#note").val();//备注
		    var companyType = Number($('input[name="companyType"]:checked').val());//状态
		    var formdata = new FormData()
		    formdata.append('id',id)
		    formdata.append('customsRegistrationNumber',customsRegistrationNumber)
			formdata.append('companyName',companyName)
			formdata.append('customsContact',customsContact)
			formdata.append('contactNumber',contactNumber)
			formdata.append('annualReviewDate',annualReviewDate)
			formdata.append('expirationDate',expirationDate)
			formdata.append('corporateCardNumber',corporateCardNumber)
			formdata.append('name',name)
			formdata.append('idCard',idCard)
			formdata.append('corporatePhone',corporatePhone)
			formdata.append('note',note)
			formdata.append('companyType',companyType)
		$.ajax({
			url:'<%=path%>/customs/updateCustoms.do',
			type:'POST',
			async:true,
			dataType:'json',
			processData:false,
            contentType:false,
			data:formdata, 
			success:function(data){
				if (data.status == 200){
					layer.msg(data.msg,{
						icon:1,
						time:3000,
						},function(){
		     				window.parent.location.reload();
		      				});
                   }
                   else{
                	   layer.msg(data.msg,{
                		   icon:2,
                		   time:3000,
                		   },function(){
			     				window.parent.location.reload();
		      				});
                	   //layer.close(index);
                   }
			},
			error:function(){
				 alert("数据错误")
			}

		})
			<%-- var editurl ='<%=path%>/customs/updateCustoms.do';
					$.operate.save(editurl, $('#orderInfoForm').serialize()); --%>

	    }
	</script>
</body>
</html>