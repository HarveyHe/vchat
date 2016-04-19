<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户权限维护</title>
	<%@include file="/common/include.jsp" %>
    <script type="text/javascript" >
    	$(document).ready(function(){
    		queryUsers();
    		queryRole();
    		$("#gridResult").datagrid("bind", {
    			onClickRow : function(rowIndex, rowData) {
    				if(rowData.employeeNo) {
    					$('#employeeNo').val(rowData.employeeNo);
    					$('#usersId').val(rowData.usersId);
			    		queryRole();
    				}
    			}
    		});
    	});
    	var roleName="";
//     	用户权限维护
    	function queryUsers(){
    		$("#gridResult").datagrid("commonQuery", {
				queryType : "BasUsersListaggQuery",
				paramForm : "formQuery"
			});
    		$("#usersEditDiv").dialog({  
    	        onClose: function () {  
    	        	$("#usersInputForm").form('clear');
    	        }  
    	    });
    		$('#usersId').val("");
	
    	};
    	function newUsers(){
    		roleName="";
    		$("#usersInputForm :input").removeClass("validatebox-invalid");
    		$("#usersEditDiv").dialog("open");
    	};
    	function editUsers(){
    		var selections = $("#gridResult").datagrid("getSelections");
    		if(selections && selections.length==1) {
    			roleName=selections[0].roleName;
    			$("#usersInputForm").form("setData",selections[0]);
    			$("#usersEditDiv").dialog("open");
    		} else {
    			$.messager.alert("警告","请选择一条记录！","warning");
    		}
    		
    	};
    	function deleteUsers(){
    		var selections = $("#gridResult").datagrid("getSelections");
    		if(!selections || selections.length == 0) {
    			$.messager.alert("警告","请选择一条记录！","warning");
    		} else {
    			$.messager.confirm("确定框","确认删除所选记录？",function(result){
    				if(result) {
    					var ids=new Array();
    					for(var i=0;i<selections.length;i++){
    						 ids[i] = selections[i].usersId;
    					}
    					$.post($url('/rest/basUsersRest/removeAllByPk.json'), {"ids":ids},function(result) {
    						queryUsers();
    			    	});
    				}
    			});
    		}
    	};
    	
    	function saveUsers() {
    		if($("#usersInputForm").form("validate")) {
    			if(roleName==null){
    				roleName="";
    			}
	    		var bool1 = roleName.indexOf("查询用户");
				var bool2 = roleName.indexOf("财务主管");
				if(bool1>0){
					var dataScope= $("#dataScope").combobox("getValue");
					if(dataScope==""){
		    			$.messager.alert("警告","该用户为查询用户，数据范围不能为空","warning");
		    			return;
					}
				}
				if(bool2>0){
					var financeApprovalAmount= $("#financeApprovalAmount").val();
					if(financeApprovalAmount==""){
		    			$.messager.alert("警告","该用户为财务主管，请输入财务主管审批金额","warning");
						return;
					}
				}
	    		var formData = app.util.getFormData($("#usersInputForm"));
    		    $.post($url('/rest/basUsersRest/save.json'), formData,
    		        function(result) {
    		    		if(result.error){
			    			$.messager.alert("警告",result.message,"warning");
    		    			
    		    		}else{
			    			queryUsers();
				    		$("#usersEditDiv").dialog("close");
				    		$("#usersInputForm").form("clear");
    		    			
    		    		}
    		        });
    		} else {
    			$.messager.alert("警告","校验不通过，请输入必填项","warning");
    		}
		};
    	function clearSensitivePassword() {
    		if($("#usersInputForm").form("validate")) {
	    		var formData = app.util.getFormData($("#usersInputForm"));
	    		$.post($url('/rest/basUsersRest/clearSensitivePassword.json'), formData,function(result) {
	    			$("#usersInputForm :input[name=sensitivePassword]").val("");
	    			$.messager.alert("信息","已清除二次密码","info");
		    	});
    		} else {
    			$.messager.alert("警告","用户信息不完整，请补充！","warning");
    		}
		};
		
    	function chooseUsersCancel() {
			$("#usersEditDiv").dialog("close");
			$("#usersInputForm").form("clear");
		};
    	
	    function formatStatus(value, rowData, rowIndex) {
	        if (value == 'COMPANY') {
	          return "公司";
	        } else if (value == 'DEPARTMENT') {
	          return "部门";
	        } else {
	          return "";
	        }
	   }
	    
    	function queryRole(){
    		var employeeNo =$('#employeeNo').val();
    		$.post($url('/rest/basRolesRest/queryForTree.json'), {"employeeNo":employeeNo},function(data) {
    			$("#tt1").tree({data:[{
    					"id":"root_role",
    					"text":"角色",
    					"children":data
    				}]
    			});
	    	},"json");
    	}
    	function saveRoleUsersRights(){
			var data = $('#tt1').tree('getChecked')  ;
			var usersId= $('#usersId').val();
			var rolesIds=new Array();
			for(var i=0;i<data.length;i++){
				rolesIds[i] = data[i].id;
			}
			$.post($url('/rest/basRolesRest/saveAllUsersRoles.json'), {"usersId":usersId,"rolesIds":rolesIds},function(result) {
				if(result.errors){
					$.messager.alert("警告",result.errors.substr(result.errors.indexOf(":") + 1),"warning");
				}else{
					queryUsers();
				}
	    	});
		}
    </script>

