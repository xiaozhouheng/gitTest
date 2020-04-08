<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HSCODE税号</title>
<link href="<%=path%>/statics/layui/css/layui.css" rel="stylesheet">
<script src="<%=path%>/statics/layui/layui.js"></script>
<script src="<%=path%>/statics/js/jquery.min.js"></script>
<script src="<%=path%>/statics/js/common/common.js"></script>
<style>
/* 
搜索框和按钮
*/
.same{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    border: 0;
    height: 38px;
} 
.btn{
    width: 5%;
    color:#ffffff;
    background-color: #009688;
}

.search-collapse,.select-table{
	position: relative;
    background: #fff;
    border-radius: 6px;
    margin-top: 10px;
    margin-left:20px;
    margin-right:20px;
    padding-top: 13px;
    padding-bottom: 13px;
    padding-left:10px;
    box-shadow: 1px 1px 3px rgba(0,0,0,.2);
}
</style>
</head>
<body class="layui-layout-body">
<div class="col-sm-12 search-collapse">
<form class="layui-form" action="<%=path%>/hsCode/exportHcode.do" method="get" id="data-form">
  <div class="layui-form-item form-inline">
    <div class="layui-input-inline" style="width:120px;">
      <select name="serachname" id="serachname" lay-verify="required">
        <option value="hcode">hscode</option>
        <option value="itemname">商品名称</option>
      </select>
  </div>
  
    <div class="layui-input-inline">
      <input type="text" id="getValue" placeholder="请输入关键词" autocomplete="off" class="layui-input">
      <input id="ids" name="ids" type="hidden">
    </div>
    <button class="same btn" type="button" data-type="reload" id="btnSerach">搜索</button>
  </div>
</form>
</div>
<div class="col-sm-12 select-table">
		<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.getAddData('40%','59%')"data-type="getAddData">
  			<i class="layui-icon">&#xe608;</i> 添加
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.getUpdateData('38%','58%')"data-type="getUpdateData">
  			<i class="layui-icon">&#xe642;</i> 修改
    	</button> 
    	<button type="button" class="layui-btn layui-btn-sm" onclick ="$.operate.removeAll()" data-type="getDeleteData">
  			<i class="layui-icon">&#xe640;</i> 删除
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick ='importHcode()'>
  			<i class="layui-icon">&#xe681;</i> 导入
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick ='$.operate.exportOrderOut()'>
  			<i class="layui-icon">&#xe601;</i> 导出
    	</button>
    	<%-- <button type="button" class="layui-btn layui-btn-sm" onclick ="<%=path%>/import/HSCODE.xlsx" >
  			<i class="layui-icon">&#xe601;</i> 下载模板
    	</button> --%>
    	<a class="layui-btn layui-btn-sm" href='<%=path%>/import/HSCODE.xlsx'><i class="layui-icon">&#xe601;</i>下载模板</a>
		<table class="layui-hide" id="layuiTable" lay-data="idTest" lay-filter="layuiTable" style="margin-bottom: -17px;"></table>
	</div>
<script>
//入口方法 
$(function(){
	var options = {
			//初始显示所有地址
			url : '<%=path%>/hsCode/getAllHsCode.do',
			//进入修改页面的地址
			editUrl : '<%=path%>/hsCode/editUi.do',
			//进入添加页面的地址
			addUrl :'<%=path%>/hsCode/editUi.do',
			//删除地址     
			removeUrl : '<%=path%>/hsCode/delete.do',
			//生成 Layui table 的标识 id，必须提供，用于后文刷新操作
			 id: "queryOrders", 
			//显示字段
			cols: [[ //表头
                    {type:'checkbox', fixed: 'left'}
                    /* ,{field: 'id', title: '序号', sort: false, fixed: 'left', templet :function (row){
                 	   return row.id;
                    }} */
                   ,{field: 'hcode', title: 'hcode',align: 'center'}
                   ,{field: 'itemname', title: '商品名称'}
                   ,{field: 'unit1', title: '第一单位',align: 'center',}
                   ,{field: 'unit2', title: '第二单位',align: 'center',} 
                   ,{field: 'time', title: '修改时间',align: 'center',templet :function (row){
                       return createTime(row.time);
                   }}
                   ,{field: 'userid', title: '修改人',align: 'center'}
                   ,{field: 'isok', title: '状态',align: 'center',templet :function (value){
                       return value ===1?"有":"无"}}
                   ,{field: 'bz', title: '监管要求',align: 'center'}
                 ]]
			}
			
	//根据条件查询表格数据重新加载
	   active = {
		    reload: function(){
		    //获取用户输入内容
		      var getValue = $("#getValue");
		      var name = $('#serachname option:selected').attr("value")
		      if(name == "hcode"){
		    	//执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	hcode:getValue.val(),
			        	itemname:""
			        }
			      }, 'data');
		      }else if(name == "itemname"){
		    	//执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: {
			        	itemname:getValue.val(),
			        	hcode:""
			        }
			      }, 'data'); 
		      }else{
		    	  alert("致命错误！")
		      }
		      
		   }
		};
	  //点击搜索按钮根据用户名称查询
	  $('#btnSerach').on('click',
      function(){
          var type = $(this).data('type');
          active[type] ? active[type].call(this) : '';
      });
	//进入初始化表格方法
	$.table.init(options);
})
	//导入
	function importHcode() {
		var openUrl = "<%=path%>/import/importHcode.jsp";//弹出窗口的url
		var title = 'HSCODE导入EXCEL';//弹出窗口的title
		var iWidth = 1000; //弹出窗口的宽度;
		var iHeight = 400; //弹出窗口的高度;
		var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
		window.open(openUrl, title, 'height=' + iHeight + ',width='
				+ iWidth + ',left=' + iLeft + ',top=' + iTop
				+ ',toolbar=no,menubar=yes,scrollbars=no');
	 }
	//导出
    function exportOrderOut(){
    	var checkStatus = tableCS.checkStatus("queryOrders")
    	console.log(checkStatus)
		var length = checkStatus.data.length;
    	alert(length)
    	layer.confirm("确定导出这些条数据吗？", function() {
		if(length!=0){
				if (true){ 
						var ids="";
						for(var i=0;i<length;i++){
							//判断数据为不为空
							if(i==0){
								ids += checkStatus.data[i].id;
							}else{
								ids += ','+checkStatus.data[i].id;
							}
						}
						$("#ids").val(ids);//把勾选到的rows里数据放到id为ids的input里面
			 			$("#data-form").submit();//提交id为data-form表单
				}
		}else{
			var name = $('#serachname option:selected') .val();
			$('#ids').attr("name",name)
			$('#ids').val( $("#getValue").val())
			$("#data-form").submit();//提交id为data-form表单
		}
			 })
	}
	
</script>
</body>
</html>