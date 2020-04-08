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
<title>出货计划</title>
<link rel="shortcut icon" href="../statics/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="../statics/css/navigation.css" />
<link rel="stylesheet" href="../statics/css/xoms.layout.css" />
<link rel="stylesheet" href="../statics/layui/css/layui.css" />
<link rel="stylesheet" href="../statics/css/to_create.css" />
<link rel="stylesheet" href="../statics/css/jquery_ui.css" />
<script type="text/javascript" src="../statics/js/jquery.min.js"></script>
<script type="text/javascript" src="../statics/js/jquery.serializejson.js"></script>
<script type="text/javascript" src="../statics/js/jquery_ui.js"></script>
<script type="text/javascript" src="../statics/js/tool.js"></script>
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
	<!-- 导航栏引入 -->
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
					<li class="dropdown active"><a href="#" class="dropdown-toggle"
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
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="searchindex active"><a href="<%=path%>/page/pageJump.do?path=views/sShippingPlan/SShippingPlan">出货计划表</a></li>
				<li role="presentation"><a
				 href="<%=path%>/page/pageJump.do?path=views/sShippingPlan/SShippingPlanInopera">出货计划表查询</a>
				</li>
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
						<%-- <ul class="nav nav-tabs">
							<li role="presentation" class="active"><a
								href="<%=path%>/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlan">到货计划表新增</a>
							</li>
							<li role="presentation"><a
								href="<%=path%>/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlanInopera">查询</a>
							</li>
						</ul> --%>

						<div class="tab-content">
							<div class="tab-pane active">
								<br />
								<br />
								<form action="" id="to_create" method="post" enctype="multipart/form-data" autocomplete="off">
									<div class="col-lg-12 col-xs-12 col-lg-pull-1">
										<div class="row">
											<div class="col-lg-5 col-xs-12 blue col-md-offset-1"
												style="text-align: center;">
											</div>
										</div>
										<div class="col-lg-12 col-xs-12">
										<!--业务编号和销售员代码-->
										<div class="container-fluid ztck_input" type = "hidden">
											<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">
														业务编号:</label>
														<div class="col-sm-7 " style="padding-left: 5px;">
															<input class="form-control" type="text" id="businessNumber"
																autoComplete='off' name="businessNumber" value="">
															<div>
																<span id="promptDeliveryTime"
																	style="color: red; display: none;">不能为空</span>
															</div>
														</div>
													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"style="padding-top: 6px; text-align: right;">
														销售员代码:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<input class="form-control" type="text" id="salespersonCode"
																name="salespersonCode" value="">
															<div>
																<span id="promptDestinationCountry"
																	style="color: red; display: none;">不能为空</span>
															</div>
														</div>
													</div>

												</div>
											</div>
										</div>
										
										<!--出货时间和目的国-->
										<div class="container-fluid ztck_input">
											<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">
															<!-- <span style="color: red; text-align: right;">*</span> -->
														出货时间:</label>
														<div class="col-sm-7 " style="padding-left: 5px;">
															<input class="form-control" type="text" id="deliveryTime"
																autoComplete='off' name="deliveryTime" value="">
															<div>
																 <span id="promptDeliveryTime"
																	style="color: red; display: none;">不能为空</span>
															</div>
														</div>
													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"style="padding-top: 6px; text-align: right;">
														目的国:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<input class="form-control" type="text" id="destinationCountry"
																name="destinationCountry" value="">
															<div>
																<span id="promptDestinationCountry"
																	style="color: red; display: none;">不能为空</span>
															</div>
														</div>
													</div>

												</div>
											</div>

										</div>
									<!-- 运输方式和目的港 -->
										<div class="container-fluid ztck_input">
											<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">运输方式:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<select class="form-control category" name="modeOfTransport"
																id="modeOfTransport">
																<option value="" >请选择</option>
																<option value="0" >公路</option>
																<option value="1" >铁路</option>
															</select> <span id="promptTransport"
																style="color: red; display: none;">不能为空</span>
														</div>

													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">
														目的港:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<input class="form-control" type="text"
																name="destination" id="destination" value=""><span
																id="promptDestination" style="color: red; display: none;">不能为空</span>
														</div>
													</div>
												</div>
											</div>

										</div>
										<!-- 出口口岸 和主运单号-->
										<div class="container-fluid ztck_input">
											<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">
														出口口岸:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<input class="form-control" type="text"
																name="exportPorts" id="exportPorts" value=""><span
																id="promptExportPorts" style="color: red; display: none;">不能为空</span>
														</div>
													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">
														主运单号:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<input class="form-control" type="text"
																name="mainWaybillNumber" id="mainWaybillNumber" value=""><span
																id="promptMainNumber" style="color: red; display: none;">不能为空</span>
														</div>
													</div>
												</div>
												
											</div>
										</div>
										<!-- 分运单号和境外收货人 -->
                                     <div class="container-fluid ztck_input">
											<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">分运单号:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
														<input class="form-control" type="text" id="distributionOrderNumber"
																name="distributionOrderNumber" value="" >
															 <span id="promptFenNumber"
																style="color: red; display: none;">不能为空</span>
														</div>
													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">境外收货人:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
														<input class="form-control" type="text" id="overseasConsignee"
																name="overseasConsignee" value="">
															 <span id="promptOverConsignee"
																style="color: red; display: none;">不能为空</span>
														</div>
													</div>
												</div>
                                            </div>
                                        </div>
											<!--境外发货人和生成销售单位-->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
															境外发货人:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" id="domesticShipper" type="text"
																	name="domesticShipper" value="">
																<div>
																	<span id="promptShipper"
																		style="color: red;display: none;">不能为空</span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">生成销售单位:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" id="productionUnit"
																	name="productionUnit" value="" >
																	<div>
																	<span id="promptUnit"
																		style="color: red;display: none;">不能为空</span>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>
											<!-- 总件数和总毛重 -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
															总件数:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	id="totalNumber" name="totalNumber" placeholder="请输入正整数" maxlength="5"
																	value="" oninput = "value=value.replace(/[^\d]/g,'')">
																<div>
																	<span id="promptTotalNumber"
																		style="color: red;display: none;">不能为空</span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
															总毛重:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	id="totalGrossWeight" name="totalGrossWeight" value="">
																<div>
																	<span id="promptTotalWeight"
																		style="color: red;display: none;">不能为空</span>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>

										<!-- 总体积和包装种类 -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
															总体积:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" id="totalCapacity"
																	name="totalCapacity" value="">
																<div>
																	<span id="promptTotalCapacity" style="color: red;display: none;">不能为空</span><span
																		id="PromptPostnonull" style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">包装种类:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<select class="form-control category" name="packingType"
																id="packingType">
																<option value="" >请选择</option>
																<option value="0" >大包</option>
																<option value="1" >小包</option>
															</select> <span id="promptPackingType"
																style="color: red; display: none;">不能为空</span>
														</div>

													</div>
												</div>
												</div>

											</div>
										<!-- 运费和保费 -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
																<!-- <span style="color: red; text-align: right;">*</span> -->
																运费:
															</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="freight"
																	id="freight" value="" >
																<div>
																	<span id="promptFreight" style="color: red;display: none;">不能为空</span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">保费:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" id="premium" name="premium"
																	value="">
																<div>
																	<span id="promptPremium" style="color: red;display: none;">不能为空</span>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										<!-- 监管方式和成交方式 -->	
										<div class="container-fluid ztck_input">
											<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">成交方式:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<select class="form-control category" name="transactionTyep"
																id="transactionTyep">
																<option value="" >请选择</option>
																<option value="1" >CIF</option>
																<option value="2" >C&F</option>
																<option value="3" >FOB</option>
																<option value="4" >C&I</option>
																<option value="5" >市场价</option>
																<option value="6" >垫仓</option>
																<option value="7" >EXW</option>
															</select> <span id="prompttransactionTyep"
																style="color: red; display: none;display: none;">不能为空</span>
														</div>

													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">监管方式:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<select class="form-control category" name="supervisionType"
																id="supervisionType">
																<option value="">请选择</option>
																<option value="0">方式一</option>
																<option value="1">方式二</option>
															</select> <span id="promptSupervisionType"
																style="color: red; display: none;display: none;">不能为空</span>
														</div>

													</div>
												</div>
											</div>
										</div>
										<!-- 包装尺寸 -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
															包装尺寸:</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" id="packageDimensions"
																	name="packageDimensions" value="">
																<div>
																	<span id="promptDimensions"
																		style="color: red;display: none;">不能为空</span>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										<!-- 上传附件 -->
										<!-- <div class="container-fluid ztck_input">
											<div class="row">
												<div class="col-lg-12 col-xs-12 col-md-offset-1">
													<label class="col-lg-1"style="padding-top: 6px; text-align: right;">
															<span style="color: red; text-align: right;">*</span>上传附件:</label>
														<div class="form-group text-center submit endit-btn" >
											            <a href="javascript:;" class="file" position='relative'>发票 <input type="file" name="file1" id="invoice" value=""></a>
														<a href="javascript:;" class="file" position='relative'>装箱单  <input type="file" name="file2" id="packingList" value=""></a>
														<a href="javascript:;" class="file" position='relative'>合同 <input type="file" name="file3" id="contract" value=""></a>
														<a href="javascript:;" class="file" position='relative'>报关委托书<input type="file" name="file4" id="cpoa" value=""></a>
														<a href="javascript:;" class="file" position='relative'>装箱明细 <input type="file" name="file5" id="packingDetails" value=""></a>
														<a href="javascript:;" class="file" position='relative'>其他1  <input type="file" name="file6" id="other1" value=""></a>
														<a href="javascript:;" class="file" position='relative'>其他2 <input type="file" name="file7" id="other2" value=""></a>
														<span class="errorRegion" id="promptFile1" style="color: red;display: none;"></span>
														<span class="errorRegion" id="promptFile2" style="color: red;display: none;"></span>
														<span class="errorRegion" id="promptFile3" style="color: red;display: none;"></span>
														<span class="errorRegion" id="promptFile4" style="color: red;display: none;"></span>  
											           </div> 	
												</div>
											</div>
										</div> -->
										<!--出货计划表明细-->
										<div class="col-lg-10 col-xs-12 col-lg-offset-2">
											<div class="row">
												<div class="col-lg-5 col-xs-12 blue col-lg-pull-1"
													style="text-align: center;">
													出货计划表明细
													<button type="button"
														class="layui-btn layui-btn-normal layui-btn-xs"
														id="zt_addhai">
														<span class="glyphicon glyphicon-plus ">添加</span>
													</button>
													<!-- <button type="button" class="btn btn-xs btn-info zt_select" id="zt_select"><span class="glyphicon glyphicon-th-list">选择</span></button> -->
												</div>
											</div>
											<div id="customs">
												<div class="cus-chd container-fluid"
													style="background-color: #F6F6F6;">
													<div>
														<span class="cus-del glyphicon glyphicon-minus-sign dn"
															style="background-color: #F6F6F6;"></span> <span
															class="cus-od badge" style="background-color: #41A3E9;">1</span>
														<button type="button"
															class="layui-btn layui-btn-normal layui-btn-xs zt_select">
															<span class="glyphicon glyphicon-th-list">选择</span>
														</button>
													</div>
													<div class="row ztck_input">
														<div class="col-lg-3 col-xs-12">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">序号</label>
																<div class="col-lg-6" style="padding-left: 5px;">
																	<input class="form-control serialNumber" type="text" value="" placeholder="请输入数字"
																		name="serialNumber" id="" oninput="this.value=this.value.replace(/[^0-9-]+/,'');">
																</div>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">货号</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control itemNumber" type="text" placeholder="请输入数字"
																		value="" name="itemNumber" id="" oninput="this.value=this.value.replace(/[^0-9-]+/,'');">
																</div>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12">
															<div>
																<label class="col-lg-6"style="padding-top: 6px; text-align: right;">
																	<!-- <span style="color: red; text-align: right;">*</span> -->
																中文名称</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control chItemName" type="text"
																		value="" name="chItemName" id="">
																</div>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12  ">
															<div>
																<label class="col-lg-6"style="padding-top: 6px; text-align: right;"> 
																	<!-- <span style="color: red; text-align: right;">*</span> -->税号</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control hscode" type="text"
																		value="" name="hscode" id="">
																</div>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-3 col-xs-12 ztck_input" id="">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">型号规格</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control model" type="text"
																		value="" name="model" id="">
																</div>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12  ztck_input">
															<div>
																<label class="col-lg-6"style="padding-top: 6px; text-align: right;">
																	<!-- <span style="color: red; text-align: right;">*</span> -->成交数量</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control number" type="text" placeholder="请输入正整数"
																		value="" name="number" id="" oninput = "value=value.replace(/[^\d]/g,'')">
																</div>
															</div>
														</div>
														<div class="col-lg-3 col-xs-12 ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">成交单位</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control unit" type="text" name="unit"
																		value="" id="">
																</div>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12  ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">价格:</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control price" type="text" value=""
																		name="price" id="">
																</div>
															</div>
														</div>
														
														<div class="col-lg-3 col-xs-12 ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">总价:</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control totalPrice" type="text" name="totalPrice"
																		value="" id="">
																</div>
															</div>
														</div>
														<div class="col-lg-3 col-xs-12 ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">币制:</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control currency" type="text" name="currency"
																		value="" id="">
																</div>
															</div>
														</div>
														<div class="col-lg-3 col-xs-12 ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">净重:</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control netWeight" type="text" name="netWeight"
																		value="" id="">
																</div>
															</div>
														</div>
														<div class="col-lg-3 col-xs-12 ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">境内货源地:</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control domesticSourceOfGoods" type="text" name="domesticSourceOfGoods"
																		value="" id="">
																</div>
															</div>
														</div>
														<div class="col-lg-3 col-xs-12 ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">备注:</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control note" type="text" name="note"
																		value="" id="">
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-12 col-xs-12">
										<hr />
										<div class="col-lg-offset-9">
											<button type="button" id="to_add"
												class="layui-btn layui-btn-normal layui-btn-sm">
												<span class="glyphicon glyphicon-ok"></span>
												保存
											</button>
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
<!-- 产品选择 -->
<div id="f_declare" style="display: none;">
		<table id="t_declare"></table>
