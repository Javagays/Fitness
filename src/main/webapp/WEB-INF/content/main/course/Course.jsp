<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>
<script type="text/javascript">
	//部门操作命名空间
	var Course = {};
	$(function() {
		/*
		 * datagrid数据格式化
		 */
		/*
		 * 数据表格初始化
		 */
		var dg = $("#courseDataGrid");

		$("#courseDataGrid").initEdatagrid({
			/*
			 * 行编辑:saveUrl、updateUrl、destroyUrl配合uiEx使用
			 */
			url : "Course/list",
			saveUrl : "Course/save",
			updateUrl : "Course/update",
			destroyUrl : "Course/delete",
			idField : "courseId",
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
			menuSelector : "#courseContextMenu",
			showContextMenu : true,
			sendRowDataPrefix : "", //提交数据前缀
			successKey : "statusCode", //服务器端返回的成功标记key
			successValue : "200" //服务器端返回的成功标记value
		});

		/*
		 * 增删改
		 */

		//搜索
		Course.doSearch = function() {
			dg.datagrid("load",{
				'coachId':$("#coachIdSearch").val(),
				'courseDate':$("#courseDateSearch").datebox('getValue'),
		/* 		'courseStart' : $("#courseStart").datebox('getValue'),
				'courseEnd' : $("#courseEnd").datebox('getValue'), */
				'courseName':$("#courseNameSearch").val()
			});
		}
		Course.clearAll = function() {
			$("CourseSearchForm").form('reset');
			dg.datagrid("load", {
			});
		}

	});
</script>

<%-- 2. 页面内容 --%>
<table id="courseDataGrid" title="课程列表" style="width: 100%" toolbar="#courseToolbar" idField="courseId" rownumbers="true" fitColumns="true" nowrap="false">
	<thead>
		<tr>
			<th field="ck" checkbox="true" width="50" sortable="true">多选框</th>
	<%-- 	<th field="deptno" width="50" sortable="true">部门编号</th> --%>
			<th field="coachId" width="50" sortable="true" editor="{type:'textbox',options:{required:true}}">教练编号</th>
			<th field="courseName" width="50" sortable="true" editor="{type:'textbox',options:{required:true}}">课程名称</th>
			<th field="courseDate" width="50" sortable="true" editor="{type:'textbox',options:{required:true}}">课程日期</th>
			<th field="courseStart" width="50"  sortable="true" editor="{type:'textbox',options:{required:true}}">课程开始时间</th>
			<th field="courseEnd" width="50" sortable="true" editor="{type:'textbox'}">课程结束时间</th>
			
		</tr>
	</thead>
</table>

<%-- 2. 搜索 ToolBar --%>
<div id="courseToolbar">
	<div>
	<form action="" id="CourseSearchForm">
		<span>教练编号:</span> <input name="coachId" id="coachIdSearch" class="easyui-textbox" />
		<span>课程名称:</span> <input name="courseName" id="courseNameSearch" class="easyui-textbox" />
		<span>课程日期:</span> <input name="courseDate" id="courseDateSearch" class="easyui-datebox" />
<!-- 		<span>课程开始时间:</span> <input name="courseStart" id="courseStart" class="easyui-datebox" />
		<span>课程结束时间:</span> <input name="courseEnd" id="courseEnd" class="easyui-datebox" /> -->
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="Course.doSearch()"><s:message code="label.search"></s:message></a>
		<a class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="Course.clearAll()"><s:message code="label.clear"></s:message></a>
	</form>
	</div>
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="$('#courseDataGrid').edatagrid('addRow')">添加课程</a>
	<!-- <shiro:hasPermission name="deptDeleteShow"> -->
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="$('#courseDataGrid').edatagrid('destroyRow')">删除课程</a>
	<!-- </shiro:hasPermission> -->
	<a class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#courseDataGrid').edatagrid('cancelRow')">撤销修改</a>
</div>

<%-- 3. grid右键菜单 --%>
<div id="courseContextMenu" class="easyui-menu" style="width:120px;">
	<div onclick="$('#courseDataGrid').edatagrid('addRow')" data-options="iconCls:'icon-add'">添加</div>
	<!-- <shiro:hasPermission name="deptDeleteShow"> -->
		<div onclick="$('#courseDataGrid').edatagrid('destroyRow')" data-options="iconCls:'icon-remove'">删除</div>
	<!-- </shiro:hasPermission> -->
	<a class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#courseDataGrid').edatagrid('cancelRow')">撤销修改</a>
 </div>


<%-- 4. 包含的Dialog页面等其他内容 --%>


