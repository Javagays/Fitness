<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>
<script type="text/javascript">
$(function(){
	//执行增加或修改
	Activity2.doEdit = function() {
		var dg=$("#ActivityDataGrid");    //這裡的命名空間要和activity的一樣
		var url = "Activity/update";
		uiEx.submitURLAjax("#Activity2EditForm", url, function(data) {
			data = eval("(" + data + ")");
			// 执行成功，刷新dg
			if (data.statusCode==200) {
				//uiEx.reloadSelTab("#tabs");
				//dg.datagrid('reload'); //刷新表格，在第当前页
				dg.datagrid({"pageNumber":data.page});//刷新表格
				//dg.datagrid('load'); //刷新表格
				uiEx.closeDialog("#Activity2EditDialog");
			} 
		},{"rows":dg.datagrid("options").pageSize});
	}
})
</script>

<!-- 添加或修改dialog -->
	<div id="Activity2EditDialog" class="easyui-dialog"
	style="width:480px;height:330px;padding:10px 20px;" resizable="true" closed="true"
	buttons="#activityEdit-dlg-buttons">
	<div class="ftitle">活动信息</div>
	<form id="Activity2EditForm" method="post">
			<input name="activityId" type="hidden">  <!-- 这里的隐藏ID，name要和后端对应上 -->
			 <table cellpadding="5">
	    		<tr>
	    			<td>活动内容:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="acContent" id="editContent"
				></td>
	    		</tr>
	    	</table>
	</form>
</div>
<div id="activityEdit-dlg-buttons">
	<a class="easyui-linkbutton" id="activityEditSaveBtn" iconCls="icon-ok"
		onclick="Activity2.doEdit()">修改</a> <a class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:uiEx.closeDialog('#Activity2EditDialog')">取消</a>
</div>