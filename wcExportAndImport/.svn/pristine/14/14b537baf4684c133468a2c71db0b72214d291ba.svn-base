<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>产品备案导入</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../statics/layui/css/layui.css" rel="stylesheet">
<script src="../statics/js/jquery.min.js"></script>
<script src="../statics/layui/layui.js"></script>
<script src="../statics/layui/layui.all.js" type="text/javascript"></script>
<script type="text/javascript" src="../statics/js/pageload.js"></script>
</head>
<body>
 <form method="post" enctype="multipart/form-data" 	action="<%=path%>/commodityFiling/ReviewCommodityFiling.do">
		<div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">导入文件：</label>
                <div class="layui-input-inline">
                    <button type="button" class="layui-btn" id="btnSubmit">
                        <i class="layui-icon"></i>选择文件
                    </button>
                    <input class="layui-upload-file" type="file" accept="undefined" name="excelFile">
                    <input type="hidden" name=file id="fRealPath">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
        <div class="layui-input-block btn-margin-left">
            <button class="layui-btn" type="submit" id="uploadBtn">确定</button>
            <button onclick="window.close()" class="layui-btn layui-btn-primary">取消</button>
        </div>
    	</div>
    	<!--导入进度条  -->
    	<!-- <div style="height: 20px;"></div>
		<div class="layui-progress layui-progress-big" lay-showPercent="yes" lay-filter="progressBar">
			<div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
		</div> -->
    </form>
</body>
<script type="text/javascript">
layui.use([ "element", "laypage", "layer", "upload"], function() {
    var element = layui.element;
        element.init();
    var laypage = layui.laypage;
    var layer = layui.layer;
    var upload = layui.upload;//主要是这个
   /*  //导入进度条
    var xhrOnProgress=function(fun) {
        xhrOnProgress.onprogress = fun; //绑定监听
        //使用闭包实现监听绑
        return function() {
            //通过$.ajaxSettings.xhr();获得XMLHttpRequest对象
            var xhr = $.ajaxSettings.xhr();
            //判断监听函数是否为函数
            if (typeof xhrOnProgress.onprogress !== 'function')
                return xhr;
            //如果有监听函数并且xhr对象支持绑定时就把监听函数绑定上去
            if (xhrOnProgress.onprogress && xhr.upload) {
                xhr.upload.onprogress = xhrOnProgress.onprogress;
            }
            return xhr;
        }
    }  */
    layui.upload.render({
        elem: '#btnSubmit',//选择文件按钮
        accept: 'file',
        exts: 'xls|xlsx',//允许上传文件格式
        auto: false,
        field:'excelFile',
        /* xhr:xhrOnProgress, 
        progress: function(e , percent) {
			//console.log("进度：" + percent + '%');
			element.progress('progressBar',percent  + '%');
		}, */
    });
     
});
</script>
</html>