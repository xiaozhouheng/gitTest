<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计量单位</title>
<link href="../statics/layui/css/layui.css" rel="stylesheet">
<script src="../statics/layui/layui.js"></script>
<script src="../statics/js/jquery.min.js"></script>
<link href="../statics/css/user/user.css" rel="stylesheet">
</head>
<body class="layui-layout-body">
<div>
<div class="col-sm-12 search-collapse">
<form class="layui-form">
  <div class="layui-form-item form-inline">
    <div class="layui-input-inline" style="width:120px;">
      <select name="serachname" id="serachname" lay-verify="required">
        <option value="code">编码</option>
        <option value="shortname">简称</option>
        <option value="name">全称</option>
      </select>
  </div>
  
    <div class="layui-input-inline">
      <input type="text" placeholder="请输入关键词" id="getValue" autocomplete="off" class="layui-input">
    </div>
     <button class="same btn" type="button" data-type="reload" id="btnSerach">搜索</button>
  </div>
</form>
</div>
	
	<div class="col-sm-12 select-table">
		<button type="button" class="layui-btn layui-btn-sm" lay-event="add" onclick="addUI()">
  			<i class="layui-icon">&#xe608;</i> 添加
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick="editUI()">
  			<i class="layui-icon">&#xe642;</i> 修改
    	</button> 
    	<button type="button" class="layui-btn layui-btn-sm" onclick ='editDel()'>
  			<i class="layui-icon">&#xe640;</i> 删除
    	</button>
		<table class="layui-hide" id="layuiTable" lay-filter="userTable" style="margin-bottom: -17px;"></table>
	</div>
</div>

<script>
var tableCS
layui.use(['form', 'layedit', 'laydate', 'table', 'layer','form'], function () {
    var table = layui.table;
    tableCS = table
    var form=layui.form;
    var layer = layui.layer;
    var laypage = layui.laypage;
    table.render({
         url: "<%=path%>/estimate/getAllEstimate.do"
        ,height:550
        ,elem: '#layuiTable'
        , limit: '10'/* 一页显示多少条 */
        //, limits: [5,10,15]/* //每页条数的选择项 */
        ,cellMinWidth: 100 //最小列宽
        , response: {
            statusName: 'success' //数据状态的字段名称，默认：code
            , statusCode: true //成功的状态码，默认：0
            , msgName: 'message' //状态信息的字段名称，默认：msg
            , countName: 'count' //数据总数的字段名称，默认：count
            , dataName: 'value' //数据列表的字段名称，默认：data  
        }
         ,cols: [[ //表头
                   {type:'checkbox', fixed: 'left'}
                   ,{field: 'code', title: '计量代码',align: 'center'}
                   ,{field: 'shortname', title: '简称',align: 'center'}
                   ,{field: 'name', title: '全称',align: 'center'}
                 ]]
        , page: true
        , done: function(res, curr, count){
        	//alert(res.value)
	      }
        , id: "idTest"
    });
  //根据条件查询表格数据重新加载
	  var $ = layui.$, active = {
		    reload: function(){
		    //获取用户输入内容
		      var getValue = $("#getValue");
		      var name = $('#serachname option:selected').attr("value")
		      if(name == "code"){
		    	//执行重载
			      table.reload('idTest', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	code:getValue.val(),
			        	shortname:"",
			        	name:""
			        	
			        }
			      }, 'data');
		      }else if(name == "shortname"){
		    	//执行重载
			      table.reload('idTest', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	shortname:getValue.val(),
			        	code:"",
			        	name:""
			        }
			      }, 'data'); 
		      }else if(name == "name"){
		    	//执行重载
			      table.reload('idTest', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	name:getValue.val(),
			        	code:"",
			        	shortname:""
			        }
			      }, 'data'); 
		      }else{
		    	  alert("错误")
		      }
		      
		   }
		};
	  //点击搜索按钮根据用户名称查询
	  $('#btnSerach').on('click',
      function(){
          var type = $(this).data('type');
          active[type] ? active[type].call(this) : '';
      });
  
});
// 时间控件  作为时间格式化使用
function createTime(v){
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
    var str = y+"-"+m+"-"+d+" "+h+":"+M;
    return str;
}

//新增
function addUI(id) {
	layer.open({
		type: 2,
		title: "添加用户页面",
		area: ['40%', '50%'],
		maxmin: true,//允许全屏最小化
		shadeClose: true, //开启遮罩关闭
		shade: 0.8,//遮罩透明度
		skin: 'layui-layer-rim',//加边框
		content:["<%=path%>/estimate/editUi.do", "no"]
	    });

}

//修改
function editUI() {
	//获取选中行信息
	console.log(tableCS)
	var checkStatus = tableCS.checkStatus("idTest")
	console.log(checkStatus)
    if (checkStatus.data == "") {
		layer.msg("请选择一条记录!");
		return;
	}else if(checkStatus.data.length>1){
		layer.msg("请只选择一条记录!")
		return;
	}else{
		//获取选中行的id
		var id = checkStatus.data[0].id;
		editUI2();
	}
    function editUI2(){
	layer.open({
		type: 2,
		title: "修改",
		area: ['60%', '50%'],
		maxmin: true,//允许全屏最小化
		shadeClose: true, //开启遮罩关闭
		shade: 0.8,//遮罩透明度
		skin: 'layui-layer-rim',//加边框
		content:["<%=path%>/estimate/editUi.do?id="+id, "no"],
	    })}

}

//删除
function editDel(){
	var checkStatus = tableCS.checkStatus("idTest")
	
	if(checkStatus.data.length == 0){
		layer.msg("请至少选择一条数据");
	}else if(checkStatus.data.length == 1){
		layer.confirm("确认要删除选中的" + checkStatus.data.length + "条数据吗?", function() {
		//删除一条操作
		var id = checkStatus.data[0].id;
		editDel1(id);
	})
	}
	else{
		layer.confirm("确认要删除选中的" + checkStatus.data.length + "条数据吗?", function() {
			//群体删除操作
			var id
			for(var i = 0 ; i < checkStatus.data.length ; i++ ){
				if(i==0){
					id=checkStatus.data[i].id;
				}else{
					id+=","+checkStatus.data[i].id;
				}
				
			}
			editDel1(id);
		});
		};
}
	
	function editDel1(id){
	$.ajax({
	      url:"<%=path%>/estimate/deleteEstimateByID.do?id="+id,
	      async: false,
	      type:"POST",
	      dataType: "text",
	      success: function (result) {
	    	   //把响应结果由字符串转成对象
               var obj = JSON.parse(result)
	            if (obj.status == 200) {
	            	layer.msg(obj.msg, {
	            		icon: 1,
	            		time: 1400,
	            	},function(index){
	            		//layer刷新子页面
	            		window.location.reload();
          				layer.close(index); 
            			});
	            }else{
	            	layer.msg(obj.msg,{
	            		icon: 2,
	            		time: 1400,
	            	},function(index){
	            		//layer刷新子页面
	            		window.location.reload();
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