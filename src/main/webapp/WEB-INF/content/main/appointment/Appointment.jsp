<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@ taglib uri="http://www.springframework.org/tags"  prefix="s"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>

<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>
<script type="text/javascript">
	//部门操作命名空间
	var Appointment = {};
	$(function() {
		/*
		 * datagrid数据格式化
		 */
		/*
		 * 数据表格初始化
		 */
		var dg = $("#appointmentDataGrid");

		$("#appointmentDataGrid").initEdatagrid({
			/*
			 * 行编辑:saveUrl、updateUrl、destroyUrl配合uiEx使用
			 */
			url : "Appointment/list",
			saveUrl : "Appointment/save",
			updateUrl : "Appointment/update",
			destroyUrl : "Appointment/delete",
			idField : "appointmentId",
			showHeaderContextMenu : true, // 表头添加右键菜单，可选择显示的列
			pagination : true,
			checkbox : true,
			checkOnSelect : true,
			singleSelect : false,
			autoSave : true,
			//queryParam:{"rows":dg.datagrid("options").pageSize},
			clickEdit : true, //单击编辑
			showMsg : true, // 显示操作消息
			//右键菜单
			menuSelector : "#appointmentContextMenu",
			showContextMenu : true,
			sendRowDataPrefix : "", //提交数据前缀
			successKey : "statusCode", //服务器端返回的成功标记key
			successValue : "200" //服务器端返回的成功标记value
		});

		/*
		 * 增删改
		 */

		//搜索
		Appointment.doSearch = function() {
			dg.datagrid("load", {
				'userId' : $("#userId").val(),
				'coachId' : $("#coachId").val(),
				'site' : $("#site").val(),
				'appointmentTime' : $('#appointmentTime').datebox('getValue')
			});
		}
		//清除搜索框内容
		Appointment.clearAll = function() {
			$("#AppointmentSearchForm").form('reset');
			dg.datagrid("load", {	
			});
		}

	});
</script>

<%-- 2. 页面内容 --%>
<table id="appointmentDataGrid" title="订单列表" style="width: 100%" toolbar="#appointmentToolbar" idField="appointmentId" rownumbers="true" fitColumns="true" nowrap="false">
	<thead>
		<tr>
			<th field="ck" checkbox="true" width="50" sortable="true">多选框</th>
		<!-- <th field="order_id" width="50" sortable="true">订单编号</th> -->
			<th field="userName" width="50" sortable="true">会员姓名</th>
			<th field="coachName" width="50" sortable="true" editor="{type:'textbox'}">教练</th>
			<th field="site" width="50"  sortable="true" editor="{type:'textbox'}">场馆</th>
			<th field="appointmentTime" width="50"  sortable="true" editor="{type:'textbox'}">预约时间</th>
		</tr>
	</thead>
</table>

<%-- 2. 搜索 ToolBar --%>
<div id="appointmentToolbar">
	<div>
	<form action="" id="AppointmentSearchForm">
		<span>会员编号:</span> <input name="userId" id="userId" class="easyui-textbox" />
		<span>教练编号:</span> <input name="coachId" id="coachId" class="easyui-textbox" />
		<span>场馆:</span> <input name="site" id="site" class="easyui-textbox" />
		<span>预约时间:</span> <input name="appointmentTime" id="appointmentTime" class="easyui-datebox" />
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="Appointment.doSearch()"><s:message code="label.search"></s:message></a>
		<a class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="Appointment.clearAll()"><s:message code="label.clear"></s:message></a>
	</form>
	</div>
	<!-- <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="$('#appointmentOrderDataGrid').edatagrid('addRow')">添加预约</a> -->
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="$('#appointmentOrderDataGrid').edatagrid('destroyRow')">删除预约</a>
	<a class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#appointmentOrderDataGrid').edatagrid('cancelRow')">撤销修改</a>
</div>

<%-- 3. grid右键菜单 --%>
<div id="appointmentContextMenu" class="easyui-menu" style="width:120px;">
	<div onclick="$('#appointmentDataGrid').edatagrid('addRow')" data-options="iconCls:'icon-add'">添加</div>
	<%-- <shiro:hasPermission name="appointmentOrderDeleteShow"> --%>
		<div onclick="$('#appointmentDataGrid').edatagrid('destroyRow')" data-options="iconCls:'icon-remove'">删除</div>
	<%-- </shiro:hasPermission> --%>
	<a class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#appointmentDataGrid').edatagrid('cancelRow')">撤销修改</a>
 </div>


<%-- 4. 包含的Dialog页面等其他内容 --%>