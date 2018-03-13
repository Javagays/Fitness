<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>
<script type="text/javascript">
$(function(){
	//执行增加或修改
	Activity2.doAdd = function() {
		var dg=$("#ActivityDataGrid");    //這裡的命名空間要和activity的一樣
		var url = "Activity/add";
		uiEx.submitURLAjax("#Activity2AddForm", url, function(data) {
			data = eval("(" + data + ")");
			// 执行成功，刷新dg
			if (data.statusCode==200) {
				//uiEx.reloadSelTab("#tabs");
				//dg.datagrid('reload'); //刷新表格，在第当前页
				dg.datagrid({"pageNumber":data.page});//刷新表格
				//dg.datagrid('load'); //刷新表格
				uiEx.closeDialog("#Activity2AddDialog");
			} 
		},{"rows":dg.datagrid("options").pageSize});
	}
})
</script>

<!-- 添加或修改dialog -->
	<div id="Activity2AddDialog" class="easyui-dialog"
	style="width:480px;height:330px;padding:10px 20px;" resizable="true" closed="true"
	buttons="#activityAdd-dlg-buttons">
	<div class="ftitle">活动信息</div>
	<form id="Activity2AddForm" method="post">
			<input name="ID" type="hidden">
			 <table cellpadding="5">
			 <!-- 
	    		<tr>
	    			<td>活动ID:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="ID"
				data-options="prompt:'input username...'" style="width:180px"></td>
	    		</tr>
	    		 -->
	    		<tr>
	    			<td>活动内容:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="acContent" id="addContent"
				></td>
	    		</tr>
	    	</table>
	</form>
</div>
<div id="activityAdd-dlg-buttons">
	<a class="easyui-linkbutton" id="activityEditSaveBtn" iconCls="icon-ok"
		onclick="Activity2.doAdd()">添加</a> <a class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:uiEx.closeDialog('#Activity2AddDialog')">取消</a>
</div>