<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>UTILIZAÇÃO DE AJAX</h3>

<input type="text" name="valor" id="teste"/>
<input type="button" name="btn" id="btn" value="Enviar" onclick="ajax()"/>

<p><a href="pages/capturarExcessao.jsp">Capturar Excessoes</a>
<p><a href="pages/acessoSistema.jsp">Logar sistema</a></p>
<p><a href="pages/uploadAjax.jsp">Upload File</a></p>
<p><a href="pages/Autenticar?deslogar=true">Deslogar</a></p>
<p><a href="pages/paginaPai.jsp">Load pagina</a></p>
<p><a href="pages/datatable.jsp">DataTable</a></p>



<div id="text">

</div>
</body>

<script>

	function ajax(){
		var tst = document.getElementById("teste").value;
		var ajax = new XMLHttpRequest();
		var url = "Excessao?valor=" + tst;

		ajax.open("GET",url, true);
		//ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		ajax.onreadystatechange = function(){
			if(this.readyState == 4 && this.status == 200){
				console.log(ajax.responseText); // imprime o texto recuperado pelo response
				console.log(ajax.getResponseHeader("exemplo"));
				
			}
			
			if(this.readyState == 4 && this.status != 200){
				alertprimira(ajax.responseText);
			}
		};
		//ajax.send("valor=" + tst);
		ajax.send();
	}

</script>
</html>