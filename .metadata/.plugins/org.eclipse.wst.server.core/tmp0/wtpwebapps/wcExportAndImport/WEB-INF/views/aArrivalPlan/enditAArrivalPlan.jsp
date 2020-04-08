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
<title>查询</title>
<link rel="stylesheet" href="../statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="../statics/layui/css/layui.css" />
<link rel="stylesheet" href="../statics/css/track.css" />
<link rel="stylesheet" href="../statics/css/navigation.css" />
<link rel="stylesheet" href="../statics/css/to_create.css" />
<link rel="stylesheet" href="../statics/css/xoms.layout.css" />
<script type="text/javascript" src="../statics/js/jquery.min.js"></script>
<script type="text/javascript" src="../statics/js/StringBuilder.js"></script>
<script type="text/javascript" src="../statics/js/tools.js"></script>
<script type="text/javascript" src="../statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<!-- <script type="text/javascript" src="../statics/layui/layui.js"></script> -->
<script type="text/javascript" src="../statics/layui/layui.js"></script>
<style>
.order-no {
	width: 300px;
}

.ztck-biaodan {
	margin-top: 20px;
}

.order-select {
	width: 80px;
}

.ztck-textarea {
	width: 225px;
}

.xoms-secnavbar a {
	text-decoration: none;
}

.xoms-secnavbar {
	margin-top: -20px;
}

.saveInput {
	padding-top: 10px;
	padding-left: 0px;
	padding-right: 0px;
}

.bighuan {
	border: 1px dashed #F0F0F0;
	border-radius: 5px 5px 5px 5px;
	width: 1140px;
	margin-left: 30px;
}

.fieldName {
	text-align: right;
	padding-top: 7px;
	padding-left: 0px;
}

.valueName {
	padding-left: 0px;
}
/* 搜索栏 */
.ui-autocomplete {
        max-height: 50%;/* 高度值 */
        overflow-y: auto; /* 超过高度出现滚动条 */
        overflow-x: hidden;/*横向超出隐藏，如果要出现横向滚动，设置为auto即可 */
    }
    /*  IE 6不支持最大高度 
     *  我们使用高度代替，但这迫使菜单总是这么高。 
     */
     /**我也不知道写这个干啥，反正我们也不用IE6*/
    * html .ui-autocomplete {
        height: 300px;
    }
       .file {  
            position: relative;  
            display: inline-block;  
            background: #D0EEFF;  
            border: 1px solid #99D3F5;  
            border-radius: 4px;  
            padding: 4px 12px;  
            overflow: hidden;  
            color: #1E88C7;  
            text-decoration: none;  
            text-indent: 0;  
            line-height: 20px;  
        }  
        .file input {  
            position: absolute;  
            font-size: 100px;  
            right: 0;  
            top: 0;  
            opacity: 0;  
        }  
        .file:hover {  
            background: #AADFFD;  
            border-color: #78C3F3;  
            color: #004974;  
            text-decoration: none;  
        } 
</style>

</head>
<body>
	<!-- 导航栏 -->
<%-- <%@ include file="../basebar/settingsbar.txt" %> --%>
<!-- 导航栏开始 -->
<nav class="navbar navbar-default container-fluid">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">安布雷</a>
			</div>

			<div class="collapse navbar-collapse "
				id="bs-example-navbar-collapse-1">

				<ul class="nav navbar-nav ">
					<li class=""><a href="<%=path%>/page/pageJump.do?path=views/index">个人中心</a></li>
					<li class="dropdown active"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">进口货物<span class="caret"></span></a>
						<ul class="dropdown-menu active">
							<!--<li><a href="<%=path%>/my_orders/to_create.html">到货计划表</a></li>-->
							<li><a href="<%=path%>/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlan">到货计划表</a></li>
							<%-- <li><a href="<%=path%>/orderManage/draft.html">审核</a></li>
							<li><a href="<%=path%>/my_order/order_problem.html">订单状态二</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态三</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态四</a></li> --%>
						</ul></li>
					<li class="dropdown "><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">出口货物<span
							class="caret"></span></a>
						<ul class="dropdown-menu active">
							<!--<li><a href="<%=path%>/my_orders/to_create.html">到货计划表</a></li>-->
							<li><a href="<%=path%>/page/pageJump.do?path=views/sShippingPlan/SShippingPlan">出货计划表</a></li>
							<%-- <li><a href="<%=path%>/orderManage/draft.html">订单状态一</a></li>
							<li><a href="<%=path%>/my_order/order_problem.html">订单状态二</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态三</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态四</a></li> --%>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">企业数据库<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=path%>/page/pageJump.do?path=views/product/productVO">产品备案</a></li>
							<%-- <li><a href="<%=path%>/freeCount/findqt.html">单证管理</a></li> --%>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">企业信息<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<!--<li><a href="./company/companyUI">企业基本信息</a></li> -->
							<li><a href="<%=path%>/company/editCompany">企业基本信息</a></li>
							<li><a href="<%=path%>/customs/customsUI">海关登记信息</a></li>
							<li><a href="<%=path%>/customer/customerUI">往来客户信息管理</a></li>
						</ul></li>

				</ul>
			    <ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">您好！${user.userName}</a>
							<li><a href="http://localhost:8080/wcExportAndImport/page/login">退出</a></li>
					</li>
				</ul>
			</div>
		</div>
	</nav>
<!-- 导航栏结束 -->
	<!--
