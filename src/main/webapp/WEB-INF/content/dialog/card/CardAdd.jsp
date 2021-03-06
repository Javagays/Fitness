<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>

<script type="text/javascript">
	$(function() {
		/*
		 *执行增改
		 */
		//执行添加或修改
		Card.add = function() {
			var dg = $("#cardDataGrid");
			var url = "Card/save";
			uiEx.submitURLAjax("#cardAddForm", url, function(data) {
				data = eval("(" + data + ")");
				// 执行成功，刷新dg
				if (data.statusCode == 200) {
					//uiEx.reloadSelTab("#tabs");
					//dg.datagrid('reload'); //刷新表格，在第当前页
					dg.datagrid({
						"pageNumber" : data.page
					});//刷新表格
					//dg.datagrid('load'); //刷新表格
					uiEx.closeDialog("#cardAddDialog");
				}
			}, {
				"rows" : dg.datagrid("options").pageSize
			});
		}
	});
</script>

<!-- 添加或修改Dialog -->
<div id="cardAddDialog" class="easyui-dialog"
	style="width: 480px; height: 330px; padding: 10px 20px;"
	resizable="true" closed="true" buttons="#cardAdd-dlg-buttons">
	<div class="ftitle">健身卡信息</div>
	<form id="cardAddForm" method="post">
		<!-- <input name="userId" type="hidden">  -->
		<table cellpadding="5">
			<tr>
				<td>卡名称:</td>
				<td><input class="easyui-textbox easyui-validatebox"
					name="cardName" required="true"
					data-options="prompt:'input username...'" style="width: 180px"><span
					class="required">*</span></td>
			</tr>
			<tr>
				<td>金额:</td>
				<td><input class="easyui-textbox easyui-validatebox" name="cardPrice"></td>
			</tr>
			<tr>
				<td>使用天数:</td>
				<td><input class="easyui-textbox easyui-validatebox" name="cardDate"></td>
			</tr>
			<tr>
				<td>使用次数:</td>
				<td><input class="easyui-textbox easyui-validatebox" name="cardNum"></td>
			</tr>
			<tr>
				<td>使用场馆:</td>
				<td><input class="easyui-textbox easyui-validatebox" name="cardSite"></td>
			</tr>
			<tr>
				<td>銷售人員:</td>
				<td><input class="easyui-textbox easyui-validatebox" name="cardSalesName"></td>
			</tr>
			
			<tr>
				<td>类型:</td>
				<td><input id="addCardType" name="cardType" required="true">
					<span class="required">*</span></td>
			</tr>
		</table>
	</form>
</div>
<div id="cardAdd-dlg-buttons">
	<a class="easyui-linkbutton" id="cardAddSaveBtn" iconCls="icon-ok"
		onclick="card.add()">添加</a> <a class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:uiEx.closeDialog('#cardAddDialog')">取消</a>
</div>