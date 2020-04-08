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
<title>进口报关</title>
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
/* 防止下拉框下拉值被遮盖*/
    .layui-table-cell {
        overflow: visible;
    }
 
    .layui-table-box {
        overflow: visible;
    }
 
    .layui-table-body {
        overflow: visible;
    }
    /* 调整高度 */
    td .layui-form-select{
        margin-top: -10px;
        margin-left: -15px;
        margin-right: -15px;
		}
</style>
<!-- <input style =" float:left;width:50px;"name ="paiDan"/>
	<select id="paiDan2" style ="float:right;"name ="paiDan" lay-filter = "paiDan"></select>
	 <a class="layui-btn layui-btn-xs" lay-event="row"lay-filter = "paiDan">设置</a>
<script type="text/html" id = "tabelSelect">
	<a class="layui-btn layui-btn-xs" lay-event="row"lay-filter = "paiDan" onclick="$.operate.getSendOrder('23%','40%')">派单</a>
</script>
<script type="text/html" id = "setTitle">
	<a class="layui-btn layui-btn-xs" lay-event="row"lay-filter = "details" onclick="$.operate.getDetails('90%','90%')">查看详情</a>
</script>-->
</head>
<body class="layui-layout-body">
<div class="col-sm-12 search-collapse">
<form class="layui-form" action="<%=path%>/hsCode/exportHcode.do" method="get" id="data-form">
  <div class="layui-form-item form-inline">
  	<div class="layui-input-inline">
    	<input type="text" class="layui-input" id="beginTime" placeholder="请输入开始时间" name="beginTime">
    </div>
    <div class="layui-input-inline">
    	<input type="text" class="layui-input" id="endTime" placeholder="请输入结束时间" name="endTime">
    </div>
    <!-- <div class="layui-input-inline" style="width:120px;">
      <select name="serachstatus" id="serachstatus" lay-verify="required">
        <option value="status">状态</option>
      </select>
  	</div> -->
    <div class="layui-input-inline" style="width:120px;">
      <select name="serachstatusinput" id="serachstatusinput" lay-verify="required">
      	<option value="">请选择状态</option>
        <option value="0">未审核</option>
        <option value="1">审核通过</option>
        <option value="2">审核失败</option>
      </select>
  	</div>
    <div class="layui-input-inline" style="width:120px;">
      <select name="serachname" id="serachname" lay-verify="required">
      	<option value="">请选择条件</option>
        <option value="customsCode">海关编码</option>
        <option value="param1">业务编号</option>
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
		<%--<button type="button" class="layui-btn layui-btn-sm" onclick="$.operate.getSendOrder('40%','59%')"data-type="getAddData">
  			<i class="layui-icon">&#xe608;</i>派单
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
    	<button type="button" class="layui-btn layui-btn-sm" onclick ='exportOrderOut()'>
  			<i class="layui-icon">&#xe601;</i> 导出
    	</button>
    	<button type="button" class="layui-btn layui-btn-sm" onclick ="<%=path%>/import/HSCODE.xlsx" >
  			<i class="layui-icon">&#xe601;</i> 下载模板
    	</button>
    	<a class="layui-btn layui-btn-sm" href="../../import/HSCODE.xlsx"><i class="layui-icon">&#xe601;</i>下载模板</a> --%>
		<table class="layui-hide" id="layuiTable" lay-data="idTest" lay-filter="layuiTable" style="margin-bottom: -17px;"></table>
	</div>
