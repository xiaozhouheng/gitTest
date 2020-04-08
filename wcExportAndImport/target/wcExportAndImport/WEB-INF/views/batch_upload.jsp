<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username = request.getSession().getAttribute("userName").toString();
%>
<html>
<head>
<title><spring:message code="createOrder" /></title>
<link rel="shortcut icon" href="<%=path%>/statics/img/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/batch_upload.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<script type="text/javascript">
        //鼠标滑过显示
  /*       $(function () {
            $(".dropdown").mouseover(function () {
                $(this).addClass("open");
            });

            $(".dropdown").mouseleave(function(){
                $(this).removeClass("open");
            })

        }) */
    </script>
</head>
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


	<!--
	时间：2018-02-07
	描述：网站主体开始
-->
	<div class="col-lg-1"></div>
	<div class="col-lg-10 col-xs-12 ztck-body">
		<br />
		<div class="container col-lg-12">
			<div class="row">
				<div class="col-lg-12 col-xs-12 ">
					<div class="container-fluid col-lg-12 col-xs-12 ztck-body">
						<ul class="nav nav-tabs">
							<li role="presentation"><a
								href="<%=path%>/my_orders/to_create.html"><spring:message
										code="create" /></a></li>
							<li role="presentation" class="active"><a
								href="<%=path%>/my_orders/upload.html"><spring:message
										code="messupload" /></a></li>
						</ul>
						<!--批量上传-->
						<div class="col-lg-12 col-xs-12" style="">
							<div class="col-lg-6 col-lg-pull-1">
								<form method="post" enctype="multipart/form-data"
									action="<%=path%>/my_orders/importOrderOut.html">
									<br />
									<br />
									<br />
									<div class=" container col-lg-9 col-lg-offset-2">
										<div class="col-lg-5 "
											style="padding-top: 6px; text-align: right;">
											<span style="color: red;">*</span><span>Excel</span>
										</div>
										<div class="col-lg-7 container" style="">
											<input type="text" id="updateFile"
												class="form-control batch-upload-text" readonly="readonly"
												placeholder="<spring:message code='create.exce'/>" /> <input
												id="excelFile" name="excelFile" type="file" />
										</div>
									</div>
									<div class=" container col-lg-9 col-lg-offset-1 ztck_input"
										style="text-align: right; color: red;">
										${result.message}</div>
									<div class=" container col-lg-9 col-lg-offset-2 ztck_input"
										style="text-align: right;">
										<div class="col-lg-5 " style="padding-top: 6px;"></div>
										<div class="col-lg-2 container" style="padding-top: 6px;">
											<button type="submit"
												class="layui-btn layui-btn-normal layui-btn-sm">
												<span class="glyphicon glyphicon-ok"></span>
												<spring:message code='create.define' />
											</button>
										</div>
									</div>
								</form>
							</div>

							<div class="col-lg-6" style="">
								<br />
								<br />
								<ul class="nav nav-tabs nav-justified">
									<li role="presentation" class="active"
										style="text-align: center;"><a href="#attention"
										data-toggle="tab"><spring:message code='create.notes' /></a></li>
									<li role="presentation"><a href="#template"
										data-toggle="tab"><spring:message code='create.template' /></a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="attention">
										<p>
											<spring:message code='create.note1' />
										</p>
										<p>
											<spring:message code='create.note2' />
										</p>
										<p>
											<spring:message code='create.note3' />
										</p>
										<p>
											<a href="#" class="model_c"  id="tranport_model" data-type="gettranport"
												style="text-decoration: none;"><spring:message
													code='create.note4' /></a>(new)
										</p>
										<p>
											<a href="#" class="model_c" id="country_model" data-type="getAddData"
												style="text-decoration: none;"><spring:message
													code='create.note5' /></a>(new)
										</p>
									</div>
									<div class="tab-pane " id="template">
										<p style="font-size: 20px;">
											<spring:message code='create.Mytemplate' />
										</p>
										<div class="col-lg-12 container">
											<div class="col-lg-2">
												<a href="<%=path%>/xls/QtOrder.xlsx">
													<div>
														<img src="<%=path%>/statics/img/order_template_excel.png" />
													</div>
													<div class="col-lg-1 col-lg-pull-3 container">QtOrder.xlsx</div>
												</a>
											</div>
										</div>
									</div>
								</div>


							</div>
						</div>

					</div>
				</div>




			</div>
		</div>
	</div>
	<!--运输方式对照表-->
				<div id="tranport_list" style="display: none;">
				<c:forEach items="${str}" var="bj">
					<div class="col-lg-6 container">
						<div class="col-lg-11 ${bj.bz}" >${bj.offercode}--------${bj.offername}</div>
					</div>
					</c:forEach>
			</div>
	<!--国家中英文对照表-->
	<div id="country_list" style="display: none;">
		<c:forEach items="${countryList}" var="country">
			<div class="col-lg-6 container">
				<div class="col-lg-1">${country.dq }</div>
				<div class="col-lg-4">${country.name }</div>
				<div class="col-lg-3">${country. ename}</div>
			</div>
		</c:forEach>
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
   	 var $ = layui.$, active = {
   			 getAddData:function(){//添加数据
		          layer.open({
		      	   type: 1,
		      	   title: '国家中英文对照表',
		      	   area: ['1050px', '650px'],
		      	   skin: 'yourclass',
		      	   content: $('#country_list'),
		      	   btn: ['确定', '取消']
		      	   ,yes: function(index){
		      		     layer.close(index);
						   }
		             })
		        },
            gettranport:function(){//添加数据
		          layer.open({
		      	   type: 1,
		      	   title: '运输方式对照表',
		      	   area: ['800px', '500px'],
		      	   skin: 'yourclass',
		      	   content: $('#tranport_list'),
		      	   btn: ['确定', '取消']
		      	   ,yes: function(index){
		      		     layer.close(index);
						   }
		             })
		        }
            }
   	 $('.model_c').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
   });

    $(function() {
        //点击button按钮触发上传按钮
        $("#updateFile").click(function() {
            $("#excelFile").trigger("click");
        });
        $("#excelFile").change(function(){
            //获取FileUpload对象
            var x = document.getElementById("excelFile").files;
            //把获得的文件名放入id为sp的span标签里面显示
            $("#updateFile").val(x[0].name);
        })
        //var x = document.getElementById("file").files;
        //alert(x[0].name);
    });

</script>
</body>
</html>

