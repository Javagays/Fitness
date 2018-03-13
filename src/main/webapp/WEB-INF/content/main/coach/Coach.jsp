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
	var Coach = {};
	$(function() {
		/*
		 * datagrid数据格式化
		 */
		/*
		 * 数据表格初始化
		 */
		var dg = $("#CoachDataGrid");

		// 第一次DG加载，以后无需初始化combobox
		var firstLoad = true;

		$("#CoachDataGrid").initDatagrid({
			/*
			 * 行编辑:saveUrl、updateUrl、destroyUrl配合uiEx使用
			 */
			url : "Coach/list",
			saveUrl : "Coach/add",
			updateUrl : "Coach/update",
			destroyUrl : "Coach/delete",
			idField : "coachId",
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
			menuSelector : "#coachContextMenu",
			showContextMenu : true,
			sendRowDataPrefix : "", //提交数据前缀
			successKey : "statusCode", //服务器端返回的成功标记key
			successValue : "200", //服务器端返回的成功标记value
			onLoadSuccess : function(data) {
				// 第一次DG加载，以后无需初始化combobox
				//if (firstLoad) {
					// 部门数据集合，添加和修改时无需去服务器查询
					Coach.courseList = data.allCoach;
					$('#coachCourseId').combobox({
						data : Coach.courseList,
						valueField : 'coachId',
						textField : 'coachName',
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
			mutipleDeleteProperty : "coachId" // 多行删除时提及给服务器的属性和值，不会添加sendRowDataPrefix前缀，支持使用数组指定多个属性名
		});

		/*
		 * 增删改
		 */

		//搜索
		Coach.doSearch = function() {
			dg.datagrid("load", {
				'coachName' : $("#coachName").val(),
				'coachType' : $("#coachType").val()
			});
		}
		Coach.clearAll = function() {
			$("#CoachSearchForm")[0].reset();
			dg.datagrid("load", {
			});
		}

		Coach.toAdd = function() {
			uiEx.resetForm("#coachAddForm");
			uiEx.openDialog("#coachAddDialog", "教练添加");
			
			
		}

		//点击按钮修改
		Coach.toEdit = function() {
			//console.info($("#coachDataGrid").length);
			
			var row = $("#CoachDataGrid").datagrid('getSelected');
			
			if (row) {
				toEdit(row);
			} else {
				uiEx.msg("请选择要修改的行");
			}
		}
		// 删除 
		Coach.toDelete = function() {
			var rows = $("#CoachDataGrid").datagrid('getSelections');
			if (rows) {
				dg.rowDelete(true, false, "statusCode", "200");
			} else {
				uiEx.msg("请选择要删除的行");
			}
		}

		//打开修改	
		function toEdit(row) {
			uiEx.resetForm("#coachEditForm");
			uiEx.openDialog("#coachEditDialog", "教练修改");

			uiEx.loadForm("#coachEditForm", row, "");
			
			
		};

	});
	
	function imgFormatter(value,row,index){
		
		return '<img alt="ok" src="http://127.0.0.1/upload/'+row.coachImageUrl+'" /> <br/>'+row.coachName;
	}
</script>
<%--
<style>
.datagrid-btable{ width:100%}
</style>
 --%>
<%-- 2. 页面内容 --%>
<table id="CoachDataGrid" title="教练列表" style="width: 100%" toolbar="#coachToolbar"
	idField="coachId" rownumbers="true" fitColumns="true" nowrap="false">
	<thead>
		<tr>
			<th field="ck" checkbox="true" width="50" sortable="true">多选框</th>
			<th field="coachName" width="50" sortable="true" data-options="formatter:imgFormatter">教练姓名
				 
			</th>
			<th field="coachType" width="50" sortable="true">教练类型</th>
			<th field="coachImageUrl" width="50" sortable="true">教练图片路径</th>
			<th field="coachStatus" width="50" sortable="true">教练空闲状态</th>
		</tr>
	</thead>
</table>
<div id="coachToolbar">
	<div>
	<form action="" id="CoachSearchForm">
		<span>教练姓名:</span> <input name="coachName" id="coachName"
			class="easyui-textbox" /> 
		 <a class="easyui-linkbutton" iconCls="icon-search" plain="true"
			onclick="Coach.doSearch()"><s:message code="label.search"></s:message></a>
		<a class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="Coach.clearAll()"><s:message code="label.clear"></s:message></a>
	</form>
	</div>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="Coach.toAdd()">添加教练</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="Coach.toEdit()">修改教练</a>
	<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="Coach.toDelete()">删除教练</a>

</div>
<%-- grid右键菜单 --%>
<div id="coachContextMenu" class="easyui-menu" style="width:120px;">
	<div onclick="Coach.toAdd()" data-options="iconCls:'icon-add'">添加教练</div>
	<div onclick="Coach.toEdit()" data-options="iconCls:'icon-edit'">修改教练</div>
	<div onclick="Coach.toDelete()" data-options="iconCls:'icon-remove'">删除教练</div>

</div>


<%-- 3. 包含的Dialog页面等其他内容 --%>
<%@ include file="/WEB-INF/content/dialog/coach/CoachAdd.jsp"%>
<%@ include file="/WEB-INF/content/dialog/coach/CoachEdit.jsp"%>
