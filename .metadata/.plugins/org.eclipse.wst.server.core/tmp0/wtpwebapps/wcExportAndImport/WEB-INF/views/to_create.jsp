<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String username = request.getSession().getAttribute("userName").toString();
/* 	String isTrue=request.getSession().getAttribute("isTrue").toString();
	String isFalse=request.getSession().getAttribute("isFalse").toString(); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--创建订单页面-->
<title><spring:message code="createOrder" /></title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/to_create.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
<script type="text/javascript" src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<link rel="stylesheet" href="<%=path%>/css/jquery_ui.css">
<script src="<%=path%>/js/jquery_ui.js"></script>
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
</style>
<body>
	<!-- 导航栏 -->
<%@ include file="basebar/myorderbar.txt" %>
	<!--
	时间：2018-02-06
	描述：网站主体开始
-->
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="createto_create createbatch_upload active"><a
					href="<%=path%>/my_orders/to_create.html"><spring:message
							code="createOrder" /></a></li>
				<li
					class="managementinfo_received managementshipment_received managementon_delivery
				managementdraft managementshipped managementpicked_up managementdelivered">
					<a href="<%=path%>/orderManage/draft.html"><spring:message
							code="orderManager" /></a>
				</li>
				<li class="order_problemindex"><a
					href="<%=path%>/my_order/order_problem.html"><spring:message
							code="errOrder" /></a></li>

				<!-- 			<li class="ordinary_mailindex">< a href="/order/my_order/ordinary_mail/index">平邮订单</ a></li>  -->
				<li class="searchindex"><a
					href="<%=path%>/queryOrder/toquery.html"><spring:message
							code="queryOrder" /></a></li>
				<li class="searchindex"><a href="<%=path%>/print/printMD.html"><spring:message
							code='print.printMD' /></a></li>
				<%-- <li class="searchindex"><a
					href="<%=path%>/orderZf/orderZf.html"><spring:message
							code='PaymentOfFreight' /></a></li> --%>
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
								href="<%=path%>/my_orders/to_create.html"><spring:message
										code="create" /></a></li>
							<li role="presentation"><a
								href="<%=path%>/my_orders/upload.html"><spring:message
										code="messupload" /></a></li>
						</ul>

						<div class="tab-content">
							<div class="tab-pane active">
								<br />
								<br />
								<form action="" id="to_create" method="post" autocomplete="off">
									<div class="col-lg-12 col-xs-12 col-lg-pull-1">
										<div class="row">
											<div class="col-lg-5 col-xs-12 blue col-md-offset-1"
												style="text-align: center;">
												<spring:message code="create.information" />
											</div>
										</div>

										<!--目的地国家和运输方式		-->
										<div class="container-fluid ztck_input">
											<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;"><span
															style="color: red; text-align: right;">*</span>
														<spring:message code="toOrder.Destinat" /></label>
														<div class="col-sm-7 " style="padding-left: 5px;">
															<input class="form-control" type="text" id="zt_country"
																autoComplete='off' name="consigneeCountry" value="">
															<div>
																<span id="PromptConsigneeCountry"
																	style="color: red; display: none;">不能为空</span>
															</div>
														</div>
														<div class="container-fluid col-md-6 col-xs-12 zt_li"
															id="zt_countryTabs" tabindex="1"
															style="width: 550px; display: none; border: solid #C4E2F7 1px; background-color: #FFFFFF;">
															<ul class="nav nav-tabs">
																<li role="presentation" class="active zt_li"><a
																	href="#destinationCountryName-dialog-countryTabs-1"
																	data-toggle="tab">ABCDE</a></li>
																<li role="presentation" class="zt_li"><a
																	href="#destinationCountryName-dialog-countryTabs-2"
																	data-toggle="tab">FGHIJ</a></li>
																<li role="presentation" class="zt_li"><a
																	href="#destinationCountryName-dialog-countryTabs-3"
																	data-toggle="tab">KLM</a></li>
																<li role="presentation" class="zt_li"><a
																	href="#destinationCountryName-dialog-countryTabs-4"
																	data-toggle="tab">NOPQRS</a></li>
																<li role="presentation" class="zt_li"><a
																	href="#destinationCountryName-dialog-countryTabs-5"
																	data-toggle="tab">TUVWXYZ</a></li>
															</ul>
															<div class="tab-content">
																<div class="tab-pane  active"
																	id="destinationCountryName-dialog-countryTabs-1">
																	<c:forEach items="${a_e}" var="a">
																		<div class="col-lg-4 url_div">
																			<a
																				class="url-product country layui-btn layui-btn-primary "
																				href="javascript: void(0);" title="${a.dq}"
																				data-code="${a.name}"
																				style="text-decoration: none; border: 0px">${a.name}</a>
																		</div>
																	</c:forEach>
																</div>
																<div class="tab-pane"
																	id="destinationCountryName-dialog-countryTabs-2">
																	<c:forEach items="${f_j}" var="f">
																		<div class="col-lg-4 url_div">
																			<a
																				class="url-product country layui-btn layui-btn-primary "
																				href="javascript: void(0);" title="${f.dq}"
																				data-code="${f.name}"
																				style="text-decoration: none; border: 0px">${f.name}</a>
																		</div>
																	</c:forEach>
																</div>
																<div class="tab-pane"
																	id="destinationCountryName-dialog-countryTabs-3">
																	<c:forEach items="${k_n}" var="k">
																		<div class="col-lg-4 url_div">
																			<a
																				class="url-product country layui-btn layui-btn-primary "
																				href="javascript: void(0);" title="${k.dq}"
																				data-code="${k.name}"
																				style="text-decoration: none; border: 0px">${k.name}</a>
																		</div>
																	</c:forEach>
																</div>
																<div class="tab-pane"
																	id="destinationCountryName-dialog-countryTabs-4">
																	<c:forEach items="${n_s}" var="n">
																		<div class="col-lg-4 url_div">
																			<a
																				class="url-product country layui-btn layui-btn-primary "
																				href="javascript: void(0);" title="${n.dq}"
																				data-code="${n.name}"
																				style="text-decoration: none; border: 0px">${n.name}</a>
																		</div>
																	</c:forEach>
																</div>
																<div class="tab-pane"
																	id="destinationCountryName-dialog-countryTabs-5">
																	<c:forEach items="${t_z}" var="t">
																		<div class="col-lg-4 url_div">
																			<a
																				class="url-product country layui-btn layui-btn-primary "
																				href="javascript: void(0);" title="${t.dq}"
																				data-code="${t.name}"
																				style="text-decoration: none; border: 0px">${t.name}</a>
																		</div>
																	</c:forEach>
																</div>

															</div>

														</div>
													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;"><span
															style="color: red; text-align: right;">*</span>
														<spring:message code="create.product" /></label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<input class="form-control" type="text" id="transport"
																name="transport" readonly="readonly" value="">
															<div>
																<span id="Prompttransport"
																	style="color: red; display: none;">不能为空</span>
															</div>
														</div>

														<div class="container-fluid col-md-6 col-xs-12 zt_li"
															id="zt_shipping" tabindex="1"
															style="width: 550px; display: none; border: solid #C4E2F7 1px; background-color: #FFFFFF;">
															<ul class="nav nav-tabs">
																<li role="presentation" class="active zt_li"><a
																	href="#shippingTabs-1" data-toggle="tab">热门产品</a></li>
															</ul>
															<div class="tab-content">
																<div class="tab-pane active" id="shippingTabs-1">
																</div>

															</div>

														</div>
													</div>

												</div>
											</div>

										</div>
										<!--
                        	客户单号和重量(kg)
                        -->
										<div class="container-fluid ztck_input">
											<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;"><span
															style="color: red; text-align: right;">*</span>
														<spring:message code="create.orderNo" /></label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<input class="form-control" type="text" id="orderNo"
																name="orderNo" value="">
															<div>
																<span id="PromptOrderNo" style="color: red;"></span>
															</div>
														</div>
													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;"><span
															style="color: red; text-align: right;">*</span>
														<spring:message code="create.weight" /></label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<input class="form-control" type="text"
																name="grossWeight" id="grossWeight" value=""><span
																id="weighteRRE" style="color: red; display: none;"></span>
														</div>
													</div>
												</div>
											</div>

										</div>

										<!--
                        	描述：是否带电池与货物类型
                        -->
										<div class="container-fluid ztck_input">
											<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;"><spring:message
																code="create.battery" /></label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<div class="radio" style="margin-top: 6px;">
																<label> <input type="radio" name="battery"
																	value="1">
																<spring:message code="create.Yes" />
																</label> <label> <input type="radio" name="battery"
																	value="0" checked="checked">
																<spring:message code="create.No" />
																</label>
															</div>
														</div>
													</div>
												</div>

												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div class="col-lg-12">
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;"><span
															style="color: red; text-align: right;">*</span>体积(CM):</label>
														<div class="col-sm-2" style="padding-left: 5px;">
															<input class="form-control" style="margin-left: -5px"
																type="text" name="olength" id="olength" placeholder="长"
																value="">
														</div>
														<div class="col-sm-2" style="padding-left: 5px;">
															<input class="form-control" style="margin-left: -5px"
																type="text" name="owidth" id="owidth" placeholder="宽"
																value="">
														</div>
														<div class="col-sm-2" style="padding-left: 5px;">
															<input class="form-control" style="margin-left: -5px"
																type="text" name="oheight" id="oheight" placeholder="高"
																value="">
														</div>
													</div>
													<div class="col-lg-5 col-md-offset-4 container-fluid">
														<span id="volume"
															style="color: red; display: none; margin-left: 5px">请填写完整</span>
														<span id="volume2"
															style="color: red; display: block; margin-left: 5px"></span>
													</div>

												</div>
											</div>
										</div>


										<!--
                        	揽收类型
                        -->
										<div class="container-fluid ztck_input">
											<div class="row">
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;">揽收类型:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<div class="radio" style="margin-top: 6px;">
																<label> <input type="radio" name="clcttype"
																	id="clcttype" value="1">上门揽收
																</label> <label> <input type="radio" name="clcttype"
																	id="clcttype" checked="checked" value="0">用户自送
																</label>
															</div>
														</div>
													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;"><span
															style="color: red; text-align: right;">*</span>
														<spring:message code="create.shipment" /></label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<div class="radio" style="margin-top: 6px;">
																<label id="baog"> <input type="radio"name="goodsTpye" id="baogint" checked="checked"value="包裹">包裹
																</label> <label id="wenj"> <input type="radio"
																	name="goodsTpye" id="wenjint" value="文件">文件
																</label> <label id="dah"> <input type="radio"
																	name="goodsTpye" id="dahint" value="大货">大货
																</label>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<!--品类  -->
										<div class="container-fluid ztck_input">
											<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;"><span
															style="color: red; text-align: right;">*</span>
														是否投保:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<div class="radio" style="margin-top: 6px;">
															<%-- <c:if test='<%=isTrue.equals("1")%>'> --%>
																<label id="shi"> <input type="radio"name="isPreM" id="isPreM1" checked="checked"value="1">是
																</label> 
																<%-- </c:if> --%>
																<%-- <c:if test='<%=isFalse.equals("1")%>'> --%>
																<label id="fou"> <input type="radio" name="isPreM" id="isPreM2" value="2">否
																</label> 
																<%-- </c:if> --%>
															</div>
														</div>
													</div>
												</div>
												<div class="col-lg-5 col-xs-12 col-md-offset-1">
													<div>
														<label class="col-lg-4"
															style="padding-top: 6px; text-align: right;"><span
															style="color: red; text-align: right;">*</span>品类:</label>
														<div class="col-sm-7" style="padding-left: 5px;">
															<select class="form-control category" name="category"
																id="category">
																<option value="" id="pinId">请选择</option>
																<c:forEach items="${plist}" var="pin">
																	<option value="${pin.code}">${pin.name}</option>
																</c:forEach>
															</select> <span id="logcategory"
																style="color: red; display: none;">不能为空</span>
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
															style="padding-top: 6px; text-align: right;"><span
															style="color: red; text-align: right;">*</span>货值(元):</label>
														<div class="col-sm-7" style="padding-left: 5px;">
														<input class="form-control" type="text" id="premiumPrice"
																name="premiumPrice" value="" onkeyup="value=value.replace(/[^\d.]/g,'')">
															 <span id="logpremiumPrice"
																style="color: red; display: none;">不能为空</span>
														</div>
													</div>
												</div>
                                            </div>
                                        </div>
										<!--收件人信息开始-->
										<div class="col-lg-12 col-xs-12">
											<div class="row">
												<div class="col-lg-5 col-xs-12 blue col-md-offset-1"
													style="text-align: center;">
													<spring:message code="create.consignee" />
												</div>
											</div>

											<!--姓名和公司		-->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><span
																style="color: red; text-align: right;">*</span>
															<spring:message code="create.name" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" id="consignee" type="text"
																	name="consignee" value="">
																<div>
																	<span id="Promptconsignee"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><spring:message
																	code="create.company" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" id="consigneeCompany"
																	name="consigneeCompany" value="">
																	<div>
																	<span id="PromptconsigneeCompany"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>
											<!--
                        	省/州和城市
                        -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><span
																style="color: red; text-align: right;">*</span>
															<spring:message code="create.province" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	id="consigneeContinent" name="consigneeContinent"
																	value="">
																<div>
																	<span id="PromptConsigneeContinent"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><span
																style="color: red; text-align: right;">*</span>
															<spring:message code="create.city" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	id="consigneeCity" name="consigneeCity" value="">
																<div>
																	<span id="PromptConsigneeCity"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>

											<!--
                        	邮编和电话
                        -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><span
																style="color: red; text-align: right;">*</span>
															<spring:message code="create.Postal" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" id="postCode"
																	name="postCode" value="">
																<div>
																	<span id="PromptPostCode" style="color: red;"></span><span
																		id="PromptPostnonull" style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><span
																style="color: red; text-align: right;">*</span>
															<spring:message code="create.Tel" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	id="consigneeTel" name="consigneeTel" value="">
																<div>
																	<span id="PromptConsigneeTel"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>
											<!--
                        	税号和买家id
                        -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;">
																<!-- <span style="color: red; text-align: right;">*</span> -->
																<spring:message code="create.taxNumber" />
															</label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="taxNumber"
																	id="taxNumber" value="">
																<div>
																	<!-- <span id="PrompttaxNumber" style="color: red;"></span> -->
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><spring:message
																	code="create.BuyerID" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text" name="buyerID"
																	value="">
															</div>
														</div>
													</div>
													<%-- <div class="col-lg-5 col-xs-12 col-md-offset-1">
				<div>
			<label class="col-lg-4" style=" padding-top: 6px; text-align: right;"><spring:message code="create.addressType" /></label>
			<div class="col-sm-7" style=" padding-top: 6px;padding-left: 5px;" >
			<input type="radio" name="ymx" value="1" checked="checked"><spring:message code="create.ymxp" />
					<input type="radio" name="ymx" value="2"><spring:message code="create.ymxc" />
					<input type="radio" name="ymx" value="3"><spring:message code="create.other" />
		</div>
			</div>
					</div>  --%>
													<%-- <div class="col-lg-5 col-xs-12 col-md-offset-1" >
				<div>
			<label class="col-lg-4" style=" padding-top: 6px; text-align: right;" ><spring:message code="create.EORI" /></label>
			<div class="col-sm-7" style="padding-left: 5px;" >
			<input  class="form-control" type="text" name="eori" value="">
		</div>
			</div>
					</div> --%>
												</div>

											</div>
											<!--
                        	买家ID和邮箱
                        -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><span
																style="color: red; text-align: right;">*</span>
															<spring:message code="create.address" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<textarea class="form-control" id="consigneeAddress"
																	name="consigneeAddress"></textarea>
																<div>
																	<span id="PromptConsigneeAddress"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>

													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><spring:message
																	code="create.Email" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" type="text"
																	name="consigneeEmail" value="">
															</div>
														</div>
													</div>
												</div>

											</div>

											<!--
                        	详细地址
                        -->
											<div class="container-fluid ztck_input">
												<div class="row"></div>
											</div>

										</div>
										<!--发件人信息开始-->
										<div class="col-lg-12 col-xs-12">
											<div class="row">
												<div class="col-lg-5 col-xs-12 blue col-md-offset-1"
													style="text-align: center;">
													<spring:message code="create.shipper" />
													<button type="button"
														class="layui-btn layui-btn-normal layui-btn-xs"
														id="zt_sender">
														<span class="glyphicon glyphicon-th-list"><spring:message
																code="create.choose" /></span>
													</button>
												</div>
											</div>
											<!--姓名和公司		-->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><spring:message
																	code="create.name" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" id="shipperName" type="text"
																	name="shipperName" value="">
																		<div>
																	<span id="PromptshipperName"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><spring:message
																	code="create.company" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" id="shipperCompany"
																	type="text" name="shipperCompany" value="">
																		<div>
																	    <span id="PromptshipperCompany"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>
											<!--
                        	省/州和城市
                        -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><spring:message
																	code="create.province" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" id="shipperContinent"
																	type="text" name="shipperContinent" value="">
																		<div>
																	    <span id="PromptshipperContinent"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><spring:message
																	code="create.city" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" id="shipperCity" type="text"
																	name="shipperCity" value="">
																	<div>
																	    <span id="PromptshipperCity"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>

											<!--
                        	邮编和电话
                        -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><spring:message
																	code="create.Postal" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" id="shipperCode" type="text"
																	name="shipperCode" value="">
																	<div>
																	<span id="PromptshipperCode"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><span
																style="color: red; text-align: right;">*</span>
															<spring:message code="create.Tel" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<input class="form-control" id="shipperTel" type="text"
																	name="shipperTel" value="">
																<div>
																	<span id="PromptShipperTel"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>

											<!--
                        	详细地址
                        -->
											<div class="container-fluid ztck_input">
												<div class="row">
													<div class="col-lg-5 col-xs-12 col-md-offset-1">
														<div>
															<label class="col-lg-4"
																style="padding-top: 6px; text-align: right;"><spring:message
																	code="create.address" /></label>
															<div class="col-sm-7" style="padding-left: 5px;">
																<textarea class="form-control" id="shipperAddress"
																	name="shipperAddress"></textarea>
																	<div>
																	    <span id="PromptshipperAddress"
																		style="color: red;"></span>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<!--海关申报品-->
										<div class="col-lg-10 col-xs-12 col-lg-offset-2">
											<div class="row">
												<div class="col-lg-5 col-xs-12 blue col-lg-pull-1"
													style="text-align: center;">
													<spring:message code="create.item" />
													<button type="button"
														class="layui-btn layui-btn-normal layui-btn-xs"
														id="zt_addhai">
														<span class="glyphicon glyphicon-plus "><spring:message
																code="create.add" /></span>
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
															<span class="glyphicon glyphicon-th-list"><spring:message
																	code="create.choose" /></span>
														</button>
													</div>
													<div class="row ztck_input">
														<div class="col-lg-3 col-xs-12">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;"><spring:message
																		code='create.EName' /></label>
																<div class="col-lg-6" style="padding-left: 5px;">
																	<input class="form-control eName" type="text" value=""
																		name="">
																</div>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;"><spring:message
																		code='create.CName' /></label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control itemName" type="text"
																		value="" name="">
																</div>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;"><span
																	style="color: red; text-align: right;">*</span>
																<spring:message code='create.Price' /></label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control unitPrice" type="text"
																		value="" name="" onkeyup="value=value.replace(/[^\d.]/g,'')">
																</div>
															</div>
															<div class="col-lg-4" style="display: none;">
																<select class="form-control">
																	<option>USD</option>
																</select>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12  ">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;"><span
																	style="color: red; text-align: right;">*</span><spring:message
																		code='create.Quantity' /></label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control goodsAmount" type="text"
																		value="1" name="">
																</div>
															</div>
															<div class="col-lg-4" style="padding: 0; display: none;">
																<select class="form-control">
																	<option>件</option>
																	<option>套</option>
																	<option>打</option>
																	<option>公斤</option>
																	<option>米</option>
																	<option>双</option>
																	<option>单个</option>
																	<option>吨</option>
																	<option>箱</option>
																</select>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-3 col-xs-12 ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;"><spring:message
																		code='create.HSCode' /></label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control customsnumber" type="text"
																		value="" name="">
																</div>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12  ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;"><span
																	style="color: red; text-align: right;">*</span><spring:message
																		code="create.netweight" /></label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control netWeight" type="text"
																		value="" name="">
																</div>
															</div>
														</div>
														<div class="col-lg-3 col-xs-12 ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;"><spring:message
																		code='create.Note' /></label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control remarks" type="text" name=""
																		value="">
																</div>
															</div>
														</div>

														<div class="col-lg-3 col-xs-12  ztck_input">
															<div>
																<label class="col-lg-6"
																	style="padding-top: 6px; text-align: right;">URL:</label>
																<div class="col-sm-6" style="padding-left: 5px;">
																	<input class="form-control url" type="text" value=""
																		name="">
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
												<spring:message code="create.save" />
											</button>
										</div>

									</div>
								</form>

								<!--<div class="col-lg-5 col-xs-12">4</div>
					-->
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>


	<script>
/**目的地国家搜索功能
 * Autocomplete插件
 */
  $(function() {
	  var availableTags=[];
	  $.ajax({
  		type:"POST",
  		url:"<%=path%>/my_orders/getBycounry.do",
  		success:function(msg){
  			for (var i = 0; i < msg.length; i++) {
  				availableTags[i]=msg[i];
			}
  		}
	  });
	
    function split( val ) {
      return val.split( /,\s*/ );
    }
    function extractLast( term ) {
      return split( term ).pop();
    }
 
    $( "#zt_country" )
      // 当选择一个条目时不离开文本域
      .bind( "keydown", function( event ) {
        if ( event.keyCode === $.ui.keyCode.TAB &&
            $( this ).data( "ui-autocomplete" ).menu.active ) {
          event.preventDefault();
        }
        $("#zt_countryTabs").css("display","none");
      })
      .autocomplete({
        minLength: 0,
        source: function( request, response ) {
          // 回到 autocomplete，但是提取最后的条目
          response( $.ui.autocomplete.filter(
            availableTags, extractLast( request.term ) ) );
        },
        focus: function() {
          // 防止在获得焦点时插入值
          return false;
        },
        select: function( event, ui ) {
          var terms = split( this.value );
         
          // 移除当前输入
          terms.pop();
          // 添加被选项
          terms.push( ui.item.value );
          // 添加占位符，在结尾添加逗号+空格
          terms.push( "" );
          var a = terms.join( "" );
          var b =a.split("(");
          this.value=b[0];
     	 //每次选择都清空运输方式input的值
     	 $("#transport").val("");
     	 $("#grossWeight").val("");
          return false;
        }
      });
  });
  </script>
