<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html>
<head>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<title>员工报销及借款系统</title>
<%@include file="/common/include.jsp" %>
	<link href="${pageContext.request.contextPath}/css/index.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript">
		//禁用返回按钮
		document.onkeydown = function(event) {
			if (! event) {
				event = window.event;
			}
			if (event.keyCode == 8) {
// 				return false;
			}
			if (event.altKey && (event.keyCode == 37 || event.keyCode == 39)) {
				return false;
			}
		};
		
		$(function(){
// 			$(".layout-button-left").trigger("click");//默认缩起左边菜单栏
			$(".panel-header").css({height:"18px"});//更改左边菜单栏高度
			tabMenuEvens();
			$(".custom-tree >li >div >.tree-title").on("click",function(){
				$(this).parent().children(".tree-hit").click();
			});
			initialUserMenus();
			listenEnter("#sensitivePasswordEditInputForm :input[name='confirmPassword']",saveNewPassword);	
			listenEnter("#sensitivePasswordResetInputForm :input[name='confirmPassword']",sresetSensitivePassword);	
			
		});
		function tabMenuEvens(){
			$("#centerTabs").delegate(".tabs-inner", "dblclick", function(){
				var subtitle = $(this).children(".tabs-closable").text();
				$("#centerTabs").tabs("close",subtitle);
			}).delegate(".tabs-inner", "contextmenu", function(e){
				$("#mm").menu("show", {
					left: e.pageX,
					top: e.pageY
				});
				var subtitle =$(this).children(".tabs-title").text();
				$("#mm").data("currtab",subtitle);
				$("#centerTabs").tabs("select",subtitle);
				return false;
			});
			//刷新
			$("#mm-tabupdate").click(function(){
				var currTab = $("#centerTabs").tabs("getSelected");
				var url = $(currTab.panel("options").content).attr("src");
				$("#centerTabs").tabs("update",{
					tab:currTab,
					options:{
						content:"<iframe scrolling='auto' frameborder='0'  src='"+url+"' style='width:100%;height:100%;'></iframe>"
					}
				});
			});
			//关闭当前
			$("#mm-tabclose").click(function(){
				var currtab_title = $("#mm").data("currtab");
				if(currtab_title!="报销单新增及查询"){
					$("#centerTabs").tabs("close",currtab_title);
				}
			});
			//全部关闭
			$("#mm-tabcloseall").click(function(){
				$(".tabs-inner .tabs-closable").each(function(i,n){
					var t = $(n).text();
					$("#centerTabs").tabs("close",t);
				});
			});
			//关闭除当前之外的TAB
			$("#mm-tabcloseother").click(function(){
				$("#mm-tabcloseright").click();
				$("#mm-tabcloseleft").click();
			});
			//关闭当前左侧的TAB
			$("#mm-tabcloseleft").click(function(){
				var prevall = $(".tabs-selected").prevAll();
				if(prevall.length==0){
					return false;
				}
				prevall.each(function(i,n){
					var t=$("a:eq(0) .tabs-closable",$(n)).text();
					$("#centerTabs").tabs("close",t);
				});
				return false;
			});
			//关闭当前右侧的TAB
			$("#mm-tabcloseright").click(function(){
				var nextall = $(".tabs-selected").nextAll();
				if(nextall.length==0){
					return false;
				}
				nextall.each(function(i,n){
					var t=$("a:eq(0) .tabs-closable",$(n)).text();
					$("#centerTabs").tabs("close",t);
				});
				return false;
			});
			//取消
			$("#mm-cancel").click(function(){
				$("#mm").menu("hide");
			});
		}
		//子页面添加tabs方法
		function addTabs(title,url,newTab,closable){
			app.util.addTabs(title,url,newTab,closable);
		}
		
		function closeTab(title) {
			$("#centerTabs").tabs("close",title);
		}
		
		function closeCurrentTab() {
			var currtab_title = $("#centerTabs").tabs("getSelected").panel("options").title;
			if(currtab_title!="报销单新增及查询"){
				$("#centerTabs").tabs("close",currtab_title);
			}
		}
		
		function getTabIframe(title) {
			return $("#centerTabs").tabs("getTab",title).find("iframe")[0];
		}
		
		//改变选中状态
		function changeSelected(o){
			$("[class='clicked']").removeClass("clicked");
			$(o).removeClass("mouseOverColor");
			$(o).addClass("clicked");
		}
			
		//鼠标放在菜单上时的颜色
		function mouseOverColor(o){
			if($(o).attr("class")!="clicked"){
				$(o).addClass("mouseOverColor");
			}
		}
		
		//鼠标走开时就把背景颜色去掉
		function clearColor(o){
			if($(o).attr("class")!="clicked"){
				$(o).removeClass("mouseOverColor");
			}
		}
	
		//以下这段script包含了修改密码功能所必须的js代码
		$(function(){
			//css定义
			$('#changePSWForm').attr({
				width:"100%",
				heigh:"100%"
			});
			$("#changePSWTable td:even").attr({
				align:"right"
			});
			$("#changePSWTable td:even").css({
				width:"30%"
			});
			$("#changePSWTable td:odd").attr({
				align:"left"
			});
			$("#changePSWTable td:odd").css({
				width:"60%"
			});
			$("#btnTable td:even").css({
				width:"39%"
			});
			$("#btnTable td:odd").css({
				width:"60%"
			});
			$("#leftAccordion").accordion({
				active:1
			});
			app.util.addTabs("报销单新增及查询",$url("/jsp/reimbursement/reimburseApplication.jsp"),"",false);
			var loginPreTargetUrl = $.cookie("loginPreTargetUrl");
			if(loginPreTargetUrl && loginPreTargetUrl.indexOf("/jsp") > -1) {
				var mainUrl = loginPreTargetUrl.substr(loginPreTargetUrl.indexOf("/jsp"),loginPreTargetUrl.indexOf(".jsp")+4);
				$.post($url("/rest/basMenuManagerRest/getByUrl.json"),{"menuItemUrl" : mainUrl},function(menuItem) {
					var title;
					if(menuItem && menuItem.menuItemName) {
						title = menuItem.menuItemName;
					} else {
						if(loginPreTargetUrl.indexOf("type=deptApprove") > -1) {
							title = "借款单-审批";
						} else if(loginPreTargetUrl.indexOf("type=cashierAudit") > -1) {
							title = "借款单-出纳审核";
						} else if(loginPreTargetUrl.indexOf("type=treasurerAudit") > -1) {
							title = "借款单-主管审核";
						} else {
							title = "未知标题"
						}
					}
					app.util.addTabs(title,$url(loginPreTargetUrl),"",true);
					$.cookie("loginPreTargetUrl",{expires : -1});
				})
				
			}
		});
		//收起左边菜单的方法
		function autoCollapse(){
			$(".layout-button-left").trigger("click");
		}
		
		//重置二次密码
		function resetPassword(){
			$.post($url('/rest/basUsersRest/checkHasSensitivePassword.json'), null,
					function(data) {
							if(data=="") {
								$("#sensitivePasswordEditDiv").dialog("open");
							} else {
								$("#sensitivePasswordResetDiv").dialog("open");
							}
			      },"json");
			
		}
		function saveNewPassword(){
			if($("#sensitivePasswordEditInputForm").form("validate")) {
				var password=$("#sensitivePasswordEditInputForm :input[name=password]").val();
				var confirmPassword= $("#sensitivePasswordEditInputForm :input[name=confirmPassword]").val();
				if(password!=confirmPassword){
					$.messager.alert("警告","两次输入密码不一致","warning");
				}else{
					$.post($url('/rest/basUsersRest/saveSensitivePassword.json'), {"password":password},
							function(data) {
									if(!data.error) {
										$.messager.alert("提示","二次密码设置成功，您可通过页面右上角“维护二次密码”修改二次密码");
										$("#sensitivePasswordEditDiv").dialog("close");
									}
					      },"json");
				}
			}
		}
		function sresetSensitivePassword(){
			if($("#sensitivePasswordResetInputForm").form("validate")) {
				var oldPassword=$("#sensitivePasswordResetInputForm :input[name=oldPassword]").val();
				var newPassword=$("#sensitivePasswordResetInputForm :input[name=newPassword]").val();
				var confirmPassword= $("#sensitivePasswordResetInputForm :input[name=confirmPassword]").val();
				$.post($url('/rest/basUsersRest/checkSensitivePassword.json'), {"password":oldPassword},
						function(data) {
								if(!data) {
									$.messager.alert("警告","您输入的旧密码有误！","warning");
								}else{
									
									if(newPassword!=confirmPassword){
										$.messager.alert("警告","两次输入密码不一致","warning");
									}else{
										$.post($url('/rest/basUsersRest/saveSensitivePassword.json'), {"password":newPassword},
												function(data) {
														if(!data.error) {
															$.messager.alert("提示","二次密码修改成功，您可通过页面右上角“维护二次密码”修改二次密码");
															$("#sensitivePasswordEditDiv").dialog("close");
															$("#sensitivePasswordResetDiv").dialog("close");
														}
										      },"json");
									}
									
								}
				      },"json");
				
				
			}
		}
		
		//初始化用户导航菜单
		function initialUserMenus(){
		  var container = $('#leftAccordion');
		  function getPanel(id) {
			var panels = container.accordion('panels');
			for (var i = 0; i < panels.length; i++) {
				var panel = panels[i];
				if (panel.panel('options').id == id) {
					return panel;
				}
			}
			return null;
		  };
		  function doInitialMenu(menus){
		    $.each(menus,function(i,item){
		      container.accordion('add',{
		        id:item.id,
		        title:item.text,
		        iconCls:item.iconCls,
		        collapsed:false
		      });
		      var panel = getPanel(item.id);
		      $('<ul class="easyui-tree tree"/>').tree({
	              data:item.children,
	              onSelect:function(node){
	            	  container.find(".tree-node-selected").removeClass("tree-node-selected");
	            	  $("[node-id="+node.id+"]").addClass("tree-node-selected");
	                node = node.attributes.data.data;
	                if(node.menuUrl){
	                  addTabs(node.menuName,node.menuUrl,false,true);
	                }
	              }
		      }).appendTo(panel);
		    });
			var windowHeight=$(window).height();
			var height=$("#leftAccordion").height();
			if(height>windowHeight){
				var accordionHeight=windowHeight-75;
				$("#leftAccordion").css({height:accordionHeight+"px"});//更改左边菜单栏高度
				$("#leftAccordion").css({"overflow-y":"scroll"});
				$("#leftAccordion .panel-tool").css({right:"15px"});
				
			}else{
				$("#leftAccordion").css({height:height+"px"});//更改左边菜单栏高度
				
			}
		  }
		  $.post($url('/rest/basMenuManagerRest/getUserMenus.json'),doInitialMenu,'JSON');
		}
	</script>