时间：2018-02-06
描述：网站主体开始
-->
	<!-- 双击弹出修改页面 -->	
	 <div id="orderMX" style="display: none; background-color: #F0F0F0;">
		<div class="col-lg-12 titles">
			<span style="font-size: 20px">订单信息:</span>
		</div>
		<form id="typeMade" method="post" class="form-control">
		<input type="hidden" id="param3" name = "param3" value ="${aArrivalPlan.param3 }"class="form-control">
		<input type="hidden" id="status" name = "status" value ="${aArrivalPlan.status }"class="form-control">
		<div class="col-lg-12 bighuan">
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>进出口岸:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="importPort" name = "importPort" value ="${aArrivalPlan.importPort }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>预计到港时间:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="estimatedArrivalTime" name = "estimatedArrivalTime" value="<fmt:formatDate value="${aArrivalPlan.estimatedArrivalTime}" pattern="yyyy-MM-dd"/>"
							class="form-control">
							<span id="promptArrivalTime"style="color: red; display: none;">不能为空</span>
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>运输方式:</h9></label>
					<div class="col-lg-7 valueName">
						<select class="form-control category" name="modeOfTransport"
								id="modeOfTransport">
								<option value="" >请选择</option>
								<option value="0" <c:if test="${aArrivalPlan.modeOfTransport=='0'}">selected</c:if>>公路</option>
								<option value="1" <c:if test="${aArrivalPlan.modeOfTransport=='1'}">selected</c:if>>铁路</option>
							</select>
					</div>
				</div>
				<%-- <div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>运输方式:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="modeOfTransport" name = "modeOfTransport" value ="${aArrivalPlan.modeOfTransport }"
							class="form-control">
					</div>
				</div> --%>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>主运单号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="mainWaybillNumber" name = "mainWaybillNumber" value ="${aArrivalPlan.mainWaybillNumber }"
							class="form-control">
							<span id="promptMainNumber" style="color: red; display: none;">不能为空</span>
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>分运单号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="fenWaybillNumber" name = "fenWaybillNumber" value ="${aArrivalPlan.fenWaybillNumber }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>境外发货人:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="overseasShipper" name = "overseasShipper" value ="${aArrivalPlan.overseasShipper }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>境外收货人:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="overseasConsignee" name = "overseasConsignee" value ="${aArrivalPlan.overseasConsignee }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>使用单位:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="unit" name = "unit" value ="${aArrivalPlan.unit }"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>提单件数:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="number" name = "number" value ="${aArrivalPlan.number }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>提单重量:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="weight" name = "weight" value ="${aArrivalPlan.weight }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>包装类型:</h9></label>
					<div class="col-lg-7 valueName">
						<%-- <input type="text" id="packingType" name = "packingType" value ="${aArrivalPlan.packingType }"
							class="form-control"> --%>
					<select class="form-control category" name="packingType"
						id="packingType">
						<option value="" >请选择</option>
						<option value="0" <c:if test="${aArrivalPlan.packingType=='0'}">selected</c:if>>大包</option>
						<option value="1" <c:if test="${aArrivalPlan.packingType=='1'}">selected</c:if>>小包</option>
					</select> 
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>包装尺寸:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="packageDimensions" name = "packageDimensions" value ="${aArrivalPlan.packageDimensions }"
							class="form-control">
					</div>
				</div>
				<!-- <div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>有无类型:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="ippc"
							class="form-control">
					</div>
				</div> -->
			</div>
			<div class="col-lg-12 hang">
				<%-- <div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>包装尺寸:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="packageDimensions" name = "packageDimensions" value ="${aArrivalPlan.packageDimensions }"
							class="form-control">
					</div>
				</div> --%>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>监管方式:</h9></label>
					<div class="col-lg-7 valueName">
						<%-- <input type="text" id="supervisionType" name = "supervisionType" value ="${aArrivalPlan.supervisionType }"
							class="form-control"> --%>
							<select class="form-control category" name="supervisionType"
								id="supervisionType">
								<option value="">请选择</option>
								<option value="0" <c:if test="${aArrivalPlan.supervisionType=='0'}">selected</c:if>>方式一</option>
								<option value="1" <c:if test="${aArrivalPlan.supervisionType=='1'}">selected</c:if>>方式二</option>
							</select>
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>成交方式:</h9></label>
					<div class="col-lg-7 valueName">
						<%-- <input type="text" id="transactionType" name = "transactionType" value ="${aArrivalPlan.transactionType }"
							class="form-control"> --%>
						<select class="form-control category" name="transactionType"
							id="transactionType">
							<option value="" >请选择</option>
							<option value="1" <c:if test="${aArrivalPlan.transactionType=='1'}">selected</c:if>>CIF</option>
							<option value="2" <c:if test="${aArrivalPlan.transactionType=='2'}">selected</c:if>>C&F</option>
							<option value="3" <c:if test="${aArrivalPlan.transactionType=='3'}">selected</c:if>>FOB</option>
							<option value="4" <c:if test="${aArrivalPlan.transactionType=='4'}">selected</c:if>>C&I</option>
							<option value="5" <c:if test="${aArrivalPlan.transactionType=='5'}">selected</c:if>>市场价</option>
							<option value="6" <c:if test="${aArrivalPlan.transactionType=='6'}">selected</c:if>>垫仓</option>
							<option value="7" <c:if test="${aArrivalPlan.transactionType=='7'}">selected</c:if>>EXW</option>
						</select>
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>运费:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="freight" name = "freight" value ="${aArrivalPlan.freight }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>保费:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="premium" name = "premium" value ="${aArrivalPlan.premium }"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>进出口标志:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="ieFlag" name = "ieFlag" value ="${aArrivalPlan.ieFlag }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>报关单号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="customsOrderNumber" name = "customsOrderNumber" value ="${aArrivalPlan.customsOrderNumber }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>统一编号:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="uniformNumbers" name = "uniformNumbers" value ="${aArrivalPlan.uniformNumbers }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>企业海关编码:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="customsCode" name = "customsCode" value ="${aArrivalPlan.customsCode }" 
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>业务编码:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="param1" name = "param1" value ="${aArrivalPlan.param1 }"
							class="form-control">
					</div>
				</div>
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>销售员代码:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="param2" name = "param2" value ="${aArrivalPlan.param2 }"
							class="form-control">
					</div>
				</div>
				<%-- <div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>派单操作员id:</h9></label>
					<div class="col-lg-7 valueName">
						<input type="text" id="param3" name = "param3" value ="${aArrivalPlan.param3 }"
							class="form-control">
					</div>
				</div> --%>
			</div>
			<div class="col-lg-12 hang">
				<div class="col-lg-3 saveInput">
					<label class="col-lg-5 fieldName"><h9>有无IPPC标识:</h9></label>
					<div class="col-lg-7 valueName">
						<div class="radio" style="margin-top: 6px;">
							<label> <input type="radio" name="ippc"
								id="clcttype" value="1" <c:if test="${aArrivalPlan.ippc eq '1'}"> checked="checked"</c:if>>有
							</label> <label> <input type="radio" name="ippc"
								id="clcttype" value="0" <c:if test="${aArrivalPlan.ippc eq '0'}"> checked="checked"</c:if>>无
							</label>
						</div>
					</div>
				</div>
			</div>
			<%-- <div class="col-lg-12 hang">
				<div class="col-lg-12 saveInput">
				<label class="col-lg-1 fieldName"><h9>上传附件:</h9></label>
						<div class="form-group text-center submit endit-btn" >
				            <a href="javascript:;" class="file" position='relative'>发票 <input type="file" name="file1" id="invoice" value="${aArrivalPlan.invoice }"></a>
							<a href="javascript:;" class="file" position='relative'>装箱单  <input type="file" name="file2" id="packingList" value="${aArrivalPlan.packingList }"></a>
							<a href="javascript:;" class="file" position='relative'>合同 <input type="file" name="file3" id="contract" value="${aArrivalPlan.contract }"></a>
							<a href="javascript:;" class="file" position='relative'>报关委托书<input type="file" name="file4" id="cpoa" value="${aArrivalPlan.cpoa }"></a>
							<a href="javascript:;" class="file" position='relative'>提单 <input type="file" name="file5" id="billOfLading" value="${aArrivalPlan.billOfLading }"></a>
							<a href="javascript:;" class="file" position='relative'>到货通知书  <input type="file" name="file6" id="arrivalNotice" value="${aArrivalPlan.arrivalNotice }"></a>
							<a href="javascript:;" class="file" position='relative'>装箱明细 <input type="file" name="file7" id="packingDetails" value="${aArrivalPlan.packingDetails }"></a>
							<a href="javascript:;" class="file" position='relative'>原产地证书<input type="file" name="file8" id="certificateOfOrigin" value="${aArrivalPlan.certificateOfOrigin }"></a>
							<a href="javascript:;" class="file" position='relative'>预录单 <input type="file" name="file12" id="preRecorded" value="${aArrivalPlan.preRecorded }"></a>
							<a href="javascript:;" class="file" position='relative'>报关单  <input type="file" name="file13" id="customsDeclaration" value="${aArrivalPlan.customsDeclaration }"></a>
							<a href="javascript:;" class="file" position='relative'>放行通知书 <input type="file" name="file14" id="releaseNotice" value="${aArrivalPlan.releaseNotice }"></a>
							<a href="javascript:;" class="file" position='relative'>其他1<input type="file" name="file9" id="other1" value="${aArrivalPlan.other1 }"></a>
							<a href="javascript:;" class="file" position='relative'>其他2 <input type="file" name="file10" id="other2" value="${aArrivalPlan.other2 }"></a>
							<a href="javascript:;" class="file" position='relative'>其他3  <input type="file" name="file11" id="other3" value="${aArrivalPlan.other3 }"></a>
							<span class="errorRegion" id="promptFile1" style="color: red;display: none;"></span>
							<span class="errorRegion" id="promptFile2" style="color: red;display: none;"></span>
							<span class="errorRegion" id="promptFile3" style="color: red;display: none;"></span>
							<span class="errorRegion" id="promptFile4" style="color: red;display: none;"></span>
							<span class="errorRegion" id="promptFile5" style="color: red;display: none;"></span>  
						</div>
			</div>
		  </div> --%>
		</div>
		</form>
		<div class="col-lg-12 titles">
			<span style="font-size: 20px">到货计划表明细:</span>
		</div>
		<div class="col-lg-12 bighuan">
			<table id="orderSku" class="layui-hide"lay-filter="orderSku"></table>
		</div>
	</div>
