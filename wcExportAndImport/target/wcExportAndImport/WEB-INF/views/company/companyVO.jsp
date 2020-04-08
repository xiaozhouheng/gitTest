<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = "";
    String username = "";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8" />
<title>企业基本信息</title>
<link rel="shortcut icon" href="../statics/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="../statics/css/navigation.css" />
<link rel="stylesheet" href="../statics/css/xoms.layout.css" />
<link rel="stylesheet" href="../statics/layui/css/layui.css" />
<link rel="stylesheet" href="../statics/layui/css/modules/layer/default/layer.css" />
<script type="text/javascript" src="../statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="../statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="../statics/layui/layui.js"></script>

<script type="text/javascript" src="../statics/layui/lay/modules/layer.js"></script>

<!--三级联动插件  -->
<script type="text/javascript" src="../statics/js/distpicper/distpicker.data.js"></script>
<script type="text/javascript" src="../statics/js/distpicper/distpicker.js"></script>
<script type="text/javascript" src="../statics/js/distpicper/main.js"></script>
</head>
<style type="text/css">
.xoms-secnavbar a {
	text-decoration: none;
}

.xoms-secnavbar {
	margin-top: -20px;
}

.container-fluid {
	padding-left: 0px;
	padding-right: 0px;
}

.ztck_input {
	margin-top: 10px;
}

.url_div {
	margin-left: 10px;
	width: 140px;
}
.url_div1 {
	margin-left: 10px;
	width: 210px;
}

.url_div_k {
	height: 30px;
	width: 250px;
	text-align: center;
	font-size: 16px;
	color: red;
	margin-left: 150px;
}

.url-product {
	width: 150%;
}

.tab-pane a {
	text-align: left;
	float: left;
}

