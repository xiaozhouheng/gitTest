
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username = request.getSession().getAttribute("userName").toString();
%>
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<!--  禁止在移动设备上缩放   -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<title><spring:message code="recharge" /></title>
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/iconfont.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/index.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/payonline.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script defer src="<%=path%>/statics/js/require.min.js"></script>
<script defer src="<%=path%>/statics/js/require.config.js"></script>
<script type="text/javascript">
        //鼠标滑过显示
        $(function () {
          /*   $(".dropdown").mouseover(function () {
                $(this).addClass("open");
            });

            $(".dropdown").mouseleave(function(){
                $(this).removeClass("open");
            }) */

        })
    </script>
</head>
<body>

	<!-- 导航栏 -->
<%@ include file="base.txt" %>
	<!--
	时间：2018-02-06
	描述：网站主体开始
-->
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="createto_create createbatch_upload "><a
					href="<%=path%>/mybill/custom.html"><spring:message
							code="myBill" /></a></li>
				<%--  <li class="order_problemindex active"><a href="<%=path%>/queryOrder/recharge.html"><spring:message code="recharge"/></a></li> --%>
				<li class="order_problemindex"><a
					href="<%=path%>/freeCount/findqt.html"><spring:message
							code="freeCount" /></a></li>
				<li class="searchindex"><a href="<%=path%>/freeMx/findMx.html"><spring:message
							code="freeMx" /></a></li>
			</ul>
		</div>
	</div>
	<div class="xoms-container" role="main">
		<div class="container xoms-main has-secnavbar-container">
			<!-- 公告 -->

			<form class="form-horizontal payonline-form"
				action="<%=path %>/order/finance_management/payonline/recharge"
				target="_blank">
				<div class="">
					<label class=" col-lg-2 ">在线支付提示：</label>
				</div>
				<div class="form-group">
					<label class=" col-md-offset-1 col-lg-11 ">1.
						快钱公司目前暂无与递四方或其他合作方推出优惠活动，请客户朋友们勿理会快钱支付网关页面的“使用优惠券”提示。</label> <label
						class=" col-md-offset-1 col-lg-11 ">2.
						充值成功后，请稍等两分钟才能在我司查询到充值记录。</label> <label
						class=" col-md-offset-1 col-lg-11">3.
						如需联系我们，请拨打：0755-23508176 或 0755-29771100。</label> <label
						class=" col-md-offset-1 col-lg-11">
						【通知】PAYPAL在线充值只针对海外PAYPAL账户使用，国内PAYPAL账户暂未开通，感谢您的配合！</label>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-1 col-sm-2"><spring:message
							code="recharge.Balance" /></label>
					<div class="col-lg-11 col-sm-10">
						<label class="control-label payonline-sum-label">${balance }
							(CNY)</label>
					</div>
				</div>
				<div class="form-group payonline-type-group">
					<label class="control-label col-lg-1 col-sm-2" for="payonlineType"><spring:message
							code="recharge.Type" /></label>
					<div class="col-lg-11 col-sm-10">
						<div class="radio payonline-type">

							<label title="宝付"> <input type="radio"
								name="payonlineType" id="payonlineType" value="BF" checked>
								<span class="payonline-type-img payonline-type-img-bf"></span>
							</label> <label title="快钱"> <input type="radio"
								name="payonlineType" id="payonlineType" value="KQ"> <span
								class="payonline-type-img payonline-type-img-kq"></span>
							</label> <label title="payonline"> <input type="radio"
								name="payonlineType" id="payonlineType" value="PO"> <span
								class="payonline-type-img payonline-type-img-po"></span>
							</label>

						</div>
					</div>
				</div>


				<%-- <div class="form-group payoneer-type-group">
                <label class="control-label col-lg-1 col-sm-2" >币种</label>
                <div class="col-lg-3 col-sm-5">
                    <label class="control-label">
                        <input type="radio" name="currencyType" id="amount-type-select" value="USD" checked>
                        <span class="">美元</span>
                    </label class="control-label">
                    <label >
                        <input type="radio" name="currencyType" id="amount-type-select" value="EUR">
                        <span class="">欧元</span>
                    </label>
                </div>
            </div>--%>
				<%-- <div class="form-group payoneer-group">

                <div class="col-lg-offset-1 col-sm-offset-2 col-lg-11 col-sm-10">
                    <label class="control-label">还没有payoneer账户? 点击 <a id="payoneerRechargeUrl" target="_blank">免费注册</a></label>
                </div>
            </div>--%>
				<div class="form-group payoneer-amount-group">
					<label class="control-label col-lg-1 col-sm-2" for="amount"><spring:message
							code="recharge.Amount" /></label>
					<div class="col-lg-3 col-sm-5">
						<input class="form-control" type="text" maxlength="10"
							onkeyup="value=value.replace(/[^\d.]/g,'')" name="amount"
							id="amount" placeholder="<spring:message code="recharge.Notes"/>">
						<label class="control-label amount-type">(CNY)</label>
					</div>
					<!-- 			<div class="col-lg-3 col-sm-5"><label class="control-label amount-type">(CNY)</label></div> -->
				</div>
				<div class="form-group agreement-group">
					<div class="col-lg-offset-1 col-sm-offset-2 col-lg-11 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox" name="agreement"
								id="agreement"> <span><spring:message
										code="recharge.Agree" /></span>
							</label>
						</div>
					</div>
				</div>

				<div class="form-group payonline-btn-group">
					<div
						class="col-lg-offset-1 col-sm-offset-2 col-lg-11 col-sm-10 xoms-btn-container">
						<button class="btn layui-btn layui-btn-normal layui-btn-sm">
							<span class="glyphicon glyphicon-jpy"></span>
							<spring:message code="recharge.Recharge" />
						</button>
					</div>
				</div>
			</form>
		</div>


		<div class="modal fade" id="payonline-modal-dialog" tabindex="-1"
			role="dialog" data-keyboard="false" data-backdrop="statics"
			aria-labelledby="payonlineLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="payonline-modal-main">
						<div class="payonline-modal-header">
							<span class=""></span> 请在新打开的窗口进行充值, 您还可以:
						</div>
						<div class="payonline-modal-content">
							<p>
								1) 充值成功后, 查看 <a
									href="/order/finance_management/my_bill/customer_amount_change"
									target="_blank">充值明细</a>
							</p>
							<p>
								2) <a class="payonline-again" href="#">继续充值</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>



	<div class="xoms-footer">
		<div class="container xoms-footer-content">
			<!--    Copyright 2004-2015©4PX All rights reserved  粤ICP备10020553号-2 -->
		</div>
	</div>
</body>
</html>
