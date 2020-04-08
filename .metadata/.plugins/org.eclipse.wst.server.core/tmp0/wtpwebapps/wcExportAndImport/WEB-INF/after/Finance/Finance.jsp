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
<title>收款页面</title>
<link href="<%=path%>/statics/layui/layui-v2.5.6/css/layui.css" rel="stylesheet">
<script src="<%=path%>/statics/layui/layui-v2.5.6/layui.js"></script><!-- 开启合计自动统计列需要2.5.6版本以上 -->
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
	 <a class="layui-btn layui-btn-xs" lay-event="row"lay-filter = "paiDan">设置</a>-->
<script type="text/html" id = "tabelSelect">
   
</script>
</head>
<body class="layui-layout-body">
<div class="col-sm-12 search-collapse">
<form class="layui-form" action="<%=path%>/hsCode/exportHcode.do" method="get" id="data-form">
  <div class="layui-form-item form-inline">
  	<div class="layui-input-inline">
    	<input type="text" class="layui-input" id="startTime" placeholder="请输入开始时间" name="startTime">
    </div>
    <div class="layui-input-inline">
    	<input type="text" class="layui-input" id="endTime" placeholder="请输入开始时间" name="endTime">
    </div>
   <!--  <div class="layui-input-inline" style="width:120px;">
      <select name="serachstatus" id="serachstatus" lay-verify="required">
        <option value="status">状态</option>
      </select>
  	</div> -->
    <div class="layui-input-inline" style="width:120px;">
      <select name="orderType" id="serachtypeinput" lay-verify="required">
      	<option value="">请选择类型</option>
        <option value="0">到货</option>
        <option value="1">出货</option>
      </select>
  	</div>
   <!--  <div class="layui-input-inline" style="width:120px;">
      <select name="serachname" id="serachname" lay-verify="required">
      	<option value="">请选择条件</option>
        <option value="customsCode">海关编码</option>
        <option value="param1">业务编号</option>
      </select>
  	</div> -->
    <div class="layui-input-inline">
      <input type="text" name = "companyName" id="getValue" placeholder="请输入企业名称" autocomplete="off" class="layui-input">
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
			url : '<%=path%>/finance/findAllFFinance.do',
			//生成 Layui table 的标识 id，必须提供，用于后文刷新操作
			 id: "queryOrders", 
			//显示字段
			cols: [[ //表头
                    {type:'checkbox', fixed: 'left',totalRowText: '合计'}
                   ,{field: 'companyName', title: '企业名称',align: 'center'}
                   ,{field: 'createTime',  width: 150, title: '创建时间',align: 'center', templet :function (row){
                       return createTime(row.createTime);
                   }}
                   ,{field: 'orderNo', title: '订单编号',align: 'center'}
                   ,{field: 'orderType', title: '订单类型',align: 'center',templet :function (d){
                	   if (d.orderType =='0'){
                           return '到货'
                       }else{
                    	   return '出货' 
                       } 
                     }}
                   ,{field : 'inspectionFee', title : '查验费', align : 'center',totalRow: true}
                   ,{field : 'storageFee', title : '仓储费', align : 'center',totalRow: true}
                   ,{field : 'customsFee', title : '报关费', align : 'center',totalRow: true}
                   ,{field : 'commodityInspectionFee', title : '商检费', align : 'center',totalRow: true}
                   ,{field : 'transitFee', title : '转关费', align : 'center',totalRow: true}
                   ,{field : 'other1Fee', title : '其他费用1', align : 'center',totalRow: true}
                   ,{field : 'other2Fee', title : '其他费用1', align : 'center',totalRow: true}
                   ,{field : 'calculationFormula', width: 150, title : '计算公式', align : 'center'}
                   ,{field : 'totalAmount', title : '总金额', align : 'center',totalRow: true}
                   ,{field : 'note', title : '备注', align : 'center'}
                   /* ,{field : 'commission3', title : '查看详情', align : 'center', templet:setTitle} */
                 ]]
			}
			
	//根据条件查询表格数据重新加载
	   active = {
		    reload: function(){
		    //获取用户输入内容
		      var startTime = $("#startTime").val();
		      var endTime = $("#endTime").val();
		      var typeValue = $("#serachtypeinput option:selected").val();
		      var getValue = $("#getValue");
		      var companyName = getValue.val();
		      //var name = $('#serachname option:selected').attr("value");
		      var condition = {}
		      if(startTime == ""){
		    	  condition.startTime = null
		      }else{
		    	  condition.startTime = startTime
		    	  }
		      if(endTime == ""){
		    	  condition.endTime = null
		      }else{
		    	  condition.endTime = endTime
		    	  }
		      if(companyName == ""){
		    	  condition.companyName = null;
		      }else{
		    	  condition.companyName =companyName
		      }
		      if(typeValue == ""){
		    	  condition.orderType = null
		      }else{
		    	  condition.orderType = typeValue
		    	  }
		      if(!typeValue == ""){
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
	var btn = "<a class='layui-btn layui-btn-xs' lay-event='update' href='<%=path%>/customsDeclaration/getDeclarationByID.do?id="+id+"' >查看</a>"
	return btn;
}
layui.use(['element','laydate'],function () {
    var laydate = layui.laydate;
    laydate.render({
        elem: '#startTime' //指定元素
        ,done: function(value, date, endDate){
            $('#startTime').change();  // 一定要加上这句！！！不然没有回调！！！
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
    	var id = data.id;
    	var btn = "<a class='layui-btn layui-btn-xs' lay-event='update' onclick='getUploadFile(\""+invoice+"\",\""+id+"\")' >下载附件</a>"
    	return btn;   
      }
    function getUploadFile(invoice,id){
    	var invoice = invoice;
    	var id = id;
        var urls = "<%=path%>/page/pageContract.do?path=after/customsDeclaration/uploadFile";
        var url = urls+"&invoice="+invoice+"&id="+id; 
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