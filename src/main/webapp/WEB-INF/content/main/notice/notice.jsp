<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="s"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>

<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>
<script type="text/javascript">
	//员工操作命名空间
	var Notice = {};
	$(function() {
		/*
		 * datagrid数据格式化
		 */
		/*
		 * 数据表格初始化
		 */
		var dg = $("#NoticeDataGrid");

		// 第一次DG加载，以后无需初始化combobox
		var firstLoad = true;

		$("#NoticeDataGrid").initDatagrid({
			/*
			 * 行编辑:saveUrl、updateUrl、destroyUrl配合uiEx使用
			 */
			url : "Notice/list",
			saveUrl : "Notice/add",
			updateUrl : "Notice/update",
			destroyUrl : "Notice/delete",
			idField : "NoticeId",
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
			menuSelector : "#NoticeContextMenu",
			showContextMenu : true,
			sendRowDataPrefix : "", //提交数据前缀
			successKey : "statusCode", //服务器端返回的成功标记key
			successValue : "200", //服务器端返回的成功标记value
			onLoadSuccess : function(data) {
				// 第一次DG加载，以后无需初始化combobox
				//if (firstLoad) {
					// 部门数据集合，添加和修改时无需去服务器查询
					//这部分是下拉框的东西！！！！！！！！！！!
					Notice.allList = data.allCoach;
					$('#NoticeId').combobox({
						data : Notice.allList,
						valueField : 'NoticeId',
						textField : 'NoContent',
						panelHeight : 'auto',
						editable : false
					});
					firstLoad = false;
				//}

			},
			//双击操作
			onDblClickRow : function(rowIndex, rowData) {
				toEdit(rowData); 
			},
			mutipleDelete : true, // 多行提交删除
			mutipleDeleteProperty : "noticeId" // 多行删除时提及给服务器的属性和值，不会添加sendRowDataPrefix前缀，支持使用数组指定多个属性名
		});

		//搜索
		Notice.doSearch = function() {
			dg.datagrid("load", {
				'noticeId' : $("#noid").val()
		//上面的activityId和后端接收这个字段的名字必须一致，否则对应不上就无法搜索
//				'deptno' : $("#empDeptno").combobox("getValue")
			});
		}
		Notice.clearAll = function() {
			//ActivitySearchForm  这里ID选择器要加#号，否则就会显示没有定义，就不起作用
			$("#NoticeSearchForm")[0].reset();
			dg.datagrid("load", {
			});
		};
			// 删除 
			Notice.toDelete = function() {
				var rows = $("#NoticeDataGrid").datagrid('getSelections');
				if (rows) {
					dg.rowDelete(true, false, "statusCode", "200");
				} else {
					uiEx.msg("请选择要删除的行");
				}
			}
			
			Notice.toAdd = function() {
				uiEx.resetForm("#noticeAddForm");
				uiEx.openDialog("#noticeAddDialog", "添加公告");
			}
			
			//点击按钮修改
			Notice.toEdit = function() {
				var row = $("#NoticeDataGrid").datagrid('getSelected');
			//	alert(row);
				if (row) {
					toEdit(row);
				} else {
					uiEx.msg("请选择要修改的行");
				}
			}
			//打开修改
			function toEdit(row) {
				uiEx.resetForm("#NoticeEditForm");
				uiEx.openDialog("#noticeEditDialog", "公告内容修改");

				uiEx.loadForm("#NoticeEditForm", row, "");
			}
	});
</script>

 <div id="NoticeToolbar">
	<div>
	<form action="" id="NoticeSearchForm">
		<span>公告ID查询:</span> <input name="idd" id="noid"
			class="easyui-textbox" /> 
	 <a class="easyui-linkbutton" iconCls="icon-search" plain="true"
			onclick="Notice.doSearch()"><s:message code="label.search"></s:message></a>
		<a class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="Notice.clearAll()"><s:message code="label.clear"></s:message></a>
	</form>
	</div>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="Notice.toAdd()">添加公告</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="Notice.toEdit()">修改公告</a>
	<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="Notice.toDelete()">删除公告</a>

</div>
<%-- 2. 页面内容 --%>
<table id="NoticeDataGrid" title="公告内容列表" style="width: 100%" toolbar="#noticeToolbar"
	idField="noticeId" rownumbers="true" fitColumns="true" nowrap="false">
	<thead>
		<tr>
			<th field="ck" checkbox="true" width="50" sortable="true">多选框</th>
			<!-- <th field="NoticeId" width="50" sortable="true">公告ID</th> -->
			<th field="noContent" width="50" sortable="true">公告内容</th>
		</tr>
	</thead>
</table>
<%-- 3. 包含的Dialog页面等其他内容 --%>
<%@ include file="/WEB-INF/content/dialog/notice/NoticeAdd.jsp"%>
<%@ include file="/WEB-INF/content/dialog/notice/NoticeEdit.jsp"%>
