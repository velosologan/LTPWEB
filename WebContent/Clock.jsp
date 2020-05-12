<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Hora atual</title>
	</head>
	<body>
		<%if(request.getParameter("valor").equals("ano")){%>
		
			<%= 1900 + new Date().getYear() %>
		
		<%}else{%>
		
			<%= new Date() %>
		
		<%}%>
	</body>
</html>