/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2020-02-09 12:15:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.after.module;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class module_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>模块管理</title>\r\n");
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
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("<div class=\"col-sm-12 search-collapse\">\r\n");
      out.write("<form class=\"layui-form\" action=\"\" method=\"get\" id=\"moduleSerach\">\r\n");
      out.write("  <div class=\"layui-form-item form-inline\">\r\n");
      out.write("    <div class=\"layui-input-inline\" style=\"width:120px;\">\r\n");
      out.write("      <select name=\"serachname\" id=\"serachname\" lay-verify=\"required\">\r\n");
      out.write("        <option value=\"name\">模块名称</option>\r\n");
      out.write("        <option value=\"code\">模块编码</option>\r\n");
      out.write("      </select>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("    <div class=\"layui-input-inline\">\r\n");
      out.write("      <input type=\"text\" id=\"getValue\" placeholder=\"请输入关键词\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <button class=\"same btn\" type=\"button\" data-type=\"reload\" id=\"btnSerach\" onclick=\"\">搜索</button>\r\n");
      out.write("  </div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"col-sm-12 select-table\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"layui-btn layui-btn-sm\" onclick=\"$.operate.getAddData('40%','59%')\"data-type=\"getAddData\">\r\n");
      out.write("  \t\t\t<i class=\"layui-icon\">&#xe608;</i> 添加\r\n");
      out.write("    \t</button>\r\n");
      out.write("    \t<button type=\"button\" class=\"layui-btn layui-btn-sm\" onclick=\"$.operate.getUpdateData('38%','58%')\"data-type=\"getUpdateData\">\r\n");
      out.write("  \t\t\t<i class=\"layui-icon\">&#xe642;</i> 修改\r\n");
      out.write("    \t</button> \r\n");
      out.write("    \t<button type=\"button\" class=\"layui-btn layui-btn-sm\" onclick =\"$.operate.removeAll()\" data-type=\"getDeleteData\">\r\n");
      out.write("  \t\t\t<i class=\"layui-icon\">&#xe640;</i> 删除\r\n");
      out.write("    \t</button> \r\n");
      out.write("\t\t<table class=\"layui-hide\" id=\"layuiTable\" lay-data=\"idTest\" lay-filter=\"layuiTable\" style=\"margin-bottom: -17px;\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("<script>\r\n");
      out.write("//入口方法 \r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar options = {\r\n");
      out.write("\t\t\t//初始显示所有地址\r\n");
      out.write("\t\t\turl : '");
      out.print(path);
      out.write("/modular/findAllModular.do',\r\n");
      out.write("\t\t\t//进入修改页面的地址\r\n");
      out.write("\t\t\teditUrl : '");
      out.print(path);
      out.write("/modular/updateJump.do',\r\n");
      out.write("\t\t\t//进入添加页面的地址\r\n");
      out.write("\t\t\taddUrl :'");
      out.print(path);
      out.write("/modular/updateJump.do',\r\n");
      out.write("\t\t\t//删除地址     \r\n");
      out.write("\t\t\tremoveUrl : '");
      out.print(path);
      out.write("/modular/deleteModularByID.do',\r\n");
      out.write("\t\t\t//生成 Layui table 的标识 id，必须提供，用于后文刷新操作\r\n");
      out.write("\t\t\t id: \"queryOrders\", \r\n");
      out.write("\t\t\t//显示字段\r\n");
      out.write("\t\t\tcols: [[ //表头\r\n");
      out.write("                    {type:'checkbox', fixed: 'left'}\r\n");
      out.write("                    /* ,{field: 'id', title: '序号', sort: false, fixed: 'left', templet :function (row){\r\n");
      out.write("                 \t   return row.id;\r\n");
      out.write("                    }} */\r\n");
      out.write("                   /* ,{field: 'parentId', title: '父菜单id',align: 'center',hide: true,templet :function (row){ \r\n");
      out.write("                 \t   return row.parentId;\r\n");
      out.write("                   }} */\r\n");
      out.write("                   /* ,{field: 'parentName', title: '父菜单名称'} */\r\n");
      out.write("                   ,{field: 'name', title: '模块名称',align: 'center',}\r\n");
      out.write("                   ,{field: 'code', title: '模块编码',align: 'center',} \r\n");
      out.write("                   /* ,{field: 'sortOrder', title: '排列序号',align: 'center',} */\r\n");
      out.write("                   ,{field: 'isParent', title: '是否父菜单',align: 'center',templet :function (d){\r\n");
      out.write("                \t   if (d.isParent =='0'){\r\n");
      out.write("                           return '否'\r\n");
      out.write("                       }else{\r\n");
      out.write("                           return '是'\r\n");
      out.write("                       }\r\n");
      out.write("                    }}\r\n");
      out.write("                   ,{field: 'status', title: '状态',align: 'center',templet :function (d){\r\n");
      out.write("                \t   if (d.status =='0'){\r\n");
      out.write("                           return '删除'\r\n");
      out.write("                       }else if (d.status =='1'){\r\n");
      out.write("                           return '存在'\r\n");
      out.write("                       }\r\n");
      out.write("                     }}\r\n");
      out.write("                   ,{field: 'createTime', title: '创建时间',align: 'center',templet :function (row){\r\n");
      out.write("                       return createTime(row.createTime);\r\n");
      out.write("                   }}\r\n");
      out.write("                 ]]\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t//根据条件查询表格数据重新加载\r\n");
      out.write("\t   active = {\r\n");
      out.write("\t\t    reload: function(){\r\n");
      out.write("\t\t    //获取用户输入内容\r\n");
      out.write("\t\t      var getValue = $(\"#getValue\");\r\n");
      out.write("\t\t      var name = $('#serachname option:selected').attr(\"value\")\r\n");
      out.write("\t\t      if(name == \"name\"){\r\n");
      out.write("\t\t    \t//执行重载\r\n");
      out.write("\t\t\t      layui.table.reload('queryOrders', {\r\n");
      out.write("\t\t\t        page: {\r\n");
      out.write("\t\t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("\t\t\t      }\r\n");
      out.write("\t\t\t      //根据条件查询\r\n");
      out.write("\t\t\t        ,where: {\r\n");
      out.write("\t\t\t        \tname:getValue.val(),\r\n");
      out.write("\t\t\t        \tcode:\"\"\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t      }, 'data');\r\n");
      out.write("\t\t      }else if(name == \"code\"){\r\n");
      out.write("\t\t    \t//执行重载\r\n");
      out.write("\t\t\t      layui.table.reload('queryOrders', {\r\n");
      out.write("\t\t\t        page: {\r\n");
      out.write("\t\t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("\t\t\t      }\r\n");
      out.write("\t\t\t      //根据条件查询\r\n");
      out.write("\t\t\t        ,where: {\r\n");
      out.write("\t\t\t        \tcode:getValue.val(),\r\n");
      out.write("\t\t\t        \tname:\"\"\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t      }, 'data'); \r\n");
      out.write("\t\t      }else{\r\n");
      out.write("\t\t    \t  alert(\"致命错误！\")\r\n");
      out.write("\t\t      }\r\n");
      out.write("\t\t      \r\n");
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
