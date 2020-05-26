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
		
		<table border="1">
			<tr>
				<td>Sequencial</td>
				<td>Nome</td>
				<td>E-mail</td>
				<td>Senha</td>
				<td>Data Nascimento</td>
				<td>Edição</td>
			</tr>
			<% for(int i = 0; i < list.size(); i++){ %>
				<%Usuario user = list.get(i); %>
				<tr>
					<td><%= i + 1 %></td>
					<td><%= user.getNome() %></td>
					<td><%= user.getEmail() %></td>
					<td><%= user.getSenha() %></td>
					<td><%= user.getDataNascimento() %></td>
					<td><a href=<%= "crud?posicao=" + (i)%>>editar</a></td>
				</tr>
			<% } %>
		</table>		
	</body>
</html>