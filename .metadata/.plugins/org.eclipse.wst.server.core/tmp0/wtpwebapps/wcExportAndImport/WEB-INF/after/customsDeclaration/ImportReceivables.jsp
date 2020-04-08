<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收款页面</title>
<link href="<%=path%>/statics/layui/layui.css" rel="stylesheet">
<link href="<%=path%>/statics/css/user/user.css" rel="stylesheet">
<script src="<%=path%>/statics/layui/layui.js"></script>
<script src="<%=path%>/statics/js/jquery.min.js"></script>
</head>
<style>
/* ul li 仿select下拉框样式美化 */

 li {
    list-style: none;
}
/* #select {
    border: 1px solid #9D9D9D;
    width: 200px;
    height: 38px;
    font-size: 16px;
    cursor: pointer;
    box-sizing: border-box;
    margin:5px 0 0 10px;
    padding: 5px 5px 0 0;
} */
.select-head {
    width: 100%;
    height: 38px;
    box-sizing: border-box;
    line-height: 24px;
    
}
.select-head .select-head-cont {
    float: left;
}
.select-head .select-icon {
    float: right;
    margin-right: 10px;
}
.option {
    margin: 50px 0 0 60px;
    width: 176px;
    height:200px;
    color: black;
    background: #fff;
    border: 1px #9D9D9D solid;
    display: none;
    z-index: 10;
    position: absolute;
    box-sizing: border-box;
    top: 23px;
    left: 0px;
    overflow-y:auto;
}
.option .option-item {
    margin-bottom: 0;
    height: 38px;
    line-height: 24px;
    padding: 10px 5px 0 12px;
}
.option-item:hover {
    background: #009688 !important;
    color: #fff !important;
}
</style>
<body>
	<div class="content">
    <form action="" method="post" id="enditform" class="layui-form enditform">
    	<div class="layui-form-item">
			<label class="layui-form-label">仓储费</label>
			<div class="layui-inline">
			<input type="text"  class="layui-input" name="passWord" id="cangchufeiInput"  value="">
			</div>
			<div class="layui-inline">
			<select name="paiDan" id="cangchufeiSelect" class ="layui-select" lay-filter="cangchufeiSelect" style="width: 150px;">
				<option>请选择单位</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">报关费</label>
			<div class="layui-inline">
			<input type="text"  class="layui-input" name="passWord" id="baoguanfeiInput" value="">
			</div>
			<div class="layui-inline">
			<select name="paiDan" id="baoguanfeiSelect" class ="layui-select" lay-filter="baoguanfeiSelect" style="width: 150px;">
				<option>请选择单位</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">商检费</label>
			<div class="layui-inline">
			<input type="text"  class="layui-input" name="passWord" id="shangjianfeiInput" value="">
			</div>
			<div class="layui-inline">
			<select name="paiDan" id="shangjianfeiSelect" class ="layui-select" lay-filter="shangjianfeiSelect" style="width: 150px;">
				<option>请选择单位</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">转关费</label>
			<div class="layui-inline">
			<input type="text"  class="layui-input" name="passWord" id="zhuanguanfeiInput"  value="">
			</div> 
			<div class="layui-inline">
			<select name="paiDan" id="zhuanguanfeiSelect" class ="layui-select" lay-filter="zhuanguanfeiSelect" style="width: 150px;">
				<option>请选择单位</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">其他1</label> 
			<div class="layui-inline">
			<input type="text"  class="layui-input" name="passWord" id="other1Input"  value="">
			</div>
			<div class="layui-inline">
			<select name="paiDan" id="other1Select" class ="layui-select" lay-filter="other1Select" style="width: 150px;">
				<option>请选择单位</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">其他2</label>
			<div class="layui-inline">
			<input type="text"  class="layui-input" name="passWord" id="other2Input"  value="">
			</div> 
			<div class="layui-inline">
			<select name="paiDan" id="other2Select" class ="layui-select" lay-filter="other2Select" style="width: 150px;">
				<option>请选择单位</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label> 
			<div class="layui-input-block">
			 <input type="text"  class="layui-input" lay-verify="required" name="passWord" id="passWord"  value="" style="width:90%;" >
			</div>
		</div>
		<div class="layui-form-item">
			 <label class="layui-form-label">计算公式</label>
			<div class="layui-inline" id = "gongshibianliang">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">总金额</label>
			<div class="layui-inline" id ="jinebianliang">
			</div>
		</div>
    </form>
    </div>