.col-sm-12 .container-fluid .zt_ss {
	width: 338px;
	height: 30px;
	font-size: 20px;
	background: #EBEBEB;
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
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">进口货物<span class="caret"></span></a>
						<ul class="dropdown-menu active">
							<!--<li><a href="<%=path%>/my_orders/to_create.html">到货计划表</a></li>-->
							<li><a href="<%=path%>/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlan">到货计划表</a></li>
							<%-- <li><a href="<%=path%>/orderManage/draft.html">审核</a></li>
							<li><a href="<%=path%>/my_order/order_problem.html">订单状态二</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态三</a></li>
							<li><a href="<%=path%>/my_orders/to_create.html">订单状态四</a></li> --%>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
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
					<li class="dropdown active"><a href="#" class="dropdown-toggle"
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
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<!-- <li class="createto_create createbatch_upload active"><a
					href="../company/companyUI">企业基本信息</a></li> -->
					<li class="createto_create createbatch_upload active"><a
					href="<%=path%>/company/editCompany">企业基本信息</a></li>
				<li
					class="managementinfo_received managementshipment_received managementon_delivery
				managementdraft managementshipped managementpicked_up managementdelivered ">
					<a href="<%=path%>/customs/customsUI">海关登记信息</a>
				</li>
				<!-- 			<li class="ordinary_mailindex">< a href="/order/my_order/ordinary_mail/index">平邮订单</ a></li>  -->
				<li class="searchindex"><a
					href="<%=path%>/customer/customerUI">往来客户信息管理</a></li>
			</ul>
		</div>
	</div>
<div class="col-lg-1"></div>
	<div class="col-lg-10 col-xs-12 ztck-body">
		<br />
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-xs-12">
					<div class="container col-lg-12 col-xs-12 ztck-body">
						<ul class="nav nav-tabs">
							<li role="presentation" class="active"><a
								href="<%=path%>/my_orders/to_create.html">企业信息录入</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active">
								<br />
								<br />
							
							<form action="" id="submitform" method="post" enctype="multipart/form-data" autocomplete="off">
									<div class="col-lg-12 col-xs-12 col-lg-pull-1">
										<!--企业基本信息-->
										<div class="col-lg-12 col-xs-12">
										<div class="row">
											<div class="col-lg-5 col-xs-12 blue col-md-offset-1"
												style="text-align: center;">
												企业基本信息
											</div>
										</div>
											<%-- <input class="form-control" id="id" type="hidden" name="id" value="${company.id}"> --%>
											<!--姓名和公司		-->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"style="padding-top: 6px; text-align: right;">
																<!-- <span style="color: red; text-align: right;">*</span> -->
															企业名称（中文）:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" id="companyChName" type="text" name="companyChName" value="${company.companyChName }">
																<!-- <div>
																	<span id="Promptconsignee" style="color: red;"></span>
																</div> -->
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">中文地址:</label>
															<div data-toggle="distpicker">
															<div class="col-sm-3">
												              <select  data-province="${company.province}" name="province" id="province" class="form-control"
												              value=""></select>
												            </div>
												            <div class="col-sm-3"> 
												              <select  data-city="${company.city}" name="city" id="city" class="form-control"
												               value=""></select>
												            </div>
												            <div class="col-sm-3"> 
												              <select data-district="${company.area}" name="area" id="area" class="form-control" 
												               value=""></select>
												            </div>	
																
																
																
															<!-- <div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" id="consigneeCompany"
																	name="consigneeCompany" value="">
																	<div>
																	<span id="PromptconsigneeCompany"
																		style="color: red;"></span>
																</div>
															</div> -->
														</div>
													</div>
												</div>
											</div>
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"	style="padding-top: 6px; text-align: right;">
																<!-- <span style="color: red; text-align: right;">*</span> -->
															企业名称（英文）:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	id="companyEnName" name="companyEnName" maxlength="20"
																	value="${company.companyEnName}">
																<div>
																	<span id="PromptConsigneeContinent"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"style="padding-top: 6px; text-align: right;">
															<!-- <span style="color: red; text-align: right;">*</span> -->
															 英文地址:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	id="enAddress" name="enAddress" value="${company.enAddress}">
																<div>
																	<span id="PromptConsigneeCity"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"style="padding-top: 6px; text-align: right;">
															<!-- <span style="color: red; text-align: right;">*</span> -->
															企业统一社会信用代码证编号:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" id="creditCode"
																	name="creditCode" value="${company.creditCode}">
																<div>
																	<span id="PromptPostCode" style="color: red;"></span><span
																		id="PromptPostnonull" style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"style="padding-top: 6px; text-align: right;">
															<!-- <span style="color: red; text-align: right;">*</span> -->纳税人性质:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<%-- <input class="form-control" type="text" id="taxpayerType"
																	name="taxpayerType" id="taxpayerType" value="${company.taxpayerType}"> --%>
															<select class="form-control category" name="taxpayerType" id="taxpayerType">
																<option value="" >请选择</option>
																<option value="1" <c:if test="${company.taxpayerType==1}">selected</c:if>>一般纳税人</option>
																<option value="0" <c:if test="${company.taxpayerType==0}">selected</c:if>>小规模纳税人</option>
															</select> 
															<span id="logcategory"style="color: red; display: none;">不能为空</span>
														</div>

													</div>
												</div>
												</div>
											</div>
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
																<!-- <span style="color: red; text-align: right;">*</span> -->
																海关注册编码:
															</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="customsCode"
																	id="customsCode" value="${company.customsCode}">
																<div>
																	<!-- <span id="PrompttaxNumber" style="color: red;"></span> -->
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">商检注册编号:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="commodityNumber"
																 id="commodityNumber"	value="${company.commodityNumber}">
															</div>
														</div>
													</div>
												</div>
											</div>
											
											
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">注册资本:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	name="registeredCapital" id="registeredCapital" value="${company.registeredCapital}">
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">企业法人:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="corporate"
																id="corporate"	value="${company.corporate}">
															</div>
														</div>
													</div>
												</div>
											</div>
											
												<div class="container-fluid ztck_input">
												<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
																企业联系人:
															</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="corporateContact"
																	id="corporateContact" value="${company.corporateContact}">
																<div>
																	<!-- <span id="PrompttaxNumber" style="color: red;"></span> -->
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
																固定电话:
															</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="fixedTelephone"
																	id="fixedTelephone" value="${company.fixedTelephone}">
																<div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
												<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
																企业邮箱:
															</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="businessMailbox"
																	id="businessMailbox" value="${company.businessMailbox}">
																<div>
																	<!-- <span id="PrompttaxNumber" style="color: red;"></span> -->
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">移动电话:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="mobilePhone"
																id="mobilePhone"	value="${company.mobilePhone}">
															</div>
														</div>
													</div>
												</div>
											</div>
											
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"style="padding-top: 6px; text-align: right;">
																<!-- <span style="color: red; text-align: right;">*</span> -->
															经营范围:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<textarea class="form-control" id="businessScope"
																id="businessScope"	name="businessScope">${company.businessScope}</textarea>
																<div>
																	<span id="PromptConsigneeAddress"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
														<!-- <div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">注册资本:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	name="registeredCapital" value="">
															</div>
														</div>
													</div> -->
												</div>
											</div>
											<div class="container-fluid ztck_input">
												<div class="row"></div>
											</div>
										</div>
										
									<!-- 	<div class="col-lg-12 col-xs-12"> -->
										<!-- div class="row">
											<div class="col-lg-5 col-xs-12 blue col-md-offset-1"
												style="text-align: center;">
												实体类型
											</div>
										</div> -->
										<div class="container-fluid ztck_input">
												<div class="row"></div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4" style="padding-top: 6px; text-align: right;">
														<!-- <span style="color: red; text-align: right;">*</span> --> 实体类型:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<div class="checkbox" style="margin-top: 6px;">
																<label id="baog"> <input class="checkbox" type="checkbox"name="isManufacturer" id="isManufacturer" value="1"<c:if test="${company.isManufacturer eq '1'}"> checked="checked"</c:if>>生产企业</label> 
																<label id="wenj"> <input class="checkbox" type="checkbox" name="isImportAndExport" id="isImportAndExport" value="1" <c:if test="${company.isImportAndExport eq '1'}"> checked="checked"</c:if>>进出口贸易企业 </label> 
																<label id="dah"> <input class="checkbox" type="checkbox" name="isFreightForwarding" id="isFreightForwarding" value="1" <c:if test="${company.isFreightForwarding eq '1'}"> checked="checked"</c:if>>货代 </label>
																<label id="dah"> <input class="checkbox" type="checkbox" name="isInstitution" id="isInstitution" value="1" <c:if test="${company.isInstitution eq '1'}"> checked="checked"</c:if>>事业单位 </label>
																<label id="dah"> <input class="checkbox" type="checkbox" name="entityType" id="entityType" value="1" <c:if test="${company.entityType eq '1'}"> checked="checked"</c:if> >其他 </label>
															</div>
														</div> 
													</div>
												</div>
										</div>
										<!--附件-->
										<br/>
										<br/>
										<div class="col-lg-10 col-xs-12 col-lg-offset-1">
											<label class="col-lg-4" style="padding-top: 6px;width:15.555555%;text-align: right;">
											<!-- <span style="color: red; text-align: right;">*</span> -->上传文件:</label>
											<a href="javascript:;" class="file" position='relative'>营业执照   <input type="file" name="file1" id="businessLicense" value=""></a>
											<a href="javascript:;" class="file" position='relative'>对外贸易经营者备案登记表  <input type="file" name="file2" id="foreignTrade" value=""></a>
											<a href="javascript:;" class="file" position='relative'>海关备案登记证 <input type="file" name="file3" id="customsRegistration" value=""></a>
											<a href="javascript:;" class="file" position='relative'>企业统一社会信用代码证<input type="file" name="file4" id="uscc" value=""></a>
											<span class="errorRegion" id="errorFile1" style="color: red;"></span>
											<span class="errorRegion" id="errorFile2" style="color: red;"></span>
											<span class="errorRegion" id="errorFile3" style="color: red;"></span>
											<span class="errorRegion" id="errorFile4" style="color: red;"></span>
										</div>
								
									<!-- </div> -->
									
									<div class="col-lg-12 col-xs-12">
									<br/>
										<div class="col-lg-offset-9">
											<button type="button" id="to_add" onclick="editSubmit()"
												class="layui-btn layui-btn-normal layui-btn-sm">
												<span class="glyphicon glyphicon-ok"></span>
												保存
											</button>
										</div>
									</div>
									</div>
								</form>
							
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	layui.use('form', function(){
	  var form = layui.form; 
	  form.render();
	 
	});

	  
	
	
	//中文地址三级联动
	$(function(){
		$("#distpicker").distpicker('destroy');
		$("#distpicker").distpicker({
		    province: '省份名',
		    city: '城市名',
		    district: '区名',
		    autoSelect: true,
		    placeholder: false
		});
		});
	
		/* $("#province").val(data.province);
	    $("#province").trigger("change");
	    $("#city").val(data.city);
	    $("#city").trigger("change");
	    $("#area").val(data.area); */
	    /* $("#edetailAddress").val(data.detailAddress); */
</script>
<script type="text/javascript">
	if("${company.id}" != ""){
		var url = "<%=path%>/company/updateCompany.do?id="+"${company.id}"
	}else{
		var url = "<%=path%>/company/updateCompany.do"
	}
function editSubmit() {
	var companyChName = $("#companyChName").val()
	var province = $("#province").val()
	var city = $("#city").val()
	var area = $("#area").val()
	var companyEnName = $("#companyEnName").val()
	var enAddress = $("#enAddress").val()
	var creditCode = $("#creditCode").val()
	/* var taxpayerType = $("#taxpayerType").val() */
	var taxpayerType = $("select[name='taxpayerType'] option:checked").val();
	var customsCode = $("#customsCode").val()
	var commodityNumber = $("#commodityNumber").val()
	var registeredCapital = $("#registeredCapital").val()
	var corporate = $("#corporate").val()
	var corporateContact = $("#corporateContact").val()
	var fixedTelephone = $("#fixedTelephone").val()
	var businessMailbox = $("#businessMailbox").val()
	var mobilePhone = $("#mobilePhone").val()
	var businessScope = $("#businessScope").val()
	if(companyChName == null || companyChName == "" ){
    	layer.confirm("请填写企业名称（中文）")
    	return
	}
	if(companyEnName == null || companyEnName == "" ){
    	layer.confirm("请填写企业名称（英文）")
    	return
	}
	if(enAddress == null || enAddress == "" ){
    	layer.confirm("请填写英文地址）")
    	return
	}
	if(creditCode == null || creditCode == "" ){
    	layer.confirm("请填写企业统一社会信用代码证编号")
    	return
	}
	if(taxpayerType == null || taxpayerType == "" ){
    	layer.confirm("请填写纳税人性质")
    	return
	}
	if(businessScope == null || businessScope == "" ){
    	layer.confirm("请填写经营范围")
    	return
	}
	//对多选按钮的数据处理
	var isManufacturers = $('#isManufacturer').is(":checked");
	var isManufacturer
	if(isManufacturers == true){
		isManufacturer =1;
	}else{
		isManufacturer =0;
	}
	var isImportAndExports = $('#isImportAndExport').is(":checked");
	var isImportAndExport
	if(isImportAndExports == true){
		isImportAndExport =1;
	}else{
		isImportAndExport =0;
	}
	var isFreightForwardings = $('#isFreightForwarding').is(":checked");
	var isFreightForwarding
	if(isFreightForwardings == true){
		isFreightForwarding =1;
	}else{
		isFreightForwarding =0;
	}
	var isInstitutions = $('#isInstitution').is(":checked");
	var isInstitution
	if(isInstitutions == true){
		isInstitution =1;
	}else{
		isInstitution =0;
	}
	var entityTypes = $('#entityType').is(":checked");
	var entityType
	if(entityTypes == true){
		entityType =1;
	}else{
		entityType =0;
	}
	//实体类型非空验证
	 var radio=document.getElementsByClassName('radio');
	         for(i=0;i<radio.length;i++){
	             if(!radio[i].checked){
	                 if(i==radio.length-1){
	                 layer.confirm("请至少选择一个实体类型")
	                  }
	             }else{
	               break;
	             }
	         }
	 //图片非空验证
	var file1 = $('#businessLicense').get(0).files[0];
	/*  if(file1==null){
 		$("#errorFile1").text("请上传营业执照");
  }return false; */
	var file2 = $('#foreignTrade').get(0).files[0];
	/*  if(file2==null){
	 		$("#errorFile2").text("请上传对外贸易经营者备案登记表");
	  }return false; */
	var file3 = $('#customsRegistration').get(0).files[0];
	/*  if(file3==null){
	 		$("#errorFile3").text("请上传海关备案登记证");
	  }return false; */
	var file4 = $('#uscc').get(0).files[0];
	/*  if(file4==null){
	 		$("#errorFile4").text("请上传企业统一社会信用代码证");
	  }return false; */
	var formdata = new FormData();
	formdata.append('companyChName',companyChName)
	formdata.append('province',province)
	formdata.append('city',city)
	formdata.append('area',area)
	formdata.append('companyEnName',companyEnName)
	formdata.append('enAddress',enAddress)
	formdata.append('creditCode',creditCode)
	formdata.append('taxpayerType',taxpayerType)
	formdata.append('customsCode',customsCode)
	formdata.append('commodityNumber',commodityNumber)
	formdata.append('registeredCapital',registeredCapital)
	formdata.append('corporate',corporate)
	formdata.append('corporateContact',corporateContact)
	formdata.append('fixedTelephone',fixedTelephone)
	formdata.append('businessMailbox',businessMailbox)
	formdata.append('mobilePhone',mobilePhone)
	formdata.append('businessScope',businessScope)
	formdata.append('isManufacturer',isManufacturer)
	formdata.append('isImportAndExport',isImportAndExport)
	formdata.append('isFreightForwarding',isFreightForwarding)
	formdata.append('isInstitution',isInstitution)
	formdata.append('entityType',entityType)
	formdata.append('file1',file1)
	formdata.append('file2',file2)
	formdata.append('file3',file3)
	formdata.append('file4',file4)
	 $.ajax({
		      url:url,
              type : 'post',
              data:formdata,
              cache:false,
              dataType:'json',
              processData:false,
              contentType:false,
              success : function (data){
                 if(data.status == 200){
                 	  layer.msg(data.msg,{
                		 icon: 1,
                	 }); 
                 }else{
                	 layer.msg(data.msg,{
                		 icon: 2, 
                	 });  
                 }
              }
          });
}
    if('${compant}'==1){
    layer.open({
      type: 1
      ,title: false //不显示标题栏
      ,closeBtn: false
      ,area: '300px;'
      ,shade: 0.8
      ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
      ,btn: ['等待审核']
      ,btnAlign: 'c'
      ,moveType: 1 //拖拽模式，0或者1
      ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">未找到对应企业或者	<br>企业正在审核中<br>如果在此期间有任何困难请致电8888888888<br><br>我们此后的征途是星辰大海 ^_^</div>'
      ,success: function(layero){
        var btn = layero.find('.layui-layer-btn');
       
      }
    });
    } 
  
</script>
</body>
</html>
