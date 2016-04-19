<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>角色权限维护</title>
	<%@include file="/common/include.jsp" %>
    <script type="text/javascript" >
					$(document).ready(function() {
						$("#treeMenus").tree( {
							onCheck : function(node, checked){
								if(checked){
									var parNode=$("#treeMenus").tree("getParent",node.target);
									if(parNode!=null){
										$('#treeMenus').tree('check', parNode.target);
									}
									var childNode=$("#treeMenus").tree("getChildren",node.target);
// 									alert(JSON.stringify(childNode))
								}else{
									
								}
							}
							
						});
						queryRoleRights();
					});

					$(function() {
						$("#treeMenus").tree("options").parameters.parameters.queryInfo.resultClass = "com.gsst.yict.sras.bas.query.MenuRolesQueryItem";
					});
					// 	角色权限维护
					function queryRoleRights() {
						$("#gridRoles").datagrid("options").orderBy="roleName asc";
						$("#gridRoles").datagrid("commonQuery", {
								queryType : "BasRolesModel",
								paramForm : "formQuery",
						});
						$("#gridRoles").datagrid("bind",{
							"onSelect" :  function(index, rowData) {
								$("#treeMenus").tree("commonQuery", {
									queryType : "MenuRolesQuery",
									queryFields : [ {
										fieldName : "roleId",
										fieldStringValue : rowData.roleId
									} ]
								}).data('roleId', rowData.roleId);
								
								
							}
						});
					};
					function newRoleRights() {
						$("#roleRightsInputForm :input").removeClass("validatebox-invalid");
						$("#roleRightsEditDiv").dialog("open");
					};
					function editRoleRights() {
						var selections = $("#gridRoles").datagrid(
								"getSelections");
						if (selections && selections.length==1) {
							$("#roleRightsInputForm").form("setData",
									selections[0]);
							$("#roleRightsEditDiv").dialog("open");
						} else {
							$.messager.alert("警告", "请选择一条记录！", "warning");
						}

					};
					function deleteRoleRights() {
						var selections = $("#gridRoles").datagrid(
								"getSelections");
						if (!selections || selections.length == 0) {
							$.messager.alert("警告", "请选择一条记录！", "warning");
						} else {
							$.messager.confirm(	"确定框","确认删除所选记录？",function(result) {
								if (result) {
									var ids = new Array();
									for (var i = 0; i < selections.length; i++) {
										ids[i] = selections[i].roleId;
									}
									$.post($url('/rest/basRolesRest/removeAllByPk.json'),{"ids" : ids},
										function(result) {
											if(result.error){
												$.messager.alert("警告",result.message, "warning");
											}else{
												
												$.messager.alert("警告","已删除", "warning");
											}
											queryRoleRights();
										});
								}
							});
						}
					};

					function saveRoleRights() {
						if ($("#roleRightsInputForm").form("validate")) {
							var formData = app.util
									.getFormData($("#roleRightsInputForm"));
							$.post($url('/rest/basRolesRest/save.json'),
									formData, function(result) {
										if (result.error) {
											$.messager.alert("警告",
													result.message, "warning");

										} else {
											$("#formQuery").form("clear");
											$.messager.alert("提示", "操作成功", "tips");
											queryRoleRights();
											$("#roleRightsEditDiv").dialog(
													"close");
											$("#roleRightsInputForm").form("clear");

										}
									});
						} else {
							$.messager.alert("警告", "校验不通过，请输入必填项", "warning");
						}
					};

					function chooseRoleRightsCancel() {
						$("#roleRightsEditDiv").dialog("close");
						$("#roleRightsInputForm").form("clear");
					};

					//关闭全部
					function collapseAll() {
						var node = $('#treeMenus').tree('getSelected');
						if (node) {
							$('#treeMenus').tree('collapseAll', node.target);
						} else {
							$('#treeMenus').tree('collapseAll');
						}
					}
					//展开全部
					function expandAll() {
						var node = $('#treeMenus').tree('getSelected');
						if (node) {
							$('#treeMenus').tree('expandAll', node.target);
						} else {
							$('#treeMenus').tree('expandAll');
						}
					}

					//点击保存获取被选中信息（角色对应的菜单）
					function saveRoleMenu() {
						var tree = $('#treeMenus');
						var changes = tree.tree('getChanges');
						var roleId = tree.data('roleId');
						if (!changes || changes.length == 0 || !roleId) {
							$.messager.alert('提示', '角色拥有的菜单没有变化,不需要保存!');
							return;
						}
						var url = $url('/rest/basMenuManagerRest/saveMenuRoles.json?roleId='
								+ roleId);
						$.postJSON(url, changes, function(result) {
							if (result.errors) {
								$.messager.alert('保存出错', result.errors);
							} else {
								$.messager.alert('提示', '保存成功');
								var gridRoles = $("#gridRoles");
								var selected = gridRoles.datagrid("getSelected");
								var selectIndex = gridRoles.datagrid("getRowIndex",selected);
								gridRoles.datagrid("selectRow",selectIndex);
							}
						});
					}

					function statusFormatter(value, rowData, rowIndex) {
						if (value == 'NORMAL') {
							return "正常";
						} else if (value == 'DISABLE') {
							return "禁用";
						} else {
							return "---";
						}
					}
				</script>