</div>
	<!--
	作者：offline
	时间：2018-02-07
	描述：网站主体结束
	-->
<script type="text/javascript">
layui.use(['element','laydate'],function () {
    var laydate = layui.laydate;
    //执行一个laydate实例
    laydate.render({
        elem: '#deliveryTime' //指定元素
        ,done: function(value, date, endDate){
            $('#deliveryTime').change();  // 一定要加上这句！！！不然没有回调！！！
            //alert(); //得到日期生成的值，如：2017-08-18
            //getData(new Date(value));
        }
    });
})
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
</script>	
<script type="text/javascript">
var k = 1;
layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function(){
    var laydate = layui.laydate, //日期
        laypage = layui.laypage, //分页
        layer = layui.layer, //弹层
        table = layui.table, //表格
        carousel = layui.carousel, //轮播
        upload = layui.upload, //上传
        element = layui.element; //元素操作
        //到货计划明细的单击选择事件
    	 $("#customs").on('click','button',function(){
    		 var note=$(this).parent().find($(".cus-od")).text();
   		  	 var i=note-1;
    		 layer.open({
	        	   type: 1,
	        	   title: '海关申报品',
	        	   area: ['900px', '600px'],
	        	   skin: 'yourclass',
	        	   content: $('#f_declare'), <%-- ["<%=path%>/AArrivalPlanDetails/findItem.do"] --%>
	        	   btn: ['确定', '取消']
	        	   ,yes: function(index){
	        		   var checkStatus = table.checkStatus('queryOrders');
					      var data = checkStatus.data;
					      //console.log(data[0].itemNumber)
					      var length=data.length;
					     if(length==1){
					    	    $("input[id='serialNumber"+i+"']").val(data[0].id);
						    	$("input[id='itemNumber"+i+"']").val(data[0].itemNumber);
						    	$("input[id='chItemName"+i+"']").val(data[0].itemChName);
						    	$("input[id='hscode"+i+"']").val(data[0].hsCode);
						    	$("input[id='model"+i+"']").val(data[0].model);
						    	$("input[id='number"+i+"']").val(data[0].number);
						    	$("input[id='unit"+i+"']").val(data[0].unit);
						    	$("input[id='price"+i+"']").val(data[0].price);
						    	$("input[id='totalPrice"+i+"']").val(data[0].totalPrice);
						    	$("input[id='currency"+i+"']").val(data[0].currency);
						    	$("input[id='netWeight"+i+"']").val(data[0].netWeight);
						    	$("input[id='domesticSourceOfGoods["+i+"]']").val(data[0].domesticSourceOfGoods);
						    	$("input[id='note"+i+"']").val(data[0].note);
						    	 layer.close(index);
				           }else{
					    	 layer.msg("请选择一条数据！",{icon:2});
				           }
	        		  }
	        	 });
    		    table.render({
    		        elem: '#t_declare',
    		       <%--  url:'<%=path%>/AArrivalPlanDetails/findItem.do', --%>
    		        url:'<%=path%>/commodityFiling/getAllcommodityFiling.do?reviewStatus=1',
    		        page: true,
    		        method:'get',
    		        height:450,
    		        limit:200,
    	            limits:[200,500,1000],
    		        id: 'queryOrders',
    		        response: {
    	                statusName: 'success' //数据状态的字段名称，默认：code
    	                , statusCode: true //成功的状态码，默认：0
    	                , msgName: 'message' //状态信息的字段名称，默认：msg
    	                , countName: 'count' //数据总数的字段名称，默认：count
    	                , dataName: 'value' //数据列表的字段名称，默认：data  
    	            },
    		        cols: [[
    		            {field : 'id',checkbox : true,align : 'center'},
    		            {field:'itemNumber',  title:'货号' ,align :'center'},
    		            {field:'barCode',  title:'条形码' ,align :'center'},
    		            {field:'itemChName', title:'产品中文名称' ,align :'center'},
    		            {field:'itemEnName',  title:'产品英文名称' ,align :'center'},
    		            {field:'hsCode',  title:'税号' ,align :'center'},
    		            {field:'netWeight',  title:'单个净重' ,align :'center' },
    		            {field:'brand',  title:'品牌' ,align :'center'},
    		            {field:'brandType',  title:'品牌类型' ,align :'center'},
    		            {field:'uses',  title:'用途' ,align :'center'},
    		            {field:'features',  title:'功能' ,align :'center'},
    		            {field:'material',  title:'材质' ,align :'center'},
    		            {field:'model',  title:'型号' ,align :'center'},
    		            {field:'packageType',  title:'包装' ,align :'center'},
    		            {field:'standardSizes',  title:'规格尺寸' ,align :'center'},
    		            {field:'other',  title:'其他' ,align :'center'},
    		            {field:'image',  title:'图片' ,align :'center'},
    		            {field:'companyCode',  title:'企业编码' ,align :'center'},
    		            {field:'businessNumber',  title:'业务编码' ,align :'center'},
    		            {field:'note',  title:'备注' ,align :'center'},
    		            
    		        ]]
    		    });
    		    
    	  })
    	  //alert(k)
			/*//清理代码
    		function clear(){
    			   //每次点击添加的时候将input清空
    		   	 $("input[type='text']").val("");   
    		     $("textarea").val("");
    		} */
        });
    
