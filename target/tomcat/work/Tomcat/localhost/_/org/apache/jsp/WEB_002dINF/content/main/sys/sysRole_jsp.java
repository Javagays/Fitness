/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-03 14:35:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.content.main.sys;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;
import java.util.*;

public final class sysRole_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/content/main/sys/../../dialog/sys/sysRoleAdd.jsp", Long.valueOf(1519956597929L));
    _jspx_dependants.put("/WEB-INF/content/main/sys/../../dialog/sys/sysRoleEdit.jsp", Long.valueOf(1519956597916L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.release();
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
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t//角色操作命名空间\r\n");
      out.write("\tvar sysRole = {};\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\t * datagrid数据格式化\r\n");
      out.write("\t\t */\r\n");
      out.write("\t\tsysRole.formatStatus = function(val, row) {\r\n");
      out.write("\t\t\tif (val != 0) {\r\n");
      out.write("\t\t\t\treturn '<span style=\"color:red;\">禁用</span>';\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn \"正常\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\t * 数据表格初始化\r\n");
      out.write("\t\t */\r\n");
      out.write("\t\tvar dg = $(\"#sysRoleDataGrid\");\r\n");
      out.write("\t\tdg.initDatagrid({\r\n");
      out.write("\t\t\ticonCls : 'icon-group',\r\n");
      out.write("\t\t\t/*\r\n");
      out.write("\t\t\t * 行编辑:saveUrl、updateUrl、destroyUrl配合uiEx使用\r\n");
      out.write("\t\t\t */\r\n");
      out.write("\t\t\turl : \"SysRole/list\",\r\n");
      out.write("\t\t\tsaveUrl : \"SysRole/save\",\r\n");
      out.write("\t\t\tupdateUrl : \"SysRole/update\",\r\n");
      out.write("\t\t\tdestroyUrl : \"SysRole/delete\",\r\n");
      out.write("\t\t\tshowHeaderContextMenu : true, // 表头添加右键菜单，可选择显示的列\r\n");
      out.write("\t\t\t// clickRowEdit:true, //注册单击行编辑，可以代替edatagrid实现带行编辑的CRUD\r\n");
      out.write("\t\t\tpageSize : 10,\r\n");
      out.write("\t\t\tpageList : [ 5, 10, 15, 20 ],\r\n");
      out.write("\t\t\tcheckbox : true,\r\n");
      out.write("\t\t\tsingleSelect : false,\r\n");
      out.write("\t\t\tcheckOnSelect : true,\r\n");
      out.write("\t\t\t//双击操作\r\n");
      out.write("\t\t\tonDblClickRow : function(rowIndex, rowData) {\r\n");
      out.write("\t\t\t\tsysRole.editIndex = rowIndex;\r\n");
      out.write("\t\t\t\ttoEdit(rowData);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmenuSelector : \"#sysRoleContextMenu\",\r\n");
      out.write("\t\t\tshowContextMenu : true\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tsysRole.toAdd = function() {\r\n");
      out.write("\t\t\tuiEx.resetForm(\"#sysRoleAddForm\");\r\n");
      out.write("\t\t\tuiEx.openDialog(\"#sysRoleAddDialog\", \"角色添加\");\r\n");
      out.write("\r\n");
      out.write("\t\t\tuiEx.initParentIdTreeChk(\"#sysRoleAddPermissions\", {\r\n");
      out.write("\t\t\t\turl : \"SysMenuPermission/listAllForSysRole\",\r\n");
      out.write("\t\t\t\tcheckbox : true,\r\n");
      out.write("\t\t\t\tanimate : true,\r\n");
      out.write("\t\t\t\tlines : true,\r\n");
      out.write("\t\t\t\tnoChildCascadeCheck : true,\r\n");
      out.write("\t\t\t\tshowTitle : \"remark\"\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t/* $(\"#sysRoleAddPermissions\").combotree({\r\n");
      out.write("\t\t\t\turl : 'SysMenuPermission/list',\r\n");
      out.write("\t\t\t\tcheckbox:true,\r\n");
      out.write("\t\t\t\tcascadeCheck:true,\r\n");
      out.write("\t\t\t\tonLoadSuccess : function(node, data) {\r\n");
      out.write("\t\t\t\t\t//$(\"#sysRoleAddPermissions\").combotree('setValue', data[0].id);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});  */\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//点击按钮修改\r\n");
      out.write("\t\tsysRole.toEdit = function() {\r\n");
      out.write("\t\t\tvar row = $(\"#sysRoleDataGrid\").datagrid('getSelected');\r\n");
      out.write("\t\t\tif (row) {\r\n");
      out.write("\t\t\t\ttoEdit(row);\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tuiEx.msg(\"请选择要修改的行\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//打开修改\t\r\n");
      out.write("\t\tfunction toEdit(row) {\r\n");
      out.write("\t\t\tuiEx.resetForm(\"#sysRoleEditForm\");\r\n");
      out.write("\t\t\tuiEx.openDialog(\"#sysRoleEditDialog\", \"角色修改\");\r\n");
      out.write("\t\t\tuiEx.loadForm(\"#sysRoleEditForm\", row, \"\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t//查询角色所有权限\r\n");
      out.write("\t\t\t$.post(\"SysRole/getAllPermissionsId\", \"roleId=\"\r\n");
      out.write("\t\t\t\t\t+ row.roleId, function(data) {\r\n");
      out.write("\t\t\t\t/*\r\n");
      out.write("\t\t\t\t * 初始化权限复选框\r\n");
      out.write("\t\t\t\t */\r\n");
      out.write("\t\t\t\tuiEx.initParentIdTreeChk(\"#sysRoleEditPermissions\", {\r\n");
      out.write("\t\t\t\t\turl : \"SysMenuPermission/listAllForSysRole\",\r\n");
      out.write("\t\t\t\t\tcheckbox : true,\r\n");
      out.write("\t\t\t\t\tanimate : true,\r\n");
      out.write("\t\t\t\t\tlines : true,\r\n");
      out.write("\t\t\t\t\tnoChildCascadeCheck : true,\r\n");
      out.write("\t\t\t\t\tshowTitle : \"remark\"\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}, data.list);\r\n");
      out.write("\r\n");
      out.write("\t\t\t}, \"json\");\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tsysRole.toDelete = function() {\r\n");
      out.write("\t\t\t// datagridSelector,  showMsg, reloadDataGrid, successKey, successValue\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar rows = $(\"#sysRoleDataGrid\").datagrid('getSelections');\r\n");
      out.write("\t\t\tif (rows) {\r\n");
      out.write("\t\t\t\tdg.rowDelete(true, false, \"statusCode\", \"200\");\r\n");
      out.write("\t\t\t\t/* var ids = \"\";\r\n");
      out.write("\t\t\t\t$.each(rows, function(i, v) {\r\n");
      out.write("\t\t\t\t\tids += v.userId + \",\";\r\n");
      out.write("\t\t\t\t}); */\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tuiEx.msg(\"请选择要删除的行\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\t * 搜索\r\n");
      out.write("\t\t */\r\n");
      out.write("\r\n");
      out.write("\t\tsysRole.doSearch = function() {\r\n");
      out.write("\t\t\t$(\"#sysRoleDataGrid\").edatagrid(\r\n");
      out.write("\t\t\t\t\t\"load\",\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t'name' : $(\"#sysRoleName\").val(),\r\n");
      out.write("\t\t\t\t\t\t'status' : $(\"#sysRoleStatus\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.combobox(\"getValue\")\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write(" \r\n");
      out.write('	');
      out.write("\r\n");
      out.write("\t<table id=\"sysRoleDataGrid\" title=\"角色列表\" style=\"width: 100%\"\r\n");
      out.write("\t\ttoolbar=\"#sysRoleToolbar\" idField=\"roleId\" rownumbers=\"true\"\r\n");
      out.write("\t\tfitColumns=\"true\" nowrap=\"false\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th field=\"ck\" checkbox=\"true\" width=\"50\" sortable=\"true\">多选框</th>\r\n");
      out.write("\t\t\t\t<th field=\"name\" width=\"50\" sortable=\"true\">名称</th>\r\n");
      out.write("\t\t\t\t<th field=\"status\" width=\"50\" formatter=\"sysRole.formatStatus\"\r\n");
      out.write("\t\t\t\t\tsortable=\"true\">状态</th>\r\n");
      out.write("\t\t\t\t<th field=\"remark\" width=\"50\">备注</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<div id=\"sysRoleToolbar\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<span>角色名:</span> <input name=\"name\" id=\"sysRoleName\"\r\n");
      out.write("\t\t\t\tclass=\"easyui-textbox\" /> <span>状态:</span> <select\r\n");
      out.write("\t\t\t\tname=\"status\" class=\"easyui-combobox\"\r\n");
      out.write("\t\t\t\tid=\"sysRoleStatus\" style=\"width:90px;\"\r\n");
      out.write("\t\t\t\tdata-options=\"editable:false,panelHeight:'auto'\">\r\n");
      out.write("\t\t\t\t<option value=\"\">--全部--</option>\r\n");
      out.write("\t\t\t\t<option value=\"0\">正常</option>\r\n");
      out.write("\t\t\t\t<option value=\"1\">禁用</option>\r\n");
      out.write("\t\t\t</select> <a class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\"\r\n");
      out.write("\t\t\t\tonclick=\"sysRole.doSearch()\">");
      if (_jspx_meth_s_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-add',plain:true\"\r\n");
      out.write("\t\t\tonclick=\"sysRole.toAdd()\">添加角色</a> <a href=\"javascript:void(0)\"\r\n");
      out.write("\t\t\tclass=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-edit',plain:true\"\r\n");
      out.write("\t\t\tonclick=\"sysRole.toEdit()\">修改角色</a> <a class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\ticonCls=\"icon-remove\" plain=\"true\" onclick=\"sysRole.toDelete()\">删除角色</a>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<div id=\"sysRoleContextMenu\" class=\"easyui-menu\" style=\"width:120px;\">\r\n");
      out.write("\t\t<div onclick=\"sysRole.toAdd()\" data-options=\"iconCls:'icon-add'\">添加</div>\r\n");
      out.write("\t\t<div onclick=\"sysRole.toEdit()\" data-options=\"iconCls:'icon-edit'\">修改</div>\r\n");
      out.write("\t\t<div onclick=\"sysRole.toDelete()\" data-options=\"iconCls:'icon-remove'\">删除</div>\r\n");
      out.write("\t</div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function() {\r\n");
      out.write("\t\r\n");
      out.write("\t/*\r\n");
      out.write("\t * 执行增改\r\n");
      out.write("\t */\r\n");
      out.write("\t sysRole.add=function(){\r\n");
      out.write("\t\t var permissions=uiEx.getCheckedInfos(\"#sysRoleAddPermissions\",[\"id\",\"type\"]);\r\n");
      out.write("\t\t var menus=\"\";\r\n");
      out.write("\t\t var operations=\"\";\r\n");
      out.write("\t\t // 初始化要提交的菜单权限和操作权限\r\n");
      out.write("\t\t $.each(permissions,function(i,v){\r\n");
      out.write("\t\t \tif(v.type=='menu'){\r\n");
      out.write("\t\t \t\tmenus+=v.id+\"#\";\r\n");
      out.write("\t\t \t}else{\r\n");
      out.write("\t\t \t\toperations+=v.id+\"#\";\r\n");
      out.write("\t\t \t}\r\n");
      out.write("\t\t });\r\n");
      out.write("\t \tvar dg=$(\"#sysRoleDataGrid\");\r\n");
      out.write("\t\tvar url = \"SysRole/save\";\r\n");
      out.write("\t \tuiEx.submitURLAjax(\"#sysRoleAddForm\",url, function(data) {\r\n");
      out.write("\t\t\tdata = eval(\"(\" + data + \")\");\r\n");
      out.write("\t\t\tif (data.statusCode==200) {\r\n");
      out.write("\t\t\t\t//uiEx.reloadSelTab(\"#tabs\");\r\n");
      out.write("\t\t\t\t//dg.datagrid('reload'); //刷新表格，在第当前页\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tdg.datagrid({\"pageNumber\":data.page});//刷新表格\r\n");
      out.write("\t\t\t\t//dg.datagrid('load'); //刷新表格\r\n");
      out.write("\t\t\t\tuiEx.closeDialog(\"#sysRoleAddDialog\");\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t}, {\"menus\":menus,\"operations\":operations,\"rows\":dg.datagrid(\"options\").pageSize});\r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<!-- 修改或修改Dialog -->\r\n");
      out.write("<div id=\"sysRoleAddDialog\" class=\"easyui-dialog\"\r\n");
      out.write("\tstyle=\"width:480px;height:410px;padding:10px 20px\" resizable=\"true\" closed=\"true\"\r\n");
      out.write("\tbuttons=\"#sysRoleAdd-dlg-buttons\">\r\n");
      out.write("\t<div class=\"ftitle\">角色信息</div>\r\n");
      out.write("\t<form id=\"sysRoleAddForm\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"roleId\"/>\r\n");
      out.write("\t\t\t <table cellpadding=\"5\">\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<td>角色名:</td>\r\n");
      out.write("\t    \t\t\t<td><input class=\"easyui-textbox easyui-validatebox\" name=\"name\"\r\n");
      out.write("\t\t\t\trequired=\"true\"\r\n");
      out.write("\t\t\t\tdata-options=\"prompt:'请输入角色名称...'\" style=\"width:200px\"><span class=\"required\">*</span></td>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<td>状态:</td>\r\n");
      out.write("\t    \t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"status\" value=\"0\" id=\"on\" checked=\"checked\"  />\r\n");
      out.write("\t\t\t\t\t\t<label for=\"on\">启用</label> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"status\" value=\"1\" id=\"off\" />\r\n");
      out.write("\t\t\t\t\t\t<label for=\"off\">禁用</label>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<td>菜单备注:</td>\r\n");
      out.write("\t    \t\t\t<td><input class=\"easyui-textbox\" multiline=\"true\" style=\"height:40px;width: 200px;\" name=\"remark\"></td>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<td>权限：</td>\r\n");
      out.write("\t    \t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"sysRoleAddPermissions\" ></ul>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"sysRoleAdd-dlg-buttons\">\r\n");
      out.write("\t<a class=\"easyui-linkbutton\" id=\"sysRoleAddSaveBtn\" iconCls=\"icon-ok\"\r\n");
      out.write("\t\tonclick=\"sysRole.add()\">添加</a> <a class=\"easyui-linkbutton\"\r\n");
      out.write("\t\ticonCls=\"icon-cancel\"\r\n");
      out.write("\t\tonclick=\"javascript:uiEx.closeDialog('#sysRoleAddDialog')\">取消</a>\r\n");
      out.write("</div>");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function() {\r\n");
      out.write("\t\r\n");
      out.write("\t/*\r\n");
      out.write("\t * 执行增改\r\n");
      out.write("\t */\r\n");
      out.write("\t sysRole.edit=function(){\r\n");
      out.write("\t\t var permissions=uiEx.getCheckedInfos(\"#sysRoleEditPermissions\",[\"id\",\"type\"]);\r\n");
      out.write("\t\t var menus=\"\";\r\n");
      out.write("\t\t var operations=\"\";\r\n");
      out.write("\t\t // 初始化要提交的菜单权限和操作权限\r\n");
      out.write("\t\t $.each(permissions,function(i,v){\r\n");
      out.write("\t\t \tif(v.type=='menu'){\r\n");
      out.write("\t\t \t\tmenus+=v.id+\"#\";\r\n");
      out.write("\t\t \t}else{\r\n");
      out.write("\t\t \t\toperations+=v.id+\"#\";\r\n");
      out.write("\t\t \t}\r\n");
      out.write("\t\t });\r\n");
      out.write("\t \tvar dg=$(\"#sysRoleDataGrid\");\r\n");
      out.write("\t\tvar url = \"SysRole/update\";\r\n");
      out.write("\t \tuiEx.submitURLAjax(\"#sysRoleEditForm\",url, function(data) {\r\n");
      out.write("\t\t\tdata = eval(\"(\" + data + \")\");\r\n");
      out.write("\t\t\tif (data.statusCode==200) {\r\n");
      out.write("\t\t\t\t//uiEx.reloadSelTab(\"#tabs\");\r\n");
      out.write("\t\t\t\t//dg.datagrid('reload'); //刷新表格，在第当前页\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tdg.datagrid({\"pageNumber\":data.page});//刷新表格\r\n");
      out.write("\t\t\t\t//dg.datagrid('load'); //刷新表格\r\n");
      out.write("\t\t\t\tuiEx.closeDialog(\"#sysRoleEditDialog\");\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t}, {\"menus\":menus,\"operations\":operations,\"rows\":dg.datagrid(\"options\").pageSize});\r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<!-- 修改或修改Dialog -->\r\n");
      out.write("<div id=\"sysRoleEditDialog\" class=\"easyui-dialog\"\r\n");
      out.write("\tstyle=\"width:480px;height:410px;padding:10px 20px\" resizable=\"true\" closed=\"true\"\r\n");
      out.write("\tbuttons=\"#sysRoleEdit-dlg-buttons\">\r\n");
      out.write("\t<div class=\"ftitle\">角色信息</div>\r\n");
      out.write("\t<form id=\"sysRoleEditForm\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"roleId\"/>\r\n");
      out.write("\t\t\t <table cellpadding=\"5\">\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<td>角色名:</td>\r\n");
      out.write("\t    \t\t\t<td><input class=\"easyui-textbox easyui-validatebox\" name=\"name\"\r\n");
      out.write("\t\t\t\trequired=\"true\"\r\n");
      out.write("\t\t\t\tdata-options=\"prompt:'请输入角色名称...'\" style=\"width:200px\"><span class=\"required\">*</span></td>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<td>状态:</td>\r\n");
      out.write("\t    \t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"status\" value=\"0\" id=\"on\" checked=\"checked\"  />\r\n");
      out.write("\t\t\t\t\t\t<label for=\"on\">启用</label> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"status\" value=\"1\" id=\"off\" />\r\n");
      out.write("\t\t\t\t\t\t<label for=\"off\">禁用</label>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<td>菜单备注:</td>\r\n");
      out.write("\t    \t\t\t<td><input class=\"easyui-textbox\" multiline=\"true\" style=\"height:40px;width: 200px;\" name=\"remark\"></td>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t\t<tr>\r\n");
      out.write("\t    \t\t\t<td>权限：</td>\r\n");
      out.write("\t    \t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"sysRoleEditPermissions\" ></ul>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t    \t\t</tr>\r\n");
      out.write("\t    \t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"sysRoleEdit-dlg-buttons\">\r\n");
      out.write("\t<a class=\"easyui-linkbutton\" id=\"sysRoleEditSaveBtn\" iconCls=\"icon-ok\"\r\n");
      out.write("\t\tonclick=\"sysRole.edit()\">修改</a> <a class=\"easyui-linkbutton\"\r\n");
      out.write("\t\ticonCls=\"icon-cancel\"\r\n");
      out.write("\t\tonclick=\"javascript:uiEx.closeDialog('#sysRoleEditDialog')\">取消</a>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_s_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f0.setParent(null);
    // /WEB-INF/content/main/sys/sysRole.jsp(175,33) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f0.setCode("label.search");
    int[] _jspx_push_body_count_s_005fmessage_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f0 = _jspx_th_s_005fmessage_005f0.doStartTag();
      if (_jspx_th_s_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f0.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f0);
    }
    return false;
  }
}
