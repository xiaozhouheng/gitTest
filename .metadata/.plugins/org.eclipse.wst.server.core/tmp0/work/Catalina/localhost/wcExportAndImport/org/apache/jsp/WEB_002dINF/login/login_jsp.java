/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2020-02-09 12:15:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"/>\r\n");
      out.write("<title>登录</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../statics/login/css/jquery.alerts.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../statics/login/css/headerfooterindex.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../statics/login/css/login.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../statics/login/css/login1.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/login/js/jquery-1.5.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/login/js/jquery.cookie.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/login/js/jquery.alerts.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/login/js/png.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/login/js/cas.login.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/login/js/capsLock.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"body\">\r\n");
      out.write("\t<div class=\"login-main\">\r\n");
      out.write("\t<div class=\"login-main-left\">\r\n");
      out.write("\t\t<!-- <img src=\"../statics/img/login/loginleft.png\" /> -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"login-main-right\">\r\n");
      out.write("     <!-- <div class=\"index-login\">\r\n");
      out.write("\t\t\t<div class=\"login-tab clearfix\">\r\n");
      out.write("\t\t\t\t<div class=\"float-left\"><span>用户登录</span></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"login-con\">\r\n");
      out.write("\t\t\t\t<div class=\"login-item\" style=\"display: block;\">\r\n");
      out.write("\t\t\t\t\t<span id=\"err_con_tip\" class=\"error-tip\"></span>\r\n");
      out.write("\t\t\t\t\t<form class=\"m-sign-in\" id=\"loginForm\" autocomplete=\"off\" >action = \"/user/login.do\" \r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-box\"><input name=\"username\" id=\"username\" type=\"text\" placeholder=\"用户名\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-box\"><input name=password id=\"pwd\" type=\"password\" placeholder=\"密码 \"></div>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:;\" id=\"btn\" class=\"btn-login\" onclick=\"login()\">登录</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div> -->\r\n");
      out.write("\t\t<form class=\"m-sign-in\" id=\"loginForm\" action=\"/wcExportAndImport/login\" autocomplete=\"off\" method=\"POST\">\r\n");
      out.write("\t\t<div class=\"login-content\">\r\n");
      out.write("\t\t\t\t\t<h1>用户登录</h1>\r\n");
      out.write("\t\t\t\t\t<div class=\"textbox\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"text-icon\"></i>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"username\" id =\"username\" type=\"text\" name=\"username\" placeholder=\"请输入用户名\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"userErr\" title=\"请输入用户名\" style=\"color:red;\"></span>\r\n");
      out.write("\t\t\t\t\t\t<i class=\"text-del\"></i>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"textbox \">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"text-icon password-icon\"></i>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"password\" type=\"password\" name=\"password\" placeholder=\"请输入密码\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"PwdErr\" style=\"color:red;\"></span>\r\n");
      out.write("\t\t\t\t\t\t<i class=\"text-del\"></i>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("        \t\t\t<button class=\"sublit\" type= \"submit\">登录</button>\r\n");
      out.write("        \t\t\t<p class=\"forget\">\r\n");
      out.write("        \t\t\t\t<!-- <a href=\"/client/register/a=forgetPassword\" target=\"_blanck\" class=\"passwprds\">忘记登录密码？</a> -->\r\n");
      out.write("        \t\t\t\t<a href=\"JavaScript:;\" class=\"passwprds\"></a>\r\n");
      out.write("        \t\t\t\t<a href=\"http://localhost:8080/wcExportAndImport/page/register\" class=\"registers\">免费注册</a>\r\n");
      out.write("        \t\t\t</p>\r\n");
      out.write("        \t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//实时监听输入框\r\n");
      out.write("/* $('#username').live('input propertychange', function(){\r\n");
      out.write("\t\tuserErr.innerHTML=\"\";\r\n");
      out.write("})\r\n");
      out.write("$('#password').live('input propertychange', function(){\r\n");
      out.write("\t\tPwdErr.innerHTML=\"\";\r\n");
      out.write("})\r\n");
      out.write(" function login(){\r\n");
      out.write("\tvar username = $(\"#username\").val();\r\n");
      out.write("\tvar password = $(\"#password\").val();\r\n");
      out.write("\tvar userErr = document.getElementById(\"userErr\");\r\n");
      out.write("\tvar PwdErr = document.getElementById(\"PwdErr\");\r\n");
      out.write("\t\r\n");
      out.write("\tif(!$(\"#loginForm input[name='username']\").val()) {\r\n");
      out.write("\t\tuserErr.innerHTML=\"用户名不能为空\";\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}else if(!$(\"#loginForm input[name='password']\").val()){\r\n");
      out.write("\t\tuserErr.innerHTML=\"\";\r\n");
      out.write("\t\tPwdErr.innerHTML=\"密码不能为空\";\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tuserErr.innerHTML=\"\";\r\n");
      out.write("\t\tPwdErr.innerHTML=\"\";\r\n");
      out.write("\t\tExecuteAjax()\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write(" function ExecuteAjax(){\r\n");
      out.write("\t var data = $('#loginForm').serialize();\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("\t\ttype:\"POST\",\r\n");
      out.write("\t\tasync:false,\r\n");
      out.write("\t\tdataType: \"json\",\r\n");
      out.write("\t\turl:\"/wcExportAndImport/user/login\",\r\n");
      out.write("\t\tdata:data,\r\n");
      out.write("\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\tif(data.status == 200){\r\n");
      out.write("\t\t\t\t\t\tjAlert('登录成功！',\"提示\", function(){\r\n");
      out.write("\t\t\t\t\t\t\t if(data.msg==0){   \r\n");
      out.write("\t\t\t\t\t\t\t\tlocation.href = \"http://localhost:8080/wcExportAndImport/\";         \r\n");
      out.write("\t\t\t\t\t\t\t} else {          \r\n");
      out.write("\t\t\t\t\t\t\t\tlocation.href = \"http://localhost:8080/wcExportAndImport/\";            \r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tjAlert(\"登录失败，原因是：\" + data.msg,\"失败\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\terror:function(){\r\n");
      out.write("\t\t\talert(\"崩溃了\")\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write(" } */\r\n");
      out.write("</script>\r\n");
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