//点击保存
$("#to_add").click(function(){
	 var businessNumber=$("#businessNumber").val();//业务编号
	 var salespersonCode=$("#salespersonCode").val();//销售员代码 
	 var destinationCountry=$("#destinationCountry").val();//目的国
	 var deliveryTime= createTime($("#deliveryTime").val());//出货时间
	 //出货时间验证
	 if(deliveryTime == 'NaN-NaN-NaN' || deliveryTime== ''){
		 layer.msg('出货时间不能为空',{
				icon:2,
				time:3000,
				},function(){
					window.parent.location.reload();
					});
		    	return false;
		     }
	 var destination=$("#destination").val();//目的港
	 var modeOfTransport= $("#modeOfTransport").val();//运输方式
	 var exportPorts=$("#exportPorts").val();//出口口岸
	 var mainWaybillNumber=$("#mainWaybillNumber").val();//主运单号
	  if(mainWaybillNumber==null || mainWaybillNumber=="" ){
		  layer.msg('主运单号不能为空',{
				icon:2,
				time:3000,
				},function(){
					window.parent.location.reload();
					});
		    	return false;
		     }
	 var distributionOrderNumber=$("#distributionOrderNumber").val();//分运单号
	 var overseasConsignee= $('#overseasConsignee').val();//境外发货人
	 var domesticShipper=$("#domesticShipper").val();//境外收货人
	 var productionUnit=$("#productionUnit").val();//生成销售单位
	 var totalNumber= $("#totalNumber").val();//总件数
	 var totalGrossWeight=$("#totalGrossWeight").val();//总毛重
	 var totalCapacity=$("#totalCapacity").val();//总体积
	 var packingType= $("#packingType").val();//包装种类
	 var packageDimensions=$("#packageDimensions").val();//包装尺寸
	 var supervisionType= $('#supervisionType').val();//监管方式
	 var transactionTyep= $('#transactionTyep').val();//成交方式
	 var freight = $("#freight").val();//运费
	 var premium = $("#premium").val();//保费
	 /* var file1 = $('#invoice').get(0).files[0];
	 var file2 = $('#packingList').get(0).files[0];
	 var file3 = $('#contract').get(0).files[0];
	 var file4 = $('#cpoa').get(0).files[0];
	 var file5 = $('#packingDetails').get(0).files[0];
	 var file6 = $('#other1').get(0).files[0];
	 var file7 = $('#other2').get(0).files[0]; */
	
	
	 //获取到货明细信息
     var BTXX = [];
     var btxxfor = {};
     for(var i = 0;i<k;i++){
     var serialNumber = $("#serialNumber"+i).val();
     var itemNumber = $("#itemNumber"+i).val();
     var chItemName = $("#chItemName"+i).val();
     var hscode = $("#hscode"+i).val();
     var model = $("#model"+i).val();
     var number = $("#number"+i).val();
     var unit = $("#unit"+i).val();
     var price = $("#price"+i).val();
     var totalPrice = $("#totalPrice"+i).val();
     var currency = $("#currency"+i).val();
     var netWeight = $("#netWeight"+i).val();
     var domesticSourceOfGoods = $("#domesticSourceOfGoods"+i).val();
     var note = $("#note"+i).val();
     
     btxxfor = {
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
    		 domesticSourceOfGoods:domesticSourceOfGoods,
    		 note:note,
     }
     BTXX.push(btxxfor)
     }
 		var formdata = new FormData()
     	var data;
     	data = {
     			businessNumber:businessNumber,
     			salespersonCode:salespersonCode,
     			destinationCountry:destinationCountry,
     			deliveryTime:deliveryTime,
     			destination:destination,
     			modeOfTransport:modeOfTransport,
     			exportPorts:exportPorts,
     			mainWaybillNumber:mainWaybillNumber,
     			distributionOrderNumber:distributionOrderNumber,
     			overseasConsignee:overseasConsignee,
     			domesticShipper:domesticShipper,
     			productionUnit:productionUnit,
     			totalNumber:totalNumber,
     			totalGrossWeight:totalGrossWeight,
     			totalCapacity:totalCapacity,
     			packingType:packingType,
     			packageDimensions:packageDimensions,
     			supervisionType:supervisionType,
     			transactionTyep:transactionTyep,
     			freight:freight,
     			premium:premium,
     			shippingPlanDetails:BTXX,
     	}
     	    var str =  JSON.stringify(data)
     		/* formdata.append('file1',file1)
			formdata.append('file2',file2)
			formdata.append('file3',file3)
			formdata.append('file4',file4)
			formdata.append('file5',file5)
			formdata.append('file6',file6)
			formdata.append('file7',file7) */
			formdata.append('shippingPlan',str)
		    $("#volume2").css("display","none");
		    var index=layer.load();

		<%--  $.post('<%=path%>/AArrivalPlan/updateAArrivalPlan.do',formdata,
	        function(result){
	    	var date=eval('('+result+')');
			if(date.status == 200){
				alert("成功")    
			}else{
				alert("失败")
			}
    	}		
	    ) --%>
		
		   $.ajax({
				url:'<%=path%>/SShippingPlan/updateSShippingPlan.do',
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
	                	   layer.close(index);
	                   }
				},
				error:function(){
					 alert("保存出货计划表数据有误")
				}

			})
});
//主运单号非空
$("#mainWaybillNumber").blur(function(){
  	 var mainWaybillNumber=$("#mainWaybillNumber").val();
  	 if(mainWaybillNumber==""||mainWaybillNumber==null){
  		$("#promptMainNumber").css("display","block");
  		 return false;
  	 }else{
  		 $("#promptMainNumber").css("display","none");
  	 }
   });

