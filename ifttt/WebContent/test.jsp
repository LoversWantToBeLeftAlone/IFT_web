
<%
	String ID = request.getParameter("id");
	String PASSWORD = request.getParameter("password");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- <%@page import="com.shi.servlet.*"%>--%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TEST</title>
</head>
<body>
	Welcome!
	<br>
	<br>
	<%=ID%>
	<br>
	<%=PASSWORD%>
	<br>
	<br>
	<%--
		test.addInformation();
	--%>
	<br>
	<%--
		test.output();
	--%>
</body>
</html>