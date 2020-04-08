<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username = request.getSession().getAttribute("userName").toString();
%>
<html>
<head>
<title><spring:message code="freeCount" /></title>
<link rel="stylesheet"
	href="<%=path%>/statics/bootstrap-3.3.7/dist/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/navigation.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/index.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.layout.css" />
<link rel="stylesheet" href="<%=path%>/statics/layui/css/layui.css" />
<link rel="stylesheet"
	href="<%=path%>/statics/css/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/ui.jqgrid.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/jqGrid.overrides.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/xoms.select.css" />
<link rel="stylesheet" href="<%=path%>/statics/css/charge.query.css" />
<script type="text/javascript" src="<%=path%>/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/statics/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/statics/layui/layui.js"></script>
<script defer src="<%=path%>/statics/js/require.min.js"></script>
<script defer src="<%=path%>/statics/js/require.config.js"></script>
<script>
$(function(){
	 var company = 1
	 var postCode = 1
	 var weight = 1
	 var length =1
	 var width =1
	 var height = 1
	 var type =  1
$.post('<%=path%>/freeCount/findTransport.do',{company:company,postCode:postCode,weight:weight,length:length,width:width,height:height,type:type},
	 function(data){
	var date=eval('('+data+')');
	if(date.relut=="0"){
		alert("信息不全")
	}else{
		$.each(date.relut,function(i,item){
			$("#trprIid").append("<option value='"+item.offername+"'>"+item.offername+"</option>");
		});
	}
})
})
layui.use('table', function(){
    var table = layui.table;
    table.render({
        elem: '#test',
        url: "<%=request.getContextPath() %>/freeCount/findYx.do?" ,
        page: true,
        limit:50,
        limits:[200,500,1000],
        cols: [[
			{field:'itemName', width:'10%', title: '<spring:message code='freeCount.Num'/>'},
            {field:'category', width:'10%', title: '<spring:message code='freeCount.Product'/>'},
            {field:'zongMomey', width:'10%', title: '<spring:message code='freeCount.Freight'/>'},
            {field:'weight', width:'10%', title: '<spring:message code='freeCount.weight'/>'},
            {field:'tijz', width:'10%', title: '<spring:message code='freeCount.VolumeWeight'/>'},
            {field:'gons', title: '<spring:message code='freeCount.gs'/>',  width:'10%'},
            /* {field:'tians', width:'10%', title: '<spring:message code='freeCount.VolumeWeight'/>'}, */
            {field:'kzz', width:'10%', title: '<spring:message code='freeCount.Tracking'/>'},
            {field:'bz', width:'10%', title: '<spring:message code='freeCount.Noties'/>'},
            {field:'fendtime', width:'10%', title: '<spring:message code='freeCount.Deliverydays'/>'}
        ]]
    ,id: 'testReload'
	});
	var $ = layui.$, active = {
		reload: function(){
			 var company = $("#countryName").val();
			 var postCode = $("#ogid-pickup").val();
			 var weight = $("#weight").val();
			 var length = $("#length").val();
			 var width = $("#width").val();
			 var height = $("#height").val();
			 var trprIid =  $("#trprIid").val();
			 var type =  $("input[name='type_value']:checked").val(); 
		table.reload('testReload', {
			  page: {
			  	curr: 1 
		  	}
			,where: {
				company : company,
				postCode : postCode,
				weight : weight,
				height : height,
				length:length,
				type : type,
				trprIid :trprIid,
				width :width,
		  	}
  		});
		}
	};
	$('.charge-form .layui-btn').on('click', function(){
	   var type = $(this).data('type');
	   active[type] ? active[type].call(this) : '';
	});
});
    //鼠标滑过显示
    $(function () {
       /*  $(".dropdown").mouseover(function () {
            $(this).addClass("open");
        });
        $(".dropdown").mouseleave(function(){
            $(this).removeClass("open");
        }) */
        
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
        $("#countryName").focus(function() {
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
        $(".country").click(function(){
        	var zt_country=$(this).data('code');
        	$("#countryName").val(zt_country);
        	 var div = document.getElementById('zt_countryTabs');
        	 div.style.display = "none";
        	 $("#countryName").blur();
        	 //赋值给全局变量
        	 consigneeCountry=zt_country;
        	 //每次选择都清空运输方式input的值
        	 $("#transport").val("");
        });
    	 
   	 //失去焦点时间，隔100毫秒执行，不然失去焦点会把上面的点击事件覆盖掉，导致赋值不上去
   	  $("#countryName").blur(function(){
  	   setTimeout(function () {
  		 var div = document.getElementById('zt_countryTabs');
      	 div.style.display = "none";
  		  }, 100); 
  	 }); 
   	 
   	$(".zt_li").mousedown(function(event) {
		event.preventDefault();
	})
	/* function myRefersh( e ) {  
    const source = e.src ; // 获得原来的 src 中的内容  
    //console.log( "source : " + source  ) ;  
    var index = source.indexOf( "?" ) ;  // 从 source 中寻找 ? 第一次出现的位置 (如果不存在则返回 -1 )  
    //console.log( "index : " + index  ) ;  
    if( index > -1 ) { // 如果找到了 ?  就进入内部  
        var s = source.substring( 0 , index ) ; // 从 source 中截取 index 之前的内容 ( index 以及 index 之后的内容都被舍弃 )  
        //console.log( "s : " + s  ) ;  
        var date = new Date(); // 创建一个 Date 对象的 一个 实例  
        var time = date.getTime() ; // 从 新创建的 Date 对象的实例中获得该时间对应毫秒值  
        e.src = s + "?time=" + time ; // 将 加了 尾巴 的 地址 重新放入到 src 上  
        //console.log( e.src ) ;  
    } else {  
        var date = new Date();  
        e.src = source + "?time=" + date.getTime();  
    }  
} */
    }) 
</script>
</head>
<style type="text/css">
.url_div {
	margin-left: 10px;
	width: 140px;
}

.url-product {
	width: 140px;
}

.tab-pane a {
	text-align: left;
	float: left;
}
</style>
<body >

	<!-- 导航栏 -->
<%@ include file="basebar/financebar.txt" %>
	<!--
	时间：2018-02-06
	描述：网站主体开始
-->
	<div class="xoms-secnavbar">
		<div class="container">
			<ul class="myorder-dropdown ">
				<li class="createto_create createbatch_upload"><a
					href="<%=path%>/mybill/custom.html"><spring:message
							code="myBill" /></a></li>
				<%-- <li class="order_problemindex"><a href="<%=path%>/queryOrder/recharge.html"><spring:message code="recharge"/></a></li> --%>
				<li class="order_problemindex active"><a
					href="<%=path%>/freeCount/findqt.html"><spring:message
							code="freeCount" /></a></li>
				<li class="searchindex"><a href="<%=path%>/freeMx/findMx.html"><spring:message
							code="freeMx" /></a></li>
				<li class="order_problemindex"><a href="<%=path%>/insurance/insurance.html"><spring:message
							code="insurance" /></a></li>
			</ul>
		</div>
	</div>
	<!--
	作者：hu
	时间：2018-02-07
	描述：主体
-->			<div align="center">
				<h6><font color="red">如重量经仓库称重后存在差异，系统会自动扣费或退费</font></h6>
			</div> 
	<div class="xoms-container col-md-10 col-md-offset-1"
		style="background-color: white;" role="main">
		
		<div class="form-horizontal charge-form " role="form">
		<div></div>
		
		
			
			<div class="layui-form-item">
				<label class="col-sm-4 col-md-3 control-label require-star-before "
					for=""><spring:message code="freeCount.Country" /></label>
				<div class="col-sm-4 col-lg-3 input-parent">
					<input class="form-control country-select" id="countryName"
						name="countryName" value="" data-code="" placeholder="请输入国家" /> <span
						style="color: #FF3333" id="countryerr"></span>
				</div>
				<br> <br>
				<div class="container-fluid col-md-offset-3 zt_li"
					id="zt_countryTabs" tabindex="1"
					style="width: 560px; display: none; border: solid #C4E2F7 1px; background-color: #FFFFFF;">
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
									<a class="url-product country layui-btn layui-btn-primary "
										href="javascript: void(0);" title="${a.name}"
										data-code="${a.name}"
										style="text-decoration: none; border: 0px">${a.name}</a>
								</div>
							</c:forEach>
						</div>
						<div class="tab-pane"
							id="destinationCountryName-dialog-countryTabs-2">
							<c:forEach items="${f_j}" var="f">
								<div class="col-lg-4 url_div">
									<a class="url-product country layui-btn layui-btn-primary "
										href="javascript: void(0);" title="${f.name}"
										data-code="${f.name}"
										style="text-decoration: none; border: 0px">${f.name}</a>
								</div>
							</c:forEach>
						</div>
						<div class="tab-pane"
							id="destinationCountryName-dialog-countryTabs-3">
							<c:forEach items="${k_n}" var="k">
								<div class="col-lg-4 url_div">
									<a class="url-product country layui-btn layui-btn-primary "
										href="javascript: void(0);" title="${k.name}"
										data-code="${k.name}"
										style="text-decoration: none; border: 0px">${k.name}</a>
								</div>
							</c:forEach>
						</div>
						<div class="tab-pane"
							id="destinationCountryName-dialog-countryTabs-4">
							<c:forEach items="${n_s}" var="n">
								<div class="col-lg-4 url_div">
									<a class="url-product country layui-btn layui-btn-primary "
										href="javascript: void(0);" title="${n.name}"
										data-code="${n.name}"
										style="text-decoration: none; border: 0px">${n.name}</a>
								</div>
							</c:forEach>
						</div>
						<div class="tab-pane"
							id="destinationCountryName-dialog-countryTabs-5">
							<c:forEach items="${t_z}" var="t">
								<div class="col-lg-4 url_div">
									<a class="url-product country layui-btn layui-btn-primary "
										href="javascript: void(0);" title="${t.name}"
										data-code="${t.name}"
										style="text-decoration: none; border: 0px">${t.name}</a>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
			</div>
		</div>



		<div class="form-horizontal charge-form " role="form">
			<div class="layui-form-item">
				<label class="col-sm-3 col-md-3 control-label " for=""><spring:message
						code="freeCount.zip" /></label>
				<div class="col-sm-2 input-parent">
					<input class="form-control country-select" id="ogid-pickup"
						name="ogid-pickup" placeholder="请输入邮编" /> <span
						style="color: #FF3333" id="zipErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 col-md-3 control-label require-star-before"
					for=""><spring:message code="freeCount.Goods" /></label>
				<div class="col-sm-8 ">
					<div class="weigth-list">
						<div class="weight-item input-parent">
							<div class="clearfix">
								<div class="pull-left">
									<label class="control-label" for=""><spring:message
											code="freeCount.Weight" /> </label> <input
										class="form-control weight-input charge-gross-weight"
										type="text" id="weight" name="weight" value="2" /> <span
										style="color: #FF3333" id="weighterr"></span>
								</div>
								<div class=" volume-div">
									<label class="control-label pull-left" for=""><spring:message
											code="freeCount.Volume" /> </label>
									<div class="pull-left">
										<input class="form-control weight-input weight-length"
											type="text" id="length" name="length"
											placeholder="<spring:message code="freeCount.length"/>" /> *
										<input class="form-control weight-input weight-width"
											type="text" id="width" name="width"
											placeholder="<spring:message code="freeCount.Width"/>" /> * <input
											class="form-control weight-input weight-height" type="text"
											id="height" name="height"
											placeholder="<spring:message code="freeCount.Height"/>" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			

			<div class="form-group">
				<label class="col-sm-3 col-md-3 control-label " for=""><spring:message
						code="freeCount.shipment" /></label>
				<div class="col-sm-2 input-parent">
					<select id="trprIid"  onclick="gradeChange()">
					<option value="">先选择上面内容</option>
					</select>
				</div>
				
				<label class="col-sm-2 col-md-1 control-label " for=""><spring:message
						code="freeCount.goodsType" /></label>
				<div class="col-sm-4 input-parent " style="margin-top: 7px;">
					<input class="" style="vertical-align: middle; margin-top: 0;"
						type="radio" id="type_value" name="type_value" value="包裹"
						checked="checked" />
					<spring:message code="freeCount.package" />
					&nbsp;&nbsp;&nbsp;&nbsp; <input class=""
						style="vertical-align: middle; margin-top: 0;" type="radio"
						id="type_value" name="type_value" value="文件" />
					<spring:message code="freeCount.file" />
					&nbsp;&nbsp;&nbsp;&nbsp; <input class=""
						style="vertical-align: middle; margin-top: 0;" type="radio"
						id="type_value" name="type_value" value="大货" />
					<spring:message code="freeCount.begPackage" />
				</div>
			</div>
			<%--    <div class="form-group">
          <label class="col-sm-4 col-md-3 control-label require-star-before" for="verificationCode"><spring:message code="freeCount.VerificationCode"/></label>
          <div class="col-sm-8 input-parent">
                <img id="img" src="<%=path%>/authImage/authImage.do" />
        		<a href='#' onclick="javascript:changeImg()" >看不清？</a>
        		<input class="form-control verification-code" type="text" name="verificationCode" id="verificationCode" value="">
        		 <span style="color: #FF3333" id="verificationErre">${verCodereer }</span>
          </div>
      </div>  --%>
			<div class="form-group">
				<div
					class="col-sm-offset-4 col-md-offset-3 col-sm-4 xoms-btn-container">
					<input type="hidden" id="ogIdPickup" name="ogIdPickup" /> <input
						type="hidden" name="cargoType" id="cargoType" value="P" />
					<button class="layui-btn layui-btn-normal" data-type="reload">
						<spring:message code="freeCount.Search" />
					</button>
				</div>
			</div>
		</div>
		<div id="test" style="height: 0px; width: 1555px;"></div>
	</div>
	<script type="text/javascript">
 	 function gradeChange(){
		
		
	 } 
 
	</script>
</body>
</html>