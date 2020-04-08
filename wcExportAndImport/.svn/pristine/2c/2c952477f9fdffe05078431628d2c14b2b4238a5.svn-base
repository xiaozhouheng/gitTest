<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>派单页面</title>
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
    	<div class="form-group">
			<label class="layui-form-label">操作员</label> 
			<div class="layui-input-inline">
			<select name="paiDan" id="paiDan" class ="layui-select" lay-filter="paiDan"style="width: 150px;">
				<option>请选择操作员</option>
			</select>
			</div>
			<!-- <ul id="select" class="form-control">
			    <li id = "paiDan"style="width:150px;">
			        <div class="select-head">
			            <span class="select-head-cont"></span>
			        </div>
			    </li>
		    </ul> -->
		</div>
    </form>
    </div>
</body>
<script>
var paiDanOption = "<option value= ''></option>\n";
var resultData;
var obj = new Object();
$.ajax({
	async:false,
	url:'<%=path%>/customsDeclaration/getUser.do',
	type:'get',
	success:function(data){
		resultData = data;
		console.log(resultData)
		for(var i = 0 ; i < resultData.length ; i++){
			var id = resultData[i].id
			var userName = resultData[i].userName
			obj[userName] = id
		}
		//console.log(obj)
		/* for(var x in resultData){
			paiDanOption +='<option value = "'+resultData[x].userName+'">'+resultData[x].userName+'</option>\n';
		} */
		for (var k=0;k<resultData.length; k++) {
	        $("#paiDan").append("<option value='" + resultData[k].userName + "'>" + resultData[k].userName + "</option>");
	    }
	    
	}
})

layui.use('form', function(){
	//alert($(User.email))
	var form = layui.form; 
	form.on('select(paiDan)', function(data){
		   userData = data.value;
		   for(var i = 0 ; i < resultData.length ; i++){
			   if(userData == Object.keys(obj)[i]){
				  var userId = obj[userData]
			   }
		   }
		   console.log(userId)
		   var id = '${id}';
		if(data.value ==data.value ){
			$.ajax({
			   	async:false,
			   	url:'<%=path%>/customsDeclaration/updateExportDeclaration.do?userId='+userId+'&id='+id,
			   	type:'post',
			   	success:function(result){
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
			   })
			form.render('select');//select是固定写法 不是选择器
			}
		});
	});

</script>
</html>