<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>/statics/transfer/layui/css/layui.css" rel="stylesheet">
<script src="<%=path%>/statics/transfer/layui/layui.js"></script>
<script src="<%=path%>/statics/js/jquery.min.js"></script>
<script src="<%=path%>/statics/js/common/common.js"></script>
</head>
<body>
<br>
<div id="test1" class="demo-transfer" style="position:absolute;left:20%;"></div>
<script type="text/javascript">
var getData;
var dataPrivilege = null;
var id =${id}
layui.use(['transfer', 'layer', 'util'], function(){
	var transfer = layui.transfer
	  ,layer = layui.layer
	  ,util = layui.util;
	
	$.ajax({
		type:"get",
		url:"<%=path%>/user/selectAllUsers.do",
		dataType:"json",
		success:function (res){
			//var expertList = res.value;
			var expertList = res;
			for(var i = 0 ; i < expertList.length ; i++){
			if(id == expertList[i].id){
				idValueIs = (expertList[i].dataPrivilege || "").split(",")
			}}
			transfer.render({
			    elem: '#test1',
			    data: expertList,
			    title: ["用户列表","已选用户"],
			    value: idValueIs,
				parseData:function(res){
						return{
							  "value":res.id,
							  "title":res.userName,
							}
				}, 
				 onchange:function(data,index){
					getData = transfer.getData('demo1')
					var idValue =""
					for(var i = 0;i<getData.length;i++){
						if(i==0){
							idValue=getData[i].value;
						}else{
							idValue+=","+getData[i].value;
						}
						dataPrivilege = idValue;
						//console.log(ids)
					}
				},
				id:'demo1',
			    //,showSearch: true//显示搜索框
			  })
	  		//getData = transfer.getData('demo1')
	 	}
	})
});

//console.log(getData)
function submitHandler() {
	$.ajax({
		type:"post",
		url:"<%=path%>/user/updateDataPrivilege.do",
		dataType:"json",
		data:{'userId':id,'dataPrivilege':dataPrivilege},
		success:function (result){
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
}
		</script>
</body>
</html>