<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%-- 1. 页面Datagrid初始化相关JS --%>
<%-- JS代码必须包含在页面中，引入外部JS文件会导致表格界面在未完成初始化前就显示，出现短暂的未初始化界面 --%>

<script type="text/javascript">
$(function() {
	
	/*
	 * 执行增改
	 */
	//执行添加或修改
	Coach.add = function() {
		var dg=$("#coachDataGrid");
		var url = "Coach/add";
		
		//alert("a");
		
		//1. 表单验证
		//$('#coachAddForm').form('enableValidation').form('validate');
	 
		
		
		//2. 提交数据到url
		// {"rows":dg.datagrid("options").pageSize}
		// ....
			var form = $('#coachAddForm')[0];
            var formData = new FormData(form);
            $.ajax({
                url:url,
                type:'post',
                data:formData,
                dataType:'json',
                cache:true,
                async:false,
                contentType:false,
                processData:false,
                success:function(data,status,xhr){
                   if (data.statusCode==200) {
                	   $("#coachAddDialog").dialog("close");
                	   $('#CoachDataGrid').datagrid('reload');
                   }
                   
                },
                error:function(xhr,status,error){
                   alert('状态'+status+'错误原因'+error);
                }
             });
		
		//3.处理成功刷新表格 
		
		
		/* 
		uiEx.submitURLAjax("#coachAddForm", url, function(data) {
			data = eval("(" + data + ")");
			// 执行成功，刷新dg
			if (data.statusCode==200) {
				//uiEx.reloadSelTab("#tabs");
				//dg.datagrid('reload'); //刷新表格，在第当前页
				dg.datagrid({"pageNumber":data.page});//刷新表格
				//dg.datagrid('load'); //刷新表格
				uiEx.closeDialog("#coachAddDialog");
			} 
		},{"rows":dg.datagrid("options").pageSize}); */
	}
});

</script>
<!-- 添加或修改Dialog -->
<div id="coachAddDialog" class="easyui-dialog"
	style="width:480px;height:330px;padding:10px 20px;" resizable="true" closed="true"
	buttons="#coachAdd-dlg-buttons">
	<div class="ftitle">教练信息</div>
	<form id="coachAddForm" method="post" enctype="multipart/form-data">
			<input name="coachId" type="hidden">
			 <table cellpadding="5">
	    		<tr>
	    			<td>教练姓名:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="coachName"
				required="true"
				data-options="prompt:'input username...'" style="width:180px"><span class="required">*</span></td>
	    		</tr>
	    		<tr>
	    			<td>教练类型:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="coachType"></td>
	    		</tr>
	    		<tr>
	    			<td>教练内容:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="coachContent"></td>
	    		</tr>
	    		<tr>
	    			<td>教练电话:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="coachPhoneno"></td>
	    		</tr>
	    		<tr>
	    			<td>教练座右铭:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="coachMotto"></td>
	    		</tr>
	    		<tr>
	    			<td>教练经验:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" name="coachExperience"></td>
	    		</tr>
	    		<tr>
	    			<td>图片上传:</td>
	    			<td><input  type="file"  name="myfile"></td>
	    		</tr>
	    		<tr>
	    			<td>教练空闲状态:</td>
	    			<td>
						<input  name="coachStatus" required="true"> <span class="required">*</span>				
					</td>
	    		</tr>
	    		<tr>
	    		<td>开始时间:</td>
	    		<td>
				      <input name="coachStarttimeStr" class="easyui-datetimebox" style="width:200px" data-options="
			            prompt: '开始时间',
			            icons:[{
			                iconCls:'icon-clear',
			                handler: function(e){
			                    $(e.data.target).datetimespinner('clear');
			                }
			            }]
			            "> 
            	</td>
	    		</tr>
	    		<tr>
	    			<td>结束时间:</td>
	    			<td>
	    				 <input name="coachEndtimeStr" class="easyui-datetimebox" style="width:200px" data-options="
				            prompt: '结束时间',
				            icons:[{
				                iconCls:'icon-clear',
				                handler: function(e){
				                    $(e.data.target).datetimespinner('clear');
				                }
				            }]
				            ">
	    			</td>
	    		</tr>
	    	</table>
	</form>
</div>
<div id="coachAdd-dlg-buttons">
	<a class="easyui-linkbutton" id="coachAddSaveBtn" iconCls="icon-ok"
		onclick="Coach.add()">添加</a> <a class="easyui-linkbutton"
		iconCls="icon-cancel"
		onclick="javascript:uiEx.closeDialog('#coachAddDialog')">取消</a>
</div>