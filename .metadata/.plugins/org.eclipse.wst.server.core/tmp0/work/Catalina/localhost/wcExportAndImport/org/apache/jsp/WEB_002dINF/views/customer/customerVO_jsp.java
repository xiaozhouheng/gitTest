/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2020-02-14 06:05:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customerVO_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.3.13.RELEASE.jar", Long.valueOf(1581249156883L));
    _jspx_dependants.put("jar:file:/F:/wcEorI/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/wcExportAndImport/WEB-INF/lib/spring-webmvc-4.3.13.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1511749306000L));
    _jspx_dependants.put("jar:file:/F:/wcEorI/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/wcExportAndImport/WEB-INF/lib/spring-webmvc-4.3.13.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1511749306000L));
  }

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    String path = request.getContextPath();
    String basePath = "";
    String username = "";

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<title>往来客户信息</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"../statics/img/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/bootstrap-3.3.7/dist/css/bootstrap.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/css/navigation.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/css/xoms.layout.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/layui/css/layui.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/bootstrap-3.3.7/dist/js/bootstrap.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/layui/layui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/js/common/common.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".xoms-secnavbar a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".xoms-secnavbar {\r\n");
      out.write("\tmargin-top: -20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".saveInput {\r\n");
      out.write("\tpadding-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var tableCS\r\n");
      out.write("//当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量\r\n");
      out.write("var table_data=new Array();\r\n");
      out.write("//入口方法 \r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar options = {\r\n");
      out.write("\t\t\t//初始显示所有地址\r\n");
      out.write("\t\t\turl : '");
      out.print(path);
      out.write("/customer/getAllCustomer.do',\r\n");
      out.write("\t\t\t//进入修改页面的地址\r\n");
      out.write("\t\t\teditUrl : '");
      out.print(path);
      out.write("/customer/jumpEndit.do',\r\n");
      out.write("\t\t\t//进入添加页面的地址\r\n");
      out.write("\t\t\taddUrl :'");
      out.print(path);
      out.write("/customer/jumpEndit.do',\r\n");
      out.write("\t\t\t//删除地址     \r\n");
      out.write("\t\t\tremoveUrl : '");
      out.print(path);
      out.write("/customer/delete.do',\r\n");
      out.write("\t\t\t//生成 Layui table 的标识 id，必须提供，用于后文刷新操作\r\n");
      out.write("\t\t\t id: \"queryOrders\",\r\n");
      out.write("\t\t\t//where: {  },\r\n");
      out.write("\t\t\t//显示字段\r\n");
      out.write("\t\t\tcols: [[ //表头\r\n");
      out.write("                  {type:'checkbox', fixed: 'left',templet :function (row){ \r\n");
      out.write("                \t   var id = row.id;\r\n");
      out.write("                  }}\r\n");
      out.write("                 ,{field: 'customerCode', title: '客户代码',align: 'center'}\r\n");
      out.write("                 ,{field: 'customerChName', title: '客户名称（中文）'}\r\n");
      out.write("                 ,{field: 'chAddress', title: '客户地址',align: 'center',}\r\n");
      out.write("                 ,{field: 'customerEnName', title: '客户名称（英文）',align: 'center'} \r\n");
      out.write("                 ,{field: 'enAddress', title: '英文地址',align: 'center',}\r\n");
      out.write("                 ,{field: 'contact', title: '联系人',align: 'center'}\r\n");
      out.write("                 ,{field: 'phone', title: '电话',align: 'center'}\r\n");
      out.write("                 ,{field: 'fax', title: '传真',align: 'center'}\r\n");
      out.write("                 ,{field: 'createTime', title: '创建时间',align: 'center',templet :function (row){\r\n");
      out.write("                     return createTime(row.createTime);\r\n");
      out.write("                 }}\r\n");
      out.write("                /*  ,{field: 'createId', title: '创建人',align: 'center'} */\r\n");
      out.write("               ]]\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//条件查询\r\n");
      out.write("\t\t\tactive = {\r\n");
      out.write("\t\t\t\t    reload: function(){\r\n");
      out.write("\t\t\t          var customerCode = $(\"#customerCode\").val();\r\n");
      out.write("\t\t\t\t      //执行重载\r\n");
      out.write("\t\t\t\t      layui.table.reload('queryOrders', {\r\n");
      out.write("\t\t\t\t        page: {\r\n");
      out.write("\t\t\t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("\t\t\t\t        }\r\n");
      out.write("\t\t\t\t        ,where: {\r\n");
      out.write("\t\t\t\t        \tcustomerCode : customerCode,\r\n");
      out.write("\t\t\t\t      }\r\n");
      out.write("\t\t\t\t      });\r\n");
      out.write("\t\t\t\t    },\r\n");
      out.write("\t\t\t         }   \r\n");
      out.write("\t\t         $('.btn').on('click', function(){\r\n");
      out.write("\t\t\t\t    var type = $(this).data('type');\r\n");
      out.write("\t\t\t\t    active[type] ? active[type].call(this) : '';\r\n");
      out.write("\t\t\t\t  });\r\n");
      out.write("\t//进入初始化表格方法\r\n");
      out.write("\t$.table.init(options);\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 导航栏 -->\r\n");
      out.write("\r\n");
      out.write("<!-- 导航栏开始 -->\r\n");
      out.write("<nav class=\"navbar navbar-default container-fluid\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\t\tdata-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"\r\n");
      out.write("\t\t\t\t\taria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"\">安布雷</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse \"\r\n");
      out.write("\t\t\t\tid=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav \">\r\n");
      out.write("\t\t\t\t\t<li class=\"\"><a href=\"");
      out.print(path);
      out.write("/page/pageJump.do?path=views/index\">个人中心</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\">进口货物<span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu active\">\r\n");
      out.write("\t\t\t\t\t\t\t<!--<li><a href=\"");
      out.print(path);
      out.write("/my_orders/to_create.html\">到货计划表</a></li>-->\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlan\">到货计划表</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\">出口货物<span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<!--<li><a href=\"");
      out.print(path);
      out.write("/my_orders/to_create.html\">到货计划表</a></li>-->\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/page/pageJump.do?path=views/sShippingPlan/SShippingPlan\">出货计划表</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\">企业数据库<span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/page/pageJump.do?path=views/product/productVO\">产品备案</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown active\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\">企业信息<span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<!--<li><a href=\"./company/companyUI\">企业基本信息</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/company/editCompany\">企业基本信息</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/customs/customsUI\">海关登记信息</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/customer/customerUI\">往来客户信息管理</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\">您好！");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"http://localhost:8080/wcExportAndImport/page/login\">退出</a></li>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("<!-- 导航栏结束 -->\r\n");
      out.write("\t<div class=\"xoms-secnavbar\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<ul class=\"myorder-dropdown \">\r\n");
      out.write("\t\t\t\t<li class=\"createto_create createbatch_upload\"><a\r\n");
      out.write("\t\t\t\t\thref=\"");
      out.print(path);
      out.write("/company/editCompany\">企业基本信息</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"managementinfo_received managementshipment_received managementon_delivery\r\n");
      out.write("\t\t\t\tmanagementdraft managementshipped managementpicked_up managementdelivered \">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(path);
      out.write("/customs/customsUI\">海关登记信息</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li class=\"searchindex active\"><a href=\"");
      out.print(path);
      out.write("/customer/customerUI\">往来客户信息</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"col-lg-1\"></div>\r\n");
      out.write("\t<!-- <div class=\"col-lg-10 col-xs-12 ztck-body\">\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<div class=\"container-fluid col-lg-9\">\r\n");
      out.write("\t\t\t<div class=\"row container\">\r\n");
      out.write("\t\t\t\t<div class=\"container col-lg-10 col-xs-12 ztck-body\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-1 col-xs-2 container\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t\t\t onclick=\"$.operate.getAddData('38%','50%')\">data-type=\"getAddData\" \r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-plus\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t新增\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-1 col-xs-2 container\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"$.operate.getUpdateData('38%','50%')\">data-type=\"getUpdateData\"\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-edit\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t修改\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-1 col-xs-2 container\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"$.operate.removeAll()\">data-type=\"getDeleteData\"\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-remove\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t删除\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col-lg-3 container\">\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<div class=\"input-group  col-xs-9\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"eName1\" class=\"form-control\" placeholder=\"请输入客户代码\">\r\n");
      out.write("\t\t\t\t\t<span class=\"input-group-btn\">\r\n");
      out.write("\t\t\t\t\t<a class=\"btn layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t   id=\"search_submit\" data-type=\"reload\"><i class=\"layui-icon\">&#xe615;</i></a>\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<table id=\"test\" lay-filter=\"queryOrders\"></table>\r\n");
      out.write("\t</div> -->\r\n");
      out.write("\t<div class=\"col-lg-10 col-xs-12 ztck-body\">\r\n");
      out.write("\t</br>\r\n");
      out.write("\t\t<div class=\"container\" style=\"width:1800px;\">\r\n");
      out.write("\t\t\t<div class=\"row container\">\r\n");
      out.write("\t\t\t\t<div class=\"container col-lg-10 col-xs-12 ztck-body\"style=\"width:1500px;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-1 col-xs-2 container\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t\t\t onclick=\"$.operate.getAddData('38%','50%')\"><!-- data-type=\"getAddData\" --> \r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-plus\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t新增\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-1 col-xs-2 container\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"$.operate.getUpdateData('38%','50%')\"><!-- data-type=\"getUpdateData\" -->\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-edit\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t修改\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-1 col-xs-2 container\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"$.operate.removeAll()\"><!-- data-type=\"getDeleteData\" -->\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-remove\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t删除\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"pull-right xoms-keyword-div received-search-container\">\r\n");
      out.write("\t\t\t\t\t\t<form id=\"queryForm\" class=\"form-inline xoms-search-form myorder-simple-search\"\r\n");
      out.write("\t\t\t\t\t\t\trole=\"form\" method=\"get\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>客户代码:</label><input type=\"text\" id =\"customerCode\" class=\"form-control\" name=\"customerCode\" value=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t <a class=\"btn layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"search_submit\" data-type=\"reload\"><i class=\"layui-icon\">&#xe615;</i>查询</a>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<table id=\"layuiTable\" lay-filter=\"queryOrders\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