</body>
<script>
	var cangchufeiInput = 0;
	var cangchufeiSelect = 0;
	var baoguanfeiInput = 0;
	var baoguanfeiSelect = 0;
	var shangjianfeiInput = 0;
	var shangjianfeiSelect = 0;
	var zhuanguanfeiInput = 0;
	var zhuanguanfeiSelect = 0;
	var other1Input = 0;
	var other1Select = 0;
	var other2Input = 0;
	var other2Select = 0;
	var jisuangongshi = " ";
	var zongjine = 0;
	layui.use(['form', 'jquery'],function(){
	    var form = layui.form;
	    var $ = layui.jquery;
		//仓储费
		$("#cangchufeiInput").bind("input propertychange",function(event){
			if(jisuangongshi != " " && jisuangongshi.indexOf("仓储费") != -1){//如果计算公式不为空，并且包含仓储费，那么就需要删除之前的仓储费，并重新添加新修改的仓储费用
				zongjine = zongjine - cangchufeiInput * cangchufeiSelect//总金额中已经包含上次输入的仓储费了，需要删除之前添加的仓储费
				cangchufeiInput = 0//仓储费置空
				cangchufeiInput = $("#cangchufeiInput").val()//仓储费获取赋值
				//重置总金额
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(cangchufeiInput != 0){//仓储费改为新的仓储费
					zongjine = zongjine + cangchufeiInput * cangchufeiSelect//增加新的仓储费用
					//重置总金额
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
			else{//如果计算公式不为空，并且计算公式没有包含仓储费，或计算公式为空，就继续执行
				cangchufeiInput = $("#cangchufeiInput").val()//仓储费获取赋值
				if(cangchufeiInput != 0 && cangchufeiSelect != 0){//判断仓储费是否有值，仓储单位是否为数值，如果没有值且不为数值，那么就直接结束
					if(jisuangongshi == " "){//正常情况，仓储费和单位都有值，并且是用户第一次输入，计算公式为空
						jisuangongshi = jisuangongshi + "仓储费*单位" //新增计算公式，并且为第一位置
						zongjine = cangchufeiInput * cangchufeiSelect //总金额第一次计算
						}
					else{//正常情况，仓储费和单位都有值，并且计算公式有值，不是用户最先输入的仓储费
						jisuangongshi = jisuangongshi + "+仓储费*单位" //在计算公式已经存在数据的情况下，继续添加需要的公式
						zongjine = zongjine + cangchufeiInput * cangchufeiSelect//增加仓储费用
						}
				//仓储费用正常添加的情况下，要执行页面展示 的 计算公式的重置操作 和 总金额的重置操作
				$("#gongshibianliang").html(" ")
				$("#jinebianliang").html(" ")
				$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
		});
	
		//仓储单位
		//监听layui select下拉框的值
		form.on('select(cangchufeiSelect)', function(data){
			if(jisuangongshi != " " && jisuangongshi.indexOf("仓储费") != -1){//如果计算公式不为空，并且包含仓储费，那么就需要删除之前的仓储费，并重新添加新修改的仓储费用
				zongjine = zongjine - cangchufeiInput * cangchufeiSelect//总金额中已经包含上次输入的仓储费了，需要删除之前添加的仓储费
				cangchufeiSelect = 0//仓储单位置空
				cangchufeiSelect = data.value;//仓储单位获取赋值
				if(cangchufeiSelect == "请选择单位"){//防止仓储单位赋值为字符串而引起总金额值错误
					cangchufeiSelect = 0 //当仓储单位为请选择单位时，赋值为0
				}
				//重置总金额
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(cangchufeiSelect != 0){//仓储单位有值，并且是新的修改的数值，则，继续增加新的仓储费用
					zongjine = zongjine + cangchufeiInput * cangchufeiSelect//增加新的仓储费用
					//重置总金额
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}else{
				//如果计算公式不为空，并且计算公式没有包含仓储费，或计算公式为空，就继续执行
				cangchufeiSelect = data.value;//仓储单位获取赋值
				if(cangchufeiSelect == "请选择单位"){
					cangchufeiSelect = 0
				}
				if(cangchufeiInput != 0 && cangchufeiSelect != 0){//判断仓储费是否有值，仓储单位是否为数值，如果没有值且不为数值，那么就直接结束
					if(jisuangongshi == " "){//正常情况，仓储费和单位都有值，并且是用户第一次输入，计算公式为空
						jisuangongshi = jisuangongshi + "仓储费*单位" //新增计算公式，并且为第一位置
						zongjine = cangchufeiInput * cangchufeiSelect //总金额第一次计算
						}
					else{//正常情况，仓储费和单位都有值，并且计算公式有值，不是用户最先输入的仓储费
						jisuangongshi = jisuangongshi + "+仓储费*单位" //在计算公式已经存在数据的情况下，继续添加需要的公式
						zongjine = zongjine + cangchufeiInput * cangchufeiSelect//增加仓储费用
						}
				//仓储费用正常添加的情况下，要执行页面展示 的 计算公式的重置操作 和 总金额的重置操作
				$("#gongshibianliang").html(" ")
				$("#jinebianliang").html(" ")
				$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
			form.render('select');//select是固定写法 不是选择器
			});
		
		//此处使用change方法监听无效
		/* $("#cangchufeiSelect").change(function(){
		$("#cangchufeiSelect").bind("select propertychange",function(){
			cangchufeiSelect = $(this).children('option:selected').val()	
			console.log(cangchufeiSelect)
		}) */
		
		//报关费
		$("#baoguanfeiInput").bind("input propertychange",function(event){
			if(jisuangongshi != " " && jisuangongshi.indexOf("报关费") != -1){
				zongjine = zongjine - baoguanfeiInput * baoguanfeiSelect
				baoguanfeiInput = 0
				baoguanfeiInput = $("#baoguanfeiInput").val()
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(baoguanfeiInput != 0){
					zongjine = zongjine + baoguanfeiInput * baoguanfeiSelect
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}else{
				baoguanfeiInput = $("#baoguanfeiInput").val()
				if(baoguanfeiInput != 0 && baoguanfeiSelect != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "报关费*单位"
						zongjine = baoguanfeiInput * baoguanfeiSelect
						}
					else{
						jisuangongshi = jisuangongshi + "+报关费*单位"
						zongjine = zongjine + baoguanfeiInput * baoguanfeiSelect
						}
				$("#gongshibianliang").html(" ")
				$("#jinebianliang").html(" ")
				$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
		});
		//报关单位
		form.on('select(baoguanfeiSelect)', function(data){
			if(jisuangongshi != " " && jisuangongshi.indexOf("报关费") != -1){
				zongjine = zongjine - baoguanfeiInput * baoguanfeiSelect
				baoguanfeiSelect = 0
				baoguanfeiSelect = data.value;
				if(baoguanfeiSelect == "请选择单位"){
					baoguanfeiSelect = 0
				}
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(baoguanfeiSelect != 0){
					zongjine = zongjine + baoguanfeiInput * baoguanfeiSelect
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			else{
				baoguanfeiSelect = data.value;
				if(baoguanfeiSelect == "请选择单位"){
					baoguanfeiSelect = 0
				}
				if(baoguanfeiInput != 0 && baoguanfeiSelect != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "报关费*单位"
						zongjine = baoguanfeiInput * baoguanfeiSelect
						}
					else{
						jisuangongshi = jisuangongshi + "+报关费*单位"
						zongjine = zongjine + baoguanfeiInput * baoguanfeiSelect
						}
					$("#gongshibianliang").html(" ")
					$("#jinebianliang").html(" ")
					$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			form.render('select');
			});

		//商检费
		$("#shangjianfeiInput").bind("input propertychange",function(event){
			if(jisuangongshi != " " && jisuangongshi.indexOf("商检费") != -1){
				zongjine = zongjine - shangjianfeiInput * shangjianfeiSelect
				shangjianfeiInput = 0
				shangjianfeiInput = $("#shangjianfeiInput").val()
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(shangjianfeiInput != 0){
					zongjine = zongjine + shangjianfeiInput * shangjianfeiSelect
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}else{
				shangjianfeiInput = $("#shangjianfeiInput").val()
				if(shangjianfeiInput != 0 && shangjianfeiSelect != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "商检费*单位"
						zongjine = shangjianfeiInput * shangjianfeiSelect
						}
					else{
						jisuangongshi = jisuangongshi + "+商检费*单位"
						zongjine = zongjine + shangjianfeiInput * shangjianfeiSelect
						}
				$("#gongshibianliang").html(" ")
				$("#jinebianliang").html(" ")
				$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
		});
		//商检单位
		form.on('select(shangjianfeiSelect)', function(data){
			if(jisuangongshi != " " && jisuangongshi.indexOf("商检费") != -1){
				zongjine = zongjine - shangjianfeiInput * shangjianfeiSelect
				shangjianfeiSelect = 0
				shangjianfeiSelect = data.value;
				if(shangjianfeiSelect == "请选择单位"){
					shangjianfeiSelect = 0
				}
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(shangjianfeiSelect != 0){
					zongjine = zongjine + shangjianfeiInput * shangjianfeiSelect
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			else{
				shangjianfeiSelect = data.value;
				if(shangjianfeiSelect == "请选择单位"){
					shangjianfeiSelect = 0
				}
				if(shangjianfeiInput != 0 && shangjianfeiSelect != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "商检费*单位"
						zongjine = shangjianfeiInput * shangjianfeiSelect
						}
					else{
						jisuangongshi = jisuangongshi + "+商检费*单位"
						zongjine = zongjine + shangjianfeiInput * shangjianfeiSelect
						}
					$("#gongshibianliang").html(" ")
					$("#jinebianliang").html(" ")
					$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			form.render('select');
			});
		
		//转关费
		$("#zhuanguanfeiInput").bind("input propertychange",function(event){
			if(jisuangongshi != " " && jisuangongshi.indexOf("转关费") != -1){
				zongjine = zongjine - zhuanguanfeiInput * zhuanguanfeiSelect
				zhuanguanfeiInput = 0
				zhuanguanfeiInput = $("#zhuanguanfeiInput").val()
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(zhuanguanfeiInput != 0){
					zongjine = zongjine + zhuanguanfeiInput * zhuanguanfeiSelect
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
			else{
				zhuanguanfeiInput = $("#zhuanguanfeiInput").val()
				if(zhuanguanfeiInput != 0 && zhuanguanfeiSelect != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "转关费*单位"
						zongjine = zhuanguanfeiInput * zhuanguanfeiSelect
						}
					else{
						jisuangongshi = jisuangongshi + "+转关费*单位"
						zongjine = zongjine + zhuanguanfeiInput * zhuanguanfeiSelect
						}
				$("#gongshibianliang").html(" ")
				$("#jinebianliang").html(" ")
				$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
		});
		//转关单位
		form.on('select(zhuanguanfeiSelect)', function(data){
			if(jisuangongshi != " " && jisuangongshi.indexOf("转关费") != -1){
				zongjine = zongjine - zhuanguanfeiInput * zhuanguanfeiSelect
				zhuanguanfeiSelect = 0
				zhuanguanfeiSelect = data.value;
				if(zhuanguanfeiSelect == "请选择单位"){
					zhuanguanfeiSelect = 0
				}
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(zhuanguanfeiSelect != 0){
					zongjine = zongjine + zhuanguanfeiInput * zhuanguanfeiSelect
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			else{
				zhuanguanfeiSelect = data.value;
				if(zhuanguanfeiSelect == "请选择单位"){
					zhuanguanfeiSelect = 0
				}
				if(zhuanguanfeiInput != 0 && zhuanguanfeiSelect != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "转关费*单位"
						zongjine = zhuanguanfeiInput * zhuanguanfeiSelect
						}
					else{
						jisuangongshi = jisuangongshi + "+转关费*单位"
						zongjine = zongjine + zhuanguanfeiInput * zhuanguanfeiSelect
						}
					$("#gongshibianliang").html(" ")
					$("#jinebianliang").html(" ")
					$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			form.render('select');
			});
		
		//其他1费用
		$("#other1Input").bind("input propertychange",function(event){
			if(jisuangongshi != " " && jisuangongshi.indexOf("其他1费用") != -1){
				zongjine = zongjine - other1Input * other1Select
				other1Input = 0
				other1Input = $("#other1Input").val()
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(other1Input != 0){
					zongjine = zongjine + other1Input * other1Select
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
			else{
				other1Input = $("#other1Input").val()
				if(other1Input != 0 && other1Select != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "其他1费用*单位"
						zongjine = other1Input * other1Select
						}
					else{
						jisuangongshi = jisuangongshi + "+其他1费用*单位"
						zongjine = zongjine + other1Input * other1Select
						}
				$("#gongshibianliang").html(" ")
				$("#jinebianliang").html(" ")
				$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
		});
		//其他1单位
		form.on('select(other1Select)', function(data){
			if(jisuangongshi != " " && jisuangongshi.indexOf("其他1费用") != -1){
				zongjine = zongjine - other1Input * other1Select
				other1Select = 0
				other1Select = data.value;
				if(other1Select == "请选择单位"){
					other1Select = 0
				}
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(other1Select != 0){
					zongjine = zongjine + other1Input * other1Select
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			else{
				other1Select = data.value;
				if(other1Select == "请选择单位"){
					other1Select = 0
				}
				if(other1Input != 0 && other1Select != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "其他1费用*单位"
						zongjine = other1Input * other1Select
						}
					else{
						jisuangongshi = jisuangongshi + "+其他1费用*单位"
						zongjine = zongjine + other1Input * other1Select
						}
					$("#gongshibianliang").html(" ")
					$("#jinebianliang").html(" ")
					$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			form.render('select');
			});
		
		

		//其他2费用
		$("#other2Input").bind("input propertychange",function(event){
			if(jisuangongshi != " " && jisuangongshi.indexOf("其他2费用") != -1){
				zongjine = zongjine - other2Input * other2Select
				other2Input = 0
				other2Input = $("#other2Input").val()
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(other2Input != 0){
					zongjine = zongjine + other2Input * other2Select
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
			else{
				other2Input = $("#other2Input").val()
				if(other2Input != 0 && other2Select != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "其他2费用*单位"
						zongjine = other2Input * other2Select
						}
					else{
						jisuangongshi = jisuangongshi + "+其他2费用*单位"
						zongjine = zongjine + other2Input * other2Select
						}
				$("#gongshibianliang").html(" ")
				$("#jinebianliang").html(" ")
				$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				}
			}
		});
		//其他2单位
		form.on('select(other2Select)', function(data){
			if(jisuangongshi != " " && jisuangongshi.indexOf("其他2费用费") != -1){
				zongjine = zongjine - other2Input * other2Select
				other2Select = 0
				other2Select = data.value;
				if(other2Select == "请选择单位"){
					other2Select = 0
				}
				$("#jinebianliang").html(" ")
				$("#jinebianliang").append("<div>"+zongjine+"</div>");
				if(other2Select != 0){
					zongjine = zongjine + other2Input * other2Select
					$("#jinebianliang").html(" ")
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			else{
				other2Select = data.value;
				if(other2Select == "请选择单位"){
					other2Select = 0
				}
				if(other2Input != 0 && other2Select != 0){
					if(jisuangongshi == " "){
						jisuangongshi = jisuangongshi + "其他2费用*单位"
						zongjine = other2Input * other2Select
						}
					else{
						jisuangongshi = jisuangongshi + "+其他2费用*单位"
						zongjine = zongjine + other2Input * other2Select
						}
					$("#gongshibianliang").html(" ")
					$("#jinebianliang").html(" ")
					$("#gongshibianliang").append("<div>"+jisuangongshi+"</div>");
					$("#jinebianliang").append("<div>"+zongjine+"</div>");
					}
				}
			form.render('select');
			});
		})






var paiDanOption = "<option value= ''></option>\n";
var resultData;
var obj = new Object();
 $.ajax({
	async:false,
	url:'<%=path%>/customsDeclaration/getUser.do',
	type:'get',
	success:function(data){
		resultData = data;
		//console.log(resultData)
		for(var i = 0 ; i < resultData.length ; i++){
			var id = resultData[i].id
			var userName = resultData[i].userName;
			obj[userName] = id
		} 
		//console.log(obj)
		/* for(var x in resultData){
			paiDanOption +='<option value = "'+resultData[x].userName+'">'+resultData[x].userName+'</option>\n';
		} */
		//for (var k=0;k<resultData.length; k++) {
	        $("#cangchufeiSelect").append("<option value='1'>1</option>");
	        $("#cangchufeiSelect").append("<option value='2'>2</option>");
	        $("#cangchufeiSelect").append("<option value='3'>3</option>");
	        
	        $("#baoguanfeiSelect").append("<option value='1'>1</option>");
	        $("#baoguanfeiSelect").append("<option value='2'>2</option>");
	        $("#baoguanfeiSelect").append("<option value='3'>3</option>");
	        
	        $("#shangjianfeiSelect").append("<option value='1'>1</option>");
	        $("#shangjianfeiSelect").append("<option value='2'>2</option>");
	        $("#shangjianfeiSelect").append("<option value='3'>3</option>");
	        
	        $("#zhuanguanfeiSelect").append("<option value='1'>1</option>");
	        $("#zhuanguanfeiSelect").append("<option value='2'>2</option>");
	        $("#zhuanguanfeiSelect").append("<option value='3'>3</option>");
	        
	        $("#other1Select").append("<option value='1'>1</option>");
	        $("#other1Select").append("<option value='2'>2</option>");
	        $("#other1Select").append("<option value='3'>3</option>");
	        
	        $("#other2Select").append("<option value='1'>1</option>");
	        $("#other2Select").append("<option value='2'>2</option>");
	        $("#other2Select").append("<option value='3'>3</option>");
	    //}
	    
	}
})

</script>
</html>