</head>
<body class="easyui-layout">
	<div region="north" title="查询条件" iconCls="icon-search">
		<div class="datagrid-toolbar">
			<a class="easyui-linkbutton" iconCls="icon-search"  onclick="queryUsers()">查询</a>
		</div>
		<form id="formQuery" class="easyui-form" style="padding:10px;"  columns="3" >
			<input name="employeeNo"
					title="工号 " class="easyui-combogrid" codetype="EMPLOYEE_NO"/>
			<input title="角色" name="roleName" class="easyui-combobox" codetype="ROLES_NAME" style="margin-left:20px;"/>
			
		</form>
	</div>
	
	<div region="center" title="列表" iconCls="icon-edit">
		 
		<div class="datagrid-toolbar">
			<a class="easyui-linkbutton" iconCls="icon-add"  onclick="newUsers()">新建</a>
			<a class="easyui-linkbutton" iconCls="icon-edit"  onclick="editUsers()">编辑</a>
			<a class="easyui-linkbutton" iconCls="icon-remove"  onclick="deleteUsers()">删除</a>
		</div>
		<table id="gridResult" class="easyui-datagrid"    fit="true">
			<thead>
				<tr>
					<th field="employeeNo" title="工号" />
					<th field="userName" title="姓名"  />
					<th field="departmentName" title="部门" />
					<th field="email" title="邮箱"  />
					<th field="roleName" title="角色" />
					<th field="financeApprovalAmount" title="财务主管审批金额" />
					<th field="dataScope" title="数据范围" formatter="formatStatus" />
					<th field="status" title="状态" codetype="USER_STATUS" />
					<th field="modifier" title="修改人" codetype ="USER_ID"/>
					<th field="modifyTime" title="修改时间"  formatter="Common.DateTimeSSFormatter"/>
					 
				</tr>
			</thead>
		</table>
	</div>
		<div region="east" title="角色列表" style="width:200px">
		<div class="datagrid-toolbar">
			<a class="easyui-linkbutton" iconCls="icon-save"  onclick="saveRoleUsersRights()">保存</a>
		</div>
		<input id="employeeNo" name="employeeNo" type="hidden"/>
		<input id="usersId" name="usersId" type="hidden"/>
		<ul id="tt1" class="easyui-tree" animate="true" dnd="true"  checkbox="true">
		</ul>
	</div>
	 
	 <!-- 新建/编辑 用户-->
	<div id="usersEditDiv" class="easyui-dialog" title="用户维护" iconCls=""
			style="width:420px;height:370px" closed="true" modal="true">
			<form id="usersInputForm" class="easyui-form" columns="1">
				<input type="hidden" name="usersId"/>
				<input type="hidden" name="isNeedConfirmPassword"/>
				<input type="hidden" name="empGrade"/>
				<input name="employeeNo" title="工号" required class="easyui-validatebox" validType="maxLength[10]" />
				<input name="userName" title="姓名" required class="easyui-validatebox" validType="maxLength[10]" />
				<input name="companyId" title="公司" required class="easyui-combogrid" codetype="COMPANY_ID"/>
				<input name="departmentName" title="部门" required class="easyui-combobox" codetype="DEPARTMENT_NAME"/>
				<input name="email" title="邮箱"  validType="maxLength[30]" />
				<input name="domainUserName" title="域用户名"  class="easyui-validatebox" validType="maxLength[20]"/>
				<input name="financeApprovalAmount" id="financeApprovalAmount" title="财务主管审批金额" validType="multiple['maxLength[10]','intNumber']" class="easyui-validatebox" />
				<input name="dataScope" id="dataScope" title="数据范围" class="easyui-combobox" codetype="DATA_SCOPE" />
				<input name="status" title="状态" required class="easyui-combobox" codetype="USER_STATUS" value="NORMAL" />
				<div>
					<input name="sensitivePassword" type="password" title="敏感信息二次密码" disabled="disabled"/>
					<a class="easyui-linkbutton" onclick="clearSensitivePassword()">清空密码</a>
				</div>
			</form>
			
		<div class="dialog-buttons" style="text-align:center">
			<a class="easyui-linkbutton" iconCls="icon-save" onclick="saveUsers()">保存</a>
			<a class="easyui-linkbutton" iconCls="myCustomerIcon_cancel" onclick="chooseUsersCancel()">取消</a>
		</div>
	</div>

	 
</body>
</html>