/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2020-02-14 03:42:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.after.customsDeclaration;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customsDeclaration_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    ");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>进口报关</title>\r\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/statics/layui/css/layui.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/statics/layui/layui.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/statics/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/statics/js/common/common.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("/* \r\n");
      out.write("搜索框和按钮\r\n");
      out.write("*/\r\n");
      out.write(".same{\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("    border: 0;\r\n");
      out.write("    height: 38px;\r\n");
      out.write("} \r\n");
      out.write(".btn{\r\n");
      out.write("    width: 5%;\r\n");
      out.write("    color:#ffffff;\r\n");
      out.write("    background-color: #009688;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".search-collapse,.select-table{\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("    background: #fff;\r\n");
      out.write("    border-radius: 6px;\r\n");
      out.write("    margin-top: 10px;\r\n");
      out.write("    margin-left:20px;\r\n");
      out.write("    margin-right:20px;\r\n");
      out.write("    padding-top: 13px;\r\n");
      out.write("    padding-bottom: 13px;\r\n");
      out.write("    padding-left:10px;\r\n");
      out.write("    box-shadow: 1px 1px 3px rgba(0,0,0,.2);\r\n");
      out.write("}\r\n");
      out.write("/* 防止下拉框下拉值被遮盖*/\r\n");
      out.write("    .layui-table-cell {\r\n");
      out.write("        overflow: visible;\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write("    .layui-table-box {\r\n");
      out.write("        overflow: visible;\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write("    .layui-table-body {\r\n");
      out.write("        overflow: visible;\r\n");
      out.write("    }\r\n");
      out.write("    /* 调整高度 */\r\n");
      out.write("    td .layui-form-select{\r\n");
      out.write("        margin-top: -10px;\r\n");
      out.write("        margin-left: -15px;\r\n");
      out.write("        margin-right: -15px;\r\n");
      out.write("\t\t}\r\n");
      out.write("</style>\r\n");
      out.write("<!-- <input style =\" float:left;width:50px;\"name =\"paiDan\"/>\r\n");
      out.write("\t<select id=\"paiDan2\" style =\"float:right;\"name =\"paiDan\" lay-filter = \"paiDan\"></select>\r\n");
      out.write("\t <a class=\"layui-btn layui-btn-xs\" lay-event=\"row\"lay-filter = \"paiDan\">设置</a>-->\r\n");
      out.write("<script type=\"text/html\" id = \"tabelSelect\">\r\n");
      out.write("   \r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("<div class=\"col-sm-12 search-collapse\">\r\n");
      out.write("<form class=\"layui-form\" action=\"");
      out.print(path);
      out.write("/hsCode/exportHcode.do\" method=\"get\" id=\"data-form\">\r\n");
      out.write("  <div class=\"layui-form-item form-inline\">\r\n");
      out.write("  \t<div class=\"layui-input-inline\">\r\n");
      out.write("    \t<input type=\"text\" class=\"layui-input\" id=\"beginTime\" placeholder=\"请输入开始时间\" name=\"beginTime\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"layui-input-inline\">\r\n");
      out.write("    \t<input type=\"text\" class=\"layui-input\" id=\"endTime\" placeholder=\"请输入开始时间\" name=\"endTime\">\r\n");
      out.write("    </div>\r\n");
      out.write("   <!--  <div class=\"layui-input-inline\" style=\"width:120px;\">\r\n");
      out.write("      <select name=\"serachstatus\" id=\"serachstatus\" lay-verify=\"required\">\r\n");
      out.write("        <option value=\"status\">状态</option>\r\n");
      out.write("      </select>\r\n");
      out.write("  \t</div> -->\r\n");
      out.write("    <div class=\"layui-input-inline\" style=\"width:120px;\">\r\n");
      out.write("      <select name=\"serachstatusinput\" id=\"serachstatusinput\" lay-verify=\"required\">\r\n");
      out.write("      \t<option value=\"\">请选择状态</option>\r\n");
      out.write("        <option value=\"0\">未审核</option>\r\n");
      out.write("        <option value=\"1\">审核通过</option>\r\n");
      out.write("        <option value=\"2\">审核失败</option>\r\n");
      out.write("      </select>\r\n");
      out.write("  \t</div>\r\n");
      out.write("    <div class=\"layui-input-inline\" style=\"width:120px;\">\r\n");
      out.write("      <select name=\"serachname\" id=\"serachname\" lay-verify=\"required\">\r\n");
      out.write("      \t<option value=\"\">请选择条件</option>\r\n");
      out.write("        <option value=\"customsCode\">海关编码</option>\r\n");
      out.write("        <option value=\"param1\">业务编号</option>\r\n");
      out.write("      </select>\r\n");
      out.write("  \t</div>\r\n");
      out.write("    <div class=\"layui-input-inline\">\r\n");
      out.write("      <input type=\"text\" id=\"getValue\" placeholder=\"请输入关键词\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("      <input id=\"ids\" name=\"ids\" type=\"hidden\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <button class=\"same btn\" type=\"button\" data-type=\"reload\" id=\"btnSerach\">搜索</button>\r\n");
      out.write("  </div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"col-sm-12 select-table\">\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<table class=\"layui-hide\" id=\"layuiTable\" lay-data=\"idTest\" lay-filter=\"layuiTable\" style=\"margin-bottom: -17px;\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("<script>\r\n");
      out.write("//入口方法 \r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar options = {\r\n");
      out.write("\t\t\t//初始显示所有地址\r\n");
      out.write("\t\t\turl : '");
      out.print(path);
      out.write("/customsDeclaration/importDeclaration.do',\r\n");
      out.write("\t\t\t//进入修改页面的地址\r\n");
      out.write("\t\t\teditUrl : '");
      out.print(path);
      out.write("/customsDeclaration/editUi.do',\r\n");
      out.write("\t\t\t//进入添加页面的地址\r\n");
      out.write("\t\t\taddUrl :'");
      out.print(path);
      out.write("/customsDeclaration/editUi.do',\r\n");
      out.write("\t\t\t//删除地址     \r\n");
      out.write("\t\t\tremoveUrl : '");
      out.print(path);
      out.write("/customsDeclaration/delete.do',\r\n");
      out.write("\t\t\t//进入派单页面地址  \r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t    ");
      out.write("\r\n");
      out.write("\t\t\t//生成 Layui table 的标识 id，必须提供，用于后文刷新操作\r\n");
      out.write("\t\t\t id: \"queryOrders\", \r\n");
      out.write("\t\t\t//显示字段\r\n");
      out.write("\t\t\tcols: [[ //表头\r\n");
      out.write("                    {type:'checkbox', fixed: 'left'}\r\n");
      out.write("                   ,{field: 'param1', title: '业务编码',align: 'center'}\r\n");
      out.write("                   ,{field: 'companyChName', title: '企业名称',align: 'center'}\r\n");
      out.write("                   ,{field: 'createTime', title: '修改时间',align: 'center',templet :function (row){\r\n");
      out.write("                       return createTime(row.createTime);\r\n");
      out.write("                   }}\r\n");
      out.write("                   ,{field: 'status', title: '状态',align: 'center',templet :function (d){\r\n");
      out.write("                \t   if (d.status =='1'){\r\n");
      out.write("                           return '审核通过'\r\n");
      out.write("                       }else if (d.status =='2'){\r\n");
      out.write("                           return '审核失败'\r\n");
      out.write("                       }else{\r\n");
      out.write("                    \t   return '未审核' \r\n");
      out.write("                       } \r\n");
      out.write("                     }}\r\n");
      out.write("                   ,{field : 'commission1', title : '备注', align : 'center'}\r\n");
      out.write("                   ,{field : 'param3', title: '权限派单',align: 'center',templet :tabelSelect}\r\n");
      out.write("                   ,{field : 'param3', title: '收款',align: 'center',templet :tabelReceivables}\r\n");
      out.write("                   ,{field : 'commission2', title : '单据下载', align : 'center', templet:uploadFile}\r\n");
      out.write("                   ,{field : 'commission3', title : '查看详情', align : 'center', templet:setTitle}\r\n");
      out.write("                 ]]\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t//根据条件查询表格数据重新加载\r\n");
      out.write("\t   active = {\r\n");
      out.write("\t\t    reload: function(){\r\n");
      out.write("\t\t    //获取用户输入内容\r\n");
      out.write("\t\t      var beginTime = $(\"#beginTime\").val();\r\n");
      out.write("\t\t      var endTime = $(\"#endTime\").val();\r\n");
      out.write("\t\t      var statusValue = $(\"#serachstatusinput option:selected\").val();\r\n");
      out.write("\t\t      var getValue = $(\"#getValue\");\r\n");
      out.write("\t\t      var getValueInput = getValue.val();\r\n");
      out.write("\t\t      var name = $('#serachname option:selected').attr(\"value\");\r\n");
      out.write("\t\t      var condition = {}\r\n");
      out.write("\t\t      if(beginTime == \"\"){\r\n");
      out.write("\t\t    \t  condition.beginTime = null\r\n");
      out.write("\t\t      }else{\r\n");
      out.write("\t\t    \t  condition.beginTime = beginTime\r\n");
      out.write("\t\t    \t  }\r\n");
      out.write("\t\t      if(endTime == \"\"){\r\n");
      out.write("\t\t    \t  condition.endTime = null\r\n");
      out.write("\t\t      }else{\r\n");
      out.write("\t\t    \t  condition.endTime = endTime\r\n");
      out.write("\t\t    \t  }\r\n");
      out.write("\t\t      if(name == \"\"){\r\n");
      out.write("\t\t    \t  condition.customsCode = null,\r\n");
      out.write("\t\t    \t  condition.param1 = null\r\n");
      out.write("\t\t      }else if(name ==\"customsCode\"){\r\n");
      out.write("\t\t    \t  condition.customsCode = getValueInput\r\n");
      out.write("\t\t      }else if(name == \"param1\"){\r\n");
      out.write("\t\t    \t  condition.param1 = getValueInput\r\n");
      out.write("\t\t      }else{alert(\"赋值错误\")}\r\n");
      out.write("\t\t      if(statusValue == \"\"){\r\n");
      out.write("\t\t    \t  condition.status = null\r\n");
      out.write("\t\t      }else{\r\n");
      out.write("\t\t    \t  condition.status = statusValue\r\n");
      out.write("\t\t    \t  }\r\n");
      out.write("\t\t      if(name == \"customsCode\"){\r\n");
      out.write("\t\t    \t  //执行重载\r\n");
      out.write("\t\t\t      layui.table.reload('queryOrders', {\r\n");
      out.write("\t\t\t        page: {\r\n");
      out.write("\t\t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("\t\t\t      }\r\n");
      out.write("\t\t\t      //根据条件查询\r\n");
      out.write("\t\t\t        ,where: condition\r\n");
      out.write("\t\t\t        /* {\r\n");
      out.write("\t\t\t        \tcustomsCode:getValueInput,\r\n");
      out.write("\t\t\t        \tparam1:\"\",\r\n");
      out.write("\t\t\t        \tbeginTime : beginTime,\r\n");
      out.write("\t\t\t        \tendTime : endTime,\r\n");
      out.write("\t\t\t        \tstatus:statusValue,\r\n");
      out.write("\t\t\t        } */\r\n");
      out.write("\t\t\t      }, 'data');\r\n");
      out.write("\t\t      }else if(name == \"param1\"){\r\n");
      out.write("\t\t    \t//执行重载\r\n");
      out.write("\t\t\t      layui.table.reload('queryOrders', {\r\n");
      out.write("\t\t\t        page: {\r\n");
      out.write("\t\t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("\t\t\t      }\r\n");
      out.write("\t\t\t      //根据条件查询\r\n");
      out.write("\t\t\t        ,where: condition\r\n");
      out.write("\t\t\t      }, 'data'); \r\n");
      out.write("\t\t      }else if(!statusValue == \"\"){\r\n");
      out.write("\t\t    \t//执行重载\r\n");
      out.write("\t\t\t      layui.table.reload('queryOrders', {\r\n");
      out.write("\t\t\t        page: {\r\n");
      out.write("\t\t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("\t\t\t      }\r\n");
      out.write("\t\t\t      //根据条件查询\r\n");
      out.write("\t\t\t        ,where: condition\r\n");
      out.write("\t\t\t      }, 'data'); \r\n");
      out.write("\t\t      }else{\r\n");
      out.write("\t\t    \t   layui.table.reload('queryOrders', {\r\n");
      out.write("\t\t\t\t        page: {\r\n");
      out.write("\t\t\t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("\t\t\t\t      }\r\n");
      out.write("\t\t\t\t      //根据条件查询\r\n");
      out.write("\t\t\t\t        ,where: condition\r\n");
      out.write("\t\t\t\t      }, 'data'); \r\n");
      out.write("\t\t      } \r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t};\r\n");
      out.write("\t  //点击搜索按钮根据用户名称查询\r\n");
      out.write("\t  $('#btnSerach').on('click',\r\n");
      out.write("      function(){\r\n");
      out.write("          var type = $(this).data('type');\r\n");
      out.write("          active[type] ? active[type].call(this) : '';\r\n");
      out.write("      });\r\n");
      out.write("\t//进入初始化表格方法\r\n");
      out.write("\t$.table.init(options);\r\n");
      out.write("})\r\n");
      out.write("function setTitle(data){\r\n");
      out.write("\tvar id = data.id;\r\n");
      out.write("\tvar btn = \"<a class='layui-btn layui-btn-xs' lay-event='update' href='");
      out.print(path);
      out.write("/customsDeclaration/getDeclarationByID.do?id=\"+id+\"' >查看</a>\"\r\n");
      out.write("\treturn btn;\r\n");
      out.write("}\r\n");
      out.write("function tabelSelect(data){\r\n");
      out.write("\tvar  id = data.id;\r\n");
      out.write("\tvar Pid = data.param3;\r\n");
      out.write("\tvar btn = \"\";\r\n");
      out.write("\tif(Pid !=null){\r\n");
      out.write("\t\t btn +=\"<a class='layui-btn layui-btn-xs' lay-event='update' lay-filter = 'paiDan' onclick='getSendOrder(\"+id+\")'>已派单</a>\";\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t btn +=\"<a class='layui-btn layui-btn-xs' lay-event='update' lay-filter = 'paiDan' onclick='getSendOrder(\"+id+\")'>派单</a>\";\r\n");
      out.write("\t}\r\n");
      out.write("\t return btn;\r\n");
      out.write("}\r\n");
      out.write("//进入派单页面地址\r\n");
      out.write("function getSendOrder(id){\r\n");
      out.write("\tvar id = id;\r\n");
      out.write("    var urls = \"");
      out.print(path);
      out.write("/page/updateJump.do?path=after/customsDeclaration/sendOrder\";\r\n");
      out.write("    var url = urls+\"&id=\"+id; \r\n");
      out.write("\tlayer.open({\r\n");
      out.write("    \t  title: '上传文件',\r\n");
      out.write("    \t  type: 2,\r\n");
      out.write("    \t  closeBtn: 2,\r\n");
      out.write("    \t  content: url,\r\n");
      out.write("    \t  //btn: ['保存', '取消'],\r\n");
      out.write("    \t  isOutAnim : true,\r\n");
      out.write("    \t  maxmin  : true,\r\n");
      out.write("    \t  anim : 2 ,\r\n");
      out.write("    \t  area : ['23%','40%'],\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function tabelReceivables(data){\r\n");
      out.write("\tvar  id = data.id;\r\n");
      out.write("\tvar btn = \"<a class='layui-btn layui-btn-xs' lay-event='update' lay-filter = 'paiDan' onclick='getReceivables(\"+id+\")'>收款</a>\";\r\n");
      out.write("\treturn btn;\r\n");
      out.write("}\r\n");
      out.write("//进入收款页面地址\r\n");
      out.write("function getReceivables(id){\r\n");
      out.write("\tvar id = id;\r\n");
      out.write("    var urls = \"");
      out.print(path);
      out.write("/page/updateJump.do?path=after/customsDeclaration/ImportReceivables\";\r\n");
      out.write("    var url = urls+\"&id=\"+id; \r\n");
      out.write("\tlayer.open({\r\n");
      out.write("    \t  title: '收款页面',\r\n");
      out.write("    \t  type: 2,\r\n");
      out.write("    \t  closeBtn: 2,\r\n");
      out.write("    \t  content: url,\r\n");
      out.write("    \t  btn: ['保存', '取消'],\r\n");
      out.write("    \t  isOutAnim : true,\r\n");
      out.write("    \t  maxmin  : true,\r\n");
      out.write("    \t  anim : 2 ,\r\n");
      out.write("    \t  area : ['40%','59%'],\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("layui.use(['element','laydate'],function () {\r\n");
      out.write("    var laydate = layui.laydate;\r\n");
      out.write("    laydate.render({\r\n");
      out.write("        elem: '#beginTime' //指定元素\r\n");
      out.write("        ,done: function(value, date, endDate){\r\n");
      out.write("            $('#beginTime').change();  // 一定要加上这句！！！不然没有回调！！！\r\n");
      out.write("            //alert(); //得到日期生成的值，如：2017-08-18\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("    laydate.render({\r\n");
      out.write("        elem: '#endTime' //指定元素\r\n");
      out.write("    });\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//文件上传 \r\n");
      out.write("    function uploadFile(data){\r\n");
      out.write("    \tvar invoice = data.invoice;\r\n");
      out.write("    \tvar id = data.id;\r\n");
      out.write("    \tvar btn = \"<a class='layui-btn layui-btn-xs' lay-event='update' onclick='getUploadFile(\\\"\"+invoice+\"\\\",\\\"\"+id+\"\\\")' >下载附件</a>\"\r\n");
      out.write("    \treturn btn;   \r\n");
      out.write("      }\r\n");
      out.write("    function getUploadFile(invoice,id){\r\n");
      out.write("    \tvar invoice = invoice;\r\n");
      out.write("    \tvar id = id;\r\n");
      out.write("        var urls = \"");
      out.print(path);
      out.write("/page/pageContract.do?path=after/customsDeclaration/uploadFile\";\r\n");
      out.write("        var url = urls+\"&invoice=\"+invoice+\"&id=\"+id; \r\n");
      out.write("    \tlayer.open({\r\n");
      out.write("\t    \t  title: '上传文件',\r\n");
      out.write("\t    \t  type: 2,\r\n");
      out.write("\t    \t  closeBtn: 2,\r\n");
      out.write("\t    \t  content: url,\r\n");
      out.write("\t    \t  //btn: ['保存', '取消'],\r\n");
      out.write("\t    \t  isOutAnim : true,\r\n");
      out.write("\t    \t  maxmin  : true,\r\n");
      out.write("\t    \t  anim : 2 ,\r\n");
      out.write("\t    \t  area : ['40%','50%'],\r\n");
      out.write("\t    \t  /* yes: function(index, layero){\r\n");
      out.write("\t    \t\t  \t//按钮【按钮一】的回调\r\n");
      out.write("\t    \t\t  var iframeWin = layero.find('iframe')[0];\r\n");
      out.write("      \t          iframeWin.contentWindow.submitHandler();\r\n");
      out.write("\t    \t  },\r\n");
      out.write("\t    \t  btn2: function(index, layero){\r\n");
      out.write("\t    \t\t  \t//按钮【按钮二】的回调\r\n");
      out.write("\t    \t\t  layer.close(index);\r\n");
      out.write("\t    \t\t  //return false 开启该代码可禁止点击该按钮关闭\r\n");
      out.write("\t    \t  } */\r\n");
      out.write("\t    });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
