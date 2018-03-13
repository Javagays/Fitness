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
	var BuyOrder = {};
	$(function() {
		/*
		 * datagrid数据格式化
		 */
		/*
		 * 数据表格初始化
		 */
		var dg = $("#BuyOrderDataGrid");

		// 第一次DG加载，以后无需初始化combobox
		var firstLoad = true;

		$("#BuyOrderDataGrid").initDatagrid({
			/*
			 * 行编辑:saveUrl、updateUrl、destroyUrl配合uiEx使用
			 */
			url : "BuyOrder/list",
/* 			saveUrl : "Activity/add",
			updateUrl : "Activity/update",
			destroyUrl : "Activity/delete", */
			idField : "orderId",
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
			menuSelector : "#BuyOrderContextMenu",
			showContextMenu : true,
			sendRowDataPrefix : "", //提交数据前缀
			successKey : "statusCode", //服务器端返回的成功标记key
			successValue : "200", //服务器端返回的成功标记value
			onLoadSuccess : function(data) {
				// 第一次DG加载，以后无需初始化combobox
				//if (firstLoad) {
					// 部门数据集合，添加和修改时无需去服务器查询
					BuyOrder.allList = data.allCoach;
					$('#orderId').combobox({
						data : BuyOrder.allList,
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
			mutipleDeleteProperty : "orderId" // 多行删除时提及给服务器的属性和值，不会添加sendRowDataPrefix前缀，支持使用数组指定多个属性名
		});

	});
</script>


<%-- 2. 页面内容 --%>
<table id="BuyOrderDataGrid" title="用户购卡记录列表" style="width: 100%" toolbar="#BuyOrderToolbar"
	idField="orderId" rownumbers="true" fitColumns="true" nowrap="false">
	<thead>
		<tr>
			<th field="ck" checkbox="true" width="50" sortable="true">多选框</th>
		    <th field="userId" width="50" sortable="true">用户ID</th>
			<th field="cardName" width="50" sortable="true">卡名称</th><!-- 这里的field一定要与后端字段对应上，否则前端无法对应上就显示不出数据 -->
			<th field="cardType" width="50" sortable="true">卡种类</th>
			<th field="cardPrice" width="50" sortable="true">价格</th>
			<th field="cardCourse" width="50" sortable="true">课程</th>
			<th field="cardDate" width="50" sortable="true">使用期限天数</th>
			<th field="cardSite" width="50" sortable="true">场地</th>
			<th field="cardFaceAmount" width="50" sortable="true">面额</th>
			<th field="useNumber" width="50" sortable="true">使用次数</th>
			<th field="cardSalesMan" width="50" sortable="true">销售人员</th>
			<th field="cardState" width="50" sortable="true">状态</th>
		</tr>
	</thead>
</table>