</head>
<body>


	<!--
	时间：2018-02-06
	描述：主体结束
-->


	<!--
	时间：2018-02-06
	描述：网站尾部
-->

	<div class="container">
		<div class="row">
			<div class="col-lg-offset-3"></div>
		</div>

	</div>
	<script type="text/javascript">
	layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function(){
        var laydate = layui.laydate, //日期
            laypage = layui.laypage, //分页
            layer = layui.layer, //弹层
            table = layui.table, //表格
            carousel = layui.carousel, //轮播
            upload = layui.upload, //上传
            element = layui.element; //元素操作
          //海关申报品的单击事件
        	 $("#customs").on('click','button',function(){
        		  var note=$(this).parent().find($(".cus-od")).text();
        		 layer.open({
		        	   type: 1,
		        	   title: '海关申报品',
		        	   area: ['900px', '600px'],
		        	   skin: 'yourclass',
		        	   content: $('#f_declare'),
		        	   btn: ['确定', '取消']
		        	   ,yes: function(index){
		        		   var checkStatus = table.checkStatus('queryOrders');
						      var data = checkStatus.data;
						      var length=data.length;
						     if(length==1){
						    	 var i=note-1;
							    	$("input[name='outSkus["+i+"].eName']").val(data[0].eName);
							    	$("input[name='outSkus["+i+"].itemName']").val(data[0].cName);
							    	$("input[name='outSkus["+i+"].unitPrice']").val(data[0].price);
							    	$("input[name='outSkus["+i+"].customsnumber']").val(data[0].goodsNum);
							    	$("input[name='outSkus["+i+"].netWeight']").val(data[0].netWeight);
							    	$("input[name='outSkus["+i+"].remarks']").val(data[0].deliveryNote);
							    	$("input[name='outSkus["+i+"].url']").val(data[0].declareUrl);
							    	 layer.close(index);
					           }else{
						    	 layer.msg("请选择一条数据！",{icon:2});
					           }
		        		  }
		        	 });
        		    table.render({
        		        elem: '#t_declare',
        		        url:'<%=path%>/declare/findAll.do',
        		        page: true,
        		        method:'post',
        		        height:450,
        		        limit:200,
        	            limits:[200,500,1000],
        		        id: 'queryOrders',
        		        cols: [[
        		            {field : 'id',checkbox : true,align : 'center'},
        		            {field:'eName',  title: '<spring:message code='declare.DeclaredNameEN'/>',align :'center'},
        		            {field:'cName',  title: '<spring:message code='declare.DeclaredNameCN'/>',align :'center'},
        		            {field:'price', title: '<spring:message code='declare.UnitPrice'/>',align :'center'},
        		            {field:'netWeight',  title: '<spring:message code='declare.PickupName'/>',align :'center'},
        		            {field:'deliveryNote',  title: '<spring:message code='declare.PictupNote'/>',align :'center'},
        		            {field:'goodsNum',  title: '<spring:message code='declare.Code'/>',align :'center' },
        		            {field:'declareUrl',  title: '<spring:message code='declare.Declaredurl'/>',align :'center'},
        		        ]]
        		    }); 
        	  })
        	  //点击选择发件人，弹窗显示数据表格
              $("#zt_sender").click(function(){
          		layer.open({
          			type: 1,
          			title:"选择发件人",
          			area:['900px', '600px'],
          			content:$('#sender'),
          			btn: ['保存', '取消'],
          			yes: function(index){
          				 var checkStatus = table.checkStatus('senderTable'); //获取表格选中数据的值  数组
          	        	 var data=checkStatus.data;
          				 //console.log(data);
          	        	 if(checkStatus.data.length!=1){
          	        		 layer.msg("请选择一条数据",{icon:2});
          	        		 return false;
          	        	 }else{
          	        		 $("#shipperName").val(data[0].shipperName);
          	        		 $("#shipperCompany").val(data[0].shipperCompany);
          	      		     $("#shipperTel").val(data[0].shipperTel);
          	      		     $("#shipperContinent").val(data[0].shipperContinent);
          	      		     $("#shipperCity").val(data[0].shipperCity);
          	      		     $("#shipperAddress").val(data[0].shipperAddress);
          	      		     $("#shipperCode").val(data[0].shipperCode);
          	      		     layer.close(index);
          			}
          			}
          		});
          		table.render({
          			  id:'senderTable',
          	          elem: '#sender_table'
          	          ,height:450
                      ,url:'<%=path%>/sender/SenderAll.do?backstage=0'
                      ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                          layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                          ,curr: 1 //设定初始在第 5 页
                          ,groups: 1 //只显示 1 个连续页码
                      }
                      ,method:'post'
                      ,cols: [[
                          {field:'id',checkbox:true,align : 'center'}
                          ,{field:'shipperName', title: '<spring:message code="sender.ShipperName"/>',align : 'center'}
                          ,{field:'shipperCompany', title: '<spring:message code="sender.Company"/>',align : 'center'}
                          ,{field:'shipperTel', title: '<spring:message code="sender.Tel"/>',align : 'center'}
                          ,{field:'shipperContinent',title: '<spring:message code="sender.Province/State"/>',align : 'center'}
                          ,{field:'shipperCity', title: '<spring:message code="sender.City"/>',align : 'center'}
                          ,{field:'shipperAddress', title: '<spring:message code="sender.Street"/>',align : 'center'}
                          ,{field:'shipperCode', title: '<spring:message code="sender.Postcode"/>',align : 'center'}
                          ,{field:'state',  title: '<spring:message code="sender.Default"/>',align : 'center'}
                      ]]
                      ,done:function(res,page,count){
                      	$("[data-field='state']").children().each(function(){  
                      		 if($(this).text()=='0'){  
                                   $(this).text("否"); 
                                }else if($(this).text()=='1'){  
                              	 $(this).text("");  
                                   $(this).append('<span class="glyphicon glyphicon-ok-circle" style="color: #1E9FFF;"></span>')  
                                }
                      	})
                      }
                  });
                      
          	});  
          
  /*       		//清理代码
        		function clear(){
        			   //每次点击添加的时候将input清空
        		   	 $("input[type='text']").val("");   
        		     $("textarea").val("");
        		} */
            });
	//鼠标滑过显示
	$(function () {
		 /**清理*/
		  clear();
		
	var consigneeCountry;
  /*   $(".dropdown").mouseover(function () {
        $(this).addClass("open");
    });

    $(".dropdown").mouseleave(function(){
        $(this).removeClass("open");
    }); */
    //给海关申报品赋name值
    $(".eName").attr("name","outSkus[0].eName");
    $(".itemName").attr("name","outSkus[0].itemName");
    $(".unitPrice").attr("name","outSkus[0].unitPrice");
    $(".goodsAmount").attr("name","outSkus[0].goodsAmount");
    $(".customsnumber").attr("name","outSkus[0].customsnumber");
    $(".netWeight").attr("name","outSkus[0].netWeight");
    $(".remarks").attr("name","outSkus[0].remarks");
    $(".url").attr("name","outSkus[0].url");
    /**
     * 添加 删除 海关申报品 功能
     * author : 聪
     * time : 2018/2/28 13:25:07
     */
    var cus = $('#customs'), chd = $('.cus-chd'),
        eName=document.getElementsByClassName('eName'),
        itemName=document.getElementsByClassName('itemName'),
        unitPrice=document.getElementsByClassName('unitPrice'),
        goodsAmount=document.getElementsByClassName('goodsAmount'),
        customsnumber=document.getElementsByClassName('customsnumber'),
        netWeight=document.getElementsByClassName('netWeight'),
         remarks=document.getElementsByClassName('remarks'),
        url=document.getElementsByClassName('url'),
        od = document.getElementsByClassName('cus-od'),
        del = document.getElementsByClassName('cus-del');
    $('#zt_addhai').click(function () {
        if(od.length === 1) del[0].className = 'cus-del glyphicon glyphicon-minus-sign';
        cus[0].insertAdjacentHTML('afterbegin', chd[0].outerHTML);
        od[0].innerText = ~~od[1].innerText + 1;
        var i = od[0].innerText-1;
        eName[0].name="outSkus["+i+"].eName";
        itemName[0].name="outSkus["+i+"].itemName";
        unitPrice[0].name="outSkus["+i+"].unitPrice";
        goodsAmount[0].name="outSkus["+i+"].goodsAmount";
        customsnumber[0].name="outSkus["+i+"].customsnumber";
        netWeight[0].name="outSkus["+i+"].netWeight";
        remarks[0].name="outSkus["+i+"].remarks";
        url[0].name="outSkus["+i+"].url";
    });
    cus.on('click', '.cus-del', function () {
        var i = 0, l = od.length, s = false;
        if (!!--l) {
            if (l === 1) s = true;
            $(this).parents('.cus-chd')[0].outerHTML = '';
            while (!!l--) {
                 od[l].innerText = ++i;
            	 eName[l].name="outSkus["+(i-1)+"].eName";
            	 itemName[l].name="outSkus["+(i-1)+"].itemName";
            	 unitPrice[l].name="outSkus["+(i-1)+"].unitPrice";
            	 goodsAmount[l].name="outSkus["+(i-1)+"].goodsAmount";
            	 customsnumber[l].name="outSkus["+(i-1)+"].customsnumber";
            	 netWeight[l].name="outSkus["+(i-1)+"].netWeight";
            	 remarks[l].name="outSkus["+(i-1)+"].remarks";
            	 url[l].name="outSkus["+(i-1)+"].url";
            }
            if (s) del[0].className += ' dn'
        }
    });
    
    
    //点击保存
    
    $("#to_add").click(function(){
      	var grossWeight=$("#grossWeight").val();
    	var zt_country=$("#zt_country").val();
    	var transport=$("#transport").val();
    	var consignee=$("#consignee").val();
    	var orderNo =$("#orderNo").val();
    	var consigneeContinent=$("#consigneeContinent").val();
    	var consigneeCity=$("#consigneeCity").val();
    	var postCode=$("#postCode").val();
    	var shipperTel=$("#shipperTel").val();
    	var shipperName=$("#shipperName").val();
    	var shipperCompany=$("#shipperCompany").val();
    	var shipperContinent=$("#shipperContinent").val();
    	var shipperCity=$("#shipperCity").val();
    	var shipperAddress=$("#shipperAddress").val();
    	var consigneeTel=$("#consigneeTel").val();
    	var PromptPostCode= $("#PromptPostCode").text();
    	var consigneeAddress=$("#consigneeAddress").val();
    	var PromptPostnonull=$("#PromptPostnonull").html();
    	var olength=$("#olength").val();
    	var owidth=$("#owidth").val();
    	var oheight=$("#oheight").val();
    	 var category=$("#category").val();
    	 var premiumPrice=$("#premiumPrice").val();
    	 var isPreM = $("input[name='isPreM']:checked").val();
    	 if(PromptPostnonull!=""){
    		 layer.alert(PromptPostnonull,{icon:2,time: 3000});
				return false;
    	 }
    	 if(isPreM==1){
    		 if(premiumPrice==""||premiumPrice==null){
    	   		 $("#logpremiumPrice").css("display","block");
    	   		 return false;
    	   	 }else{
    	   		 $("#logpremiumPrice").css("display","none");
    	   	 }
    	 }
    	if(/[\u4E00-\u9FA5]/.test(orderNo)){
    		 $("#PromptOrderNo").text("不能输入汉字");
    		 layer.msg('请查看数据是否输入正确',{icon:2});  
    		 return false;
    		 /* var PrompttaxNumber = $("#PrompttaxNumber").val(); */
    	}else if(/[\u4E00-\u9FA5]/.test(consignee)){
    		 $("#Promptconsignee").text("不能输入汉字");
    		 layer.msg('请查看数据是否输入正确',{icon:2});  
    		 return false;
    	}else if(/[\u4E00-\u9FA5]/.test(shipperName)){
    		 $("#PromptshipperName").text("不能输入汉字");
    		 layer.msg('请查看数据是否输入正确',{icon:2});  
    		 return false;
    	}else if(/[\u4E00-\u9FA5]/.test(consigneeContinent)){
	   		 $("#PromptConsigneeContinent").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(/[\u4E00-\u9FA5]/.test(consigneeCity)){
	   		 $("#PromptConsigneeCity").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(/[\u4E00-\u9FA5]/.test(consigneeTel)){
	   		 $("#PromptConsigneeTel").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(/[\u4E00-\u9FA5]/.test(consigneeAddress)){
	   		 $("#PromptConsigneeAddress").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(/[\u4E00-\u9FA5]/.test(consigneeCompany)){
	   		 $("#PromptconsigneeCompany").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(/[\u4E00-\u9FA5]/.test(shipperContinent)){
	   		 $("#PromptshipperContinent").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(/[\u4E00-\u9FA5]/.test(shipperCity)){
	   		 $("#PromptshipperCity").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(/[\u4E00-\u9FA5]/.test(shipperCode)){
	   		 $("#PromptshipperCode").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(/[\u4E00-\u9FA5]/.test(shipperAddress)){
	   		 $("#PromptshipperAddress").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(/[\u4E00-\u9FA5]/.test(shipperTel)){
	   		 $("#PromptshipperTel").text("不能输入汉字")
	   		  layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if(consignee.length<4){
	   		 $("#Promptconsignee").text("长度应大于三");
	   	     layer.msg('请查看数据是否输入正确',{icon:2});  
	   		 return false;
	   	 }else if (zt_country == "" || zt_country == null
										|| transport == "" || transport == null
										|| consignee == "" || consignee == null
										|| consigneeContinent == ""
										|| consigneeContinent == null
										|| consigneeCity == ""
										|| consigneeCity == null
										|| postCode==null
										|| postCode==""
										|| orderNo == "" 
										|| orderNo == null
										|| shipperTel == ""
										|| shipperTel == null
										|| consigneeTel == ""
										|| consigneeTel == null
										|| consigneeAddress == ""
										|| consigneeAddress == null
										|| grossWeight == null
										|| grossWeight == ''
										|| olength==""
										|| olength==null
										|| owidth==""
										|| owidth==null
										|| oheight==""
										|| oheight==null
										|| category==null
										|| category==""
										/* || PrompttaxNumber=="普通税号应为6-10位" */
										) {
			 					layer.alert("带红色星号的必填项请填写完整",{icon:2,time: 3000});
									return false;
								}
    							 $("#volume2").css("display","none");
								var obj = $("#to_create").serializeJson();
								var index=layer.load();
								console.log(obj);
								$.post('<%=path%>/my_orders/to_add.do',obj,
    							function(msg){
		    					if(msg.result==1){
								layer.msg('添加成功',{icon:1});
								document.location.reload();//因为加了遮罩，添加成功不能刷新页面，于是手动刷新					    
								}else if(msg.result==2){
								  layer.msg(msg.msg,{icon:2});  
								  layer.close(index);
								 }else if(msg.result==3){
								   layer.msg('添加失败,内件订单数量过大或总价超过货值',{icon:2});  
								   layer.close(index);
								 }else if(msg.result==4){
									   layer.msg(msg.msg,{icon:2});  
									   layer.close(index);
									 }else if(msg.result==7){
										 layer.msg(msg.msg,{icon:2});  
										   layer.close(index);
									 }else{
								 layer.msg('添加失败',{icon:2}); 
								 layer.close(index);
								   }
    	})
    });


	//当鼠标放在弹出的a标签上的时候变色
    $(".url-product").mouseenter(function(){
    	$(this).removeClass("layui-btn layui-btn-primary");
    	$(this).addClass("layui-btn layui-btn-normal");
    });
      $(".url-product").mouseleave(function(){
    	$(this).removeClass("layui-btn layui-btn-normal");
    	$(this).addClass("layui-btn layui-btn-primary");
    });
   //点击国家地区弹出div框
     $("#zt_country").focus(function() {
    var div = document.getElementById('zt_countryTabs');
    if(div.style.display == "none") {
    	div.style.display = "block";
    	div.style.position = "absolute";
    	div.style.zIndex = "3",
    		div.style.top = document.getElementById('zt_country').style.top + 36 + "px";
    	div.style.left = "224px";
    } else {
    	div.style.display = "none";
    }
    });  
    
	 //当点击国家地区a标签以后赋值给input框
    $(".country").on("click",function(){
    	var zt_country=$(this).data('code');
    	$("#zt_country").val(zt_country);
    	 var div = document.getElementById('zt_countryTabs');
    	 div.style.display = "none";
    	 $("#zt_country").blur();
    	 //赋值给全局变量
    	 consigneeCountry=zt_country;
    	 //每次选择都清空运输方式input的值
    	 $("#transport").val("");
    	 $("#grossWeight").val("");
    });
    	
    $("#grossWeight").blur(function() {
   	 var transport=$("#transport").val();
 	 var grossWeight=$("#grossWeight").val();
   	 if(transport==""||transport==null){
   		$("#weighteRRE").html("先填写运输方式");
   		$("#weighteRRE").css("display","block");
   		$("#grossWeight").val("");
   		return false;
   	 }
   	 
   	 if(grossWeight==""||grossWeight==null){
   		$("#weighteRRE").html("重量必填");
   		 $("#weighteRRE").css("display","block");
   	 }else{
   	  	var reg =  /^\d+(\.\d+)?$/.test($("#grossWeight").val());
   		if(!reg) {
   			$("#weighteRRE").html("预报重量必须为正数");
   		 $("#weighteRRE").css("display","block");
   		}else{
   			$.post('<%=path%>/bjQudaoPrice/maxWeight.do',{grossWeight:grossWeight,transport:transport},
      		function(msg){
      			var date=eval('('+msg+')');
   			if(date.result==''){
   	   			$("#PromptPostCode").text("");
   	   		$.ajax({
   	    		type:"POST",
   	    		url:"<%=path%>/bjChannel/findType.do",
   	    		data:{transport:transport,grossWeight:grossWeight},
   	    		success:function(msg){
   	    			var date=eval('('+msg+')');
   	    			if(date.type!=""&&date.type!=null){
   	    				document.getElementById("wenjint").checked=true;
       				   // $("#wenjint").attr("checked","checked")
   	    				$("#wenj").prop("hidden",false); 
   	    				$("#baog").prop("hidden",false); 
   	    				$("#dah").prop("hidden",false); 
   	    			}else{
   		    			if(date.wenj==1){
   		    				document.getElementById("wenjint").checked=true;
   		    				//$("#wenjint").attr("checked","checked")
   		    				$("#wenj").prop("hidden",false); 
   		    			}else{
   		    				$("#wenj").prop("hidden",true); 
   		    			}
   						if(date.baog==1){
   							document.getElementById("baogint").checked=true;
   							//$("#baogint").attr("checked","checked");
   							$("#baog").prop("hidden",false); 
   		    			}else{
   		    				$("#baog").prop("hidden",true); 
   		    			}
   						if(date.dah==1){
   							document.getElementById("dahint").checked=true;
   							//$("#dahint").attr("checked","checked")
   							$("#dah").prop("hidden",false); 
   		    			}else{
   							$("#dah").prop("hidden",true); 
   		    			}
   	    		}
   	    		}
   	    	})
   	   			
   	   			
   	   			
   	   			
   			}else{
   				$("#grossWeight").val("");
   				$("#weighteRRE").html("订单超重，请联系客服");
      	   		$("#weighteRRE").css("display","block");
   			}
      		});
   			
   			
     		$("#weighteRRE").css("display","none");
   		}
   	 	/*  var flag = /^\+?[1-9][0-9]*$/.test(grossWeight);
   		
  		if(flag){
  			$("#weighteRRE").html("预报重量必须为整数");
  		} */
   	 }
    })
	
	 
    //点击运输方式弹出div框
    $("#transport").focus(function() {
    	//console.log(consigneeCountry);
    	var consigneeCountry2=$("#zt_country").val()
    	if(consigneeCountry2==null || consigneeCountry2==""){
    		$("#shippingTabs-1 div").remove();
    		$("#shippingTabs-1").prepend("<div class='col-lg-6 url_div_k'>请先选择目的地国家/地区! </div>");
    		Country=null;
    	}else{
    		$("#shippingTabs-1 div").remove();
    		$("#shippingTabs-1").prepend("<div class='col-lg-6'>加载中... </div>");
    	$.ajax({
    		type:"POST",
    		url:"<%=path%>/my_orders/getShipping.do",
    		data:{consigneeCountry:consigneeCountry2},
    		success:function(msg){
    			/*  $("#grossWeight").val("");
    			 $("#wenj").prop("hidden",true); 
    	    	 $("#baog").prop("hidden",true); 
    	    	 $("#dah").prop("hidden",true);  */
    			if(msg.length<1){
					//console.log("没有的话。值为："+consigneeCountry);
					$("#shippingTabs-1 div").remove();
					$("#shippingTabs-1").prepend("<div class='col-lg-6 url_div_k'>目的国家不通邮! </div>");
					Country=null;
    			}else{
    				//console.log("如果有。值为："+consigneeCountry);
    				$("#shippingTabs-1 div").remove();
    				for (var i = 0; i < msg.length; i++) {
    					$("#shippingTabs-1").prepend("<div class='col-lg-6 url_div1'><a class='url-product shipping layui-btn layui-btn-primary ' href='javascript: void(0);' title='"+msg[i].name+"' data-code='"+msg[i].name+"' style='text-decoration: none;border:0px;"+msg[i].ry+"'>"+msg[i].name+"</a></div>");
					}
    				//当点击运输方式a标签以后赋值给input框
    			    $(".shipping").click(function(){
    			    	var shipping=$(this).data('code');
    			    	$("#transport").val(shipping);
    			    	 var div = document.getElementById('zt_shipping');
    			    	 div.style.display = "none";
    			    	 $("#transport").blur();
    			    }); 
    			    //失去焦点时间，隔100毫秒执行，不然失去焦点会把上面的点击事件覆盖掉，导致赋值不上去
    			 	  $("#transport").blur(function(){
    				   setTimeout(function () {
    					 var div = document.getElementById('zt_shipping');
    			    	 div.style.display = "none";
    					  }, 100); 
    				 }); 
    			    
    			 	 $(".zt_li").mousedown(function(event) {
    			 		event.preventDefault();
    			 	});
    			 	//当鼠标放在弹出的a标签上的时候变色
    			     $(".url-product").mouseenter(function(){
    			     	$(this).removeClass("layui-btn layui-btn-primary");
    			     	$(this).addClass("layui-btn layui-btn-normal");
    			     });
    			       $(".url-product").mouseleave(function(){
    			     	$(this).removeClass("layui-btn layui-btn-normal");
    			     	$(this).addClass("layui-btn layui-btn-primary");
    			     });
    			}
    			 $("#grossWeight").val("");
    		}
    	});
    	}
    	
        var div = document.getElementById('zt_shipping');
        if(div.style.display == "none") {
        	div.style.display = "block";
        	div.style.position = "absolute";
        	div.style.zIndex = "3",
        		div.style.top = document.getElementById('transport').style.top + 36 + "px";
        	div.style.left = "224px";
        } else {
        	div.style.display = "none";
        }
        });
 
	 
	 //失去焦点时间，隔100毫秒执行，不然失去焦点会把上面的点击事件覆盖掉，导致赋值不上去
 	  $("#zt_country").blur(function(){
	   setTimeout(function () {
		 var div = document.getElementById('zt_countryTabs');
    	 div.style.display = "none";
		  }, 100); 
	 }); 
 	 //失去焦点时间，隔100毫秒执行，不然失去焦点会把上面的点击事件覆盖掉，导致赋值不上去
 	  $("#transport").blur(function(){
	   setTimeout(function () {
		 var div = document.getElementById('zt_shipping');
    	 div.style.display = "none";
		  }, 100); 
	 }); 
	 
	$(".zt_li").mousedown(function(event) {
		event.preventDefault();
	})
	
	
	//判断目的地国家/地区
    $("#zt_country").blur(function(){
    	 $("#postCode").val('');
   	 var consigneeCountry=$("#zt_country").val();
   	 if(consigneeCountry==""||consigneeCountry==null){
   		 $("#PromptConsigneeCountry").css("display","block");
   	 }else{
   		 $("#PromptConsigneeCountry").css("display","none");
   	 }
    });
	//判断运输方式
	 $("#transport").blur(function(){
		 $("#postCode").val('');
	   	 var transport=$("#transport").val();
	   	 if(transport==""||transport==null){
	   		 $("#Prompttransport").css("display","block");
	   	 }else{
	   		 $("#Prompttransport").css("display","none");
	   	 }
	    });
	
	/* //判断税号
	 $("#taxNumber").blur(function(){
	   	 var taxNumber=$("#taxNumber").val();
	   	 if(taxNumber==""||taxNumber==null){
	   		 $("#PrompttaxNumber").text("不能为空");
	   	 }else if(taxNumber.length<6 || taxNumber.length>10){
	   		 $("#PrompttaxNumber").text("普通税号应为6-10位");
	   	 }else{
	   		 $("#PrompttaxNumber").text("");
	   	 }
	    }); */
	//判断客户单号
	 $("#orderNo").blur(function(){
	   	 var orderNo=$("#orderNo").val();
	   	 if(orderNo==""||orderNo==null){
	   		 $("#PromptOrderNo").text("不能为空");
	   	 }else if(/[\u4E00-\u9FA5]/.test(orderNo)){
	   		 $("#PromptOrderNo").text("不能输入汉字");
	   	 }else{
	   		 $.post('<%=path%>/my_orders/findOrderNo.do',{orderNo:orderNo},
	   			  function(result){
	   			 if(result==0){
	   		        $("#PromptOrderNo").text("");
	   			 }else{
	   				$("#PromptOrderNo").text("客户单号已存在");
	   			 }
	   		    })
	   	 }
	    });
	//判断收件人姓名
	 $("#consignee").blur(function(){
	   	 var consignee=$("#consignee").val();
	   	 if(consignee==""||consignee==null){
	   		 $("#Promptconsignee").text("不能为空")
	   	 }else if(/[\u4E00-\u9FA5]/.test(consignee)){
	   		 $("#Promptconsignee").text("不能输入汉字")
	   	 }else if(consignee.length<4){
	   		 $("#Promptconsignee").text("长度应大于三")
	   	 }else{
	   		 $("#Promptconsignee").text("");
	   	 }
	    });
	/**判断发件人姓名  不能输入汉字*/
	 $("#shipperName").blur(function(){
	   	 var shipperName=$("#shipperName").val();
	   	 if(/[\u4E00-\u9FA5]/.test(shipperName)){
	   		 $("#PromptshipperName").text("不能输入汉字")
	   	 }else{
	   		 $("#PromptshipperName").text("");
	   	 }
	    });
	//判断品类
	 $("#category").blur(function(){
	   	 var category=$("#category").val();
	   	 if(category==""||category==null){
	   		 $("#logcategory").css("display","block");
	   	 }else{
	   		 $("#logcategory").css("display","none");
	   	 }
	    });
	//判断省/州
	 $("#consigneeContinent").blur(function(){
	   	 var consigneeContinent=$("#consigneeContinent").val();
	   	 if(consigneeContinent==""||consigneeContinent==null){
	   		 $("#PromptConsigneeContinent").text("不能为空");
	   	 }else if(/[\u4E00-\u9FA5]/.test(consigneeContinent)){
	   		 $("#PromptConsigneeContinent").text("不能输入汉字")
	   	 }else{
	   		 $("#PromptConsigneeContinent").text("");
	   	 }
	    });
	//判断城市
	 $("#consigneeCity").blur(function(){
	   	 var consigneeCity=$("#consigneeCity").val();
	   	 if(consigneeCity==""||consigneeCity==null){
	   		 $("#PromptConsigneeCity").text("不能为空");
	   	 }else if(/[\u4E00-\u9FA5]/.test(consigneeCity)){
	   		 $("#PromptConsigneeCity").text("不能输入汉字")
	   	 }else{
	   		 $("#PromptConsigneeCity").text("");
	   	 }
	    });
	//判断邮编
	 $("#postCode").blur(function(){
		var transport=$("#transport").val();
	   	var postCode=$("#postCode").val();
	    var consigneeCountry=$("#zt_country").val();
	    var zt_country=$("#zt_country").val();
	    if(transport==""||consigneeCountry==""){
	    	 $("#postCode").val('');
	    	 $("#PromptPostCode").text("请先选择国家运输方式");
	    	 return
	    }else{
	    	 $("#PromptPostCode").text("");
	    }
   		$.post('<%=path%>/offerSku/xyType.do',{postCode:postCode,company:consigneeCountry,off:transport},
   				 function(msg){
   			var date=eval('('+msg+')');
			if(date.postgz!=1){
				$("#postCode").val('')
				 $("#PromptPostCode").text(date.postgz);
			}else{
				$("#PromptPostCode").text("");
			}
   		 });
   	  if(postCode==null||postCode==""){
    	 $("#PromptPostnonull").text("不能为空");
      }else if(postCode!=null||postCode!=""){
    	  $.post('<%=path%>/region/post.do',{postCode:postCode,consigneeCountry:transport},
   				 function(msg){
    			if(msg==0){
    				$("#PromptPostnonull").text("您输入的邮编不在配送范围内，请在运输方式中选择邮政产品");
    			}else if(msg==1){
    				$("#PromptPostnonull").text("");
    			}
   		 });
      }
      else{
    	  $("#PromptPostnonull").text("");
      }
	    });
	//判断收件人电话
	 $("#consigneeTel").blur(function(){
	   	 var consigneeTel=$("#consigneeTel").val();
	   	 if(consigneeTel==""||consigneeTel==null){
	   		 $("#PromptConsigneeTel").text("不能为空");
	   	 }else if(/[\u4E00-\u9FA5]/.test(consigneeTel)){
	  		 $("#PromptConsigneeTel").text("不能输入汉字")
	  	 }else{
	   		 $("#PromptConsigneeTel").text("");
	   	 }
	    });
	/*判断体积是否为空并判断是否大于90*/
	$("#olength").blur(function(){
	   	 var olength=$("#olength").val();
	   	 if(olength==""||olength==null){
	   		 $("#volume2").text("");
	   		 $("#volume").css("display","block");
	   	 }else if(owidth<=90||oheight<=90||olength<=90){
    		 $("#volume2").text("");
    		 $("#volume").css("display","none");
    	}
	    });
	$("#owidth").blur(function(){
	   	 var owidth=$("#owidth").val();
	   	 if(owidth==""||owidth==null){
	   		 $("#volume2").text("");
	   		 $("#volume").css("display","block");
	   	 }else if(owidth<=90||oheight<=90||olength<=90){
    		 $("#volume2").text("");
    		 $("#volume").css("display","none");
	    	}
	    });
	$("#oheight").blur(function(){
	   	 var oheight=$("#oheight").val();
	   	 if(oheight==""||oheight==null){
	   		 $("#volume").css("display","block");
	   		 $("#volume2").text("");
	   	 }else if(owidth<=90||oheight<=90||olength<=90){
    		 $("#volume2").text("");
    		 $("#volume").css("display","none");
	    	}
	    });
	//判断收件人地址
	 $("#consigneeAddress").blur(function(){
	   	 var consigneeAddress=$("#consigneeAddress").val();
	   	 if(consigneeAddress==""||consigneeAddress==null){
	   		 $("#PromptConsigneeAddress").text("不能为空");
	   	 }else if(/[\u4E00-\u9FA5]/.test(consigneeAddress)){
	  		 $("#PromptConsigneeAddress").text("不能输入汉字")
	  	 }else{
	   		 $("#PromptConsigneeAddress").text("");
	   	 }
	    });
	 //发件人电话
	 $("#shipperTel").blur(function(){
	   	 var shipperTel=$("#shipperTel").val();
	   	 if(shipperTel==""||shipperTel==null){
	   		 $("#PromptShipperTel").text("不能为空");
	   	 }else if(/[\u4E00-\u9FA5]/.test(shipperTel)){
	  		 $("#PromptShipperTel").text("不能输入汉字")
	  	 }else{
	   		 $("#PromptShipperTel").text("");
	   	 }
	    });
	 //发件人邮编
		 $("#shipperCode").blur(function(){
			   	 var shipperName=$("#shipperCode").val();
			   	 if(/[\u4E00-\u9FA5]/.test(shipperName)){
			   		 $("#PromptshipperCode").text("不能输入汉字")
			   	 }else{
			   		 $("#PromptshipperCode").text("");
			   	 }
			    });
	 //发件人省
		 $("#shipperContinent").blur(function(){
			   	 var shipperName=$("#shipperContinent").val();
			   	 if(/[\u4E00-\u9FA5]/.test(shipperName)){
			   		 $("#PromptshipperContinent").text("不能输入汉字")
			   	 }else{
			   		 $("#PromptshipperContinent").text("");
			   	 }
			    });
	 //发件人市
		 $("#shipperCity").blur(function(){
			   	 var shipperName=$("#shipperCity").val();
			   	 if(/[\u4E00-\u9FA5]/.test(shipperName)){
			   		 $("#PromptshipperCity").text("不能输入汉字")
			   	 }else{
			   		 $("#PromptshipperCity").text("");
			   	 }
			    });
	 //发件人公司
		 $("#shipperCompany").blur(function(){
			   	 var shipperName=$("#shipperCompany").val();
			   	 if(/[\u4E00-\u9FA5]/.test(shipperName)){
			   		 $("#PromptshipperCompany").text("不能输入汉字")
			   	 }else{
			   		 $("#PromptshipperCompany").text("");
			   	 }
			    });
	 //收件人公司
		 $("#consigneeCompany").blur(function(){
			   	 var shipperName=$("#consigneeCompany").val();
			   	 if(/[\u4E00-\u9FA5]/.test(shipperName)){
			   		 $("#PromptconsigneeCompany").text("不能输入汉字")
			   	 }else{
			   		 $("#PromptconsigneeCompany").text("");
			   	 }
			    });
	 //发件人地址
		 $("#shipperAddress").blur(function(){
			   	 var shipperName=$("#shipperAddress").val();
			   	 if(/[\u4E00-\u9FA5]/.test(shipperName)){
			   		 $("#PromptshipperAddress").text("不能输入汉字")
			   	 }else{
			   		 $("#PromptshipperAddress").text("");
			   	 }
			    });

		 $('input:radio[name="isPreM"]').change( function(){
			var isPreM = $("input[name='isPreM']:checked").val();
               if(isPreM==1){
            	   $("#premiumPrice").removeAttr("readonly")
               }else{
            	   $("#premiumPrice").val("");
            	   $("#premiumPrice").attr("readonly","readonly")
               }
		 })
	//清理代码
		function clear(){
			   //每次点击添加的时候将input清空
		   	 $("input[type='text']").val("");   
		     $("textarea").val("");
		     $("#pinId").attr("selected","selected");//因为f5不能刷新下拉框的值，所以这里这样给下拉框默认值
		     $(".goodsAmount").val("1");//设置数量为1
         }
	})
	
</script>

	<div id="f_declare" style="display: none;">
		<table id="t_declare"></table>
	</div>
	<div id="sender" style="display: none;">
		<table class="layui-hide" id="sender_table"></table>
	</div>
</body>
</html>
