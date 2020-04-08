<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>菜单</title>
  <link rel="stylesheet" href="./statics/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">后台管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <!-- <img src="http://t.cn/RCzsdCq" class="layui-nav-img"> -->
                                 您好！${user.userName} ${PromptMessage}
        </a>
       <!--  <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl> -->
      </li>
      <li class="layui-nav-item"><a href="http://localhost:8080/wcExportAndImport/page/login">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">用户中心</a>
          <dl class="layui-nav-child">
          <dd><a target="main" href="user/jump">用户管理</a></dd>
          <dd><a target="main" href="modular/jump">模块管理</a></dd>
           <!--  <dd><a target="main" href="./statics/html/user/userManagement.jsp">用户管理</a></dd> -->
           <!-- <dd><a target="main" href="./statics/html/user/module.jsp">模块管理</a></dd> -->
          <dd><a target="main" href="company/afterCompanyUI">企业管理</a></dd>
            <!-- <dd><a href="">超链接</a></dd> -->
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">产品管理</a>
          <dl class="layui-nav-child">
            <dd><a target="main" href="page/pageJump.do?path=after/commodityFiling/commodityFiling">产品信息</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a target="main" href="page/pageJump.do?path=after/customsDeclaration/customsDeclaration">进口报关</a>
        </li>
         <li class="layui-nav-item">
          <a target="main" href="page/pageJump.do?path=after/customsDeclaration/exportDeclaration">出口报关</a>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">数字字典</a>
          <dl class="layui-nav-child">
          	<dd><a target="main" href="page/pageJump.do?path=after/hscode/hscode">税号</a></dd>
            <dd><a target="main" href="page/pageJump.do?path=after/country/country">国家代码</a></dd>
            <dd><a target="main" href="page/pageJump.do?path=after/estimate/estimate">计量单位</a></dd>
            <!-- <dd><a href=""></a></dd> -->
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
 <iframe name="main" height="100%" width="100%" scrolling="yes"
                frameborder="0" src="./statics/html/datapushhead.jsp"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script src="./statics/layui/layui.js"></script>
<script src="./statics/js/jquery.min.js"></script>
<script>
//JavaScript代码区域
  //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });
    $(".layui-nav").on("click", "dd", function () {
        var data = $(this).attr("data");
        $("#main").attr("src", data)
    })
</script>
</body>
</html>