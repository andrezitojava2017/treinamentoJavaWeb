
<%@page import="usuario.UsuarioModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autenticado</title>
</head>
<body>
<h3>Acesso liberado ao software apos autenticação</h3>
<%
HttpSession sessao = request.getSession();
UsuarioModel user = (UsuarioModel)sessao.getAttribute("usuario");
out.write(user.getNome());
%>


<p><a href="uploadFile.jsp">Upload File</a></p>
</body>
</html>