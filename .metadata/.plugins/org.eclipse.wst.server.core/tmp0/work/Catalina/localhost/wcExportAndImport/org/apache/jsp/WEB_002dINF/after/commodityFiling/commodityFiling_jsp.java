/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2020-02-11 03:12:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.after.commodityFiling;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class commodityFiling_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>产品信息</title>\r\n");
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
      out.write("<form class=\"layui-form\" action=\"");
      out.print(path);
      out.write("/commodityFiling/exportCommodityFiling.do\" method=\"get\" id=\"data-form\">\r\n");
      out.write("  <div class=\"layui-form-item form-inline\">\r\n");
      out.write("   <div class=\"layui-input-inline\" style=\"width:120px;\">\r\n");
      out.write("      <select name=\"serachstatusinput\" id=\"serachstatusinput\" lay-verify=\"required\">\r\n");
      out.write("      \t<option value=\"\">请选择状态</option>\r\n");
      out.write("        <option value=\"0\">未审核</option>\r\n");
      out.write("        <option value=\"1\">审核通过</option>\r\n");
      out.write("        <option value=\"-1\">审核失败</option>\r\n");
      out.write("      </select>\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \r\n");
      out.write("    <div class=\"layui-input-inline\" style=\"width:120px;\">\r\n");
      out.write("      <select name=\"serachname\" id=\"serachname\" lay-verify=\"required\">\r\n");
      out.write("        <option value=\"hsCode\">HS编号</option>\r\n");
      out.write("      </select>\r\n");
      out.write("  </div>\r\n");
      out.write("    <div class=\"layui-input-inline\">\r\n");
      out.write("      <input type=\"text\" id=\"getValue\" placeholder=\"请输入关键词\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("      <input id=\"ids\" name=\"ids\" type=\"hidden\">\r\n");
      out.write("    </div>\r\n");
      out.write("     <button class=\"layui-btn\" type=\"button\" id=\"btnSerach\" data-type=\"reload\" onclick=\"\">搜索</button>\r\n");
      out.write("  </div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"col-sm-12 select-table\">\r\n");
      out.write("\t\t<!-- <button type=\"button\" class=\"layui-btn layui-btn-sm\" onclick=\"comAudit()\"> 审核\r\n");
      out.write("    \t</button> -->\r\n");
      out.write("    \t<button type=\"button\" class=\"layui-btn layui-btn-sm\" onclick ='$.operate.exportOrderOut()'>\r\n");
      out.write("  \t\t\t<i class=\"layui-icon\">&#xe601;</i> 导出\r\n");
      out.write("    \t</button>\r\n");
      out.write("    \t<button type=\"button\" class=\"layui-btn layui-btn-sm\" onclick ='importCommodityFiling()'>\r\n");
      out.write("  \t\t\t<i class=\"layui-icon\">&#xe681;</i> 导入\r\n");
      out.write("    \t</button>\r\n");
      out.write("\t\t<table class=\"layui-hide\" id=\"layuiTable\" lay-data=\"idTest\" lay-filter=\"layuiTable\" style=\"margin-bottom: -17px;\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("<script>\r\n");
      out.write("var tableID\r\n");
      out.write("//入口方法 \r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar options = {\r\n");
      out.write("\t\t\t//初始显示所有地址\r\n");
      out.write("\t\t\turl : '");
      out.print(path);
      out.write("/commodityFiling/findAfterCommodityFiling.do',\r\n");
      out.write("\t\t\t//生成 Layui table 的标识 id，必须提供，用于后文刷新操作\r\n");
      out.write("\t\t\t id: \"queryOrders\", \r\n");
      out.write("\t\t\t//显示字段\r\n");
      out.write("\t\t\tcols: [[ //表头\r\n");
      out.write("\t                    {type:'checkbox', fixed: 'left',templet :function (row){ \r\n");
      out.write("\t                   \t   var id = row.id;\r\n");
      out.write("\t                     }}\r\n");
      out.write("\t                    ,{field: 'itemNumber', title: '货号',align: 'center'}\r\n");
      out.write("\t                    ,{field: 'barCode', title: '条形码'}\r\n");
      out.write("\t                    ,{field: 'itemChName', title: '产品中文名称',align: 'center',}\r\n");
      out.write("\t                    ,{field: 'itemEnName', title: '产品英文名称',align: 'center',} \r\n");
      out.write("\t                    ,{field: 'hsCode', title: 'HS编码',align: 'center',}\r\n");
      out.write("\t                    ,{field: 'netWeight', title: '单个净重',align: 'center'}\r\n");
      out.write("\t                    /* ,{field: 'userId', title: '创建人',align: 'center'} */\r\n");
      out.write("\t                    ,{field: 'createTime', title: '创建时间',align: 'center',templet :function (row){\r\n");
      out.write("\t                        return createTime(row.createTime);\r\n");
      out.write("\t                    }}\r\n");
      out.write("\t                    ,{field: 'hsCodeStatus', title: '税号状态',align: 'center',templet :function (d){\r\n");
      out.write("\t                 \t   if (d.hsCodeStatus =='0'){\r\n");
      out.write("\t                            return '异常'\r\n");
      out.write("\t                        }else if(d.hsCodeStatus =='1'){\r\n");
      out.write("\t                            return '正常'\r\n");
      out.write("\t                        }\r\n");
      out.write("\t                    }}\r\n");
      out.write("\t                    /* ,{field: 'reviewerId', title: '审核人',align: 'center'} */\r\n");
      out.write("\t                    ,{field: 'reviewTime', title: '审核时间',align: 'center',templet :function (row){\r\n");
      out.write("\t                        return createTime(row.reviewTime);\r\n");
      out.write("\t                    }}\r\n");
      out.write("\t                    ,{field: 'reviewStatus', title: '审核状态',align: 'center',templet :function (d){\r\n");
      out.write("\t                 \t   if (d.reviewStatus =='1'){\r\n");
      out.write("\t                            return '审核通过'\r\n");
      out.write("\t                        }else if(d.reviewStatus =='-1'){\r\n");
      out.write("\t                            return '审核失败'\r\n");
      out.write("\t                        }else{\r\n");
      out.write("\t                            return '未审核'\r\n");
      out.write("\t                        }\r\n");
      out.write("\t                    }}\r\n");
      out.write("\t                    ,{field: 'companyCode', title: '企业编码',align: 'center'}\r\n");
      out.write("\t                    ,{field: 'note', title: '备注',align: 'center'}\r\n");
      out.write("\t                  ]]\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t   //根据条件查询表格数据重新加载\r\n");
      out.write("\t   active = {\r\n");
      out.write("\t\t    reload: function(){\r\n");
      out.write("\t\t    //获取用户输入内容\r\n");
      out.write("\t\t      var getValue = $(\"#getValue\");\r\n");
      out.write("\t\t      var statusValue = $(\"#serachstatusinput option:selected\").val();\r\n");
      out.write("\t\t      var getValueInput = getValue.val();\r\n");
      out.write("\t\t      var name = $('#serachname option:selected').attr(\"value\")\r\n");
      out.write("\t\t      var condition = {}\r\n");
      out.write("\t\t      if(name == \"\"){\r\n");
      out.write("\t\t    \t  condition.hsCode =\"\"\r\n");
      out.write("\t\t      }else if(name ==\"hsCode\"){\r\n");
      out.write("\t\t    \t  condition.hsCode = getValueInput\r\n");
      out.write("\t\t      }else{alert(\"赋值错误\")}\r\n");
      out.write("\t\t      if(statusValue == \"\"){\r\n");
      out.write("\t\t    \t  condition.reviewStatus = \"\"\r\n");
      out.write("\t\t      }else{\r\n");
      out.write("\t\t    \t  condition.reviewStatus = statusValue\r\n");
      out.write("\t\t    \t  }\r\n");
      out.write("\t\t      if(name == \"hsCode\"){\r\n");
      out.write("\t\t    \t  //执行重载\r\n");
      out.write("\t\t\t      layui.table.reload('queryOrders', {\r\n");
      out.write("\t\t\t        page: {\r\n");
      out.write("\t\t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("\t\t\t      }\r\n");
      out.write("\t\t\t      //根据条件查询\r\n");
      out.write("\t\t\t        ,where: condition\r\n");
      out.write("\t\t\t      }, 'data');\r\n");
      out.write("\t\t      }else if(!reviewStatus == \"\"){\r\n");
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
      out.write("\t\t      }\r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t};\r\n");
      out.write("\t  //点击搜索按钮根据用户名称查询\r\n");
      out.write("\t  $('#btnSerach').on('click',function(){\r\n");
      out.write("       var type = $(this).data('type');\r\n");
      out.write("       //alert(type)\r\n");
      out.write("       active[type] ? active[type].call(this) : '';\r\n");
      out.write("   });\r\n");
      out.write("\t//进入初始化表格方法\r\n");
      out.write("\t$.table.init(options);\r\n");
      out.write("})\r\n");
      out.write("//时间控件  作为时间格式化使用\r\n");
      out.write("function createTime(v){\r\n");
      out.write("\tvar date = new Date(v);\r\n");
      out.write("    var y = date.getFullYear();\r\n");
      out.write("    var m = date.getMonth()+1;\r\n");
      out.write("    m = m<10?'0'+m:m;\r\n");
      out.write("    var d = date.getDate();\r\n");
      out.write("    d = d<10?(\"0\"+d):d;\r\n");
      out.write("    var h = date.getHours();\r\n");
      out.write("    h = h<10?(\"0\"+h):h;\r\n");
      out.write("    var M = date.getMinutes();\r\n");
      out.write("    M = M<10?(\"0\"+M):M;\r\n");
      out.write("    var str = y+\"-\"+m+\"-\"+d+\" \"+h+\":\"+M;\r\n");
      out.write("    return str;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//导入\r\n");
      out.write("function importCommodityFiling() {\r\n");
      out.write("\tvar openUrl = \"");
      out.print(path);
      out.write("/import/importAfterCommodityFiling.jsp\";//弹出窗口的url\r\n");
      out.write("\tvar title = '产品备案导入EXCEL';//弹出窗口的title\r\n");
      out.write("\tvar iWidth = 800; //弹出窗口的宽度;\r\n");
      out.write("\tvar iHeight = 400; //弹出窗口的高度;\r\n");
      out.write("\tvar iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;\r\n");
      out.write("\tvar iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;\r\n");
      out.write("\tvar winopen = window.open(openUrl, title, 'height=' + iHeight + ',width='\r\n");
      out.write("\t\t\t+ iWidth + ',left=' + iLeft + ',top=' + iTop\r\n");
      out.write("\t\t\t+ ',toolbar=no,menubar=yes,scrollbars=no');\r\n");
      out.write("\t//监听 window.open 关闭事件\r\n");
      out.write("\t    var loop = setInterval(function() {\r\n");
      out.write("\t\t    if(winopen.closed) {  \r\n");
      out.write("\t\t        clearInterval(loop);   \r\n");
      out.write("\t\t        window.location.reload();\r\n");
      out.write("\t\t    }  \r\n");
      out.write("\t\t}, 100);\r\n");
      out.write(" }\r\n");
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
