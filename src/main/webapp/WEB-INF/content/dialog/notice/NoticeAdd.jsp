<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>
<script type="text/javascript">
$(function(){
	//执行增加或修改
	Notice.doAdd = function() {
		var dg=$("#NoticeDataGrid");    //這裡的命名空間要和activity的一樣
		var url = "Notice/add";
		uiEx.submitURLAjax("#NoticeAddForm", url, function(data) {
			data = eval("(" + data + ")");
			// 执行成功，刷新dg
			if (data.statusCode==200) {
				//uiEx.reloadSelTab("#tabs");
				//dg.datagrid('reload'); //刷新表格，在第当前页
				dg.datagrid({"pageNumber":data.page});//刷新表格
				//dg.datagrid('load'); //刷新表格
				uiEx.closeDialog("#noticeAddDialog");
			} 
		},{"rows":dg.datagrid("options").pageSize});
	}
})
</script>

<!-- 添加或修改dialog -->
	<div id="noticeAddDialog" class="easyui-dialog"
	style="width:480px;height:330px;padding:10px 20px;" resizable="true" closed="true"
	buttons="#noticeAdd-dlg-buttons">
	<div class="ftitle">活动信息</div>
	<form id="NoticeAddForm" method="post">
			<input name="noticeId" type="hidden">
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
	    			<td><input class="easyui-textbox easyui-validatebox" name="noContent" id="addContent"
				></td>
	    		</tr>
	    	</table>
	</form>
</div>
<div id="noticeAdd-dlg-buttons">
	<a class="easyui-linkbutton" id="noticeEditSaveBtn" iconCls="icon-ok"
		onclick="Notice.doAdd()">添加</a> <a class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:uiEx.closeDialog('#noticeAddDialog')">取消</a>
</div>