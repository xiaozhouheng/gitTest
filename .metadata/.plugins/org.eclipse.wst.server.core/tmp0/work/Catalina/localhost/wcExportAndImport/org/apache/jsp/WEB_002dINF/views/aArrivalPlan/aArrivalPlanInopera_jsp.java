/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.13
 * Generated at: 2020-02-10 02:14:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.aArrivalPlan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aArrivalPlanInopera_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>查询</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/bootstrap-3.3.7/dist/css/bootstrap.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/layui/css/layui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/css/track.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/css/navigation.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/css/to_create.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../statics/css/xoms.layout.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/js/StringBuilder.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/js/tools.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/bootstrap-3.3.7/dist/js/bootstrap.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../statics/layui/layui.js\"></script>\r\n");
      out.write("<!-- <script type=\"text/javascript\" src=\"../statics/js/common/common.js\"></script> -->\r\n");
      out.write("<style>\r\n");
      out.write(".order-no {\r\n");
      out.write("\twidth: 300px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".ztck-biaodan {\r\n");
      out.write("\tmargin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".order-select {\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".ztck-textarea {\r\n");
      out.write("\twidth: 225px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
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
      out.write("\tpadding-left: 0px;\r\n");
      out.write("\tpadding-right: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".bighuan {\r\n");
      out.write("\tborder: 1px dashed #F0F0F0;\r\n");
      out.write("\tborder-radius: 5px 5px 5px 5px;\r\n");
      out.write("\twidth: 1140px;\r\n");
      out.write("\tmargin-left: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".fieldName {\r\n");
      out.write("\ttext-align: right;\r\n");
      out.write("\tpadding-top: 7px;\r\n");
      out.write("\tpadding-left: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".valueName {\r\n");
      out.write("\tpadding-left: 0px;\r\n");
      out.write("}\r\n");
      out.write("/* 搜索栏 */\r\n");
      out.write(".ui-autocomplete {\r\n");
      out.write("        max-height: 50%;/* 高度值 */\r\n");
      out.write("        overflow-y: auto; /* 超过高度出现滚动条 */\r\n");
      out.write("        overflow-x: hidden;/*横向超出隐藏，如果要出现横向滚动，设置为auto即可 */\r\n");
      out.write("    }\r\n");
      out.write("    /*  IE 6不支持最大高度 \r\n");
      out.write("     *  我们使用高度代替，但这迫使菜单总是这么高。 \r\n");
      out.write("     */\r\n");
      out.write("     /**我也不知道写这个干啥，反正我们也不用IE6*/\r\n");
      out.write("    * html .ui-autocomplete {\r\n");
      out.write("        height: 300px;\r\n");
      out.write("    }\r\n");
      out.write("       .file {  \r\n");
      out.write("            position: relative;  \r\n");
      out.write("            display: inline-block;  \r\n");
      out.write("            background: #D0EEFF;  \r\n");
      out.write("            border: 1px solid #99D3F5;  \r\n");
      out.write("            border-radius: 4px;  \r\n");
      out.write("            padding: 4px 12px;  \r\n");
      out.write("            overflow: hidden;  \r\n");
      out.write("            color: #1E88C7;  \r\n");
      out.write("            text-decoration: none;  \r\n");
      out.write("            text-indent: 0;  \r\n");
      out.write("            line-height: 20px;  \r\n");
      out.write("        }  \r\n");
      out.write("        .file input {  \r\n");
      out.write("            position: absolute;  \r\n");
      out.write("            font-size: 100px;  \r\n");
      out.write("            right: 0;  \r\n");
      out.write("            top: 0;  \r\n");
      out.write("            opacity: 0;  \r\n");
      out.write("        }  \r\n");
      out.write("        .file:hover {  \r\n");
      out.write("            background: #AADFFD;  \r\n");
      out.write("            border-color: #78C3F3;  \r\n");
      out.write("            color: #004974;  \r\n");
      out.write("            text-decoration: none;  \r\n");
      out.write("        } \r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//时间控件  作为时间格式化使用\r\n");
      out.write("\tfunction createTime(v){\r\n");
      out.write("\t\tvar date = new Date(v);\r\n");
      out.write("\t    var y = date.getFullYear();\r\n");
      out.write("\t    var m = date.getMonth()+1;\r\n");
      out.write("\t    m = m<10?'0'+m:m;\r\n");
      out.write("\t    var d = date.getDate();\r\n");
      out.write("\t    d = d<10?(\"0\"+d):d;\r\n");
      out.write("\t    var h = date.getHours();\r\n");
      out.write("\t    h = h<10?(\"0\"+h):h;\r\n");
      out.write("\t    var M = date.getMinutes();\r\n");
      out.write("\t    M = M<10?(\"0\"+M):M;\r\n");
      out.write("\t    var str = y+\"-\"+m+\"-\"+d+\" \"+h+\":\"+M;\r\n");
      out.write("\t    return str;\r\n");
      out.write("\t}\r\n");
      out.write("    //当前表格中的全部数据:在表格的checkbox全选的时候没有得到数据, 因此用全局存放变量\r\n");
      out.write("    var table_data=new Array();\r\n");
      out.write("    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function(){\r\n");
      out.write("        var laydate = layui.laydate, //日期\r\n");
      out.write("            laypage = layui.laypage, //分页\r\n");
      out.write("            layer = layui.layer, //弹层\r\n");
      out.write("            table = layui.table, //表格\r\n");
      out.write("            carousel = layui.carousel, //轮播\r\n");
      out.write("            upload = layui.upload, //上传\r\n");
      out.write("            element = layui.element; //元素操作\r\n");
      out.write("        table.render({\r\n");
      out.write("            elem: '#ordermanage',\r\n");
      out.write("            url:'");
      out.print(path);
      out.write("/AArrivalPlan/getAllAArrivalPlan.do',\r\n");
      out.write("            page: true,\r\n");
      out.write("            method:'get',\r\n");
      out.write("            height:600,\r\n");
      out.write("            limit:50,\r\n");
      out.write("            limits:[50,200,500,1000],\r\n");
      out.write("            id: 'queryOrders',\r\n");
      out.write("            response: {\r\n");
      out.write("                statusName: 'success' //数据状态的字段名称，默认：code\r\n");
      out.write("                , statusCode: true //成功的状态码，默认：0\r\n");
      out.write("                , msgName: 'message' //状态信息的字段名称，默认：msg\r\n");
      out.write("                , countName: 'count' //数据总数的字段名称，默认：count\r\n");
      out.write("                , dataName: 'value' //数据列表的字段名称，默认：data  \r\n");
      out.write("            },\r\n");
      out.write("            cols: [[\r\n");
      out.write("                {type:'checkbox', fixed: 'left'},\r\n");
      out.write("                {field:'id',title:'id',align : 'center'},\r\n");
      out.write("                {field:'param1',  title: '业务编码',align :'center'},\r\n");
      out.write("                {field:'param2',  title: '销售员代码',align :'center'},\r\n");
      out.write("                {field:'importPort',  title: '进出口岸',align :'center'},\r\n");
      out.write("                {field:'estimatedArrivalTime',  title: '预计到港时间',align :'center',templet :function (row){\r\n");
      out.write("                    return createTime(row.estimatedArrivalTime);\r\n");
      out.write("                }},\r\n");
      out.write("                {field:'modeOfTransport',  title: '运输方式',align :'center',templet :function (row,value){\r\n");
      out.write("                    return value ===1?\"铁路\":\"公路\"}},\r\n");
      out.write("                {field:'mainWaybillNumber',  title: '主运单号',align :'center'},\r\n");
      out.write("                {field:'fenWaybillNumber', title: '分运单号',align :'center'},\r\n");
      out.write("                {field:'supervisionType',  title: '监管方式',align :'center',templet :function (row,value){\r\n");
      out.write("                    return value ===1?\"方式四\":\"方式三\"}},\r\n");
      out.write("                {field:'transactionType',  title: '成交方式',align :'center',templet :function (row,value){\r\n");
      out.write("                    return value ===1?\"方式二\":\"方式一\"}},\r\n");
      out.write("                {field:'customsOrderNumber',  title: '报关单号',align :'center' },\r\n");
      out.write("                {field:'uniformNumbers',  title: '统一编号',align :'center'},\r\n");
      out.write("                {field:'customsCode',  title: '企业海关编码',align :'center'},\r\n");
      out.write("                {field: 'param3', title: '上传文件',align: 'center',templet :uploadFile}\r\n");
      out.write("            ]]\r\n");
      out.write("        ,done: function(res, page, count){\r\n");
      out.write("        \t//表格列隐藏\r\n");
      out.write("        \t $(\"[data-field='id']\").css('display','none');\r\n");
      out.write("        \t//给table添加双击事件\r\n");
      out.write("            $('.layui-table-body').find(\"table\" ).find(\"tbody\").children(\"tr\").on('dblclick',function(){\r\n");
      out.write("            \t//var ids = res.value[0].id;\r\n");
      out.write("            \t/* var id = JSON.stringify($('.layui-table-body').find(\"table\" ).find(\"tbody\").find(\".layui-table-hover\").data('index')); */\r\n");
      out.write("            \tvar ids = JSON.stringify($('.layui-table-body').find(\"table\").find(\"tbody\").find(\".layui-table-hover\").find(\"td\").find(\".laytable-cell-1-id\").text())\r\n");
      out.write("                //var data = res.data[id];\r\n");
      out.write("             \tids = ids.replace(/[^0-9]/ig,\"\")\r\n");
      out.write("                location.href = \"");
      out.print(path);
      out.write("/AArrivalPlan/enditAArrivalPlan.do?id=\"+ids;\r\n");
      out.write("            });\r\n");
      out.write("     \r\n");
      out.write("   }  \r\n");
      out.write("        });  \r\n");
      out.write("            \r\n");
      out.write("   \t var $ = layui.$, active = {\r\n");
      out.write("\t\t\t    reload: function(){\r\n");
      out.write("\t              var mainWaybillNumber = $(\"#mainWaybillNumber\").val();\r\n");
      out.write("\t              var fenWaybillNumber = $(\"#fenWaybillNumber\").val();\r\n");
      out.write("\t\t\t      //执行重载\r\n");
      out.write("\t\t\t      table.reload('queryOrders', {\r\n");
      out.write("\t\t\t        page: {\r\n");
      out.write("\t\t\t          curr: 1 //重新从第 1 页开始\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        ,where: {\r\n");
      out.write("\t\t\t        \tmainWaybillNumber : mainWaybillNumber,\r\n");
      out.write("\t\t\t        \tfenWaybillNumber : fenWaybillNumber,\r\n");
      out.write("\t\t\t      }\r\n");
      out.write("\t\t\t      });\r\n");
      out.write("\t\t\t    },\r\n");
      out.write("\t }   \r\n");
      out.write("\t\t\t  $('.btn').on('click', function(){\r\n");
      out.write("\t\t\t    var type = $(this).data('type');\r\n");
      out.write("\t\t\t    active[type] ? active[type].call(this) : '';\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\r\n");
      out.write("\t\t\t  \r\n");
      out.write("});\r\n");
      out.write("     \r\n");
      out.write("    //删除\r\n");
      out.write("    function removeData(){\r\n");
      out.write("    \tvar table\r\n");
      out.write("\t\tlayui.use(['table'], function(){\r\n");
      out.write("\t\t\ttable = layui.table;\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\tvar checkStatus = table.checkStatus('queryOrders');\r\n");
      out.write("    \tif(checkStatus.data.length == 0){\r\n");
      out.write("    \t\tlayer.msg(\"请至少选择一条数据\");\r\n");
      out.write("    \t}else if(checkStatus.data.length == 1){\r\n");
      out.write("    \t\tlayer.confirm(\"确认要删除选中的\" + checkStatus.data.length + \"条数据吗?\", function() {\r\n");
      out.write("    \t\t//删除一条操作\r\n");
      out.write("    \t\tvar id = checkStatus.data[0].id;\r\n");
      out.write("    \t\tremoveDataSub(id);\r\n");
      out.write("    \t})\r\n");
      out.write("    \t}\r\n");
      out.write("    \telse{\r\n");
      out.write("    \t\tlayer.confirm(\"确认要删除选中的\" + checkStatus.data.length + \"条数据吗?\", function() {\r\n");
      out.write("    \t\t\t//群体删除操作\r\n");
      out.write("    \t\t\tvar id\r\n");
      out.write("    \t\t\tfor(var i = 0 ; i < checkStatus.data.length ; i++ ){\r\n");
      out.write("    \t\t\t\tif(i==0){\r\n");
      out.write("    \t\t\t\t\tid=checkStatus.data[i].id;\r\n");
      out.write("    \t\t\t\t}else{\r\n");
      out.write("    \t\t\t\t\tid+=\",\"+checkStatus.data[i].id;\r\n");
      out.write("    \t\t\t\t}\r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t\tremoveDataSub(id);\r\n");
      out.write("    \t\t});\r\n");
      out.write("    \t\t};\r\n");
      out.write("    }\r\n");
      out.write("    \t\r\n");
      out.write("    \tfunction removeDataSub(id){\r\n");
      out.write("    \t$.ajax({\r\n");
      out.write("    \t      url:\"");
      out.print(path);
      out.write("/AArrivalPlan/deleteAArrivalPlan.do?ids=\"+id,\r\n");
      out.write("    \t      async: false,\r\n");
      out.write("    \t      type:\"POST\",\r\n");
      out.write("    \t      dataType: \"text\",\r\n");
      out.write("    \t      success: function (result) {\r\n");
      out.write("    \t    \t   //把响应结果由字符串转成对象\r\n");
      out.write("                   var obj = JSON.parse(result)\r\n");
      out.write("    \t            if (obj.status == 200) {\r\n");
      out.write("    \t            \tlayer.msg(obj.msg, {\r\n");
      out.write("    \t            \t\ticon: 1,\r\n");
      out.write("    \t            \t\ttime: 1400,\r\n");
      out.write("    \t            \t},function(index){\r\n");
      out.write("    \t            \t\t//layer刷新子页面\r\n");
      out.write("    \t            \t\twindow.location.reload();\r\n");
      out.write("              \t\t\t\tlayer.close(index); \r\n");
      out.write("                \t\t\t});\r\n");
      out.write("    \t            }else{\r\n");
      out.write("    \t            \tlayer.msg(obj.msg,{\r\n");
      out.write("    \t            \t\ticon: 2,\r\n");
      out.write("    \t            \t\ttime: 1400,\r\n");
      out.write("    \t            \t},function(index){\r\n");
      out.write("    \t            \t\t//layer刷新子页面\r\n");
      out.write("    \t            \t\twindow.location.reload();\r\n");
      out.write("              \t\t\t\tlayer.close(index); \r\n");
      out.write("                \t\t\t});\r\n");
      out.write("    \t            }\r\n");
      out.write("    \t        },\r\n");
      out.write("    \t        error : function() {\r\n");
      out.write("    \t            alert(\"异常！\");\r\n");
      out.write("    \t        }\r\n");
      out.write("    \t      })\r\n");
      out.write("    \t   } \r\n");
      out.write("    //文件上传 \r\n");
      out.write("    function uploadFile(data){\r\n");
      out.write("    \tvar invoice = data.invoice;\r\n");
      out.write("    \tvar btn = \"<a class='layui-btn-blue layui-btn-xs' lay-event='update' onclick='getUploadFile(\\\"\"+invoice+\"\\\")' >上传附件</a>\"\r\n");
      out.write("    \treturn btn;   \r\n");
      out.write("      }\r\n");
      out.write("    function getUploadFile(invoice){\r\n");
      out.write("    \tvar invoice = invoice;\r\n");
      out.write("        var urls = \"");
      out.print(path);
      out.write("/page/updateJump.do?path=views/aArrivalPlan/uploadFile\";\r\n");
      out.write("        var url = urls+\"&id=\"+invoice; \r\n");
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
      out.write("    }\t\r\n");
      out.write("    \t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
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
      out.write("\t\t\t\t\t<li class=\"dropdown active\"><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
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
      out.write("\t\t\t\t\t<li class=\"dropdown \"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\taria-expanded=\"false\">出口货物<span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu active\">\r\n");
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
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
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
      out.write("\t\t\t <ul class=\"nav navbar-nav navbar-right\">\r\n");
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
      out.write("\t<!--\r\n");
      out.write("时间：2018-02-06\r\n");
      out.write("描述：网站主体开始\r\n");
      out.write("-->\r\n");
      out.write("\t<div class=\"xoms-secnavbar\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<ul class=\"myorder-dropdown \">\r\n");
      out.write("\t\t\t\t<li role=\"presentation\"><a\r\n");
      out.write("\t\t\t\t\thref=\"");
      out.print(path);
      out.write("/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlan\">到货计划表</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li role=\"presentation\" class=\"active\"><a\r\n");
      out.write("\t\t\t\thref=\"");
      out.print(path);
      out.write("/page/pageJump.do?path=views/aArrivalPlan/aArrivalPlanInopera\">到货计划表查询</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("        ");
      out.write("\t\r\n");
      out.write("\t    <div class=\"xoms-container\" role=\"main\">\r\n");
      out.write("\t\t<div\r\n");
      out.write("\t\t\tclass=\"container has-thirdnavbar-container myorder-container xoms-main\"\r\n");
      out.write("\t\t\tstyle=\"margin-top: -50px;\">\r\n");
      out.write("\t\t\t<div class=\"main\">\r\n");
      out.write("\t\t\t\t<div class=\"myorder-toolbar-container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"order-toolbar clearfix  col-lg-12\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pull-left xoms-btn-container operate-btn-container\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pull-right xoms-keyword-div received-search-container\">\r\n");
      out.write("\t\t\t\t\t\t\t<form id=\"queryForm\" class=\"form-inline xoms-search-form myorder-simple-search\"\r\n");
      out.write("\t\t\t\t\t\t\t\trole=\"form\" method=\"get\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>主运单号:</label><input type=\"text\" id =\"mainWaybillNumber\" class=\"form-control\" name=\"mainWaybillNumber\" value=\"\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>分运单号:</label><input type=\"text\" id =\"fenWaybillNumber\" class=\"form-control\" name=\"fenWaybillNumber\" value=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t <a class=\"btn layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"search_submit\" data-type=\"reload\"><i class=\"layui-icon\">&#xe615;</i>查询</a>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"layui-btn layui-btn-normal layui-btn-sm\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"removeData()\"><!-- data-type=\"getDeleteData\" -->\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-remove\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t删除\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<table id=\"ordermanage\" lay-filter=\"Singledata\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"height: 135px; width: 1555px;\">\r\n");
      out.write("\t\t\t\t\t    </table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 打印表单 -->\r\n");
      out.write("\t\t<form class=\"print-form\" action=\"#\" target=_blank method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"userName\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\tname=\"identity\" /> <input type=\"hidden\" name=\"data\" /> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" name=\"encipherment\" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<!-- 导出excel -->\r\n");
      out.write("\t\t<form id=\"f_orderOut_export\"\r\n");
      out.write("\t\t\taction=\"");
      out.print(path);
      out.write("/orderManage/exportOrderOut.html?\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"ids\" id=\"orderOutIDS\" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/html\" id=\"track\">\r\n");
      out.write("  <a class=\"layui-btn layui-btn-xs layui-btn-normal a\" lay-event=\"detail\" >跟踪</a>\r\n");
      out.write("</script>\r\n");
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
