<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="widgets/ext-4.2.1/resources/css/ext-all-neptune-debug.css">
<script type="text/javascript" src="widgets/ext-4.2.1/ext-all-debug.js"></script>
<script type="text/javascript" src="app/app.js"></script>
</head>
<body>
</body>
</html>
