<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@include file="/context/mytags.jsp"%> --%>
<%@page import="com.harvey.vchat.bas.utils.SrasUtils"%>
<%
String path = request.getContextPath();
String errorInfo = request.getParameter("type");
String returnUrl = request.getParameter("returnUrl");
if(returnUrl == null) {
	returnUrl = "";
}
String msg = "";
if("UsernameNotFoundException".equals(errorInfo)){
	msg = "用户名密码错误!";
}else if("BadCredentialsException".equals(errorInfo)){
	msg = "用户名密码错误!";
}else if("ValidationCodeErrorException".equals(errorInfo)){
	msg = "用户名密码错误!";
}
%>
<!DOCTYPE html>
<html>
<head>
<title>${applicationScope.config['applicationName']}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/lib/jquery-easyui-1.2.4/themes-1.3.2/default/easyui.css" />
	
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.1/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/utils/msgBox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/lib/jquery-easyui-1.2.4/jquery.easyui-1.2.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-plugins/jquery.cookie.js"></script>

<script language="javascript" type="text/javascript">
	if(window.location.href != top.location.href){
	  	document.cookie="JSESSIONID=";
		top.location.href=window.location.pathname;
	}
	if(window.location.href!=window.location.pathname){
	}
	var returnUrl = decodeURIComponent("<%=returnUrl%>");
	if(returnUrl && returnUrl.indexOf("/jsp") > -1) {
		var loginPreTargetUrl = $.cookie("loginPreTargetUrl");
		if(!loginPreTargetUrl || loginPreTargetUrl.indexOf("/jsp") == -1) {
			$.cookie("loginPreTargetUrl",returnUrl.substr(returnUrl.indexOf("/jsp")))
		}
	}
	
  $(function() {
    $("#j_username").focus();
    $("#j_username").unbind("keydown").keydown(function(e) {
      if (e.keyCode == 13) {
        $("#j_password").unbind("foucs").focus();
      }
    });
    $("#j_password").unbind("keydown").keydown(function(e) {
      if (e.keyCode == 13) {
    	  
	      var j_username = $("#j_username").val();
	      if (j_username == null || j_username.length < 1) {
	        $.messager.alert("警告","用户名密码错误!","warning");
	        return;
	      }
	      var j_password = $("#j_password").val();
	      if (j_password == null || j_password.length < 1) {
	        $.messager.alert("警告","用户名密码错误!","warning");
	        return;
	      }
    	  
    	  $("#form")[0].submit();
      }
    });
    $("#button").unbind("click").click(function() {
      var j_username = $("#j_username").val();
      if (j_username == null || j_username.length < 1) {
        $.messager.alert("警告","用户名密码错误!","warning");
        return;
      }
      var j_password = $("#j_password").val();
      if (j_password == null || j_password.length < 1) {
        $.messager.alert("警告","用户名密码错误!","warning");
        return;
      }
      $("#form")[0].submit();
    });
  });
</script>
</head>
<body>
		<div id="container"  class="wrapper">
			<div class="wrapperin">
				<div class="userlogo"><div class="img">
 				<table>
 					<tr>
	 					<td rowSpan="2"><img src="${pageContext.request.contextPath }/images/login/Logo_yict.png" alt="" height="50.25px" width="86.75px" /></td>
 						<td><span class="cname">员工报销及借款系统</span></td> 
 					</tr>
 					<tr>
 						<td><span class="ename">Staff Reimbuement and Advance System (SRAS)</span> </td> 
 					</tr>
 				</table>
				
				</div></div>
				<div id="content">
					<div class="box">
						<span class="bg"></span>
						<div class="content" >
							<img src="${pageContext.request.contextPath }/images/login/loginimg_smas.jpg" alt="" class="loginimg" />
							<div class="loginright">
								<div class="warningcon" style="display: none;">
									<span class="warning">请输入用户名和密码</span>
								</div>
								<form action="${pageContext.request.contextPath }/security_check_"  method="post"
									id="form" name="form">
									<table  class="userform">
										<tr>
											<td colSpan="2" style="text-align: left;">
												用户名：
											
												<input type="text" name="username" id="j_username" placeholder="输入用户名"   class="input" nullmsg="请输入用户名!"/>
											</td>
										</tr>
										<tr>
											<td colSpan="2"  style="text-align: left;">
												密　码：
												
												<input type="password" name="password" id="j_password" placeholder="输入密码"  class="input" nullmsg="请输入密码!"/>
											</td>
										</tr>
										<tr>
											<td  style="text-align: left;width:45%">
														&nbsp;
											</td>
											<td  style="text-align: left;width:55%">
												&nbsp;
											</td>
											
										</tr>
										<tr>
											<td colSpan="2"  style="text-align: left;">
<!-- 												<a class="button" id="but_login" ><span id="sub">登 录</span> </a> -->
												<input type="button" name="button" id="button" value="登 录"	class="iput_bnt button" />
											</td>
										</tr>
										<tr>
											<td colSpan="2" style="text-align: right;">
												<div><span class="version">版本:1.0</span></div>						
											</td>
										</tr>
									</table>
								</form>
							</div>
						</div>
					</div>
					<div class="copyright"><span>©版权所有 盐田国际集装箱码头有限公司 中国深圳市盐田港 邮编：518083 电话：(86-755) 25290888 传真：(86-755) 25291188</span></div>

				</div>
			</div>
		</div>
</body>
<%
	if(!SrasUtils.isEmpty(msg)){
		out.println("<script language=\"javascript\" type=\"text/javascript\">");
		out.println("$.messager.alert(\"警告\",\"用户名密码错误!\",\"warning\");");
		out.println("</script>");
	}
%>
</html>