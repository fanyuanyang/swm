<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href=" <%=basePath%>">
<title>demo</title>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
</head>
<body>
<% Object user=request.getSession().getAttribute("user"); //获取你的对象里面涵盖的内容%>
<%=user %>
</body>
</html>
