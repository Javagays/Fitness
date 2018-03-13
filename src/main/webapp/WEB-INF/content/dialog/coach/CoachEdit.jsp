<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>

<script type="text/javascript">
$(function() {
	
	/*
	 * 执行增改
	 */
	//执行添加或修改
	Coach.edit = function() {
		var dg=$("#CoachDataGrid");
		var url = "Coach/update";
		uiEx.submitURLAjax("#coachEditForm", url, function(data) {
			data = eval("(" + data + ")");
			// 执行成功，刷新dg
			if (data.statusCode==200) {
				//uiEx.reloadSelTab("#tabs");
				dg.datagrid('reload'); //刷新表格，在第当前页
				dg.datagrid({"pageNumber":data.page});//刷新表格
				//dg.datagrid('load'); //刷新表格
				uiEx.closeDialog("#coachEditDialog");
			} 
		},{"rows":dg.datagrid("options").pageSize});
	}
});

</script>
<!-- 添加或修改Dialog -->
<div id="coachEditDialog" class="easyui-dialog"
	style="width:480px;height:330px;padding:10px 20px;" resizable="true" closed="true"
	buttons="#coachEdit-dlg-buttons">
	<div class="ftitle">教练信息</div>
	<form id="coachEditForm" method="post">
			<input name="coachId" type="hidden">
			 <table cellpadding="5">
	    		<tr>
	    			<td>教练姓名:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="coachName"
				 required="true"
				data-options="prompt:'input coachname...'" style="width:180px"><span class="required">*</span></td>
	    		</tr>
	    		<tr>
	    			<td>教练类型:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="coachType"
				></td>
	    		</tr>
	    		<tr>
	    			<td>教练状态:</td>
	    			<td>
						<input  name="coachStatus" required="true"> <span class="required">*</span>				
					</td>
	    		</tr>
	    	</table>
	</form>
</div>
<div id="coachEdit-dlg-buttons">
	<a class="easyui-linkbutton" id="CoachEditSaveBtn" iconCls="icon-ok"
		onclick="Coach.edit()">修改</a> <a class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:uiEx.closeDialog('#coachEditDialog')">取消</a>
</div>