</head>
<body class="easyui-layout">
	<div region="north" border="false" class="head">
		<div class="name" style="font-size: 23px; padding-left: 20px;padding-top: 7px;">员工报销及借款系统</div>
			<div class="info">
				<span class="name">${requestScope.userInfo.userName}</span> |&nbsp;
				<span><a href="javascript:resetPassword();" class="resetPassword">维护二次密码 </a>&nbsp;|&nbsp;</span>
				<a href="${pageContext.request.contextPath}/security_logout_" class="logout">退出 </a>
			</div>
		<a href="#" class="return">返回首页</a>
    </div>
	<div id="west" region="west" title="菜单栏" style="width:240px;" split="true" >
		<div id="leftAccordion" class="easyui-accordion" fit="true" animate="false" border=false multiple="true"></div>
	</div>
	<div region="center" style="overflow: hidden;">
		<div class="easyui-tabs" id="centerTabs" fit="true" border="false">
		</div>
	</div>
	
	<div id="mm" class="easyui-menu" style="width:150px;display:none;">
		<div id="mm-tabupdate">刷新</div>
<!-- 		<div class="menu-sep"></div> -->
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
<!-- 		<div class="menu-sep"></div> -->
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
<!-- 		<div class="menu-sep"></div> -->
		<div id="mm-cancel">取消</div>
	</div>	
	
	
	<!-- 首次 设置 敏感信息二次密码-->
	<div id="sensitivePasswordEditDiv" class="easyui-dialog" title="敏感信息二次密码-创建" iconCls=""
			style="width:400px;height:150px" closed="true" modal="true">
			<form id="sensitivePasswordEditInputForm" class="easyui-form custom-form" columns="1"">
				 <input name="password" title="敏感信息二次密码" class="easyui-validatebox" required type="password" validType="safepass" >
				 <input name="confirmPassword" title="密码确认" class="easyui-validatebox" required type="password" validType="safepass" >
			</form>
			
		
		<div class="dialog-buttons" style="text-align:center">
			<a class="easyui-linkbutton" iconCls="icon-save" onclick="saveNewPassword()">保存</a>
			<a class="easyui-linkbutton" iconCls="myCustomerIcon_cancel" onclick='javascript:$("#sensitivePasswordEditDiv").dialog("close");'">取消</a>
		</div>
	</div>
	
		 <!-- 修改 敏感信息二次密码-->
	<div id="sensitivePasswordResetDiv" class="easyui-dialog" title="敏感信息二次密码-修改" iconCls=""
			style="width:400px;height:150px" closed="true" modal="true">
			<form id="sensitivePasswordResetInputForm" class="easyui-form custom-form" columns="1"">
				 <input name="oldPassword" title="旧密码" type="password" class="easyui-validatebox" required validType="safepass" >
				 <input name="newPassword" title="新密码" class="easyui-validatebox" required type="password" validType="safepass" >
				 <input name="confirmPassword" title="密码确认" class="easyui-validatebox" required type="password" validType="safepass" >
			</form>
			
		
		<div class="dialog-buttons" style="text-align:center">
			<a class="easyui-linkbutton" iconCls="icon-save" onclick="sresetSensitivePassword()">保存</a>
			<a class="easyui-linkbutton" iconCls="myCustomerIcon_cancel" onclick='javascript:$("#sensitivePasswordResetDiv").dialog("close");'>取消</a>
		</div>
	</div>	
</body>
</html>