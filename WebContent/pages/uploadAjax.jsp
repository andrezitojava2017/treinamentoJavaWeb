<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Upload com Ajax</title>
</head>
<body>
	<h3>UPLOAD</h3>

	<div>
		<form enctype="application/x-www-form-urlencoded", method="POST">
			<input type="file" id="file" name="file" onchange="uploadFile();" />
			<img src="" name="image" id="image" alt="IMG" width="200"
				height="200" />
		</form>
	</div>


</body>

<script type="text/javascript">
	function uploadFile() {
		var image = document.querySelector("img");
		var file = document.querySelector("input[type=file]").files[0];

		var lerArquivo = new FileReader();

		lerArquivo.onloadend = function() {
			image.src = lerArquivo.result;

			$.ajax({
				method : "POST",
				url : "fileUpload",
				data : {
					valorParam : lerArquivo.result
				}
			}).done(function(response) {
				alert(response);
			}).fail(function(xhr, status, errorThrown) {
				alert("Error: " + xhr.responseText);
			});
		};

		if (file) {
			lerArquivo.readAsDataURL(file);

		} else {
			image.src = "";
		}

	}
</script>
</html>
