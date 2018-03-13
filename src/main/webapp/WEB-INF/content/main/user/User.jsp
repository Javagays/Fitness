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
	//员工操作命名空间
	var User = {};
	$(function() {
		/*
		 * datagrid数据格式化
		 */
		/*
		 * 数据表格初始化
		 */
		var dg = $("#userDataGrid");

		// 第一次DG加载，以后无需初始化combobox
		var firstLoad = true;

		$("#userDataGrid").initDatagrid({
			/*
			 * 行编辑:saveUrl、updateUrl、destroyUrl配合uiEx使用
			 */
			url : "User/list",
			saveUrl : "User/save",
			updateUrl : "User/update",
			destroyUrl : "User/delete",
			idField : "userId",
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
			menuSelector : "#userContextMenu",
			showContextMenu : true,
			sendRowDataPrefix : "", //提交数据前缀
			successKey : "statusCode", //服务器端返回的成功标记key
			successValue : "200", //服务器端返回的成功标记value
			onLoadSuccess : function(data) {
				// 第一次DG加载，以后无需初始化combobox
			},
			//双击操作
			onDblClickRow : function(rowIndex, rowData) {
				toEdit(rowData);
			},
			mutipleDelete : true, // 多行提交删除
			mutipleDeleteProperty : "userId" // 多行删除时提及给服务器的属性和值，不会添加sendRowDataPrefix前缀，支持使用数组指定多个属性名
		});

		/*
		 * 增删改
		 */

		//搜索
		User.doSearch = function() {
			dg.datagrid("load", {
				'userName' : $("#userNameSearch").val(),
				'userPhone' : $("#userPhoneSearch").val()
				/* 'registerTime' :  $('#registerTimeSearch').datebox('getValue') */
			});
		}
		User.clearAll = function() {
			$("UserSearchForm").form('reset');
			dg.datagrid("load", {
			});
		}

		User.toAdd = function() {
			uiEx.resetForm("#userAddForm");
			uiEx.openDialog("#userAddDialog", "用户添加");
		}

		//点击按钮修改
		User.toEdit = function() {
			var row = $("#userDataGrid").datagrid('getSelected');
			if (row) {
				toEdit(row);
			} else {
				uiEx.msg("请选择要修改的行");
			}
		}
		// 删除 
		User.toDelete = function() {
			var rows = $("#userDataGrid").datagrid('getSelections');
			if (rows) {
				dg.rowDelete(true, false, "statusCode", "200");
			} else {
				uiEx.msg("请选择要删除的行");
			}
		}

		//打开修改	
		function toEdit(row) {
			uiEx.resetForm("#userEditForm");
			uiEx.openDialog("#userEditDialog", "会员修改");

			uiEx.loadForm("#userEditForm", row, "")
		}
		;

	});
</script>
<%--
<style>
.datagrid-btable{ width:100%}
</style>
 --%>
<%-- 2. 页面内容 --%>
<table id="userDataGrid" title="会员列表" style="width: 100%" toolbar="#userToolbar" idField="userId" rownumbers="true" fitColumns="true" nowrap="false">
	<thead>
		<tr>
			<th field="ck" checkbox="true" width="50" sortable="true">多选框</th>
			<th field="userName" width="50" sortable="true">会员姓名</th>
			<th field="userPhone" width="50" sortable="true">会员电话</th>
			<th field="userIntegral" width="50" sortable="true">会员积分</th>
			<th field="homeLocation" width="50" sortable="true">家庭住址</th>
			<th field="workLocation" width="50" sortable="true">工作地址</th>
			<th field="birthday" width="50" sortable="true">会员生日</th>
			<th field="userIDcard" width="50" sortable="true">身份证号</th>
			<th field="registerTime" width="50" sortable="true">注册时间</th>
			<th field="height" width="50" sortable="true">身高</th>
			<th field="weight" width="50" sortable="true">体重</th>
			<th field="sex" width="50" sortable="true">性别</th>
		</tr>
	</thead>
</table>
<div id="userToolbar">
	<div>
	<form action="" id="UserSearchForm">
		<span>会员姓名:</span> <input name="userName" id="userNameSearch" class="easyui-textbox" />
		<span>会员电话:</span> <input name="userPhone" id="userPhoneSearch" class="easyui-textbox" />
		<%-- <span>会员积分:</span> <input name="userIntegral" id="userIntegralSearch" class="easyui-textbox" />
		<span>家庭住址:</span> <input name="homeLocation" id="homeLocationSearch" class="easyui-textbox" />
		<span>工作地址:</span> <input name="workLocation" id="workLocationSearch" class="easyui-textbox" />
		<span>会员生日:</span> <input name="birthday" id="birthdaySearch" class="easyui-textbox" />
		<span>身份证号:</span> <input name="userIDcard" id="userIDcardSearch" class="easyui-textbox" /> --%>
		<%-- <span>注册时间:</span> <input name="loginTime" id="registerTimeSearch" class="easyui-datebox" /> --%>
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="User.doSearch()"><s:message code="label.search"></s:message></a>
		<a class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="User.clearAll()"><s:message code="label.clear"></s:message></a>
	</form>
	</div>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="User.toAdd()">添加员工</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="User.toEdit()">修改员工</a>
	<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="User.toDelete()">删除员工</a>

</div>
<%-- grid右键菜单 --%>
<div id="userContextMenu" class="easyui-menu" style="width:120px;">
	<div onclick="User.toAdd()" data-options="iconCls:'icon-add'">添加会员</div>
	<div onclick="User.toEdit()" data-options="iconCls:'icon-edit'">修改会员</div>
	<div onclick="User.toDelete()" data-options="iconCls:'icon-remove'">删除会员</div>

</div>


<%-- 3. 包含的Dialog页面等其他内容 --%>
<%@ include file="/WEB-INF/content/dialog/user/UserAdd.jsp"%>
<%@ include file="/WEB-INF/content/dialog/user/UserEdit.jsp"%>