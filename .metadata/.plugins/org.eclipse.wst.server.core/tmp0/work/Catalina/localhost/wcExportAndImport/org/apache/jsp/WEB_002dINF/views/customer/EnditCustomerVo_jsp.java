/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2020-02-15 05:18:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EnditCustomerVo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>修改往来客户信息</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"../statics/img/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/bootstrap-3.3.7/dist/css/bootstrap.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/css/navigation.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/css/xoms.layout.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/layui/css/layui.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"../statics/bootstrap-3.3.7/dist/js/bootstrap.js\"></script>\r\n");
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
      out.write("<body>\r\n");
      out.write("<div id=\"aaa\" style=\"margin: 5px\">\r\n");
      out.write("\t\t<form id=\"orderInfoForm\" method=\"post\" class=\"layui-form\">\r\n");
      out.write("\t\t\t<table class=\"layui-table\" name=\"orderDetail\">\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr style=\"display: none;\">\r\n");
      out.write("\t\t\t\t\t\t<th>id</th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"\" name=\"id\" id=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerInformation.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\t\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">客户代码</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" lay-verify=\"required\" class=\"layui-input\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"customerCode\" name=\"customerCode\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerInformation.customerCode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">客户地址</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" lay-verify=\"required\" class=\"layui-input\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"chAddress\" name=\"chAddress\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerInformation.chAddress}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">客户名称(中文)</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" lay-verify=\"required\" class=\"layui-input\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"customerChName\" name=\"customerChName\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerInformation.customerChName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">客户名称(英文)</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" lay-verify=\"required\" class=\"layui-input\" \r\n");
      out.write("\t\t\t\t\t\t\tid=\"customerEnName\" name=\"customerEnName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerInformation.customerEnName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">英文地址</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" lay-verify=\"required\" class=\"layui-input\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"enAddress\" name=\"enAddress\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerInformation.enAddress}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">联系人</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" lay-verify=\"required\" class=\"layui-input\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"contact\" name=\"contact\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerInformation.contact}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">电话</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" lay-verify=\"required\" class=\"layui-input\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"phone\" name=\"phone\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerInformation.phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">传真</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" lay-verify=\"required\" class=\"layui-input\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"fax\" name=\"fax\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerInformation.fax}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t//layui激活form\r\n");
      out.write("\tlayui.use('form', function(){\r\n");
      out.write("\t\tvar form = layui.form; \r\n");
      out.write("\t\tform.render();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction submitHandler() {\r\n");
      out.write("\t\t\tvar editurl ='");
      out.print(path);
      out.write("/customer/updateCustomer.do';\r\n");
      out.write("\t\t\t\t\t$.operate.save(editurl, $('#orderInfoForm').serialize());\r\n");
      out.write("\r\n");
      out.write("\t    }\r\n");
      out.write("\t</script>\r\n");
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