</head>
<body class="easyui-layout">
	<div region="north" title="查询条件" iconCls="icon-search">
		<div class="datagrid-toolbar">
			<a class="easyui-linkbutton" iconCls="icon-search"  onclick="queryRoleRights()">查询</a>
		</div>
		<form id="formQuery" class="easyui-form" style="padding:10px;" columns="3">
			<input name="roleName" title="角色  " class="easyui-combobox" codetype="ROLES_NAME"/>
		</form>
	</div>
	
	<div region="center" title="列表" iconCls="icon-edit">
		 
		<div class="datagrid-toolbar" >
			<a class="easyui-linkbutton" iconCls="icon-add"  onclick="newRoleRights()">新建</a>
			<a class="easyui-linkbutton" iconCls="icon-edit"   onclick="editRoleRights()">编辑</a>
			<a class="easyui-linkbutton" iconCls="icon-remove"  onclick="deleteRoleRights()">删除</a>
		</div>
		<table id="gridRoles" class="easyui-datagrid" singleSelect="true"  fit="true">
			<thead>
				<tr>
					<th field="roleName" title="角色" />
					<th field="status" title="状态" formatter="statusFormatter" />
				</tr>
			</thead>
		</table>
	</div>
	<div region="east" title="角色拥有的功能权限" style="width:200px">
		<div id="viewqueryTerm" region="north"
			style="background-color: #efefef; height: 29px;">
			<a href="javascript:expandAll()" class="easyui-linkbutton"
				plain="true" iconCls="accordion-collapse">展开</a> <a
				href="javascript:collapseAll()" class="easyui-linkbutton"
				plain="true" iconCls="accordion-expand">折叠</a> <a href="javascript:saveRoleMenu()"
				class="easyui-linkbutton" plain="true" iconCls="icon-save">保存</a>
		</div>
		<div region="center">
			<ul id="treeMenus" class="easyui-tree" checkbox="true" cascadeCheck="false" autoCheckParent="true"
				idField="menuUuid" parentField="pmenuUuid" textField="menuName">
			</ul>
		</div>
	</div>
	 
	 <!-- 新建/编辑 角色权限-->
	<div id="roleRightsEditDiv" class="easyui-dialog" title="角色维护" iconCls=""
			style="width:400px;height:150px" closed="true" modal="true">
			<form id="roleRightsInputForm" class="easyui-form custom-form" columns="1">
				 <input type="hidden" name="roleId"/>
				 <input name="roleName" title="角色" required class="easyui-validatebox" validType="maxLength[10]" />
				 <input name="status" title="状态" class="easyui-combobox" codetype="USER_STATUS" required/>
				 
			</form>
			
		
		<div class="dialog-buttons" style="text-align:center">
			<a class="easyui-linkbutton" iconCls="icon-save" onclick="saveRoleRights()">保存</a>
			<a class="easyui-linkbutton" iconCls="myCustomerIcon_cancel" onclick="chooseRoleRightsCancel()">取消</a>
		</div>
	</div>
	


	 
</body>
</html>