<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<table width="100%" height="100%" border="0">
		<tr>
			<td>&nbsp;</td>
			<td align="center" height="48">
				<table width="250" border="0" cellpadding="0" cellspacing="0">
					<form action="j_spring_security_check" method="post" id="loginForm">
						<tr>
							<td height="40" width="150">用户名：</td>
							<td><input type="text" name="j_username" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td><input type="password" name="j_password"></td>
						</tr>
						<tr>
							<td align="right" height="25" colspan="2"><input type="submit" value="提交"> <input type="reset" value="重置"></td>
						</tr>
					</form>
				</table>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</body>
</html>
