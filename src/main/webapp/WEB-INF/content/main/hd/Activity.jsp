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
	var Activity2 = {};
	$(function() {
		/*
		 * datagrid数据格式化
		 */
		/*
		 * 数据表格初始化
		 */
		var dg = $("#ActivityDataGrid");

		// 第一次DG加载，以后无需初始化combobox
		var firstLoad = true;

		$("#ActivityDataGrid").initDatagrid({
			/*
			 * 行编辑:saveUrl、updateUrl、destroyUrl配合uiEx使用
			 */
			url : "Activity/list",
			saveUrl : "Activity/add",
			updateUrl : "Activity/update",
			destroyUrl : "Activity/delete",
			idField : "activityId",
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
			menuSelector : "#ActivityContextMenu",
			showContextMenu : true,
			sendRowDataPrefix : "", //提交数据前缀
			successKey : "statusCode", //服务器端返回的成功标记key
			successValue : "200", //服务器端返回的成功标记value
			onLoadSuccess : function(data) {
				// 第一次DG加载，以后无需初始化combobox
				//if (firstLoad) {
					// 部门数据集合，添加和修改时无需去服务器查询
					Activity2.allList = data.allCoach;
					$('#activityId').combobox({
						data : Activity2.allList,
						valueField : '',
						textField : 'acContent',
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
			mutipleDeleteProperty : "activityId" // 多行删除时提及给服务器的属性和值，不会添加sendRowDataPrefix前缀，支持使用数组指定多个属性名
		});

		//搜索
		Activity2.doSearch = function() {
			console.log(1111111111111);
			dg.datagrid("load", {
				'activityId' : $("#ACID").val()
		//上面的activityId和后端接收这个字段的名字必须一致，否则对应不上就无法搜索
//				'deptno' : $("#empDeptno").combobox("getValue")
			});
		}
		Activity2.clearAll = function() {
			//ActivitySearchForm  这里ID选择器要加#号，否则就会显示没有定义，就不起作用
			$("#ActivitySearchForm")[0].reset();
		//	$("#AppointmentSearchForm").form('reset');
			dg.datagrid("load", {
			});
		};
		
		Activity2.toAdd = function() {
			
			uiEx.resetForm("#Activity2AddForm");
			uiEx.openDialog("#Activity2AddDialog", "添加活动");
			/*
			 * 初始化部门combobox
			 */
			 $.post("Activity/allActivity","",function(data){
				
				$('#addActivityId').combobox({
					data : data,
					valueField : 'activityId',
					textField : 'acContent',
					panelHeight : 'auto',
					editable : false,
					onLoadSuccess : function() { //加载完成后,设置选中第一项
						var val = $(this).combobox("getData");
						$(this).combobox("select", val[0].activityId);
					}
				});
			}) 
		};
		
			
			// 删除 
			Activity2.toDelete = function() {
				var rows = $("#ActivityDataGrid").datagrid('getSelections');
				if (rows) {
					dg.rowDelete(true, false, "statusCode", "200");
				} else {
					uiEx.msg("请选择要删除的行");
				}
			}
			
			//点击按钮修改
			Activity2.toEdit = function() {
				var row = $("#ActivityDataGrid").datagrid('getSelected');
				alert(row);
				if (row) {
					toEdit(row);
				} else {
					uiEx.msg("请选择要修改的行");
				}
			}
			//打开修改
			function toEdit(row) {
				uiEx.resetForm("#Activity2EditForm");
				uiEx.openDialog("#Activity2EditDialog", "活动内容修改");

				uiEx.loadForm("#Activity2EditForm", row, "");
				/*
				 * 初始化部门combobox
				 */
				 $.post("Activity/allActivity","",function(data){
					$('#editAcContent').combobox({
						data : data,
						textField : 'activityId',
						textField : 'acContent',
						panelHeight : 'auto',
						editable : false,
						onLoadSuccess : function() { //加载完成后,设置选中第一项
							var val = $(this).combobox("getData");
							$(this).combobox("select", row.activity.acContent);
						}
					});
				 });
			}
	});
</script>
<%--
<style>
.datagrid-btable{ width:100%}
</style>
 --%>
 <div id="ActivityToolbar">
	<div>
	<form action="" id="ActivitySearchForm">
		<span>活动ID查询:</span> <input name="ID" id="ACID"
			class="easyui-textbox" /> 
	 <a class="easyui-linkbutton" iconCls="icon-search" plain="true"
			onclick="Activity2.doSearch()"><s:message code="label.search"></s:message></a>
		<a class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="Activity2.clearAll()"><s:message code="label.clear"></s:message></a>
	</form>
	</div>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="Activity2.toAdd()">添加内容</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="Activity2.toEdit()">修改内容</a>
	<a class="easyui-linkbutton" iconCls="icon-remove" plain="true"
		onclick="Activity2.toDelete()">删除内容</a>

</div>
<%-- 2. 页面内容 --%>
<table id="ActivityDataGrid" title="活动内容列表" style="width: 100%" toolbar="#ActivityToolbar"
	idField="activityId" rownumbers="true" fitColumns="true" nowrap="false">
	<thead>
		<tr>
			<th field="ck" checkbox="true" width="50" sortable="true">多选框</th>
			<!-- <!-- <th field="activityId" width="50" sortable="true">活动ID</th> --> -->
			<th field="acContent" width="50" sortable="true">活动内容</th><!-- 这里的field一定要与后端字段对应上，否则前端无法对应上就显示不出数据 -->
		</tr>
	</thead>
</table>

	<%-- 3. 包含的Dialog页面等其他内容 --%>
<%@ include file="/WEB-INF/content/dialog/hd/activityAdd.jsp"%>
<%@ include file="/WEB-INF/content/dialog/hd/activityEdit.jsp"%>
