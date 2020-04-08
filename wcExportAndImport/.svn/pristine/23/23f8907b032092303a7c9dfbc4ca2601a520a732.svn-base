<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>/statics/transfer/layui/css/layui.css" rel="stylesheet">
<script src="<%=path%>/statics/transfer/layui/layui.js"></script>
<script src="<%=path%>/statics/transfer/layui/layui.all.js"></script>
<script src="<%=path%>/statics/js/jquery.min.js"></script>
<script src="<%=path%>/statics/js/common/common.js"></script>
</head>
<body>
<br>
<div class="layui-form-item">
    <label class="layui-form-label sendOrder-left-paading"></label>
    <input type="hidden" id="filePath" name="filePath" />
    <div class="layui-input-inline" style="display: inline-block;position: relative;float: left;margin-right: 10px;width:80%;">
        <div class="layui-upload">
            <button type="button" class="layui-btn-blue" id="testList">选择文件</button>
            <div class="layui-upload-list">
                <table class="layui-table">
                    <thead>
                    <tr><th>文件名</th>
                        <th>大小</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr></thead>
                    <tbody id="demoList"></tbody>
                </table>
            </div>
            <button type="button" class="layui-btn-blue layui-btn-disabled" id="testListAction">开始上传</button>
        </div>
    </div>
</div>
<form action="<%=path%>/AArrivalPlan/downloadFile.do" method="get" id="btnform" class="layui-form enditform" >
        <input name="id" type="hidden" id ="fileAdress">
        
</form>
<script type="text/javascript">
var demoListView = $('#demoList')
var invoice = ${id}
//删除回显文件的id
var fileId;
//已上传文件回显
$(function(){
	$.ajax({
        type: "get",
        url: "<%=path%>/AArrivalPlan/findPicture.do",
        data:{'invoice':invoice},
        dataType: "json",
        success: function(data){
            for(var i = 0;i<data.length;i++){
            var id = data[i].id 
            fileId = id;
            var tr = $(['<tr id="upload">'
                        , '<td style = "width:200px;">' + data[i].fileName + '</td>'
                        , '<td>' + data[i].size + 'kb</td>'
                        , '<td style="color: #5FB878;">已上传</td>'
                        , '<td>'
                        , '<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete" onclick = "fileDel()">删除</button>'
                        , '<button class="layui-btn layui-btn-xs layui-btn-downLoad demo-downLoad" onclick = "downLoad('+id+')">下载</button>'
                        , '</td>'
                        , '</tr>'].join(''));
            demoListView.append(tr);
        }
	}
    });
})
//回显删除功能
function fileDel(){
	$.ajax({
        type: "post",
        url: "<%=path%>/AArrivalPlan/deleteFileByID.do",
        data:{'id':fileId},
        dataType: "json",
        success: function(data){
        	 if (data.status == 200) {
             	layer.msg(data.msg, {
             		icon: 1,
             		time: 700,
             	},function(){
         				location.reload();
             		});
             }else{
            	layer.msg(data.msg,{
            		icon: 2,
            		time: 700,
            	},function(){
        				location.reload();
            			});
            }
	}
    });
}
//回显下载文件
function downLoad(id){
	$("#fileAdress").val(id)
	$('#btnform').submit();
}

layui.use(['upload'], function(){
	var $ = layui.jquery,
	   upload = layui.upload;
//多文件列表
var uploadListIns = upload.render({
    elem: '#testList'
    , url: '<%=path%>/AArrivalPlan/uploadFile.do'
    //设置图片上传的大小
    , size: 31457280
    //设置图片上传的格式
    //, acceptMime: 'image/jpg, image/png'
    , accept:'file'
    , multiple: true
    //参数名
    , field:'files'
    //禁用自动上传
    , auto: false
    //上传按钮
    , bindAction: '#testListAction'
    //请求前的操作
    , before: function () {
        //添加参数
        var data = {}
        data.invoice = ${id};
        this.data = data;
    }
    //每一次请求结束后操作
    , choose: function (obj) {
        var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
        //读取本地文件
        obj.preview(function (index, file, result) {
        	console.log(index)
        	//console.log(file)
        	//console.log(result)
        	
            if($("#testListAction").hasClass("layui-btn-disabled")){
            	$("#testListAction").removeClass("layui-btn-disabled");
            }
            var tr = $(['<tr id="upload-' + index + '">'
                , '<td style = "width:200px;">' + file.name + '</td>'
                , '<td>' + (file.size / 1014).toFixed(1) + 'kb</td>'
                , '<td>等待上传</td>'
                , '<td>'
                , '<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                , '</td>'
                , '</tr>'].join(''));
            //单个重传  ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
            /*tr.find('.demo-reload').on('click', function(){
                obj.upload(index, file);
            });*/
            //删除
            tr.find('.demo-delete').on('click', function () {
                delete file[index]; //删除对应的文件
                tr.remove();
                uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
            });
            demoListView.append(tr);
        });
    }
    , done: function (res, index, upload) {
        if (res.status == 200) { //上传成功
        	 var tr = demoListView.find('tr#upload-' + index), tds = tr.children();
             tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
             location.reload();
            //tds.eq(3).html(''); //清空操作
            //$("#demoList").html('');
            //return delete this.files[index]; //删除文件队列已经上传成功的文件
            //this.error(index, upload);
	        }
    	}
    , error: function (res,index, upload) {
        var tr = demoListView.find('tr#upload-' + index)
            , tds = tr.children();
        tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
        tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
    		}
		})
	});
/* function noFile() {
	var content = $("#demoList").html();
	if (content== null || content == 0) {
	    layer.alert("请选择文件")
		}
	} */
</script>
</body>
</html>