/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-12 11:57:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.content.main.buyorder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class BuyOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//员工操作命名空间\r\n");
      out.write("\tvar BuyOrder = {};\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\t * datagrid数据格式化\r\n");
      out.write("\t\t */\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\t * 数据表格初始化\r\n");
      out.write("\t\t */\r\n");
      out.write("\t\tvar dg = $(\"#BuyOrderDataGrid\");\r\n");
      out.write("\r\n");
      out.write("\t\t// 第一次DG加载，以后无需初始化combobox\r\n");
      out.write("\t\tvar firstLoad = true;\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#BuyOrderDataGrid\").initDatagrid({\r\n");
      out.write("\t\t\t/*\r\n");
      out.write("\t\t\t * 行编辑:saveUrl、updateUrl、destroyUrl配合uiEx使用\r\n");
      out.write("\t\t\t */\r\n");
      out.write("\t\t\turl : \"BuyOrder/list\",\r\n");
      out.write("/* \t\t\tsaveUrl : \"Activity/add\",\r\n");
      out.write("\t\t\tupdateUrl : \"Activity/update\",\r\n");
      out.write("\t\t\tdestroyUrl : \"Activity/delete\", */\r\n");
      out.write("\t\t\tidField : \"orderId\",\r\n");
      out.write("\t\t\tshowHeaderContextMenu : true, // 表头添加右键菜单，可选择显示的列\r\n");
      out.write("\t\t\tpagination : true,\r\n");
      out.write("\t\t\tcheckbox : true,\r\n");
      out.write("\t\t\tcheckOnSelect : true,\r\n");
      out.write("\t\t\tsingleSelect : false,\r\n");
      out.write("\t\t\tautoSave : true,\r\n");
      out.write("\t\t\t//queryParam:{\"rows\":dg.datagrid(\"options\").pageSize},\r\n");
      out.write("\t\t\tclickEdit : true, //单击编辑\r\n");
      out.write("\t\t\tshowMsg : true, // 显示操作消息\r\n");
      out.write("\t\t\t//右键菜单\r\n");
      out.write("\t\t\tmenuSelector : \"#BuyOrderContextMenu\",\r\n");
      out.write("\t\t\tshowContextMenu : true,\r\n");
      out.write("\t\t\tsendRowDataPrefix : \"\", //提交数据前缀\r\n");
      out.write("\t\t\tsuccessKey : \"statusCode\", //服务器端返回的成功标记key\r\n");
      out.write("\t\t\tsuccessValue : \"200\", //服务器端返回的成功标记value\r\n");
      out.write("\t\t\tonLoadSuccess : function(data) {\r\n");
      out.write("\t\t\t\t// 第一次DG加载，以后无需初始化combobox\r\n");
      out.write("\t\t\t\t//if (firstLoad) {\r\n");
      out.write("\t\t\t\t\t// 部门数据集合，添加和修改时无需去服务器查询\r\n");
      out.write("\t\t\t\t\tBuyOrder.allList = data.allCoach;\r\n");
      out.write("\t\t\t\t\t$('#orderId').combobox({\r\n");
      out.write("\t\t\t\t\t\tdata : BuyOrder.allList,\r\n");
      out.write("\t\t\t\t\t\tvalueField : '',\r\n");
      out.write("\t\t\t\t\t\ttextField : 'acContent',\r\n");
      out.write("\t\t\t\t\t\tpanelHeight : 'auto',\r\n");
      out.write("\t\t\t\t\t\teditable : false\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\tfirstLoad = false;\r\n");
      out.write("\t\t\t\t//}\r\n");
      out.write("\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t//双击操作\r\n");
      out.write("\t\t\tonDblClickRow : function(rowIndex, rowData) {\r\n");
      out.write("\t\t\t\ttoEdit(rowData); \r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmutipleDelete : true, // 多行提交删除\r\n");
      out.write("\t\t\tmutipleDeleteProperty : \"orderId\" // 多行删除时提及给服务器的属性和值，不会添加sendRowDataPrefix前缀，支持使用数组指定多个属性名\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table id=\"BuyOrderDataGrid\" title=\"用户购卡记录列表\" style=\"width: 100%\" toolbar=\"#BuyOrderToolbar\"\r\n");
      out.write("\tidField=\"orderId\" rownumbers=\"true\" fitColumns=\"true\" nowrap=\"false\">\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th field=\"ck\" checkbox=\"true\" width=\"50\" sortable=\"true\">多选框</th>\r\n");
      out.write("\t\t    <th field=\"userId\" width=\"50\" sortable=\"true\">用户ID</th>\r\n");
      out.write("\t\t\t<th field=\"cardName\" width=\"50\" sortable=\"true\">卡名称</th><!-- 这里的field一定要与后端字段对应上，否则前端无法对应上就显示不出数据 -->\r\n");
      out.write("\t\t\t<th field=\"cardType\" width=\"50\" sortable=\"true\">卡种类</th>\r\n");
      out.write("\t\t\t<th field=\"cardPrice\" width=\"50\" sortable=\"true\">价格</th>\r\n");
      out.write("\t\t\t<th field=\"cardCourse\" width=\"50\" sortable=\"true\">课程</th>\r\n");
      out.write("\t\t\t<th field=\"cardDate\" width=\"50\" sortable=\"true\">使用期限天数</th>\r\n");
      out.write("\t\t\t<th field=\"cardSite\" width=\"50\" sortable=\"true\">场地</th>\r\n");
      out.write("\t\t\t<th field=\"cardFaceAmount\" width=\"50\" sortable=\"true\">面额</th>\r\n");
      out.write("\t\t\t<th field=\"useNumber\" width=\"50\" sortable=\"true\">使用次数</th>\r\n");
      out.write("\t\t\t<th field=\"cardSalesMan\" width=\"50\" sortable=\"true\">销售人员</th>\r\n");
      out.write("\t\t\t<th field=\"cardState\" width=\"50\" sortable=\"true\">状态</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}