<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Excessão</title>
</head>
<body>

<h3>CAPTURAR EXCESSOES</h3>

<div>
	<table>
		<tr>
			<td>
				<input type="text" id="texto"/>
			</td>
			<td>
				<input type="button" value="Enviar" onclick="executa()"/>
			</td>
		</tr>
		
		<tr>
			<td></td>
		</tr>
	</table>
</div>

<script>
	
	function executa(){
		var informado = $('#texto').val();
		$.ajax({
			method:"POST",
			url:"Excessao",
			data:{valorParam : informado}
		})
		.done(function(response){
			alert(response);
		})
		.fail(function(xhr, status, errorThrown){
			alert("Error: " + xhr.responseText);
			<!-- xhr.responseText - msg definida na servlet do servidor -->
			<!-- status - status de ERROR -->
			<!-- errorThrow - exibe msg padrão error do js -->
		});
	}
	
</script>

</body>
</html>