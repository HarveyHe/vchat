<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>角色用户权限维护</title>
	<%@include file="/common/include.jsp" %>
    <style type="text/css">



    </style>
    <script type="text/javascript" >
    	
    	$(document).ready(function(){
    		queryRoleUsersRights();
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
    
//     	角色用户权限维护
    	function queryRoleUsersRights(){
    		$("#gridResult").datagrid("commonQuery", {
				queryType : "BasUsersListaggQuery",
				paramForm : "formQuery"
			});
    		$('#usersId').val("");
    	};
    	
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
	    				queryRoleUsersRights();
    				}
    	    	});
    	}
	    function formatStatus(value, rowData, rowIndex) {
	        if (value == 'COMPANY') {
	          return "公司";
	        } else if (value == 'DEPARTMENT') {
	          return "部门";
	        } else {
	          return "";
	        }
	   }
    </script>

</head>
<body class="easyui-layout">
	<div region="north" title="查询条件" iconCls="icon-search">
		<div class="datagrid-toolbar">
			<a class="easyui-linkbutton" iconCls="icon-search"  onclick="queryRoleUsersRights()">查询</a>
		</div>
		<form id="formQuery" class="easyui-form" style="padding:10px;"  columns="3" >
			<input name="employeeNo"
					title="工号 " class="easyui-combogrid" codetype="EMPLOYEE_NO"/>
			<input title="角色" name="roleName" class="easyui-combobox" codetype="ROLES_NAME" style="margin-left:20px;"/>
			
		</form>
	</div>
	
	<div region="center" title="" iconCls="">
		 
		<table id="gridResult" class="easyui-datagrid" fit="true" checkbox="false"  >
			<thead>
				<tr>
					 
					<th field="employeeNo"  title="工号"  />
					<th field="userName"  title="姓名"  />
					<th field="departmentName"  title="部门"  />
					<th field="roleName"  title="角色"  />
					<th field="financeApprovalAmount"  title="财务主管审批金额"  allowHeaderWrap="true"/>
					<th field="dataScope"  title="数据范围"  formatter="formatStatus"/>
					<th field="status" title="状态" codetype="USER_STATUS" />
					 
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
<!-- 			<li> -->
<!-- 				<span id="role">角色</span> -->
<!-- 				<ul  id="tt2" class="easyui-tree" animate="true" dnd="true"> -->
<!-- 					<li> -->
<!-- 						<span>管理员</span> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<span>借款申请人</span> -->
<!-- 					</li> -->
<!-- 				</ul> -->
<!-- 			</li> -->
		</ul>
	</div>
	 
	
	 
</body>
</html>