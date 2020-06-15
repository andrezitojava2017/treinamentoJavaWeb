<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h3>Pagina Pai Load Query</h3>
<div>
	<input type="button" value="Carregar pagina" onclick="carregar()"/>
</div>
<div id="subpagina">
</div>
</body>

<script>
	function carregar(){
		$("#subpagina").load("paginaFilha.jsp");
	}
</script>

</html>