//鼠标滑过显示
$(function () {
	 /**清理*/
	 // clear();
	
var consigneeCountry;
//给明细赋id值
$(".serialNumber").attr("id","serialNumber0");
$(".itemNumber").attr("id","itemNumber0");
$(".chItemName").attr("id","chItemName0");
$(".hscode").attr("id","hscode0");
$(".model").attr("id","model0");
$(".number").attr("id","number0");
$(".unit").attr("id","unit0");
$(".price").attr("id","price0");
$(".totalPrice").attr("id","totalPrice0");
$(".currency").attr("id","currency0");
$(".netWeight").attr("id","netWeight0");
$(".domesticSourceOfGoods").attr("id","domesticSourceOfGoods0");
$(".note").attr("id","note0");
/**
 * 添加 删除 到货计划表明细 功能
 */
var cus = $('#customs'), chd = $('.cus-chd'),
    serialNumber=document.getElementsByClassName('serialNumber'),
    itemNumber=document.getElementsByClassName('itemNumber'),
    chItemName=document.getElementsByClassName('chItemName'),
    hscode=document.getElementsByClassName('hscode'),
    model=document.getElementsByClassName('model'),
    number=document.getElementsByClassName('number'),
    unit=document.getElementsByClassName('unit'),
    price=document.getElementsByClassName('price'),
    totalPrice=document.getElementsByClassName('totalPrice'),
    currency=document.getElementsByClassName('currency'),
    netWeight=document.getElementsByClassName('netWeight'),
    domesticSourceOfGoods=document.getElementsByClassName('domesticSourceOfGoods'),
    note=document.getElementsByClassName('note'),
    od = document.getElementsByClassName('cus-od'),
    del = document.getElementsByClassName('cus-del');
$('#zt_addhai').click(function () {
    if(od.length === 1) del[0].className = 'cus-del glyphicon glyphicon-minus-sign';
    cus[0].insertAdjacentHTML('afterbegin', chd[0].outerHTML);
    od[0].innerText = ~~od[1].innerText + 1;
    var i = od[0].innerText-1;
    k = i+1;
    serialNumber[0].id="serialNumber"+i+"";
    itemNumber[0].id="itemNumber"+i+"";
    chItemName[0].id="chItemName"+i+"";
    hscode[0].id="hscode"+i+"";
    model[0].id="model"+i+"";
    number[0].id="number"+i+"";
    unit[0].id="unit"+i+"";
    price[0].id="price"+i+"";
    totalPrice[0].id="totalPrice"+i+"";
    currency[0].id="currency"+i+"";
    netWeight[0].id="netWeight"+i+"";
    domesticSourceOfGoods[0].id="domesticSourceOfGoods"+i+"";
    note[0].id="note"+i+"";
});
cus.on('click', '.cus-del', function () {
    var i = 0, l = od.length, s = false;
    if (!!--l) {
        if (l === 1) s = true;
        $(this).parents('.cus-chd')[0].outerHTML = '';
        while (!!l--) {
             od[l].innerText = ++i;
             k = od[l].innerText;
             serialNumber[l].id="serialNumber"+(i-1);
             itemNumber[l].id="itemNumber"+(i-1);
             chItemName[l].id="chItemName"+(i-1);
             hscode[l].id="hscode"+(i-1);
             model[l].id="model"+(i-1);
             number[l].id="number"+(i-1);
             unit[l].id="unit"+(i-1);
             price[l].id="price"+(i-1);
             totalPrice[l].id="totalPrice"+(i-1);
             currency[l].id="currency"+(i-1);
             netWeight[l].id="netWeight"+(i-1);
             domesticSourceOfGoods[l].id="domesticSourceOfGoods"+(i-1);
             note[l].id="note"+(i-1);
        }
        if (s) del[0].className += ' dn'
    }
});
})
</script>
</body>
</html>