<script>
//入口方法 
$(function(){
	var options = {
			//初始显示所有地址
			url : '<%=path%>/customsDeclaration/exportDeclaration.do',
			//进入派单页面地址  
			orderUrl:'<%=path%>/page/updateJump.do?path=after/customsDeclaration/exportOrder',
		    <%--  orderUrl:'<%=path%>/customsDeclaration/updateJump.do', --%>
		    detailsUrl:'<%=path%>/customsDeclaration/getDeclarationByID.do',
			//生成 Layui table 的标识 id，必须提供，用于后文刷新操作
			 id: "queryOrders", 
			//显示字段
			cols: [[ //表头
                    {type:'checkbox', fixed: 'left'}
                   ,{field: 'param1', title: '业务编号',align: 'center'}
                   ,{field: 'companyChName', title: '企业名称',align: 'center'}
                   ,{field: 'createTime', title: '修改时间',align: 'center',templet :function (row){
                       return createTime(row.createTime);
                   }}
                   ,{field: 'status', title: '状态',align: 'center',templet :function (d){
                	   if (d.status =='1'){
                           return '审核通过'
                       }else if (d.status =='2'){
                           return '审核失败'
                       }else{
                    	   return '未审核' 
                       } 
                     }}
                   ,{field : 'commission1', title : '备注', align : 'center'}
                   ,{field : 'reviewId', title: '权限派单',align: 'center',templet :tabelSelect}
                   ,{field : 'commission2', title : '单据下载', align : 'center', templet:uploadFile}
                   ,{field : 'commission3', title : '查看详情', align : 'center', templet:setTitle}
                 ]]
			}
			
	//根据条件查询表格数据重新加载
	   active = {
		    reload: function(){
		    //获取用户输入内容
		      var beginTime = $("#beginTime").val();
		      var endTime = $("#endTime").val();
		      var statusValue = $("#serachstatusinput option:selected").val();
		      var getValue = $("#getValue");
		      var getValueInput = getValue.val();
		      var name = $('#serachname option:selected').attr("value");
		      var condition = {}
		      if(beginTime == ""){
		    	  condition.beginTime = ""
		      }else{
		    	  condition.beginTime = beginTime
		    	  }
		      if(endTime == ""){
		    	  condition.endTime = ""
		      }else{
		    	  condition.endTime = endTime
		    	  }
		      if(name == ""){
		    	  condition.customsCode = ""
		    	  condition.param1 = ""
		      }else if(name =="customsCode"){
		    	  condition.customsCode = getValueInput
		      }else if(name == "param1"){
		    	  condition.param1 = getValueInput
		      }else{alert("赋值错误")}
		      if(statusValue == ""){
		    	  condition.status = ""
		      }else{
		    	  condition.status = statusValue
		    	  }
		      if(name == "customsCode"){
		    	  //执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: condition
			        /* {
			        	customsCode:getValueInput,
			        	param1:"",
			        	beginTime : beginTime,
			        	endTime : endTime,
			        	status:statusValue,
			        } */
			      }, 'data');
		      }else if(name == "param1"){
		    	//执行重载
			      layui.table.reload('queryOrders', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			      }
			      //根据条件查询
			        ,where: condition
			      }, 'data'); 
		      }else if(!statusValue == ""){
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
	  $('#btnSerach').on('click',
   function(){
       var type = $(this).data('type');
       active[type] ? active[type].call(this) : '';
   });
	//进入初始化表格方法
	$.table.init(options);
})
function setTitle(data){
	var id = data.id;
	var btn = "<a class='layui-btn layui-btn-xs' lay-event='update' href='<%=path%>/customsDeclaration/getExportDeclarationByID.do?id="+id+"' >查看</a>"
	return btn;
}
/* function tabelSelect(data){
	var  id = data.id;
	var Pid = data.reviewId;
	var btn1 = "<a class='layui-btn layui-btn-xs' lay-event='row' lay-filter = 'paiDan' onclick='getSendOrder("+id+")>派单</a>"
	var btn2 = "<a class='layui-btn layui-btn-xs' lay-event='update' onclick='getSendOrder("+id+")'>已派单</a>"
	if(Pid !=null){
		return btn2;
	}else{
		return btn1;
	}
	 return btn;
} */
function tabelSelect(data){
	var  id = data.id;
	var Pid = data.reviewId;
	var btn = "";
	if(Pid !=null){
		 btn +="<a class='layui-btn layui-btn-xs' lay-event='update' lay-filter = 'paiDan' onclick='getSendOrder("+id+")'>已派单</a>";
	}else{
		 btn +="<a class='layui-btn layui-btn-xs' lay-event='update' lay-filter = 'paiDan' onclick='getSendOrder("+id+")'>派单</a>";
	}
	 return btn;
}

//出口进入派单页面地址
function getSendOrder(id){
	var id = id;
    var urls = "<%=path%>/page/updateJump.do?path=after/customsDeclaration/exportOrder";
    var url = urls+"&id="+id; 
	layer.open({
    	  title: '上传文件',
    	  type: 2,
    	  closeBtn: 2,
    	  content: url,
    	  //btn: ['保存', '取消'],
    	  isOutAnim : true,
    	  maxmin  : true,
    	  anim : 2 ,
    	  area : ['23%','40%'],
    });
}

layui.use(['element','laydate'],function () {
    var laydate = layui.laydate;
    laydate.render({
        elem: '#beginTime' //指定元素
        ,done: function(value, date, endDate){
            $('#beginTime').change();  // 一定要加上这句！！！不然没有回调！！！
            //alert(); //得到日期生成的值，如：2017-08-18
        }
    });
    laydate.render({
        elem: '#endTime' //指定元素
    });
})

    //文件上传 
    function uploadFile(data){
    	var invoice = data.invoice;
    	var btn = "<a class='layui-btn layui-btn-xs' lay-event='update' onclick='getUploadFile(\""+invoice+"\")' >下载附件</a>"
    	return btn;   
      }
    function getUploadFile(invoice){
    	var invoice = invoice;
        var urls = "<%=path%>/page/updateJump.do?path=after/customsDeclaration/uploadFile";
        var url = urls+"&id="+invoice; 
    	layer.open({
	    	  title: '上传文件',
	    	  type: 2,
	    	  closeBtn: 2,
	    	  content: url,
	    	  //btn: ['保存', '取消'],
	    	  isOutAnim : true,
	    	  maxmin  : true,
	    	  anim : 2 ,
	    	  area : ['40%','50%'],
	    	  /* yes: function(index, layero){
	    		  	//按钮【按钮一】的回调
	    		  var iframeWin = layero.find('iframe')[0];
      	          iframeWin.contentWindow.submitHandler();
	    	  },
	    	  btn2: function(index, layero){
	    		  	//按钮【按钮二】的回调
	    		  layer.close(index);
	    		  //return false 开启该代码可禁止点击该按钮关闭
	    	  } */
	    });
    }
</script>
</body>
</html>