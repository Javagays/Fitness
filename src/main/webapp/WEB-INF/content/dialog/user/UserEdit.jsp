<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>

<script type="text/javascript">
$(function() {
	
	/*
	 * 执行增改
	 */
	//执行添加或修改
	User.edit = function() {
		var dg=$("#userDataGrid");
		var url = "User/update";
		uiEx.submitURLAjax("#userEditForm", url, function(data) {
			data = eval("(" + data + ")");
			// 执行成功，刷新dg
			if (data.statusCode==200) {
				//uiEx.reloadSelTab("#tabs");
				//dg.datagrid('reload'); //刷新表格，在第当前页
				dg.datagrid({"pageNumber":data.page});//刷新表格
				//dg.datagrid('load'); //刷新表格
				uiEx.closeDialog("#empEditDialog");
			} 
		},{"rows":dg.datagrid("options").pageSize});
	}
});

</script>
<!-- 添加或修改Dialog -->
<div id="userEditDialog" class="easyui-dialog"
	style="width:480px;height:330px;padding:10px 20px;" resizable="true" closed="true"
	buttons="#userEdit-dlg-buttons">
	<div class="ftitle">用户信息</div>
	<form id="userEditForm" method="post">
			<input name="userId" type="hidden">
			 <table cellpadding="5">
	    		<tr>
	    			<td>会员姓名:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="userName" required="true" data-options="prompt:'input username...'" style="width:180px"><span class="required">*</span></td>
	    		</tr>
	    		<tr>
	    			<td>会员电话:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="userPhone"></td>
	    		</tr>
	    		<tr>
	    			<td>会员积分:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="userIntegral"></td>
	    		</tr>
	    		<tr>
	    			<td>家庭住址:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="homeLocation"></td>
	    		</tr>
	    		<tr>
	    			<td>工作地址:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="workLocation"></td>
	    		</tr>
	    		<tr>
	    			<td>会员生日:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="birthday"></td>
	    		</tr>
	    		<tr>
	    			<td>身份证号:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="userIDcard"></td>
	    		</tr>
	    		<tr>
	    			<td>注册时间:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="registerTime"></td>
	    		</tr>
	    		<tr>
	    			<td>身高:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="height"></td>
	    		</tr>
	    		<tr>
	    			<td>体重:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="weight"></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="sex"></td>
	    		</tr>
	    	</table>
	</form>
	
<div id="userEdit-dlg-buttons">
	<a class="easyui-linkbutton" id="userEditSaveBtn" iconCls="icon-ok"
		onclick="User.edit()">修改</a> <a class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:uiEx.closeDialog('#userEditDialog')">取消</a>
</div>
</div>

