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
<title>产品信息</title>
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
<form class="layui-form" action="<%=path%>/commodityFiling/exportCommodityFiling.do" method="get" id="data-form">
  <div class="layui-form-item form-inline">
   <div class="layui-input-inline" style="width:120px;">
      <select name="serachstatusinput" id="serachstatusinput" lay-verify="required">
      	<option value="">请选择状态</option>
        <option value="0">未审核</option>
        <option value="1">审核通过</option>
        <option value="-1">审核失败</option>
      </select>
  	</div>
  
    <div class="layui-input-inline" style="width:120px;">
      <select name="serachname" id="serachname" lay-verify="required">
        <option value="hsCode">HS编号</option>
      </select>
  </div>
    <div class="layui-input-inline">
      <input type="text" id="getValue" placeholder="请输入关键词" autocomplete="off" class="layui-input">
      <input id="ids" name="ids" type="hidden">
    </div>
     <button class="layui-btn" type="button" id="btnSerach" data-type="reload" onclick="">搜索</button>
  </div>
</form>
</div>
<div class="col-sm-12 select-table">
		<!-- <button type="button" class="layui-btn layui-btn-sm" onclick="comAudit()"> 审核
    	</button> -->
    	<button type="button" class="layui-btn layui-btn-sm" onclick ='$.operate.exportOrderOut()'>
  			<i class="layui-icon">&#xe601;</i> 导出
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick ='importCommodityFiling()'>
  			<i class="layui-icon">&#xe681;</i> 导入
    	</button>
		<table class="layui-hide" id="layuiTable" lay-data="idTest" lay-filter="layuiTable" style="margin-bottom: -17px;"></table>
	</div>
<script>
var tableID
//入口方法 
$(function(){
	var options = {
			//初始显示所有地址
			url : '<%=path%>/commodityFiling/findAfterCommodityFiling.do',
			//生成 Layui table 的标识 id，必须提供，用于后文刷新操作
			 id: "queryOrders", 
			//显示字段
			cols: [[ //表头
	                    {type:'checkbox', fixed: 'left',templet :function (row){ 
	                   	   var id = row.id;
	                     }}
	                    ,{field: 'itemNumber', title: '货号',align: 'center'}
	                    ,{field: 'barCode', title: '条形码'}
	                    ,{field: 'itemChName', title: '产品中文名称',align: 'center',}
	                    ,{field: 'itemEnName', title: '产品英文名称',align: 'center',} 
	                    ,{field: 'hsCode', title: 'HS编码',align: 'center',}
	                    ,{field: 'netWeight', title: '单个净重',align: 'center'}
	                    /* ,{field: 'userId', title: '创建人',align: 'center'} */
	                    ,{field: 'createTime', title: '创建时间',align: 'center',templet :function (row){
	                        return createTime(row.createTime);
	                    }}
	                    ,{field: 'hsCodeStatus', title: '税号状态',align: 'center',templet :function (d){
	                 	   if (d.hsCodeStatus =='0'){
	                            return '异常'
	                        }else if(d.hsCodeStatus =='1'){
	                            return '正常'
	                        }
	                    }}
	                    /* ,{field: 'reviewerId', title: '审核人',align: 'center'} */
	                    ,{field: 'reviewTime', title: '审核时间',align: 'center',templet :function (row){
	                        return createTime(row.reviewTime);
	                    }}
	                    ,{field: 'reviewStatus', title: '审核状态',align: 'center',templet :function (d){
	                 	   if (d.reviewStatus =='1'){
	                            return '审核通过'
	                        }else if(d.reviewStatus =='-1'){
	                            return '审核失败'
	                        }else{
	                            return '未审核'
	                        }
	                    }}
	                    ,{field: 'companyCode', title: '企业编码',align: 'center'}
	                    ,{field: 'note', title: '备注',align: 'center'}
	                  ]]
			}
			
	   //根据条件查询表格数据重新加载
	   active = {
		    reload: function(){
		    //获取用户输入内容
		      var getValue = $("#getValue");
		      var statusValue = $("#serachstatusinput option:selected").val();
		      var getValueInput = getValue.val();
		      var name = $('#serachname option:selected').attr("value")
		      var condition = {}
		      if(name == ""){
		    	  condition.hsCode =""
		      }else if(name =="hsCode"){
		    	  condition.hsCode = getValueInput
		      }else{alert("赋值错误")}
		      if(statusValue == ""){
		    	  condition.reviewStatus = ""
		      }else{
		    	  condition.reviewStatus = statusValue
		    	  }
		      if(name == "hsCode"){
		    	  //执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: condition
			      }, 'data');
		      }else if(!reviewStatus == ""){
		    	//执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: condition
			      }, 'data'); 
		      }else{
		    	   layui.table.reload('queryOrders', {
				        page: {
				          curr: 1 //重新从第 1 页开始
				      }
				      //根据条件查询
				        ,where: condition
				      }, 'data'); 
		      }
		   }
		};
	  //点击搜索按钮根据用户名称查询
	  $('#btnSerach').on('click',function(){
       var type = $(this).data('type');
       //alert(type)
       active[type] ? active[type].call(this) : '';
   });
	//进入初始化表格方法
	$.table.init(options);
})
//时间控件  作为时间格式化使用
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

//导入
function importCommodityFiling() {
	var openUrl = "<%=path%>/import/importAfterCommodityFiling.jsp";//弹出窗口的url
	var title = '产品备案导入EXCEL';//弹出窗口的title
	var iWidth = 800; //弹出窗口的宽度;
	var iHeight = 400; //弹出窗口的高度;
	var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
	var winopen = window.open(openUrl, title, 'height=' + iHeight + ',width='
			+ iWidth + ',left=' + iLeft + ',top=' + iTop
			+ ',toolbar=no,menubar=yes,scrollbars=no');
	//监听 window.open 关闭事件
	    var loop = setInterval(function() {
		    if(winopen.closed) {  
		        clearInterval(loop);   
		        window.location.reload();
		    }  
		}, 100);
 }
</script>
</body>
</html>