<script type="text/javascript">
//时间戳
function getUnixTime(dateStr){
    var newstr = dateStr.replace(/-/g,'/'); 
    var date =  new Date(newstr); 
    var time_str = date.getTime().toString();
    return time_str.substr(0, 10);
    }
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
    var str = y+"-"+m+"-"+d;
    return str;
}    
    //当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量
    var table_data=new Array();
    layui.use(['form', 'layedit', 'laydate', 'table', 'element','jquery'], function(){
    	 var table = layui.table;
         var form=layui.form;
         var $ = layui.jquery;
         var laydate = layui.laydate;
         //获取表头所有信息 放在函数外面方便时间修改函数使用
         //var param3 = $("#param3").val();//派单操作员id
         var status = $("#status").val();//状态 
         var ids = ${aArrivalPlan.id};
         var importPort=$("#importPort").val();
    	 var estimatedArrivalTime= createTime($("#estimatedArrivalTime").val());
    	 var mainWaybillNumber=$("#mainWaybillNumber").val();//主运单号
    	 var fenWaybillNumber=$("#fenWaybillNumber").val();//分运单号
    	 var overseasShipper=$("#overseasShipper").val();//境外发货人
    	 var overseasConsignee=$("#overseasConsignee").val();//境外收货人
    	 var unitBT=$("#unit").val();//消费使用单位
    	 var numberBT= $('#number').val();//提单件数
    	 var packageDimensions=$("#packageDimensions").val();//包装尺寸
    	 var weight=$("#weight").val();//提单重量
    	 var freight=$("#freight").val();//运费
    	 var premium=$("#premium").val();//保费
    	 var ieFlag=$("#ieFlag").val();//进出口标志
    	 var customsOrderNumber=$("#customsOrderNumber").val();//报关单号
    	 var uniformNumbers=$("#uniformNumbers").val();//统一编号
    	 var customsCode=$("#customsCode").val();//企业海关编码
    	 var packingType = $('#packingType').val();//包装种类
    	 var modeOfTransport= $('#modeOfTransport').val();//运输方式
    	 var transactionType= $('#transactionType').val();//成交方式
    	 var supervisionType= $('#supervisionType').val();//监管方式
    	 var param1 = $("#param1").val();//业务编码
    	 var param2 = $("#param2").val();//销售员代码
    	 var ippc = $('input[name="ippc"]:checked').val();//有无标识
    	 if( ippc == undefined){
    		 ippc = "";
    	 }
    	 /* var file1 = $('#invoice').get(0).files[0];
    	 var file2 = $('#packingList').get(0).files[0];
    	 var file3 = $('#contract').get(0).files[0];
    	 var file4 = $('#cpoa').get(0).files[0];
    	 var file5 = $('#billOfLading').get(0).files[0];
    	 var file6 = $('#arrivalNotice').get(0).files[0];
    	 var file7 = $('#packingDetails').get(0).files[0];
    	 var file8 = $('#certificateOfOrigin').get(0).files[0];
    	 var file9 = $('#other1').get(0).files[0];
    	 var file10 = $('#other2').get(0).files[0];
    	 var file11 = $('#other3').get(0).files[0];
    	 var file12 = $('#preRecorded').get(0).files[0];
    	 var file13 = $('#customsDeclaration').get(0).files[0];
    	 var file14 = $('#releaseNotice').get(0).files[0]; */
    	 
    	 var btDataQJa;//定义表体全局
		    	//子表赋值 
		    	table.render({
					elem : '#orderSku',
					//data : '${aArrivalPlan.aArrivalPlanDetailsVOs }',//直接赋值json数据，只能拿到存json串对象的地址。
					//data:[{"chItemName": "苹果","countryOfOrigin": "1","currency": "1","hscode": "1","itemNumber": 123,"model": "1","netWeight": "1","note": "1","number": 1,"price": "1","serialNumber": 1,"totalPrice": "1","unit": "1"}],
					url:'<%=path%>/AArrivalPlanDetails/getAllAArrivalPlanDetails.do?aId='+'${aArrivalPlan.id }',
		                page: false,
		                method:'get',
		                id: 'queryOrdersku',
		                 response: {
		                    statusName: 'success' //数据状态的字段名称，默认：code
		                    , statusCode: true //成功的状态码，默认：0
		                    , msgName: 'message' //状态信息的字段名称，默认：msg
		                    , countName: 'count' //数据总数的字段名称，默认：count
		                    , dataName: 'value' //数据列表的字段名称，默认：data  
		                },
		                cols: [[
		                    {field:'serialNumber',edit: 'text',  title: '序号',align :'center'},
		                    {field:'itemNumber',edit: 'text',  title: '货号',align :'center'},
		                    {field:'chItemName',edit: 'text',  title: '中文品名',align :'center'},
		                    {field:'hscode',edit: 'text',  title: '税号',align :'center'},
		                    {field:'model',edit: 'text',  title: '规格型号',align :'center'},
		                    {field:'number',edit: 'text',  title: '成交数量',align :'center'},
		                    {field:'unit',edit: 'text',  title: '成交单位',align :'center'},
		                    {field:'price',edit: 'text',  title: '价格',align :'center'},
		                    {field:'totalPrice',edit: 'text',  title: '总价',align :'center'},
		                    {field:'currency',edit: 'text',  title: '币制',align :'center'},
		                    {field:'netWeight',edit: 'text',  title: '净重',align :'center'},
		                    {field:'countryOfOrigin',edit: 'text',  title: '原产国',align :'center'},
		                    {field:'note',edit: 'text',  title: '备注',align :'center'}
		                ]]
		                ,done: function(res, page, count){
		                	for(var i =0; i< res.value.length;i++){
		                		var aId = ${aArrivalPlan.id};
		                		var id = res.value[i].id;
		                		var serialNumber = res.value[i].serialNumber;
		                		var itemNumber = res.value[i].itemNumber;
		                		var chItemName = res.value[i].chItemName;
		                		var hscode = res.value[i].hscode;
		                		var model = res.value[i].model;
		                		var number = res.value[i].number;
		                		var unit = res.value[i].unit;
		                		var price = res.value[i].price;
		                		var totalPrice = res.value[i].totalPrice;
		                		var currency = res.value[i].currency;
		                		var netWeight = res.value[i].netWeight
		                		var countryOfOrigin = res.value[i].countryOfOrigin;
		                		var note = res.value[i].note;
		                		var getData = [];
		                		var Data ={
		                				id:id,
		                				aId:aId,
		                				serialNumber:serialNumber,
		                				itemNumber:itemNumber,
		                				chItemName:chItemName,
		                				hscode:hscode,
		                				model:model,
		                				number:number,
		                				unit:unit,
		                				price:price,
		                				totalPrice:totalPrice,
		                				currency:currency,
		                				netWeight:netWeight,
		                				countryOfOrigin:countryOfOrigin,
		                				note:note,
		                		}
		                		btDataQJa = Data;//表体赋值给全局 方便点击时间修改函数使用
		                		getData.push(Data)
		                	}
		
		    	
		    $(function(){
		    	//下拉框选择修改
		    	$("select").change(function(){
		    		var modeOfTransportName = $("#modeOfTransport").attr("name");
		    	    var modeOfTransportValue = $("#modeOfTransport").val();
		    	    var packingTypeName = $("#packingType").attr("name");
		    	    var packingTypeValue = $("#packingType").val();
		    	    var transactionTypeName = $("#transactionType").attr("name");
		    	    var transactionTypeValue = $("#transactionType").val();
		    	    var supervisionTypeName = $("#supervisionType").attr("name");
		    	    var supervisionTypeValue = $("#supervisionType").val();
		    	    var jsonGetSeleData ={
		   			    	aArrivalPlanDetails:getData,
		   			    	//BTXX:btxx,
		   			    	    id:id,
		   			    	    param1:param1,
		   			    	    param2:param2,
		   			    	    status:status,
		              		    importPort:importPort,
		              			estimatedArrivalTime:estimatedArrivalTime,
		              			mainWaybillNumber:mainWaybillNumber,
		              			fenWaybillNumber:fenWaybillNumber,
		              			overseasShipper:overseasShipper,
		              			overseasConsignee:overseasConsignee,
		              			unit:unitBT,
		              			number:numberBT,
		              			weight:weight,
		              			packageDimensions:packageDimensions,
		              			freight:freight,
		              			premium:premium,
		              			ieFlag:ieFlag,
		              			customsOrderNumber:customsOrderNumber,
		              			uniformNumbers:uniformNumbers,
		              			customsCode:customsCode,
		              			transactionType:transactionType,
		              			modeOfTransport:modeOfTransport,
		              			packingType:packingType,
		              			supervisionType:supervisionType,
		              			ippc:ippc,
		   			       }
				    	  var id = ${aArrivalPlan.id}
				          id = id;
				          modeOfTransportKey = modeOfTransportName;
				          modeOfTransportValue = modeOfTransportValue;
				          packingTypeKey = packingTypeName;
				          packingTypeValue = packingTypeValue;
				          transactionTypeKey = transactionTypeName;
				          transactionTypeValue = transactionTypeValue;
				          supervisionTypeKey = supervisionTypeName;
				          supervisionTypeValue = supervisionTypeValue;
				          jsonGetSeleData[packingTypeKey] = packingTypeValue;
				          jsonGetSeleData[transactionTypeKey] = transactionTypeValue;
				          jsonGetSeleData[supervisionTypeKey] = supervisionTypeValue;
				          jsonGetSeleData[modeOfTransportKey] = modeOfTransportValue;
				          jsonGetSeleData['id'] = id;
				          var strSelect = JSON.stringify(jsonGetSeleData);
				          console.log(strSelect)
				          var formdata = new FormData();
	            		  formdata.append('aArrivalPlan',strSelect)
	            		//验证时间非空
	      	            if(estimatedArrivalTimeValue == 'NaN-NaN-NaN' || estimatedArrivalTimeValue== ''){
	      	    			layer.msg('预计到港时间不能为空',{
	      	    				icon:2,
	      	    				time:3000,
	      	    				},function(){
	      	    					estimatedArrivalTimeId = "estimatedArrivalTime"
	      	    					//window.parent.location.reload();
	      	    					});
	      	    			return false;
	      	    			}
		    	    $.ajax({
		         	    url:"<%=path%>/AArrivalPlan/updateAArrivalPlan.do",
		         	    type:'POST',
			   				async:true,
			   				dataType:'json',
			   				processData:false,
			   	            contentType:false,
			   				data:formdata,
		         	   success:function( data ){
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
			                	   layer.close(index);
			                   }
						},
						error:function(){
							 alert("修改表头数据有误")
						}
		            })
		    	});
		    	//下拉框选择修改结束
		    	//点击单选按钮修改开始
		    	 $("input[name=ippc]").click(function(){
					    //var ippc = $(this).val();
	        	   //修改后的key和value
	            	 var ippcName = $(this).attr("name");
	            	 var ippcValue = $(this).val();
	        	     var jsonGetRadioData ={
	   			    	aArrivalPlanDetails:getData,
	   			    	    id:id,
	   			    	 	param1:param1,
	   			    	    param2:param2,
	   			    	    status:status,
	              		    importPort:importPort,
	              			estimatedArrivalTime:estimatedArrivalTime,
	              			mainWaybillNumber:mainWaybillNumber,
	              			fenWaybillNumber:fenWaybillNumber,
	              			overseasShipper:overseasShipper,
	              			overseasConsignee:overseasConsignee,
	              			unit:unitBT,
	              			number:numberBT,
	              			weight:weight,
	              			packageDimensions:packageDimensions,
	              			freight:freight,
	              			premium:premium,
	              			ieFlag:ieFlag,
	              			customsOrderNumber:customsOrderNumber,
	              			uniformNumbers:uniformNumbers,
	              			customsCode:customsCode,
	              			transactionType:transactionType,
	              			modeOfTransport:modeOfTransport,
	              			packingType:packingType,
	              			supervisionType:supervisionType,
	              			ippc:ippc,
	   			       }
	        	    var id = ${aArrivalPlan.id}
	        	     id = id;
	        	     ippcNameKey = ippcName;
	            	 ippcValue = ippcValue;
	        	     jsonGetRadioData[ippcNameKey] = ippcValue;
			         jsonGetRadioData['id'] = id;
			    var strRadio = JSON.stringify(jsonGetRadioData);
			       console.log(strRadio)
	            var formdata = new FormData();
	            formdata.append('aArrivalPlan',strRadio)
	          //验证时间非空
	            if(estimatedArrivalTimeValue == 'NaN-NaN-NaN' || estimatedArrivalTimeValue== ''){
	    			layer.msg('预计到港时间不能为空',{
	    				icon:2,
	    				time:3000,
	    				},function(){
	    					estimatedArrivalTimeId = "estimatedArrivalTime"
	    					window.parent.location.reload();
	    					});
	    			return false;
	    			}
	            $.ajax({
	         	    url:"<%=path%>/AArrivalPlan/updateAArrivalPlan.do",
	         	    type:'POST',
		   				async:true,
		   				dataType:'json',
		   				processData:false,
		   	            contentType:false,
		   				data:formdata,
	         	   success:function( data ){
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
		                	   layer.close(index);
		                   }
					},
					error:function(){
						 alert("修改表头数据有误")
					}
	            })
	           });
		        //点击单选按钮修改结束
		        
		        
		        
		        
		//时间input框的值调用初始化
		var arrinputId = ["estimatedArrivalTime"]//时间输入框的id放到数组里面。便于下方判断（过id判断是否是时间input输入框，是就return 不走接口，不是就走接口）
        var estimatedArrivalTimeValueFirst = estimatedArrivalTime //获取未修改之前的时间input框的value，用于下方时间值判断
        var estimatedArrivalTimeValueSecond = estimatedArrivalTime//用于获取修改之后的时间input框的value，用于下方时间值判断
        var estimatedArrivalTimeId = null //用于获取时间input框的id，当时间发生变化之后才会获取
        //时间input框的值调用初始化结束
    	 
    	 
    	//点击时间修改及时间处理
    	var estimatedArrivalTimeValue
    	laydate.render({
    		elem: '#estimatedArrivalTime' //指定元素 
    		,done: function(value, date){
    			$('#estimatedArrivalTime').change();  // 一定要加上这句！！！不然没有回调！！！
	            //alert(value); //得到日期生成的值，如：2017-08-18
	            var estimatedArrivalTimeName = $("#estimatedArrivalTime").attr("name")
	            estimatedArrivalTimeValue = value
	            //时间变动处理
	            if(estimatedArrivalTimeValueFirst == estimatedArrivalTimeValue){//如果时间没有变化，就直接跳出，走input框的接口调用
	            	return;
	            }else if(estimatedArrivalTimeValueFirst != estimatedArrivalTimeValue && estimatedArrivalTimeValue != null){//第二次赋值，判断第一次赋值和第二次新值是否相等，如果不等，则给second赋值，用于下方判断
	            	//alert("时间变化测试")
	            	estimatedArrivalTimeValueFirst = estimatedArrivalTimeValue //用于下次判断
	            	estimatedArrivalTimeValueSecond = estimatedArrivalTimeValue//用于下次判断
	             	estimatedArrivalTimeId = "estimatedArrivalTime"//当时间变化之后，才会获取id,用于input框位置的验证，屏蔽input执行
	             	estimatedArrivalTime = estimatedArrivalTimeValue //用于时间变动传值
	            }else if(estimatedArrivalTimeValue == null){
	            	//alert("时间为空测试")
	            	estimatedArrivalTimeValueSecond = estimatedArrivalTimeValue
	            	estimatedArrivalTimeId = null
	            	estimatedArrivalTime = estimatedArrivalTimeValue
	            	return false;
	            }else{
  		             	alert("时间处理出现错误")
  		        }
	            //验证时间非空
	            if(estimatedArrivalTimeValue == 'NaN-NaN-NaN' || estimatedArrivalTimeValue== ''){
	    			layer.msg('预计到港时间不能为空',{
		    					icon:2,
		    					time:3000,
		    				},function(){
		    					estimatedArrivalTimeId = "estimatedArrivalTime"
		    					window.parent.location.reload();
					      	});
	    			return false;
	    		     }
            
    		    var date = new Date(estimatedArrivalTimeValue)
	            var getBtData = [];
	            getBtData.push(btDataQJa);
	            var jsonGetTimeData = {
	            	aArrivalPlanDetails:getBtData,
	            	id:ids,
	            	param1:param1,
			    	param2:param2,
			    	status:status,
          		    importPort:importPort,
          			estimatedArrivalTime:estimatedArrivalTime,
          			mainWaybillNumber:mainWaybillNumber,
          			fenWaybillNumber:fenWaybillNumber,
          			overseasShipper:overseasShipper,
          			overseasConsignee:overseasConsignee,
          			unit:unitBT,
          			number:numberBT,
          			weight:weight,
          			packageDimensions:packageDimensions,
          			freight:freight,
          			premium:premium,
          			ieFlag:ieFlag,
          			customsOrderNumber:customsOrderNumber,
          			uniformNumbers:uniformNumbers,
          			customsCode:customsCode,
          			transactionType:transactionType,
          			modeOfTransport:modeOfTransport,
          			packingType:packingType,
          			supervisionType:supervisionType,
          			ippc:ippc,
	            }
    		    estimatedArrivalTimeValue = createTime(date.toString());
    		    estimatedArrivalTimeNameKey = estimatedArrivalTimeName;
    		    jsonGetTimeData[estimatedArrivalTimeNameKey] = estimatedArrivalTimeValue;
    		    var strTime = JSON.stringify(jsonGetTimeData);
			    console.log(strTime)
			    var formdata = new FormData();
            	formdata.append('aArrivalPlan',strTime)
		    	$.ajax({
		    		url:"<%=path%>/AArrivalPlan/updateAArrivalPlan.do",
		    		type:'POST',
		    		async:true,
		    		dataType:'json',
		    		processData:false,
		    		contentType:false,
		    		data:formdata,
		    		success:function( data ){
		    			if (data.status == 200){
		    				layer.msg(data.msg,{
		    					icon:1,
		    					time:3000,
		    				},function(){
		    					estimatedArrivalTimeId = null
		    					window.parent.location.reload();
					      	});
		    				}else{
		    					layer.msg(data.msg,{
		    						icon:2,
		    						time:3000,
		    						},function(){
		    							estimatedArrivalTimeId = null
		    							window.parent.location.reload();
					      			});
		    					layer.close(index);
		    				}
						},
						error:function(){
							 alert("修改表头时间数据有误")
						}
		            })
    		}
    	})
		        
		    	//点击表头input框修改开始
	            $("input").blur(function(){
	            	setTimeout(inputUse,200);        
	           });
		        function inputUse(){
		        	//修改后的key和value
		        	 var importPortName =  $("#importPort").attr("name");
		             var importPortValue = $("#importPort").val();
		             var mainWaybillNumberName = $("#mainWaybillNumber").attr("name");
		             var mainWaybillNumberValue = $("#mainWaybillNumber").val();
		             /* //验证主运单号不能为空
		             if(mainWaybillNumberValue==null || mainWaybillNumberValue=="" ){
		        			//layer.confirm("请填写主运单号")
		        			$("#promptMainNumber").css("display","block");
		        			//焦点离开验证提示消失
		        			$('#mainWaybillNumber').on('blur focus',function(){
		        				if($(this).is(":focus")){
		        					$("#promptMainNumber").css("display","none");
		        				}
		        			})
		        		    	return false;
		        		     }else{
		        		    	 $("#promptMainNumber").css("display","none");
		        		     } */
		        		   
		             var fenWaybillNumberName = $("#fenWaybillNumber").attr("name");
	            	 var fenWaybillNumberValue = $("#fenWaybillNumber").val();
	            	 var overseasShipperName = $("#overseasShipper").attr("name");
	            	 var overseasShipperValue = $("#overseasShipper").val();
	            	 var overseasConsigneeName = $("#overseasConsignee").attr("name")
	            	 var overseasConsigneeValue = $("#overseasConsignee").val();
	            	 var unitName = $("#unit").attr("name");
	            	 var unitValue = $("#unit").val();
	            	 var numberName = $("#number").attr("name");
	            	 var numberValue = $("#number").val();
	            	 var packageDimensionsName = $("#packageDimensions").attr("name");
	            	 var packageDimensionsValue = $("#packageDimensions").val();
	            	 var weightName = $("#weight").attr("name");
	            	 var weightValue = $("#weight").val();
	            	 var freightName = $("#freight").attr("name");
	            	 var freightValue = $("#freight").val();
	            	 var premiumName = $("#premium").attr("name");
	            	 var premiumValue = $("#premium").val();
	            	 var ieFlagName = $("#ieFlag").attr("name");
	            	 var ieFlagValue = $("#ieFlag").val();
	            	 var customsOrderNumberName = $("#customsOrderNumber").attr("name");
	            	 var customsOrderNumberValue = $("#customsOrderNumber").val();
	            	 var uniformNumbersName = $("#uniformNumbers").attr("name");
	            	 var uniformNumbersValue = $("#uniformNumbers").val();
	            	 var customsCodeName = $("#customsCode").attr("name");
	            	 var customsCodeValue = $("#customsCode").val();
	            	 var param1Name = $("#param1").attr("name");
	            	 var param1Value = $("#param1").val();
	            	 var param2Name = $("#param2").attr("name");
	            	 var param2Value = $("#param2").val();
	        	     var jsonGetData ={
	   			    	aArrivalPlanDetails:getData,
	   			    	//BTXX:btxx,
	   			    	    id:id,
		   			    	param1:param1,
		 			    	param2:param2,
		 			    	status:status,
	              		    importPort:importPort,
	              			estimatedArrivalTime:estimatedArrivalTime,
	              			mainWaybillNumber:mainWaybillNumber,
	              			fenWaybillNumber:fenWaybillNumber,
	              			overseasShipper:overseasShipper,
	              			overseasConsignee:overseasConsignee,
	              			unit:unitBT,
	              			number:numberBT,
	              			weight:weight,
	              			packageDimensions:packageDimensions,
	              			freight:freight,
	              			premium:premium,
	              			ieFlag:ieFlag,
	              			customsOrderNumber:customsOrderNumber,
	              			uniformNumbers:uniformNumbers,
	              			customsCode:customsCode,
	              			transactionType:transactionType,
	              			modeOfTransport:modeOfTransport,
	              			packingType:packingType,
	              			supervisionType:supervisionType,
	              			ippc:ippc,
	   			       }
	        	   var id = ${aArrivalPlan.id}
	        	   id = id;
	        	   //把修改后的name和value赋值给key和value
			       //key = name; 
			       //value = value;
			       
			         key = importPortName;
			         value = importPortValue;
			         key1 = mainWaybillNumberName;
			         value1 = mainWaybillNumberValue;
			         key2 = fenWaybillNumberName;
			         value2 = fenWaybillNumberValue;
			         key3 = overseasShipperName;
			         value3 = overseasShipperValue;
			         key4 = overseasConsigneeName;
			         value4 = overseasConsigneeValue;
			         key5 = unitName;
			         value5 = unitValue;
			         key6 = numberName;
			         value6 = numberValue;
			         key7 = packageDimensionsName;
			         value7 = packageDimensionsValue;
			         key8 = weightName;
			         value8 = weightValue;
			         key9 = freightName;
			         value9 = freightValue;
			         key10 = premiumName;
			         value10 = premiumValue;
			         key11 = ieFlagName;
			         value11 = ieFlagValue;
			         key12 = customsOrderNumberName;
			         value12 = customsOrderNumberValue;
			         key13 = uniformNumbersName;
			         value13 = uniformNumbersValue;
			         key14 = customsCodeName;
			         value14 = customsCodeValue;
			         key15 = param1Name;
			         value15 = param1Value;
			         key16 = param2Name;
			         value16 = param2Value;
			         jsonGetData[key] = value;
			         jsonGetData[key1] = value1;
			         jsonGetData[key2] = value2;
			         jsonGetData[key3] = value3;
			         jsonGetData[key4] = value4;
			         jsonGetData[key5] = value5;
			         jsonGetData[key6] = value6;
			         jsonGetData[key7] = value7;
			         jsonGetData[key8] = value8;
			         jsonGetData[key9] = value9;
			         jsonGetData[key10] = value10;
			         jsonGetData[key11] = value11;
			         jsonGetData[key12] = value12;
			         jsonGetData[key13] = value13;
			         jsonGetData[key14] = value14;
			         jsonGetData[key15] = value15;
			         jsonGetData[key16] = value16;
			         jsonGetData['id'] = id;
			       //BTXX = btxx;
			    var strs = JSON.stringify(jsonGetData);
			       console.log(strs)
	            var formdata = new FormData();
	            formdata.append('aArrivalPlan',strs)
	          	//验证时间非空
	            if(estimatedArrivalTimeValue == 'NaN-NaN-NaN' || estimatedArrivalTimeValue== ''){
	    			layer.msg('预计到港时间不能为空',{
	    				icon:2,
	    				time:3000,
	    				},function(){
	    					estimatedArrivalTimeId = "estimatedArrivalTime"
	    					window.parent.location.reload();
	    					});
	    			return false;
	    			}
	            //除时间框外的所有input框均走此执行路径
	            if(arrinputId.includes(estimatedArrivalTimeId)){
	            	return
	            }else{
	            		 $.ajax({
	     	         	    url:"<%=path%>/AArrivalPlan/updateAArrivalPlan.do",
	     	         	    type:'POST',
	     		   				async:true,
	     		   				dataType:'json',
	     		   				processData:false,
	     		   	            contentType:false,
	     		   				data:formdata,
	     	         	   success:function( data ){
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
	     		                	   layer.close(index);
	     		                   }
	     					},
	     					error:function(){
	     						 alert("修改表头数据有误")
	     					}
	     	            })
	            	}
		        }
	         //点击表头input框修改结束
            //监听单元格（表体修改）编辑开始
            var MXX = [];
	        var mxx = {};
            table.on('edit(orderSku)', function (obj) {
               var value = obj.value; //得到修改后的值
               var data = obj.data;  //得到所在行所有键值
               var aId = ${aArrivalPlan.id};
               var chItemName = data.chItemName;
               var serialNumber = data.serialNumber;
               var itemNumber = data.itemNumber;
               var hscode = data.hscode;
               var model = data.model;
               var number = data.number;
               var unit = data.unit;
               var price = data.price;
               var totalPrice = data.totalPrice;
               var currency = data.currency;
               var netWeight = data.netWeight;
               var countryOfOrigin = data.countryOfOrigin;
               var note = data.note;
               var field = obj.field; //得到字段
               var MX = [];
               var mx = {
            		   aId:aId,
            		   chItemName:chItemName,
            		   serialNumber:serialNumber,
            		   itemNumber:itemNumber,
            		   hscode:hscode,
            		   model:model,
            		   number:number,
            		   unit:unit,
            		   price:price,
            		   totalPrice:totalPrice,
            		   currency:currency,
            		   netWeight:netWeight,
            		   countryOfOrigin:countryOfOrigin,
            		   note:note,
               };
			  //给data中的field、value动态赋值
               var id = obj.data.id; //定义需要传给后台的id
               mx.id = id; //传给后台的id
               key = field; //改动的field的名字赋给key，这样field就是动态的
               value = value; //value值赋给传给后台的value
               mx[key] = value; //传入后台的key：value
               mxx = mx;
               MX.push(mx);
               var jsonData = {
            		id:ids,
            		param1:param1,
 			    	param2:param2,
 			    	status:status,
           		    importPort:importPort,
           			estimatedArrivalTime:estimatedArrivalTime,
           			mainWaybillNumber:mainWaybillNumber,
           			fenWaybillNumber:fenWaybillNumber,
           			overseasShipper:overseasShipper,
           			overseasConsignee:overseasConsignee,
           			unit:unitBT,
           			number:numberBT,
           			packageDimensions:packageDimensions,
           			weight:weight,
           			freight:freight,
           			premium:premium,
           			ieFlag:ieFlag,
           			customsOrderNumber:customsOrderNumber,
           			uniformNumbers:uniformNumbers,
           			customsCode:customsCode,
           			transactionType:transactionType,
           			modeOfTransport:modeOfTransport,
           			packingType:packingType,
           			supervisionType:supervisionType,
           			ippc:ippc,   
            	    aArrivalPlanDetails:MX,
           }
            var str = JSON.stringify(jsonData);
               console.log(str)
            var formdata = new FormData();
            formdata.append('aArrivalPlan',str)
          //验证时间非空
            if(estimatedArrivalTimeValue == 'NaN-NaN-NaN' || estimatedArrivalTimeValue== ''){
    			layer.msg('预计到港时间不能为空',{
    				icon:2,
    				time:3000,
    				},function(){
    					estimatedArrivalTimeId = "estimatedArrivalTime"
    					});
    			return false;
    			}
            $.ajax({
         	    url:"<%=path%>/AArrivalPlan/updateAArrivalPlan.do",
         	    type:'POST',
	   				async:true,
	   				dataType:'json',
	   				processData:false,
	   	            contentType:false,
	   				data:formdata,
         	   success:function( data ){
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
	                	   layer.close(index);
	                   }
				},
				error:function(){
					 alert("修改表体数据有误")
				}

            })
            
           });
          //监听单元格（表体修改）编辑结束
	            
	    })
	 }
      })
		    	  //双击打开修改页面
				  layer.open({
		        	   type: 1,
		        	   title: '订单详情',
		        	   area: ['1200px', '600px'],
		        	   skin: 'yourclass',
		        	   content: $('#orderMX'),
		        	   cancel: function(){
		       			// 右上角关闭事件的逻辑
		        		   location.href = '<%=path%>/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlanInopera';
		       		}
		        	 });
                
               
              
            
   	 var $ = layui.$, active = {
			    reload: function(){
	              var orderNo= $("#orderNo").val();
			      //执行重载
			      table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	key: value
			      }
			      });
			    },
	 }   
			  $('.btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
			  
});
</script>	
	
</body>
</html>
