<%@page import="br.upis.sistema.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<% List<Usuario> list = (List<Usuario>)request.getAttribute("listUsuarios"); %>
		
		<table>
			<tr>
				<td>Sequencial</td>
				<td>Dados</td>
			</tr>
			<% for(int i = 0; i < list.size(); i++){ %>
				<tr>
					<td><%= i + 1 %></td>
					<td><%= list.get(i) %></td>
				</tr>
			<% } %>
		</table>		
	</body>
</html>